package com.example.mybaidugettoken;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import com.baidu.oauth.BaiduOAuth;
import com.baidu.oauth.BaiduOAuth.BaiduOAuthResponse;
import com.baidu.oauth.BaiduOAuth.OAuthListener;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
public class MainActivity extends Activity {
	private final String mbApiKey = "aAxtpjrZvPZ90I18GBndkI61";//���滻����ͻ���Ӧ��ʱ��ȡ��Api Key��
	private Button getAccessToken;//�����Ӧ��ť
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	 public void onClick(View v) {
	        BaiduOAuth oauthClient = new BaiduOAuth();
	        oauthClient.startOAuth(MainActivity.this, mbApiKey, new String[]{"basic","netdisk"},new BaiduOAuth.OAuthListener() {
	                @Override
	                public void onException(String msg) {
	                    Toast.makeText(getApplicationContext(), "Login failed " + msg, Toast.LENGTH_SHORT).show();
	                }
	                @Override
	                public void onComplete(BaiduOAuthResponse response) {
	                    if(null != response){
	                    	String accessToken = response.getAccessToken();
	                    	//��logCat�����������Ϣ
	                    	Log.i("Token", "Token: " + accessToken + "    User name:" + response.getUserName());
	                    	Toast.makeText(getApplicationContext(), "Token: " + accessToken + "    User name:" + response.getUserName(), Toast.LENGTH_SHORT).show();
	                    }
	                }
	                @Override
	                public void onCancel() {
	                    Toast.makeText(getApplicationContext(), "Login cancelled", Toast.LENGTH_SHORT).show();
	                }
	            });
	        }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

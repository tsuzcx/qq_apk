package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class WXEntryActivity
  extends Activity
{
  static final String a = "com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE";
  static final String b = "com.tencent.msg.permission.pushnotify2";
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new Intent("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
    paramBundle.putExtras(getIntent());
    sendBroadcast(paramBundle, "com.tencent.msg.permission.pushnotify2");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */
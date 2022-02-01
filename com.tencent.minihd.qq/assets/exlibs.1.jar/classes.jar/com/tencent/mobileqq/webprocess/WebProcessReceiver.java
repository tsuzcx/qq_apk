package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

public class WebProcessReceiver
  extends QQBroadcastReceiver
{
  protected static final String a = "WebProcessReceiver";
  public static final String b = "com.tencent.mobileqq.webprocess.preload_web_process";
  public static final String c = "action_clear_cache";
  public static final String d = "action_reset_tbs";
  public static final String e = "com.tencent.msg.permission.pushnotify2";
  
  protected void a(Context paramContext)
  {
    try
    {
      WebView localWebView = new WebView(paramContext);
      if (localWebView.getX5WebViewExtension() == null)
      {
        WebSettings localWebSettings = localWebView.getSettings();
        if (localWebSettings != null)
        {
          String str2 = "";
          String str3 = MobileQQ.getMobileQQ().getProcessName();
          String str1 = str2;
          if (str3 != null)
          {
            int i = str3.lastIndexOf(':');
            str1 = str2;
            if (i > -1) {
              str1 = "_" + str3.substring(i);
            }
          }
          localWebSettings.setDatabasePath(paramContext.getDir("database" + str1, 0).getPath());
          localWebSettings.setAppCachePath(paramContext.getDir("appcache" + str1, 0).getPath());
          if (Build.VERSION.SDK_INT >= 21) {
            localWebSettings.setMixedContentMode(0);
          }
        }
        localWebView.clearCache(true);
        localWebView.clearFormData();
        localWebView.clearSslPreferences();
        localWebView.clearHistory();
        localWebView.clearMatches();
      }
      for (;;)
      {
        localWebView.destroy();
        return;
        QbSdk.clearAllWebViewCache(paramContext, true);
      }
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "clear webview cache got exception:", paramContext);
      }
    }
  }
  
  protected void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    paramContext = AuthorizeConfig.a();
    paramContext.a("https://www.qq.com/");
    paramContext.a("https://www.qq.com/", "foo.bar");
    paramContext.a();
    paramContext.b();
    paramContext.b("https://www.qq.com/");
    paramAppRuntime.getManager(2);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getAction();
      if (paramIntent != null) {
        break label14;
      }
    }
    label14:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "action=" + paramIntent);
      }
      if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "preload web process!");
        }
        a(paramAppRuntime, paramContext);
        return;
      }
      if ("action_clear_cache".equals(paramIntent))
      {
        a(paramContext);
        return;
      }
    } while (!"action_reset_tbs".equals(paramIntent));
    QbSdk.reset(paramContext.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */
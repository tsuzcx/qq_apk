package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneTihSettingWebPlugin
  extends WebViewPlugin
{
  public static final String a = "aciton_switch_tih_setting";
  public static final String b = "qztodayinhistory";
  public static final String c = "settihnome";
  public static final String d = QZoneTihSettingWebPlugin.class.getSimpleName();
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleJsRequest url: " + paramString1 + "pkgName:" + paramString2 + "method:" + paramString3);
    }
    if (!paramString2.equals("qztodayinhistory")) {}
    while (!paramString3.equals("settihnome")) {
      return false;
    }
    paramJsBridgeListener = new Intent("aciton_switch_tih_setting");
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "actionString: " + paramJsBridgeListener.getAction());
    }
    BaseApplication.getContext().sendBroadcast(paramJsBridgeListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin
 * JD-Core Version:    0.7.0.1
 */
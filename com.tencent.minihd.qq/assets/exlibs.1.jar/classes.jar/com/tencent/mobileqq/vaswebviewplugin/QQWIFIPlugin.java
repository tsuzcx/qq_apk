package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

public class QQWIFIPlugin
  extends VasWebviewJsPlugin
{
  private static final String KEY_FROM = "webfrom";
  private static final String KEY_SID = "sid";
  private static final String tag = "QQWIFIPlugin";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "url=" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("qqwifi"))) {
      return false;
    }
    int i;
    try
    {
      i = paramString1.indexOf("=");
      if ((i != -1) && (i + 1 <= paramString1.length() - 1)) {
        break label104;
      }
      throw new Exception("illegal json");
    }
    catch (Exception paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWIFIPlugin", 2, "handleJsRequest", paramJsBridgeListener);
      }
    }
    return true;
    label104:
    paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
    if (paramJsBridgeListener.has("callback")) {}
    for (paramJsBridgeListener = paramJsBridgeListener.getString("callback");; paramJsBridgeListener = "")
    {
      if ("start".equals(paramString3))
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.getString("webfrom");
        paramString1 = paramString1.getString("sid");
        paramString2 = new Intent("com.tencent.mobileqq.action.QQWiFi");
        paramString2.putExtra("webfrom", paramJsBridgeListener);
        paramString2.putExtra("sid", paramString1);
        paramString2.setClass(this.mRuntime.a(), JumpActivity.class);
        this.mRuntime.a().startActivity(paramString2);
        break;
      }
      if (!"getPhoneNumber".equals(paramString3)) {
        break;
      }
      paramString1 = (TelephonyManager)this.mRuntime.a().getSystemService("phone");
      paramString2 = new JSONObject();
      paramString2.put("result", 0);
      paramString2.put("phoneNumber", paramString1.getLine1Number());
      callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin
 * JD-Core Version:    0.7.0.1
 */
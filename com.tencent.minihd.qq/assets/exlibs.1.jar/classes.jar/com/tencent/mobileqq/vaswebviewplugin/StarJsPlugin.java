package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class StarJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "starclub";
  public static final String TAG = "StarJsPlugin";
  private BrowserAppInterface browserApp;
  private Bundle mReqBundle;
  
  public void createShortcut(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StarJsPlugin", 2, "startCreateShortcut " + paramJSONObject.toString());
    }
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str = paramJSONObject.getString("nickname");
      if (QQUtils.a(this.browserApp.a(), new String[] { str }))
      {
        localJSONObject.put("ret", -2);
        super.callJs(paramString + "(" + localJSONObject.toString() + ");");
        return;
      }
      if (!NetworkUtil.e(this.browserApp.getApplication().getApplicationContext()))
      {
        localJSONObject.put("ret", -3);
        super.callJs(paramString + "(" + localJSONObject.toString() + ");");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StarJsPlugin", 2, "createShortcut failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putString("iconurl", paramJSONObject.getString("iconurl"));
    this.mReqBundle.putString("nickname", str);
    this.mReqBundle.putString("starhomeurl", paramJSONObject.getString("starhomeurl"));
    this.mReqBundle.putString("sid", paramJSONObject.getString("starid"));
    paramJSONObject = DataFactory.makeIPCRequestPacket("createShortcut", paramString, this.mOnRemoteResp.key, this.mReqBundle);
    WebIPCOperator.getInstance().sendServiceIpcReq(paramJSONObject);
  }
  
  protected long getPluginBusiness()
  {
    return 2164260864L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StarJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"starclub".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("illegal json");
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StarJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString1 = paramJsBridgeListener.getString("callback");
      if (paramString1 == null) {
        throw new Exception("need callbackId");
      }
      if (!"createShortcut".equals(paramString3)) {
        break;
      }
      createShortcut(paramJsBridgeListener, paramString1);
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  protected void onCreate()
  {
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      super.onCreate();
      return;
      if (QLog.isColorLevel()) {
        QLog.e("StarJsPlugin", 2, "ERROR!!! StarClub is not running in web process!");
      }
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("StarJsPlugin", 2, "response:" + (String)localObject);
      }
      if ((localObject == null) || (!"createShortcut".equals(localObject))) {}
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", paramBundle.get("ret"));
      super.callJs(str + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramBundle)
    {
      super.callJsOnError(str, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin
 * JD-Core Version:    0.7.0.1
 */
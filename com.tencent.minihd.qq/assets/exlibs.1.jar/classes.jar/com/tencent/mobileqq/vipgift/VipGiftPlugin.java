package com.tencent.mobileqq.vipgift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VipGiftPlugin
  extends VasWebviewJsPlugin
{
  public static final String a = "VipGiftPlugin";
  
  private void a()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void a(String paramString)
  {
    int i = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      if (this.mRuntime.a() != null) {
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("options");
          int j;
          if (localObject != null)
          {
            j = ((JSONObject)localObject).optInt("style");
            i = ((JSONObject)localObject).optInt("animation");
            label75:
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            localObject = localActivity.getIntent().getExtras();
            ((Bundle)localObject).putString("leftViewText", "");
            switch (j)
            {
            }
          }
          for (;;)
          {
            Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
            localIntent.putExtras((Bundle)localObject);
            localIntent.putExtra("url", paramString);
            localIntent.setFlags(0);
            localActivity.startActivityForResult(localIntent, 100);
            switch (i)
            {
            case 0: 
            case 1: 
              localActivity.overridePendingTransition(0, 0);
              return;
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              break;
            case 2: 
              localActivity.overridePendingTransition(2130968746, 0);
              return;
              j = 0;
              break label75;
            }
          }
          return;
        }
        catch (JSONException paramString) {}
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipGiftPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 2)
    {
      paramString = this.mRuntime.a();
      if (paramString != null) {
        break label19;
      }
    }
    label19:
    while (!paramString.getClass().getSimpleName().equals("VipGiftBrowserActivity")) {
      return false;
    }
    paramString.finish();
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("gift".equals(paramString2))
    {
      if (("openUrl".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        a(paramVarArgs[0]);
        a();
      }
      while ((!"close".equals(paramString3)) || (paramVarArgs.length != 1)) {
        return true;
      }
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.getString("callback");
        long l = paramString1.getLong("version");
        paramString1 = new Bundle();
        paramString1.putLong("version", l);
        sendRemoteReq(DataFactory.makeIPCRequestPacket("close_version", paramJsBridgeListener, this.mOnRemoteResp.key, paramString1), false, false);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        return true;
      }
    }
    return false;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    try
    {
      if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
      {
        JSONObject localJSONObject = new JSONObject();
        String str1 = paramBundle.getString("cmd");
        String str2 = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        if ((str1 != null) && ("close_version".equals(str1)))
        {
          localJSONObject.put("result", paramBundle.getInt("result"));
          a(str2, localJSONObject.toString());
          a();
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftPlugin
 * JD-Core Version:    0.7.0.1
 */
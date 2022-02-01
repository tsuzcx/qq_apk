package com.tencent.mobileqq.mybusiness;

import com.tencent.mobileqq.activity.phone.BindNumberDialogActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class MyBusinessWebViewPlugin
  extends WebViewPlugin
{
  public static final String a = "mybusiness";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if ("mybusiness".equals(paramString2))
    {
      if ("setRightBtnChangeNumber".equals(paramString3))
      {
        System.out.println("MyBusinessWebViewPlugin setChangeNumnber");
        paramJsBridgeListener = (MyBusinessActivity)this.mRuntime.a();
        bool1 = bool2;
        if (paramVarArgs != null)
        {
          bool1 = bool2;
          if (paramVarArgs.length <= 0) {}
        }
        try
        {
          bool1 = new JSONObject(paramVarArgs[0]).optBoolean("visible", false);
          paramJsBridgeListener.b(bool1);
          return true;
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            bool1 = bool2;
          }
        }
      }
      if ("bindNumber".equals(paramString3))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        bool1 = bool3;
        if (paramVarArgs != null)
        {
          paramJsBridgeListener = paramString1;
          bool1 = bool3;
          if (paramVarArgs.length > 0) {
            paramJsBridgeListener = paramString1;
          }
        }
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          paramString1 = paramString2.optString("mobileNumber", "");
          paramJsBridgeListener = paramString1;
          bool2 = paramString2.optBoolean("unbind", false);
          paramJsBridgeListener = paramString1;
          bool1 = bool2;
          if (bool2)
          {
            paramJsBridgeListener = "";
            bool1 = bool2;
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            bool1 = bool3;
          }
        }
        BindNumberDialogActivity.a(this.mRuntime.a(), paramJsBridgeListener, bool1, 2);
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */
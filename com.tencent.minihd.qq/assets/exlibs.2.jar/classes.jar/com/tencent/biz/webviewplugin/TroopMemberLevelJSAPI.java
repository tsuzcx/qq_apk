package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public class TroopMemberLevelJSAPI
  extends WebViewPlugin
{
  String a = "troop_member_level_JS_API";
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!this.a.equals(paramString2)) {
      return false;
    }
    if (("setTitleBar".equals(paramString3)) && (paramVarArgs.length == 3))
    {
      ((QQBrowserActivity)this.mRuntime.a()).a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI
 * JD-Core Version:    0.7.0.1
 */
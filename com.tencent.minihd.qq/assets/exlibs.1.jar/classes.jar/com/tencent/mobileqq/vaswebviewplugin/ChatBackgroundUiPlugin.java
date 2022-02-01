package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ChatBackgroundUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatBackgroundUiPlugin";
  private Bundle mReqBundle;
  private String uin;
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mReqBundle = new Bundle();
    this.uin = this.mRuntime.a().getAccount();
    this.activity.M = super.decodeUrl(this.activity.M);
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundUiPlugin", 2, this.activity.M);
    }
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 33554432L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ChatFontUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatFontUiPlugin";
  private boolean mIsDpcWriteUser;
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.M = super.decodeUrl(this.activity.M);
    int i = this.activity.getIntent().getIntExtra("fontId", -1);
    if ((i != -1) && (this.activity.getIntent().getBooleanExtra("fromAIO", false)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      QQBrowserActivity localQQBrowserActivity = this.activity;
      localQQBrowserActivity.M = (localQQBrowserActivity.M + "&adtag=mvip.gexinghua.mobile.font.client_tab_store&id=" + i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontUiPlugin", 2, this.activity.M);
    }
    this.mIsDpcWriteUser = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
  }
  
  protected long getPluginBusiness()
  {
    return 4096L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin
 * JD-Core Version:    0.7.0.1
 */
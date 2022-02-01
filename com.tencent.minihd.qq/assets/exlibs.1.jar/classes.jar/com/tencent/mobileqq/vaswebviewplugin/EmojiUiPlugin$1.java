package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

class EmojiUiPlugin$1
  extends Client.onRemoteRespObserver
{
  EmojiUiPlugin$1(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onBindedToClient()
  {
    if (this.this$0.isHomePageWatingBind)
    {
      this.this$0.loadHomePage(this.this$0.homePageUrlInfo, this.this$0.mSid);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "oncreate -> onBindedToClient:loadurl");
      }
      this.this$0.isHomePageWatingBind = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "onBindedToClient");
    }
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    int i = -1;
    int j;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.key))
    {
      String str = paramBundle.getString("cmd");
      Bundle localBundle = paramBundle.getBundle("response");
      int k = paramBundle.getInt("failcode");
      if ((str != null) && ("writeQFaceResult".equals(str)))
      {
        j = localBundle.getInt("result", -1);
        paramBundle = localBundle.getString("messge");
        if (k == 1000) {
          break label128;
        }
        paramBundle = "QFaceResult error";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i + " msg:" + paramBundle);
      }
      return;
      label128:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;

class a
  implements Runnable
{
  a(MobileQQCloseServiceReceiver paramMobileQQCloseServiceReceiver, Context paramContext) {}
  
  public void run()
  {
    try
    {
      boolean bool = TMAssistantDownloadManager.getInstance(this.a).getDownloadSDKSettingClient().isAllDownloadFinished();
      k.c("MobileQQCloseServiceReceiver", "receive broadcast isAllDownloadFinished = " + bool);
      if (bool) {
        TMAssistantDownloadManager.closeAllService(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.a
 * JD-Core Version:    0.7.0.1
 */
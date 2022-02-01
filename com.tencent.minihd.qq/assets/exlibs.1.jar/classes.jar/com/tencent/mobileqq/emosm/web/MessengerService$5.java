package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;

class MessengerService$5
  extends DownloadListener
{
  MessengerService$5(MessengerService paramMessengerService, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Bundle localBundle = paramDownloadTask.a();
    localBundle.putString("status", "onDone");
    localBundle.putLong("readSize", paramDownloadTask.b);
    localBundle.putInt("result", paramDownloadTask.a());
    localBundle.putLong("downloadTime", paramDownloadTask.h - paramDownloadTask.g);
    this.this$0.mVipIPCDownloadListener.onResponse(localBundle);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    Bundle localBundle = paramDownloadTask.a();
    localBundle.putString("status", "onProgress");
    localBundle.putLong("readSize", paramDownloadTask.b);
    this.this$0.mVipIPCDownloadListener.onResponse(localBundle);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.5
 * JD-Core Version:    0.7.0.1
 */
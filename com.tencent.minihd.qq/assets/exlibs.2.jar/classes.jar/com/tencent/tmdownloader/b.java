package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.a.k;

class b
  implements Runnable
{
  b(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(10000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      k.b("TMAssistantDownloadSDKService", "exception:", localInterruptedException);
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.b
 * JD-Core Version:    0.7.0.1
 */
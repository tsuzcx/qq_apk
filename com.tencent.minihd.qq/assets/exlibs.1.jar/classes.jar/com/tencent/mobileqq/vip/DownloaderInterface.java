package com.tencent.mobileqq.vip;

import android.os.Bundle;

public abstract interface DownloaderInterface
{
  public abstract int a(boolean paramBoolean, String paramString);
  
  public abstract DownloadTask a(String paramString);
  
  public abstract void a();
  
  public abstract void a(DownloadTask paramDownloadTask, DownloadListener paramDownloadListener, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderInterface
 * JD-Core Version:    0.7.0.1
 */
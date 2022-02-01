package com.tencent.component.network.downloader;

public abstract interface Downloader$DownloadListener
{
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, long paramLong, float paramFloat);
  
  public abstract void a(String paramString, DownloadResult paramDownloadResult);
  
  public abstract void b(String paramString, DownloadResult paramDownloadResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
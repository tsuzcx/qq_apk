package com.tencent.component.network.downloader.strategy;

public enum DownloadPreprocessStrategy$DownloadPool
{
  final String a;
  
  private DownloadPreprocessStrategy$DownloadPool(String paramString)
  {
    this.a = paramString;
  }
  
  public static int size()
  {
    return 2;
  }
  
  public String getName()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool
 * JD-Core Version:    0.7.0.1
 */
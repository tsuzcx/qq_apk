package com.tencent.mars.cdn;

public abstract interface CdnLogic$VideoStreamingCallback
{
  public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onDownloadToEnd(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onM3U8Ready(String paramString1, String paramString2);
  
  public abstract void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public abstract void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
 * JD-Core Version:    0.7.0.1
 */
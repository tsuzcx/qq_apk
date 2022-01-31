package com.tencent.mars.cdn;

public abstract interface CdnLogic$ICallback
{
  public abstract void ReportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void RequestGetCDN(int paramInt);
  
  public abstract byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte);
  
  public abstract void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  
  public abstract void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult);
  
  public abstract void onCheckFileidCompleted(String paramString, CdnLogic.CheckFileIDResult paramCheckFileIDResult);
  
  public abstract void onDataAvailable(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onDownloadToEnd(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onMoovReady(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onPreloadCompleted(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onPreloadCompletedWithResult(String paramString, int paramInt1, int paramInt2, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  
  public abstract void onProgressChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void onRecvedData(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.ICallback
 * JD-Core Version:    0.7.0.1
 */
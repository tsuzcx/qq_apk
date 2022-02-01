package com.tencent.tmassistantsdk;

public abstract interface ITMAssistantCallBackListener
{
  public abstract void OnDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString);
  
  public abstract void OnQQDownloaderInvalid();
  
  public abstract void OnServiceFree();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.ITMAssistantCallBackListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.midas.api;

public abstract interface IAPMidasNetCallBack
{
  public abstract void MidasNetError(String paramString1, int paramInt, String paramString2);
  
  public abstract void MidasNetFinish(String paramString1, String paramString2);
  
  public abstract void MidasNetStop(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.api.IAPMidasNetCallBack
 * JD-Core Version:    0.7.0.1
 */
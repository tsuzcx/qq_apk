package com.tencent.midas.api;

public abstract interface IAPMidasPayCallBack
{
  public abstract void MidasPayCallBack(APMidasResponse paramAPMidasResponse);
  
  public abstract void MidasPayNeedLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.api.IAPMidasPayCallBack
 * JD-Core Version:    0.7.0.1
 */
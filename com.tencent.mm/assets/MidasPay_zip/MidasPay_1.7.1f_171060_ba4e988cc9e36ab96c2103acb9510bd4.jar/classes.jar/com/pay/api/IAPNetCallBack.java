package com.pay.api;

public abstract interface IAPNetCallBack
{
  public abstract void MidasNetError(String paramString1, int paramInt, String paramString2);
  
  public abstract void MidasNetFinish(String paramString1, String paramString2);
  
  public abstract void MidasNetStop(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.IAPNetCallBack
 * JD-Core Version:    0.7.0.1
 */
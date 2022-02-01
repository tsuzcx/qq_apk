package com.pay.api;

public abstract interface IAPNetCallBack
{
  public abstract void MidasNetError(String paramString1, int paramInt, String paramString2);
  
  public abstract void MidasNetFinish(String paramString1, String paramString2);
  
  public abstract void MidasNetStop(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.IAPNetCallBack
 * JD-Core Version:    0.7.0.1
 */
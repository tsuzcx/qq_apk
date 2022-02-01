package com.pay.api;

public abstract interface IAPPayCallBack
{
  public abstract void MidasPayCallBack(APPayResponse paramAPPayResponse);
  
  public abstract void MidasPayNeedLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.IAPPayCallBack
 * JD-Core Version:    0.7.0.1
 */
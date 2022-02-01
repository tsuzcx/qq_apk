package com.pay.api;

public abstract interface IAPPayCallBack
{
  public abstract void MidasPayCallBack(APPayResponse paramAPPayResponse);
  
  public abstract void MidasPayNeedLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.api.IAPPayCallBack
 * JD-Core Version:    0.7.0.1
 */
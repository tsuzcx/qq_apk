package com.pay.api;

public abstract interface IAPPayCallBack
{
  public abstract void MidasPayCallBack(APPayResponse paramAPPayResponse);
  
  public abstract void MidasPayNeedLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.IAPPayCallBack
 * JD-Core Version:    0.7.0.1
 */
package com.pay.api;

public abstract interface IAPPayGameServiceCallBack
{
  public abstract void PayGameNeedLogin();
  
  public abstract void PayGameServiceCallBack(APPayResponseInfo paramAPPayResponseInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.api.IAPPayGameServiceCallBack
 * JD-Core Version:    0.7.0.1
 */
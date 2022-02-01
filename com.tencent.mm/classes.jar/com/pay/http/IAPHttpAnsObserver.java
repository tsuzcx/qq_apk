package com.pay.http;

public abstract interface IAPHttpAnsObserver
{
  public abstract void onError(APBaseHttpAns paramAPBaseHttpAns);
  
  public abstract void onFinish(APBaseHttpAns paramAPBaseHttpAns);
  
  public abstract void onStop(APBaseHttpAns paramAPBaseHttpAns);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.http.IAPHttpAnsObserver
 * JD-Core Version:    0.7.0.1
 */
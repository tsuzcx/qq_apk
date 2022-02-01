package com.facebook;

public abstract interface LoginStatusCallback
{
  public abstract void onCompleted(AccessToken paramAccessToken);
  
  public abstract void onError(Exception paramException);
  
  public abstract void onFailure();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.LoginStatusCallback
 * JD-Core Version:    0.7.0.1
 */
package com.facebook;

public abstract interface FacebookCallback<RESULT>
{
  public abstract void onCancel();
  
  public abstract void onError(FacebookException paramFacebookException);
  
  public abstract void onSuccess(RESULT paramRESULT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.FacebookCallback
 * JD-Core Version:    0.7.0.1
 */
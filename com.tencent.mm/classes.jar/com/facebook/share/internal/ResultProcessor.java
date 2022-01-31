package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;

public abstract class ResultProcessor
{
  private FacebookCallback appCallback;
  
  public ResultProcessor(FacebookCallback paramFacebookCallback)
  {
    this.appCallback = paramFacebookCallback;
  }
  
  public void onCancel(AppCall paramAppCall)
  {
    if (this.appCallback != null) {
      this.appCallback.onCancel();
    }
  }
  
  public void onError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    if (this.appCallback != null) {
      this.appCallback.onError(paramFacebookException);
    }
  }
  
  public abstract void onSuccess(AppCall paramAppCall, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.ResultProcessor
 * JD-Core Version:    0.7.0.1
 */
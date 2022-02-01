package com.facebook;

public abstract interface FacebookDialog<CONTENT, RESULT>
{
  public abstract boolean canShow(CONTENT paramCONTENT);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<RESULT> paramFacebookCallback);
  
  public abstract void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<RESULT> paramFacebookCallback, int paramInt);
  
  public abstract void show(CONTENT paramCONTENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.FacebookDialog
 * JD-Core Version:    0.7.0.1
 */
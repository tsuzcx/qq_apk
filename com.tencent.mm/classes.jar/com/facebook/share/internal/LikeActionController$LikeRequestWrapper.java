package com.facebook.share.internal;

abstract interface LikeActionController$LikeRequestWrapper
  extends LikeActionController.RequestWrapper
{
  public abstract String getUnlikeToken();
  
  public abstract boolean isObjectLiked();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.LikeRequestWrapper
 * JD-Core Version:    0.7.0.1
 */
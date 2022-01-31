package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequestBatch;

abstract interface LikeActionController$RequestWrapper
{
  public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
  
  public abstract FacebookRequestError getError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.RequestWrapper
 * JD-Core Version:    0.7.0.1
 */
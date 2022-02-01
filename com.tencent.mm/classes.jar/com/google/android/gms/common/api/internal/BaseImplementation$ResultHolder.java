package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public abstract interface BaseImplementation$ResultHolder<R>
{
  @KeepForSdk
  public abstract void setFailedResult(Status paramStatus);
  
  @KeepForSdk
  public abstract void setResult(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
 * JD-Core Version:    0.7.0.1
 */
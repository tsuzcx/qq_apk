package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzabp;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  public final PendingResult<S> createFailedResult(Status paramStatus)
  {
    return new zzabp(paramStatus);
  }
  
  public Status onFailure(Status paramStatus)
  {
    return paramStatus;
  }
  
  public abstract PendingResult<S> onSuccess(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultTransform
 * JD-Core Version:    0.7.0.1
 */
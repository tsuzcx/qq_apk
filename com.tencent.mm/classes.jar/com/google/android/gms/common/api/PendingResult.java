package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result>
{
  public abstract R await();
  
  public abstract R await(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void cancel();
  
  public abstract boolean isCanceled();
  
  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(PendingResult.zza paramzza)
  {
    throw new UnsupportedOperationException();
  }
  
  public Integer zzvr()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResult
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult>
  implements zzf<TResult>
{
  private final Executor zzbFQ;
  private final Continuation<TResult, TContinuationResult> zzbNt;
  private final zzh<TContinuationResult> zzbNu;
  
  public zza(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation, zzh<TContinuationResult> paramzzh)
  {
    this.zzbFQ = paramExecutor;
    this.zzbNt = paramContinuation;
    this.zzbNu = paramzzh;
  }
  
  public void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public void onComplete(Task<TResult> paramTask)
  {
    this.zzbFQ.execute(new zza.1(this, paramTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tasks.zza
 * JD-Core Version:    0.7.0.1
 */
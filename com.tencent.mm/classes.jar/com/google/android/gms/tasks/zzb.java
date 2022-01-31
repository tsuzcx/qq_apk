package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult>
  implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult>
{
  private final Executor zzbFQ;
  private final Continuation<TResult, Task<TContinuationResult>> zzbNt;
  private final zzh<TContinuationResult> zzbNu;
  
  public zzb(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation, zzh<TContinuationResult> paramzzh)
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
    this.zzbFQ.execute(new zzb.1(this, paramTask));
  }
  
  public void onFailure(Exception paramException)
  {
    this.zzbNu.setException(paramException);
  }
  
  public void onSuccess(TContinuationResult paramTContinuationResult)
  {
    this.zzbNu.setResult(paramTContinuationResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tasks.zzb
 * JD-Core Version:    0.7.0.1
 */
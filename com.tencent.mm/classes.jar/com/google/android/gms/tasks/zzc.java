package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzc<TResult>
  implements zzf<TResult>
{
  private final Executor zzbFQ;
  private OnCompleteListener<TResult> zzbNy;
  private final Object zzrJ = new Object();
  
  public zzc(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzbFQ = paramExecutor;
    this.zzbNy = paramOnCompleteListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzrJ)
    {
      this.zzbNy = null;
      return;
    }
  }
  
  public void onComplete(Task<TResult> paramTask)
  {
    synchronized (this.zzrJ)
    {
      if (this.zzbNy == null) {
        return;
      }
      this.zzbFQ.execute(new zzc.1(this, paramTask));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tasks.zzc
 * JD-Core Version:    0.7.0.1
 */
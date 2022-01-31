package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zzd<TResult>
  implements zzf<TResult>
{
  private final Executor zzbFQ;
  private OnFailureListener zzbNA;
  private final Object zzrJ = new Object();
  
  public zzd(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzbFQ = paramExecutor;
    this.zzbNA = paramOnFailureListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzrJ)
    {
      this.zzbNA = null;
      return;
    }
  }
  
  public void onComplete(Task<TResult> paramTask)
  {
    if (!paramTask.isSuccessful()) {
      synchronized (this.zzrJ)
      {
        if (this.zzbNA == null) {
          return;
        }
        this.zzbFQ.execute(new zzd.1(this, paramTask));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tasks.zzd
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

class zze<TResult>
  implements zzf<TResult>
{
  private final Executor zzbFQ;
  private OnSuccessListener<? super TResult> zzbNC;
  private final Object zzrJ = new Object();
  
  public zze(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzbFQ = paramExecutor;
    this.zzbNC = paramOnSuccessListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzrJ)
    {
      this.zzbNC = null;
      return;
    }
  }
  
  public void onComplete(Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful()) {
      synchronized (this.zzrJ)
      {
        if (this.zzbNC == null) {
          return;
        }
        this.zzbFQ.execute(new zze.1(this, paramTask));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zze
 * JD-Core Version:    0.7.0.1
 */
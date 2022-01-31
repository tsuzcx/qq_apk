package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult>
{
  private Queue<zzf<TResult>> zzbNE;
  private boolean zzbNF;
  private final Object zzrJ = new Object();
  
  public void zza(Task<TResult> paramTask)
  {
    for (;;)
    {
      zzf localzzf;
      synchronized (this.zzrJ)
      {
        if ((this.zzbNE == null) || (this.zzbNF)) {
          return;
        }
        this.zzbNF = true;
        synchronized (this.zzrJ)
        {
          localzzf = (zzf)this.zzbNE.poll();
          if (localzzf == null)
          {
            this.zzbNF = false;
            return;
          }
        }
      }
      localzzf.onComplete(paramTask);
    }
  }
  
  public void zza(zzf<TResult> paramzzf)
  {
    synchronized (this.zzrJ)
    {
      if (this.zzbNE == null) {
        this.zzbNE = new ArrayDeque();
      }
      this.zzbNE.add(paramzzf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zzg
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

final class Tasks$zzc
  implements Tasks.zzb
{
  private final zzh<Void> zzbNG;
  private Exception zzbNL;
  private final int zzbNN;
  private int zzbNO;
  private int zzbNP;
  private final Object zzrJ = new Object();
  
  public Tasks$zzc(int paramInt, zzh<Void> paramzzh)
  {
    this.zzbNN = paramInt;
    this.zzbNG = paramzzh;
  }
  
  private void zzTI()
  {
    if (this.zzbNO + this.zzbNP == this.zzbNN)
    {
      if (this.zzbNL == null) {
        this.zzbNG.setResult(null);
      }
    }
    else {
      return;
    }
    zzh localzzh = this.zzbNG;
    int i = this.zzbNP;
    int j = this.zzbNN;
    localzzh.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", this.zzbNL));
  }
  
  public final void onFailure(Exception paramException)
  {
    synchronized (this.zzrJ)
    {
      this.zzbNP += 1;
      this.zzbNL = paramException;
      zzTI();
      return;
    }
  }
  
  public final void onSuccess(Object arg1)
  {
    synchronized (this.zzrJ)
    {
      this.zzbNO += 1;
      zzTI();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks.zzc
 * JD-Core Version:    0.7.0.1
 */
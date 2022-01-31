package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

class zzf$1
  implements Executor
{
  zzf$1(zzf paramzzf, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.zzs.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzf.1
 * JD-Core Version:    0.7.0.1
 */
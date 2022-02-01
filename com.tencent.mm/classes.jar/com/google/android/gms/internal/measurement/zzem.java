package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

abstract class zzem
{
  private static volatile Handler handler;
  private final zzhi zzafj;
  private final Runnable zzyd;
  private volatile long zzye;
  
  zzem(zzhi paramzzhi)
  {
    Preconditions.checkNotNull(paramzzhi);
    this.zzafj = paramzzhi;
    this.zzyd = new zzen(this, paramzzhi);
  }
  
  private final Handler getHandler()
  {
    if (handler != null) {
      return handler;
    }
    try
    {
      if (handler == null) {
        handler = new Handler(this.zzafj.getContext().getMainLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    finally {}
  }
  
  final void cancel()
  {
    this.zzye = 0L;
    getHandler().removeCallbacks(this.zzyd);
  }
  
  public abstract void run();
  
  public final boolean zzef()
  {
    return this.zzye != 0L;
  }
  
  public final void zzh(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzye = this.zzafj.zzbt().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzyd, paramLong)) {
        this.zzafj.zzge().zzim().zzg("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzem
 * JD-Core Version:    0.7.0.1
 */
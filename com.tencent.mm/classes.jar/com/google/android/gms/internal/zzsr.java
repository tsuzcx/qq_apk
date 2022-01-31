package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

abstract class zzsr
{
  private static volatile Handler zzafd;
  private final zzsc zzadO;
  private volatile long zzafe;
  private final Runnable zzw;
  
  zzsr(zzsc paramzzsc)
  {
    zzac.zzw(paramzzsc);
    this.zzadO = paramzzsc;
    this.zzw = new zzsr.1(this);
  }
  
  private Handler getHandler()
  {
    if (zzafd != null) {
      return zzafd;
    }
    try
    {
      if (zzafd == null) {
        zzafd = new Handler(this.zzadO.getContext().getMainLooper());
      }
      Handler localHandler = zzafd;
      return localHandler;
    }
    finally {}
  }
  
  public void cancel()
  {
    this.zzafe = 0L;
    getHandler().removeCallbacks(this.zzw);
  }
  
  public abstract void run();
  
  public boolean zzcy()
  {
    return this.zzafe != 0L;
  }
  
  public long zzpA()
  {
    if (this.zzafe == 0L) {
      return 0L;
    }
    return Math.abs(this.zzadO.zznR().currentTimeMillis() - this.zzafe);
  }
  
  public void zzy(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzafe = this.zzadO.zznR().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzw, paramLong)) {
        this.zzadO.zznS().zze("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public void zzz(long paramLong)
  {
    long l = 0L;
    if (!zzcy()) {
      return;
    }
    if (paramLong < 0L)
    {
      cancel();
      return;
    }
    paramLong -= Math.abs(this.zzadO.zznR().currentTimeMillis() - this.zzafe);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      getHandler().removeCallbacks(this.zzw);
      if (getHandler().postDelayed(this.zzw, paramLong)) {
        break;
      }
      this.zzadO.zznS().zze("Failed to adjust delayed post. time", Long.valueOf(paramLong));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzsr
 * JD-Core Version:    0.7.0.1
 */
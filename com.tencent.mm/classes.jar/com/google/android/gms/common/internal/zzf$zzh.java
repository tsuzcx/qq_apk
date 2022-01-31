package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class zzf$zzh
  implements ServiceConnection
{
  private final int zzaFx;
  
  public zzf$zzh(zzf paramzzf, int paramInt)
  {
    this.zzaFx = paramInt;
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      this.zzaFu.zza(8, null, this.zzaFx);
      return;
    }
    synchronized (zzf.zza(this.zzaFu))
    {
      zzf.zza(this.zzaFu, zzv.zza.zzbu(paramIBinder));
      this.zzaFu.zza(0, null, this.zzaFx);
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (zzf.zza(this.zzaFu))
    {
      zzf.zza(this.zzaFu, null);
      this.zzaFu.mHandler.sendMessage(this.zzaFu.mHandler.obtainMessage(4, this.zzaFx, 1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzh
 * JD-Core Version:    0.7.0.1
 */
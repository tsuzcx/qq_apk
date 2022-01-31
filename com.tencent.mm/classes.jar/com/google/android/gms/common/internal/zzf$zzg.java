package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzf$zzg
  extends zzu.zza
{
  private zzf zzaFw;
  private final int zzaFx;
  
  public zzf$zzg(zzf paramzzf, int paramInt)
  {
    this.zzaFw = paramzzf;
    this.zzaFx = paramInt;
  }
  
  private void zzxJ()
  {
    this.zzaFw = null;
  }
  
  public final void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    zzac.zzb(this.zzaFw, "onPostInitComplete can be called only once per call to getRemoteService");
    this.zzaFw.zza(paramInt, paramIBinder, paramBundle, this.zzaFx);
    zzxJ();
  }
  
  public final void zzb(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzg
 * JD-Core Version:    0.7.0.1
 */
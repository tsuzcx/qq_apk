package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zzf$zza
  extends zzf.zze<Boolean>
{
  public final int statusCode;
  public final Bundle zzaFt;
  
  protected zzf$zza(zzf paramzzf, int paramInt, Bundle paramBundle)
  {
    super(paramzzf, Boolean.valueOf(true));
    this.statusCode = paramInt;
    this.zzaFt = paramBundle;
  }
  
  protected void zzb(Boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean == null) {
      zzf.zza(this.zzaFu, 1, null);
    }
    do
    {
      return;
      switch (this.statusCode)
      {
      default: 
        zzf.zza(this.zzaFu, 1, null);
        paramBoolean = localObject;
        if (this.zzaFt != null) {
          paramBoolean = (PendingIntent)this.zzaFt.getParcelable("pendingIntent");
        }
        zzm(new ConnectionResult(this.statusCode, paramBoolean));
        return;
      }
    } while (zzxG());
    zzf.zza(this.zzaFu, 1, null);
    zzm(new ConnectionResult(8, null));
    return;
    zzf.zza(this.zzaFu, 1, null);
    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
  }
  
  protected abstract void zzm(ConnectionResult paramConnectionResult);
  
  protected abstract boolean zzxG();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zza
 * JD-Core Version:    0.7.0.1
 */
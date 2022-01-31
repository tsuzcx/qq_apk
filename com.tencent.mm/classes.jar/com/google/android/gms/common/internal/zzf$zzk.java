package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class zzf$zzk
  extends zzf.zza
{
  public zzf$zzk(zzf paramzzf, int paramInt, Bundle paramBundle)
  {
    super(paramzzf, paramInt, paramBundle);
  }
  
  protected final void zzm(ConnectionResult paramConnectionResult)
  {
    this.zzaFu.zzaFi.zzg(paramConnectionResult);
    this.zzaFu.onConnectionFailed(paramConnectionResult);
  }
  
  protected final boolean zzxG()
  {
    this.zzaFu.zzaFi.zzg(ConnectionResult.zzayj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzk
 * JD-Core Version:    0.7.0.1
 */
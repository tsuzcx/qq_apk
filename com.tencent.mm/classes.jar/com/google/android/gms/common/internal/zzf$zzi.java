package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public class zzf$zzi
  implements zzf.zzf
{
  public zzf$zzi(zzf paramzzf) {}
  
  public void zzg(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess()) {
      this.zzaFu.zza(null, this.zzaFu.zzxF());
    }
    while (zzf.zzd(this.zzaFu) == null) {
      return;
    }
    zzf.zzd(this.zzaFu).onConnectionFailed(paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzi
 * JD-Core Version:    0.7.0.1
 */
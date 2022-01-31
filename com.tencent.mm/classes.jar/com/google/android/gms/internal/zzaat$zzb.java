package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class zzaat$zzb
  extends zzaaz.zza
{
  private WeakReference<zzaat> zzaCc;
  
  zzaat$zzb(zzaat paramzzaat)
  {
    this.zzaCc = new WeakReference(paramzzaat);
  }
  
  public void zzvE()
  {
    zzaat localzzaat = (zzaat)this.zzaCc.get();
    if (localzzaat == null) {
      return;
    }
    zzaat.zza(localzzaat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaat.zzb
 * JD-Core Version:    0.7.0.1
 */
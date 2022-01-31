package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzaad.zzb;

abstract class zzcw$zzb<T>
  extends zza
{
  private zzaad.zzb<T> zzahW;
  
  public zzcw$zzb(zzaad.zzb<T> paramzzb)
  {
    this.zzahW = paramzzb;
  }
  
  public void zzaa(T paramT)
  {
    zzaad.zzb localzzb = this.zzahW;
    if (localzzb != null)
    {
      localzzb.setResult(paramT);
      this.zzahW = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw.zzb
 * JD-Core Version:    0.7.0.1
 */
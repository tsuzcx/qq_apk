package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzaav$zza
{
  private final zzaau zzaCk;
  
  protected zzaav$zza(zzaau paramzzaau)
  {
    this.zzaCk = paramzzaau;
  }
  
  public final void zzc(zzaav paramzzaav)
  {
    zzaav.zza(paramzzaav).lock();
    try
    {
      zzaau localzzaau1 = zzaav.zzb(paramzzaav);
      zzaau localzzaau2 = this.zzaCk;
      if (localzzaau1 != localzzaau2) {
        return;
      }
      zzwe();
      return;
    }
    finally
    {
      zzaav.zza(paramzzaav).unlock();
    }
  }
  
  protected abstract void zzwe();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaav.zza
 * JD-Core Version:    0.7.0.1
 */
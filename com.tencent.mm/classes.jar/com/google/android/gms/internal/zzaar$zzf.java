package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzaar$zzf
  implements Runnable
{
  private zzaar$zzf(zzaar paramzzaar) {}
  
  public void run()
  {
    zzaar.zzc(this.zzaBA).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      zzwe();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzaar.zzd(this.zzaBA).zza(localRuntimeException);
      return;
    }
    finally
    {
      zzaar.zzc(this.zzaBA).unlock();
    }
  }
  
  protected abstract void zzwe();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzaar.zzf
 * JD-Core Version:    0.7.0.1
 */
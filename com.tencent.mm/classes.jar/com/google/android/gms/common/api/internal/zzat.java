package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zzat
  implements Runnable
{
  private zzat(zzaj paramzzaj) {}
  
  public void run()
  {
    zzaj.zzc(this.zzhv).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      zzaq();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzaj.zzd(this.zzhv).zzb(localRuntimeException);
      return;
    }
    finally
    {
      zzaj.zzc(this.zzhv).unlock();
    }
  }
  
  protected abstract void zzaq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzat
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;

public abstract interface IObjectWrapper
  extends IInterface
{
  private static class zza$zza
    implements IObjectWrapper
  {
    private IBinder zzrk;
    
    zza$zza(IBinder paramIBinder)
    {
      this.zzrk = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return this.zzrk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.dynamic.IObjectWrapper
 * JD-Core Version:    0.7.0.1
 */
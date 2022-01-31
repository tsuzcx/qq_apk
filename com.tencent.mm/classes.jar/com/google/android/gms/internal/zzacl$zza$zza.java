package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class zzacl$zza$zza
  implements zzacl
{
  private IBinder zzrk;
  
  zzacl$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  public void zza(zzack paramzzack)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
      if (paramzzack != null) {
        localIBinder = paramzzack.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.zzrk.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzacl.zza.zza
 * JD-Core Version:    0.7.0.1
 */
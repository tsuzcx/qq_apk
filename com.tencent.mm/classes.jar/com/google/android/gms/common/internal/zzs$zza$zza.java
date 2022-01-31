package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

class zzs$zza$zza
  implements zzs
{
  private IBinder zzrk;
  
  zzs$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  public void cancel()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
      this.zzrk.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzs.zza.zza
 * JD-Core Version:    0.7.0.1
 */
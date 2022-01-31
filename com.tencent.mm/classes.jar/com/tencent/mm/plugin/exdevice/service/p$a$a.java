package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

final class p$a$a
  implements p
{
  private IBinder mRemote;
  
  p$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final o aMj()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      o localo = o.a.y(localParcel2.readStrongBinder());
      return localo;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final l aMk()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      l locall = l.a.x(localParcel2.readStrongBinder());
      return locall;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.p.a.a
 * JD-Core Version:    0.7.0.1
 */
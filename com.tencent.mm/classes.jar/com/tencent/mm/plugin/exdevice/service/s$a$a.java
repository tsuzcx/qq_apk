package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

final class s$a$a
  implements s
{
  private IBinder mRemote;
  
  s$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
      localParcel1.writeLong(paramLong);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.s.a.a
 * JD-Core Version:    0.7.0.1
 */
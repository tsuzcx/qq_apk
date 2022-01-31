package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a$a
  implements o
{
  private IBinder mRemote;
  
  o$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final long bqr()
  {
    AppMethodBeat.i(19616);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      long l = localParcel2.readLong();
      return l;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19616);
    }
  }
  
  public final byte[] bqs()
  {
    AppMethodBeat.i(19617);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      byte[] arrayOfByte = localParcel2.createByteArray();
      return arrayOfByte;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19617);
    }
  }
  
  public final int bqt()
  {
    AppMethodBeat.i(19618);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19618);
    }
  }
  
  public final int bqu()
  {
    AppMethodBeat.i(19619);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19619);
    }
  }
  
  public final int bqv()
  {
    AppMethodBeat.i(19620);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.o.a.a
 * JD-Core Version:    0.7.0.1
 */
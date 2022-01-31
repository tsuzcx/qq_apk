package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$a$a
  implements q
{
  private IBinder mRemote;
  
  q$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(19623);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
      localParcel1.writeDouble(paramDouble1);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeByteArray(paramArrayOfByte);
      localParcel1.writeDouble(paramDouble2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeString(paramString);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(19623);
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.q.a.a
 * JD-Core Version:    0.7.0.1
 */
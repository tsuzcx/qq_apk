package com.a.a;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a$a
  implements b
{
  private IBinder mRemote;
  
  b$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118242);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationClient");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(118242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */
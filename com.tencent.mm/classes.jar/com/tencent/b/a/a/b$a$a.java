package com.tencent.b.a.a;

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
  
  public final void onActionResult(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75593);
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.assistant.sdk.SDKActionCallback");
      localParcel.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(75593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.b.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */
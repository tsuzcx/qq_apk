package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final boolean a(Intent paramIntent, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(94129);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i == 0) {
              break label144;
            }
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(94129);
      }
      continue;
      label144:
      bool = false;
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final int getVersion()
  {
    AppMethodBeat.i(94130);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(94130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.search.verification.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
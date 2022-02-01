package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends e
{
  public final String a(Context paramContext, IBinder paramIBinder)
  {
    AppMethodBeat.i(138436);
    paramContext = Parcel.obtain();
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramContext.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
      paramIBinder.transact(3, paramContext, localParcel, 0);
      localParcel.readException();
      paramIBinder = localParcel.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel.recycle();
      paramContext.recycle();
      AppMethodBeat.o(138436);
    }
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(138435);
    Intent localIntent = new Intent("com.asus.msa.action.ACCESS_DID");
    localIntent.setClassName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
    AppMethodBeat.o(138435);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
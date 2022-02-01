package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends e
{
  public final String a(Context paramContext, IBinder paramIBinder)
  {
    AppMethodBeat.i(138440);
    paramContext = Parcel.obtain();
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramContext.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      paramIBinder.transact(1, paramContext, localParcel, 0);
      localParcel.readException();
      paramIBinder = localParcel.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel.recycle();
      paramContext.recycle();
      AppMethodBeat.o(138440);
    }
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(138439);
    Intent localIntent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
    localIntent.setPackage("com.huawei.hwid");
    AppMethodBeat.o(138439);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */
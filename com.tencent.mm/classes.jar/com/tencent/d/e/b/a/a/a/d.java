package com.tencent.d.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.d.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends e
{
  public final String a(Context paramContext, IBinder paramIBinder)
  {
    AppMethodBeat.i(138442);
    paramContext = Parcel.obtain();
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramContext.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
      paramIBinder.transact(1, paramContext, localParcel, 0);
      localParcel.readException();
      paramIBinder = localParcel.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel.recycle();
      paramContext.recycle();
      AppMethodBeat.o(138442);
    }
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(138441);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
    AppMethodBeat.o(138441);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */
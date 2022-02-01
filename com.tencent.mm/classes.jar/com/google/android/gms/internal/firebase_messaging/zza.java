package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zza
  implements IInterface
{
  private final IBinder zza;
  private final String zzb;
  
  protected zza(IBinder paramIBinder, String paramString)
  {
    this.zza = paramIBinder;
    this.zzb = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.zza;
  }
  
  protected final Parcel obtainAndWriteInterfaceToken()
  {
    AppMethodBeat.i(4107);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    AppMethodBeat.o(4107);
    return localParcel;
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(4108);
    try
    {
      this.zza.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(4108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zza
 * JD-Core Version:    0.7.0.1
 */
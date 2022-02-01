package com.google.android.gms.internal.wearable;

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
    AppMethodBeat.i(100648);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    AppMethodBeat.o(100648);
    return localParcel;
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(100649);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zza.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
      AppMethodBeat.o(100649);
    }
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(100650);
    try
    {
      this.zza.transact(paramInt, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(100650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zza
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal.gcm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzd
  implements IInterface
{
  private final IBinder zzd;
  private final String zze;
  
  protected zzd(IBinder paramIBinder, String paramString)
  {
    this.zzd = paramIBinder;
    this.zze = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.zzd;
  }
  
  protected final Parcel obtainAndWriteInterfaceToken()
  {
    AppMethodBeat.i(2572);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zze);
    AppMethodBeat.o(2572);
    return localParcel;
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(2573);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzd.transact(2, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
      AppMethodBeat.o(2573);
    }
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(2574);
    try
    {
      this.zzd.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(2574);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzd
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal.auth-api-phone;

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
    AppMethodBeat.i(80424);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    AppMethodBeat.o(80424);
    return localParcel;
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(80425);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zza.transact(1, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
      AppMethodBeat.o(80425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zza
 * JD-Core Version:    0.7.0.1
 */
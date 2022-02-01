package com.google.android.gms.internal.auth;

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
    AppMethodBeat.i(10773);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zze);
    AppMethodBeat.o(10773);
    return localParcel;
  }
  
  protected final Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(10774);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzd.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return localParcel;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(10774);
    }
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(10775);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzd.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
      AppMethodBeat.o(10775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzd
 * JD-Core Version:    0.7.0.1
 */
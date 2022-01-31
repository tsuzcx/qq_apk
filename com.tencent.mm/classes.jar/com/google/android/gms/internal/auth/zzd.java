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
    AppMethodBeat.i(77114);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zze);
    AppMethodBeat.o(77114);
    return localParcel;
  }
  
  protected final Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(77115);
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
      AppMethodBeat.o(77115);
    }
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(77116);
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
      AppMethodBeat.o(77116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzd
 * JD-Core Version:    0.7.0.1
 */
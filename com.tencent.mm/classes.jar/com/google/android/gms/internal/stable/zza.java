package com.google.android.gms.internal.stable;

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
  
  protected Parcel obtainAndWriteInterfaceToken()
  {
    AppMethodBeat.i(90457);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    AppMethodBeat.o(90457);
    return localParcel;
  }
  
  protected Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(90458);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zza.transact(paramInt, paramParcel, localParcel, 0);
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
      AppMethodBeat.o(90458);
    }
  }
  
  protected void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(90459);
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
      AppMethodBeat.o(90459);
    }
  }
  
  protected void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(90460);
    try
    {
      this.zza.transact(paramInt, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(90460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zza
 * JD-Core Version:    0.7.0.1
 */
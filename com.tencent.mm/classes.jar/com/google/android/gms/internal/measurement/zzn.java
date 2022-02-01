package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzn
  implements IInterface
{
  private final IBinder zzqi;
  private final String zzqj;
  
  protected zzn(IBinder paramIBinder, String paramString)
  {
    this.zzqi = paramIBinder;
    this.zzqj = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.zzqi;
  }
  
  protected final Parcel obtainAndWriteInterfaceToken()
  {
    AppMethodBeat.i(40312);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzqj);
    AppMethodBeat.o(40312);
    return localParcel;
  }
  
  protected final Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(40313);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzqi.transact(paramInt, paramParcel, localParcel, 0);
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
      AppMethodBeat.o(40313);
    }
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(40314);
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzqi.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
      AppMethodBeat.o(40314);
    }
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(40315);
    try
    {
      this.zzqi.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(40315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzn
 * JD-Core Version:    0.7.0.1
 */
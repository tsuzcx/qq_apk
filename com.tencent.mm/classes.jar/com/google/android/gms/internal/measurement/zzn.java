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
    AppMethodBeat.i(3522);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzqj);
    AppMethodBeat.o(3522);
    return localParcel;
  }
  
  protected final Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(3523);
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
      AppMethodBeat.o(3523);
    }
  }
  
  protected final void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(3524);
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
      AppMethodBeat.o(3524);
    }
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel)
  {
    AppMethodBeat.i(3525);
    try
    {
      this.zzqi.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
      AppMethodBeat.o(3525);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzn
 * JD-Core Version:    0.7.0.1
 */
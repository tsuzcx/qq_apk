package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.gcm.zzd;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh
  extends zzd
  implements zzg
{
  zzh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
  }
  
  public final void zzf(int paramInt)
  {
    AppMethodBeat.i(70030);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(2, localParcel);
    AppMethodBeat.o(70030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.zzh
 * JD-Core Version:    0.7.0.1
 */
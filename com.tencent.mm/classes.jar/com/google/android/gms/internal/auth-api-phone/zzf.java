package com.google.android.gms.internal.auth-api-phone;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf
  extends zza
  implements zze
{
  zzf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
  }
  
  public final void zza(zzg paramzzg)
  {
    AppMethodBeat.i(938);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzg);
    transactAndReadExceptionReturnVoid(1, localParcel);
    AppMethodBeat.o(938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzf
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg
  extends zza
  implements zze
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
  }
  
  public final String getId()
  {
    AppMethodBeat.i(115351);
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    AppMethodBeat.o(115351);
    return str;
  }
  
  public final boolean zzb(boolean paramBoolean)
  {
    AppMethodBeat.i(115352);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, true);
    localParcel = transactAndReadException(2, localParcel);
    paramBoolean = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(115352);
    return paramBoolean;
  }
  
  public final boolean zzc()
  {
    AppMethodBeat.i(115353);
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(115353);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.ads_identifier.zzg
 * JD-Core Version:    0.7.0.1
 */
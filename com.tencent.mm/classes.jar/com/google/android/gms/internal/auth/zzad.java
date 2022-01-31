package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzad
  extends zzd
  implements zzac
{
  zzad(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
  }
  
  public final void zzd(zzaa paramzzaa, zzae paramzzae)
  {
    AppMethodBeat.i(77084);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzaa);
    zzf.zzd(localParcel, paramzzae);
    transactAndReadExceptionReturnVoid(9, localParcel);
    AppMethodBeat.o(77084);
  }
  
  public final void zzd(zzaa paramzzaa, zzag paramzzag)
  {
    AppMethodBeat.i(77081);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzaa);
    zzf.zzd(localParcel, paramzzag);
    transactAndReadExceptionReturnVoid(6, localParcel);
    AppMethodBeat.o(77081);
  }
  
  public final void zzd(zzaa paramzzaa, zzai paramzzai)
  {
    AppMethodBeat.i(77080);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzaa);
    zzf.zzd(localParcel, paramzzai);
    transactAndReadExceptionReturnVoid(5, localParcel);
    AppMethodBeat.o(77080);
  }
  
  public final void zzd(zzaa paramzzaa, zzak paramzzak)
  {
    AppMethodBeat.i(77083);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzaa);
    zzf.zzd(localParcel, paramzzak);
    transactAndReadExceptionReturnVoid(8, localParcel);
    AppMethodBeat.o(77083);
  }
  
  public final void zzd(zzaa paramzzaa, zzy paramzzy)
  {
    AppMethodBeat.i(77082);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzaa);
    zzf.zzd(localParcel, paramzzy);
    transactAndReadExceptionReturnVoid(7, localParcel);
    AppMethodBeat.o(77082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzad
 * JD-Core Version:    0.7.0.1
 */
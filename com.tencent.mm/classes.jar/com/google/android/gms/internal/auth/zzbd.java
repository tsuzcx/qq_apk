package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbd
  extends zzd
  implements zzbc
{
  zzbd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
  }
  
  public final void zzd(zzba paramzzba)
  {
    AppMethodBeat.i(50494);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzba);
    transactAndReadExceptionReturnVoid(4, localParcel);
    AppMethodBeat.o(50494);
  }
  
  public final void zzd(zzba paramzzba, CredentialRequest paramCredentialRequest)
  {
    AppMethodBeat.i(50491);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzba);
    zzf.zzd(localParcel, paramCredentialRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
    AppMethodBeat.o(50491);
  }
  
  public final void zzd(zzba paramzzba, zzay paramzzay)
  {
    AppMethodBeat.i(50493);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzba);
    zzf.zzd(localParcel, paramzzay);
    transactAndReadExceptionReturnVoid(3, localParcel);
    AppMethodBeat.o(50493);
  }
  
  public final void zzd(zzba paramzzba, zzbe paramzzbe)
  {
    AppMethodBeat.i(50492);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzba);
    zzf.zzd(localParcel, paramzzbe);
    transactAndReadExceptionReturnVoid(2, localParcel);
    AppMethodBeat.o(50492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbd
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh
  extends com.google.android.gms.internal.auth.zzd
  implements zzf
{
  zzh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.account.IWorkAccountService");
  }
  
  public final void zzd(zzd paramzzd, Account paramAccount)
  {
    AppMethodBeat.i(76972);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzf.zzd(localParcel, paramzzd);
    com.google.android.gms.internal.auth.zzf.zzd(localParcel, paramAccount);
    transactAndReadExceptionReturnVoid(3, localParcel);
    AppMethodBeat.o(76972);
  }
  
  public final void zzd(zzd paramzzd, String paramString)
  {
    AppMethodBeat.i(76971);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzf.zzd(localParcel, paramzzd);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(2, localParcel);
    AppMethodBeat.o(76971);
  }
  
  public final void zze(boolean paramBoolean)
  {
    AppMethodBeat.i(76970);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzf.zzd(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(1, localParcel);
    AppMethodBeat.o(76970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.account.zzh
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzj
  extends zzd
  implements zzh
{
  zzj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.auth.IAuthManagerService");
  }
  
  public final Bundle zzd(Account paramAccount)
  {
    AppMethodBeat.i(10787);
    Object localObject = obtainAndWriteInterfaceToken();
    zzf.zzd((Parcel)localObject, paramAccount);
    paramAccount = transactAndReadException(7, (Parcel)localObject);
    localObject = (Bundle)zzf.zzd(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    AppMethodBeat.o(10787);
    return localObject;
  }
  
  public final Bundle zzd(Account paramAccount, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10786);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramAccount);
    localParcel.writeString(paramString);
    zzf.zzd(localParcel, paramBundle);
    paramAccount = transactAndReadException(5, localParcel);
    paramString = (Bundle)zzf.zzd(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    AppMethodBeat.o(10786);
    return paramString;
  }
  
  public final Bundle zzd(String paramString)
  {
    AppMethodBeat.i(10788);
    Object localObject = obtainAndWriteInterfaceToken();
    ((Parcel)localObject).writeString(paramString);
    paramString = transactAndReadException(8, (Parcel)localObject);
    localObject = (Bundle)zzf.zzd(paramString, Bundle.CREATOR);
    paramString.recycle();
    AppMethodBeat.o(10788);
    return localObject;
  }
  
  public final Bundle zzd(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10784);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zzf.zzd(localParcel, paramBundle);
    paramString = transactAndReadException(2, localParcel);
    paramBundle = (Bundle)zzf.zzd(paramString, Bundle.CREATOR);
    paramString.recycle();
    AppMethodBeat.o(10784);
    return paramBundle;
  }
  
  public final AccountChangeEventsResponse zzd(AccountChangeEventsRequest paramAccountChangeEventsRequest)
  {
    AppMethodBeat.i(10785);
    Object localObject = obtainAndWriteInterfaceToken();
    zzf.zzd((Parcel)localObject, paramAccountChangeEventsRequest);
    paramAccountChangeEventsRequest = transactAndReadException(3, (Parcel)localObject);
    localObject = (AccountChangeEventsResponse)zzf.zzd(paramAccountChangeEventsRequest, AccountChangeEventsResponse.CREATOR);
    paramAccountChangeEventsRequest.recycle();
    AppMethodBeat.o(10785);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzj
 * JD-Core Version:    0.7.0.1
 */
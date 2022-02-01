package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzk
  implements WorkAccountApi
{
  private static final Status zzaf;
  
  static
  {
    AppMethodBeat.i(10793);
    zzaf = new Status(13);
    AppMethodBeat.o(10793);
  }
  
  public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    AppMethodBeat.i(10791);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzm(this, WorkAccount.API, paramGoogleApiClient, paramString));
    AppMethodBeat.o(10791);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    AppMethodBeat.i(10792);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzo(this, WorkAccount.API, paramGoogleApiClient, paramAccount));
    AppMethodBeat.o(10792);
    return paramGoogleApiClient;
  }
  
  public final void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    AppMethodBeat.i(10789);
    setWorkAuthenticatorEnabledWithResult(paramGoogleApiClient, paramBoolean);
    AppMethodBeat.o(10789);
  }
  
  public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    AppMethodBeat.i(10790);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzl(this, WorkAccount.API, paramGoogleApiClient, paramBoolean));
    AppMethodBeat.o(10790);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzk
 * JD-Core Version:    0.7.0.1
 */
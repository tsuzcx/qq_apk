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
    AppMethodBeat.i(77134);
    zzaf = new Status(13);
    AppMethodBeat.o(77134);
  }
  
  public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    AppMethodBeat.i(77132);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzm(this, WorkAccount.API, paramGoogleApiClient, paramString));
    AppMethodBeat.o(77132);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    AppMethodBeat.i(77133);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzo(this, WorkAccount.API, paramGoogleApiClient, paramAccount));
    AppMethodBeat.o(77133);
    return paramGoogleApiClient;
  }
  
  public final void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    AppMethodBeat.i(77130);
    setWorkAuthenticatorEnabledWithResult(paramGoogleApiClient, paramBoolean);
    AppMethodBeat.o(77130);
  }
  
  public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    AppMethodBeat.i(77131);
    paramGoogleApiClient = paramGoogleApiClient.execute(new zzl(this, WorkAccount.API, paramGoogleApiClient, paramBoolean));
    AppMethodBeat.o(77131);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzk
 * JD-Core Version:    0.7.0.1
 */
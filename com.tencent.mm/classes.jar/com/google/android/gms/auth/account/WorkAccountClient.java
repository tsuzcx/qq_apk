package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccountClient
  extends GoogleApi<Api.ApiOptions.NoOptions>
{
  private final WorkAccountApi zzae;
  
  WorkAccountClient(Activity paramActivity)
  {
    super(paramActivity, WorkAccount.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.i(10625);
    this.zzae = new zzk();
    AppMethodBeat.o(10625);
  }
  
  WorkAccountClient(Context paramContext)
  {
    super(paramContext, WorkAccount.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    AppMethodBeat.i(10624);
    this.zzae = new zzk();
    AppMethodBeat.o(10624);
  }
  
  public Task<Account> addWorkAccount(String paramString)
  {
    AppMethodBeat.i(10627);
    paramString = PendingResultUtil.toTask(this.zzae.addWorkAccount(asGoogleApiClient(), paramString), new zzj(this));
    AppMethodBeat.o(10627);
    return paramString;
  }
  
  public Task<Void> removeWorkAccount(Account paramAccount)
  {
    AppMethodBeat.i(10628);
    paramAccount = PendingResultUtil.toVoidTask(this.zzae.removeWorkAccount(asGoogleApiClient(), paramAccount));
    AppMethodBeat.o(10628);
    return paramAccount;
  }
  
  public Task<Void> setWorkAuthenticatorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(10626);
    Task localTask = PendingResultUtil.toVoidTask(this.zzae.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), paramBoolean));
    AppMethodBeat.o(10626);
    return localTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccountClient
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzur
  implements WorkAccountApi
{
  private static final Status zzaiO = new Status(13);
  
  public PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zzb(new zzur.2(this, WorkAccount.API, paramGoogleApiClient, paramString));
  }
  
  public PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    return paramGoogleApiClient.zzb(new zzur.3(this, WorkAccount.API, paramGoogleApiClient, paramAccount));
  }
  
  public void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    paramGoogleApiClient.zzb(new zzur.1(this, WorkAccount.API, paramGoogleApiClient, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzur
 * JD-Core Version:    0.7.0.1
 */
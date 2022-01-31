package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface WorkAccountApi
{
  public abstract PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  public abstract void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccountApi
 * JD-Core Version:    0.7.0.1
 */
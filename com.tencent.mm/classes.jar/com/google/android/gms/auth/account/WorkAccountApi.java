package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
public abstract interface WorkAccountApi
{
  @Deprecated
  public abstract PendingResult<AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString);
  
  @Deprecated
  public abstract PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  @Deprecated
  public abstract void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  @Deprecated
  public abstract PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  @Deprecated
  public static abstract interface AddAccountResult
    extends Result
  {
    public abstract Account getAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccountApi
 * JD-Core Version:    0.7.0.1
 */
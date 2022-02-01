package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

final class zzr
  implements WorkAccountApi.AddAccountResult
{
  private final Status mStatus;
  private final Account zzn;
  
  public zzr(Status paramStatus, Account paramAccount)
  {
    this.mStatus = paramStatus;
    this.zzn = paramAccount;
  }
  
  public final Account getAccount()
  {
    return this.zzn;
  }
  
  public final Status getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzr
 * JD-Core Version:    0.7.0.1
 */
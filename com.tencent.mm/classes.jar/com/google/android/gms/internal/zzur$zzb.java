package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

class zzur$zzb
  implements WorkAccountApi.AddAccountResult
{
  private final Account zzahh;
  private final Status zzair;
  
  public zzur$zzb(Status paramStatus, Account paramAccount)
  {
    this.zzair = paramStatus;
    this.zzahh = paramAccount;
  }
  
  public Account getAccount()
  {
    return this.zzahh;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzur.zzb
 * JD-Core Version:    0.7.0.1
 */
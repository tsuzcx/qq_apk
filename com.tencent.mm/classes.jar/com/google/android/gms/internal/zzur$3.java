package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

class zzur$3
  extends zzaad.zza<Result, zzus>
{
  zzur$3(zzur paramzzur, Api paramApi, GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected void zza(zzus paramzzus)
  {
    ((zzb)paramzzus.zzxD()).zza(new zzur.3.1(this), this.zzaiB);
  }
  
  protected Result zzc(Status paramStatus)
  {
    return new zzur.zzc(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzur.3
 * JD-Core Version:    0.7.0.1
 */
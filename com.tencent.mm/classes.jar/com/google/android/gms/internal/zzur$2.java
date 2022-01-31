package com.google.android.gms.internal;

import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzur$2
  extends zzaad.zza<WorkAccountApi.AddAccountResult, zzus>
{
  zzur$2(zzur paramzzur, Api paramApi, GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected void zza(zzus paramzzus)
  {
    ((zzb)paramzzus.zzxD()).zza(new zzur.2.1(this), this.zzaiD);
  }
  
  protected WorkAccountApi.AddAccountResult zzf(Status paramStatus)
  {
    return new zzur.zzb(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzur.2
 * JD-Core Version:    0.7.0.1
 */
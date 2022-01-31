package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzvc$2
  extends zzvd<Status>
{
  zzvc$2(zzvc paramzzvc, GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(Context paramContext, zzvl paramzzvl)
  {
    paramzzvl.zza(new zzvc.zza(this), new zzvm(this.zzajO));
  }
  
  protected Status zzb(Status paramStatus)
  {
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzvc.2
 * JD-Core Version:    0.7.0.1
 */
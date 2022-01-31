package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzvc$1
  extends zzvd<CredentialRequestResult>
{
  zzvc$1(zzvc paramzzvc, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(Context paramContext, zzvl paramzzvl)
  {
    paramzzvl.zza(new zzvc.1.1(this), this.zzajM);
  }
  
  protected CredentialRequestResult zzj(Status paramStatus)
  {
    return zzvb.zzi(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzvc.1
 * JD-Core Version:    0.7.0.1
 */
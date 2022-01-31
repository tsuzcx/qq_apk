package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zze$1
  extends zze.zza<GoogleSignInResult>
{
  zze$1(GoogleApiClient paramGoogleApiClient, zzn paramzzn, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zza(zzd paramzzd)
  {
    ((zzk)paramzzd.zzxD()).zza(new zze.1.1(this), this.zzakz);
  }
  
  protected final GoogleSignInResult zzn(Status paramStatus)
  {
    return new GoogleSignInResult(null, paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze.1
 * JD-Core Version:    0.7.0.1
 */
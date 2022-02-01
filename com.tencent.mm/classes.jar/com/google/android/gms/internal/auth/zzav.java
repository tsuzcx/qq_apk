package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzav<R extends Result>
  extends BaseImplementation.ApiMethodImpl<R, zzax>
{
  zzav(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.CREDENTIALS_API, paramGoogleApiClient);
  }
  
  protected abstract void zzd(Context paramContext, zzbc paramzzbc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzav
 * JD-Core Version:    0.7.0.1
 */
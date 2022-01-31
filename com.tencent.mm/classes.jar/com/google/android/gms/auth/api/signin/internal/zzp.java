package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzp<R extends Result>
  extends BaseImplementation.ApiMethodImpl<R, zzh>
{
  public zzp(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.GOOGLE_SIGN_IN_API, paramGoogleApiClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzp
 * JD-Core Version:    0.7.0.1
 */
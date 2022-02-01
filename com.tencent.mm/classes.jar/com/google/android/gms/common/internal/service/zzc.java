package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzc<R extends Result>
  extends BaseImplementation.ApiMethodImpl<R, CommonClient>
{
  public zzc(GoogleApiClient paramGoogleApiClient)
  {
    super(Common.API, paramGoogleApiClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.zzc
 * JD-Core Version:    0.7.0.1
 */
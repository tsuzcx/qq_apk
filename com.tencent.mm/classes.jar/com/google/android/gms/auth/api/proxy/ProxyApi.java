package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public abstract interface ProxyApi
{
  @KeepForSdk
  public abstract PendingResult<ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);
  
  @KeepForSdk
  public static abstract interface ProxyResult
    extends Result
  {
    @KeepForSdk
    public abstract ProxyResponse getResponse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyApi
 * JD-Core Version:    0.7.0.1
 */
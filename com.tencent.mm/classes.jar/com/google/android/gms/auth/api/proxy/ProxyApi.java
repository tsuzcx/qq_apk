package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface ProxyApi
{
  public abstract PendingResult<ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);
  
  public static abstract interface ProxyResult
    extends Result
  {
    public abstract ProxyResponse getResponse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyApi
 * JD-Core Version:    0.7.0.1
 */
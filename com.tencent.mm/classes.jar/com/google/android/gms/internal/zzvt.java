package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzac;

public class zzvt
  implements ProxyApi
{
  public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    zzac.zzw(paramGoogleApiClient);
    zzac.zzw(paramProxyRequest);
    return paramGoogleApiClient.zzb(new zzvt.1(this, paramGoogleApiClient, paramProxyRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzvt
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbo
  extends zzbm
{
  zzbo(zzbn paramzzbn, GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zzd(Context paramContext, zzbk paramzzbk)
  {
    AppMethodBeat.i(10767);
    paramzzbk.zzd(new zzbp(this), this.zzec);
    AppMethodBeat.o(10767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbo
 * JD-Core Version:    0.7.0.1
 */
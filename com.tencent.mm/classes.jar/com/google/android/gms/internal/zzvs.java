package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

abstract class zzvs
  extends zzaad.zza<ProxyApi.ProxyResult, zzvp>
{
  public zzvs(GoogleApiClient paramGoogleApiClient)
  {
    super(zza.API, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzvr paramzzvr);
  
  protected final void zza(zzvp paramzzvp)
  {
    zza(paramzzvp.getContext(), (zzvr)paramzzvp.zzxD());
  }
  
  protected ProxyApi.ProxyResult zzk(Status paramStatus)
  {
    return new zzvu(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzvs
 * JD-Core Version:    0.7.0.1
 */
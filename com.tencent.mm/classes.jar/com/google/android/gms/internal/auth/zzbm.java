package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzbm
  extends BaseImplementation.ApiMethodImpl<ProxyApi.ProxyResult, zzbh>
{
  public zzbm(GoogleApiClient paramGoogleApiClient)
  {
    super(zzf.API, paramGoogleApiClient);
  }
  
  protected abstract void zzd(Context paramContext, zzbk paramzzbk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbm
 * JD-Core Version:    0.7.0.1
 */
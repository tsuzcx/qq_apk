package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;

class zzn$4
  extends zzm<CapabilityApi.RemoveLocalCapabilityResult>
{
  zzn$4(zzn paramzzn, GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzw(this, this.zzbTM);
  }
  
  protected CapabilityApi.RemoveLocalCapabilityResult zzbS(Status paramStatus)
  {
    return new zzn.zza(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.4
 * JD-Core Version:    0.7.0.1
 */
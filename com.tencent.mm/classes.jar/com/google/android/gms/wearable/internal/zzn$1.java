package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;

class zzn$1
  extends zzm<CapabilityApi.GetCapabilityResult>
{
  zzn$1(zzn paramzzn, GoogleApiClient paramGoogleApiClient, String paramString, int paramInt)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzh(this, this.zzbTM, this.zzbTN);
  }
  
  protected CapabilityApi.GetCapabilityResult zzbP(Status paramStatus)
  {
    return new zzn.zze(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.1
 * JD-Core Version:    0.7.0.1
 */
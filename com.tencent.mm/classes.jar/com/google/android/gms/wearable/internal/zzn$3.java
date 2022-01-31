package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;

class zzn$3
  extends zzm<CapabilityApi.AddLocalCapabilityResult>
{
  zzn$3(zzn paramzzn, GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzv(this, this.zzbTM);
  }
  
  protected CapabilityApi.AddLocalCapabilityResult zzbR(Status paramStatus)
  {
    return new zzn.zza(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.3
 * JD-Core Version:    0.7.0.1
 */
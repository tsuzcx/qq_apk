package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;

class zzn$2
  extends zzm<CapabilityApi.GetAllCapabilitiesResult>
{
  zzn$2(zzn paramzzn, GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzd(this, this.zzbTN);
  }
  
  protected CapabilityApi.GetAllCapabilitiesResult zzbQ(Status paramStatus)
  {
    return new zzn.zzd(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.2
 * JD-Core Version:    0.7.0.1
 */
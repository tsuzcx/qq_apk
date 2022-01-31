package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;

final class zzn$zzf
  extends zzm<Status>
{
  private CapabilityApi.CapabilityListener zzbTP;
  
  private zzn$zzf(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    super(paramGoogleApiClient);
    this.zzbTP = paramCapabilityListener;
  }
  
  protected final void zza(zzcx paramzzcx)
  {
    paramzzcx.zza(this, this.zzbTP);
    this.zzbTP = null;
  }
  
  public final Status zzb(Status paramStatus)
  {
    this.zzbTP = null;
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zzf
 * JD-Core Version:    0.7.0.1
 */
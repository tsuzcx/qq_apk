package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;

final class zzz
  extends zzn<Status>
{
  private CapabilityApi.CapabilityListener zzbs;
  
  private zzz(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    super(paramGoogleApiClient);
    this.zzbs = paramCapabilityListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzz
 * JD-Core Version:    0.7.0.1
 */
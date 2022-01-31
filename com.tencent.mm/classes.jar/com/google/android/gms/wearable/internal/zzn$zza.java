package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;

public class zzn$zza
  implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult
{
  private final Status zzair;
  
  public zzn$zza(Status paramStatus)
  {
    this.zzair = paramStatus;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zza
 * JD-Core Version:    0.7.0.1
 */
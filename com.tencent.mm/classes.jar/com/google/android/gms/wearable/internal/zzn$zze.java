package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;

public class zzn$zze
  implements CapabilityApi.GetCapabilityResult
{
  private final Status zzair;
  private final CapabilityInfo zzbTT;
  
  public zzn$zze(Status paramStatus, CapabilityInfo paramCapabilityInfo)
  {
    this.zzair = paramStatus;
    this.zzbTT = paramCapabilityInfo;
  }
  
  public CapabilityInfo getCapability()
  {
    return this.zzbTT;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zze
 * JD-Core Version:    0.7.0.1
 */
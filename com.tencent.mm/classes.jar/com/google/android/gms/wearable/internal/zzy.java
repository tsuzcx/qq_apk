package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;

public final class zzy
  implements CapabilityApi.GetCapabilityResult
{
  private final CapabilityInfo zzbv;
  private final Status zzp;
  
  public zzy(Status paramStatus, CapabilityInfo paramCapabilityInfo)
  {
    this.zzp = paramStatus;
    this.zzbv = paramCapabilityInfo;
  }
  
  public final CapabilityInfo getCapability()
  {
    return this.zzbv;
  }
  
  public final Status getStatus()
  {
    return this.zzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzy
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

public class zzn$zzd
  implements CapabilityApi.GetAllCapabilitiesResult
{
  private final Status zzair;
  private final Map<String, CapabilityInfo> zzbTS;
  
  public zzn$zzd(Status paramStatus, Map<String, CapabilityInfo> paramMap)
  {
    this.zzair = paramStatus;
    this.zzbTS = paramMap;
  }
  
  public Map<String, CapabilityInfo> getAllCapabilities()
  {
    return this.zzbTS;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zzd
 * JD-Core Version:    0.7.0.1
 */
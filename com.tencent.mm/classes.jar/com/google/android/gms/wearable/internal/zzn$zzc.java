package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Set;

public class zzn$zzc
  implements CapabilityInfo
{
  private final String mName;
  private final Set<Node> zzbTR;
  
  public zzn$zzc(CapabilityInfo paramCapabilityInfo)
  {
    this(paramCapabilityInfo.getName(), paramCapabilityInfo.getNodes());
  }
  
  public zzn$zzc(String paramString, Set<Node> paramSet)
  {
    this.mName = paramString;
    this.zzbTR = paramSet;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Set<Node> getNodes()
  {
    return this.zzbTR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zzc
 * JD-Core Version:    0.7.0.1
 */
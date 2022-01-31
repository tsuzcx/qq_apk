package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

public class zzcb$zzb
  implements NodeApi.GetLocalNodeResult
{
  private final Status zzair;
  private final Node zzbUQ;
  
  public zzcb$zzb(Status paramStatus, Node paramNode)
  {
    this.zzair = paramStatus;
    this.zzbUQ = paramNode;
  }
  
  public Node getNode()
  {
    return this.zzbUQ;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcb.zzb
 * JD-Core Version:    0.7.0.1
 */
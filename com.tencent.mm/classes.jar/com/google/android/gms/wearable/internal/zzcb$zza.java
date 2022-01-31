package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.List;

public class zzcb$zza
  implements NodeApi.GetConnectedNodesResult
{
  private final Status zzair;
  private final List<Node> zzbUP;
  
  public zzcb$zza(Status paramStatus, List<Node> paramList)
  {
    this.zzair = paramStatus;
    this.zzbUP = paramList;
  }
  
  public List<Node> getNodes()
  {
    return this.zzbUP;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcb.zza
 * JD-Core Version:    0.7.0.1
 */
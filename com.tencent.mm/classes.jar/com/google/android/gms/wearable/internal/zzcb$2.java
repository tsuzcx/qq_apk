package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.ArrayList;

class zzcb$2
  extends zzm<NodeApi.GetConnectedNodesResult>
{
  zzcb$2(zzcb paramzzcb, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzy(this);
  }
  
  protected NodeApi.GetConnectedNodesResult zzcc(Status paramStatus)
  {
    return new zzcb.zza(paramStatus, new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcb.2
 * JD-Core Version:    0.7.0.1
 */
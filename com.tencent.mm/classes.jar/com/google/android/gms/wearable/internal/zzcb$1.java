package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

class zzcb$1
  extends zzm<NodeApi.GetLocalNodeResult>
{
  zzcb$1(zzcb paramzzcb, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzcx paramzzcx)
  {
    paramzzcx.zzx(this);
  }
  
  protected NodeApi.GetLocalNodeResult zzcb(Status paramStatus)
  {
    return new zzcb.zzb(paramStatus, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcb.1
 * JD-Core Version:    0.7.0.1
 */
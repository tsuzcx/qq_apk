package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public final class zzcb
  implements NodeApi
{
  private static zzb.zza<NodeApi.NodeListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public final void zza(zzcx paramAnonymouszzcx, zzaad.zzb<Status> paramAnonymouszzb, NodeApi.NodeListener paramAnonymousNodeListener, zzabh<NodeApi.NodeListener> paramAnonymouszzabh)
      {
        paramAnonymouszzcx.zza(paramAnonymouszzb, paramAnonymousNodeListener, paramAnonymouszzabh, zzcb.this);
      }
    };
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, NodeApi.NodeListener paramNodeListener)
  {
    return zzb.zza(paramGoogleApiClient, zza(new IntentFilter[] { zzcv.zzip("com.google.android.gms.wearable.NODE_CHANGED") }), paramNodeListener);
  }
  
  public final PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzcb.2(this, paramGoogleApiClient));
  }
  
  public final PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zza(new zzcb.1(this, paramGoogleApiClient));
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, NodeApi.NodeListener paramNodeListener)
  {
    return paramGoogleApiClient.zza(new zzcb.4(this, paramGoogleApiClient, paramNodeListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcb
 * JD-Core Version:    0.7.0.1
 */
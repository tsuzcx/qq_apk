package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzq
  implements ChannelApi
{
  private static zzb.zza<ChannelApi.ChannelListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    return new zzq.2(paramArrayOfIntentFilter);
  }
  
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(paramChannelListener, "listener is null");
    return zzb.zza(paramGoogleApiClient, zza(new IntentFilter[] { zzcv.zzip("com.google.android.gms.wearable.CHANNEL_EVENT") }), paramChannelListener);
  }
  
  public final PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(paramString1, "nodeId is null");
    zzac.zzb(paramString2, "path is null");
    return paramGoogleApiClient.zza(new zzq.1(this, paramGoogleApiClient, paramString1, paramString2));
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzac.zzb(paramGoogleApiClient, "client is null");
    zzac.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzq.zzb(paramGoogleApiClient, paramChannelListener, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzq
 * JD-Core Version:    0.7.0.1
 */
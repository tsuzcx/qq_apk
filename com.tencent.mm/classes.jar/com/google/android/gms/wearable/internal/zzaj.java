package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaj
  implements ChannelApi
{
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(70998);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    paramGoogleApiClient = zzb.zza(paramGoogleApiClient, new zzal(new IntentFilter[] { zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT") }), paramChannelListener);
    AppMethodBeat.o(70998);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    AppMethodBeat.i(70997);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramString1, "nodeId is null");
    Preconditions.checkNotNull(paramString2, "path is null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzak(this, paramGoogleApiClient, paramString1, paramString2));
    AppMethodBeat.o(70997);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(70999);
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzan(paramGoogleApiClient, paramChannelListener, null));
    AppMethodBeat.o(70999);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaj
 * JD-Core Version:    0.7.0.1
 */
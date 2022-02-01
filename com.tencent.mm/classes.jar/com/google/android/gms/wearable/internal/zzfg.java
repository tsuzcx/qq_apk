package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfg
  implements NodeApi
{
  public final PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(101298);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzfi(this, paramGoogleApiClient));
    AppMethodBeat.o(101298);
    return paramGoogleApiClient;
  }
  
  public final PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(101297);
    paramGoogleApiClient = paramGoogleApiClient.enqueue(new zzfh(this, paramGoogleApiClient));
    AppMethodBeat.o(101297);
    return paramGoogleApiClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfg
 * JD-Core Version:    0.7.0.1
 */
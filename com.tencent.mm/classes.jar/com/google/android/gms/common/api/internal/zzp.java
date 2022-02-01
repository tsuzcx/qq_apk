package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> mApi;
  private final boolean zzfo;
  private zzq zzfp;
  
  public zzp(Api<?> paramApi, boolean paramBoolean)
  {
    this.mApi = paramApi;
    this.zzfo = paramBoolean;
  }
  
  private final void zzy()
  {
    AppMethodBeat.i(11437);
    Preconditions.checkNotNull(this.zzfp, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    AppMethodBeat.o(11437);
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(11434);
    zzy();
    this.zzfp.onConnected(paramBundle);
    AppMethodBeat.o(11434);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11436);
    zzy();
    this.zzfp.zza(paramConnectionResult, this.mApi, this.zzfo);
    AppMethodBeat.o(11436);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(11435);
    zzy();
    this.zzfp.onConnectionSuspended(paramInt);
    AppMethodBeat.o(11435);
  }
  
  public final void zza(zzq paramzzq)
  {
    this.zzfp = paramzzq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzp
 * JD-Core Version:    0.7.0.1
 */
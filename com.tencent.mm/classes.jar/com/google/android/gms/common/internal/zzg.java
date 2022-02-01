package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg
  implements BaseGmsClient.BaseOnConnectionFailedListener
{
  zzg(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11898);
    this.zzte.onConnectionFailed(paramConnectionResult);
    AppMethodBeat.o(11898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzg
 * JD-Core Version:    0.7.0.1
 */
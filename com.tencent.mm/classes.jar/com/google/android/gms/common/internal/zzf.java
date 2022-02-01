package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zzf(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(11896);
    this.zztd.onConnected(paramBundle);
    AppMethodBeat.o(11896);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(11897);
    this.zztd.onConnectionSuspended(paramInt);
    AppMethodBeat.o(11897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * JD-Core Version:    0.7.0.1
 */
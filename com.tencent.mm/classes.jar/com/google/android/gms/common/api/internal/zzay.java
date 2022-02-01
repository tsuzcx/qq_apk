package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzay
  implements GoogleApiClient.OnConnectionFailedListener
{
  zzay(zzav paramzzav, StatusPendingResult paramStatusPendingResult) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11303);
    this.zziv.setResult(new Status(8));
    AppMethodBeat.o(11303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzay
 * JD-Core Version:    0.7.0.1
 */
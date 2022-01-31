package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzax
  implements GoogleApiClient.ConnectionCallbacks
{
  zzax(zzav paramzzav, AtomicReference paramAtomicReference, StatusPendingResult paramStatusPendingResult) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(60810);
    zzav.zza(this.zzit, (GoogleApiClient)this.zziu.get(), this.zziv, true);
    AppMethodBeat.o(60810);
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzax
 * JD-Core Version:    0.7.0.1
 */
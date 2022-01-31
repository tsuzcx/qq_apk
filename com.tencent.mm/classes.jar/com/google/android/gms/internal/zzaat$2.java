package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

class zzaat$2
  implements GoogleApiClient.ConnectionCallbacks
{
  zzaat$2(zzaat paramzzaat, AtomicReference paramAtomicReference, zzabt paramzzabt) {}
  
  public void onConnected(Bundle paramBundle)
  {
    zzaat.zza(this.zzaBY, (GoogleApiClient)this.zzaBZ.get(), this.zzaCa, true);
  }
  
  public void onConnectionSuspended(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaat.2
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;

public class zzaag
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final boolean zzaAu;
  private zzaah zzaAv;
  public final Api<?> zzaxf;
  
  public zzaag(Api<?> paramApi, boolean paramBoolean)
  {
    this.zzaxf = paramApi;
    this.zzaAu = paramBoolean;
  }
  
  private void zzvL()
  {
    zzac.zzb(this.zzaAv, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public void onConnected(Bundle paramBundle)
  {
    zzvL();
    this.zzaAv.onConnected(paramBundle);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzvL();
    this.zzaAv.zza(paramConnectionResult, this.zzaxf, this.zzaAu);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzvL();
    this.zzaAv.onConnectionSuspended(paramInt);
  }
  
  public void zza(zzaah paramzzaah)
  {
    this.zzaAv = paramzzaah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaag
 * JD-Core Version:    0.7.0.1
 */
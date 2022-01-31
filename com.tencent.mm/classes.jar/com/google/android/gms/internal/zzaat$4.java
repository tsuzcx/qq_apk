package com.google.android.gms.internal;

import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

class zzaat$4
  implements ResultCallback<Status>
{
  zzaat$4(zzaat paramzzaat, zzabt paramzzabt, boolean paramBoolean, GoogleApiClient paramGoogleApiClient) {}
  
  public void zzp(Status paramStatus)
  {
    zzn.zzas(zzaat.zzc(this.zzaBY)).zzrD();
    if ((paramStatus.isSuccess()) && (this.zzaBY.isConnected())) {
      this.zzaBY.reconnect();
    }
    this.zzaCa.zzb(paramStatus);
    if (this.zzaCb) {
      this.zzapg.disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaat.4
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

final class zzbah$1
  extends Api.zza<zzbat, zzbaj>
{
  public final zzbat zza(Context paramContext, Looper paramLooper, zzg paramzzg, zzbaj paramzzbaj, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramzzbaj == null) {
      paramzzbaj = zzbaj.zzbEm;
    }
    for (;;)
    {
      return new zzbat(paramContext, paramLooper, true, paramzzg, paramzzbaj, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzbah.1
 * JD-Core Version:    0.7.0.1
 */
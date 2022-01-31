package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.wearable.internal.zzcx;

final class Wearable$1
  extends Api.zza<zzcx, Wearable.WearableOptions>
{
  public final zzcx zza(Context paramContext, Looper paramLooper, zzg paramzzg, Wearable.WearableOptions paramWearableOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramWearableOptions == null) {
      new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
    }
    return new zzcx(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable.1
 * JD-Core Version:    0.7.0.1
 */
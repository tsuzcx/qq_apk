package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzvf;

final class Auth$1
  extends Api.zza<zzvf, Auth.AuthCredentialsOptions>
{
  public final zzvf zza(Context paramContext, Looper paramLooper, zzg paramzzg, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzvf(paramContext, paramLooper, paramzzg, paramAuthCredentialsOptions, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.Auth.1
 * JD-Core Version:    0.7.0.1
 */
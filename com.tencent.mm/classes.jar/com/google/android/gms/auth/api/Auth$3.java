package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import java.util.Collections;
import java.util.List;

final class Auth$3
  extends Api.zza<zzd, GoogleSignInOptions>
{
  public final zzd zza(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzd(paramContext, paramLooper, paramzzg, paramGoogleSignInOptions, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final List<Scope> zza(GoogleSignInOptions paramGoogleSignInOptions)
  {
    if (paramGoogleSignInOptions == null) {
      return Collections.emptyList();
    }
    return paramGoogleSignInOptions.zzrj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.Auth.3
 * JD-Core Version:    0.7.0.1
 */
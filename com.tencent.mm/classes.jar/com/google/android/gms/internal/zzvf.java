package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public final class zzvf
  extends zzl<zzvl>
{
  private final Auth.AuthCredentialsOptions zzajQ;
  
  public zzvf(Context paramContext, Looper paramLooper, zzg paramzzg, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzajQ = paramAuthCredentialsOptions;
  }
  
  protected final zzvl zzaE(IBinder paramIBinder)
  {
    return zzvl.zza.zzaG(paramIBinder);
  }
  
  protected final String zzeA()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  protected final String zzez()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
  
  protected final Bundle zzqL()
  {
    if (this.zzajQ == null) {
      return new Bundle();
    }
    return this.zzajQ.zzqL();
  }
  
  final Auth.AuthCredentialsOptions zzrc()
  {
    return this.zzajQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzvf
 * JD-Core Version:    0.7.0.1
 */
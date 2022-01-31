package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzuv
  extends zzl<zzux>
{
  public zzuv(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 74, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzux zzaB(IBinder paramIBinder)
  {
    return zzux.zza.zzaD(paramIBinder);
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
  }
  
  protected String zzez()
  {
    return "com.google.android.gms.auth.api.accountactivationstate.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzuv
 * JD-Core Version:    0.7.0.1
 */
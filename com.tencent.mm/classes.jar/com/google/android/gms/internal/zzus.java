package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.account.zzb;
import com.google.android.gms.auth.account.zzb.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzus
  extends zzl<zzb>
{
  public zzus(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 120, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzb zzaA(IBinder paramIBinder)
  {
    return zzb.zza.zzaz(paramIBinder);
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.auth.account.IWorkAccountService";
  }
  
  protected String zzez()
  {
    return "com.google.android.gms.auth.account.workaccount.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzus
 * JD-Core Version:    0.7.0.1
 */
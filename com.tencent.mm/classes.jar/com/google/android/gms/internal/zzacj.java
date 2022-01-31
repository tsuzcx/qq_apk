package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzacj
  extends zzl<zzacl>
{
  public zzacj(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzacl zzbz(IBinder paramIBinder)
  {
    return zzacl.zza.zzbB(paramIBinder);
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
  
  public String zzez()
  {
    return "com.google.android.gms.common.service.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzacj
 * JD-Core Version:    0.7.0.1
 */
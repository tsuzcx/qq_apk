package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zza;
import com.google.android.gms.auth.api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import java.util.Set;

public final class zzvp
  extends zzl<zzvr>
{
  private final Bundle zzaje;
  
  public zzvp(Context paramContext, Looper paramLooper, zzg paramzzg, zzb paramzzb, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 16, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramzzb == null) {}
    for (paramContext = new Bundle();; paramContext = paramzzb.zzqU())
    {
      this.zzaje = paramContext;
      return;
    }
  }
  
  protected final zzvr zzaH(IBinder paramIBinder)
  {
    return zzvr.zza.zzaJ(paramIBinder);
  }
  
  protected final String zzeA()
  {
    return "com.google.android.gms.auth.api.internal.IAuthService";
  }
  
  protected final String zzez()
  {
    return "com.google.android.gms.auth.service.START";
  }
  
  protected final Bundle zzqL()
  {
    return this.zzaje;
  }
  
  public final boolean zzrd()
  {
    zzg localzzg = zzxW();
    return (!TextUtils.isEmpty(localzzg.getAccountName())) && (!localzzg.zzc(zza.API).isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzvp
 * JD-Core Version:    0.7.0.1
 */
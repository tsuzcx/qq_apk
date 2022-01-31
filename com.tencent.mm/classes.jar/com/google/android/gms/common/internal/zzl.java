package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Iterator;
import java.util.Set;

public abstract class zzl<T extends IInterface>
  extends zzf<T>
  implements Api.zze, zzm.zza
{
  private final zzg zzaAL;
  private final Account zzahh;
  private final Set<Scope> zzakq;
  
  public zzl(Context paramContext, Looper paramLooper, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzn.zzaU(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzg, (GoogleApiClient.ConnectionCallbacks)zzac.zzw(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzac.zzw(paramOnConnectionFailedListener));
  }
  
  protected zzl(Context paramContext, Looper paramLooper, zzn paramzzn, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramzzn, paramGoogleApiAvailability, paramInt, zza(paramConnectionCallbacks), zza(paramOnConnectionFailedListener), paramzzg.zzxP());
    this.zzaAL = paramzzg;
    this.zzahh = paramzzg.getAccount();
    this.zzakq = zzb(paramzzg.zzxM());
  }
  
  private static zzf.zzb zza(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null) {
      return null;
    }
    return new zzl.1(paramConnectionCallbacks);
  }
  
  private static zzf.zzc zza(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null) {
      return null;
    }
    return new zzl.2(paramOnConnectionFailedListener);
  }
  
  private Set<Scope> zzb(Set<Scope> paramSet)
  {
    Set localSet = zzc(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return this.zzahh;
  }
  
  protected Set<Scope> zzc(Set<Scope> paramSet)
  {
    return paramSet;
  }
  
  public zzc[] zzxA()
  {
    return new zzc[0];
  }
  
  protected final Set<Scope> zzxF()
  {
    return this.zzakq;
  }
  
  public final zzg zzxW()
  {
    return this.zzaAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * JD-Core Version:    0.7.0.1
 */
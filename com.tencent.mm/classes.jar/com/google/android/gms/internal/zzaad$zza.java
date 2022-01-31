package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;

public abstract class zzaad$zza<R extends Result, A extends Api.zzb>
  extends zzaaf<R>
  implements zzaad.zzb<R>
{
  private final Api<?> zzaxf;
  private final Api.zzc<A> zzazY;
  
  @Deprecated
  protected zzaad$zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)zzac.zzb(paramGoogleApiClient, "GoogleApiClient must not be null"));
    this.zzazY = ((Api.zzc)zzac.zzw(paramzzc));
    this.zzaxf = null;
  }
  
  public zzaad$zza(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)zzac.zzb(paramGoogleApiClient, "GoogleApiClient must not be null"));
    this.zzazY = paramApi.zzvg();
    this.zzaxf = paramApi;
  }
  
  private void zzc(RemoteException paramRemoteException)
  {
    zzB(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public final Api<?> getApi()
  {
    return this.zzaxf;
  }
  
  public final void zzB(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Failed result must not be success");
      zzb(zzc(paramStatus));
      return;
    }
  }
  
  public abstract void zza(A paramA);
  
  public final void zzb(A paramA)
  {
    try
    {
      zza(paramA);
      return;
    }
    catch (DeadObjectException paramA)
    {
      zzc(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      zzc(paramA);
    }
  }
  
  public final Api.zzc<A> zzvg()
  {
    return this.zzazY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaad.zza
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzg;

public final class zzaaj<O extends Api.ApiOptions>
  extends zzc<O>
{
  private final Api.zze zzaAJ;
  private final zzaag zzaAK;
  private final zzg zzaAL;
  private final Api.zza<? extends zzbai, zzbaj> zzazo;
  
  public zzaaj(Context paramContext, Api<O> paramApi, Looper paramLooper, Api.zze paramzze, zzaag paramzzaag, zzg paramzzg, Api.zza<? extends zzbai, zzbaj> paramzza)
  {
    super(paramContext, paramApi, paramLooper);
    this.zzaAJ = paramzze;
    this.zzaAK = paramzzaag;
    this.zzaAL = paramzzg;
    this.zzazo = paramzza;
    this.zzayX.zzb(this);
  }
  
  public final Api.zze buildApiClient(Looper paramLooper, zzaax.zza<O> paramzza)
  {
    this.zzaAK.zza(paramzza);
    return this.zzaAJ;
  }
  
  public final zzabr createSignInCoordinator(Context paramContext, Handler paramHandler)
  {
    return new zzabr(paramContext, paramHandler, this.zzaAL, this.zzazo);
  }
  
  public final Api.zze zzvU()
  {
    return this.zzaAJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaj
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

public final class Api<O extends Api.ApiOptions>
{
  private final String mName;
  private final Api.zza<?, O> zzayH;
  private final Api.zzh<?, O> zzayI;
  private final zzf<?> zzayJ;
  private final Api.zzi<?> zzayK;
  
  public <C extends Api.zze> Api(String paramString, Api.zza<C, O> paramzza, zzf<C> paramzzf)
  {
    zzac.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzac.zzb(paramzzf, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zzayH = paramzza;
    this.zzayI = null;
    this.zzayJ = paramzzf;
    this.zzayK = null;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final Api.zzd<?, O> zzve()
  {
    return this.zzayH;
  }
  
  public final Api.zza<?, O> zzvf()
  {
    if (this.zzayH != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.zzayH;
    }
  }
  
  public final Api.zzc<?> zzvg()
  {
    if (this.zzayJ != null) {
      return this.zzayJ;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public static final class zzf<C extends Api.zze>
    extends Api.zzc<C>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.Api
 * JD-Core Version:    0.7.0.1
 */
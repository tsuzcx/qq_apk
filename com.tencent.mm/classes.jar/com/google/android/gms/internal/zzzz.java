package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzaa;

public final class zzzz<O extends Api.ApiOptions>
{
  private final Api<O> zzaxf;
  private final O zzayT;
  private final boolean zzazL;
  private final int zzazM;
  
  private zzzz(Api<O> paramApi)
  {
    this.zzazL = true;
    this.zzaxf = paramApi;
    this.zzayT = null;
    this.zzazM = System.identityHashCode(this);
  }
  
  private zzzz(Api<O> paramApi, O paramO)
  {
    this.zzazL = false;
    this.zzaxf = paramApi;
    this.zzayT = paramO;
    this.zzazM = zzaa.hashCode(new Object[] { this.zzaxf, this.zzayT });
  }
  
  public static <O extends Api.ApiOptions> zzzz<O> zza(Api<O> paramApi, O paramO)
  {
    return new zzzz(paramApi, paramO);
  }
  
  public static <O extends Api.ApiOptions> zzzz<O> zzb(Api<O> paramApi)
  {
    return new zzzz(paramApi);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzzz)) {
        return false;
      }
      paramObject = (zzzz)paramObject;
    } while ((!this.zzazL) && (!paramObject.zzazL) && (zzaa.equal(this.zzaxf, paramObject.zzaxf)) && (zzaa.equal(this.zzayT, paramObject.zzayT)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzazM;
  }
  
  public final String zzvw()
  {
    return this.zzaxf.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzzz
 * JD-Core Version:    0.7.0.1
 */
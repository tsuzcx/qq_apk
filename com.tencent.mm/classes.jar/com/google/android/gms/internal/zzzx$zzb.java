package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzzx$zzb<A extends zzaad.zza<? extends Result, Api.zzb>>
  extends zzzx
{
  protected final A zzazF;
  
  public zzzx$zzb(int paramInt, A paramA)
  {
    super(paramInt);
    this.zzazF = paramA;
  }
  
  public void zza(zzaal paramzzaal, boolean paramBoolean)
  {
    paramzzaal.zza(this.zzazF, paramBoolean);
  }
  
  public void zza(zzaax.zza<?> paramzza)
  {
    this.zzazF.zzb(paramzza.zzvU());
  }
  
  public void zzz(Status paramStatus)
  {
    this.zzazF.zzB(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzzx.zzb
 * JD-Core Version:    0.7.0.1
 */
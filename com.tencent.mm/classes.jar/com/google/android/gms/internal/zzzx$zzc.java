package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zzzx$zzc
  extends zzzx.zza
{
  public final zzabm<Api.zzb, ?> zzazG;
  public final zzabz<Api.zzb, ?> zzazH;
  
  public zzzx$zzc(zzabn paramzzabn, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    this.zzazG = paramzzabn.zzazG;
    this.zzazH = paramzzabn.zzazH;
  }
  
  public final void zzb(zzaax.zza<?> paramzza)
  {
    if (this.zzazG.zzwW() != null) {
      paramzza.zzwI().put(this.zzazG.zzwW(), new zzabn(this.zzazG, this.zzazH));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzzx.zzc
 * JD-Core Version:    0.7.0.1
 */
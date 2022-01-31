package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgl
  extends zzgm<CapabilityApi.AddLocalCapabilityResult>
{
  public zzgl(BaseImplementation.ResultHolder<CapabilityApi.AddLocalCapabilityResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzf paramzzf)
  {
    AppMethodBeat.i(71373);
    zza(new zzu(zzgd.zzb(paramzzf.statusCode)));
    AppMethodBeat.o(71373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgl
 * JD-Core Version:    0.7.0.1
 */
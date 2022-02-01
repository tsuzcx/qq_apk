package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgq
  extends zzgm<CapabilityApi.GetAllCapabilitiesResult>
{
  public zzgq(BaseImplementation.ResultHolder<CapabilityApi.GetAllCapabilitiesResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzdi paramzzdi)
  {
    AppMethodBeat.i(101361);
    zza(new zzx(zzgd.zzb(paramzzdi.statusCode), zzgk.zzb(paramzzdi.zzdp)));
    AppMethodBeat.o(101361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgq
 * JD-Core Version:    0.7.0.1
 */
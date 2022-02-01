package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhd
  extends zzgm<CapabilityApi.RemoveLocalCapabilityResult>
{
  public zzhd(BaseImplementation.ResultHolder<CapabilityApi.RemoveLocalCapabilityResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzfy paramzzfy)
  {
    AppMethodBeat.i(101375);
    zza(new zzu(zzgd.zzb(paramzzfy.statusCode)));
    AppMethodBeat.o(101375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhd
 * JD-Core Version:    0.7.0.1
 */
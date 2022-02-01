package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgr
  extends zzgm<CapabilityApi.GetCapabilityResult>
{
  public zzgr(BaseImplementation.ResultHolder<CapabilityApi.GetCapabilityResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzdk paramzzdk)
  {
    AppMethodBeat.i(101362);
    Status localStatus = zzgd.zzb(paramzzdk.statusCode);
    if (paramzzdk.zzdq == null) {}
    for (paramzzdk = null;; paramzzdk = new zzw(paramzzdk.zzdq))
    {
      zza(new zzy(localStatus, paramzzdk));
      AppMethodBeat.o(101362);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgr
 * JD-Core Version:    0.7.0.1
 */
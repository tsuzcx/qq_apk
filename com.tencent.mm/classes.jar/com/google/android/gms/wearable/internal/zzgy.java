package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgy
  extends zzgm<NodeApi.GetLocalNodeResult>
{
  public zzgy(BaseImplementation.ResultHolder<NodeApi.GetLocalNodeResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzeg paramzzeg)
  {
    AppMethodBeat.i(71388);
    zza(new zzfk(zzgd.zzb(paramzzeg.statusCode), paramzzeg.zzea));
    AppMethodBeat.o(71388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgy
 * JD-Core Version:    0.7.0.1
 */
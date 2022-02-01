package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzha
  extends zzgm<ChannelApi.OpenChannelResult>
{
  public zzha(BaseImplementation.ResultHolder<ChannelApi.OpenChannelResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzfq paramzzfq)
  {
    AppMethodBeat.i(101372);
    zza(new zzam(zzgd.zzb(paramzzfq.statusCode), paramzzfq.zzck));
    AppMethodBeat.o(101372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzha
 * JD-Core Version:    0.7.0.1
 */
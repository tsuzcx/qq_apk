package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgv
  extends zzgm<DataApi.DataItemResult>
{
  public zzgv(BaseImplementation.ResultHolder<DataApi.DataItemResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzec paramzzec)
  {
    AppMethodBeat.i(101368);
    zza(new zzcg(zzgd.zzb(paramzzec.statusCode), paramzzec.zzdy));
    AppMethodBeat.o(101368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgv
 * JD-Core Version:    0.7.0.1
 */
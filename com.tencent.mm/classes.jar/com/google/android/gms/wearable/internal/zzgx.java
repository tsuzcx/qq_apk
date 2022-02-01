package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgx
  extends zzgm<DataApi.GetFdForAssetResult>
{
  public zzgx(BaseImplementation.ResultHolder<DataApi.GetFdForAssetResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzee paramzzee)
  {
    AppMethodBeat.i(101370);
    zza(new zzci(zzgd.zzb(paramzzee.statusCode), paramzzee.zzdz));
    AppMethodBeat.o(101370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgx
 * JD-Core Version:    0.7.0.1
 */
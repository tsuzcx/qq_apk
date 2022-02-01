package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgp
  extends zzgm<DataApi.DeleteDataItemsResult>
{
  public zzgp(BaseImplementation.ResultHolder<DataApi.DeleteDataItemsResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzdg paramzzdg)
  {
    AppMethodBeat.i(101360);
    zza(new zzch(zzgd.zzb(paramzzdg.statusCode), paramzzdg.zzdh));
    AppMethodBeat.o(101360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgp
 * JD-Core Version:    0.7.0.1
 */
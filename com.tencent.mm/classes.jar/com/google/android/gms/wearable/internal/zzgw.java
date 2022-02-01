package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgw
  extends zzgm<DataItemBuffer>
{
  public zzgw(BaseImplementation.ResultHolder<DataItemBuffer> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zzb(DataHolder paramDataHolder)
  {
    AppMethodBeat.i(101369);
    zza(new DataItemBuffer(paramDataHolder));
    AppMethodBeat.o(101369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgw
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzhb
  extends zzgm<DataApi.DataItemResult>
{
  private final List<FutureTask<Boolean>> zzev;
  
  zzhb(BaseImplementation.ResultHolder<DataApi.DataItemResult> paramResultHolder, List<FutureTask<Boolean>> paramList)
  {
    super(paramResultHolder);
    this.zzev = paramList;
  }
  
  public final void zza(zzfu paramzzfu)
  {
    AppMethodBeat.i(101373);
    zza(new zzcg(zzgd.zzb(paramzzfu.statusCode), paramzzfu.zzdy));
    if (paramzzfu.statusCode != 0)
    {
      paramzzfu = this.zzev.iterator();
      while (paramzzfu.hasNext()) {
        ((FutureTask)paramzzfu.next()).cancel(true);
      }
    }
    AppMethodBeat.o(101373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhb
 * JD-Core Version:    0.7.0.1
 */
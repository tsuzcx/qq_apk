package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class zzgu
  extends zzgm<NodeApi.GetConnectedNodesResult>
{
  public zzgu(BaseImplementation.ResultHolder<NodeApi.GetConnectedNodesResult> paramResultHolder)
  {
    super(paramResultHolder);
  }
  
  public final void zza(zzea paramzzea)
  {
    AppMethodBeat.i(71384);
    ArrayList localArrayList = new ArrayList();
    if (paramzzea.zzdx != null) {
      localArrayList.addAll(paramzzea.zzdx);
    }
    zza(new zzfj(zzgd.zzb(paramzzea.statusCode), localArrayList));
    AppMethodBeat.o(71384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgu
 * JD-Core Version:    0.7.0.1
 */
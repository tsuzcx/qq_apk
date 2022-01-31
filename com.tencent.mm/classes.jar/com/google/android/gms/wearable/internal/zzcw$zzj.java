package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.ArrayList;
import java.util.List;

final class zzcw$zzj
  extends zzcw.zzb<NodeApi.GetConnectedNodesResult>
{
  public zzcw$zzj(zzaad.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
  {
    super(paramzzb);
  }
  
  public final void zza(zzbl paramzzbl)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramzzbl.zzbUF);
    zzaa(new zzcb.zza(zzcr.zzik(paramzzbl.statusCode), localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw.zzj
 * JD-Core Version:    0.7.0.1
 */
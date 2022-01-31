package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzaad.zzb;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzcw
{
  private static Map<String, CapabilityInfo> zzS(List<zzo> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size() * 2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzo localzzo = (zzo)paramList.next();
      localHashMap.put(localzzo.getName(), new zzn.zzc(localzzo));
    }
    return localHashMap;
  }
  
  static final class zzn
    extends zzcw.zzb<NodeApi.GetLocalNodeResult>
  {
    public zzn(zzaad.zzb<NodeApi.GetLocalNodeResult> paramzzb)
    {
      super();
    }
    
    public final void zza(zzbr paramzzbr)
    {
      zzaa(new zzcb.zzb(zzcr.zzik(paramzzbr.statusCode), paramzzbr.zzbUH));
    }
  }
  
  static final class zzp
    extends zzcw.zzb<ChannelApi.OpenChannelResult>
  {
    public zzp(zzaad.zzb<ChannelApi.OpenChannelResult> paramzzb)
    {
      super();
    }
    
    public final void zza(zzce paramzzce)
    {
      zzaa(new zzq.zza(zzcr.zzik(paramzzce.statusCode), paramzzce.zzbUa));
    }
  }
  
  static final class zzq
    extends zzcw.zzb<DataApi.DataItemResult>
  {
    private final List<FutureTask<Boolean>> zzIz;
    
    zzq(zzaad.zzb<DataApi.DataItemResult> paramzzb, List<FutureTask<Boolean>> paramList)
    {
      super();
      this.zzIz = paramList;
    }
    
    public final void zza(zzci paramzzci)
    {
      zzaa(new zzah.zza(zzcr.zzik(paramzzci.statusCode), paramzzci.zzbUG));
      if (paramzzci.statusCode != 0)
      {
        paramzzci = this.zzIz.iterator();
        while (paramzzci.hasNext()) {
          ((FutureTask)paramzzci.next()).cancel(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcw
 * JD-Core Version:    0.7.0.1
 */
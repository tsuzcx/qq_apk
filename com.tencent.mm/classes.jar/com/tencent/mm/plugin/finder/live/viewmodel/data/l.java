package com.tencent.mm.plugin.finder.live.viewmodel.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LiveHistoryManager;", "", "()V", "STAY_MAX_COUNT", "", "getSTAY_MAX_COUNT", "()I", "STAY_TIME", "getSTAY_TIME", "TAG", "", "historiesList", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/LinkedHashMap;", "preInHistoryLive", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LiveHistoryManager$PreInHistory;", "abandonCurrentLive", "", "getHistories", "", "reportCurrentLive", "live", "isHistoryLive", "", "PreInHistory", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l EbO;
  private static final LinkedHashMap<Long, f> EbP;
  private static a EbQ;
  
  static
  {
    AppMethodBeat.i(356877);
    EbO = new l();
    EbP = new LinkedHashMap();
    AppMethodBeat.o(356877);
  }
  
  public static void a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(356866);
    Object localObject2 = new StringBuilder("#reportCurrentLive liveId:");
    if (paramf == null)
    {
      localObject1 = null;
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" name:");
      if (paramf != null) {
        break label450;
      }
      localObject1 = null;
      label44:
      Log.i("LiveHistoryManager", localObject1 + " isHistoryLive:" + paramBoolean + '}');
      if (paramf != null) {
        break label477;
      }
      localObject1 = null;
      label80:
      localObject2 = EbQ;
      if (localObject2 != null) {
        break label507;
      }
      localObject2 = null;
      label93:
      if (s.p(localObject1, localObject2)) {
        Log.i("LiveHistoryManager", "reportCurrentLive is equal. return");
      }
      localObject1 = EbQ;
      if (localObject1 == null) {
        break label546;
      }
      l = System.currentTimeMillis() - ((a)localObject1).EbR;
      localObject2 = a.ahiX;
      if (l <= ((Number)a.jTW().bmg()).intValue() * 1000) {
        break label541;
      }
    }
    label541:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("LiveHistoryManager", "#reportCurrentLive pre live liveId:" + ((a)localObject1).EbS.Ebr.liveId + " name:" + ((a)localObject1).EbS.Ebr.mIU + " stayTime:" + l + " toHistory=" + paramBoolean);
      if (!paramBoolean) {
        break label546;
      }
      EbP.remove(Long.valueOf(((a)localObject1).EbS.Ebr.liveId));
      ((Map)EbP).put(Long.valueOf(((a)localObject1).EbS.Ebr.liveId), ((a)localObject1).EbS);
      localObject1 = ((Map)EbP).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        int i = EbP.size();
        a locala = a.ahiX;
        int j = ((Number)a.jTX().bmg()).intValue();
        if (i <= j) {
          break;
        }
        Log.i("LiveHistoryManager", "#reportCurrentLive historiesList.size=" + i + ", max=" + j + ". remove " + ((f)((Map.Entry)localObject2).getValue()).Ebr.mIU);
        ((Iterator)localObject1).remove();
      }
      localObject1 = paramf.Ebr;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((LiveConfig)localObject1).liveId);
      break;
      label450:
      localObject1 = paramf.Ebr;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label44;
      }
      localObject1 = ((LiveConfig)localObject1).mIU;
      break label44;
      label477:
      localObject1 = paramf.Ebr;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label80;
      }
      localObject1 = Long.valueOf(((LiveConfig)localObject1).liveId);
      break label80;
      label507:
      localObject2 = ((a)localObject2).EbS.Ebr;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label93;
      }
      localObject2 = Long.valueOf(((LiveConfig)localObject2).liveId);
      break label93;
    }
    label546:
    EbQ = null;
    Log.i("LiveHistoryManager", s.X("#reportCurrentLive finally histories size: ", Integer.valueOf(EbP.size())));
    if (paramf == null)
    {
      AppMethodBeat.o(356866);
      return;
    }
    long l = System.currentTimeMillis();
    paramf = new f(paramf.Ebr);
    paramf.Ebu = true;
    Object localObject1 = ah.aiuX;
    EbQ = new a(l, paramf);
    AppMethodBeat.o(356866);
  }
  
  public static List<f> eyc()
  {
    AppMethodBeat.i(356844);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(EbP.values());
    localObject = (List)localObject;
    AppMethodBeat.o(356844);
    return localObject;
  }
  
  public static void eyd()
  {
    EbQ = null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LiveHistoryManager$PreInHistory;", "", "comeInTime", "", "live", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "(JLcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "getComeInTime", "()J", "getLive", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final long EbR;
    final f EbS;
    
    public a(long paramLong, f paramf)
    {
      AppMethodBeat.i(356831);
      this.EbR = paramLong;
      this.EbS = paramf;
      AppMethodBeat.o(356831);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(356855);
      if (this == paramObject)
      {
        AppMethodBeat.o(356855);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(356855);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.EbR != paramObject.EbR)
      {
        AppMethodBeat.o(356855);
        return false;
      }
      if (!s.p(this.EbS, paramObject.EbS))
      {
        AppMethodBeat.o(356855);
        return false;
      }
      AppMethodBeat.o(356855);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(356847);
      int i = q.a..ExternalSyntheticBackport0.m(this.EbR);
      int j = this.EbS.hashCode();
      AppMethodBeat.o(356847);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(356837);
      String str = "PreInHistory(comeInTime=" + this.EbR + ", live=" + this.EbS + ')';
      AppMethodBeat.o(356837);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.l
 * JD-Core Version:    0.7.0.1
 */
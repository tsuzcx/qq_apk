package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/IReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "()V", "isWatch", "", "objAllocateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "watchedLogId", "calc", "", "getObjHashCode", "", "obj", "", "getRecord", "logId", "isBlock", "onAllocate", "record", "onRelease", "printBriefLog", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "prefixLog", "startWatch", "stopWatch", "vertify", "Companion", "ReportRecord", "plugin-finder_release"})
public final class b
  implements ae<t>
{
  public static final a zTP;
  private boolean zTM;
  private int zTN;
  private final ConcurrentHashMap<Integer, List<b>> zTO;
  
  static
  {
    AppMethodBeat.i(274200);
    zTP = new a((byte)0);
    AppMethodBeat.o(274200);
  }
  
  public b()
  {
    AppMethodBeat.i(274198);
    this.zTO = new ConcurrentHashMap();
    AppMethodBeat.o(274198);
  }
  
  private final boolean Pc(int paramInt)
  {
    return (!this.zTM) && ((this.zTN == 0) || (this.zTN != paramInt));
  }
  
  private final List<b> dPb()
  {
    AppMethodBeat.i(274195);
    List localList2 = (List)this.zTO.get(Integer.valueOf(18054));
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = (List)new ArrayList();
      ((Map)this.zTO).put(Integer.valueOf(18054), localList1);
    }
    AppMethodBeat.o(274195);
    return localList1;
  }
  
  static String dq(Object paramObject)
  {
    AppMethodBeat.i(274196);
    n localn = n.zWF;
    paramObject = n.Mp(paramObject.hashCode());
    AppMethodBeat.o(274196);
    return paramObject;
  }
  
  public final void a(bu parambu, String paramString, t paramt)
  {
    AppMethodBeat.i(274192);
    p.k(paramString, "prefixLog");
    p.k(paramt, "record");
    if (Pc(0))
    {
      AppMethodBeat.o(274192);
      return;
    }
    if ((parambu instanceof BaseFinderFeed))
    {
      parambu = (BaseFinderFeed)parambu;
      Object localObject = n.zWF;
      String str = n.Mp(parambu.mf());
      parambu = parambu.contact;
      if (parambu != null)
      {
        localObject = parambu.field_nickname;
        parambu = (bu)localObject;
        if (localObject != null) {}
      }
      else
      {
        parambu = "";
      }
      Log.i("FeedReportWatcher", paramString + " --- nickName:" + parambu + " feedId:" + str + "        record obj:" + dq(paramt));
    }
    AppMethodBeat.o(274192);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(274193);
    if (Pc(18054))
    {
      AppMethodBeat.o(274193);
      return;
    }
    Object localObject = new StringBuilder("feedId:");
    n localn = n.zWF;
    localObject = n.Mp(paramt.feedId) + "  obj:" + dq(paramt);
    paramt = new b(paramt.hashCode(), (String)localObject);
    dPb().add(paramt);
    AppMethodBeat.o(274193);
  }
  
  public final void b(t paramt)
  {
    AppMethodBeat.i(274194);
    if (Pc(18054))
    {
      AppMethodBeat.o(274194);
      return;
    }
    if (paramt != null)
    {
      Object localObject1 = (Iterable)dPb();
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      int i;
      label109:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b)localObject2).zTQ == paramt.hashCode()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label109;
          }
          localCollection.add(localObject2);
          break;
        }
      }
      paramt = (List)localCollection;
      if (!((Collection)paramt).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label169;
        }
        label134:
        if (paramt == null) {
          break label174;
        }
      }
      label169:
      label174:
      for (paramt = (b)paramt.get(0);; paramt = null)
      {
        if (paramt == null) {
          break label179;
        }
        paramt.isReleased = true;
        AppMethodBeat.o(274194);
        return;
        i = 0;
        break;
        paramt = null;
        break label134;
      }
      label179:
      AppMethodBeat.o(274194);
      return;
    }
    AppMethodBeat.o(274194);
  }
  
  public final void dOZ()
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.zTM = bool;
      this.zTN = 0;
      return;
    }
  }
  
  public final void dPa()
  {
    AppMethodBeat.i(274191);
    if (!Pc(0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)this.zTO).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        int j = ((Number)((Map.Entry)localObject2).getKey()).intValue();
        ((Map.Entry)localObject2).getValue();
        int i = ((List)((Map.Entry)localObject2).getValue()).size();
        Object localObject3 = (Iterable)((Map.Entry)localObject2).getValue();
        Object localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((b)localObject4).isReleased) {
            ((Collection)localObject1).add(localObject4);
          }
        }
        int k = ((List)localObject1).size();
        int m = i - k;
        localObject1 = "logId:" + j + " -- allocateCount:" + i + " releasedCount:" + k + " unReleaseCount:" + m;
        if (m > 0)
        {
          localObject3 = (Iterable)((Map.Entry)localObject2).getValue();
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          label334:
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if (!((b)localObject4).isReleased) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label334;
              }
              ((Collection)localObject2).add(localObject4);
              break;
            }
          }
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (b)((Iterator)localObject2).next();
            Log.w("FeedReportWatcher", "not released logId:" + j + " -- " + ((b)localObject3).zTR);
          }
        }
        localStringBuilder.append((String)localObject1 + "\n");
      }
      Log.i("FeedReportWatcher", dq(this) + " calc result:\n" + localStringBuilder);
      this.zTO.clear();
      this.zTM = false;
    }
    AppMethodBeat.o(274191);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "", "objHashCode", "", "isReleased", "", "simpleDesc", "", "complexDesc", "(IZLjava/lang/String;Ljava/lang/String;)V", "getComplexDesc", "()Ljava/lang/String;", "setComplexDesc", "(Ljava/lang/String;)V", "()Z", "setReleased", "(Z)V", "getObjHashCode", "()I", "setObjHashCode", "(I)V", "getSimpleDesc", "setSimpleDesc", "plugin-finder_release"})
  public static final class b
  {
    boolean isReleased;
    int zTQ;
    String zTR;
    private String zTS;
    
    private b(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(285546);
      this.zTQ = paramInt;
      this.isReleased = false;
      this.zTR = paramString1;
      this.zTS = paramString2;
      AppMethodBeat.o(285546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */
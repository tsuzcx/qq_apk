package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/IReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "()V", "isWatch", "", "objAllocateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "watchedLogId", "calc", "", "getObjHashCode", "", "obj", "", "getRecord", "logId", "isBlock", "onAllocate", "record", "onRelease", "printBriefLog", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "prefixLog", "startWatch", "stopWatch", "vertify", "Companion", "ReportRecord", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements as<af>
{
  public static final a Fnu;
  private boolean Fnv;
  private int Fnw;
  private final ConcurrentHashMap<Integer, List<b>> Fnx;
  
  static
  {
    AppMethodBeat.i(331429);
    Fnu = new a((byte)0);
    AppMethodBeat.o(331429);
  }
  
  public b()
  {
    AppMethodBeat.i(331380);
    this.Fnx = new ConcurrentHashMap();
    AppMethodBeat.o(331380);
  }
  
  private final boolean Sd(int paramInt)
  {
    return (!this.Fnv) && ((this.Fnw == 0) || (this.Fnw != paramInt));
  }
  
  private final List<b> eMh()
  {
    AppMethodBeat.i(331393);
    List localList2 = (List)this.Fnx.get(Integer.valueOf(18054));
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = (List)new ArrayList();
      ((Map)this.Fnx).put(Integer.valueOf(18054), localList1);
    }
    AppMethodBeat.o(331393);
    return localList1;
  }
  
  static String fA(Object paramObject)
  {
    AppMethodBeat.i(331402);
    z localz = z.FrZ;
    paramObject = z.pL(paramObject.hashCode());
    AppMethodBeat.o(331402);
    return paramObject;
  }
  
  public final void a(cc paramcc, String paramString, af paramaf)
  {
    AppMethodBeat.i(331461);
    s.u(paramString, "prefixLog");
    s.u(paramaf, "record");
    if (Sd(0))
    {
      AppMethodBeat.o(331461);
      return;
    }
    Object localObject;
    String str;
    if ((paramcc instanceof BaseFinderFeed))
    {
      paramcc = (BaseFinderFeed)paramcc;
      localObject = z.FrZ;
      str = z.pL(paramcc.bZA());
      paramcc = paramcc.contact;
      if (paramcc != null) {
        break label125;
      }
      paramcc = "";
    }
    for (;;)
    {
      Log.i("FeedReportWatcher", paramString + " --- nickName:" + paramcc + " feedId:" + str + "        record obj:" + fA(paramaf));
      AppMethodBeat.o(331461);
      return;
      label125:
      localObject = paramcc.field_nickname;
      paramcc = (cc)localObject;
      if (localObject == null) {
        paramcc = "";
      }
    }
  }
  
  public final void a(af paramaf)
  {
    AppMethodBeat.i(331470);
    if (Sd(18054))
    {
      AppMethodBeat.o(331470);
      return;
    }
    Object localObject = new StringBuilder("feedId:");
    z localz = z.FrZ;
    localObject = z.pL(paramaf.feedId) + "  obj:" + fA(paramaf);
    paramaf = new b(paramaf.hashCode(), (String)localObject);
    eMh().add(paramaf);
    AppMethodBeat.o(331470);
  }
  
  public final void b(af paramaf)
  {
    AppMethodBeat.i(331483);
    if (Sd(18054))
    {
      AppMethodBeat.o(331483);
      return;
    }
    int i;
    if (paramaf != null)
    {
      Object localObject1 = (Iterable)eMh();
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label109:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b)localObject2).Fny == paramaf.hashCode()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label109;
          }
          localCollection.add(localObject2);
          break;
        }
      }
      paramaf = (List)localCollection;
      if (((Collection)paramaf).isEmpty()) {
        break label155;
      }
      i = 1;
      if (i == 0) {
        break label160;
      }
      label134:
      if (paramaf != null) {
        break label165;
      }
    }
    label155:
    label160:
    label165:
    for (paramaf = null;; paramaf = (b)paramaf.get(0))
    {
      if (paramaf != null) {
        paramaf.isReleased = true;
      }
      AppMethodBeat.o(331483);
      return;
      i = 0;
      break;
      paramaf = null;
      break label134;
    }
  }
  
  public final void eMf()
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fnv = bool;
      this.Fnw = 0;
      return;
    }
  }
  
  public final void eMg()
  {
    AppMethodBeat.i(331446);
    if (!Sd(0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)this.Fnx).entrySet().iterator();
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
            Log.w("FeedReportWatcher", "not released logId:" + j + " -- " + ((b)localObject3).Fnz);
          }
        }
        localStringBuilder.append(s.X((String)localObject1, "\n"));
      }
      Log.i("FeedReportWatcher", fA(this) + " calc result:\n" + localStringBuilder);
      this.Fnx.clear();
      this.Fnv = false;
    }
    AppMethodBeat.o(331446);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "", "objHashCode", "", "isReleased", "", "simpleDesc", "", "complexDesc", "(IZLjava/lang/String;Ljava/lang/String;)V", "getComplexDesc", "()Ljava/lang/String;", "setComplexDesc", "(Ljava/lang/String;)V", "()Z", "setReleased", "(Z)V", "getObjHashCode", "()I", "setObjHashCode", "(I)V", "getSimpleDesc", "setSimpleDesc", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private String FnA;
    int Fny;
    String Fnz;
    boolean isReleased;
    
    private b(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(331036);
      this.Fny = paramInt;
      this.isReleased = false;
      this.Fnz = paramString1;
      this.FnA = paramString2;
      AppMethodBeat.o(331036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */
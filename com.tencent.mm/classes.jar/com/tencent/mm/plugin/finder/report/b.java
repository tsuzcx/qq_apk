package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/IReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "()V", "isWatch", "", "objAllocateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "watchedLogId", "calc", "", "getObjHashCode", "", "obj", "", "getRecord", "logId", "isBlock", "onAllocate", "record", "onRelease", "printBriefLog", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "prefixLog", "startWatch", "stopWatch", "vertify", "Companion", "ReportRecord", "plugin-finder_release"})
public final class b
  implements aa<p>
{
  public static final a vcY;
  private boolean vcV;
  private int vcW;
  private final ConcurrentHashMap<Integer, List<b>> vcX;
  
  static
  {
    AppMethodBeat.i(250516);
    vcY = new a((byte)0);
    AppMethodBeat.o(250516);
  }
  
  public b()
  {
    AppMethodBeat.i(250515);
    this.vcX = new ConcurrentHashMap();
    AppMethodBeat.o(250515);
  }
  
  private final boolean Kb(int paramInt)
  {
    return (!this.vcV) && ((this.vcW == 0) || (this.vcW != paramInt));
  }
  
  static String dl(Object paramObject)
  {
    AppMethodBeat.i(250513);
    k localk = k.vfA;
    paramObject = k.Fg(paramObject.hashCode());
    AppMethodBeat.o(250513);
    return paramObject;
  }
  
  private final List<b> dnE()
  {
    AppMethodBeat.i(250512);
    List localList2 = (List)this.vcX.get(Integer.valueOf(18054));
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = (List)new ArrayList();
      ((Map)this.vcX).put(Integer.valueOf(18054), localList1);
    }
    AppMethodBeat.o(250512);
    return localList1;
  }
  
  public final void a(bo parambo, String paramString, p paramp)
  {
    AppMethodBeat.i(250509);
    kotlin.g.b.p.h(paramString, "prefixLog");
    kotlin.g.b.p.h(paramp, "record");
    if (Kb(0))
    {
      AppMethodBeat.o(250509);
      return;
    }
    if ((parambo instanceof BaseFinderFeed))
    {
      parambo = (BaseFinderFeed)parambo;
      Object localObject = k.vfA;
      String str = k.Fg(parambo.lT());
      parambo = parambo.contact;
      if (parambo != null)
      {
        localObject = parambo.field_nickname;
        parambo = (bo)localObject;
        if (localObject != null) {}
      }
      else
      {
        parambo = "";
      }
      Log.i("FeedReportWatcher", paramString + " --- nickName:" + parambo + " feedId:" + str + "        record obj:" + dl(paramp));
    }
    AppMethodBeat.o(250509);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(250510);
    if (Kb(18054))
    {
      AppMethodBeat.o(250510);
      return;
    }
    Object localObject = new StringBuilder("feedId:");
    k localk = k.vfA;
    localObject = k.Fg(paramp.feedId) + "  obj:" + dl(paramp);
    paramp = new b(paramp.hashCode(), (String)localObject);
    dnE().add(paramp);
    AppMethodBeat.o(250510);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(250511);
    if (Kb(18054))
    {
      AppMethodBeat.o(250511);
      return;
    }
    if (paramp != null)
    {
      Object localObject1 = (Iterable)dnE();
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      int i;
      label109:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b)localObject2).vcZ == paramp.hashCode()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label109;
          }
          localCollection.add(localObject2);
          break;
        }
      }
      paramp = (List)localCollection;
      if (!((Collection)paramp).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label169;
        }
        label134:
        if (paramp == null) {
          break label174;
        }
      }
      label169:
      label174:
      for (paramp = (b)paramp.get(0);; paramp = null)
      {
        if (paramp == null) {
          break label179;
        }
        paramp.isReleased = true;
        AppMethodBeat.o(250511);
        return;
        i = 0;
        break;
        paramp = null;
        break label134;
      }
      label179:
      AppMethodBeat.o(250511);
      return;
    }
    AppMethodBeat.o(250511);
  }
  
  public final void dnC()
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.vcV = bool;
      this.vcW = 0;
      return;
    }
  }
  
  public final void dnD()
  {
    AppMethodBeat.i(250508);
    if (!Kb(0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)this.vcX).entrySet().iterator();
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
            Log.w("FeedReportWatcher", "not released logId:" + j + " -- " + ((b)localObject3).vda);
          }
        }
        localStringBuilder.append((String)localObject1 + "\n");
      }
      Log.i("FeedReportWatcher", dl(this) + " calc result:\n" + localStringBuilder);
      this.vcX.clear();
      this.vcV = false;
    }
    AppMethodBeat.o(250508);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "", "objHashCode", "", "isReleased", "", "simpleDesc", "", "complexDesc", "(IZLjava/lang/String;Ljava/lang/String;)V", "getComplexDesc", "()Ljava/lang/String;", "setComplexDesc", "(Ljava/lang/String;)V", "()Z", "setReleased", "(Z)V", "getObjHashCode", "()I", "setObjHashCode", "(I)V", "getSimpleDesc", "setSimpleDesc", "plugin-finder_release"})
  public static final class b
  {
    boolean isReleased;
    int vcZ;
    String vda;
    private String vdb;
    
    private b(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(250506);
      this.vcZ = paramInt;
      this.isReleased = false;
      this.vda = paramString1;
      this.vdb = paramString2;
      AppMethodBeat.o(250506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */
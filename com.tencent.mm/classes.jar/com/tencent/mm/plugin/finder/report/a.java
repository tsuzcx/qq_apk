package com.tencent.mm.plugin.finder.report;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "ID", "", "()V", "browserExposeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "clickChatExposeMap", "clickExposeSet", "", "curBrowseExposeSet", "diffDataListener", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "isStatistic", "", "statisticCondition", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "threadName", "", "copySet", "", "src", "", "dst", "getExposeContainer", "type", "getExposePv", "", "getExposeSet", "getExposeUV", "getMapContainer", "incExpose", "id", "(Ljava/lang/Object;I)V", "isIdLegal", "(Ljava/lang/Object;)Z", "isShouldExecute", "onDiffData", "diffData", "record", "exposedSet", "curSet", "idSet", "setOnDiffDataListener", "setStatisticCondition", "startStatistic", "stopStatistic", "Companion", "plugin-finder_release"})
public final class a<ID>
{
  private static final String TAG = "Finder.ExposeStatisticUtil";
  public static final a vcS;
  private final String threadName;
  volatile boolean vcL;
  public z<ID> vcM;
  ab<ID> vcN;
  private final Set<ID> vcO;
  private final ConcurrentHashMap<ID, Integer> vcP;
  private final Set<ID> vcQ;
  private final ConcurrentHashMap<ID, Integer> vcR;
  
  static
  {
    AppMethodBeat.i(250505);
    vcS = new a((byte)0);
    TAG = "Finder.ExposeStatisticUtil";
    AppMethodBeat.o(250505);
  }
  
  public a()
  {
    AppMethodBeat.i(250504);
    this.threadName = "ExposeStatisticUtil";
    this.vcO = ((Set)new HashSet());
    this.vcP = new ConcurrentHashMap();
    this.vcQ = ((Set)new HashSet());
    this.vcR = new ConcurrentHashMap();
    AppMethodBeat.o(250504);
  }
  
  private final void a(Set<? extends ID> paramSet1, Set<? extends ID> paramSet2)
  {
    AppMethodBeat.i(250503);
    if (!this.vcL)
    {
      AppMethodBeat.o(250503);
      return;
    }
    Object localObject1 = ak.a(paramSet2, (Iterable)paramSet1);
    paramSet1 = this.vcO;
    paramSet1.clear();
    paramSet2 = ((Iterable)paramSet2).iterator();
    while (paramSet2.hasNext()) {
      paramSet1.add(paramSet2.next());
    }
    Object localObject2;
    label130:
    int i;
    if ((localObject1 == null) || (((Set)localObject1).isEmpty()))
    {
      paramSet2 = TAG;
      localObject2 = new StringBuilder("newExposeRecords").append(localObject1).append("，size:");
      if (localObject1 == null) {
        break label313;
      }
      paramSet1 = Integer.valueOf(((Set)localObject1).size());
      Log.i(paramSet2, paramSet1 + ')');
      if (localObject1 == null) {
        break label323;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label318;
      }
      i = 1;
      label168:
      if (i != 1) {
        break label394;
      }
      paramSet1 = ((Iterable)localObject1).iterator();
    }
    for (;;)
    {
      label184:
      if (!paramSet1.hasNext()) {
        break label394;
      }
      paramSet2 = paramSet1.next();
      if ((paramSet2 instanceof Integer)) {
        if (((Number)paramSet2).intValue() >= 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label373;
        }
        localObject1 = this.vcP;
        if (!((ConcurrentHashMap)localObject1).keySet().contains(paramSet2)) {
          break label375;
        }
        localObject2 = (Integer)((ConcurrentHashMap)localObject1).get(paramSet2);
        if (localObject2 == null) {
          break label184;
        }
        ((Map)localObject1).put(paramSet2, Integer.valueOf(((Integer)localObject2).intValue() + 1));
        break label184;
        h.RTc.b((Runnable)new b(this, (Set)localObject1), this.threadName);
        break;
        label313:
        paramSet1 = null;
        break label130;
        label318:
        i = 0;
        break label168;
        label323:
        AppMethodBeat.o(250503);
        return;
        i = 0;
        continue;
        if ((paramSet2 instanceof String))
        {
          if (!Util.isNullOrNil((String)paramSet2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else if (paramSet2 != null) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label373:
      continue;
      label375:
      ((Map)localObject1).put(paramSet2, Integer.valueOf(1));
    }
    label394:
    AppMethodBeat.o(250503);
  }
  
  public final void m(Set<? extends ID> paramSet)
  {
    AppMethodBeat.i(250502);
    Object localObject1 = (Iterable)paramSet;
    paramSet = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label78:
    label105:
    label108:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      boolean bool;
      if (this.vcL)
      {
        ab localab = this.vcN;
        if (localab != null)
        {
          bool = localab.dm(localObject2);
          if (!bool) {
            break label105;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label108;
        }
        paramSet.add(localObject2);
        break;
        bool = true;
        break label78;
      }
    }
    paramSet = (List)paramSet;
    a(this.vcO, j.r((Iterable)paramSet));
    AppMethodBeat.o(250502);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_EXPOSE_BROWSE", "", "TYPE_EXPOSE_CLICK", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ID", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, Set paramSet) {}
    
    public final void run()
    {
      AppMethodBeat.i(250501);
      z localz = a.a(this.vcT);
      if (localz != null)
      {
        localz.doO();
        AppMethodBeat.o(250501);
        return;
      }
      AppMethodBeat.o(250501);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */
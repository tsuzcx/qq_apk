package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "ID", "", "()V", "browserExposeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "clickChatExposeMap", "clickExposeSet", "", "curBrowseExposeSet", "diffDataListener", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "isStatistic", "", "statisticCondition", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "threadName", "", "copySet", "", "src", "", "dst", "getExposeContainer", "type", "getExposePv", "", "getExposeSet", "getExposeUV", "getMapContainer", "incExpose", "id", "(Ljava/lang/Object;I)V", "isIdLegal", "(Ljava/lang/Object;)Z", "isShouldExecute", "onDiffData", "diffData", "record", "exposedSet", "curSet", "idSet", "setOnDiffDataListener", "setStatisticCondition", "startStatistic", "stopStatistic", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<ID>
{
  public static final a Fnm;
  private static final String TAG;
  volatile boolean Fnn;
  public ar<ID> Fno;
  at<ID> Fnp;
  private final Set<ID> Fnq;
  private final ConcurrentHashMap<ID, Integer> Fnr;
  private final Set<ID> Fns;
  private final ConcurrentHashMap<ID, Integer> Fnt;
  private final String threadName;
  
  static
  {
    AppMethodBeat.i(331394);
    Fnm = new a((byte)0);
    TAG = "Finder.ExposeStatisticUtil";
    AppMethodBeat.o(331394);
  }
  
  public a()
  {
    AppMethodBeat.i(331369);
    this.threadName = "ExposeStatisticUtil";
    this.Fnq = ((Set)new HashSet());
    this.Fnr = new ConcurrentHashMap();
    this.Fns = ((Set)new HashSet());
    this.Fnt = new ConcurrentHashMap();
    AppMethodBeat.o(331369);
  }
  
  private static final void a(a parama, Set paramSet)
  {
    AppMethodBeat.i(331388);
    s.u(parama, "this$0");
    parama = parama.Fno;
    if (parama != null) {
      parama.eNQ();
    }
    AppMethodBeat.o(331388);
  }
  
  private final void b(Set<? extends ID> paramSet1, Set<? extends ID> paramSet2)
  {
    AppMethodBeat.i(331383);
    if (!this.Fnn)
    {
      AppMethodBeat.o(331383);
      return;
    }
    Object localObject1 = kotlin.a.ar.a(paramSet2, (Iterable)paramSet1);
    paramSet1 = this.Fnq;
    paramSet1.clear();
    paramSet2 = ((Iterable)paramSet2).iterator();
    while (paramSet2.hasNext()) {
      paramSet1.add(paramSet2.next());
    }
    Object localObject2;
    label121:
    int i;
    if ((localObject1 == null) || (((Set)localObject1).isEmpty()))
    {
      paramSet2 = TAG;
      localObject2 = new StringBuilder("newExposeRecords").append(localObject1).append("，size:");
      if (localObject1 != null) {
        break label307;
      }
      paramSet1 = null;
      Log.i(paramSet2, paramSet1 + ')');
      if (localObject1 == null) {
        break label326;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label321;
      }
      i = 1;
      label159:
      if (i != 1) {
        break label326;
      }
      i = 1;
      label166:
      if (i == 0) {
        break label396;
      }
      paramSet1 = ((Iterable)localObject1).iterator();
    }
    for (;;)
    {
      label181:
      if (!paramSet1.hasNext()) {
        break label396;
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
          break label375;
        }
        localObject1 = this.Fnr;
        if (!((ConcurrentHashMap)localObject1).keySet().contains(paramSet2)) {
          break label377;
        }
        localObject2 = (Integer)((ConcurrentHashMap)localObject1).get(paramSet2);
        if (localObject2 == null) {
          break label181;
        }
        ((Map)localObject1).put(paramSet2, Integer.valueOf(((Integer)localObject2).intValue() + 1));
        break label181;
        h.ahAA.g(new a..ExternalSyntheticLambda0(this, (Set)localObject1), this.threadName);
        break;
        label307:
        paramSet1 = Integer.valueOf(((Set)localObject1).size());
        break label121;
        label321:
        i = 0;
        break label159;
        label326:
        i = 0;
        break label166;
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
      label375:
      continue;
      label377:
      ((Map)localObject1).put(paramSet2, Integer.valueOf(1));
    }
    label396:
    AppMethodBeat.o(331383);
  }
  
  public final void u(Set<? extends ID> paramSet)
  {
    AppMethodBeat.i(331407);
    Object localObject1 = (Iterable)paramSet;
    paramSet = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label71:
    label106:
    label109:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      at localat;
      boolean bool;
      if (this.Fnn)
      {
        localat = this.Fnp;
        if (localat == null)
        {
          bool = true;
          if (!bool) {
            break label106;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        paramSet.add(localObject2);
        break;
        bool = localat.fB(localObject2);
        break label71;
      }
    }
    paramSet = (List)paramSet;
    b(this.Fnq, p.r((Iterable)paramSet));
    AppMethodBeat.o(331407);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_EXPOSE_BROWSE", "", "TYPE_EXPOSE_CLICK", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */
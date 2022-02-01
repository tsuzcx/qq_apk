package com.tencent.mm.plugin.finder.report;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.h.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.n;
import com.tencent.mm.plugin.finder.viewmodel.component.n.a;
import com.tencent.mm.plugin.finder.viewmodel.component.n.c;
import com.tencent.mm.plugin.finder.viewmodel.component.n.d;
import com.tencent.mm.plugin.finder.viewmodel.component.n.m;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enhanceFeedUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "getEnhanceFeedUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "fragment$delegate", "Lkotlin/Lazy;", "isEnableEnhance", "", "tabType", "", "getTabType", "()I", "tabType$delegate", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "plugin-finder_release"})
public final class i
  extends s
{
  private static final String TAG = "Finder.ImportantFeedFlowReporter";
  private static LinkedList<emr> zVo;
  public static final a zVp;
  private final f zVl;
  private final f zVm;
  private final boolean zVn;
  
  static
  {
    AppMethodBeat.i(236418);
    zVp = new a((byte)0);
    TAG = "Finder.ImportantFeedFlowReporter";
    zVo = new LinkedList();
    AppMethodBeat.o(236418);
  }
  
  public i(final MMFragmentActivity paramMMFragmentActivity, bid parambid)
  {
    super(paramMMFragmentActivity, parambid);
    AppMethodBeat.i(236417);
    this.zVl = kotlin.g.ar((a)new e(parambid));
    this.zVm = kotlin.g.ar((a)new b(this, paramMMFragmentActivity));
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dYh().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.zVn = bool;
      AppMethodBeat.o(236417);
      return;
    }
  }
  
  private final n dPq()
  {
    AppMethodBeat.i(236414);
    if ((getTabType() == 4) && (this.zVn))
    {
      Object localObject = (FinderHomeTabFragment)this.zVm.getValue();
      if (localObject != null)
      {
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        localObject = com.tencent.mm.ui.component.g.h((Fragment)localObject);
        p.k(n.class, "modelClass");
        localObject = ((g.a)localObject).Xoy;
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, T>");
          AppMethodBeat.o(236414);
          throw ((Throwable)localObject);
        }
        localObject = (n)((Map)localObject).get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + n.class.getCanonicalName());
        AppMethodBeat.o(236414);
        return localObject;
      }
    }
    AppMethodBeat.o(236414);
    return null;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(236413);
    int i = ((Number)this.zVl.getValue()).intValue();
    AppMethodBeat.o(236413);
    return i;
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(236415);
    p.k(paramb, "event");
    Object localObject1 = this.zWO;
    n localn;
    int i;
    bid localbid;
    Object localObject2;
    int j;
    Object localObject3;
    if (localObject1 != null)
    {
      localn = dPq();
      if (localn != null)
      {
        i = getTabType();
        localbid = this.xbu;
        localObject2 = (a)new c((t)localObject1, this, paramb);
        p.k(paramb, "event");
        p.k(localbid, "contextObj");
        p.k(localObject2, "generateStats");
        if (!(paramb instanceof a.a)) {
          break label306;
        }
        j = ((a.a)paramb).type;
        localObject1 = a.a.xqt;
        if (j != a.a.dpV()) {
          break label266;
        }
        localObject1 = n.d.Bjh;
        if (localObject1 != n.d.Bjk)
        {
          localObject3 = (o)((a)localObject2).invoke();
          localObject2 = (FinderItem)((o)localObject3).Mx;
          localObject3 = (emr)((o)localObject3).My;
          if (((emr)localObject3).Upt < 1000L) {
            break label629;
          }
          if (localObject2 != null) {
            break label355;
          }
          Log.e("Finder.EnhanceFeedUIC", "[onEventHappen] tabType=" + i + " type=" + localObject1 + " feed is null.");
        }
      }
    }
    for (;;)
    {
      super.a(paramb);
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.j)) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl))
      {
        paramb = aj.Bnu;
        com.tencent.mm.ae.d.c(aj.eld(), (a)new d(this));
      }
      AppMethodBeat.o(236415);
      return;
      label266:
      localObject1 = a.a.xqt;
      if (j != a.a.dpP())
      {
        localObject1 = a.a.xqt;
        if (j != a.a.dpQ()) {}
      }
      else
      {
        localObject1 = n.d.Bji;
        break;
      }
      localObject1 = n.d.Bjk;
      break;
      label306:
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
      {
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl)
        {
          localObject1 = n.d.Bjj;
          break;
        }
        localObject1 = n.d.Bjk;
        break;
      }
      localObject1 = n.d.Bjk;
      break;
      label355:
      n.c localc = new n.c(((FinderItem)localObject2).getId());
      localc.Bjb = SystemClock.uptimeMillis();
      localc.RN(1);
      h.a locala = ((FinderItem)localObject2).getPosTriggerConfig();
      label427:
      com.tencent.mm.plugin.finder.storage.d locald;
      switch (com.tencent.mm.plugin.finder.viewmodel.component.o.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        bool = false;
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.dYh().aSr()).intValue() != 1) || (!bool)) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dYg().aSr()).intValue() == 1) {
          bool = true;
        }
        Log.i("Finder.EnhanceFeedUIC", "[onEventHappen] tabType=" + i + " type=" + localObject1 + " enable=" + bool + " posTriggerConfig=" + locala);
        if (bool) {
          break label595;
        }
        localc.RM(-100);
        localc.NB(SystemClock.uptimeMillis());
        break;
        bool = locala.ADg;
        break label427;
        bool = locala.ADh;
        break label427;
        bool = locala.ADi;
        break label427;
      }
      label595:
      com.tencent.mm.ui.component.b.launch$default(localn, null, null, (m)new n.m(localn, (emr)localObject3, (FinderItem)localObject2, localc, i, localbid, null), 3, null);
      continue;
      label629:
      Log.w("Finder.EnhanceFeedUIC", "[onDispatch] exposesTime=" + ((emr)localObject3).Upt + "ms is too short.");
    }
  }
  
  public final LinkedList<emr> dPl()
  {
    AppMethodBeat.i(236416);
    LinkedList localLinkedList2 = super.dPl();
    n localn = dPq();
    int i;
    if (localn != null)
    {
      List localList = (List)localLinkedList2;
      p.k(localList, "stats");
      if (!localList.isEmpty())
      {
        Object localObject2;
        Collection localCollection;
        for (;;)
        {
          synchronized (localn.BiT)
          {
            localObject2 = (List)localn.BiT;
            if (((List)localObject2).size() > 1) {
              kotlin.a.j.a((List)localObject2, (Comparator)new n.a());
            }
            if (localList.size() > 5)
            {
              localList = localList.subList(0, 5);
              localObject2 = new StringBuilder("[addEnhanceStatsList] stat=");
              Object localObject3 = (Iterable)localList;
              localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localCollection.add(com.tencent.mm.ae.d.Fw(((emr)((Iterator)localObject3).next()).xbk));
            }
          }
        }
        Log.i("Finder.EnhanceFeedUIC", (List)localCollection);
        i = localObject1.size() + localn.BiT.size() - 5;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        if (!localn.BiT.isEmpty()) {
          localn.BiT.removeFirst();
        }
      }
      else
      {
        localn.BiT.addAll((Collection)localObject1);
        AppMethodBeat.o(236416);
        return localLinkedList2;
      }
      i -= 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<emr> Pg(int paramInt)
    {
      AppMethodBeat.i(271865);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = i.dPr();
        i.aM(new LinkedList());
        Log.i(i.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (BuildInfo.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            emr localemr = (emr)localIterator.next();
            Object localObject = t.zXK;
            localObject = i.zVp;
            t.a.a(localemr, i.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(271865);
        return localLinkedList;
      }
      AppMethodBeat.o(271865);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "invoke"})
  static final class b
    extends q
    implements a<FinderHomeTabFragment>
  {
    b(i parami, MMFragmentActivity paramMMFragmentActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "invoke", "com/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter$onEventHappen$1$1"})
  static final class c
    extends q
    implements a<o<? extends FinderItem, ? extends emr>>
  {
    c(t paramt, i parami, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Integer>
  {
    e(bid parambid)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.report;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.m.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.n;
import com.tencent.mm.plugin.finder.viewmodel.component.n.b;
import com.tencent.mm.plugin.finder.viewmodel.component.n.c;
import com.tencent.mm.plugin.finder.viewmodel.component.n.f;
import com.tencent.mm.plugin.finder.viewmodel.component.n.k;
import com.tencent.mm.plugin.finder.viewmodel.component.n.l;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enhanceFeedUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "getEnhanceFeedUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "fragment$delegate", "Lkotlin/Lazy;", "isEnableEnhance", "", "tabType", "", "getTabType", "()I", "tabType$delegate", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends ae
{
  public static final a Fqb;
  private static LinkedList<fhp> Fqf;
  private static final String TAG;
  private final j Fqc;
  private final j Fqd;
  private final boolean Fqe;
  
  static
  {
    AppMethodBeat.i(331476);
    Fqb = new a((byte)0);
    TAG = "Finder.ImportantFeedFlowReporter";
    Fqf = new LinkedList();
    AppMethodBeat.o(331476);
  }
  
  public q(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    super(paramMMFragmentActivity, parambui);
    AppMethodBeat.i(331440);
    this.Fqc = kotlin.k.cm((a)new e(parambui));
    this.Fqd = kotlin.k.cm((a)new b(paramMMFragmentActivity, this));
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXm().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fqe = bool;
      AppMethodBeat.o(331440);
      return;
    }
  }
  
  private final n eMC()
  {
    AppMethodBeat.i(331456);
    if ((getTabType() == 4) && (this.Fqe))
    {
      Object localObject = (FinderHomeTabFragment)this.Fqd.getValue();
      if (localObject != null)
      {
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
        localObject = (n)com.tencent.mm.ui.component.k.y((Fragment)localObject).cp(n.class);
        AppMethodBeat.o(331456);
        return localObject;
      }
    }
    AppMethodBeat.o(331456);
    return null;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(331444);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(331444);
    return i;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331501);
    s.u(paramb, "event");
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder("[onEventHappen] centerFeed=");
    Object localObject3 = this.Fsr;
    long l;
    int m;
    Object localObject4;
    int i;
    if (localObject3 == null)
    {
      l = 0L;
      Log.i((String)localObject1, com.tencent.mm.ae.d.hF(l) + ' ');
      localObject1 = eNb();
      if (localObject1 != null)
      {
        localObject2 = eMC();
        if (localObject2 != null)
        {
          m = getTabType();
          localObject3 = this.Auc;
          localObject4 = (a)new c((af)localObject1, this);
          s.u(paramb, "event");
          s.u(localObject3, "contextObj");
          s.u(localObject4, "generateStats");
          if (!(paramb instanceof a.a)) {
            break label376;
          }
          i = ((a.a)paramb).type;
          localObject1 = a.a.ANi;
          if (i != a.a.dYE()) {
            break label300;
          }
          localObject1 = n.c.GOt;
          label165:
          if (localObject1 != n.c.GOu)
          {
            if (((CharSequence)((n)localObject2).GOf).length() <= 0) {
              break label533;
            }
            i = 1;
            label191:
            if (i == 0) {
              break label538;
            }
            Log.w("Finder.EnhanceFeedUIC", "[onDispatch] just return. isRunningTag=" + ((n)localObject2).GOf + " eventType=" + localObject1);
          }
        }
      }
    }
    label300:
    label368:
    label376:
    Object localObject5;
    for (;;)
    {
      super.a(paramb);
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.k)) && (((com.tencent.mm.plugin.finder.event.base.k)paramb).AIv != ((com.tencent.mm.plugin.finder.event.base.k)paramb).AOv))
      {
        paramb = as.GSQ;
        com.tencent.mm.ae.d.e(as.foC(), (a)new d(this));
      }
      AppMethodBeat.o(331501);
      return;
      l = ((af)localObject3).feedId;
      break;
      localObject1 = a.a.ANi;
      if (i == a.a.dYq())
      {
        localObject1 = n.c.GOq;
        break label165;
      }
      localObject1 = a.a.ANi;
      if (i == a.a.dYk()) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label368;
        }
        localObject1 = n.c.GOr;
        break;
        localObject1 = a.a.ANi;
        if (i == a.a.dYl()) {
          i = 1;
        } else {
          i = 0;
        }
      }
      localObject1 = n.c.GOu;
      break label165;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.k))
      {
        ((n)localObject2).AIv = ((com.tencent.mm.plugin.finder.event.base.k)paramb).AOv;
        if (((((com.tencent.mm.plugin.finder.event.base.k)paramb).type != 0) && (((com.tencent.mm.plugin.finder.event.base.k)paramb).type != 2) && (((com.tencent.mm.plugin.finder.event.base.k)paramb).type != 1) && (((com.tencent.mm.plugin.finder.event.base.k)paramb).type != 8) && (((com.tencent.mm.plugin.finder.event.base.k)paramb).type != 3)) || (((com.tencent.mm.plugin.finder.event.base.k)paramb).AIv == ((com.tencent.mm.plugin.finder.event.base.k)paramb).AOv) || (((n)localObject2).GOg >= ((com.tencent.mm.plugin.finder.event.base.k)paramb).AOw)) {
          break label525;
        }
        ((n)localObject2).GOg = ((com.tencent.mm.plugin.finder.event.base.k)paramb).AOw;
        if (((n)localObject2).GOh) {
          ((n)localObject2).GOh = false;
        }
      }
      else
      {
        localObject1 = n.c.GOu;
        break label165;
      }
      localObject1 = n.c.GOs;
      break label165;
      label525:
      localObject1 = n.c.GOu;
      break label165;
      label533:
      i = 0;
      break label191;
      label538:
      localObject5 = (r)((a)localObject4).invoke();
      localObject4 = (FinderItem)((r)localObject5).bsC;
      localObject5 = (fhp)((r)localObject5).bsD;
      if (((fhp)localObject5).abIr < 1000L) {
        break label973;
      }
      if (localObject4 != null) {
        break label631;
      }
      Log.e("Finder.EnhanceFeedUIC", "[onEventHappen] tabType=" + m + " type=" + localObject1 + " feed is null.");
    }
    label631:
    Object localObject6 = com.tencent.mm.plugin.finder.storage.d.FAy;
    label654:
    int j;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXm().bmg()).intValue() == 1)
    {
      i = 1;
      if (n.a((n.c)localObject1, (FinderItem)localObject4, (fhp)localObject5)) {
        break label851;
      }
      i = 1;
      j = 0;
    }
    for (;;)
    {
      localObject6 = new n.b(((FinderItem)localObject4).getId());
      ((n.b)localObject6).GOj = SystemClock.uptimeMillis();
      ((n.b)localObject6).Ve(1);
      m.b localb = ((FinderItem)localObject4).getPosTriggerConfig();
      FinderObject localFinderObject = ((FinderItem)localObject4).getFeedObject();
      if (j != 0)
      {
        Log.i("Finder.EnhanceFeedUIC", "[onEventHappen] tabType=" + m + " type=" + localObject1 + " requestObj=" + n.O(localFinderObject) + " posTriggerConfig=" + localb);
        ((n)localObject2).GOf = n.O(localFinderObject);
        e.launch$default((e)localObject2, null, null, (kotlin.g.a.m)new n.k((fhp)localObject5, (n)localObject2, (n.b)localObject6, (n.c)localObject1, m, (bui)localObject3, localFinderObject, (FinderItem)localObject4, null), 3, null).bh((kotlin.g.a.b)new n.l((n)localObject2));
        break;
        i = 0;
        break label654;
        label851:
        if ((localObject1 == n.c.GOt) || (!((n)localObject2).GOc.contains(Long.valueOf(((FinderItem)localObject4).field_id)))) {
          break label1009;
        }
        i = 2;
        j = 0;
        continue;
      }
      Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] disableReason=" + i + " tabType=" + m + " type=" + localObject1 + " requestObj=" + n.O(localFinderObject) + " posTriggerConfig=" + localb);
      ((n.b)localObject6).Vd(-100);
      ((n.b)localObject6).rf(SystemClock.uptimeMillis());
      break;
      label973:
      Log.w("Finder.EnhanceFeedUIC", "[onDispatch] exposesTime=" + ((fhp)localObject5).abIr + "ms is too short.");
      break;
      label1009:
      int k = 0;
      j = i;
      i = k;
    }
  }
  
  public final LinkedList<fhp> eMx()
  {
    AppMethodBeat.i(331510);
    LinkedList localLinkedList2 = super.eMx();
    n localn = eMC();
    List localList2;
    if (localn != null)
    {
      localList2 = (List)localLinkedList2;
      s.u(localList2, "stats");
      if (localList2.isEmpty()) {}
    }
    for (;;)
    {
      int i;
      synchronized (localn.GOd)
      {
        List localList1 = (List)localn.GOd;
        if (localList1.size() > 1) {
          p.a(localList1, (Comparator)new n.f());
        }
        localList1 = localList2;
        if (localList2.size() > 5) {
          localList1 = localList2.subList(0, 5);
        }
        i = localList1.size() + localn.GOd.size() - 5;
        if (i > 0)
        {
          if (!localn.GOd.isEmpty()) {
            localn.GOd.removeFirst();
          }
        }
        else
        {
          localn.GOd.addAll((Collection)localList1);
          AppMethodBeat.o(331510);
          return localLinkedList2;
        }
      }
      i -= 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static LinkedList<fhp> Sj(int paramInt)
    {
      AppMethodBeat.i(331254);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = q.eMD();
        q.aT(new LinkedList());
        Log.i(q.access$getTAG$cp(), s.X("streamCgiStats returnList ", Integer.valueOf(localLinkedList.size())));
        if (BuildInfo.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            fhp localfhp = (fhp)localIterator.next();
            Object localObject = af.FsA;
            localObject = q.Fqb;
            af.a.a(localfhp, q.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(331254);
        return localLinkedList;
      }
      AppMethodBeat.o(331254);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<FinderHomeTabFragment>
  {
    b(MMFragmentActivity paramMMFragmentActivity, q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/protocal/protobuf/Stats;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<r<? extends FinderItem, ? extends fhp>>
  {
    c(af paramaf, q paramq)
    {
      super();
    }
    
    private r<FinderItem, fhp> eME()
    {
      AppMethodBeat.i(331256);
      Object localObject2 = this.Fqh;
      Object localObject1 = new af(((af)localObject2).feedId, ((af)localObject2).startTime, ((af)localObject2).ANj, ((af)localObject2).AOo, ((af)localObject2).FsB, ((af)localObject2).FpB, null, 64);
      ((af)localObject1).hlB = ((af)localObject2).hlB;
      ((af)localObject1).FsD = ((af)localObject2).FsD;
      ((af)localObject1).endTime = ((af)localObject2).endTime;
      ((af)localObject1).FsE = ((af)localObject2).FsE;
      ((af)localObject1).FsF = ((af)localObject2).FsF;
      ((af)localObject1).FsG = ((af)localObject2).FsG;
      ((af)localObject1).FsH = ((af)localObject2).FsH;
      ((af)localObject1).FsI = ((af)localObject2).FsI;
      ((af)localObject1).FsJ = ((af)localObject2).FsJ;
      ((af)localObject1).FsK = ((af)localObject2).FsK;
      ((af)localObject1).FsL = ((af)localObject2).FsL;
      ((af)localObject1).FsM = ((af)localObject2).FsM;
      ((af)localObject1).sve = ((af)localObject2).sve;
      ((af)localObject1).FsN = ((af)localObject2).FsN;
      ((af)localObject1).FsO = ((af)localObject2).FsO;
      ((af)localObject1).FsP = ((af)localObject2).FsP;
      ((af)localObject1).FsQ = ((af)localObject2).FsQ;
      ((af)localObject1).FsR = ((af)localObject2).FsR;
      ((af)localObject1).FsS = ((af)localObject2).FsS;
      ((af)localObject1).FsT = ((af)localObject2).FsT;
      ((af)localObject1).FsU = ((af)localObject2).FsU;
      ((af)localObject1).FsV = ((af)localObject2).FsV;
      ((af)localObject1).FsX = ((af)localObject2).FsX;
      ((af)localObject1).FsY = ((af)localObject2).FsY;
      ((af)localObject1).FsZ = ((af)localObject2).FsZ;
      ((af)localObject1).Fta = ((af)localObject2).Fta;
      ((af)localObject1).Ftb = ((af)localObject2).Ftb;
      ((af)localObject1).Ftc = ((af)localObject2).Ftc;
      ((af)localObject1).Ftd = ((af)localObject2).Ftd;
      ((af)localObject1).hTS = ((af)localObject2).hTS;
      ((af)localObject1).Fte = ((af)localObject2).Fte;
      ((af)localObject1).Ftf = ((af)localObject2).Ftf;
      ((af)localObject1).Ftg = ((af)localObject2).Ftg;
      ((af)localObject1).Fth = ((af)localObject2).Fth;
      ((af)localObject1).Fti = ((af)localObject2).Fti;
      ((af)localObject1).Ftj = ((af)localObject2).Ftj;
      ((af)localObject1).Ftk = ((af)localObject2).Ftk;
      ((af)localObject1).netType = ((af)localObject2).netType;
      ((af)localObject1).videoDuration = ((af)localObject2).videoDuration;
      ((af)localObject1).a(jdField_this.FpB);
      localObject2 = ((af)localObject1).ANj;
      af.a locala = af.FsA;
      localObject1 = new r(localObject2, af.a.a((af)localObject1, jdField_this.Auc));
      AppMethodBeat.o(331256);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<Integer>
  {
    e(bui parambui)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */
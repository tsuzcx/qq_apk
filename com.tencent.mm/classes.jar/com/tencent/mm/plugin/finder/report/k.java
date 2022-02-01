package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class k
  extends a
{
  public static final a ryX;
  private HashMap<Long, l> rxw;
  
  static
  {
    AppMethodBeat.i(202806);
    ryX = new a((byte)0);
    AppMethodBeat.o(202806);
  }
  
  public k(MMActivity paramMMActivity, anm paramanm)
  {
    super(paramMMActivity, paramanm);
    AppMethodBeat.i(202805);
    this.rxw = new HashMap();
    AppMethodBeat.o(202805);
  }
  
  private final dcw a(l paraml, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(202799);
    if (paraml.endTime == 0L) {
      paraml.endTime = ce.azJ();
    }
    Object localObject1 = l.ryZ;
    d.g.b.k.h(paraml, "record");
    dcw localdcw = new dcw();
    Object localObject3 = new BitSet(64);
    localdcw.qXP = paraml.dig;
    localObject1 = paraml.feed;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((FinderItem)localObject1).getObjectNonceId();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localdcw.objectNonceId = ((String)localObject1);
    localdcw.FMx = new lo();
    localdcw.FMy = new doq();
    localdcw.FMz = new cbz();
    localObject1 = paraml.feed;
    if (localObject1 != null)
    {
      localObject2 = ((FinderItem)localObject1).field_username;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localdcw.rfC = ((String)localObject1);
    float f = (float)(paraml.endTime - paraml.startTime) / 1000.0F;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      long l = localObject3.toLongArray()[0];
      localdcw.FMx.DZq = l;
      localdcw.FMy.yuZ = ((int)f);
      localdcw.FMz.FpZ = ((int)f);
      localdcw.FMz.Fqj = paraml.rxD;
      localObject1 = localdcw.FMz;
      if (!paramBoolean) {
        break label859;
      }
      i = 0;
      label270:
      ((cbz)localObject1).Fqi = i;
      localObject1 = paraml.feed;
      if (localObject1 != null)
      {
        localObject2 = localdcw.FMz;
        if (((FinderItem)localObject1).getLikeFlag() != 1) {
          break label865;
        }
        i = 1;
        label307:
        ((cbz)localObject2).Fqf = i;
        localObject2 = localdcw.FMz;
        localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
        if (!b.a.adk(((FinderItem)localObject1).getUserName())) {
          break label871;
        }
        i = 1;
        label340:
        ((cbz)localObject2).Fqe = i;
        localObject2 = localdcw.FMz;
        if (((FinderItem)localObject1).getFavFlag() != 1) {
          break label877;
        }
      }
    }
    label859:
    label865:
    label871:
    label877:
    for (int i = j;; i = 0)
    {
      ((cbz)localObject2).Fqh = i;
      anm localanm = this.contextObj;
      d.g.b.k.h(localanm, "contextObj");
      d.g.b.k.h(paraml, "record");
      localObject3 = new an();
      ((an)localObject3).jdMethod_do(localanm.rfR);
      ((an)localObject3).ho(com.tencent.mm.ac.c.pb(paraml.dig));
      ((an)localObject3).hl(localanm.sessionId);
      ((an)localObject3).hm(localanm.qox);
      ((an)localObject3).hn(localanm.qom);
      ((an)localObject3).ds(paraml.startTime);
      ((an)localObject3).dt(paraml.endTime);
      ((an)localObject3).dr(paraml.endTime - paraml.startTime);
      FinderItem localFinderItem = paraml.feed;
      if (localFinderItem != null)
      {
        ((an)localObject3).du(localFinderItem.getLikeCount());
        localObject1 = localanm.ses;
        if (localObject1 != null)
        {
          localObject2 = n.h((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((an)localObject3).hq((String)localObject1);
        ((an)localObject3).dv(localFinderItem.getMediaType());
      }
      ((an)localObject3).dp(paraml.rxD);
      localObject1 = d.rxr;
      ((an)localObject3).dq(d.DT(localanm.rfR));
      localObject1 = l.ryZ;
      ((an)localObject3).hp(n.h(l.a.a(paraml), ",", ";", false));
      localObject1 = d.rxr;
      ((an)localObject3).hr(d.G(paraml.dig, localanm.rfR));
      ((an)localObject3).dyF();
      paraml = d.rxr;
      d.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(202799);
      return localdcw;
      if (f < 1.0F)
      {
        ((BitSet)localObject3).set(22, true);
        break;
      }
      if (f < 2.0F)
      {
        ((BitSet)localObject3).set(23, true);
        break;
      }
      if (f < 3.0F)
      {
        ((BitSet)localObject3).set(24, true);
        break;
      }
      if (f < 5.0F)
      {
        ((BitSet)localObject3).set(25, true);
        break;
      }
      if (f < 10.0F)
      {
        ((BitSet)localObject3).set(26, true);
        break;
      }
      if (f < 20.0F)
      {
        ((BitSet)localObject3).set(27, true);
        break;
      }
      if (f < 30.0F)
      {
        ((BitSet)localObject3).set(28, true);
        break;
      }
      if (f < 40.0F)
      {
        ((BitSet)localObject3).set(29, true);
        break;
      }
      if (f < 50.0F)
      {
        ((BitSet)localObject3).set(30, true);
        break;
      }
      ((BitSet)localObject3).set(31, true);
      break;
      i = 1;
      break label270;
      i = 0;
      break label307;
      i = 0;
      break label340;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(202801);
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cGf(), (d.g.a.a)new b(this));
    AppMethodBeat.o(202801);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(202803);
    d.g.b.k.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      boolean bool;
      switch (this.contextObj.rfR)
      {
      default: 
        bool = false;
      }
      for (;;)
      {
        ac.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.contextObj.rfR + " fromCommentScene:" + this.contextObj.seo);
        if (!bool) {
          break label268;
        }
        localObject1 = v.rve;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rdP;
        if (localObject1 == null) {
          break label421;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).rdD);
        }
        bool = true;
        continue;
        if (this.contextObj.seo == 34) {
          bool = true;
        } else {
          bool = false;
        }
      }
      label268:
      Object localObject4;
      label421:
      for (Object localObject1 = (List)localObject1;; localObject1 = null)
      {
        v.a((List)localObject1, this.contextObj);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramb).nAG == ((com.tencent.mm.plugin.finder.event.base.l)paramb).rdH) && (((com.tencent.mm.plugin.finder.event.base.l)paramb).rdJ == ((com.tencent.mm.plugin.finder.event.base.l)paramb).nAH)) {
          break label890;
        }
        localObject2 = new HashSet();
        localObject1 = new HashSet();
        ((HashSet)localObject2).addAll((Collection)this.rxw.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rdQ;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          ((HashSet)localObject2).add(Long.valueOf(((g)localObject4).rdD.lx()));
          ((HashSet)localObject1).add(Long.valueOf(((g)localObject4).rdD.lx()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rdP;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label532:
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject2).contains(Long.valueOf(((g)localObject5).rdD.lx()))) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label532;
            }
            ((Collection)localObject3).add(localObject5);
            break;
          }
        }
        localObject2 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (g)((Iterator)localObject2).next();
          localObject4 = new l(((g)localObject3).rdD.lx(), paramb.rdg, ((g)localObject3).rdD.feedObject);
          ((l)localObject4).rxD = ((g)localObject3).rdE;
          ((l)localObject4).rdF = ((g)localObject3).rdF;
          a((l)localObject4, true);
        }
      }
      Object localObject2 = ((Map)this.rxw).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((HashSet)localObject1).contains(((Map.Entry)localObject3).getKey())) {
          a((l)((Map.Entry)localObject3).getValue(), false);
        }
      }
      localObject1 = new HashMap();
      localObject2 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rdQ;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (g)((Iterator)localObject2).next();
          localObject4 = (l)this.rxw.get(Long.valueOf(((g)localObject3).rdD.lx()));
          if (localObject4 != null)
          {
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rdD.lx()), localObject4);
          }
          else
          {
            localObject4 = new l(((g)localObject3).rdD.lx(), paramb.rdg, ((g)localObject3).rdD.feedObject);
            ((l)localObject4).rxD = ((g)localObject3).rdE;
            ((l)localObject4).rdF = ((g)localObject3).rdF;
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rdD.lx()), localObject4);
          }
        }
      }
      this.rxw = ((HashMap)localObject1);
    }
    label890:
    AppMethodBeat.o(202803);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(202802);
    d.g.b.k.h(paramc, "dispatcher");
    d.g.b.k.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(202802);
      return true;
    }
    AppMethodBeat.o(202802);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(202804);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(202804);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(202800);
    onExit();
    super.onRelease();
    AppMethodBeat.o(202800);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */
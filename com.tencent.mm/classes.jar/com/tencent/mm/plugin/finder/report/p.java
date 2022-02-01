package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.n.n;
import d.z;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class p
  extends c
{
  public static final a sqG;
  private HashMap<Long, q> soR;
  
  static
  {
    AppMethodBeat.i(203357);
    sqG = new a((byte)0);
    AppMethodBeat.o(203357);
  }
  
  public p(MMActivity paramMMActivity, aqy paramaqy)
  {
    super(paramMMActivity, paramaqy);
    AppMethodBeat.i(203356);
    this.soR = new HashMap();
    AppMethodBeat.o(203356);
  }
  
  private final dij a(q paramq, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(203350);
    if (paramq.endTime == 0L) {
      paramq.endTime = cf.aCM();
    }
    Object localObject1 = q.sqI;
    d.g.b.p.h(paramq, "record");
    dij localdij = new dij();
    Object localObject3 = new BitSet(64);
    localdij.rIZ = paramq.dtq;
    localObject1 = paramq.feed;
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
    localdij.objectNonceId = ((String)localObject1);
    localdij.Hxf = new ly();
    localdij.Hxg = new duh();
    localdij.Hxh = new cgq();
    localObject1 = paramq.feed;
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
    localdij.rTn = ((String)localObject1);
    float f = (float)(paramq.endTime - paramq.startTime) / 1000.0F;
    long l;
    int i;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      l = localObject3.toLongArray()[0];
      localdij.Hxf.FEM = l;
      localdij.Hxg.zMn = ((int)f);
      localdij.Hxh.GZJ = ((int)f);
      localdij.Hxh.GZT = paramq.soY;
      localObject1 = localdij.Hxh;
      if (!paramBoolean) {
        break label1009;
      }
      i = 0;
      label270:
      ((cgq)localObject1).GZS = i;
      localObject1 = paramq.feed;
      if (localObject1 != null)
      {
        localObject2 = localdij.Hxh;
        if (((FinderItem)localObject1).getLikeFlag() == 0) {
          break label1015;
        }
        i = 1;
        label306:
        ((cgq)localObject2).GZP = i;
        localObject2 = localdij.Hxh;
        localObject3 = com.tencent.mm.plugin.finder.api.c.rHn;
        if (!c.a.agZ(((FinderItem)localObject1).getUserName())) {
          break label1021;
        }
        i = 1;
        label339:
        ((cgq)localObject2).GZO = i;
        localObject2 = localdij.Hxh;
        if (((FinderItem)localObject1).getFavFlag() != 1) {
          break label1027;
        }
        i = j;
        label366:
        ((cgq)localObject2).GZR = i;
      }
      aqy localaqy = this.rIl;
      d.g.b.p.h(localaqy, "contextObj");
      d.g.b.p.h(paramq, "record");
      localObject3 = new ay();
      ((ay)localObject3).ee(localaqy.rTD);
      ((ay)localObject3).iK(com.tencent.mm.ad.c.rc(paramq.dtq));
      ((ay)localObject3).iH(localaqy.sessionId);
      ((ay)localObject3).iI(localaqy.qXu);
      ((ay)localObject3).iJ(localaqy.qXj);
      ((ay)localObject3).ei(paramq.startTime);
      ((ay)localObject3).ej(paramq.endTime);
      ((ay)localObject3).eh(paramq.endTime - paramq.startTime);
      FinderItem localFinderItem = paramq.feed;
      if (localFinderItem != null)
      {
        ((ay)localObject3).ek(localFinderItem.getLikeCount());
        localObject1 = localaqy.tco;
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
        ((ay)localObject3).iM((String)localObject1);
        ((ay)localObject3).el(localFinderItem.getMediaType());
      }
      ((ay)localObject3).ef(paramq.soY);
      localObject1 = h.soM;
      ((ay)localObject3).eg(h.EX(localaqy.rTD));
      localObject1 = q.sqI;
      ((ay)localObject3).iL(n.h(q.a.a(paramq), ",", ";", false));
      localObject1 = h.soM;
      ((ay)localObject3).iN(h.I(paramq.dtq, localaqy.rTD));
      if (localaqy.rTD == 15)
      {
        localObject1 = paramq.feed;
        if (localObject1 == null) {
          break label1033;
        }
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        label682:
        if (localObject1 != null) {
          switch (paramq.feed.getFeedObject().recommendReasonType)
          {
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            l = 0L;
          }
        }
      }
    }
    for (;;)
    {
      ((ay)localObject3).em(l);
      localObject1 = paramq.feed.getFeedObject().recommendReason;
      paramq = (q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      ((ay)localObject3).iO(paramq);
      ((ay)localObject3).dJX();
      paramq = h.soM;
      h.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(203350);
      return localdij;
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
      label1009:
      i = 1;
      break label270;
      label1015:
      i = 0;
      break label306;
      label1021:
      i = 0;
      break label339;
      label1027:
      i = 0;
      break label366;
      label1033:
      localObject1 = null;
      break label682;
      l = 1L;
      continue;
      l = 2L;
      continue;
      l = 3L;
      continue;
      l = 4L;
      continue;
      l = 5L;
      continue;
      l = 6L;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(203352);
    FinderReporterUIC.a locala = FinderReporterUIC.tcM;
    com.tencent.mm.ad.c.c(FinderReporterUIC.cOy(), (d.g.a.a)new b(this));
    AppMethodBeat.o(203352);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203354);
    d.g.b.p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      boolean bool;
      switch (this.rIl.rTD)
      {
      default: 
        bool = false;
      }
      for (;;)
      {
        ad.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.rIl.rTD + " fromCommentScene:" + this.rIl.tcl);
        if (!bool) {
          break label268;
        }
        localObject1 = x.skz;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rRp;
        if (localObject1 == null) {
          break label421;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).rQZ);
        }
        bool = true;
        continue;
        if (this.rIl.tcl == 34) {
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
        x.a((List)localObject1, this.rIl);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramb).obN == ((com.tencent.mm.plugin.finder.event.base.l)paramb).rRd) && (((com.tencent.mm.plugin.finder.event.base.l)paramb).rRf == ((com.tencent.mm.plugin.finder.event.base.l)paramb).obO)) {
          break label890;
        }
        localObject2 = new HashSet();
        localObject1 = new HashSet();
        ((HashSet)localObject2).addAll((Collection)this.soR.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rRq;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          ((HashSet)localObject2).add(Long.valueOf(((g)localObject4).rQZ.lP()));
          ((HashSet)localObject1).add(Long.valueOf(((g)localObject4).rQZ.lP()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rRp;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label532:
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject2).contains(Long.valueOf(((g)localObject5).rQZ.lP()))) {}
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
          localObject4 = new q(((g)localObject3).rQZ.lP(), paramb.rQC, ((g)localObject3).rQZ.feedObject);
          ((q)localObject4).soY = ((g)localObject3).rRa;
          ((q)localObject4).rRb = ((g)localObject3).rRb;
          a((q)localObject4, true);
        }
      }
      Object localObject2 = ((Map)this.soR).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((HashSet)localObject1).contains(((Map.Entry)localObject3).getKey())) {
          a((q)((Map.Entry)localObject3).getValue(), false);
        }
      }
      localObject1 = new HashMap();
      localObject2 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rRq;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (g)((Iterator)localObject2).next();
          localObject4 = (q)this.soR.get(Long.valueOf(((g)localObject3).rQZ.lP()));
          if (localObject4 != null)
          {
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rQZ.lP()), localObject4);
          }
          else
          {
            localObject4 = new q(((g)localObject3).rQZ.lP(), paramb.rQC, ((g)localObject3).rQZ.feedObject);
            ((q)localObject4).soY = ((g)localObject3).rRa;
            ((q)localObject4).rRb = ((g)localObject3).rRb;
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rQZ.lP()), localObject4);
          }
        }
      }
      this.soR = ((HashMap)localObject1);
    }
    label890:
    AppMethodBeat.o(203354);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    AppMethodBeat.i(203353);
    d.g.b.p.h(paramc, "dispatcher");
    d.g.b.p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(203353);
      return true;
    }
    AppMethodBeat.o(203353);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203355);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(203355);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(203351);
    onExit();
    super.onRelease();
    AppMethodBeat.o(203351);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.b.p;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class q
  extends c
{
  public static final a sAQ;
  private HashMap<Long, r> syY;
  
  static
  {
    AppMethodBeat.i(203916);
    sAQ = new a((byte)0);
    AppMethodBeat.o(203916);
  }
  
  public q(MMActivity paramMMActivity, arn paramarn)
  {
    super(paramMMActivity, paramarn);
    AppMethodBeat.i(203915);
    this.syY = new HashMap();
    AppMethodBeat.o(203915);
  }
  
  private final dje a(r paramr, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(203909);
    if (paramr.endTime == 0L) {
      paramr.endTime = ch.aDc();
    }
    Object localObject1 = r.sAS;
    p.h(paramr, "record");
    dje localdje = new dje();
    Object localObject3 = new BitSet(64);
    localdje.rRn = paramr.duw;
    localObject1 = paramr.feed;
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
    localdje.objectNonceId = ((String)localObject1);
    localdje.HQO = new ly();
    localdje.HQP = new dve();
    localdje.HQQ = new chk();
    localObject1 = paramr.feed;
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
    localdje.sbR = ((String)localObject1);
    float f = (float)(paramr.endTime - paramr.startTime) / 1000.0F;
    long l;
    int i;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      l = localObject3.toLongArray()[0];
      localObject1 = localdje.HQO;
      if (localObject1 != null) {
        ((ly)localObject1).FXh = l;
      }
      localObject1 = localdje.HQP;
      if (localObject1 != null) {
        ((dve)localObject1).Adu = ((int)f);
      }
      localObject1 = localdje.HQQ;
      if (localObject1 != null) {
        ((chk)localObject1).Htk = ((int)f);
      }
      localObject1 = localdje.HQQ;
      if (localObject1 != null) {
        ((chk)localObject1).Htt = paramr.szj;
      }
      localObject1 = localdje.HQQ;
      if (localObject1 != null)
      {
        if (!paramBoolean) {
          break label1065;
        }
        i = 0;
        label311:
        ((chk)localObject1).Hts = i;
      }
      localObject1 = paramr.feed;
      if (localObject1 != null)
      {
        localObject2 = localdje.HQQ;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getLikeFlag() == 0) {
            break label1071;
          }
          i = 1;
          label352:
          ((chk)localObject2).Htp = i;
        }
        localObject2 = localdje.HQQ;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.api.c.rPy;
          if (!c.a.ahW(((FinderItem)localObject1).getUserName())) {
            break label1077;
          }
          i = 1;
          label390:
          ((chk)localObject2).sSH = i;
        }
        localObject2 = localdje.HQQ;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getFavFlag() != 1) {
            break label1083;
          }
          i = j;
          label422:
          ((chk)localObject2).Htr = i;
        }
      }
      arn localarn = this.rQw;
      p.h(localarn, "contextObj");
      p.h(paramr, "record");
      localObject3 = new ay();
      ((ay)localObject3).ef(localarn.sch);
      ((ay)localObject3).iU(com.tencent.mm.ac.c.rp(paramr.duw));
      ((ay)localObject3).iR(localarn.sessionId);
      ((ay)localObject3).iS(localarn.rfA);
      ((ay)localObject3).iT(localarn.rfo);
      ((ay)localObject3).ej(paramr.startTime);
      ((ay)localObject3).ek(paramr.endTime);
      ((ay)localObject3).ei(paramr.endTime - paramr.startTime);
      FinderItem localFinderItem = paramr.feed;
      if (localFinderItem != null)
      {
        ((ay)localObject3).el(localFinderItem.getLikeCount());
        localObject1 = localarn.tni;
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
        ((ay)localObject3).iW((String)localObject1);
        ((ay)localObject3).em(localFinderItem.getMediaType());
      }
      ((ay)localObject3).eg(paramr.szj);
      localObject1 = i.syT;
      ((ay)localObject3).eh(i.Ft(localarn.sch));
      localObject1 = r.sAS;
      ((ay)localObject3).iV(n.h(r.a.a(paramr), ",", ";", false));
      localObject1 = i.syT;
      ((ay)localObject3).iX(i.I(paramr.duw, localarn.sch));
      if (localarn.sch == 15)
      {
        localObject1 = paramr.feed;
        if (localObject1 == null) {
          break label1089;
        }
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        label738:
        if (localObject1 != null) {
          switch (paramr.feed.getFeedObject().recommendReasonType)
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
      ((ay)localObject3).en(l);
      localObject1 = paramr.feed.getFeedObject().recommendReason;
      paramr = (r)localObject1;
      if (localObject1 == null) {
        paramr = "";
      }
      ((ay)localObject3).iY(paramr);
      ((ay)localObject3).dNp();
      paramr = i.syT;
      i.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(203909);
      return localdje;
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
      label1065:
      i = 1;
      break label311;
      label1071:
      i = 0;
      break label352;
      label1077:
      i = 0;
      break label390;
      label1083:
      i = 0;
      break label422;
      label1089:
      localObject1 = null;
      break label738;
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
    AppMethodBeat.i(203911);
    FinderReporterUIC.a locala = FinderReporterUIC.tnG;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cRd(), (d.g.a.a)new b(this));
    AppMethodBeat.o(203911);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203913);
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      boolean bool;
      switch (this.rQw.sch)
      {
      default: 
        bool = false;
      }
      for (;;)
      {
        ae.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.rQw.sch + " fromCommentScene:" + this.rQw.tnf);
        if (!bool) {
          break label268;
        }
        localObject1 = y.stw;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rZR;
        if (localObject1 == null) {
          break label421;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).rZB);
        }
        bool = true;
        continue;
        if (this.rQw.tnf == 34) {
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
        y.a((List)localObject1, this.rQw);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramb).ohB == ((com.tencent.mm.plugin.finder.event.base.l)paramb).rZF) && (((com.tencent.mm.plugin.finder.event.base.l)paramb).rZH == ((com.tencent.mm.plugin.finder.event.base.l)paramb).ohC)) {
          break label890;
        }
        localObject2 = new HashSet();
        localObject1 = new HashSet();
        ((HashSet)localObject2).addAll((Collection)this.syY.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rZS;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          ((HashSet)localObject2).add(Long.valueOf(((g)localObject4).rZB.lP()));
          ((HashSet)localObject1).add(Long.valueOf(((g)localObject4).rZB.lP()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rZR;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label532:
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject2).contains(Long.valueOf(((g)localObject5).rZB.lP()))) {}
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
          localObject4 = new r(((g)localObject3).rZB.lP(), paramb.rZe, ((g)localObject3).rZB.feedObject);
          ((r)localObject4).szj = ((g)localObject3).rZC;
          ((r)localObject4).rZD = ((g)localObject3).rZD;
          a((r)localObject4, true);
        }
      }
      Object localObject2 = ((Map)this.syY).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((HashSet)localObject1).contains(((Map.Entry)localObject3).getKey())) {
          a((r)((Map.Entry)localObject3).getValue(), false);
        }
      }
      localObject1 = new HashMap();
      localObject2 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).rZS;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (g)((Iterator)localObject2).next();
          localObject4 = (r)this.syY.get(Long.valueOf(((g)localObject3).rZB.lP()));
          if (localObject4 != null)
          {
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rZB.lP()), localObject4);
          }
          else
          {
            localObject4 = new r(((g)localObject3).rZB.lP(), paramb.rZe, ((g)localObject3).rZB.feedObject);
            ((r)localObject4).szj = ((g)localObject3).rZC;
            ((r)localObject4).rZD = ((g)localObject3).rZD;
            ((HashMap)localObject1).put(Long.valueOf(((g)localObject3).rZB.lP()), localObject4);
          }
        }
      }
      this.syY = ((HashMap)localObject1);
    }
    label890:
    AppMethodBeat.o(203913);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    AppMethodBeat.i(203912);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(203912);
      return true;
    }
    AppMethodBeat.o(203912);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203914);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(203914);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(203910);
    onExit();
    super.onRelease();
    AppMethodBeat.o(203910);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */
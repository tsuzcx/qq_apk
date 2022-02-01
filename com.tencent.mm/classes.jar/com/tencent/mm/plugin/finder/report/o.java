package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.l;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class o
  extends c
{
  public static final a KVu;
  private HashMap<Long, p> KUL;
  
  static
  {
    AppMethodBeat.i(198854);
    KVu = new a((byte)0);
    AppMethodBeat.o(198854);
  }
  
  public o(MMActivity paramMMActivity, dzp paramdzp)
  {
    super(paramMMActivity, paramdzp);
    AppMethodBeat.i(198853);
    this.KUL = new HashMap();
    AppMethodBeat.o(198853);
  }
  
  private final cxk a(p paramp, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(198847);
    if (paramp.endTime == 0L) {
      paramp.endTime = ce.asS();
    }
    Object localObject1 = p.KVv;
    d.g.b.k.h(paramp, "record");
    cxk localcxk = new cxk();
    Object localObject3 = new BitSet(64);
    localcxk.objectId = paramp.feedId;
    localObject1 = paramp.feed;
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
    localcxk.objectNonceId = ((String)localObject1);
    localcxk.bitFeature = new li();
    localcxk.valFeature = new djb();
    localcxk.orgVal = new bxf();
    localObject1 = paramp.feed;
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
    localcxk.finderUsername = ((String)localObject1);
    float f = (float)(paramp.endTime - paramp.startTime) / 1000.0F;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      long l = localObject3.toLongArray()[0];
      localcxk.bitFeature.CGQ = l;
      localcxk.valFeature.xil = ((int)f);
      localcxk.orgVal.DTD = ((int)f);
      localcxk.orgVal.LzV = paramp.KUQ;
      localObject1 = localcxk.orgVal;
      if (!paramBoolean) {
        break label859;
      }
      i = 0;
      label270:
      ((bxf)localObject1).LzU = i;
      localObject1 = paramp.feed;
      if (localObject1 != null)
      {
        localObject2 = localcxk.orgVal;
        if (((FinderItem)localObject1).getLikeFlag() != 1) {
          break label865;
        }
        i = 1;
        label307:
        ((bxf)localObject2).LzR = i;
        localObject2 = localcxk.orgVal;
        localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
        if (!b.a.YO(((FinderItem)localObject1).getUserName())) {
          break label871;
        }
        i = 1;
        label340:
        ((bxf)localObject2).LzQ = i;
        localObject2 = localcxk.orgVal;
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
      ((bxf)localObject2).LzT = i;
      dzp localdzp = this.contextObj;
      d.g.b.k.h(localdzp, "contextObj");
      d.g.b.k.h(paramp, "record");
      localObject3 = new hn();
      ((hn)localObject3).yq(localdzp.qqE);
      ((hn)localObject3).awX(com.tencent.mm.ad.c.ly(paramp.feedId));
      ((hn)localObject3).awU(localdzp.sessionId);
      ((hn)localObject3).awV(localdzp.qwV);
      ((hn)localObject3).awW(localdzp.KHW);
      ((hn)localObject3).yu(paramp.startTime);
      ((hn)localObject3).yv(paramp.endTime);
      ((hn)localObject3).yt(paramp.endTime - paramp.startTime);
      FinderItem localFinderItem = paramp.feed;
      if (localFinderItem != null)
      {
        ((hn)localObject3).yw(localFinderItem.getLikeCount());
        localObject1 = localdzp.LiO;
        if (localObject1 != null)
        {
          localObject2 = d.n.n.h((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((hn)localObject3).aJo((String)localObject1);
        ((hn)localObject3).yx(localFinderItem.getMediaType());
      }
      ((hn)localObject3).yr(paramp.KUQ);
      localObject1 = b.qFq;
      ((hn)localObject3).ys(b.aho(localdzp.qqE));
      localObject1 = p.KVv;
      ((hn)localObject3).ayx(d.n.n.h(p.a.a(paramp), ",", ";", false));
      localObject1 = b.qFq;
      ((hn)localObject3).aJs(b.am(paramp.feedId, localdzp.qqE));
      ((hn)localObject3).fYy();
      paramp = b.qFq;
      b.a((a)localObject3);
      AppMethodBeat.o(198847);
      return localcxk;
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
    AppMethodBeat.i(198849);
    Iterator localIterator = ((Map)this.KUL).entrySet().iterator();
    while (localIterator.hasNext()) {
      a((p)((Map.Entry)localIterator.next()).getValue(), false);
    }
    this.KUL = new HashMap();
    AppMethodBeat.o(198849);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(198851);
    d.g.b.k.h(paramc, "event");
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.n))
    {
      if ((this.contextObj.qqE == 15) || (this.contextObj.qqE == 26)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label153;
        }
        localObject1 = q.qDO;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.n)paramc).KMl;
        if (localObject1 == null) {
          break label304;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject2).next()).qHv);
        }
      }
      label153:
      Object localObject4;
      label304:
      for (Object localObject1 = (List)localObject1;; localObject1 = null)
      {
        q.n((List)localObject1, this.contextObj.qqE);
        if ((((com.tencent.mm.plugin.finder.event.base.n)paramc).mYh == ((com.tencent.mm.plugin.finder.event.base.n)paramc).qsi) && (((com.tencent.mm.plugin.finder.event.base.n)paramc).qsj == ((com.tencent.mm.plugin.finder.event.base.n)paramc).mYi)) {
          break label767;
        }
        localObject2 = new HashSet();
        localObject1 = new HashSet();
        ((HashSet)localObject2).addAll((Collection)this.KUL.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.n)paramc).KMm;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject3).next();
          ((HashSet)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs()));
          ((HashSet)localObject1).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.n)paramc).KMl;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label414:
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject2).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.bMs()))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label414;
            }
            ((Collection)localObject3).add(localObject5);
            break;
          }
        }
        localObject2 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject2).next();
          localObject4 = new p(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.feedObject);
          ((p)localObject4).KUQ = ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMi;
          ((p)localObject4).KMj = ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMj;
          a((p)localObject4, true);
        }
      }
      Object localObject2 = ((Map)this.KUL).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((HashSet)localObject1).contains(((Map.Entry)localObject3).getKey())) {
          a((p)((Map.Entry)localObject3).getValue(), false);
        }
      }
      localObject1 = new HashMap();
      localObject2 = ((com.tencent.mm.plugin.finder.event.base.n)paramc).KMm;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject2).next();
          localObject4 = (p)this.KUL.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs()));
          if (localObject4 != null)
          {
            ((HashMap)localObject1).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs()), localObject4);
          }
          else
          {
            localObject4 = new p(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.feedObject);
            ((p)localObject4).KUQ = ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMi;
            ((p)localObject4).KMj = ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMj;
            ((HashMap)localObject1).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs()), localObject4);
          }
        }
      }
      this.KUL = ((HashMap)localObject1);
    }
    label767:
    AppMethodBeat.o(198851);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(198850);
    d.g.b.k.h(paramd, "dispatcher");
    d.g.b.k.h(paramc, "event");
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.n))
    {
      AppMethodBeat.o(198850);
      return true;
    }
    AppMethodBeat.o(198850);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(198852);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(198852);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(198848);
    onExit();
    super.onRelease();
    AppMethodBeat.o(198848);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */
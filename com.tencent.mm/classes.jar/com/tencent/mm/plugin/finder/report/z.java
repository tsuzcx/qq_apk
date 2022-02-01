package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.cu;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.b.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class z
  extends g
{
  public static final a zYT;
  private HashMap<Long, aa> zWQ;
  
  static
  {
    AppMethodBeat.i(226059);
    zYT = new a((byte)0);
    AppMethodBeat.o(226059);
  }
  
  public z(MMFragmentActivity paramMMFragmentActivity, bid parambid)
  {
    super(paramMMFragmentActivity, parambid);
    AppMethodBeat.i(226058);
    this.zWQ = new HashMap();
    AppMethodBeat.o(226058);
  }
  
  private final emr a(aa paramaa, boolean paramBoolean)
  {
    AppMethodBeat.i(226035);
    if (paramaa.endTime == 0L) {
      paramaa.endTime = cm.bfE();
    }
    Object localObject1 = aa.zYV;
    p.k(paramaa, "record");
    emr localemr = new emr();
    Object localObject3 = new BitSet(64);
    localemr.xbk = paramaa.feedId;
    localObject1 = paramaa.xpY;
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
    localemr.objectNonceId = ((String)localObject1);
    localemr.Upj = new mf();
    localemr.Upk = new ezq();
    localemr.Upl = new dhb();
    localObject1 = paramaa.xpY;
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
    localemr.finderUsername = ((String)localObject1);
    float f = (float)(paramaa.endTime - paramaa.startTime) / 1000.0F;
    int i;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      l = localObject3.toLongArray()[0];
      localObject1 = localemr.Upj;
      if (localObject1 != null) {
        ((mf)localObject1).RRR = l;
      }
      localObject1 = localemr.Upk;
      if (localObject1 != null) {
        ((ezq)localObject1).KyZ = ((int)f);
      }
      localObject1 = localemr.Upl;
      if (localObject1 != null) {
        ((dhb)localObject1).TNM = ((int)f);
      }
      localObject1 = localemr.Upl;
      if (localObject1 != null) {
        ((dhb)localObject1).TNV = paramaa.zWX;
      }
      localObject1 = localemr.Upl;
      if (localObject1 != null)
      {
        if (!paramBoolean) {
          break label1257;
        }
        i = 0;
        label308:
        ((dhb)localObject1).TNU = i;
      }
      localObject1 = paramaa.xpY;
      if (localObject1 != null)
      {
        localObject2 = localemr.Upl;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getLikeFlag() == 0) {
            break label1263;
          }
          i = 1;
          label349:
          ((dhb)localObject2).TNR = i;
        }
        localObject2 = localemr.Upl;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
          if (!d.a.aAN(((FinderItem)localObject1).getUserName())) {
            break label1269;
          }
          i = 1;
          label387:
          ((dhb)localObject2).AvX = i;
        }
        localObject2 = localemr.Upl;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getFavFlag() != 1) {
            break label1275;
          }
          i = 1;
          label418:
          ((dhb)localObject2).TNT = i;
        }
      }
      bid localbid = this.xbu;
      p.k(localbid, "contextObj");
      p.k(paramaa, "record");
      localObject3 = new cu();
      ((cu)localObject3).gm(localbid.xkX);
      ((cu)localObject3).nu(com.tencent.mm.ae.d.Fw(paramaa.feedId));
      ((cu)localObject3).nr(localbid.sessionId);
      ((cu)localObject3).ns(localbid.wmL);
      ((cu)localObject3).nt(localbid.wmz);
      ((cu)localObject3).gq(paramaa.startTime);
      ((cu)localObject3).gr(paramaa.endTime);
      ((cu)localObject3).gp(paramaa.endTime - paramaa.startTime);
      FinderItem localFinderItem = paramaa.xpY;
      if (localFinderItem != null)
      {
        ((cu)localObject3).gs(localFinderItem.getLikeCount());
        localObject1 = localbid.BmS;
        if (localObject1 != null)
        {
          localObject2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((cu)localObject3).nw((String)localObject1);
        ((cu)localObject3).gt(localFinderItem.getMediaType());
      }
      ((cu)localObject3).gn(paramaa.zWX);
      localObject1 = com.tencent.mm.plugin.findersdk.b.c.BvA;
      ((cu)localObject3).go(c.a.Sh(localbid.xkX));
      localObject1 = aa.zYV;
      ((cu)localObject3).nv(kotlin.n.n.l(aa.a.a(paramaa), ",", ";", false));
      localObject1 = n.zWF;
      ((cu)localObject3).nx(n.N(paramaa.feedId, localbid.xkX));
      if (localbid.xkX == 15)
      {
        localObject1 = paramaa.xpY;
        if (localObject1 == null) {
          break label1281;
        }
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        label734:
        if (localObject1 == null) {}
      }
      switch (paramaa.xpY.getFeedObject().recommendReasonType)
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
        label819:
        ((cu)localObject3).gu(l);
        localObject2 = paramaa.xpY.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((cu)localObject3).ny((String)localObject1);
        localObject1 = paramaa.xpY;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getFinderObject();
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).event;
              if (localObject1 != null)
              {
                ((cu)localObject3).nA(com.tencent.mm.ae.d.Fw(((bfv)localObject1).xdR));
                ((cu)localObject3).gw(localbid.fEH);
              }
            }
          }
        }
        localObject1 = paramaa.xpY;
        if (localObject1 == null) {
          break label1350;
        }
        localObject1 = ((FinderItem)localObject1).getFinderObject();
        if (localObject1 == null) {
          break label1350;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null) {
          break label1350;
        }
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 == null) {
          break label1350;
        }
        ((cu)localObject3).nz(((bfs)localObject1).groupId);
        if (((bfs)localObject1).musicInfo != null)
        {
          paramaa = ((bfs)localObject1).musicInfo;
          if (paramaa != null)
          {
            paramaa = paramaa.BHW;
            label1014:
            paramaa = (CharSequence)paramaa;
            if ((paramaa != null) && (paramaa.length() != 0)) {
              break label1338;
            }
            i = 1;
            label1035:
            if (i != 0) {
              break label1344;
            }
          }
        }
        break;
      }
    }
    label1281:
    label1338:
    label1344:
    for (long l = 2L;; l = 1L)
    {
      ((cu)localObject3).gv(l);
      ((cu)localObject3).fBl();
      paramaa = n.zWF;
      n.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(226035);
      return localemr;
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
      label1257:
      i = 1;
      break label308;
      label1263:
      i = 0;
      break label349;
      label1269:
      i = 0;
      break label387;
      label1275:
      i = 0;
      break label418;
      localObject1 = null;
      break label734;
      l = 1L;
      break label819;
      l = 2L;
      break label819;
      l = 3L;
      break label819;
      l = 4L;
      break label819;
      l = 5L;
      break label819;
      l = 6L;
      break label819;
      paramaa = null;
      break label1014;
      i = 0;
      break label1035;
    }
    label1350:
    localObject1 = paramaa.xpY;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getFinderObject();
      if (localObject1 == null) {}
    }
    for (l = ((FinderObject)localObject1).id;; l = 0L)
    {
      ((cu)localObject3).nz(com.tencent.mm.ae.d.Fw(l));
      paramaa = paramaa.xpY;
      if ((paramaa == null) || (paramaa.getMediaType() != 4)) {
        break;
      }
      ((cu)localObject3).gv(1L);
      break;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(226038);
    aj.a locala = aj.Bnu;
    com.tencent.mm.ae.d.c(aj.eld(), (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(226038);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(226056);
    p.k(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      boolean bool;
      switch (this.xbu.xkX)
      {
      case 23: 
      case 24: 
      case 25: 
      case 27: 
      case 29: 
      default: 
        bool = false;
      }
      for (;;)
      {
        Log.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.xbu.xkX + " fromCommentScene:" + this.xbu.fGo);
        if (!bool) {
          break label268;
        }
        localObject1 = au.zBf;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).xrq;
        if (localObject1 == null) {
          break label425;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next()).xrd);
        }
        bool = true;
        continue;
        if (this.xbu.fGo == 34) {
          bool = true;
        } else {
          bool = false;
        }
      }
      label268:
      Object localObject4;
      label425:
      for (Object localObject1 = (List)localObject1;; localObject1 = null)
      {
        au.a((List)localObject1, this.xbu);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramb).sCr == ((com.tencent.mm.plugin.finder.event.base.l)paramb).xrh) && (((com.tencent.mm.plugin.finder.event.base.l)paramb).xrj == ((com.tencent.mm.plugin.finder.event.base.l)paramb).sCs)) {
          break label1026;
        }
        localObject1 = new HashSet();
        localObject2 = new HashSet();
        ((HashSet)localObject1).addAll((Collection)this.zWQ.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).xrr;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          ((HashSet)localObject1).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf()));
          ((HashSet)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).xrq;
      label538:
      long l1;
      long l2;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject1).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()))) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label538;
            }
            ((Collection)localObject3).add(localObject5);
            break;
          }
        }
        localObject3 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf();
          l2 = paramb.xqG;
          if ((((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd instanceof BaseFinderFeed))
          {
            localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd;
            if (localObject1 == null)
            {
              paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(226056);
              throw paramb;
            }
          }
          for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
          {
            localObject1 = new aa(l1, l2, (FinderItem)localObject1);
            ((aa)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xre;
            ((aa)localObject1).xrf = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrf;
            a((aa)localObject1, true);
            break;
          }
        }
      }
      localObject1 = ((Map)this.zWQ).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject2).contains(((Map.Entry)localObject3).getKey())) {
          a((aa)((Map.Entry)localObject3).getValue(), false);
        }
      }
      Object localObject2 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).xrr;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          localObject1 = (aa)this.zWQ.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf()));
          if (localObject1 != null)
          {
            ((HashMap)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf()), localObject1);
          }
          else
          {
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf();
            l2 = paramb.xqG;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd instanceof BaseFinderFeed))
            {
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd;
              if (localObject1 == null)
              {
                paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(226056);
                throw paramb;
              }
            }
            for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
            {
              localObject1 = new aa(l1, l2, (FinderItem)localObject1);
              ((aa)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xre;
              ((aa)localObject1).xrf = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrf;
              ((HashMap)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf()), localObject1);
              break;
            }
          }
        }
      }
      this.zWQ = ((HashMap)localObject2);
    }
    label1026:
    AppMethodBeat.o(226056);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    AppMethodBeat.i(226040);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(226040);
      return true;
    }
    AppMethodBeat.o(226040);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(226057);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(226057);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(226037);
    onExit();
    super.onRelease();
    AppMethodBeat.o(226037);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.z
 * JD-Core Version:    0.7.0.1
 */
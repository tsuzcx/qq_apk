package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
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
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"})
public final class v
  extends e
{
  public static final a vhK;
  private HashMap<Long, w> vfK;
  
  static
  {
    AppMethodBeat.i(250813);
    vhK = new a((byte)0);
    AppMethodBeat.o(250813);
  }
  
  public v(MMFragmentActivity paramMMFragmentActivity, bbn parambbn)
  {
    super(paramMMFragmentActivity, parambbn);
    AppMethodBeat.i(250812);
    this.vfK = new HashMap();
    AppMethodBeat.o(250812);
  }
  
  private final ecq a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(250806);
    if (paramw.endTime == 0L) {
      paramw.endTime = cl.aWA();
    }
    Object localObject1 = w.vhM;
    p.h(paramw, "record");
    ecq localecq = new ecq();
    Object localObject3 = new BitSet(64);
    localecq.hFK = paramw.feedId;
    localObject1 = paramw.tHo;
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
    localecq.objectNonceId = ((String)localObject1);
    localecq.NcM = new mp();
    localecq.NcN = new epf();
    localecq.NcO = new cxr();
    localObject1 = paramw.tHo;
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
    localecq.finderUsername = ((String)localObject1);
    float f = (float)(paramw.endTime - paramw.startTime) / 1000.0F;
    int i;
    if (f < 0.5F)
    {
      ((BitSet)localObject3).set(21, true);
      l = localObject3.toLongArray()[0];
      localObject1 = localecq.NcM;
      if (localObject1 != null) {
        ((mp)localObject1).KQT = l;
      }
      localObject1 = localecq.NcN;
      if (localObject1 != null) {
        ((epf)localObject1).ElR = ((int)f);
      }
      localObject1 = localecq.NcO;
      if (localObject1 != null) {
        ((cxr)localObject1).MCg = ((int)f);
      }
      localObject1 = localecq.NcO;
      if (localObject1 != null) {
        ((cxr)localObject1).MCp = paramw.vfP;
      }
      localObject1 = localecq.NcO;
      if (localObject1 != null)
      {
        if (!paramBoolean) {
          break label1251;
        }
        i = 0;
        label308:
        ((cxr)localObject1).MCo = i;
      }
      localObject1 = paramw.tHo;
      if (localObject1 != null)
      {
        localObject2 = localecq.NcO;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getLikeFlag() == 0) {
            break label1257;
          }
          i = 1;
          label349:
          ((cxr)localObject2).MCl = i;
        }
        localObject2 = localecq.NcO;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.api.c.tsp;
          if (!c.a.asJ(((FinderItem)localObject1).getUserName())) {
            break label1263;
          }
          i = 1;
          label387:
          ((cxr)localObject2).vPj = i;
        }
        localObject2 = localecq.NcO;
        if (localObject2 != null)
        {
          if (((FinderItem)localObject1).getFavFlag() != 1) {
            break label1269;
          }
          i = 1;
          label418:
          ((cxr)localObject2).MCn = i;
        }
      }
      bbn localbbn = this.ttO;
      p.h(localbbn, "contextObj");
      p.h(paramw, "record");
      localObject3 = new cd();
      ((cd)localObject3).fv(localbbn.tCE);
      ((cd)localObject3).le(d.zs(paramw.feedId));
      ((cd)localObject3).lb(localbbn.sessionId);
      ((cd)localObject3).lc(localbbn.sGQ);
      ((cd)localObject3).ld(localbbn.sGE);
      ((cd)localObject3).fz(paramw.startTime);
      ((cd)localObject3).fA(paramw.endTime);
      ((cd)localObject3).fy(paramw.endTime - paramw.startTime);
      FinderItem localFinderItem = paramw.tHo;
      if (localFinderItem != null)
      {
        ((cd)localObject3).fB(localFinderItem.getLikeCount());
        localObject1 = localbbn.wza;
        if (localObject1 != null)
        {
          localObject2 = n.j((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((cd)localObject3).lg((String)localObject1);
        ((cd)localObject3).fC(localFinderItem.getMediaType());
      }
      ((cd)localObject3).fw(paramw.vfP);
      localObject1 = k.vfA;
      ((cd)localObject3).fx(k.Kt(localbbn.tCE));
      localObject1 = w.vhM;
      ((cd)localObject3).lf(n.j(w.a.a(paramw), ",", ";", false));
      localObject1 = k.vfA;
      ((cd)localObject3).lh(k.G(paramw.feedId, localbbn.tCE));
      if (localbbn.tCE == 15)
      {
        localObject1 = paramw.tHo;
        if (localObject1 == null) {
          break label1275;
        }
        localObject1 = ((FinderItem)localObject1).getFeedObject();
        label734:
        if (localObject1 == null) {}
      }
      switch (paramw.tHo.getFeedObject().recommendReasonType)
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
        ((cd)localObject3).fD(l);
        localObject2 = paramw.tHo.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((cd)localObject3).li((String)localObject1);
        localObject1 = paramw.tHo;
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
                ((cd)localObject3).lk(d.zs(((azs)localObject1).twd));
                ((cd)localObject3).acZ();
              }
            }
          }
        }
        localObject1 = paramw.tHo;
        if (localObject1 == null) {
          break label1344;
        }
        localObject1 = ((FinderItem)localObject1).getFinderObject();
        if (localObject1 == null) {
          break label1344;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null) {
          break label1344;
        }
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 == null) {
          break label1344;
        }
        ((cd)localObject3).lj(((azr)localObject1).groupId);
        if (((azr)localObject1).musicInfo != null)
        {
          paramw = ((azr)localObject1).musicInfo;
          if (paramw != null)
          {
            paramw = paramw.wWb;
            label1008:
            paramw = (CharSequence)paramw;
            if ((paramw != null) && (paramw.length() != 0)) {
              break label1332;
            }
            i = 1;
            label1029:
            if (i != 0) {
              break label1338;
            }
          }
        }
        break;
      }
    }
    label1332:
    label1338:
    for (long l = 2L;; l = 1L)
    {
      ((cd)localObject3).fE(l);
      ((cd)localObject3).eOp();
      paramw = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(250806);
      return localecq;
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
      label1251:
      i = 1;
      break label308;
      label1257:
      i = 0;
      break label349;
      label1263:
      i = 0;
      break label387;
      label1269:
      i = 0;
      break label418;
      label1275:
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
      paramw = null;
      break label1008;
      i = 0;
      break label1029;
    }
    label1344:
    localObject1 = paramw.tHo;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getFinderObject();
      if (localObject1 == null) {}
    }
    for (l = ((FinderObject)localObject1).id;; l = 0L)
    {
      ((cd)localObject3).lj(d.zs(l));
      paramw = paramw.tHo;
      if ((paramw == null) || (paramw.getMediaType() != 4)) {
        break;
      }
      ((cd)localObject3).fE(1L);
      break;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(250808);
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    d.c(FinderReporterUIC.dIB(), (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(250808);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(250810);
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      boolean bool;
      switch (this.ttO.tCE)
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
        Log.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.ttO.tCE + " fromCommentScene:" + this.ttO.tyh);
        if (!bool) {
          break label268;
        }
        localObject1 = as.uOL;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).tIH;
        if (localObject1 == null) {
          break label425;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).tIu);
        }
        bool = true;
        continue;
        if (this.ttO.tyh == 34) {
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
        as.a((List)localObject1, this.ttO);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramb).ptb == ((com.tencent.mm.plugin.finder.event.base.l)paramb).tIy) && (((com.tencent.mm.plugin.finder.event.base.l)paramb).tIA == ((com.tencent.mm.plugin.finder.event.base.l)paramb).ptc)) {
          break label970;
        }
        localObject1 = new HashSet();
        localObject2 = new HashSet();
        ((HashSet)localObject1).addAll((Collection)this.vfK.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).tII;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          ((HashSet)localObject1).add(Long.valueOf(((g)localObject4).tIu.lT()));
          ((HashSet)localObject2).add(Long.valueOf(((g)localObject4).tIu.lT()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).tIH;
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
          if (!((HashSet)localObject1).contains(Long.valueOf(((g)localObject5).tIu.lT()))) {}
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
          localObject4 = (g)((Iterator)localObject3).next();
          l1 = ((g)localObject4).tIu.lT();
          l2 = paramb.tHW;
          if ((((g)localObject4).tIu instanceof BaseFinderFeed)) {}
          for (localObject1 = ((BaseFinderFeed)((g)localObject4).tIu).feedObject;; localObject1 = null)
          {
            localObject1 = new w(l1, l2, (FinderItem)localObject1);
            ((w)localObject1).vfP = ((g)localObject4).tIv;
            ((w)localObject1).tIw = ((g)localObject4).tIw;
            a((w)localObject1, true);
            break;
          }
        }
      }
      localObject1 = ((Map)this.vfK).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject2).contains(((Map.Entry)localObject3).getKey())) {
          a((w)((Map.Entry)localObject3).getValue(), false);
        }
      }
      Object localObject2 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramb).tII;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          localObject1 = (w)this.vfK.get(Long.valueOf(((g)localObject4).tIu.lT()));
          if (localObject1 != null)
          {
            ((HashMap)localObject2).put(Long.valueOf(((g)localObject4).tIu.lT()), localObject1);
          }
          else
          {
            l1 = ((g)localObject4).tIu.lT();
            l2 = paramb.tHW;
            if ((((g)localObject4).tIu instanceof BaseFinderFeed)) {}
            for (localObject1 = ((BaseFinderFeed)((g)localObject4).tIu).feedObject;; localObject1 = null)
            {
              localObject1 = new w(l1, l2, (FinderItem)localObject1);
              ((w)localObject1).vfP = ((g)localObject4).tIv;
              ((w)localObject1).tIw = ((g)localObject4).tIw;
              ((HashMap)localObject2).put(Long.valueOf(((g)localObject4).tIu.lT()), localObject1);
              break;
            }
          }
        }
      }
      this.vfK = ((HashMap)localObject2);
    }
    label970:
    AppMethodBeat.o(250810);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    AppMethodBeat.i(250809);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(250809);
      return true;
    }
    AppMethodBeat.o(250809);
    return false;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(250811);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(250811);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(250807);
    onExit();
    super.onRelease();
    AppMethodBeat.o(250807);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.v
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public final class ae
  extends e
{
  public static final a vix;
  private ConcurrentLinkedQueue<ecq> vfE;
  p vfI;
  HashSet<Long> vfJ;
  HashMap<Long, p> vfK;
  
  static
  {
    AppMethodBeat.i(250845);
    vix = new a((byte)0);
    AppMethodBeat.o(250845);
  }
  
  public ae(MMFragmentActivity paramMMFragmentActivity, bbn parambbn)
  {
    super(paramMMFragmentActivity, parambbn);
    AppMethodBeat.i(250844);
    this.vfE = new ConcurrentLinkedQueue();
    this.vfJ = new HashSet();
    this.vfK = new HashMap();
    AppMethodBeat.o(250844);
  }
  
  private final void a(p paramp, ecq paramecq)
  {
    AppMethodBeat.i(250838);
    bm localbm = paramp.uJO;
    if (localbm != null)
    {
      long l1 = localbm.dkW();
      if (paramp.vfV > 0) {
        e.a.a(this.ttO, l1, 5, String.valueOf(paramp.vfV), paramp.uOV, localbm);
      }
      long l2 = paramp.endTime;
      long l3 = paramp.startTime;
      e.a.a(this.ttO, l1, 2, String.valueOf(l2 - l3), paramp.uOV, localbm);
      if (paramp.vfY > 0) {
        e.a.a(this.ttO, l1, 11, String.valueOf(paramp.vfY), paramp.uOV, localbm);
      }
      Object localObject = this.ttO;
      paramecq = paramecq.NcM;
      if (paramecq != null) {}
      for (paramecq = Long.valueOf(paramecq.KQT);; paramecq = "")
      {
        e.a.a((bbn)localObject, l1, 3, String.valueOf(paramecq), paramp.uOV, localbm);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("netType", paramp.netType);
        ((JSONObject)localObject).put("isPause", paramp.vgq);
        ((JSONObject)localObject).put("isSeek", paramp.vgr);
        ((JSONObject)localObject).put("playProgressInfo", paramp.vgs);
        ((JSONObject)localObject).put("maxPlayPercent", paramp.vfY);
        ((JSONObject)localObject).put("maxPlayLength", paramp.vfX);
        ((JSONObject)localObject).put("videoDuration", paramp.videoDuration);
        ((JSONObject)localObject).put("playTime", paramp.vgo);
        ((JSONObject)localObject).put("realPlayTime", paramp.vgm);
        ((JSONObject)localObject).put("voiceInfo", paramp.vgw);
        ((JSONObject)localObject).put("playFormat", paramp.vgx);
        paramecq = this.ttO;
        localObject = ((JSONObject)localObject).toString();
        kotlin.g.b.p.g(localObject, "playInfoObj.toString()");
        e.a.a(paramecq, l1, 17, n.j((String)localObject, ",", ";", false), paramp.uOV, localbm);
        paramecq = c.vdc;
        paramecq = c.EY(paramp.feedId);
        if (!Util.isNullOrNil(paramecq)) {
          e.a.a(this.ttO, l1, 18, paramecq, paramp.uOV, localbm);
        }
        AppMethodBeat.o(250838);
        return;
      }
    }
    AppMethodBeat.o(250838);
  }
  
  private final ecq d(p paramp)
  {
    AppMethodBeat.i(250840);
    p.c(paramp);
    Object localObject = p.vgC;
    localObject = p.a.a(paramp, this.ttO);
    bm localbm = paramp.uJO;
    if (localbm != null)
    {
      long l = localbm.dkW();
      e.a.a(this.ttO, l, 14, String.valueOf(paramp.endTime - paramp.startTime), 0L, localbm, 16);
    }
    AppMethodBeat.o(250840);
    return localObject;
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(250837);
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    d.c(FinderReporterUIC.dIB(), (a)new c(this));
    AppMethodBeat.o(250837);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(250839);
    kotlin.g.b.p.h(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label358:
    Object localObject5;
    long l1;
    long l2;
    label442:
    Object localObject6;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!this.visible)
      {
        Log.i("MegaVideoFeedFlowReporter", this.ttO.tCE + " not visible");
        AppMethodBeat.o(250839);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      Object localObject7;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtF().value()).intValue() == 1)
      {
        localObject1 = as.uOL;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIH;
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).tIu);
          }
          localObject1 = (List)localObject1;
          as.a((List)localObject1, this.ttO);
        }
      }
      else
      {
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).tCi == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptb == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIy) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptc == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIA)) {
          break label1391;
        }
        localObject3 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).tCi == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC) {
          break label544;
        }
        localObject1 = this.vfI;
        if (localObject1 != null)
        {
          ((p)localObject1).a(this.vdR);
          localObject2 = p.vgC;
          localObject2 = p.a.a((p)localObject1, this.ttO);
          ((LinkedList)localObject3).add(localObject2);
          a((p)localObject1, (ecq)localObject2);
          localObject1 = x.SXb;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
        if (localObject1 == null) {
          break label544;
        }
        localObject4 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (g)((Iterator)localObject4).next();
        } while (((g)localObject5).tIu.lT() != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC);
        l1 = ((g)localObject5).tIu.lT();
        l2 = paramb.tHW;
        if (!(((g)localObject5).tIu instanceof BaseFinderFeed)) {
          break label527;
        }
        localObject1 = ((BaseFinderFeed)((g)localObject5).tIu).feedObject;
        localObject6 = ((g)localObject5).tIw;
        localObject7 = this.vdR;
        if (!(((g)localObject5).tIu instanceof bm)) {
          break label533;
        }
      }
      label527:
      label533:
      for (localObject2 = (bm)((g)localObject5).tIu;; localObject2 = null)
      {
        localObject1 = new p(l1, l2, (FinderItem)localObject1, (i)localObject6, true, (com.tencent.mm.plugin.finder.video.reporter.b)localObject7, (bm)localObject2);
        ((p)localObject1).vfP = ((g)localObject5).tIv;
        localObject2 = x.SXb;
        this.vfI = ((p)localObject1);
        break label358;
        localObject1 = null;
        break;
        localObject1 = null;
        break label442;
      }
      localObject1 = x.SXb;
      label544:
      localObject5 = new HashSet();
      localObject4 = new HashSet();
      ((HashSet)localObject5).addAll((Collection)this.vfK.keySet());
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (g)((Iterator)localObject1).next();
          ((HashSet)localObject5).add(Long.valueOf(((g)localObject2).tIu.lT()));
          ((HashSet)localObject4).add(Long.valueOf(((g)localObject2).tIu.lT()));
        }
        localObject1 = x.SXb;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIH;
      if (localObject1 != null)
      {
        localObject6 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (g)((Iterator)localObject6).next();
          if (!((HashSet)localObject5).contains(Long.valueOf(((g)localObject7).tIu.lT())))
          {
            l1 = ((g)localObject7).tIu.lT();
            l2 = paramb.tHW;
            label782:
            i locali;
            if ((((g)localObject7).tIu instanceof BaseFinderFeed))
            {
              localObject1 = ((BaseFinderFeed)((g)localObject7).tIu).feedObject;
              locali = ((g)localObject7).tIw;
              if (!(((g)localObject7).tIu instanceof bm)) {
                break label868;
              }
            }
            label868:
            for (localObject2 = (bm)((g)localObject7).tIu;; localObject2 = null)
            {
              localObject1 = new p(l1, l2, (FinderItem)localObject1, locali, false, null, (bm)localObject2, 48);
              ((p)localObject1).vgy = ((g)localObject7).tIu;
              ((LinkedList)localObject3).add(d((p)localObject1));
              localObject1 = x.SXb;
              break;
              localObject1 = null;
              break label782;
            }
          }
        }
        localObject1 = x.SXb;
      }
      localObject1 = ((Map)this.vfK).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject4).contains(((Map.Entry)localObject2).getKey())) {
          ((LinkedList)localObject3).add(d((p)((Map.Entry)localObject2).getValue()));
        }
      }
      localObject4 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (g)((Iterator)localObject5).next();
          localObject1 = (p)this.vfK.get(Long.valueOf(((g)localObject6).tIu.lT()));
          if (localObject1 != null)
          {
            ((p)localObject1).vgy = ((g)localObject6).tIu;
            if ((p)((HashMap)localObject4).put(Long.valueOf(((g)localObject6).tIu.lT()), localObject1) != null) {
              break;
            }
          }
          else
          {
            l1 = ((g)localObject6).tIu.lT();
            l2 = paramb.tHW;
            if ((((g)localObject6).tIu instanceof BaseFinderFeed))
            {
              localObject1 = ((BaseFinderFeed)((g)localObject6).tIu).feedObject;
              label1122:
              localObject7 = ((g)localObject6).tIw;
              if (!(((g)localObject6).tIu instanceof bm)) {
                break label1222;
              }
            }
            label1222:
            for (localObject2 = (bm)((g)localObject6).tIu;; localObject2 = null)
            {
              localObject1 = new p(l1, l2, (FinderItem)localObject1, (i)localObject7, false, null, (bm)localObject2, 48);
              ((p)localObject1).vgy = ((g)localObject6).tIu;
              ((p)localObject1).vfP = ((g)localObject6).tIv;
              ((HashMap)localObject4).put(Long.valueOf(((g)localObject6).tIu.lT()), localObject1);
              break;
              localObject1 = null;
              break label1122;
            }
          }
        }
        localObject1 = x.SXb;
      }
      this.vfK = ((HashMap)localObject4);
      this.vfE.addAll((Collection)localObject3);
      if (this.vfE.size() > 20)
      {
        localObject1 = FinderReporterUIC.wzC;
        d.c(FinderReporterUIC.dIB(), (a)new b(this));
      }
      localObject1 = new StringBuilder("waitForReportStatsList ");
      localObject3 = (Iterable)this.vfE;
      localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(d.zs(((ecq)((Iterator)localObject3).next()).hFK));
      }
      Log.i("MegaVideoFeedFlowReporter", (List)localObject2);
      label1391:
      if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).ptb != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIy) || (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptc != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIA))
      {
        this.vfJ = new HashSet();
        localObject2 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIJ;
        if (localObject2 != null)
        {
          localObject1 = this.vfJ;
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(Long.valueOf(((bo)((Iterator)localObject3).next()).lT()));
          }
          ((HashSet)localObject1).addAll((Collection)localObject2);
        }
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (g)((Iterator)localObject3).next();
          localObject4 = ((g)localObject2).tIw;
          if (localObject4 != null)
          {
            if (((i)localObject4).Rrg)
            {
              localObject5 = this.ttO;
              l1 = ((g)localObject2).tIu.lT();
              l2 = paramb.tHW;
              if (!(((g)localObject2).tIu instanceof BaseFinderFeed)) {
                break label1756;
              }
              localObject1 = ((BaseFinderFeed)((g)localObject2).tIu).feedObject;
              label1659:
              if (!(((g)localObject2).tIu instanceof bm)) {
                break label1762;
              }
            }
            label1756:
            label1762:
            for (localObject2 = (bm)((g)localObject2).tIu;; localObject2 = null)
            {
              e.a.a((bbn)localObject5, new p(l1, l2, (FinderItem)localObject1, (i)localObject4, false, null, (bm)localObject2, 48));
              ((i)localObject4).Rrg = false;
              localObject1 = ((i)localObject4).Rri;
              if (localObject1 != null)
              {
                localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
                if (localObject1 != null)
                {
                  ((WxRecyclerAdapter)localObject1).onPause();
                  localObject1 = x.SXb;
                }
              }
              localObject1 = x.SXb;
              break;
              localObject1 = null;
              break label1659;
            }
          }
        }
        paramb = x.SXb;
        AppMethodBeat.o(250839);
        return;
      }
      AppMethodBeat.o(250839);
      return;
    }
    int i;
    if ((paramb instanceof a.a))
    {
      localObject2 = null;
      localObject5 = null;
      localObject4 = null;
      localObject3 = null;
      localObject6 = null;
      i = ((a.a)paramb).type;
      localObject1 = a.a.tHJ;
      if (i == a.a.cZT())
      {
        localObject1 = this.vfI;
        if (localObject1 != null) {
          if (((p)localObject1).feedId == ((a.a)paramb).feedId)
          {
            i = 1;
            if (i == 0) {
              break label2063;
            }
            label1861:
            if (localObject1 == null) {
              break label2075;
            }
            ((p)localObject1).msj += 1;
            i = ((p)localObject1).vgd;
            ((p)localObject1).vgd = (i + 1);
            localObject1 = localObject6;
            label1896:
            localObject2 = k.vfA;
            localObject2 = k.Fd(((a.a)paramb).feedId);
            if (localObject2 == null) {
              break label2159;
            }
            l1 = ((bm)localObject2).dkW();
            paramb = this.ttO;
            localObject3 = e.c.vdX;
            e.a.a(paramb, l1, 1, e.c.dnN(), 0L, (bm)localObject2, 16);
            paramb = this.ttO;
            localObject3 = z.aTY();
            kotlin.g.b.p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            localObject3 = e.a.a(10, new String[] { "1", localObject3 }).toString();
            kotlin.g.b.p.g(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
            e.a.a(paramb, l1, 10, (String)localObject3, 0L, (bm)localObject2, 16);
            paramb = x.SXb;
            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          }
        }
      }
      for (;;)
      {
        if (paramb != null)
        {
          p.c(paramb);
          localObject1 = p.vgC;
          paramb = p.a.a(paramb, this.ttO);
          this.vfE.add(paramb);
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          label2063:
          localObject1 = null;
          break label1861;
          localObject1 = null;
          break label1861;
          label2075:
          l1 = ((a.a)paramb).feedId;
          l2 = paramb.tHW;
          localObject1 = k.vfA;
          localObject1 = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
          ((p)localObject1).msj += 1;
          ((p)localObject1).vgd += 1;
          localObject2 = x.SXb;
          localObject2 = x.SXb;
          break label1896;
          label2159:
          Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_SNS mega video is null id = " + ((a.a)paramb).feedId);
          paramb = x.SXb;
          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          continue;
          localObject1 = a.a.tHJ;
          if (i == a.a.cZS())
          {
            localObject1 = this.vfI;
            if (localObject1 != null) {
              if (((p)localObject1).feedId == ((a.a)paramb).feedId)
              {
                i = 1;
                label2239:
                if (i == 0) {
                  break label2398;
                }
                label2243:
                if (localObject1 == null) {
                  break label2410;
                }
                i = ((p)localObject1).msj;
                ((p)localObject1).msj = (i + 1);
                localObject1 = localObject5;
              }
            }
            for (;;)
            {
              localObject2 = k.vfA;
              localObject2 = k.Fd(((a.a)paramb).feedId);
              if (localObject2 == null) {
                break label2482;
              }
              l1 = ((bm)localObject2).dkW();
              paramb = this.ttO;
              localObject3 = e.c.vdX;
              e.a.a(paramb, l1, 1, e.c.dnN(), 0L, (bm)localObject2, 16);
              paramb = this.ttO;
              localObject3 = z.aTY();
              kotlin.g.b.p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localObject3 = e.a.a(10, new String[] { "2", localObject3 }).toString();
              kotlin.g.b.p.g(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              e.a.a(paramb, l1, 10, (String)localObject3, 0L, (bm)localObject2, 16);
              paramb = x.SXb;
              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
              break;
              i = 0;
              break label2239;
              label2398:
              localObject1 = null;
              break label2243;
              localObject1 = null;
              break label2243;
              label2410:
              l1 = ((a.a)paramb).feedId;
              l2 = paramb.tHW;
              localObject1 = k.vfA;
              localObject1 = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
              ((p)localObject1).msj += 1;
              localObject2 = x.SXb;
              localObject2 = x.SXb;
            }
            label2482:
            Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_CHAT mega video is null id = " + ((a.a)paramb).feedId);
            paramb = x.SXb;
            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          }
          else
          {
            localObject1 = a.a.tHJ;
            if (i == a.a.cZV())
            {
              localObject1 = k.vfA;
              localObject1 = k.Fd(((a.a)paramb).feedId);
              if (localObject1 != null)
              {
                l1 = ((bm)localObject1).dkW();
                paramb = this.ttO;
                localObject3 = z.aTY();
                kotlin.g.b.p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                localObject3 = e.a.a(13, new String[] { "1", localObject3 }).toString();
                kotlin.g.b.p.g(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                e.a.a(paramb, l1, 13, (String)localObject3, 0L, (bm)localObject1, 16);
                paramb = x.SXb;
                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
              }
              else
              {
                Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_SNS mega video is null id = " + ((a.a)paramb).feedId);
                paramb = x.SXb;
                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
              }
            }
            else
            {
              localObject1 = a.a.tHJ;
              if (i == a.a.cZU())
              {
                localObject1 = k.vfA;
                localObject1 = k.Fd(((a.a)paramb).feedId);
                if (localObject1 != null)
                {
                  l1 = ((bm)localObject1).dkW();
                  paramb = this.ttO;
                  localObject3 = z.aTY();
                  kotlin.g.b.p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  localObject3 = e.a.a(13, new String[] { "2", localObject3 }).toString();
                  kotlin.g.b.p.g(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  e.a.a(paramb, l1, 13, (String)localObject3, 0L, (bm)localObject1, 16);
                  paramb = x.SXb;
                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                }
                else
                {
                  Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_CHAT mega video is null id = " + ((a.a)paramb).feedId);
                  paramb = x.SXb;
                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                }
              }
              else
              {
                localObject1 = a.a.tHJ;
                if (i == a.a.daa())
                {
                  localObject1 = this.vfI;
                  if (localObject1 != null) {
                    if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label2870:
                      if (i == 0) {
                        break label2967;
                      }
                      label2874:
                      if (localObject1 == null) {
                        break label2979;
                      }
                      ((p)localObject1).vga += 1;
                      localObject1 = localObject4;
                      label2895:
                      localObject2 = k.vfA;
                      localObject2 = k.Fd(((a.a)paramb).feedId);
                      if (localObject2 == null) {
                        break label3046;
                      }
                      l1 = ((bm)localObject2).dkW();
                      paramb = this.ttO;
                      localObject3 = e.c.vdX;
                      e.a.a(paramb, l1, 7, e.c.dnN(), 0L, (bm)localObject2, 16);
                    }
                  }
                  for (paramb = x.SXb;; paramb = x.SXb)
                  {
                    paramb = x.SXb;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label2870;
                    label2967:
                    localObject1 = null;
                    break label2874;
                    localObject1 = null;
                    break label2874;
                    label2979:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.tHW;
                    localObject1 = k.vfA;
                    localObject1 = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                    ((p)localObject1).vga += 1;
                    localObject2 = x.SXb;
                    break label2895;
                    label3046:
                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CLICK_AVATAR mega video is null id = " + ((a.a)paramb).feedId);
                  }
                }
                localObject1 = a.a.tHJ;
                if (i == a.a.dab())
                {
                  localObject1 = this.vfI;
                  if (localObject1 != null) {
                    if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label3123:
                      if (i == 0) {
                        break label3220;
                      }
                      label3127:
                      if (localObject1 == null) {
                        break label3232;
                      }
                      ((p)localObject1).vgb += 1;
                      localObject1 = localObject3;
                      label3148:
                      localObject2 = k.vfA;
                      localObject2 = k.Fd(((a.a)paramb).feedId);
                      if (localObject2 == null) {
                        break label3299;
                      }
                      l1 = ((bm)localObject2).dkW();
                      paramb = this.ttO;
                      localObject3 = e.c.vdX;
                      e.a.a(paramb, l1, 16, e.c.dnN(), 0L, (bm)localObject2, 16);
                    }
                  }
                  for (paramb = x.SXb;; paramb = x.SXb)
                  {
                    paramb = x.SXb;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label3123;
                    label3220:
                    localObject1 = null;
                    break label3127;
                    localObject1 = null;
                    break label3127;
                    label3232:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.tHW;
                    localObject1 = k.vfA;
                    localObject1 = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                    ((p)localObject1).vgb += 1;
                    localObject2 = x.SXb;
                    break label3148;
                    label3299:
                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.FAV mega video is null id = " + ((a.a)paramb).feedId);
                  }
                }
                localObject1 = a.a.tHJ;
                if (i == a.a.dad())
                {
                  localObject1 = this.vfI;
                  if (localObject1 != null) {
                    if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label3376:
                      if (i == 0) {
                        break label3410;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label3422;
                    }
                    i = ((p)localObject1).vgl;
                    ((p)localObject1).vgl = (i + 1);
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                    break;
                    i = 0;
                    break label3376;
                    label3410:
                    localObject1 = null;
                    continue;
                    localObject1 = null;
                  }
                  label3422:
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.tHW;
                  localObject1 = k.vfA;
                  paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                  paramb.vgl += 1;
                  localObject1 = x.SXb;
                  localObject1 = x.SXb;
                }
                else
                {
                  localObject1 = a.a.tHJ;
                  if (i == a.a.cZW())
                  {
                    localObject1 = this.vfI;
                    if (localObject1 != null) {
                      if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                      {
                        i = 1;
                        label3532:
                        if (i == 0) {
                          break label3566;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject1 == null) {
                        break label3578;
                      }
                      i = ((p)localObject1).vgc;
                      ((p)localObject1).vgc = (i + 1);
                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                      break;
                      i = 0;
                      break label3532;
                      label3566:
                      localObject1 = null;
                      continue;
                      localObject1 = null;
                    }
                    label3578:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.tHW;
                    localObject1 = k.vfA;
                    paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                    paramb.vgc += 1;
                    localObject1 = x.SXb;
                    localObject1 = x.SXb;
                  }
                  else
                  {
                    localObject1 = a.a.tHJ;
                    if (i == a.a.dae())
                    {
                      localObject1 = this.vfI;
                      if (localObject1 != null) {
                        if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                        {
                          i = 1;
                          label3688:
                          if (i == 0) {
                            break label3722;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label3734;
                        }
                        i = ((p)localObject1).vgf;
                        ((p)localObject1).vgf = (i + 1);
                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                        break;
                        i = 0;
                        break label3688;
                        label3722:
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      label3734:
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.tHW;
                      localObject1 = k.vfA;
                      paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                      paramb.vgf += 1;
                      localObject1 = x.SXb;
                      localObject1 = x.SXb;
                    }
                    else
                    {
                      localObject1 = a.a.tHJ;
                      if (i == a.a.daf())
                      {
                        localObject1 = this.vfI;
                        if (localObject1 != null) {
                          if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                          {
                            i = 1;
                            label3844:
                            if (i == 0) {
                              break label3878;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label3890;
                          }
                          i = ((p)localObject1).vge;
                          ((p)localObject1).vge = (i + 1);
                          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                          break;
                          i = 0;
                          break label3844;
                          label3878:
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        label3890:
                        l1 = ((a.a)paramb).feedId;
                        l2 = paramb.tHW;
                        localObject1 = k.vfA;
                        paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                        paramb.vge += 1;
                        localObject1 = x.SXb;
                        localObject1 = x.SXb;
                      }
                      else
                      {
                        localObject1 = a.a.tHJ;
                        if (i == a.a.dag())
                        {
                          localObject1 = this.vfI;
                          if (localObject1 != null) {
                            if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                            {
                              i = 1;
                              label4000:
                              if (i == 0) {
                                break label4034;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4046;
                            }
                            i = ((p)localObject1).vgg;
                            ((p)localObject1).vgg = (i + 1);
                            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                            break;
                            i = 0;
                            break label4000;
                            label4034:
                            localObject1 = null;
                            continue;
                            localObject1 = null;
                          }
                          label4046:
                          l1 = ((a.a)paramb).feedId;
                          l2 = paramb.tHW;
                          localObject1 = k.vfA;
                          paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                          paramb.vgg += 1;
                          localObject1 = x.SXb;
                          localObject1 = x.SXb;
                        }
                        else
                        {
                          localObject1 = a.a.tHJ;
                          if (i == a.a.dah())
                          {
                            localObject1 = this.vfI;
                            if (localObject1 != null) {
                              if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                              {
                                i = 1;
                                label4156:
                                if (i == 0) {
                                  break label4190;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4202;
                              }
                              i = ((p)localObject1).vgj;
                              ((p)localObject1).vgj = (i + 1);
                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                              break;
                              i = 0;
                              break label4156;
                              label4190:
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            label4202:
                            l1 = ((a.a)paramb).feedId;
                            l2 = paramb.tHW;
                            localObject1 = k.vfA;
                            paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                            paramb.vgj += 1;
                            localObject1 = x.SXb;
                            localObject1 = x.SXb;
                          }
                          else
                          {
                            localObject1 = a.a.tHJ;
                            if (i == a.a.dai())
                            {
                              localObject1 = this.vfI;
                              if (localObject1 != null) {
                                if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                                {
                                  i = 1;
                                  label4312:
                                  if (i == 0) {
                                    break label4346;
                                  }
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 == null) {
                                  break label4358;
                                }
                                i = ((p)localObject1).vgk;
                                ((p)localObject1).vgk = (i + 1);
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                break;
                                i = 0;
                                break label4312;
                                label4346:
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              label4358:
                              l1 = ((a.a)paramb).feedId;
                              l2 = paramb.tHW;
                              localObject1 = k.vfA;
                              paramb = new p(l1, l2, null, null, false, null, k.Fd(((a.a)paramb).feedId), 56);
                              paramb.vgk += 1;
                              localObject1 = x.SXb;
                              localObject1 = x.SXb;
                            }
                            else
                            {
                              paramb = a.a.tHJ;
                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                              if (i != a.a.daj())
                              {
                                paramb = a.a.tHJ;
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                if (i != a.a.dak())
                                {
                                  paramb = a.a.tHJ;
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                  if (i != a.a.dal())
                                  {
                                    AppMethodBeat.o(250839);
                                    return;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(250839);
      return;
    }
    if ((paramb instanceof c.a)) {
      switch (((c.a)paramb).type)
      {
      }
    }
    label4742:
    label5510:
    for (;;)
    {
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4650;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4656;
          }
          ((p)localObject1).vgp = paramb.tHW;
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          label4650:
          localObject1 = null;
        }
      }
      label4656:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4742;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4748;
          }
          if (((p)localObject1).vgp != 0L) {
            ((p)localObject1).vgo = (paramb.tHW - ((p)localObject1).vgp);
          }
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      label4748:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4818;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4824;
          }
          ((p)localObject1).vgn = paramb.tHW;
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          label4818:
          localObject1 = null;
        }
      }
      label4824:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4915;
          }
        }
        label4915:
        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
        {
          if (paramb == null) {
            break label4920;
          }
          paramb.vfT[paramb.vfU] += 1;
          i = paramb.vfV;
          paramb.vfV = (i + 1);
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
        }
      }
      label4920:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5077;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label5083;
          }
          ((p)localObject1).vgt.add(Integer.valueOf(((c.a)paramb).offset));
          i = (int)(100.0F * ((c.a)paramb).offset / ((c.a)paramb).jcu);
          if (i > localObject1.vfS[localObject1.vfU]) {
            ((p)localObject1).vfS[localObject1.vfU] = i;
          }
          if (i > ((p)localObject1).vfY)
          {
            ((p)localObject1).vfX = ((c.a)paramb).offset;
            ((p)localObject1).vfY = i;
          }
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          label5077:
          localObject1 = null;
        }
      }
      label5083:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5181;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label5187;
          }
          if (((p)localObject1).vgn != 0L)
          {
            ((p)localObject1).vgm += paramb.tHW - ((p)localObject1).vgn;
            ((p)localObject1).vgn = 0L;
          }
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
          label5181:
          localObject1 = null;
        }
      }
      label5187:
      AppMethodBeat.o(250839);
      return;
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId != ((c.a)paramb).feedId) {
          break label5346;
        }
        i = 1;
        if (i == 0) {
          break label5351;
        }
        label5227:
        if (localObject1 != null)
        {
          ((p)localObject1).vgr = 1;
          localObject1 = x.SXb;
        }
      }
      if (((c.a)paramb).tHM != null)
      {
        localObject1 = k.vfA;
        localObject1 = k.Fd(((c.a)paramb).feedId);
        if (localObject1 == null) {
          break label5410;
        }
        l1 = ((bm)localObject1).dkW();
        if (((c.a)paramb).tHO <= ((c.a)paramb).tHP) {
          break label5357;
        }
        e.a.a(this.ttO, l1, 15, String.valueOf(e.a.a(15, new String[] { "-1" })), 0L, (bm)localObject1, 16);
      }
      label5331:
      for (paramb = x.SXb;; paramb = x.SXb)
      {
        paramb = x.SXb;
        AppMethodBeat.o(250839);
        return;
        label5346:
        i = 0;
        break;
        label5351:
        localObject1 = null;
        break label5227;
        label5357:
        if (((c.a)paramb).tHO >= ((c.a)paramb).tHP) {
          break label5331;
        }
        e.a.a(this.ttO, l1, 15, String.valueOf(e.a.a(15, new String[] { "1" })), 0L, (bm)localObject1, 16);
        break label5331;
        Log.i("MegaVideoFeedFlowReporter", "ActionEvent.VIDEO_SEEK mega video is null id = " + ((c.a)paramb).feedId);
      }
      label5410:
      localObject1 = this.vfI;
      if (localObject1 != null)
      {
        if (((p)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5507;
          }
        }
        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
        {
          if (paramb == null) {
            break label5510;
          }
          paramb.vgq = 1;
          paramb = x.SXb;
          AppMethodBeat.o(250839);
          return;
          i = 0;
          break;
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(250835);
    kotlin.g.b.p.h(paramc, "dispatcher");
    kotlin.g.b.p.h(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(250835);
      return true;
    }
    if ((paramb instanceof ag.b))
    {
      AppMethodBeat.o(250835);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(250835);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(250835);
      return true;
    }
    AppMethodBeat.o(250835);
    return false;
  }
  
  public final LinkedList<ecq> dnM()
  {
    AppMethodBeat.i(250841);
    if (this.vfE.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.vfE);
      this.vfE.clear();
      s locals = s.vhF;
      s.a((List)localLinkedList, this.ttO, 0);
      AppMethodBeat.o(250841);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(250841);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(250843);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(250843);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(250836);
    onExit();
    super.onRelease();
    AppMethodBeat.o(250836);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(250842);
    super.onVisible();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.uLr);
    if (localObject != null)
    {
      localObject = ((FinderReporterUIC)localObject).wzz;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
          if (localWxRecyclerAdapter != null) {
            localWxRecyclerAdapter.onResume();
          }
        }
        AppMethodBeat.o(250842);
        return;
      }
    }
    AppMethodBeat.o(250842);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(ae paramae)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ae
 * JD-Core Version:    0.7.0.1
 */
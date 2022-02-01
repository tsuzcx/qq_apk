package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public final class ah
  extends g
{
  public static final a zZq;
  private ConcurrentLinkedQueue<emr> zWK;
  t zWO;
  HashSet<Long> zWP;
  HashMap<Long, t> zWQ;
  
  static
  {
    AppMethodBeat.i(288907);
    zZq = new a((byte)0);
    AppMethodBeat.o(288907);
  }
  
  public ah(MMFragmentActivity paramMMFragmentActivity, bid parambid)
  {
    super(paramMMFragmentActivity, parambid);
    AppMethodBeat.i(288906);
    this.zWK = new ConcurrentLinkedQueue();
    this.zWP = new HashSet();
    this.zWQ = new HashMap();
    AppMethodBeat.o(288906);
  }
  
  private final void a(t paramt, emr paramemr)
  {
    AppMethodBeat.i(288899);
    bs localbs = paramt.zvv;
    if (localbs != null)
    {
      long l1 = localbs.dKW();
      if (paramt.zXd > 0) {
        g.a.a(this.xbu, l1, 5, String.valueOf(paramt.zXd), paramt.fhq, localbs);
      }
      long l2 = paramt.endTime;
      long l3 = paramt.startTime;
      g.a.a(this.xbu, l1, 2, String.valueOf(l2 - l3), paramt.fhq, localbs);
      if (paramt.zXg > 0) {
        g.a.a(this.xbu, l1, 11, String.valueOf(paramt.zXg), paramt.fhq, localbs);
      }
      Object localObject = this.xbu;
      paramemr = paramemr.Upj;
      if (paramemr != null) {}
      for (paramemr = Long.valueOf(paramemr.RRR);; paramemr = "")
      {
        g.a.a((bid)localObject, l1, 3, String.valueOf(paramemr), paramt.fhq, localbs);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("netType", paramt.netType);
        ((JSONObject)localObject).put("isPause", paramt.zXy);
        ((JSONObject)localObject).put("isSeek", paramt.zXz);
        ((JSONObject)localObject).put("playProgressInfo", paramt.zXA);
        ((JSONObject)localObject).put("maxPlayPercent", paramt.zXg);
        ((JSONObject)localObject).put("maxPlayLength", paramt.zXf);
        ((JSONObject)localObject).put("videoDuration", paramt.videoDuration);
        ((JSONObject)localObject).put("playTime", paramt.zXw);
        ((JSONObject)localObject).put("realPlayTime", paramt.zXu);
        ((JSONObject)localObject).put("voiceInfo", paramt.zXE);
        ((JSONObject)localObject).put("playFormat", paramt.zXF);
        paramemr = this.xbu;
        localObject = ((JSONObject)localObject).toString();
        p.j(localObject, "playInfoObj.toString()");
        g.a.a(paramemr, l1, 17, kotlin.n.n.l((String)localObject, ",", ";", false), paramt.fhq, localbs);
        paramemr = c.zTT;
        paramemr = c.Mi(paramt.feedId);
        if (!Util.isNullOrNil(paramemr)) {
          g.a.a(this.xbu, l1, 18, paramemr, paramt.fhq, localbs);
        }
        AppMethodBeat.o(288899);
        return;
      }
    }
    AppMethodBeat.o(288899);
  }
  
  private final emr f(t paramt)
  {
    AppMethodBeat.i(288902);
    t.e(paramt);
    Object localObject = t.zXK;
    localObject = t.a.a(paramt, this.xbu);
    bs localbs = paramt.zvv;
    if (localbs != null)
    {
      long l = localbs.dKW();
      g.a.a(this.xbu, l, 14, String.valueOf(paramt.endTime - paramt.startTime), 0L, localbs, 16);
    }
    AppMethodBeat.o(288902);
    return localObject;
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(288898);
    aj.a locala = aj.Bnu;
    com.tencent.mm.ae.d.c(aj.eld(), (a)new c(this));
    AppMethodBeat.o(288898);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(288901);
    p.k(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    long l1;
    long l2;
    label460:
    label476:
    Object localObject6;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!getVisible())
      {
        Log.i("MegaVideoFeedFlowReporter", this.xbu.xkX + " not visible");
        AppMethodBeat.o(288901);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUO().aSr()).intValue() == 1)
      {
        localObject1 = au.zBf;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrq;
        if (localObject1 == null) {
          break label460;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next()).xrd);
        }
      }
      for (localObject1 = (List)localObject1;; localObject1 = null)
      {
        au.a((List)localObject1, this.xbu);
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCr == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrh) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCs == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrj)) {
          break label1475;
        }
        localObject3 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl) {
          break label572;
        }
        localObject1 = this.zWO;
        if (localObject1 != null)
        {
          ((t)localObject1).a(this.zUT);
          localObject2 = t.zXK;
          localObject2 = t.a.a((t)localObject1, this.xbu);
          ((LinkedList)localObject3).add(localObject2);
          a((t)localObject1, (emr)localObject2);
          localObject1 = x.aazN;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
        if (localObject1 == null) {
          break label572;
        }
        localObject4 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
        } while (((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf() != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl);
        l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf();
        l2 = paramb.xqG;
        if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd instanceof BaseFinderFeed)) {
          break label555;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd;
        if (localObject1 != null) {
          break;
        }
        paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(288901);
        throw paramb;
      }
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      localObject6 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrf;
      Object localObject7 = this.zUT;
      if ((((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd instanceof bs)) {}
      for (localObject2 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd;; localObject2 = null)
      {
        localObject1 = new t(l1, l2, (FinderItem)localObject1, (com.tencent.mm.view.recyclerview.j)localObject6, true, (com.tencent.mm.plugin.finder.video.reporter.d)localObject7, (bs)localObject2);
        ((t)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xre;
        localObject2 = x.aazN;
        this.zWO = ((t)localObject1);
        break;
        label555:
        localObject1 = null;
        break label476;
      }
      localObject1 = x.aazN;
      label572:
      localObject5 = new HashSet();
      localObject4 = new HashSet();
      ((HashSet)localObject5).addAll((Collection)this.zWQ.keySet());
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
          ((HashSet)localObject5).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd.mf()));
          ((HashSet)localObject4).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd.mf()));
        }
        localObject1 = x.aazN;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrq;
      if (localObject1 != null)
      {
        localObject6 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject6).next();
          if (!((HashSet)localObject5).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd.mf())))
          {
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd.mf();
            l2 = paramb.xqG;
            label838:
            com.tencent.mm.view.recyclerview.j localj;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd instanceof BaseFinderFeed))
            {
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd;
              if (localObject1 == null)
              {
                paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(288901);
                throw paramb;
              }
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              localj = ((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrf;
              if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd instanceof bs)) {
                break label924;
              }
            }
            label924:
            for (localObject2 = ((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd;; localObject2 = null)
            {
              localObject1 = new t(l1, l2, (FinderItem)localObject1, localj, false, null, (bs)localObject2, 48);
              ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject7).xrd;
              ((LinkedList)localObject3).add(f((t)localObject1));
              localObject1 = x.aazN;
              break;
              localObject1 = null;
              break label838;
            }
          }
        }
        localObject1 = x.aazN;
      }
      localObject1 = ((Map)this.zWQ).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject4).contains(((Map.Entry)localObject2).getKey())) {
          ((LinkedList)localObject3).add(f((t)((Map.Entry)localObject2).getValue()));
        }
      }
      localObject4 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject5).next();
          localObject1 = (t)this.zWQ.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf()));
          if (localObject1 != null)
          {
            ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;
            if ((t)((HashMap)localObject4).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf()), localObject1) != null) {
              break;
            }
          }
          else
          {
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf();
            l2 = paramb.xqG;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd instanceof BaseFinderFeed))
            {
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;
              if (localObject1 == null)
              {
                paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(288901);
                throw paramb;
              }
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              label1206:
              localObject7 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrf;
              if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd instanceof bs)) {
                break label1306;
              }
            }
            label1306:
            for (localObject2 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;; localObject2 = null)
            {
              localObject1 = new t(l1, l2, (FinderItem)localObject1, (com.tencent.mm.view.recyclerview.j)localObject7, false, null, (bs)localObject2, 48);
              ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;
              ((t)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xre;
              ((HashMap)localObject4).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf()), localObject1);
              break;
              localObject1 = null;
              break label1206;
            }
          }
        }
        localObject1 = x.aazN;
      }
      this.zWQ = ((HashMap)localObject4);
      this.zWK.addAll((Collection)localObject3);
      if (this.zWK.size() > 20)
      {
        localObject1 = aj.Bnu;
        com.tencent.mm.ae.d.c(aj.eld(), (a)new b(this));
      }
      localObject1 = new StringBuilder("waitForReportStatsList ");
      localObject3 = (Iterable)this.zWK;
      localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ae.d.Fw(((emr)((Iterator)localObject3).next()).xbk));
      }
      Log.i("MegaVideoFeedFlowReporter", (List)localObject2);
      label1475:
      if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).sCr != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrh) || (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCs != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrj))
      {
        this.zWP = new HashSet();
        localObject2 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrs;
        if (localObject2 != null)
        {
          localObject1 = this.zWP;
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(Long.valueOf(((bu)((Iterator)localObject3).next()).mf()));
          }
          ((HashSet)localObject1).addAll((Collection)localObject2);
        }
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          localObject4 = ((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrf;
          if (localObject4 != null)
          {
            if (((com.tencent.mm.view.recyclerview.j)localObject4).YSG)
            {
              localObject5 = this.xbu;
              l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd.mf();
              l2 = paramb.xqG;
              if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd instanceof BaseFinderFeed)) {
                break label1868;
              }
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd;
              if (localObject1 == null)
              {
                paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(288901);
                throw paramb;
              }
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              label1771:
              if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd instanceof bs)) {
                break label1874;
              }
            }
            label1868:
            label1874:
            for (localObject2 = ((com.tencent.mm.plugin.finder.event.base.g)localObject2).xrd;; localObject2 = null)
            {
              g.a.a((bid)localObject5, new t(l1, l2, (FinderItem)localObject1, (com.tencent.mm.view.recyclerview.j)localObject4, false, null, (bs)localObject2, 48));
              ((com.tencent.mm.view.recyclerview.j)localObject4).YSG = false;
              localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject4).YSI;
              if (localObject1 != null)
              {
                localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
                if (localObject1 != null)
                {
                  ((WxRecyclerAdapter)localObject1).onPause();
                  localObject1 = x.aazN;
                }
              }
              localObject1 = x.aazN;
              break;
              localObject1 = null;
              break label1771;
            }
          }
        }
        paramb = x.aazN;
        AppMethodBeat.o(288901);
        return;
      }
      AppMethodBeat.o(288901);
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
      localObject1 = a.a.xqt;
      if (i == a.a.dpQ())
      {
        localObject1 = this.zWO;
        if (localObject1 != null) {
          if (((t)localObject1).feedId == ((a.a)paramb).feedId)
          {
            i = 1;
            if (i == 0) {
              break label2175;
            }
            label1973:
            if (localObject1 == null) {
              break label2187;
            }
            ((t)localObject1).pqr += 1;
            i = ((t)localObject1).zXl;
            ((t)localObject1).zXl = (i + 1);
            localObject1 = localObject6;
            label2008:
            localObject2 = n.zWF;
            localObject2 = n.Mm(((a.a)paramb).feedId);
            if (localObject2 == null) {
              break label2271;
            }
            l1 = ((bs)localObject2).dKW();
            paramb = this.xbu;
            localObject3 = g.c.zUZ;
            g.a.a(paramb, l1, 1, g.c.dPm(), 0L, (bs)localObject2, 16);
            paramb = this.xbu;
            localObject3 = z.bcZ();
            p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            localObject3 = g.a.a(10, new String[] { "1", localObject3 }).toString();
            p.j(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
            g.a.a(paramb, l1, 10, (String)localObject3, 0L, (bs)localObject2, 16);
            paramb = x.aazN;
            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          }
        }
      }
      for (;;)
      {
        if (paramb != null)
        {
          t.e(paramb);
          localObject1 = t.zXK;
          paramb = t.a.a(paramb, this.xbu);
          this.zWK.add(paramb);
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          label2175:
          localObject1 = null;
          break label1973;
          localObject1 = null;
          break label1973;
          label2187:
          l1 = ((a.a)paramb).feedId;
          l2 = paramb.xqG;
          localObject1 = n.zWF;
          localObject1 = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
          ((t)localObject1).pqr += 1;
          ((t)localObject1).zXl += 1;
          localObject2 = x.aazN;
          localObject2 = x.aazN;
          break label2008;
          label2271:
          Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_SNS mega video is null id = " + ((a.a)paramb).feedId);
          paramb = x.aazN;
          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          continue;
          localObject1 = a.a.xqt;
          if (i == a.a.dpP())
          {
            localObject1 = this.zWO;
            if (localObject1 != null) {
              if (((t)localObject1).feedId == ((a.a)paramb).feedId)
              {
                i = 1;
                label2351:
                if (i == 0) {
                  break label2510;
                }
                label2355:
                if (localObject1 == null) {
                  break label2522;
                }
                i = ((t)localObject1).pqr;
                ((t)localObject1).pqr = (i + 1);
                localObject1 = localObject5;
              }
            }
            for (;;)
            {
              localObject2 = n.zWF;
              localObject2 = n.Mm(((a.a)paramb).feedId);
              if (localObject2 == null) {
                break label2594;
              }
              l1 = ((bs)localObject2).dKW();
              paramb = this.xbu;
              localObject3 = g.c.zUZ;
              g.a.a(paramb, l1, 1, g.c.dPm(), 0L, (bs)localObject2, 16);
              paramb = this.xbu;
              localObject3 = z.bcZ();
              p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localObject3 = g.a.a(10, new String[] { "2", localObject3 }).toString();
              p.j(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              g.a.a(paramb, l1, 10, (String)localObject3, 0L, (bs)localObject2, 16);
              paramb = x.aazN;
              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
              break;
              i = 0;
              break label2351;
              label2510:
              localObject1 = null;
              break label2355;
              localObject1 = null;
              break label2355;
              label2522:
              l1 = ((a.a)paramb).feedId;
              l2 = paramb.xqG;
              localObject1 = n.zWF;
              localObject1 = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
              ((t)localObject1).pqr += 1;
              localObject2 = x.aazN;
              localObject2 = x.aazN;
            }
            label2594:
            Log.i("MegaVideoFeedFlowReporter", "ActionEvent.SHARE_TO_CHAT mega video is null id = " + ((a.a)paramb).feedId);
            paramb = x.aazN;
            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
          }
          else
          {
            localObject1 = a.a.xqt;
            if (i == a.a.dpS())
            {
              localObject1 = n.zWF;
              localObject1 = n.Mm(((a.a)paramb).feedId);
              if (localObject1 != null)
              {
                l1 = ((bs)localObject1).dKW();
                paramb = this.xbu;
                localObject3 = z.bcZ();
                p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                localObject3 = g.a.a(13, new String[] { "1", localObject3 }).toString();
                p.j(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                g.a.a(paramb, l1, 13, (String)localObject3, 0L, (bs)localObject1, 16);
                paramb = x.aazN;
                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
              }
              else
              {
                Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_SNS mega video is null id = " + ((a.a)paramb).feedId);
                paramb = x.aazN;
                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
              }
            }
            else
            {
              localObject1 = a.a.xqt;
              if (i == a.a.dpR())
              {
                localObject1 = n.zWF;
                localObject1 = n.Mm(((a.a)paramb).feedId);
                if (localObject1 != null)
                {
                  l1 = ((bs)localObject1).dKW();
                  paramb = this.xbu;
                  localObject3 = z.bcZ();
                  p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  localObject3 = g.a.a(13, new String[] { "2", localObject3 }).toString();
                  p.j(localObject3, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  g.a.a(paramb, l1, 13, (String)localObject3, 0L, (bs)localObject1, 16);
                  paramb = x.aazN;
                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                }
                else
                {
                  Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CANCEL_SHARE_TO_CHAT mega video is null id = " + ((a.a)paramb).feedId);
                  paramb = x.aazN;
                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                }
              }
              else
              {
                localObject1 = a.a.xqt;
                if (i == a.a.dpX())
                {
                  localObject1 = this.zWO;
                  if (localObject1 != null) {
                    if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label2982:
                      if (i == 0) {
                        break label3079;
                      }
                      label2986:
                      if (localObject1 == null) {
                        break label3091;
                      }
                      ((t)localObject1).zXi += 1;
                      localObject1 = localObject4;
                      label3007:
                      localObject2 = n.zWF;
                      localObject2 = n.Mm(((a.a)paramb).feedId);
                      if (localObject2 == null) {
                        break label3158;
                      }
                      l1 = ((bs)localObject2).dKW();
                      paramb = this.xbu;
                      localObject3 = g.c.zUZ;
                      g.a.a(paramb, l1, 7, g.c.dPm(), 0L, (bs)localObject2, 16);
                    }
                  }
                  for (paramb = x.aazN;; paramb = x.aazN)
                  {
                    paramb = x.aazN;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label2982;
                    label3079:
                    localObject1 = null;
                    break label2986;
                    localObject1 = null;
                    break label2986;
                    label3091:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.xqG;
                    localObject1 = n.zWF;
                    localObject1 = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                    ((t)localObject1).zXi += 1;
                    localObject2 = x.aazN;
                    break label3007;
                    label3158:
                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.CLICK_AVATAR mega video is null id = " + ((a.a)paramb).feedId);
                  }
                }
                localObject1 = a.a.xqt;
                if (i == a.a.dpY())
                {
                  localObject1 = this.zWO;
                  if (localObject1 != null) {
                    if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label3235:
                      if (i == 0) {
                        break label3332;
                      }
                      label3239:
                      if (localObject1 == null) {
                        break label3344;
                      }
                      ((t)localObject1).zXj += 1;
                      localObject1 = localObject3;
                      label3260:
                      localObject2 = n.zWF;
                      localObject2 = n.Mm(((a.a)paramb).feedId);
                      if (localObject2 == null) {
                        break label3411;
                      }
                      l1 = ((bs)localObject2).dKW();
                      paramb = this.xbu;
                      localObject3 = g.c.zUZ;
                      g.a.a(paramb, l1, 16, g.c.dPm(), 0L, (bs)localObject2, 16);
                    }
                  }
                  for (paramb = x.aazN;; paramb = x.aazN)
                  {
                    paramb = x.aazN;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label3235;
                    label3332:
                    localObject1 = null;
                    break label3239;
                    localObject1 = null;
                    break label3239;
                    label3344:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.xqG;
                    localObject1 = n.zWF;
                    localObject1 = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                    ((t)localObject1).zXj += 1;
                    localObject2 = x.aazN;
                    break label3260;
                    label3411:
                    Log.i("MegaVideoFeedFlowReporter", "ActionEvent.FAV mega video is null id = " + ((a.a)paramb).feedId);
                  }
                }
                localObject1 = a.a.xqt;
                if (i == a.a.dqa())
                {
                  localObject1 = this.zWO;
                  if (localObject1 != null) {
                    if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      label3488:
                      if (i == 0) {
                        break label3522;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label3534;
                    }
                    i = ((t)localObject1).zXt;
                    ((t)localObject1).zXt = (i + 1);
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                    break;
                    i = 0;
                    break label3488;
                    label3522:
                    localObject1 = null;
                    continue;
                    localObject1 = null;
                  }
                  label3534:
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.xqG;
                  localObject1 = n.zWF;
                  paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                  paramb.zXt += 1;
                  localObject1 = x.aazN;
                  localObject1 = x.aazN;
                }
                else
                {
                  localObject1 = a.a.xqt;
                  if (i == a.a.dpT())
                  {
                    localObject1 = this.zWO;
                    if (localObject1 != null) {
                      if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                      {
                        i = 1;
                        label3644:
                        if (i == 0) {
                          break label3678;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject1 == null) {
                        break label3690;
                      }
                      i = ((t)localObject1).zXk;
                      ((t)localObject1).zXk = (i + 1);
                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                      break;
                      i = 0;
                      break label3644;
                      label3678:
                      localObject1 = null;
                      continue;
                      localObject1 = null;
                    }
                    label3690:
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.xqG;
                    localObject1 = n.zWF;
                    paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                    paramb.zXk += 1;
                    localObject1 = x.aazN;
                    localObject1 = x.aazN;
                  }
                  else
                  {
                    localObject1 = a.a.xqt;
                    if (i == a.a.dqb())
                    {
                      localObject1 = this.zWO;
                      if (localObject1 != null) {
                        if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                        {
                          i = 1;
                          label3800:
                          if (i == 0) {
                            break label3834;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label3846;
                        }
                        i = ((t)localObject1).zXn;
                        ((t)localObject1).zXn = (i + 1);
                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                        break;
                        i = 0;
                        break label3800;
                        label3834:
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      label3846:
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.xqG;
                      localObject1 = n.zWF;
                      paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                      paramb.zXn += 1;
                      localObject1 = x.aazN;
                      localObject1 = x.aazN;
                    }
                    else
                    {
                      localObject1 = a.a.xqt;
                      if (i == a.a.dqc())
                      {
                        localObject1 = this.zWO;
                        if (localObject1 != null) {
                          if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                          {
                            i = 1;
                            label3956:
                            if (i == 0) {
                              break label3990;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4002;
                          }
                          i = ((t)localObject1).zXm;
                          ((t)localObject1).zXm = (i + 1);
                          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                          break;
                          i = 0;
                          break label3956;
                          label3990:
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        label4002:
                        l1 = ((a.a)paramb).feedId;
                        l2 = paramb.xqG;
                        localObject1 = n.zWF;
                        paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                        paramb.zXm += 1;
                        localObject1 = x.aazN;
                        localObject1 = x.aazN;
                      }
                      else
                      {
                        localObject1 = a.a.xqt;
                        if (i == a.a.dqd())
                        {
                          localObject1 = this.zWO;
                          if (localObject1 != null) {
                            if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                            {
                              i = 1;
                              label4112:
                              if (i == 0) {
                                break label4146;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4158;
                            }
                            i = ((t)localObject1).zXo;
                            ((t)localObject1).zXo = (i + 1);
                            paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                            break;
                            i = 0;
                            break label4112;
                            label4146:
                            localObject1 = null;
                            continue;
                            localObject1 = null;
                          }
                          label4158:
                          l1 = ((a.a)paramb).feedId;
                          l2 = paramb.xqG;
                          localObject1 = n.zWF;
                          paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                          paramb.zXo += 1;
                          localObject1 = x.aazN;
                          localObject1 = x.aazN;
                        }
                        else
                        {
                          localObject1 = a.a.xqt;
                          if (i == a.a.dqe())
                          {
                            localObject1 = this.zWO;
                            if (localObject1 != null) {
                              if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                              {
                                i = 1;
                                label4268:
                                if (i == 0) {
                                  break label4302;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4314;
                              }
                              i = ((t)localObject1).zXr;
                              ((t)localObject1).zXr = (i + 1);
                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                              break;
                              i = 0;
                              break label4268;
                              label4302:
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            label4314:
                            l1 = ((a.a)paramb).feedId;
                            l2 = paramb.xqG;
                            localObject1 = n.zWF;
                            paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                            paramb.zXr += 1;
                            localObject1 = x.aazN;
                            localObject1 = x.aazN;
                          }
                          else
                          {
                            localObject1 = a.a.xqt;
                            if (i == a.a.dqf())
                            {
                              localObject1 = this.zWO;
                              if (localObject1 != null) {
                                if (((t)localObject1).feedId == ((a.a)paramb).feedId)
                                {
                                  i = 1;
                                  label4424:
                                  if (i == 0) {
                                    break label4458;
                                  }
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 == null) {
                                  break label4470;
                                }
                                i = ((t)localObject1).zXs;
                                ((t)localObject1).zXs = (i + 1);
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                break;
                                i = 0;
                                break label4424;
                                label4458:
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              label4470:
                              l1 = ((a.a)paramb).feedId;
                              l2 = paramb.xqG;
                              localObject1 = n.zWF;
                              paramb = new t(l1, l2, null, null, false, null, n.Mm(((a.a)paramb).feedId), 56);
                              paramb.zXs += 1;
                              localObject1 = x.aazN;
                              localObject1 = x.aazN;
                            }
                            else
                            {
                              paramb = a.a.xqt;
                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                              if (i != a.a.dqg())
                              {
                                paramb = a.a.xqt;
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                if (i != a.a.dqh())
                                {
                                  paramb = a.a.xqt;
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject2;
                                  if (i != a.a.dqi())
                                  {
                                    AppMethodBeat.o(288901);
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
      AppMethodBeat.o(288901);
      return;
    }
    if ((paramb instanceof c.a)) {
      switch (((c.a)paramb).type)
      {
      }
    }
    label4762:
    label4768:
    label4854:
    label5622:
    for (;;)
    {
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4762;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4768;
          }
          ((t)localObject1).zXx = paramb.xqG;
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4854;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4860;
          }
          if (((t)localObject1).zXx != 0L) {
            ((t)localObject1).zXw = (paramb.xqG - ((t)localObject1).zXx);
          }
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      label4860:
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label4930;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label4936;
          }
          ((t)localObject1).zXv = paramb.xqG;
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5027;
          }
        }
        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
        {
          if (paramb == null) {
            break label5032;
          }
          paramb.zXb[paramb.zXc] += 1;
          i = paramb.zXd;
          paramb.zXd = (i + 1);
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
        }
      }
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5189;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label5195;
          }
          ((t)localObject1).zXB.add(Integer.valueOf(((c.a)paramb).offset));
          i = (int)(100.0F * ((c.a)paramb).offset / ((c.a)paramb).total);
          if (i > localObject1.zXa[localObject1.zXc]) {
            ((t)localObject1).zXa[localObject1.zXc] = i;
          }
          if (i > ((t)localObject1).zXg)
          {
            ((t)localObject1).zXf = ((c.a)paramb).offset;
            ((t)localObject1).zXg = i;
          }
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5293;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label5299;
          }
          if (((t)localObject1).zXv != 0L)
          {
            ((t)localObject1).zXu += paramb.xqG - ((t)localObject1).zXv;
            ((t)localObject1).zXv = 0L;
          }
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
          localObject1 = null;
        }
      }
      AppMethodBeat.o(288901);
      return;
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId != ((c.a)paramb).feedId) {
          break label5458;
        }
        i = 1;
        if (i == 0) {
          break label5463;
        }
        if (localObject1 != null)
        {
          ((t)localObject1).zXz = 1;
          localObject1 = x.aazN;
        }
      }
      if (((c.a)paramb).xqw != null)
      {
        localObject1 = n.zWF;
        localObject1 = n.Mm(((c.a)paramb).feedId);
        if (localObject1 == null) {
          break label5522;
        }
        l1 = ((bs)localObject1).dKW();
        if (((c.a)paramb).xqy <= ((c.a)paramb).fFM) {
          break label5469;
        }
        g.a.a(this.xbu, l1, 15, String.valueOf(g.a.a(15, new String[] { "-1" })), 0L, (bs)localObject1, 16);
      }
      for (paramb = x.aazN;; paramb = x.aazN)
      {
        paramb = x.aazN;
        AppMethodBeat.o(288901);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label5339;
        if (((c.a)paramb).xqy >= ((c.a)paramb).fFM) {
          break label5443;
        }
        g.a.a(this.xbu, l1, 15, String.valueOf(g.a.a(15, new String[] { "1" })), 0L, (bs)localObject1, 16);
        break label5443;
        Log.i("MegaVideoFeedFlowReporter", "ActionEvent.VIDEO_SEEK mega video is null id = " + ((c.a)paramb).feedId);
      }
      localObject1 = this.zWO;
      if (localObject1 != null)
      {
        if (((t)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5619;
          }
        }
        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
        {
          if (paramb == null) {
            break label5622;
          }
          paramb.zXy = 1;
          paramb = x.aazN;
          AppMethodBeat.o(288901);
          return;
          i = 0;
          break;
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(288896);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(288896);
      return true;
    }
    if ((paramb instanceof aj.b))
    {
      AppMethodBeat.o(288896);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(288896);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(288896);
      return true;
    }
    AppMethodBeat.o(288896);
    return false;
  }
  
  public final LinkedList<emr> dPl()
  {
    AppMethodBeat.i(288903);
    if (this.zWK.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.zWK);
      this.zWK.clear();
      w localw = w.zYO;
      w.a((List)localLinkedList, this.xbu, 0);
      AppMethodBeat.o(288903);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(288903);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(288905);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(288905);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(288897);
    onExit();
    super.onRelease();
    AppMethodBeat.o(288897);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(288904);
    super.onVisible();
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)dsB());
    if (localObject != null)
    {
      localObject = ((aj)localObject).Bnr;
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
        AppMethodBeat.o(288904);
        return;
      }
    }
    AppMethodBeat.o(288904);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ah
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import d.a.j;
import d.g.b.v.e;
import d.n.n;
import d.y;
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
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "waitForReportStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "checkEmptyToHotTabExpose", "", "checkRedDotExpose", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Companion", "plugin-finder_release"})
public class l
  extends c
{
  public static final a KUM;
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private LinkedList<cxk> KUI;
  private m KUJ;
  private HashSet<Long> KUK;
  private HashMap<Long, m> KUL;
  
  static
  {
    AppMethodBeat.i(198835);
    KUM = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    AppMethodBeat.o(198835);
  }
  
  public l(MMActivity paramMMActivity, dzp paramdzp)
  {
    super(paramMMActivity, paramdzp);
    AppMethodBeat.i(198834);
    this.KUI = new LinkedList();
    this.KUK = new HashSet();
    this.KUL = new HashMap();
    AppMethodBeat.o(198834);
  }
  
  private final cxk a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(198830);
    m.a(paramm);
    Object localObject1 = m.KVt;
    cxk localcxk = m.a.b(paramm);
    c.a.a(this.contextObj, paramm.feedId, 14, String.valueOf(paramm.endTime - paramm.startTime));
    c.a.a(this.contextObj, paramm, 2);
    if (paramBoolean) {
      if (paramm != null)
      {
        localObject1 = paramm.feed;
        if (localObject1 != null)
        {
          Object localObject2 = ((FinderItem)localObject1).getFoldedLayout();
          if ((localObject2 != null) && (((ain)localObject2).fwP > 0))
          {
            localObject1 = paramm.KMj;
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LDN;
            }
            while (localObject1 == null)
            {
              localObject1 = paramm.KMj;
              if (localObject1 != null)
              {
                LongSparseArray localLongSparseArray = new LongSparseArray();
                localObject2 = ((ain)localObject2).Dlg;
                d.g.b.k.g(localObject2, "it.objects");
                localObject2 = ((Iterable)localObject2).iterator();
                int i = 0;
                for (;;)
                {
                  if (((Iterator)localObject2).hasNext())
                  {
                    Object localObject3 = ((Iterator)localObject2).next();
                    if (i < 0) {
                      j.fvx();
                    }
                    localObject3 = (FinderObject)localObject3;
                    if (i <= 2)
                    {
                      h localh = new h((com.tencent.mm.view.recyclerview.a)new c((FinderObject)localObject3));
                      localh.KMi = i;
                      localLongSparseArray.put(((FinderObject)localObject3).id, localh);
                    }
                    i += 1;
                    continue;
                    localObject1 = null;
                    break;
                  }
                }
                ((com.tencent.mm.view.recyclerview.f)localObject1).LDN = localLongSparseArray;
              }
            }
            c.a.a(this.contextObj, paramm);
            paramm = paramm.KMj;
            if (paramm != null)
            {
              paramm = paramm.LDO;
              if (paramm != null)
              {
                paramm = (WxRecyclerAdapter)paramm.get();
                if (paramm != null) {
                  paramm.onPause();
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198830);
      return localcxk;
      if (paramm != null)
      {
        localObject1 = paramm.KMj;
        if ((localObject1 != null) && ((((com.tencent.mm.view.recyclerview.f)localObject1).LDL) || (((com.tencent.mm.view.recyclerview.f)localObject1).LDM)))
        {
          c.a.a(this.contextObj, paramm);
          ((com.tencent.mm.view.recyclerview.f)localObject1).LDM = false;
          paramm = ((com.tencent.mm.view.recyclerview.f)localObject1).LDO;
          if (paramm != null)
          {
            paramm = (WxRecyclerAdapter)paramm.get();
            if (paramm != null) {
              paramm.onPause();
            }
          }
        }
      }
    }
  }
  
  private final void a(m paramm, cxk paramcxk)
  {
    AppMethodBeat.i(198828);
    if (paramm.KUW > 0) {
      c.a.a(this.contextObj, paramm.feedId, 5, String.valueOf(paramm.KUW), paramm.yLW);
    }
    long l1 = paramm.endTime;
    long l2 = paramm.startTime;
    c.a.a(this.contextObj, paramm.feedId, 2, String.valueOf(l1 - l2), paramm.yLW);
    if (paramm.KUY > 0) {
      c.a.a(this.contextObj, paramm.feedId, 11, String.valueOf(paramm.KUY), paramm.yLW);
    }
    Object localObject = this.contextObj;
    l1 = paramm.feedId;
    paramcxk = paramcxk.bitFeature;
    if (paramcxk != null) {}
    for (paramcxk = Long.valueOf(paramcxk.CGQ);; paramcxk = "")
    {
      c.a.a((dzp)localObject, l1, 3, String.valueOf(paramcxk), paramm.yLW);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("netType", paramm.netType);
      ((JSONObject)localObject).put("isPause", paramm.KVl);
      ((JSONObject)localObject).put("isSeek", paramm.KVm);
      ((JSONObject)localObject).put("playProgressInfo", paramm.KVn);
      ((JSONObject)localObject).put("maxPlayPercent", paramm.KUY);
      ((JSONObject)localObject).put("maxPlayLength", paramm.KUX);
      ((JSONObject)localObject).put("videoDuration", paramm.videoDuration);
      ((JSONObject)localObject).put("playTime", paramm.qGD);
      ((JSONObject)localObject).put("realPlayTime", paramm.qGR);
      ((JSONObject)localObject).put("voiceInfo", paramm.KVr);
      paramcxk = this.contextObj;
      l1 = paramm.feedId;
      localObject = ((JSONObject)localObject).toString();
      d.g.b.k.g(localObject, "playInfoObj.toString()");
      c.a.a(paramcxk, l1, 17, n.h((String)localObject, ",", ";", false), paramm.yLW);
      c.a.a(this.contextObj, paramm, 1);
      AppMethodBeat.o(198828);
      return;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(198827);
    LinkedList localLinkedList = new LinkedList();
    ??? = ((Map)this.KUL).entrySet().iterator();
    while (((Iterator)???).hasNext()) {
      localLinkedList.add(a((m)((Map.Entry)((Iterator)???).next()).getValue(), false));
    }
    this.KUL = new HashMap();
    ??? = this.KUJ;
    if (??? != null)
    {
      ((m)???).a(this.KUy);
      Object localObject3 = m.KVt;
      localObject3 = m.a.b((m)???);
      localLinkedList.add(localObject3);
      a((m)???, (cxk)localObject3);
    }
    this.KUJ = null;
    synchronized (this.KUI)
    {
      this.KUI.addAll((Collection)localLinkedList);
      this.KUK = new HashSet();
      AppMethodBeat.o(198827);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(198829);
    d.g.b.k.h(paramc, "event");
    super.a(paramc);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    label451:
    Object localObject5;
    label1146:
    int m;
    label1397:
    int n;
    int i1;
    int i2;
    int j;
    int k;
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      if (!this.visible)
      {
        ad.i(TAG, this.contextObj.qqE + " not visible");
        AppMethodBeat.o(198829);
        return;
      }
      localObject1 = q.qDO;
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMl;
      if (localObject1 != null)
      {
        ??? = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)???, 10));
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.k)((Iterator)???).next()).qHv);
        }
      }
      for (localObject1 = (List)localObject1;; localObject1 = null)
      {
        q.n((List)localObject1, this.contextObj.qqE);
        if ((((com.tencent.mm.plugin.finder.event.base.l)paramc).qGl == ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsk) && (((com.tencent.mm.plugin.finder.event.base.l)paramc).mYh == ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsi) && (((com.tencent.mm.plugin.finder.event.base.l)paramc).mYi == ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsj)) {
          break label1146;
        }
        localObject1 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.l)paramc).qGl == ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsk) {
          break label451;
        }
        ??? = this.KUJ;
        if (??? != null)
        {
          ((m)???).a(this.KUy);
          localObject3 = m.KVt;
          localObject3 = m.a.b((m)???);
          ((LinkedList)localObject1).add(localObject3);
          a((m)???, (cxk)localObject3);
          ??? = y.JfV;
        }
        ??? = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMm;
        if (??? == null) {
          break label451;
        }
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)???).next();
          if (((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs() == ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsk)
          {
            localObject3 = new m(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.feedObject, ((com.tencent.mm.plugin.finder.event.base.k)localObject4).KMj, true, this.KUy);
            ((m)localObject3).KUQ = ((com.tencent.mm.plugin.finder.event.base.k)localObject4).KMi;
            localObject4 = y.JfV;
            this.KUJ = ((m)localObject3);
          }
        }
      }
      ??? = y.JfV;
      localObject3 = new HashSet();
      ??? = new HashSet();
      ((HashSet)localObject3).addAll((Collection)this.KUL.keySet());
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMm;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject4).next();
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.bMs()));
          ((HashSet)???).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.bMs()));
        }
        localObject4 = y.JfV;
      }
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMl;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject4).next();
          if (!((HashSet)localObject3).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.bMs())))
          {
            ((LinkedList)localObject1).add(a(new m(((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)localObject5).qHv.feedObject, ((com.tencent.mm.plugin.finder.event.base.k)localObject5).KMj, 48), true));
            localObject5 = y.JfV;
          }
        }
        localObject3 = y.JfV;
      }
      localObject3 = ((Map)this.KUL).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(((Map.Entry)localObject4).getKey())) {
          ((LinkedList)localObject1).add(a((m)((Map.Entry)localObject4).getValue(), false));
        }
      }
      ??? = new HashMap();
      localObject3 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMm;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject3).next();
          localObject5 = (m)this.KUL.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs()));
          if (localObject5 != null)
          {
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs()), localObject5);
          }
          else
          {
            localObject5 = new m(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.feedObject, ((com.tencent.mm.plugin.finder.event.base.k)localObject4).KMj, 48);
            ((m)localObject5).KUQ = ((com.tencent.mm.plugin.finder.event.base.k)localObject4).KMi;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.k)localObject4).qHv.bMs()), localObject5);
          }
        }
        localObject3 = y.JfV;
      }
      this.KUL = ((HashMap)???);
      synchronized (this.KUI)
      {
        this.KUI.addAll((Collection)localObject1);
        if (this.KUI.size() > 20)
        {
          localObject1 = FinderReporterUIC.Ljl;
          com.tencent.mm.ad.c.e(FinderReporterUIC.fXw(), (d.g.a.a)new b(this));
        }
        localObject1 = TAG;
        ??? = new StringBuilder("waitForReportStatsList ");
        localObject4 = (Iterable)this.KUI;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(Long.valueOf(((cxk)((Iterator)localObject4).next()).objectId));
        }
      }
      if (((com.tencent.mm.plugin.finder.event.base.l)paramc).mYi != ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsj)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMn;
        if (localObject1 != null)
        {
          ??? = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              localObject1 = (com.tencent.mm.view.recyclerview.a)((Iterator)???).next();
              if (!this.KUK.contains(Long.valueOf(((com.tencent.mm.view.recyclerview.a)localObject1).bMs()))) {
                switch (((com.tencent.mm.view.recyclerview.a)localObject1).bMt())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.contextObj.qqE == 17) || (this.contextObj.qqE == 18))
                  {
                    localObject1 = b.qFq;
                    b.b(1, this.contextObj);
                  }
                  break;
                case -2: 
                  if ((this.contextObj.qqE == 17) || (this.contextObj.qqE == 18) || (this.contextObj.qqE == 20))
                  {
                    localObject1 = FinderReporterUIC.Ljl;
                    localObject1 = FinderReporterUIC.a.lB((Context)this.activity);
                    if (localObject1 != null) {
                      if (((FinderReporterUIC)localObject1).fXp())
                      {
                        if (localObject1 == null) {
                          break label1704;
                        }
                        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.e)localObject1).mYh > 1)) {
                          continue;
                        }
                        localObject1 = g.ad(PluginFinder.class);
                        d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().YW("TLWxBubble");
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject1 = g.afB();
                        d.g.b.k.g(localObject1, "MMKernel.storage()");
                        m = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.FwJ, 0);
                        localObject1 = g.afB();
                        d.g.b.k.g(localObject1, "MMKernel.storage()");
                        n = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.FwK, 0);
                        localObject1 = g.afB();
                        d.g.b.k.g(localObject1, "MMKernel.storage()");
                        i1 = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.LBe, 0);
                        localObject1 = g.afB();
                        d.g.b.k.g(localObject1, "MMKernel.storage()");
                        i2 = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.LBf, 0);
                        j = 0;
                        localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
                        if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
                          break label1706;
                        }
                        k = 5;
                        if (n > 0) {
                          j = 1;
                        }
                        i = j;
                        if (m > 0) {
                          i = j | 0x8;
                        }
                        j = i;
                        if (i1 > 0) {
                          j = i | 0x2;
                        }
                        if (i2 <= 0) {
                          break label5742;
                        }
                      }
                    }
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
    label1704:
    label1706:
    label2098:
    label2133:
    label2272:
    label2284:
    label2412:
    label3564:
    label5740:
    label5742:
    for (int i = j | 0x4;; i = j)
    {
      localObject1 = b.qFq;
      localObject1 = b.lx((Context)this.activity);
      j = i;
      i = k;
      for (;;)
      {
        localObject4 = b.qFq;
        localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).field_tipsId;
        d.g.b.k.g(localObject3, "ctrInfo.field_tipsId");
        b.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, (String)localObject3, null, 0L, this.contextObj, 0, 1408);
        break;
        localObject1 = null;
        break label1397;
        break;
        localObject1 = "2";
        i = 1;
        j = 1;
      }
      localObject1 = y.JfV;
      this.KUK = new HashSet();
      ??? = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMn;
      if (??? != null)
      {
        localObject1 = this.KUK;
        localObject3 = (Iterable)???;
        ??? = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)???).add(Long.valueOf(((com.tencent.mm.view.recyclerview.a)((Iterator)localObject3).next()).bMs()));
        }
        ((HashSet)localObject1).addAll((Collection)???);
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.l)paramc).KMm;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject1).next();
          localObject3 = ((com.tencent.mm.plugin.finder.event.base.k)???).KMj;
          if (localObject3 != null)
          {
            if (((com.tencent.mm.view.recyclerview.f)localObject3).LDM)
            {
              c.a.a(this.contextObj, new m(((com.tencent.mm.plugin.finder.event.base.k)???).qHv.bMs(), paramc.KLZ, ((com.tencent.mm.plugin.finder.event.base.k)???).qHv.feedObject, (com.tencent.mm.view.recyclerview.f)localObject3, 48));
              ((com.tencent.mm.view.recyclerview.f)localObject3).LDM = false;
              ??? = ((com.tencent.mm.view.recyclerview.f)localObject3).LDO;
              if (??? != null)
              {
                ??? = (WxRecyclerAdapter)((WeakReference)???).get();
                if (??? != null)
                {
                  ((WxRecyclerAdapter)???).onPause();
                  ??? = y.JfV;
                }
              }
            }
            ??? = y.JfV;
          }
        }
        paramc = y.JfV;
        AppMethodBeat.o(198829);
        return;
      }
      AppMethodBeat.o(198829);
      return;
      long l1;
      long l2;
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.c.a))
      {
        ??? = null;
        Object localObject7 = null;
        Object localObject6 = null;
        localObject5 = null;
        localObject4 = null;
        localObject3 = null;
        Object localObject8 = null;
        i = ((com.tencent.mm.plugin.finder.event.c.a)paramc).type;
        localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
        if (i == com.tencent.mm.plugin.finder.event.c.a.fSn())
        {
          localObject1 = this.KUJ;
          if (localObject1 != null) {
            if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
            {
              i = 1;
              if (i == 0) {
                break label2272;
              }
              if (localObject1 == null) {
                break label2284;
              }
              ((m)localObject1).shareCount += 1;
              i = ((m)localObject1).KVc;
              ((m)localObject1).KVc = (i + 1);
              localObject1 = localObject8;
              ??? = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
              localObject3 = c.b.KUB;
              c.a.a((dzp)???, l1, 1, c.b.fTT());
              ??? = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
              paramc = u.aqG();
              d.g.b.k.g(paramc, "ConfigStorageLogic.getUsernameFromUserInfo()");
              paramc = c.a.a(10, new String[] { "1", paramc }).toString();
              d.g.b.k.g(paramc, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              c.a.a((dzp)???, l1, 10, paramc);
              paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
            }
          }
        }
        for (;;)
        {
          if (paramc != null)
          {
            m.a(paramc);
            localObject1 = m.KVt;
            paramc = m.a.b(paramc);
            this.KUI.add(paramc);
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label2098;
            localObject1 = null;
            break label2098;
            l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
            l2 = paramc.KLZ;
            localObject1 = b.qFq;
            localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
            ((m)localObject1).shareCount += 1;
            ((m)localObject1).KVc += 1;
            ??? = y.JfV;
            ??? = y.JfV;
            break label2133;
            localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
            if (i == com.tencent.mm.plugin.finder.event.c.a.fSm())
            {
              localObject1 = this.KUJ;
              if (localObject1 != null) {
                if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                {
                  i = 1;
                  if (i == 0) {
                    break label2543;
                  }
                  if (localObject1 == null) {
                    break label2555;
                  }
                  i = ((m)localObject1).shareCount;
                  ((m)localObject1).shareCount = (i + 1);
                  localObject1 = localObject7;
                }
              }
              for (;;)
              {
                ??? = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                localObject3 = c.b.KUB;
                c.a.a((dzp)???, l1, 1, c.b.fTT());
                ??? = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                paramc = u.aqG();
                d.g.b.k.g(paramc, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramc = c.a.a(10, new String[] { "2", paramc }).toString();
                d.g.b.k.g(paramc, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((dzp)???, l1, 10, paramc);
                paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                break;
                i = 0;
                break label2408;
                label2543:
                localObject1 = null;
                break label2412;
                localObject1 = null;
                break label2412;
                label2555:
                l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                l2 = paramc.KLZ;
                localObject1 = b.qFq;
                localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                ((m)localObject1).shareCount += 1;
                ??? = y.JfV;
                ??? = y.JfV;
              }
            }
            localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
            if (i == com.tencent.mm.plugin.finder.event.c.a.fSp())
            {
              localObject1 = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
              paramc = u.aqG();
              d.g.b.k.g(paramc, "ConfigStorageLogic.getUsernameFromUserInfo()");
              paramc = c.a.a(13, new String[] { "1", paramc }).toString();
              d.g.b.k.g(paramc, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              c.a.a((dzp)localObject1, l1, 13, paramc);
              paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
            }
            else
            {
              localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
              if (i == com.tencent.mm.plugin.finder.event.c.a.fSo())
              {
                localObject1 = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                paramc = u.aqG();
                d.g.b.k.g(paramc, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramc = c.a.a(13, new String[] { "2", paramc }).toString();
                d.g.b.k.g(paramc, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((dzp)localObject1, l1, 13, paramc);
                paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
              }
              else
              {
                localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                if (i == com.tencent.mm.plugin.finder.event.c.a.fSr())
                {
                  localObject1 = this.KUJ;
                  if (localObject1 != null) {
                    if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                    {
                      i = 1;
                      if (i == 0) {
                        break label2906;
                      }
                      if (localObject1 == null) {
                        break label2918;
                      }
                      ((m)localObject1).clickComment += 1;
                      localObject1 = localObject6;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    paramc = c.b.KUB;
                    c.a.a((dzp)???, l1, 6, c.b.fTT());
                    paramc = y.JfV;
                    paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                    break;
                    i = 0;
                    break label2835;
                    localObject1 = null;
                    break label2839;
                    localObject1 = null;
                    break label2839;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    l2 = paramc.KLZ;
                    localObject1 = b.qFq;
                    localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                    ((m)localObject1).clickComment += 1;
                    ??? = y.JfV;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                if (i == com.tencent.mm.plugin.finder.event.c.a.fSu())
                {
                  localObject1 = this.KUJ;
                  if (localObject1 != null) {
                    if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3096;
                      }
                      if (localObject1 == null) {
                        break label3108;
                      }
                      ((m)localObject1).KUZ += 1;
                      localObject1 = localObject5;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    paramc = c.b.KUB;
                    c.a.a((dzp)???, l1, 7, c.b.fTT());
                    paramc = y.JfV;
                    paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                    break;
                    i = 0;
                    break label3025;
                    localObject1 = null;
                    break label3029;
                    localObject1 = null;
                    break label3029;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    l2 = paramc.KLZ;
                    localObject1 = b.qFq;
                    localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                    ((m)localObject1).KUZ += 1;
                    ??? = y.JfV;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                if (i == com.tencent.mm.plugin.finder.event.c.a.fSv())
                {
                  localObject1 = this.KUJ;
                  if (localObject1 != null) {
                    if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3286;
                      }
                      if (localObject1 == null) {
                        break label3298;
                      }
                      ((m)localObject1).KVa += 1;
                      localObject1 = localObject4;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    paramc = c.b.KUB;
                    c.a.a((dzp)???, l1, 16, c.b.fTT());
                    paramc = y.JfV;
                    paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                    break;
                    i = 0;
                    break label3215;
                    localObject1 = null;
                    break label3219;
                    localObject1 = null;
                    break label3219;
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    l2 = paramc.KLZ;
                    localObject1 = b.qFq;
                    localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                    ((m)localObject1).KVa += 1;
                    ??? = y.JfV;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                if (i == com.tencent.mm.plugin.finder.event.c.a.fSx())
                {
                  localObject1 = this.KUJ;
                  if (localObject1 != null) {
                    if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3439;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label3451;
                    }
                    i = ((m)localObject1).KVi;
                    ((m)localObject1).KVi = (i + 1);
                    paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                    break;
                    i = 0;
                    break label3405;
                    label3439:
                    localObject1 = null;
                    continue;
                    localObject1 = null;
                  }
                  label3451:
                  l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                  l2 = paramc.KLZ;
                  localObject1 = b.qFq;
                  paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                  paramc.KVi += 1;
                  localObject1 = y.JfV;
                  localObject1 = y.JfV;
                }
                else
                {
                  localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                  if (i == com.tencent.mm.plugin.finder.event.c.a.fSq())
                  {
                    localObject1 = this.KUJ;
                    if (localObject1 != null) {
                      if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3629;
                        }
                        if (localObject1 == null) {
                          break label3641;
                        }
                        i = ((m)localObject1).KVb;
                        ((m)localObject1).KVb = (i + 1);
                        localObject1 = localObject3;
                      }
                    }
                    for (;;)
                    {
                      ??? = this.contextObj;
                      l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                      paramc = c.b.KUB;
                      c.a.a((dzp)???, l1, 12, c.b.fTT());
                      paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                      break;
                      i = 0;
                      break label3560;
                      localObject1 = null;
                      break label3564;
                      localObject1 = null;
                      break label3564;
                      l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                      l2 = paramc.KLZ;
                      localObject1 = b.qFq;
                      localObject1 = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                      ((m)localObject1).KVb += 1;
                      ??? = y.JfV;
                      ??? = y.JfV;
                    }
                  }
                  localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                  if (i == com.tencent.mm.plugin.finder.event.c.a.fSy())
                  {
                    localObject1 = this.KUJ;
                    if (localObject1 != null) {
                      if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3787;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject1 == null) {
                        break label3799;
                      }
                      i = ((m)localObject1).KVe;
                      ((m)localObject1).KVe = (i + 1);
                      paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                      break;
                      i = 0;
                      break label3753;
                      localObject1 = null;
                      continue;
                      localObject1 = null;
                    }
                    l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                    l2 = paramc.KLZ;
                    localObject1 = b.qFq;
                    paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                    paramc.KVe += 1;
                    localObject1 = y.JfV;
                    localObject1 = y.JfV;
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                    if (i == com.tencent.mm.plugin.finder.event.c.a.fSz())
                    {
                      localObject1 = this.KUJ;
                      if (localObject1 != null) {
                        if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3942;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label3954;
                        }
                        i = ((m)localObject1).KVd;
                        ((m)localObject1).KVd = (i + 1);
                        paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                        break;
                        i = 0;
                        break label3908;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      label3954:
                      l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                      l2 = paramc.KLZ;
                      localObject1 = b.qFq;
                      paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                      paramc.KVd += 1;
                      localObject1 = y.JfV;
                      localObject1 = y.JfV;
                    }
                    else
                    {
                      localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                      if (i == com.tencent.mm.plugin.finder.event.c.a.fSA())
                      {
                        localObject1 = this.KUJ;
                        if (localObject1 != null) {
                          if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4097;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4109;
                          }
                          i = ((m)localObject1).KVf;
                          ((m)localObject1).KVf = (i + 1);
                          paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                          break;
                          i = 0;
                          break label4063;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                        l2 = paramc.KLZ;
                        localObject1 = b.qFq;
                        paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                        paramc.KVf += 1;
                        localObject1 = y.JfV;
                        localObject1 = y.JfV;
                      }
                      else
                      {
                        localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                        if (i == com.tencent.mm.plugin.finder.event.c.a.fSB())
                        {
                          localObject1 = this.KUJ;
                          if (localObject1 != null) {
                            if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                            {
                              i = 1;
                              label4218:
                              if (i == 0) {
                                break label4252;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4264;
                            }
                            i = ((m)localObject1).KVg;
                            ((m)localObject1).KVg = (i + 1);
                            paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                            break;
                            i = 0;
                            break label4218;
                            localObject1 = null;
                            continue;
                            localObject1 = null;
                          }
                          l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                          l2 = paramc.KLZ;
                          localObject1 = b.qFq;
                          paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                          paramc.KVg += 1;
                          localObject1 = y.JfV;
                          localObject1 = y.JfV;
                        }
                        else
                        {
                          localObject1 = com.tencent.mm.plugin.finder.event.c.a.KLX;
                          if (i == com.tencent.mm.plugin.finder.event.c.a.fSC())
                          {
                            localObject1 = this.KUJ;
                            if (localObject1 != null) {
                              if (((m)localObject1).feedId == ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId)
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4407;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4419;
                              }
                              i = ((m)localObject1).KVh;
                              ((m)localObject1).KVh = (i + 1);
                              paramc = (com.tencent.mm.plugin.finder.event.base.c)???;
                              break;
                              i = 0;
                              break label4373;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId;
                            l2 = paramc.KLZ;
                            localObject1 = b.qFq;
                            paramc = new m(l1, l2, b.qh(((com.tencent.mm.plugin.finder.event.c.a)paramc).feedId), null, 56);
                            paramc.KVh += 1;
                            localObject1 = y.JfV;
                            localObject1 = y.JfV;
                          }
                          else
                          {
                            AppMethodBeat.o(198829);
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
        AppMethodBeat.o(198829);
        return;
      }
      if ((paramc instanceof i.b))
      {
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((i.b)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label4761;
            }
            if (localObject1 == null) {
              break label4772;
            }
            if (((i.b)paramc).qsb.mediaType != 2) {
              break label4767;
            }
          }
          for (i = 0;; i = 1)
          {
            j = ((i.b)paramc).index;
            if (j + 1 > ((m)localObject1).maxPageIndex) {
              ((m)localObject1).maxPageIndex = (j + 1);
            }
            k = ((m)localObject1).KUV;
            if (k != j)
            {
              l1 = ce.asS();
              l2 = l1 - localObject1.KUR[localObject1.KUV];
              m = localObject1.KUT[localObject1.KUV];
              n = localObject1.KUU[localObject1.KUV];
              ((m)localObject1).KUS[k] = l2;
              ((m)localObject1).KUR[j] = l1;
              ((m)localObject1).KUV = j;
              c.a.a(this.contextObj, ((m)localObject1).feedId, 4, String.valueOf(c.a.a(4, new String[] { String.valueOf(l2), String.valueOf(k), String.valueOf(j), String.valueOf(i), String.valueOf(m), String.valueOf(n) })));
            }
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label4541;
          }
        }
        AppMethodBeat.o(198829);
        return;
      }
      if ((paramc instanceof b.a)) {
        switch (((b.a)paramc).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label4946;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label4952;
            }
            ((m)localObject1).KVk = paramc.KLZ;
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5038;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5044;
            }
            if (((m)localObject1).KVk != 0L) {
              ((m)localObject1).qGD = (paramc.KLZ - ((m)localObject1).KVk);
            }
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5114;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5120;
            }
            ((m)localObject1).KVj = paramc.KLZ;
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            label5114:
            localObject1 = null;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5211;
            }
          }
          for (paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;; paramc = null)
          {
            if (paramc == null) {
              break label5216;
            }
            paramc.KUU[paramc.KUV] += 1;
            i = paramc.KUW;
            paramc.KUW = (i + 1);
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5373;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5379;
            }
            ((m)localObject1).KVo.add(Integer.valueOf(((b.a)paramc).offset));
            i = (int)(100.0F * ((b.a)paramc).offset / ((b.a)paramc).hlk);
            if (i > localObject1.KUT[localObject1.KUV]) {
              ((m)localObject1).KUT[localObject1.KUV] = i;
            }
            if (i > ((m)localObject1).KUY)
            {
              ((m)localObject1).KUX = ((b.a)paramc).offset;
              ((m)localObject1).KUY = i;
            }
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            label5373:
            localObject1 = null;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5477;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5483;
            }
            if (((m)localObject1).KVj != 0L)
            {
              ((m)localObject1).qGR += paramc.KLZ - ((m)localObject1).KVj;
              ((m)localObject1).KVj = 0L;
            }
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(198829);
        return;
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId != ((b.a)paramc).feedId) {
            break label5611;
          }
          i = 1;
          if (i == 0) {
            break label5616;
          }
          if (localObject1 != null)
          {
            ((m)localObject1).KVm = 1;
            localObject1 = y.JfV;
          }
        }
        if (((b.a)paramc).qsb != null)
        {
          if (((b.a)paramc).qsc <= ((b.a)paramc).qsd) {
            break label5622;
          }
          c.a.a(this.contextObj, ((b.a)paramc).feedId, 15, String.valueOf(c.a.a(15, new String[] { "-1" })));
        }
        for (;;)
        {
          paramc = y.JfV;
          AppMethodBeat.o(198829);
          return;
          i = 0;
          break;
          label5616:
          localObject1 = null;
          break label5523;
          label5622:
          if (((b.a)paramc).qsc < ((b.a)paramc).qsd) {
            c.a.a(this.contextObj, ((b.a)paramc).feedId, 15, String.valueOf(c.a.a(15, new String[] { "1" })));
          }
        }
        localObject1 = this.KUJ;
        if (localObject1 != null)
        {
          if (((m)localObject1).feedId == ((b.a)paramc).feedId)
          {
            i = 1;
            if (i == 0) {
              break label5737;
            }
          }
          for (paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;; paramc = null)
          {
            if (paramc == null) {
              break label5740;
            }
            paramc.KVl = 1;
            paramc = y.JfV;
            AppMethodBeat.o(198829);
            return;
            i = 0;
            break;
          }
        }
      }
    }
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(198825);
    d.g.b.k.h(paramd, "dispatcher");
    d.g.b.k.h(paramc, "event");
    if (super.a(paramd, paramc))
    {
      AppMethodBeat.o(198825);
      return true;
    }
    if ((paramc instanceof i.b))
    {
      AppMethodBeat.o(198825);
      return true;
    }
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.l))
    {
      AppMethodBeat.o(198825);
      return true;
    }
    if ((paramc instanceof com.tencent.mm.plugin.finder.event.c.a))
    {
      AppMethodBeat.o(198825);
      return true;
    }
    AppMethodBeat.o(198825);
    return false;
  }
  
  public final LinkedList<cxk> fTS()
  {
    AppMethodBeat.i(198831);
    if (this.KUI.size() > 0)
    {
      localObject1 = new v.e();
      ((v.e)localObject1).Jhw = this.KUI;
      this.KUI = new LinkedList();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("start send stats list ").append(this.contextObj.qqE).append(' ');
      Object localObject2 = (Iterable)((v.e)localObject1).Jhw;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(Long.valueOf(((cxk)((Iterator)localObject2).next()).objectId));
      }
      ad.i(str, (List)localCollection);
      new com.tencent.mm.plugin.finder.cgi.f((List)((v.e)localObject1).Jhw, this.contextObj).auK().j((com.tencent.mm.vending.c.a)new d(this, (v.e)localObject1));
      localObject1 = (LinkedList)((v.e)localObject1).Jhw;
      AppMethodBeat.o(198831);
      return localObject1;
    }
    Object localObject1 = new LinkedList();
    AppMethodBeat.o(198831);
    return localObject1;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(198833);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(198833);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(198826);
    onExit();
    super.onRelease();
    AppMethodBeat.o(198826);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(198832);
    super.onVisible();
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB((Context)this.activity);
    if (localObject != null)
    {
      localObject = ((FinderReporterUIC)localObject).Ljh;
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
        AppMethodBeat.o(198832);
        return;
      }
    }
    AppMethodBeat.o(198832);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(l paraml)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    c(FinderObject paramFinderObject) {}
    
    public final long bMs()
    {
      return this.KUO.id;
    }
    
    public final int bMt()
    {
      return 0;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(l paraml, v.e parame) {}
    
    private Object b(a.a<alh> arg1)
    {
      AppMethodBeat.i(198824);
      if ((???.errCode == 0) && (???.errType == 0))
      {
        ??? = l.KUM;
        ad.i(l.access$getTAG$cp(), "successfully! size=" + ((LinkedList)this.KUP.Jhw).size());
        ??? = y.JfV;
        AppMethodBeat.o(198824);
        return ???;
      }
      ??? = l.KUM;
      ad.w(l.access$getTAG$cp(), "fail to report! size=" + ((LinkedList)this.KUP.Jhw).size());
      synchronized (l.a(this.KUN))
      {
        boolean bool = l.a(this.KUN).addAll((Collection)this.KUP.Jhw);
        AppMethodBeat.o(198824);
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */
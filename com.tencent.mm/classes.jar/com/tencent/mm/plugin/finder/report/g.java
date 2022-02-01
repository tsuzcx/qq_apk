package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.g.b.v.f;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "waitForReportStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "checkEmptyToHotTabExpose", "", "checkRedDotExpose", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Companion", "plugin-finder_release"})
public class g
  extends a
{
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private static h rxx;
  public static final g.a rxy;
  private LinkedList<dcw> rxt;
  private h rxu;
  private HashSet<Long> rxv;
  private HashMap<Long, h> rxw;
  
  static
  {
    AppMethodBeat.i(202780);
    rxy = new g.a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    AppMethodBeat.o(202780);
  }
  
  public g(MMActivity paramMMActivity, anm paramanm)
  {
    super(paramMMActivity, paramanm);
    AppMethodBeat.i(202779);
    this.rxt = new LinkedList();
    this.rxv = new HashSet();
    this.rxw = new HashMap();
    AppMethodBeat.o(202779);
  }
  
  private final dcw a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(202775);
    h.a(paramh);
    Object localObject1 = h.ryk;
    dcw localdcw = h.a.b(paramh);
    a.a.a(this.contextObj, paramh.dig, 14, String.valueOf(paramh.endTime - paramh.startTime));
    a.a.a(this.contextObj, paramh, 2);
    if (paramBoolean) {
      if (paramh != null)
      {
        localObject1 = paramh.feed;
        if (localObject1 != null)
        {
          Object localObject2 = ((FinderItem)localObject1).getFoldedLayout();
          if ((localObject2 != null) && (((ajz)localObject2).fAw > 0))
          {
            localObject1 = paramh.rdF;
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).JCx;
            }
            while (localObject1 == null)
            {
              localObject1 = paramh.rdF;
              if (localObject1 != null)
              {
                LongSparseArray localLongSparseArray = new LongSparseArray();
                localObject2 = ((ajz)localObject2).EEw;
                k.g(localObject2, "it.objects");
                localObject2 = ((Iterable)localObject2).iterator();
                int i = 0;
                for (;;)
                {
                  if (((Iterator)localObject2).hasNext())
                  {
                    Object localObject3 = ((Iterator)localObject2).next();
                    if (i < 0) {
                      d.a.j.fOc();
                    }
                    localObject3 = (FinderObject)localObject3;
                    if (i <= 2)
                    {
                      com.tencent.mm.view.recyclerview.h localh = new com.tencent.mm.view.recyclerview.h((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject3));
                      localh.rdE = i;
                      localLongSparseArray.put(((FinderObject)localObject3).id, localh);
                    }
                    i += 1;
                    continue;
                    localObject1 = null;
                    break;
                  }
                }
                ((com.tencent.mm.view.recyclerview.f)localObject1).JCx = localLongSparseArray;
              }
            }
            a.a.a(this.contextObj, paramh);
            paramh = paramh.rdF;
            if (paramh != null)
            {
              paramh = paramh.JCy;
              if (paramh != null)
              {
                paramh = (WxRecyclerAdapter)paramh.get();
                if (paramh != null) {
                  paramh.onPause();
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(202775);
      return localdcw;
      if (paramh != null)
      {
        localObject1 = paramh.rdF;
        if ((localObject1 != null) && ((((com.tencent.mm.view.recyclerview.f)localObject1).JCv) || (((com.tencent.mm.view.recyclerview.f)localObject1).JCw)))
        {
          a.a.a(this.contextObj, paramh);
          ((com.tencent.mm.view.recyclerview.f)localObject1).JCw = false;
          paramh = ((com.tencent.mm.view.recyclerview.f)localObject1).JCy;
          if (paramh != null)
          {
            paramh = (WxRecyclerAdapter)paramh.get();
            if (paramh != null) {
              paramh.onPause();
            }
          }
        }
      }
    }
  }
  
  private final void a(h paramh, dcw paramdcw)
  {
    AppMethodBeat.i(202773);
    if (paramh.rxJ > 0) {
      a.a.a(this.contextObj, paramh.dig, 5, String.valueOf(paramh.rxJ), paramh.rxC);
    }
    long l1 = paramh.endTime;
    long l2 = paramh.startTime;
    a.a.a(this.contextObj, paramh.dig, 2, String.valueOf(l1 - l2), paramh.rxC);
    if (paramh.rxM > 0) {
      a.a.a(this.contextObj, paramh.dig, 11, String.valueOf(paramh.rxM), paramh.rxC);
    }
    Object localObject = this.contextObj;
    l1 = paramh.dig;
    paramdcw = paramdcw.FMx;
    if (paramdcw != null) {}
    for (paramdcw = Long.valueOf(paramdcw.DZq);; paramdcw = "")
    {
      a.a.a((anm)localObject, l1, 3, String.valueOf(paramdcw), paramh.rxC);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("netType", paramh.netType);
      ((JSONObject)localObject).put("isPause", paramh.ryc);
      ((JSONObject)localObject).put("isSeek", paramh.ryd);
      ((JSONObject)localObject).put("playProgressInfo", paramh.rye);
      ((JSONObject)localObject).put("maxPlayPercent", paramh.rxM);
      ((JSONObject)localObject).put("maxPlayLength", paramh.rxL);
      ((JSONObject)localObject).put("videoDuration", paramh.videoDuration);
      ((JSONObject)localObject).put("playTime", paramh.rya);
      ((JSONObject)localObject).put("realPlayTime", paramh.rxY);
      ((JSONObject)localObject).put("voiceInfo", paramh.ryi);
      paramdcw = this.contextObj;
      l1 = paramh.dig;
      localObject = ((JSONObject)localObject).toString();
      k.g(localObject, "playInfoObj.toString()");
      a.a.a(paramdcw, l1, 17, n.h((String)localObject, ",", ";", false), paramh.rxC);
      a.a.a(this.contextObj, paramh, 1);
      AppMethodBeat.o(202773);
      return;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(202772);
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cGf(), (d.g.a.a)new c(this));
    AppMethodBeat.o(202772);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(202774);
    k.h(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    label448:
    label455:
    Object localObject5;
    label1150:
    int m;
    label1401:
    int n;
    int i1;
    int i2;
    int j;
    int k;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!this.visible)
      {
        ac.i(TAG, this.contextObj.rfR + " not visible");
        AppMethodBeat.o(202774);
        return;
      }
      localObject1 = v.rve;
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdP;
      if (localObject1 != null)
      {
        ??? = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)???, 10));
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next()).rdD);
        }
      }
      for (localObject1 = (List)localObject1;; localObject1 = null)
      {
        v.a((List)localObject1, this.contextObj);
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).raQ == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdL) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).nAG == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdH) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).nAH == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdJ)) {
          break label1150;
        }
        localObject1 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).raQ == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdL) {
          break label455;
        }
        ??? = this.rxu;
        if (??? != null)
        {
          ((h)???).a(this.rwW);
          localObject3 = h.ryk;
          localObject3 = h.a.b((h)???);
          ((LinkedList)localObject1).add(localObject3);
          a((h)???, (dcw)localObject3);
          ??? = y.KTp;
        }
        ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdQ;
        if (??? == null) {
          break label448;
        }
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next();
          if (((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx() == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdL)
          {
            localObject3 = new h(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx(), paramb.rdg, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdF, true, this.rwW);
            ((h)localObject3).rxD = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdE;
            localObject4 = y.KTp;
            this.rxu = ((h)localObject3);
          }
        }
      }
      ??? = y.KTp;
      rxx = this.rxu;
      localObject3 = new HashSet();
      ??? = new HashSet();
      ((HashSet)localObject3).addAll((Collection)this.rxw.keySet());
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdQ;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdD.lx()));
          ((HashSet)???).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdD.lx()));
        }
        localObject4 = y.KTp;
      }
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdP;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          if (!((HashSet)localObject3).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdD.lx())))
          {
            ((LinkedList)localObject1).add(a(new h(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdD.lx(), paramb.rdg, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdD.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rdF, 48), true));
            localObject5 = y.KTp;
          }
        }
        localObject3 = y.KTp;
      }
      localObject3 = ((Map)this.rxw).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(((Map.Entry)localObject4).getKey())) {
          ((LinkedList)localObject1).add(a((h)((Map.Entry)localObject4).getValue(), false));
        }
      }
      ??? = new HashMap();
      localObject3 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdQ;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          localObject5 = (h)this.rxw.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx()));
          if (localObject5 != null)
          {
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx()), localObject5);
          }
          else
          {
            localObject5 = new h(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx(), paramb.rdg, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdF, 48);
            ((h)localObject5).rxD = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdE;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rdD.lx()), localObject5);
          }
        }
        localObject3 = y.KTp;
      }
      this.rxw = ((HashMap)???);
      synchronized (this.rxt)
      {
        this.rxt.addAll((Collection)localObject1);
        if (this.rxt.size() > 20)
        {
          localObject1 = FinderReporterUIC.seQ;
          com.tencent.mm.ac.c.c(FinderReporterUIC.cGf(), (d.g.a.a)new g.b(this));
        }
        localObject1 = TAG;
        ??? = new StringBuilder("waitForReportStatsList ");
        localObject4 = (Iterable)this.rxt;
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(Long.valueOf(((dcw)((Iterator)localObject4).next()).qXP));
        }
      }
      if (((com.tencent.mm.plugin.finder.event.base.j)paramb).nAH != ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdJ)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdR;
        if (localObject1 != null)
        {
          ??? = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              localObject1 = (com.tencent.mm.view.recyclerview.a)((Iterator)???).next();
              if (!this.rxv.contains(Long.valueOf(((com.tencent.mm.view.recyclerview.a)localObject1).lx()))) {
                switch (((com.tencent.mm.view.recyclerview.a)localObject1).bTF())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.contextObj.rfR == 17) || (this.contextObj.rfR == 18))
                  {
                    localObject1 = d.rxr;
                    d.b(1, this.contextObj);
                  }
                  break;
                case -2: 
                  if ((this.contextObj.rfR == 17) || (this.contextObj.rfR == 18) || (this.contextObj.rfR == 20))
                  {
                    localObject1 = FinderReporterUIC.seQ;
                    localObject1 = FinderReporterUIC.a.eV((Context)this.activity);
                    if (localObject1 != null) {
                      if (((FinderReporterUIC)localObject1).cFY())
                      {
                        if (localObject1 == null) {
                          break label1709;
                        }
                        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).nAG > 1)) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
                        k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().adx("TLWxBubble");
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.g.agR();
                        k.g(localObject1, "MMKernel.storage()");
                        m = ((e)localObject1).agA().getInt(ah.a.GUV, 0);
                        localObject1 = com.tencent.mm.kernel.g.agR();
                        k.g(localObject1, "MMKernel.storage()");
                        n = ((e)localObject1).agA().getInt(ah.a.GUW, 0);
                        localObject1 = com.tencent.mm.kernel.g.agR();
                        k.g(localObject1, "MMKernel.storage()");
                        i1 = ((e)localObject1).agA().getInt(ah.a.GUX, 0);
                        localObject1 = com.tencent.mm.kernel.g.agR();
                        k.g(localObject1, "MMKernel.storage()");
                        i2 = ((e)localObject1).agA().getInt(ah.a.GUY, 0);
                        j = 0;
                        localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
                        if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
                          break label1711;
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
                          break label5746;
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
    label1709:
    label1711:
    label2103:
    label2138:
    label2277:
    label2289:
    label2417:
    label3569:
    label5746:
    for (int i = j | 0x4;; i = j)
    {
      localObject1 = d.rxr;
      localObject1 = d.eN((Context)this.activity);
      j = i;
      i = k;
      for (;;)
      {
        localObject4 = d.rxr;
        localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.h)localObject3).field_tipsId;
        k.g(localObject3, "ctrInfo.field_tipsId");
        d.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, (String)localObject3, null, 0L, this.contextObj, 0, 0, 3456);
        break;
        localObject1 = null;
        break label1401;
        break;
        localObject1 = "2";
        i = 1;
        j = 1;
      }
      localObject1 = y.KTp;
      this.rxv = new HashSet();
      ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdR;
      if (??? != null)
      {
        localObject1 = this.rxv;
        localObject3 = (Iterable)???;
        ??? = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)???).add(Long.valueOf(((com.tencent.mm.view.recyclerview.a)((Iterator)localObject3).next()).lx()));
        }
        ((HashSet)localObject1).addAll((Collection)???);
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rdQ;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
          localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)???).rdF;
          if (localObject3 != null)
          {
            if (((com.tencent.mm.view.recyclerview.f)localObject3).JCw)
            {
              a.a.a(this.contextObj, new h(((com.tencent.mm.plugin.finder.event.base.g)???).rdD.lx(), paramb.rdg, ((com.tencent.mm.plugin.finder.event.base.g)???).rdD.feedObject, (com.tencent.mm.view.recyclerview.f)localObject3, 48));
              ((com.tencent.mm.view.recyclerview.f)localObject3).JCw = false;
              ??? = ((com.tencent.mm.view.recyclerview.f)localObject3).JCy;
              if (??? != null)
              {
                ??? = (WxRecyclerAdapter)((WeakReference)???).get();
                if (??? != null)
                {
                  ((WxRecyclerAdapter)???).onPause();
                  ??? = y.KTp;
                }
              }
            }
            ??? = y.KTp;
          }
        }
        paramb = y.KTp;
        AppMethodBeat.o(202774);
        return;
      }
      AppMethodBeat.o(202774);
      return;
      long l1;
      long l2;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.a.a))
      {
        ??? = null;
        Object localObject7 = null;
        Object localObject6 = null;
        localObject5 = null;
        localObject4 = null;
        localObject3 = null;
        Object localObject8 = null;
        i = ((com.tencent.mm.plugin.finder.event.a.a)paramb).type;
        localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
        if (i == com.tencent.mm.plugin.finder.event.a.a.ctd())
        {
          localObject1 = this.rxu;
          if (localObject1 != null) {
            if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
            {
              i = 1;
              if (i == 0) {
                break label2277;
              }
              if (localObject1 == null) {
                break label2289;
              }
              ((h)localObject1).kLX += 1;
              i = ((h)localObject1).rxR;
              ((h)localObject1).rxR = (i + 1);
              localObject1 = localObject8;
              ??? = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
              localObject3 = a.b.rwZ;
              a.a.a((anm)???, l1, 1, a.b.cwO());
              ??? = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
              paramb = u.axw();
              k.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
              paramb = a.a.a(10, new String[] { "1", paramb }).toString();
              k.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              a.a.a((anm)???, l1, 10, paramb);
              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
            }
          }
        }
        for (;;)
        {
          if (paramb != null)
          {
            h.a(paramb);
            localObject1 = h.ryk;
            paramb = h.a.b(paramb);
            this.rxt.add(paramb);
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label2103;
            localObject1 = null;
            break label2103;
            l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
            l2 = paramb.rdg;
            localObject1 = d.rxr;
            localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
            ((h)localObject1).kLX += 1;
            ((h)localObject1).rxR += 1;
            ??? = y.KTp;
            ??? = y.KTp;
            break label2138;
            localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
            if (i == com.tencent.mm.plugin.finder.event.a.a.ctc())
            {
              localObject1 = this.rxu;
              if (localObject1 != null) {
                if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                {
                  i = 1;
                  if (i == 0) {
                    break label2548;
                  }
                  if (localObject1 == null) {
                    break label2560;
                  }
                  i = ((h)localObject1).kLX;
                  ((h)localObject1).kLX = (i + 1);
                  localObject1 = localObject7;
                }
              }
              for (;;)
              {
                ??? = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                localObject3 = a.b.rwZ;
                a.a.a((anm)???, l1, 1, a.b.cwO());
                ??? = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                paramb = u.axw();
                k.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = a.a.a(10, new String[] { "2", paramb }).toString();
                k.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                a.a.a((anm)???, l1, 10, paramb);
                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                break;
                i = 0;
                break label2413;
                label2548:
                localObject1 = null;
                break label2417;
                localObject1 = null;
                break label2417;
                l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                l2 = paramb.rdg;
                localObject1 = d.rxr;
                localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                ((h)localObject1).kLX += 1;
                ??? = y.KTp;
                ??? = y.KTp;
              }
            }
            localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
            if (i == com.tencent.mm.plugin.finder.event.a.a.ctf())
            {
              localObject1 = this.contextObj;
              l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
              paramb = u.axw();
              k.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
              paramb = a.a.a(13, new String[] { "1", paramb }).toString();
              k.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              a.a.a((anm)localObject1, l1, 13, paramb);
              paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
            }
            else
            {
              localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
              if (i == com.tencent.mm.plugin.finder.event.a.a.cte())
              {
                localObject1 = this.contextObj;
                l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                paramb = u.axw();
                k.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = a.a.a(13, new String[] { "2", paramb }).toString();
                k.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                a.a.a((anm)localObject1, l1, 13, paramb);
                paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
              }
              else
              {
                localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                if (i == com.tencent.mm.plugin.finder.event.a.a.cth())
                {
                  localObject1 = this.rxu;
                  if (localObject1 != null) {
                    if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                    {
                      i = 1;
                      if (i == 0) {
                        break label2911;
                      }
                      if (localObject1 == null) {
                        break label2923;
                      }
                      ((h)localObject1).rxN += 1;
                      localObject1 = localObject6;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    paramb = a.b.rwZ;
                    a.a.a((anm)???, l1, 6, a.b.cwO());
                    paramb = y.KTp;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label2840;
                    localObject1 = null;
                    break label2844;
                    localObject1 = null;
                    break label2844;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    l2 = paramb.rdg;
                    localObject1 = d.rxr;
                    localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                    ((h)localObject1).rxN += 1;
                    ??? = y.KTp;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                if (i == com.tencent.mm.plugin.finder.event.a.a.ctk())
                {
                  localObject1 = this.rxu;
                  if (localObject1 != null) {
                    if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3101;
                      }
                      if (localObject1 == null) {
                        break label3113;
                      }
                      ((h)localObject1).rxO += 1;
                      localObject1 = localObject5;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    paramb = a.b.rwZ;
                    a.a.a((anm)???, l1, 7, a.b.cwO());
                    paramb = y.KTp;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label3030;
                    localObject1 = null;
                    break label3034;
                    localObject1 = null;
                    break label3034;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    l2 = paramb.rdg;
                    localObject1 = d.rxr;
                    localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                    ((h)localObject1).rxO += 1;
                    ??? = y.KTp;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                if (i == com.tencent.mm.plugin.finder.event.a.a.ctl())
                {
                  localObject1 = this.rxu;
                  if (localObject1 != null) {
                    if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3291;
                      }
                      if (localObject1 == null) {
                        break label3303;
                      }
                      ((h)localObject1).rxP += 1;
                      localObject1 = localObject4;
                    }
                  }
                  for (;;)
                  {
                    ??? = this.contextObj;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    paramb = a.b.rwZ;
                    a.a.a((anm)???, l1, 16, a.b.cwO());
                    paramb = y.KTp;
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                    break;
                    i = 0;
                    break label3220;
                    localObject1 = null;
                    break label3224;
                    localObject1 = null;
                    break label3224;
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    l2 = paramb.rdg;
                    localObject1 = d.rxr;
                    localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                    ((h)localObject1).rxP += 1;
                    ??? = y.KTp;
                  }
                }
                localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                if (i == com.tencent.mm.plugin.finder.event.a.a.ctn())
                {
                  localObject1 = this.rxu;
                  if (localObject1 != null) {
                    if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3444;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label3456;
                    }
                    i = ((h)localObject1).rxX;
                    ((h)localObject1).rxX = (i + 1);
                    paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                    break;
                    i = 0;
                    break label3410;
                    label3444:
                    localObject1 = null;
                    continue;
                    localObject1 = null;
                  }
                  l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                  l2 = paramb.rdg;
                  localObject1 = d.rxr;
                  paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                  paramb.rxX += 1;
                  localObject1 = y.KTp;
                  localObject1 = y.KTp;
                }
                else
                {
                  localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                  if (i == com.tencent.mm.plugin.finder.event.a.a.ctg())
                  {
                    localObject1 = this.rxu;
                    if (localObject1 != null) {
                      if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3634;
                        }
                        if (localObject1 == null) {
                          break label3646;
                        }
                        i = ((h)localObject1).rxQ;
                        ((h)localObject1).rxQ = (i + 1);
                        localObject1 = localObject3;
                      }
                    }
                    for (;;)
                    {
                      ??? = this.contextObj;
                      l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                      paramb = a.b.rwZ;
                      a.a.a((anm)???, l1, 12, a.b.cwO());
                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                      break;
                      i = 0;
                      break label3565;
                      localObject1 = null;
                      break label3569;
                      localObject1 = null;
                      break label3569;
                      l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                      l2 = paramb.rdg;
                      localObject1 = d.rxr;
                      localObject1 = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                      ((h)localObject1).rxQ += 1;
                      ??? = y.KTp;
                      ??? = y.KTp;
                    }
                  }
                  localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                  if (i == com.tencent.mm.plugin.finder.event.a.a.cto())
                  {
                    localObject1 = this.rxu;
                    if (localObject1 != null) {
                      if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3792;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject1 == null) {
                        break label3804;
                      }
                      i = ((h)localObject1).rxT;
                      ((h)localObject1).rxT = (i + 1);
                      paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                      break;
                      i = 0;
                      break label3758;
                      localObject1 = null;
                      continue;
                      localObject1 = null;
                    }
                    l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                    l2 = paramb.rdg;
                    localObject1 = d.rxr;
                    paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                    paramb.rxT += 1;
                    localObject1 = y.KTp;
                    localObject1 = y.KTp;
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                    if (i == com.tencent.mm.plugin.finder.event.a.a.ctp())
                    {
                      localObject1 = this.rxu;
                      if (localObject1 != null) {
                        if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3947;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label3959;
                        }
                        i = ((h)localObject1).rxS;
                        ((h)localObject1).rxS = (i + 1);
                        paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                        break;
                        i = 0;
                        break label3913;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      label3959:
                      l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                      l2 = paramb.rdg;
                      localObject1 = d.rxr;
                      paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                      paramb.rxS += 1;
                      localObject1 = y.KTp;
                      localObject1 = y.KTp;
                    }
                    else
                    {
                      localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                      if (i == com.tencent.mm.plugin.finder.event.a.a.ctq())
                      {
                        localObject1 = this.rxu;
                        if (localObject1 != null) {
                          if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4102;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4114;
                          }
                          i = ((h)localObject1).rxU;
                          ((h)localObject1).rxU = (i + 1);
                          paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                          break;
                          i = 0;
                          break label4068;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                        l2 = paramb.rdg;
                        localObject1 = d.rxr;
                        paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                        paramb.rxU += 1;
                        localObject1 = y.KTp;
                        localObject1 = y.KTp;
                      }
                      else
                      {
                        localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                        if (i == com.tencent.mm.plugin.finder.event.a.a.ctr())
                        {
                          localObject1 = this.rxu;
                          if (localObject1 != null) {
                            if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                            {
                              i = 1;
                              label4223:
                              if (i == 0) {
                                break label4257;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4269;
                            }
                            i = ((h)localObject1).rxV;
                            ((h)localObject1).rxV = (i + 1);
                            paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                            break;
                            i = 0;
                            break label4223;
                            localObject1 = null;
                            continue;
                            localObject1 = null;
                          }
                          l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                          l2 = paramb.rdg;
                          localObject1 = d.rxr;
                          paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                          paramb.rxV += 1;
                          localObject1 = y.KTp;
                          localObject1 = y.KTp;
                        }
                        else
                        {
                          localObject1 = com.tencent.mm.plugin.finder.event.a.a.rcW;
                          if (i == com.tencent.mm.plugin.finder.event.a.a.cts())
                          {
                            localObject1 = this.rxu;
                            if (localObject1 != null) {
                              if (((h)localObject1).dig == ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig)
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4412;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4424;
                              }
                              i = ((h)localObject1).rxW;
                              ((h)localObject1).rxW = (i + 1);
                              paramb = (com.tencent.mm.plugin.finder.event.base.b)???;
                              break;
                              i = 0;
                              break label4378;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((com.tencent.mm.plugin.finder.event.a.a)paramb).dig;
                            l2 = paramb.rdg;
                            localObject1 = d.rxr;
                            paramb = new h(l1, l2, d.ur(((com.tencent.mm.plugin.finder.event.a.a)paramb).dig), null, 56);
                            paramb.rxW += 1;
                            localObject1 = y.KTp;
                            localObject1 = y.KTp;
                          }
                          else
                          {
                            AppMethodBeat.o(202774);
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
        AppMethodBeat.o(202774);
        return;
      }
      if ((paramb instanceof p.b))
      {
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((p.b)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label4766;
            }
            if (localObject1 == null) {
              break label4777;
            }
            if (((p.b)paramb).rcY.mediaType != 2) {
              break label4772;
            }
          }
          for (i = 0;; i = 1)
          {
            j = ((p.b)paramb).index;
            if (j + 1 > ((h)localObject1).rxK) {
              ((h)localObject1).rxK = (j + 1);
            }
            k = ((h)localObject1).rxI;
            if (k != j)
            {
              l1 = ce.azJ();
              l2 = l1 - localObject1.rxE[localObject1.rxI];
              m = localObject1.rxG[localObject1.rxI];
              n = localObject1.rxH[localObject1.rxI];
              ((h)localObject1).rxF[k] = l2;
              ((h)localObject1).rxE[j] = l1;
              ((h)localObject1).rxI = j;
              a.a.a(this.contextObj, ((h)localObject1).dig, 4, String.valueOf(a.a.a(4, new String[] { String.valueOf(l2), String.valueOf(k), String.valueOf(j), String.valueOf(i), String.valueOf(m), String.valueOf(n) })));
            }
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label4546;
          }
        }
        AppMethodBeat.o(202774);
        return;
      }
      if ((paramb instanceof b.a)) {
        switch (((b.a)paramb).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label4950;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label4956;
            }
            ((h)localObject1).ryb = paramb.rdg;
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5042;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5048;
            }
            if (((h)localObject1).ryb != 0L) {
              ((h)localObject1).rya = (paramb.rdg - ((h)localObject1).ryb);
            }
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5118;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5124;
            }
            ((h)localObject1).rxZ = paramb.rdg;
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            label5118:
            localObject1 = null;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5215;
            }
          }
          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
          {
            if (paramb == null) {
              break label5220;
            }
            paramb.rxH[paramb.rxI] += 1;
            i = paramb.rxJ;
            paramb.rxJ = (i + 1);
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5377;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5383;
            }
            ((h)localObject1).ryf.add(Integer.valueOf(((b.a)paramb).offset));
            i = (int)(100.0F * ((b.a)paramb).offset / ((b.a)paramb).hLN);
            if (i > localObject1.rxG[localObject1.rxI]) {
              ((h)localObject1).rxG[localObject1.rxI] = i;
            }
            if (i > ((h)localObject1).rxM)
            {
              ((h)localObject1).rxL = ((b.a)paramb).offset;
              ((h)localObject1).rxM = i;
            }
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5481;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label5487;
            }
            if (((h)localObject1).rxZ != 0L)
            {
              ((h)localObject1).rxY += paramb.rdg - ((h)localObject1).rxZ;
              ((h)localObject1).rxZ = 0L;
            }
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(202774);
        return;
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig != ((b.a)paramb).dig) {
            break label5615;
          }
          i = 1;
          if (i == 0) {
            break label5620;
          }
          if (localObject1 != null)
          {
            ((h)localObject1).ryd = 1;
            localObject1 = y.KTp;
          }
        }
        if (((b.a)paramb).rcY != null)
        {
          if (((b.a)paramb).rda <= ((b.a)paramb).rdb) {
            break label5626;
          }
          a.a.a(this.contextObj, ((b.a)paramb).dig, 15, String.valueOf(a.a.a(15, new String[] { "-1" })));
        }
        for (;;)
        {
          paramb = y.KTp;
          AppMethodBeat.o(202774);
          return;
          i = 0;
          break;
          label5620:
          localObject1 = null;
          break label5527;
          label5626:
          if (((b.a)paramb).rda < ((b.a)paramb).rdb) {
            a.a.a(this.contextObj, ((b.a)paramb).dig, 15, String.valueOf(a.a.a(15, new String[] { "1" })));
          }
        }
        localObject1 = this.rxu;
        if (localObject1 != null)
        {
          if (((h)localObject1).dig == ((b.a)paramb).dig)
          {
            i = 1;
            if (i == 0) {
              break label5741;
            }
          }
          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
          {
            if (paramb == null) {
              break label5744;
            }
            paramb.ryc = 1;
            paramb = y.KTp;
            AppMethodBeat.o(202774);
            return;
            i = 0;
            break;
          }
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(202770);
    k.h(paramc, "dispatcher");
    k.h(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(202770);
      return true;
    }
    if ((paramb instanceof p.b))
    {
      AppMethodBeat.o(202770);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(202770);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.a.a))
    {
      AppMethodBeat.o(202770);
      return true;
    }
    AppMethodBeat.o(202770);
    return false;
  }
  
  public final LinkedList<dcw> cwN()
  {
    AppMethodBeat.i(202776);
    if (this.rxt.size() > 0)
    {
      localObject1 = new v.f();
      ((v.f)localObject1).KUQ = this.rxt;
      this.rxt = new LinkedList();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("start send stats list ").append(this.contextObj.rfR).append(' ');
      Object localObject2 = (Iterable)((v.f)localObject1).KUQ;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(Long.valueOf(((dcw)((Iterator)localObject2).next()).qXP));
      }
      ac.i(str, (List)localCollection);
      new com.tencent.mm.plugin.finder.cgi.j((List)((v.f)localObject1).KUQ, this.contextObj).aBB().j((com.tencent.mm.vending.c.a)new e(this, (v.f)localObject1));
      localObject1 = (LinkedList)((v.f)localObject1).KUQ;
      AppMethodBeat.o(202776);
      return localObject1;
    }
    Object localObject1 = new LinkedList();
    AppMethodBeat.o(202776);
    return localObject1;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(202778);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(202778);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(202771);
    onExit();
    super.onRelease();
    AppMethodBeat.o(202771);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(202777);
    super.onVisible();
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)this.activity);
    if (localObject != null)
    {
      localObject = ((FinderReporterUIC)localObject).seM;
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
        AppMethodBeat.o(202777);
        return;
      }
    }
    AppMethodBeat.o(202777);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final int bTF()
    {
      return 0;
    }
    
    public final long lx()
    {
      return this.rxA.id;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(g paramg, v.f paramf) {}
    
    private Object b(com.tencent.mm.ak.a.a<aob> arg1)
    {
      AppMethodBeat.i(202769);
      if ((???.errCode == 0) && (???.errType == 0))
      {
        ??? = g.rxy;
        ac.i(g.access$getTAG$cp(), "successfully! size=" + ((LinkedList)this.rxB.KUQ).size());
        ??? = y.KTp;
        AppMethodBeat.o(202769);
        return ???;
      }
      ??? = g.rxy;
      ac.w(g.access$getTAG$cp(), "fail to report! size=" + ((LinkedList)this.rxB.KUQ).size());
      synchronized (g.d(this.rxz))
      {
        boolean bool = g.d(this.rxz).addAll((Collection)this.rxB.KUQ);
        AppMethodBeat.o(202769);
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */
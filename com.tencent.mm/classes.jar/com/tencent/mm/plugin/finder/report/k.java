package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.convert.ab.a;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.a.ae;
import d.g.b.p;
import d.z;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "checkEmptyToHotTabExpose", "", "messageType", "", "index", "checkRedDotExpose", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExtStatsReport", "feedActionValue", "", "sendStatsLimit", "list", "hasTryTime", "sendStatsList", "Companion", "plugin-finder_release"})
public class k
  extends c
{
  private static final int HXd = 1;
  private static final int OcI = 20;
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private static l soS;
  public static final a soT;
  private LinkedList<dij> soO;
  l soP;
  HashSet<Long> soQ;
  public HashMap<Long, l> soR;
  
  static
  {
    AppMethodBeat.i(203320);
    soT = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    OcI = 20;
    HXd = 1;
    AppMethodBeat.o(203320);
  }
  
  public k(MMActivity paramMMActivity, aqy paramaqy)
  {
    super(paramMMActivity, paramaqy);
    AppMethodBeat.i(203319);
    this.soO = new LinkedList();
    this.soQ = new HashSet();
    this.soR = new HashMap();
    AppMethodBeat.o(203319);
  }
  
  private final dij a(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(203313);
    l.a(paraml);
    Object localObject1 = l.spI;
    dij localdij = l.a.a(paraml, this.rIl);
    c.a.a(this.rIl, paraml.dtq, 14, String.valueOf(paraml.endTime - paraml.startTime));
    c.a.a(this.rIl, paraml, 2);
    Object localObject3;
    Object localObject2;
    int i;
    Object localObject4;
    if (paramBoolean)
    {
      if (paraml != null)
      {
        localObject1 = paraml.feed;
        if (localObject1 != null)
        {
          localObject3 = ((FinderItem)localObject1).getFoldedLayout();
          if ((localObject3 != null) && (((amx)localObject3).fTM > 0))
          {
            localObject1 = paraml.rRb;
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LvD;
            }
            while (localObject1 == null)
            {
              localObject1 = paraml.rRb;
              if (localObject1 != null)
              {
                localObject2 = new LongSparseArray();
                localObject3 = ((amx)localObject3).Gmm;
                p.g(localObject3, "it.objects");
                localObject3 = ((Iterable)localObject3).iterator();
                i = 0;
                for (;;)
                {
                  if (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = ((Iterator)localObject3).next();
                    if (i < 0) {
                      d.a.j.gfB();
                    }
                    localObject4 = (FinderObject)localObject4;
                    if (i <= 2)
                    {
                      com.tencent.mm.view.recyclerview.h localh = new com.tencent.mm.view.recyclerview.h((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject4));
                      localh.rRa = i;
                      ((LongSparseArray)localObject2).put(((FinderObject)localObject4).id, localh);
                    }
                    i += 1;
                    continue;
                    localObject1 = null;
                    break;
                  }
                }
                ((com.tencent.mm.view.recyclerview.f)localObject1).LvD = ((LongSparseArray)localObject2);
              }
            }
            c.a.a(this.rIl, paraml);
            localObject1 = paraml.rRb;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LvE;
              if (localObject1 != null)
              {
                localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
                if (localObject1 != null) {
                  ((WxRecyclerAdapter)localObject1).onPause();
                }
              }
            }
          }
        }
      }
      if (paraml != null)
      {
        localObject1 = paraml.sjQ;
        if (localObject1 != null) {
          if (localObject1 == null) {
            break label511;
          }
        }
      }
    }
    label511:
    for (paraml = ((BaseFinderFeed)localObject1).attachFavInfo;; paraml = null)
    {
      if (paraml != null)
      {
        paraml = h.soM;
        long l = ((BaseFinderFeed)localObject1).lP();
        i = this.rIl.rTD;
        paraml = this.rIl.qXj;
        localObject2 = this.rIl.qXu;
        localObject3 = this.rIl.sessionId;
        localObject4 = h.soM;
        h.a(l, 2, i, paraml, (String)localObject2, (String)localObject3, h.I(((BaseFinderFeed)localObject1).lP(), this.rIl.rTD));
      }
      AppMethodBeat.o(203313);
      return localdij;
      if (paraml == null) {
        break;
      }
      localObject1 = paraml.rRb;
      if ((localObject1 == null) || ((!((com.tencent.mm.view.recyclerview.f)localObject1).LvB) && (!((com.tencent.mm.view.recyclerview.f)localObject1).LvC))) {
        break;
      }
      c.a.a(this.rIl, paraml);
      ((com.tencent.mm.view.recyclerview.f)localObject1).LvC = false;
      localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LvE;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        break;
      }
      ((WxRecyclerAdapter)localObject1).onPause();
      break;
    }
  }
  
  private final void a(l paraml, dij paramdij)
  {
    AppMethodBeat.i(203311);
    if (paraml.spe > 0) {
      c.a.a(this.rIl, paraml.dtq, 5, String.valueOf(paraml.spe), paraml.soX);
    }
    long l1 = paraml.endTime;
    long l2 = paraml.startTime;
    c.a.a(this.rIl, paraml.dtq, 2, String.valueOf(l1 - l2), paraml.soX);
    if (paraml.sph > 0) {
      c.a.a(this.rIl, paraml.dtq, 11, String.valueOf(paraml.sph), paraml.soX);
    }
    Object localObject = this.rIl;
    l1 = paraml.dtq;
    paramdij = paramdij.Hxf;
    if (paramdij != null) {}
    for (paramdij = Long.valueOf(paramdij.FEM);; paramdij = "")
    {
      c.a.a((aqy)localObject, l1, 3, String.valueOf(paramdij), paraml.soX);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("netType", paraml.netType);
      ((JSONObject)localObject).put("isPause", paraml.spx);
      ((JSONObject)localObject).put("isSeek", paraml.spy);
      ((JSONObject)localObject).put("playProgressInfo", paraml.spz);
      ((JSONObject)localObject).put("maxPlayPercent", paraml.sph);
      ((JSONObject)localObject).put("maxPlayLength", paraml.spg);
      ((JSONObject)localObject).put("videoDuration", paraml.videoDuration);
      ((JSONObject)localObject).put("playTime", paraml.spv);
      ((JSONObject)localObject).put("realPlayTime", paraml.spt);
      ((JSONObject)localObject).put("voiceInfo", paraml.spD);
      ((JSONObject)localObject).put("playFormat", paraml.spE);
      paramdij = this.rIl;
      l1 = paraml.dtq;
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "playInfoObj.toString()");
      c.a.a(paramdij, l1, 17, d.n.n.h((String)localObject, ",", ";", false), paraml.soX);
      paramdij = a.smX;
      paramdij = a.wp(paraml.dtq);
      if (!bt.isNullOrNil(paramdij)) {
        c.a.a(this.rIl, paraml.dtq, 18, paramdij, paraml.soX);
      }
      c.a.a(this.rIl, paraml, 1);
      AppMethodBeat.o(203311);
      return;
    }
  }
  
  private final void fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203315);
    h localh = h.soM;
    h.a(1, paramInt1, paramInt2, this.rIl);
    AppMethodBeat.o(203315);
  }
  
  private final void l(LinkedList<dij> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(221537);
    if ((paramInt > HXd) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(221537);
      return;
    }
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = new LinkedList();
    if (paramLinkedList.size() > OcI)
    {
      localLinkedList2.addAll((Collection)paramLinkedList.subList(0, OcI));
      localLinkedList1.addAll((Collection)paramLinkedList.subList(OcI, paramLinkedList.size()));
    }
    for (;;)
    {
      ad.i(TAG, "[sendStatsLimit] list=" + paramLinkedList.size() + " tryCount=" + paramInt);
      new com.tencent.mm.plugin.finder.cgi.l((List)localLinkedList2, this.rIl).aEC().aED().j((com.tencent.mm.vending.c.a)new e(this, localLinkedList2, localLinkedList1, paramInt));
      AppMethodBeat.o(221537);
      return;
      localLinkedList2.addAll((Collection)paramLinkedList);
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(203310);
    FinderReporterUIC.a locala = FinderReporterUIC.tcM;
    com.tencent.mm.ad.c.c(FinderReporterUIC.cOy(), (d.g.a.a)new c(this));
    AppMethodBeat.o(203310);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(203312);
    p.h(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    label574:
    label581:
    Object localObject5;
    l locall;
    label1310:
    label1628:
    int m;
    int n;
    int i1;
    int i2;
    int k;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!this.visible)
      {
        ad.i(TAG, this.rIl.rTD + " not visible");
        AppMethodBeat.o(203312);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cHR())
      {
        localObject1 = x.skz;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRp;
        if (localObject1 != null)
        {
          ??? = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)???, 10));
          ??? = ((Iterable)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next()).rQZ);
          }
          localObject1 = (List)localObject1;
          x.a((List)localObject1, this.rIl);
        }
      }
      else
      {
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).rNl == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRj) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).obN == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRd) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).obO == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRf)) {
          break label1310;
        }
        localObject1 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).rNl == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRj) {
          break label581;
        }
        ??? = this.soP;
        if (??? != null)
        {
          ((l)???).a(this.snM);
          localObject3 = l.spI;
          localObject3 = l.a.a((l)???, this.rIl);
          ((LinkedList)localObject1).add(localObject3);
          a((l)???, (dij)localObject3);
          switch (((com.tencent.mm.plugin.finder.event.base.j)paramb).type)
          {
          case 4: 
          case 5: 
          case 7: 
          default: 
            ad.d(TAG, "centerFeedChange " + ((com.tencent.mm.plugin.finder.event.base.j)paramb).type);
          }
        }
      }
      for (;;)
      {
        ??? = z.MKo;
        ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRq;
        if (??? == null) {
          break label574;
        }
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next();
          if (((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP() == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRj)
          {
            localObject3 = new l(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP(), paramb.rQC, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rRb, true, this.snM);
            ((l)localObject3).soY = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rRa;
            localObject4 = z.MKo;
            this.soP = ((l)localObject3);
          }
        }
        localObject1 = null;
        break;
        ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(1)))));
      }
      ??? = z.MKo;
      soS = this.soP;
      localObject3 = new HashSet();
      ??? = new HashSet();
      ((HashSet)localObject3).addAll((Collection)this.soR.keySet());
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRq;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ.lP()));
          ((HashSet)???).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ.lP()));
        }
        localObject4 = z.MKo;
      }
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRp;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          if (!((HashSet)localObject3).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ.lP())))
          {
            locall = new l(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ.lP(), paramb.rQC, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rRb, 48);
            locall.sjQ = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rQZ;
            ((LinkedList)localObject1).add(a(locall, true));
            localObject5 = z.MKo;
          }
        }
        localObject3 = z.MKo;
      }
      localObject3 = ((Map)this.soR).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(((Map.Entry)localObject4).getKey())) {
          ((LinkedList)localObject1).add(a((l)((Map.Entry)localObject4).getValue(), false));
        }
      }
      ??? = new HashMap();
      localObject3 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRq;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          localObject5 = (l)this.soR.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP()));
          if (localObject5 != null)
          {
            ((l)localObject5).sjQ = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP()), localObject5);
          }
          else
          {
            localObject5 = new l(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP(), paramb.rQC, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rRb, 48);
            ((l)localObject5).sjQ = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ;
            ((l)localObject5).soY = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rRa;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rQZ.lP()), localObject5);
          }
        }
        localObject3 = z.MKo;
      }
      this.soR = ((HashMap)???);
      synchronized (this.soO)
      {
        this.soO.addAll((Collection)localObject1);
        if (this.soO.size() > 20)
        {
          localObject1 = FinderReporterUIC.tcM;
          com.tencent.mm.ad.c.c(FinderReporterUIC.cOy(), (d.g.a.a)new b(this));
        }
        localObject1 = TAG;
        ??? = new StringBuilder("waitForReportStatsList ");
        localObject4 = (Iterable)this.soO;
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(Long.valueOf(((dij)((Iterator)localObject4).next()).rIZ));
        }
      }
      if (((com.tencent.mm.plugin.finder.event.base.j)paramb).obO != ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRf)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRr;
        if (localObject1 != null)
        {
          ??? = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)???).next();
              if (!this.soQ.contains(Long.valueOf(((com.tencent.mm.view.recyclerview.a)localObject3).lP()))) {
                switch (((com.tencent.mm.view.recyclerview.a)localObject3).bYk())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.rIl.rTD == 17) || (this.rIl.rTD == 18)) {
                    fL(1, 0);
                  }
                  break;
                case 2011: 
                  if (this.rIl.rTD == 17)
                  {
                    localObject1 = com.tencent.mm.plugin.finder.convert.ab.rOP;
                    fL(2, ab.a.El(3));
                  }
                  else if (this.rIl.rTD == 18)
                  {
                    localObject1 = com.tencent.mm.plugin.finder.convert.ab.rOP;
                    fL(2, ab.a.El(1));
                  }
                  break;
                case -5: 
                  if ((this.rIl.rTD == 17) || (this.rIl.rTD == 18) || (this.rIl.rTD == 20))
                  {
                    localObject1 = FinderReporterUIC.tcM;
                    localObject1 = FinderReporterUIC.a.eY((Context)this.activity);
                    if (localObject1 != null) {
                      if (((FinderReporterUIC)localObject1).cOr())
                      {
                        if (localObject1 == null) {
                          continue;
                        }
                        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).obN > 1)) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
                        p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().ahn("TLWxBubble");
                        localObject1 = "";
                        if (localObject3 != null)
                        {
                          localObject1 = com.tencent.mm.kernel.g.ajC();
                          p.g(localObject1, "MMKernel.storage()");
                          m = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IHC, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajC();
                          p.g(localObject1, "MMKernel.storage()");
                          n = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IHD, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajC();
                          p.g(localObject1, "MMKernel.storage()");
                          i1 = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IHE, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajC();
                          p.g(localObject1, "MMKernel.storage()");
                          i2 = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IHF, 0);
                          localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
                          if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
                            break label2015;
                          }
                          k = 5;
                          if (n <= 0) {
                            break label6783;
                          }
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
    label2015:
    label2684:
    label6652:
    label6783:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (m > 0) {
        i = j | 0x8;
      }
      j = i;
      if (i1 > 0) {
        j = i | 0x2;
      }
      if (i2 > 0) {}
      for (i = j | 0x4;; i = j)
      {
        localObject1 = h.soM;
        localObject1 = h.eN((Context)this.activity);
        j = i;
        i = k;
        for (;;)
        {
          localObject4 = h.soM;
          localObject4 = ((i)localObject3).field_tipsId;
          p.g(localObject4, "ctrInfo.field_tipsId");
          h.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, (String)localObject4, null, 0L, this.rIl, 0, 0, 3456);
          localObject4 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject4).getRedDotManager().ahm("TLWxBubble");
          if ((localObject3 == null) || (localObject4 == null)) {
            break;
          }
          localObject5 = g.soH;
          g.b((String)localObject1, (i)localObject3, (ase)localObject4, 1, this.rIl, 0, 96);
          break;
          localObject1 = null;
          break label1628;
          localObject1 = "2";
          i = 1;
          j = 1;
        }
        if (((this.rIl.rTD != 17) && (this.rIl.rTD != 18)) || (!(localObject3 instanceof com.tencent.mm.plugin.finder.feed.ab))) {
          break;
        }
        localObject1 = "";
        localObject4 = ((com.tencent.mm.plugin.finder.feed.ab)localObject3).rXV.object.subList(0, Math.min(3, ((com.tencent.mm.plugin.finder.feed.ab)localObject3).rXV.object.size()));
        p.g(localObject4, "it.card.`object`.subList…, it.card.`object`.size))");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (FinderObject)((Iterator)localObject4).next();
          localObject1 = (String)localObject1 + com.tencent.mm.ad.c.rc(((FinderObject)localObject5).id) + '|';
        }
        localObject4 = com.tencent.mm.ui.component.a.KiD;
        localObject4 = (FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
        localObject3 = (com.tencent.mm.plugin.finder.feed.ab)localObject3;
        p.h(localObject3, "item");
        localObject3 = (Integer)((FinderStreamCardVM)localObject4).sZL.get(FinderStreamCardVM.a.a((com.tencent.mm.plugin.finder.feed.ab)localObject3));
        if (localObject3 != null) {}
        for (i = ((Integer)localObject3).intValue();; i = -1)
        {
          localObject3 = h.soM;
          h.a((String)localObject1, i, this.rIl);
          break;
        }
        localObject1 = z.MKo;
        this.soQ = new HashSet();
        ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRr;
        if (??? != null)
        {
          localObject1 = this.soQ;
          localObject3 = (Iterable)???;
          ??? = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)???).add(Long.valueOf(((com.tencent.mm.view.recyclerview.a)((Iterator)localObject3).next()).lP()));
          }
          ((HashSet)localObject1).addAll((Collection)???);
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rRq;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
            localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)???).rRb;
            if (localObject3 != null)
            {
              if (((com.tencent.mm.view.recyclerview.f)localObject3).LvC)
              {
                c.a.a(this.rIl, new l(((com.tencent.mm.plugin.finder.event.base.g)???).rQZ.lP(), paramb.rQC, ((com.tencent.mm.plugin.finder.event.base.g)???).rQZ.feedObject, (com.tencent.mm.view.recyclerview.f)localObject3, 48));
                ((com.tencent.mm.view.recyclerview.f)localObject3).LvC = false;
                ??? = ((com.tencent.mm.view.recyclerview.f)localObject3).LvE;
                if (??? != null)
                {
                  ??? = (WxRecyclerAdapter)((WeakReference)???).get();
                  if (??? != null)
                  {
                    ((WxRecyclerAdapter)???).onPause();
                    ??? = z.MKo;
                  }
                }
              }
              ??? = z.MKo;
            }
          }
          paramb = z.MKo;
          AppMethodBeat.o(203312);
          return;
        }
        AppMethodBeat.o(203312);
        return;
        long l1;
        long l2;
        if ((paramb instanceof a.a))
        {
          ??? = null;
          Object localObject7 = null;
          Object localObject6 = null;
          locall = null;
          localObject5 = null;
          localObject4 = null;
          localObject3 = null;
          Object localObject8 = null;
          i = ((a.a)paramb).type;
          localObject1 = a.a.rQr;
          if (i == a.a.czg())
          {
            localObject1 = this.soP;
            if (localObject1 != null) {
              if (((l)localObject1).dtq == ((a.a)paramb).dtq)
              {
                i = 1;
                if (i == 0) {
                  break label2826;
                }
                if (localObject1 == null) {
                  break label2838;
                }
                ((l)localObject1).liA += 1;
                i = ((l)localObject1).spm;
                ((l)localObject1).spm = (i + 1);
                localObject1 = localObject8;
                ??? = this.rIl;
                l1 = ((a.a)paramb).dtq;
                localObject3 = c.b.snP;
                c.a.a((aqy)???, l1, 1, c.b.cDq());
                ??? = this.rIl;
                l1 = ((a.a)paramb).dtq;
                paramb = com.tencent.mm.model.u.aAm();
                p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = c.a.a(10, new String[] { "1", paramb }).toString();
                p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((aqy)???, l1, 10, paramb);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              l.a((l)localObject1);
              paramb = l.spI;
              paramb = l.a.a((l)localObject1, this.rIl);
              this.soO.add(paramb);
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label2649;
              localObject1 = null;
              break label2649;
              l1 = ((a.a)paramb).dtq;
              l2 = paramb.rQC;
              localObject1 = h.soM;
              localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
              ((l)localObject1).liA += 1;
              ((l)localObject1).spm += 1;
              ??? = z.MKo;
              ??? = z.MKo;
              break label2684;
              localObject1 = a.a.rQr;
              if (i == a.a.czf())
              {
                localObject1 = this.soP;
                if (localObject1 != null) {
                  if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3094;
                    }
                    if (localObject1 == null) {
                      break label3106;
                    }
                    i = ((l)localObject1).liA;
                    ((l)localObject1).liA = (i + 1);
                    localObject1 = localObject7;
                  }
                }
                for (;;)
                {
                  ??? = this.rIl;
                  l1 = ((a.a)paramb).dtq;
                  localObject3 = c.b.snP;
                  c.a.a((aqy)???, l1, 1, c.b.cDq());
                  ??? = this.rIl;
                  l1 = ((a.a)paramb).dtq;
                  paramb = com.tencent.mm.model.u.aAm();
                  p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = c.a.a(10, new String[] { "2", paramb }).toString();
                  p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  c.a.a((aqy)???, l1, 10, paramb);
                  break;
                  i = 0;
                  break label2962;
                  localObject1 = null;
                  break label2966;
                  localObject1 = null;
                  break label2966;
                  l1 = ((a.a)paramb).dtq;
                  l2 = paramb.rQC;
                  localObject1 = h.soM;
                  localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                  ((l)localObject1).liA += 1;
                  ??? = z.MKo;
                  ??? = z.MKo;
                }
              }
              localObject1 = a.a.rQr;
              if (i == a.a.czi())
              {
                localObject1 = this.rIl;
                l1 = ((a.a)paramb).dtq;
                paramb = com.tencent.mm.model.u.aAm();
                p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = c.a.a(13, new String[] { "1", paramb }).toString();
                p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((aqy)localObject1, l1, 13, paramb);
                localObject1 = ???;
              }
              else
              {
                localObject1 = a.a.rQr;
                if (i == a.a.czh())
                {
                  localObject1 = this.rIl;
                  l1 = ((a.a)paramb).dtq;
                  paramb = com.tencent.mm.model.u.aAm();
                  p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = c.a.a(13, new String[] { "2", paramb }).toString();
                  p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  c.a.a((aqy)localObject1, l1, 13, paramb);
                  localObject1 = ???;
                }
                else
                {
                  localObject1 = a.a.rQr;
                  if (i == a.a.czk())
                  {
                    localObject1 = this.soP;
                    if (localObject1 != null) {
                      if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3456;
                        }
                        if (localObject1 == null) {
                          break label3468;
                        }
                        ((l)localObject1).spi += 1;
                        localObject1 = localObject6;
                      }
                    }
                    for (;;)
                    {
                      ??? = this.rIl;
                      l1 = ((a.a)paramb).dtq;
                      paramb = c.b.snP;
                      c.a.a((aqy)???, l1, 6, c.b.cDq());
                      paramb = z.MKo;
                      break;
                      i = 0;
                      break label3388;
                      localObject1 = null;
                      break label3392;
                      localObject1 = null;
                      break label3392;
                      l1 = ((a.a)paramb).dtq;
                      l2 = paramb.rQC;
                      localObject1 = h.soM;
                      localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                      ((l)localObject1).spi += 1;
                      ??? = z.MKo;
                    }
                  }
                  localObject1 = a.a.rQr;
                  if (i == a.a.czn())
                  {
                    localObject1 = this.soP;
                    if (localObject1 != null) {
                      if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3721;
                        }
                        if (localObject1 == null) {
                          break label3733;
                        }
                        ((l)localObject1).spj += 1;
                        ??? = locall;
                        localObject1 = this.rIl;
                        l1 = ((a.a)paramb).dtq;
                        localObject3 = c.b.snP;
                        c.a.a((aqy)localObject1, l1, 7, c.b.cDq());
                        localObject1 = z.MKo;
                        localObject3 = this.soP;
                        localObject1 = ???;
                        if (localObject3 == null) {
                          continue;
                        }
                        if (((l)localObject3).dtq != ((a.a)paramb).dtq) {
                          break label3799;
                        }
                        i = 1;
                        if (i == 0) {
                          break label3804;
                        }
                      }
                    }
                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                    {
                      localObject1 = ???;
                      if (paramb == null) {
                        break;
                      }
                      ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(4)))));
                      paramb = z.MKo;
                      localObject1 = ???;
                      break;
                      i = 0;
                      break label3575;
                      localObject1 = null;
                      break label3579;
                      localObject1 = null;
                      break label3579;
                      l1 = ((a.a)paramb).dtq;
                      l2 = paramb.rQC;
                      localObject1 = h.soM;
                      ??? = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                      ((l)???).spj += 1;
                      localObject1 = z.MKo;
                      break label3600;
                      i = 0;
                      break label3670;
                    }
                  }
                  else
                  {
                    localObject1 = a.a.rQr;
                    if (i == a.a.czo())
                    {
                      localObject1 = this.soP;
                      if (localObject1 != null) {
                        if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3918;
                          }
                          if (localObject1 == null) {
                            break label3930;
                          }
                          ((l)localObject1).spk += 1;
                          localObject1 = localObject5;
                        }
                      }
                      for (;;)
                      {
                        ??? = this.rIl;
                        l1 = ((a.a)paramb).dtq;
                        paramb = c.b.snP;
                        c.a.a((aqy)???, l1, 16, c.b.cDq());
                        paramb = z.MKo;
                        break;
                        i = 0;
                        break label3850;
                        localObject1 = null;
                        break label3854;
                        localObject1 = null;
                        break label3854;
                        l1 = ((a.a)paramb).dtq;
                        l2 = paramb.rQC;
                        localObject1 = h.soM;
                        localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                        ((l)localObject1).spk += 1;
                        ??? = z.MKo;
                      }
                    }
                    localObject1 = a.a.rQr;
                    if (i == a.a.czq())
                    {
                      localObject1 = this.soP;
                      if (localObject1 != null) {
                        if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                        {
                          i = 1;
                          if (i == 0) {
                            break label4072;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label4084;
                        }
                        i = ((l)localObject1).sps;
                        ((l)localObject1).sps = (i + 1);
                        localObject1 = ???;
                        break;
                        i = 0;
                        break label4037;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      l1 = ((a.a)paramb).dtq;
                      l2 = paramb.rQC;
                      localObject1 = h.soM;
                      localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                      ((l)localObject1).sps += 1;
                      paramb = z.MKo;
                      paramb = z.MKo;
                    }
                    else
                    {
                      localObject1 = a.a.rQr;
                      if (i == a.a.czj())
                      {
                        localObject1 = this.soP;
                        if (localObject1 != null) {
                          if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4260;
                            }
                            if (localObject1 == null) {
                              break label4272;
                            }
                            i = ((l)localObject1).spl;
                            ((l)localObject1).spl = (i + 1);
                            localObject1 = localObject4;
                          }
                        }
                        for (;;)
                        {
                          ??? = this.rIl;
                          l1 = ((a.a)paramb).dtq;
                          paramb = c.b.snP;
                          c.a.a((aqy)???, l1, 12, c.b.cDq());
                          break;
                          i = 0;
                          break label4194;
                          localObject1 = null;
                          break label4198;
                          localObject1 = null;
                          break label4198;
                          l1 = ((a.a)paramb).dtq;
                          l2 = paramb.rQC;
                          localObject1 = h.soM;
                          localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                          ((l)localObject1).spl += 1;
                          ??? = z.MKo;
                          ??? = z.MKo;
                        }
                      }
                      localObject1 = a.a.rQr;
                      if (i == a.a.czr())
                      {
                        localObject1 = this.soP;
                        if (localObject1 != null) {
                          if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4419;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4431;
                          }
                          i = ((l)localObject1).spo;
                          ((l)localObject1).spo = (i + 1);
                          localObject1 = ???;
                          break;
                          i = 0;
                          break label4384;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((a.a)paramb).dtq;
                        l2 = paramb.rQC;
                        localObject1 = h.soM;
                        localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                        ((l)localObject1).spo += 1;
                        paramb = z.MKo;
                        paramb = z.MKo;
                      }
                      else
                      {
                        localObject1 = a.a.rQr;
                        if (i == a.a.czs())
                        {
                          localObject1 = this.soP;
                          if (localObject1 != null) {
                            if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                            {
                              i = 1;
                              if (i == 0) {
                                break label4653;
                              }
                              if (localObject1 == null) {
                                break label4665;
                              }
                              i = ((l)localObject1).spn;
                              ((l)localObject1).spn = (i + 1);
                              ??? = localObject3;
                              localObject3 = this.soP;
                              localObject1 = ???;
                              if (localObject3 == null) {
                                continue;
                              }
                              if (((l)localObject3).dtq != ((a.a)paramb).dtq) {
                                break label4736;
                              }
                              i = 1;
                              if (i == 0) {
                                break label4741;
                              }
                            }
                          }
                          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                          {
                            localObject1 = ???;
                            if (paramb == null) {
                              break;
                            }
                            ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(7)))));
                            paramb = z.MKo;
                            localObject1 = ???;
                            break;
                            i = 0;
                            break label4541;
                            localObject1 = null;
                            break label4545;
                            localObject1 = null;
                            break label4545;
                            l1 = ((a.a)paramb).dtq;
                            l2 = paramb.rQC;
                            localObject1 = h.soM;
                            ??? = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                            ((l)???).spn += 1;
                            localObject1 = z.MKo;
                            localObject1 = z.MKo;
                            break label4568;
                            i = 0;
                            break label4601;
                          }
                        }
                        else
                        {
                          localObject1 = a.a.rQr;
                          if (i == a.a.czt())
                          {
                            localObject1 = this.soP;
                            if (localObject1 != null) {
                              if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4822;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4834;
                              }
                              i = ((l)localObject1).spp;
                              ((l)localObject1).spp = (i + 1);
                              localObject1 = ???;
                              break;
                              i = 0;
                              break label4787;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((a.a)paramb).dtq;
                            l2 = paramb.rQC;
                            localObject1 = h.soM;
                            localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                            ((l)localObject1).spp += 1;
                            paramb = z.MKo;
                            paramb = z.MKo;
                          }
                          else
                          {
                            localObject1 = a.a.rQr;
                            if (i == a.a.czu())
                            {
                              localObject1 = this.soP;
                              if (localObject1 != null) {
                                if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                                {
                                  i = 1;
                                  if (i == 0) {
                                    break label4979;
                                  }
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 == null) {
                                  break label4991;
                                }
                                i = ((l)localObject1).spq;
                                ((l)localObject1).spq = (i + 1);
                                localObject1 = ???;
                                break;
                                i = 0;
                                break label4944;
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              label4991:
                              l1 = ((a.a)paramb).dtq;
                              l2 = paramb.rQC;
                              localObject1 = h.soM;
                              localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                              ((l)localObject1).spq += 1;
                              paramb = z.MKo;
                              paramb = z.MKo;
                            }
                            else
                            {
                              localObject1 = a.a.rQr;
                              if (i == a.a.czv())
                              {
                                localObject1 = this.soP;
                                if (localObject1 != null) {
                                  if (((l)localObject1).dtq == ((a.a)paramb).dtq)
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5136;
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  if (localObject1 == null) {
                                    break label5148;
                                  }
                                  i = ((l)localObject1).spr;
                                  ((l)localObject1).spr = (i + 1);
                                  localObject1 = ???;
                                  break;
                                  i = 0;
                                  break label5101;
                                  localObject1 = null;
                                  continue;
                                  localObject1 = null;
                                }
                                l1 = ((a.a)paramb).dtq;
                                l2 = paramb.rQC;
                                localObject1 = h.soM;
                                localObject1 = new l(l1, l2, h.ws(((a.a)paramb).dtq), null, 56);
                                ((l)localObject1).spr += 1;
                                paramb = z.MKo;
                                paramb = z.MKo;
                              }
                              else
                              {
                                localObject1 = a.a.rQr;
                                if (i == a.a.czw())
                                {
                                  localObject3 = this.soP;
                                  localObject1 = ???;
                                  if (localObject3 != null)
                                  {
                                    if (((l)localObject3).dtq == ((a.a)paramb).dtq)
                                    {
                                      i = 1;
                                      if (i == 0) {
                                        break label5314;
                                      }
                                    }
                                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                    {
                                      localObject1 = ???;
                                      if (paramb == null) {
                                        break;
                                      }
                                      ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(6)))));
                                      paramb = z.MKo;
                                      localObject1 = ???;
                                      break;
                                      i = 0;
                                      break label5262;
                                    }
                                  }
                                }
                                else
                                {
                                  localObject1 = a.a.rQr;
                                  if (i == a.a.czx())
                                  {
                                    localObject3 = this.soP;
                                    localObject1 = ???;
                                    if (localObject3 != null)
                                    {
                                      if (((l)localObject3).dtq == ((a.a)paramb).dtq)
                                      {
                                        i = 1;
                                        if (i == 0) {
                                          break label5416;
                                        }
                                      }
                                      for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                      {
                                        localObject1 = ???;
                                        if (paramb == null) {
                                          break;
                                        }
                                        ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(8)))));
                                        paramb = z.MKo;
                                        localObject1 = ???;
                                        break;
                                        i = 0;
                                        break label5364;
                                      }
                                    }
                                  }
                                  else
                                  {
                                    localObject1 = a.a.rQr;
                                    if (i == a.a.czy())
                                    {
                                      localObject3 = this.soP;
                                      localObject1 = ???;
                                      if (localObject3 != null)
                                      {
                                        if (((l)localObject3).dtq == ((a.a)paramb).dtq)
                                        {
                                          i = 1;
                                          if (i == 0) {
                                            break label5518;
                                          }
                                        }
                                        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                        {
                                          localObject1 = ???;
                                          if (paramb == null) {
                                            break;
                                          }
                                          ahO(c.a.Y(ae.c(d.u.S("feedActionType", Integer.valueOf(9)))));
                                          paramb = z.MKo;
                                          localObject1 = ???;
                                          break;
                                          i = 0;
                                          break label5466;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      AppMethodBeat.o(203312);
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
          AppMethodBeat.o(203312);
          return;
        }
        if ((paramb instanceof v.b))
        {
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((v.b)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label5797;
              }
              if (localObject1 == null) {
                break label5808;
              }
              if (((v.b)paramb).rQt.mediaType != 2) {
                break label5803;
              }
            }
            for (i = 0;; i = 1)
            {
              j = ((v.b)paramb).index;
              if (j + 1 > ((l)localObject1).spf) {
                ((l)localObject1).spf = (j + 1);
              }
              k = ((l)localObject1).spd;
              if (k != j)
              {
                l1 = cf.aCM();
                l2 = l1 - localObject1.soZ[localObject1.spd];
                m = localObject1.spb[localObject1.spd];
                n = localObject1.spc[localObject1.spd];
                ((l)localObject1).spa[k] = l2;
                ((l)localObject1).soZ[j] = l1;
                ((l)localObject1).spd = j;
                c.a.a(this.rIl, ((l)localObject1).dtq, 4, String.valueOf(c.a.a(4, new String[] { String.valueOf(l2), String.valueOf(k), String.valueOf(j), String.valueOf(i), String.valueOf(m), String.valueOf(n) })));
              }
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label5577;
            }
          }
          AppMethodBeat.o(203312);
          return;
        }
        if ((paramb instanceof b.a)) {
          switch (((b.a)paramb).type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label5982;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label5988;
              }
              ((l)localObject1).spw = paramb.rQC;
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6074;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6080;
              }
              if (((l)localObject1).spw != 0L) {
                ((l)localObject1).spv = (paramb.rQC - ((l)localObject1).spw);
              }
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6150;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6156;
              }
              ((l)localObject1).spu = paramb.rQC;
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6247;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label6252;
              }
              paramb.spc[paramb.spd] += 1;
              i = paramb.spe;
              paramb.spe = (i + 1);
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6409;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6415;
              }
              ((l)localObject1).spA.add(Integer.valueOf(((b.a)paramb).offset));
              i = (int)(100.0F * ((b.a)paramb).offset / ((b.a)paramb).ieH);
              if (i > localObject1.spb[localObject1.spd]) {
                ((l)localObject1).spb[localObject1.spd] = i;
              }
              if (i > ((l)localObject1).sph)
              {
                ((l)localObject1).spg = ((b.a)paramb).offset;
                ((l)localObject1).sph = i;
              }
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6513;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6519;
              }
              if (((l)localObject1).spu != 0L)
              {
                ((l)localObject1).spt += paramb.rQC - ((l)localObject1).spu;
                ((l)localObject1).spu = 0L;
              }
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203312);
          return;
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq != ((b.a)paramb).dtq) {
              break label6647;
            }
            i = 1;
            if (i == 0) {
              break label6652;
            }
            if (localObject1 != null)
            {
              ((l)localObject1).spy = 1;
              localObject1 = z.MKo;
            }
          }
          if (((b.a)paramb).rQt != null)
          {
            if (((b.a)paramb).rQv <= ((b.a)paramb).rQw) {
              break label6658;
            }
            c.a.a(this.rIl, ((b.a)paramb).dtq, 15, String.valueOf(c.a.a(15, new String[] { "-1" })));
          }
          for (;;)
          {
            paramb = z.MKo;
            AppMethodBeat.o(203312);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label6559;
            if (((b.a)paramb).rQv < ((b.a)paramb).rQw) {
              c.a.a(this.rIl, ((b.a)paramb).dtq, 15, String.valueOf(c.a.a(15, new String[] { "1" })));
            }
          }
          localObject1 = this.soP;
          if (localObject1 != null)
          {
            if (((l)localObject1).dtq == ((b.a)paramb).dtq)
            {
              i = 1;
              if (i == 0) {
                break label6773;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label6776;
              }
              paramb.spx = 1;
              paramb = z.MKo;
              AppMethodBeat.o(203312);
              return;
              i = 0;
              break;
            }
          }
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(203308);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(203308);
      return true;
    }
    if ((paramb instanceof v.b))
    {
      AppMethodBeat.o(203308);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(203308);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(203308);
      return true;
    }
    AppMethodBeat.o(203308);
    return false;
  }
  
  public final void ahO(String paramString)
  {
    AppMethodBeat.i(203318);
    p.h(paramString, "feedActionValue");
    l locall = this.soP;
    if (locall != null)
    {
      ad.i(TAG, "sendExtStatsReport ".concat(String.valueOf(paramString)));
      aie localaie = new aie();
      localaie.rIZ = locall.dtq;
      Object localObject = locall.feed;
      if (localObject != null) {
        localaie.rTn = ((FinderItem)localObject).getUserName();
      }
      localObject = h.soM;
      localaie.sessionBuffer = h.I(locall.dtq, this.rIl.rTD);
      localaie.GfF = paramString;
      localaie.videoDuration = locall.videoDuration;
      paramString = locall.feed;
      if (paramString != null) {}
      for (int i = paramString.getMediaType();; i = 0)
      {
        localaie.mediaType = i;
        a.a(this.rIl, localaie);
        AppMethodBeat.o(203318);
        return;
      }
    }
    AppMethodBeat.o(203318);
  }
  
  public final LinkedList<dij> cDp()
  {
    AppMethodBeat.i(203314);
    if (this.soO.size() > 0)
    {
      localLinkedList = this.soO;
      this.soO = new LinkedList();
      l(localLinkedList, 0);
      AppMethodBeat.o(203314);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(203314);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203317);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(203317);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(203309);
    onExit();
    super.onRelease();
    AppMethodBeat.o(203309);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(203316);
    super.onVisible();
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY((Context)this.activity);
    if (localObject != null)
    {
      localObject = ((FinderReporterUIC)localObject).tcI;
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
        AppMethodBeat.o(203316);
        return;
      }
    }
    AppMethodBeat.o(203316);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "LIMIT_PER_COUNT", "", "getLIMIT_PER_COUNT", "()I", "RETRY_COUNT", "getRETRY_COUNT", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(aqy paramaqy, aie paramaie)
    {
      AppMethodBeat.i(203303);
      p.h(paramaqy, "contextObj");
      p.h(paramaie, "extStats");
      ad.i(k.access$getTAG$cp(), "sendExtStatsReport " + paramaie.rIZ);
      com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)new com.tencent.mm.plugin.finder.cgi.ab(paramaqy, paramaie));
      AppMethodBeat.o(203303);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final int bYk()
    {
      return 0;
    }
    
    public final long lP()
    {
      return this.soV.id;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(k paramk, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */
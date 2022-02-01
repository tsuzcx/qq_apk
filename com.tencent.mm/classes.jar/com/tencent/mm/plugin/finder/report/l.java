package com.tencent.mm.plugin.finder.report;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.finder.convert.ab.a;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.u;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "checkEmptyToHotTabExpose", "", "messageType", "", "index", "checkRedDotExpose", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExtStatsReport", "feedActionValue", "", "sendStatsLimit", "list", "hasTryTime", "sendStatsList", "Companion", "plugin-finder_release"})
public class l
  extends c
{
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private static final int syZ = 20;
  private static final int sza = 1;
  private static m szb;
  public static final a szc;
  private LinkedList<dje> syV;
  m syW;
  HashSet<Long> syX;
  public HashMap<Long, m> syY;
  
  static
  {
    AppMethodBeat.i(203878);
    szc = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    syZ = 20;
    sza = 1;
    AppMethodBeat.o(203878);
  }
  
  public l(MMActivity paramMMActivity, arn paramarn)
  {
    super(paramMMActivity, paramarn);
    AppMethodBeat.i(203877);
    this.syV = new LinkedList();
    this.syX = new HashSet();
    this.syY = new HashMap();
    AppMethodBeat.o(203877);
  }
  
  private final dje a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(203870);
    m.a(paramm);
    Object localObject1 = m.szT;
    dje localdje = m.a.a(paramm, this.rQw);
    c.a.a(this.rQw, paramm.duw, 14, String.valueOf(paramm.endTime - paramm.startTime));
    c.a.a(this.rQw, paramm, 2);
    Object localObject3;
    Object localObject2;
    int i;
    Object localObject4;
    if (paramBoolean)
    {
      if (paramm != null)
      {
        localObject1 = paramm.feed;
        if (localObject1 != null)
        {
          localObject3 = ((FinderItem)localObject1).getFoldedLayout();
          if ((localObject3 != null) && (((ank)localObject3).fVS > 0))
          {
            localObject1 = paramm.rZD;
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LSq;
            }
            while (localObject1 == null)
            {
              localObject1 = paramm.rZD;
              if (localObject1 != null)
              {
                localObject2 = new LongSparseArray();
                localObject3 = ((ank)localObject3).GFu;
                p.g(localObject3, "it.objects");
                localObject3 = ((Iterable)localObject3).iterator();
                i = 0;
                for (;;)
                {
                  if (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = ((Iterator)localObject3).next();
                    if (i < 0) {
                      d.a.j.gkd();
                    }
                    localObject4 = (FinderObject)localObject4;
                    if (i <= 2)
                    {
                      com.tencent.mm.view.recyclerview.h localh = new com.tencent.mm.view.recyclerview.h((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject4));
                      localh.rZC = i;
                      ((LongSparseArray)localObject2).put(((FinderObject)localObject4).id, localh);
                    }
                    i += 1;
                    continue;
                    localObject1 = null;
                    break;
                  }
                }
                ((com.tencent.mm.view.recyclerview.f)localObject1).LSq = ((LongSparseArray)localObject2);
              }
            }
            c.a.a(this.rQw, paramm);
            localObject1 = paramm.rZD;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LSr;
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
      if (paramm != null)
      {
        localObject1 = paramm.ssN;
        if (localObject1 != null) {
          if (localObject1 == null) {
            break label511;
          }
        }
      }
    }
    label511:
    for (paramm = ((BaseFinderFeed)localObject1).attachFavInfo;; paramm = null)
    {
      if (paramm != null)
      {
        paramm = i.syT;
        long l = ((BaseFinderFeed)localObject1).lP();
        i = this.rQw.sch;
        paramm = this.rQw.rfo;
        localObject2 = this.rQw.rfA;
        localObject3 = this.rQw.sessionId;
        localObject4 = i.syT;
        i.a(l, 2, i, paramm, (String)localObject2, (String)localObject3, i.I(((BaseFinderFeed)localObject1).lP(), this.rQw.sch));
      }
      AppMethodBeat.o(203870);
      return localdje;
      if (paramm == null) {
        break;
      }
      localObject1 = paramm.rZD;
      if ((localObject1 == null) || ((!((com.tencent.mm.view.recyclerview.f)localObject1).LSo) && (!((com.tencent.mm.view.recyclerview.f)localObject1).LSp))) {
        break;
      }
      c.a.a(this.rQw, paramm);
      ((com.tencent.mm.view.recyclerview.f)localObject1).LSp = false;
      localObject1 = ((com.tencent.mm.view.recyclerview.f)localObject1).LSr;
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
  
  private final void a(m paramm, dje paramdje)
  {
    AppMethodBeat.i(203868);
    if (paramm.szp > 0) {
      c.a.a(this.rQw, paramm.duw, 5, String.valueOf(paramm.szp), paramm.szi);
    }
    long l1 = paramm.endTime;
    long l2 = paramm.startTime;
    c.a.a(this.rQw, paramm.duw, 2, String.valueOf(l1 - l2), paramm.szi);
    if (paramm.szs > 0) {
      c.a.a(this.rQw, paramm.duw, 11, String.valueOf(paramm.szs), paramm.szi);
    }
    Object localObject = this.rQw;
    l1 = paramm.duw;
    paramdje = paramdje.HQO;
    if (paramdje != null) {}
    for (paramdje = Long.valueOf(paramdje.FXh);; paramdje = "")
    {
      c.a.a((arn)localObject, l1, 3, String.valueOf(paramdje), paramm.szi);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("netType", paramm.netType);
      ((JSONObject)localObject).put("isPause", paramm.szI);
      ((JSONObject)localObject).put("isSeek", paramm.szJ);
      ((JSONObject)localObject).put("playProgressInfo", paramm.szK);
      ((JSONObject)localObject).put("maxPlayPercent", paramm.szs);
      ((JSONObject)localObject).put("maxPlayLength", paramm.szr);
      ((JSONObject)localObject).put("videoDuration", paramm.videoDuration);
      ((JSONObject)localObject).put("playTime", paramm.szG);
      ((JSONObject)localObject).put("realPlayTime", paramm.szE);
      ((JSONObject)localObject).put("voiceInfo", paramm.szO);
      ((JSONObject)localObject).put("playFormat", paramm.szP);
      paramdje = this.rQw;
      l1 = paramm.duw;
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "playInfoObj.toString()");
      c.a.a(paramdje, l1, 17, d.n.n.h((String)localObject, ",", ";", false), paramm.szi);
      paramdje = a.swO;
      paramdje = a.wF(paramm.duw);
      if (!bu.isNullOrNil(paramdje)) {
        c.a.a(this.rQw, paramm.duw, 18, paramdje, paramm.szi);
      }
      c.a.a(this.rQw, paramm, 1);
      AppMethodBeat.o(203868);
      return;
    }
  }
  
  private final void f(LinkedList<dje> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(203872);
    if ((paramInt > sza) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(203872);
      return;
    }
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = new LinkedList();
    if (paramLinkedList.size() > syZ)
    {
      localLinkedList2.addAll((Collection)paramLinkedList.subList(0, syZ));
      localLinkedList1.addAll((Collection)paramLinkedList.subList(syZ, paramLinkedList.size()));
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "[sendStatsLimit] list=" + paramLinkedList.size() + " tryCount=" + paramInt);
      new com.tencent.mm.plugin.finder.cgi.l((List)localLinkedList2, this.rQw).aES().aET().j((com.tencent.mm.vending.c.a)new e(this, localLinkedList2, localLinkedList1, paramInt));
      AppMethodBeat.o(203872);
      return;
      localLinkedList2.addAll((Collection)paramLinkedList);
    }
  }
  
  private final void fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203873);
    i locali = i.syT;
    i.a(1, paramInt1, paramInt2, this.rQw);
    AppMethodBeat.o(203873);
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(203867);
    FinderReporterUIC.a locala = FinderReporterUIC.tnG;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cRd(), (d.g.a.a)new c(this));
    AppMethodBeat.o(203867);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(203869);
    p.h(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    label574:
    label581:
    Object localObject5;
    m localm;
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
        com.tencent.mm.sdk.platformtools.ae.i(TAG, this.rQw.sch + " not visible");
        AppMethodBeat.o(203869);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJO())
      {
        localObject1 = y.stw;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZR;
        if (localObject1 != null)
        {
          ??? = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)???, 10));
          ??? = ((Iterable)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next()).rZB);
          }
          localObject1 = (List)localObject1;
          y.a((List)localObject1, this.rQw);
        }
      }
      else
      {
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).rVz == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZL) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ohB == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZF) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ohC == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZH)) {
          break label1310;
        }
        localObject1 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).rVz == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZL) {
          break label581;
        }
        ??? = this.syW;
        if (??? != null)
        {
          ((m)???).a(this.sxD);
          localObject3 = m.szT;
          localObject3 = m.a.a((m)???, this.rQw);
          ((LinkedList)localObject1).add(localObject3);
          a((m)???, (dje)localObject3);
          switch (((com.tencent.mm.plugin.finder.event.base.j)paramb).type)
          {
          case 4: 
          case 5: 
          case 7: 
          default: 
            com.tencent.mm.sdk.platformtools.ae.d(TAG, "centerFeedChange " + ((com.tencent.mm.plugin.finder.event.base.j)paramb).type);
          }
        }
      }
      for (;;)
      {
        ??? = z.Nhr;
        ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZS;
        if (??? == null) {
          break label574;
        }
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)???).next();
          if (((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP() == ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZL)
          {
            localObject3 = new m(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP(), paramb.rZe, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZD, true, this.sxD);
            ((m)localObject3).szj = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZC;
            localObject4 = z.Nhr;
            this.syW = ((m)localObject3);
          }
        }
        localObject1 = null;
        break;
        aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(1)))));
      }
      ??? = z.Nhr;
      szb = this.syW;
      localObject3 = new HashSet();
      ??? = new HashSet();
      ((HashSet)localObject3).addAll((Collection)this.syY.keySet());
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZS;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB.lP()));
          ((HashSet)???).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB.lP()));
        }
        localObject4 = z.Nhr;
      }
      localObject4 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZR;
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          if (!((HashSet)localObject3).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB.lP())))
          {
            localm = new m(((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB.lP(), paramb.rZe, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZD, 48);
            localm.ssN = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).rZB;
            ((LinkedList)localObject1).add(a(localm, true));
            localObject5 = z.Nhr;
          }
        }
        localObject3 = z.Nhr;
      }
      localObject3 = ((Map)this.syY).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(((Map.Entry)localObject4).getKey())) {
          ((LinkedList)localObject1).add(a((m)((Map.Entry)localObject4).getValue(), false));
        }
      }
      ??? = new HashMap();
      localObject3 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZS;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          localObject5 = (m)this.syY.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP()));
          if (localObject5 != null)
          {
            ((m)localObject5).ssN = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP()), localObject5);
          }
          else
          {
            localObject5 = new m(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP(), paramb.rZe, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.feedObject, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZD, 48);
            ((m)localObject5).ssN = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB;
            ((m)localObject5).szj = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZC;
            ((HashMap)???).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject4).rZB.lP()), localObject5);
          }
        }
        localObject3 = z.Nhr;
      }
      this.syY = ((HashMap)???);
      synchronized (this.syV)
      {
        this.syV.addAll((Collection)localObject1);
        if (this.syV.size() > 20)
        {
          localObject1 = FinderReporterUIC.tnG;
          com.tencent.mm.ac.c.c(FinderReporterUIC.cRd(), (d.g.a.a)new b(this));
        }
        localObject1 = TAG;
        ??? = new StringBuilder("waitForReportStatsList ");
        localObject4 = (Iterable)this.syV;
        localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(Long.valueOf(((dje)((Iterator)localObject4).next()).rRn));
        }
      }
      if (((com.tencent.mm.plugin.finder.event.base.j)paramb).ohC != ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZH)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZT;
        if (localObject1 != null)
        {
          ??? = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)???).hasNext())
            {
              localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)???).next();
              if (!this.syX.contains(Long.valueOf(((com.tencent.mm.view.recyclerview.a)localObject3).lP()))) {
                switch (((com.tencent.mm.view.recyclerview.a)localObject3).bZz())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.rQw.sch == 17) || (this.rQw.sch == 18)) {
                    fL(1, 0);
                  }
                  break;
                case 2011: 
                  if (this.rQw.sch == 17)
                  {
                    localObject1 = com.tencent.mm.plugin.finder.convert.ab.rXp;
                    fL(2, ab.a.Ey(3));
                  }
                  else if (this.rQw.sch == 18)
                  {
                    localObject1 = com.tencent.mm.plugin.finder.convert.ab.rXp;
                    fL(2, ab.a.Ey(1));
                  }
                  break;
                case -5: 
                  if ((this.rQw.sch == 17) || (this.rQw.sch == 18) || (this.rQw.sch == 20))
                  {
                    localObject1 = FinderReporterUIC.tnG;
                    localObject1 = FinderReporterUIC.a.fc((Context)this.activity);
                    if (localObject1 != null) {
                      if (((FinderReporterUIC)localObject1).cQW())
                      {
                        if (localObject1 == null) {
                          continue;
                        }
                        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).ohB > 1)) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
                        p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().aij("TLWxBubble");
                        localObject1 = "";
                        if (localObject3 != null)
                        {
                          localObject1 = com.tencent.mm.kernel.g.ajR();
                          p.g(localObject1, "MMKernel.storage()");
                          m = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jcf, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajR();
                          p.g(localObject1, "MMKernel.storage()");
                          n = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jcg, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajR();
                          p.g(localObject1, "MMKernel.storage()");
                          i1 = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jch, 0);
                          localObject1 = com.tencent.mm.kernel.g.ajR();
                          p.g(localObject1, "MMKernel.storage()");
                          i2 = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jci, 0);
                          localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
                          if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
                            break label2004;
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
    label2004:
    label2649:
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
        localObject1 = i.syT;
        localObject1 = i.eR((Context)this.activity);
        j = i;
        i = k;
        for (;;)
        {
          localObject4 = i.syT;
          i.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).field_tipsId, null, 0L, this.rQw, 0, 0, 3456);
          localObject4 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject4).getRedDotManager().aii("TLWxBubble");
          if ((localObject3 == null) || (localObject4 == null)) {
            break;
          }
          localObject5 = h.syO;
          h.a((String)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject3, (ast)localObject4, 1, this.rQw, 0, 0, 96);
          break;
          localObject1 = null;
          break label1628;
          localObject1 = "2";
          i = 1;
          j = 1;
        }
        if (((this.rQw.sch != 17) && (this.rQw.sch != 18)) || (!(localObject3 instanceof com.tencent.mm.plugin.finder.feed.ab)) || (((com.tencent.mm.plugin.finder.feed.ab)localObject3).sgH != 0)) {
          break;
        }
        localObject1 = "";
        localObject4 = ((com.tencent.mm.plugin.finder.feed.ab)localObject3).sgG.object.subList(0, Math.min(3, ((com.tencent.mm.plugin.finder.feed.ab)localObject3).sgG.object.size()));
        p.g(localObject4, "it.card.`object`.subList…, it.card.`object`.size))");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (FinderObject)((Iterator)localObject4).next();
          localObject1 = (String)localObject1 + com.tencent.mm.ac.c.rp(((FinderObject)localObject5).id) + '|';
        }
        localObject4 = com.tencent.mm.ui.component.a.KEX;
        localObject4 = (FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
        localObject3 = (com.tencent.mm.plugin.finder.feed.ab)localObject3;
        p.h(localObject3, "item");
        localObject3 = (Integer)((FinderStreamCardVM)localObject4).tkZ.get(FinderStreamCardVM.a.a((com.tencent.mm.plugin.finder.feed.ab)localObject3));
        if (localObject3 != null) {}
        for (i = ((Integer)localObject3).intValue();; i = -1)
        {
          localObject3 = i.syT;
          i.a((String)localObject1, i, this.rQw);
          break;
        }
        localObject1 = z.Nhr;
        this.syX = new HashSet();
        ??? = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZT;
        if (??? != null)
        {
          localObject1 = this.syX;
          localObject3 = (Iterable)???;
          ??? = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)???).add(Long.valueOf(((com.tencent.mm.view.recyclerview.a)((Iterator)localObject3).next()).lP()));
          }
          ((HashSet)localObject1).addAll((Collection)???);
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZS;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
            localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)???).rZD;
            if (localObject3 != null)
            {
              if (((com.tencent.mm.view.recyclerview.f)localObject3).LSp)
              {
                c.a.a(this.rQw, new m(((com.tencent.mm.plugin.finder.event.base.g)???).rZB.lP(), paramb.rZe, ((com.tencent.mm.plugin.finder.event.base.g)???).rZB.feedObject, (com.tencent.mm.view.recyclerview.f)localObject3, 48));
                ((com.tencent.mm.view.recyclerview.f)localObject3).LSp = false;
                ??? = ((com.tencent.mm.view.recyclerview.f)localObject3).LSr;
                if (??? != null)
                {
                  ??? = (WxRecyclerAdapter)((WeakReference)???).get();
                  if (??? != null)
                  {
                    ((WxRecyclerAdapter)???).onPause();
                    ??? = z.Nhr;
                  }
                }
              }
              ??? = z.Nhr;
            }
          }
          paramb = z.Nhr;
          AppMethodBeat.o(203869);
          return;
        }
        AppMethodBeat.o(203869);
        return;
        long l1;
        long l2;
        if ((paramb instanceof a.a))
        {
          ??? = null;
          Object localObject7 = null;
          Object localObject6 = null;
          localm = null;
          localObject5 = null;
          localObject4 = null;
          localObject3 = null;
          Object localObject8 = null;
          i = ((a.a)paramb).type;
          localObject1 = a.a.rYT;
          if (i == a.a.cAK())
          {
            localObject1 = this.syW;
            if (localObject1 != null) {
              if (((m)localObject1).duw == ((a.a)paramb).duw)
              {
                i = 1;
                if (i == 0) {
                  break label2826;
                }
                if (localObject1 == null) {
                  break label2838;
                }
                ((m)localObject1).lmm += 1;
                i = ((m)localObject1).szx;
                ((m)localObject1).szx = (i + 1);
                localObject1 = localObject8;
                ??? = this.rQw;
                l1 = ((a.a)paramb).duw;
                localObject3 = c.b.sxG;
                c.a.a((arn)???, l1, 1, c.b.cFi());
                ??? = this.rQw;
                l1 = ((a.a)paramb).duw;
                paramb = v.aAC();
                p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = c.a.a(10, new String[] { "1", paramb }).toString();
                p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((arn)???, l1, 10, paramb);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              m.a((m)localObject1);
              paramb = m.szT;
              paramb = m.a.a((m)localObject1, this.rQw);
              this.syV.add(paramb);
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label2649;
              localObject1 = null;
              break label2649;
              l1 = ((a.a)paramb).duw;
              l2 = paramb.rZe;
              localObject1 = i.syT;
              localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
              ((m)localObject1).lmm += 1;
              ((m)localObject1).szx += 1;
              ??? = z.Nhr;
              ??? = z.Nhr;
              break label2684;
              localObject1 = a.a.rYT;
              if (i == a.a.cAJ())
              {
                localObject1 = this.syW;
                if (localObject1 != null) {
                  if (((m)localObject1).duw == ((a.a)paramb).duw)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3094;
                    }
                    if (localObject1 == null) {
                      break label3106;
                    }
                    i = ((m)localObject1).lmm;
                    ((m)localObject1).lmm = (i + 1);
                    localObject1 = localObject7;
                  }
                }
                for (;;)
                {
                  ??? = this.rQw;
                  l1 = ((a.a)paramb).duw;
                  localObject3 = c.b.sxG;
                  c.a.a((arn)???, l1, 1, c.b.cFi());
                  ??? = this.rQw;
                  l1 = ((a.a)paramb).duw;
                  paramb = v.aAC();
                  p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = c.a.a(10, new String[] { "2", paramb }).toString();
                  p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  c.a.a((arn)???, l1, 10, paramb);
                  break;
                  i = 0;
                  break label2962;
                  localObject1 = null;
                  break label2966;
                  localObject1 = null;
                  break label2966;
                  l1 = ((a.a)paramb).duw;
                  l2 = paramb.rZe;
                  localObject1 = i.syT;
                  localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                  ((m)localObject1).lmm += 1;
                  ??? = z.Nhr;
                  ??? = z.Nhr;
                }
              }
              localObject1 = a.a.rYT;
              if (i == a.a.cAM())
              {
                localObject1 = this.rQw;
                l1 = ((a.a)paramb).duw;
                paramb = v.aAC();
                p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = c.a.a(13, new String[] { "1", paramb }).toString();
                p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                c.a.a((arn)localObject1, l1, 13, paramb);
                localObject1 = ???;
              }
              else
              {
                localObject1 = a.a.rYT;
                if (i == a.a.cAL())
                {
                  localObject1 = this.rQw;
                  l1 = ((a.a)paramb).duw;
                  paramb = v.aAC();
                  p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = c.a.a(13, new String[] { "2", paramb }).toString();
                  p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  c.a.a((arn)localObject1, l1, 13, paramb);
                  localObject1 = ???;
                }
                else
                {
                  localObject1 = a.a.rYT;
                  if (i == a.a.cAO())
                  {
                    localObject1 = this.syW;
                    if (localObject1 != null) {
                      if (((m)localObject1).duw == ((a.a)paramb).duw)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3456;
                        }
                        if (localObject1 == null) {
                          break label3468;
                        }
                        ((m)localObject1).szt += 1;
                        localObject1 = localObject6;
                      }
                    }
                    for (;;)
                    {
                      ??? = this.rQw;
                      l1 = ((a.a)paramb).duw;
                      paramb = c.b.sxG;
                      c.a.a((arn)???, l1, 6, c.b.cFi());
                      paramb = z.Nhr;
                      break;
                      i = 0;
                      break label3388;
                      localObject1 = null;
                      break label3392;
                      localObject1 = null;
                      break label3392;
                      l1 = ((a.a)paramb).duw;
                      l2 = paramb.rZe;
                      localObject1 = i.syT;
                      localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                      ((m)localObject1).szt += 1;
                      ??? = z.Nhr;
                    }
                  }
                  localObject1 = a.a.rYT;
                  if (i == a.a.cAR())
                  {
                    localObject1 = this.syW;
                    if (localObject1 != null) {
                      if (((m)localObject1).duw == ((a.a)paramb).duw)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3721;
                        }
                        if (localObject1 == null) {
                          break label3733;
                        }
                        ((m)localObject1).szu += 1;
                        ??? = localm;
                        localObject1 = this.rQw;
                        l1 = ((a.a)paramb).duw;
                        localObject3 = c.b.sxG;
                        c.a.a((arn)localObject1, l1, 7, c.b.cFi());
                        localObject1 = z.Nhr;
                        localObject3 = this.syW;
                        localObject1 = ???;
                        if (localObject3 == null) {
                          continue;
                        }
                        if (((m)localObject3).duw != ((a.a)paramb).duw) {
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
                      aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(4)))));
                      paramb = z.Nhr;
                      localObject1 = ???;
                      break;
                      i = 0;
                      break label3575;
                      localObject1 = null;
                      break label3579;
                      localObject1 = null;
                      break label3579;
                      l1 = ((a.a)paramb).duw;
                      l2 = paramb.rZe;
                      localObject1 = i.syT;
                      ??? = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                      ((m)???).szu += 1;
                      localObject1 = z.Nhr;
                      break label3600;
                      i = 0;
                      break label3670;
                    }
                  }
                  else
                  {
                    localObject1 = a.a.rYT;
                    if (i == a.a.cAS())
                    {
                      localObject1 = this.syW;
                      if (localObject1 != null) {
                        if (((m)localObject1).duw == ((a.a)paramb).duw)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3918;
                          }
                          if (localObject1 == null) {
                            break label3930;
                          }
                          ((m)localObject1).szv += 1;
                          localObject1 = localObject5;
                        }
                      }
                      for (;;)
                      {
                        ??? = this.rQw;
                        l1 = ((a.a)paramb).duw;
                        paramb = c.b.sxG;
                        c.a.a((arn)???, l1, 16, c.b.cFi());
                        paramb = z.Nhr;
                        break;
                        i = 0;
                        break label3850;
                        localObject1 = null;
                        break label3854;
                        localObject1 = null;
                        break label3854;
                        l1 = ((a.a)paramb).duw;
                        l2 = paramb.rZe;
                        localObject1 = i.syT;
                        localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                        ((m)localObject1).szv += 1;
                        ??? = z.Nhr;
                      }
                    }
                    localObject1 = a.a.rYT;
                    if (i == a.a.cAU())
                    {
                      localObject1 = this.syW;
                      if (localObject1 != null) {
                        if (((m)localObject1).duw == ((a.a)paramb).duw)
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
                        i = ((m)localObject1).szD;
                        ((m)localObject1).szD = (i + 1);
                        localObject1 = ???;
                        break;
                        i = 0;
                        break label4037;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      l1 = ((a.a)paramb).duw;
                      l2 = paramb.rZe;
                      localObject1 = i.syT;
                      localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                      ((m)localObject1).szD += 1;
                      paramb = z.Nhr;
                      paramb = z.Nhr;
                    }
                    else
                    {
                      localObject1 = a.a.rYT;
                      if (i == a.a.cAN())
                      {
                        localObject1 = this.syW;
                        if (localObject1 != null) {
                          if (((m)localObject1).duw == ((a.a)paramb).duw)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4260;
                            }
                            if (localObject1 == null) {
                              break label4272;
                            }
                            i = ((m)localObject1).szw;
                            ((m)localObject1).szw = (i + 1);
                            localObject1 = localObject4;
                          }
                        }
                        for (;;)
                        {
                          ??? = this.rQw;
                          l1 = ((a.a)paramb).duw;
                          paramb = c.b.sxG;
                          c.a.a((arn)???, l1, 12, c.b.cFi());
                          break;
                          i = 0;
                          break label4194;
                          localObject1 = null;
                          break label4198;
                          localObject1 = null;
                          break label4198;
                          l1 = ((a.a)paramb).duw;
                          l2 = paramb.rZe;
                          localObject1 = i.syT;
                          localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                          ((m)localObject1).szw += 1;
                          ??? = z.Nhr;
                          ??? = z.Nhr;
                        }
                      }
                      localObject1 = a.a.rYT;
                      if (i == a.a.cAV())
                      {
                        localObject1 = this.syW;
                        if (localObject1 != null) {
                          if (((m)localObject1).duw == ((a.a)paramb).duw)
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
                          i = ((m)localObject1).szz;
                          ((m)localObject1).szz = (i + 1);
                          localObject1 = ???;
                          break;
                          i = 0;
                          break label4384;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((a.a)paramb).duw;
                        l2 = paramb.rZe;
                        localObject1 = i.syT;
                        localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                        ((m)localObject1).szz += 1;
                        paramb = z.Nhr;
                        paramb = z.Nhr;
                      }
                      else
                      {
                        localObject1 = a.a.rYT;
                        if (i == a.a.cAW())
                        {
                          localObject1 = this.syW;
                          if (localObject1 != null) {
                            if (((m)localObject1).duw == ((a.a)paramb).duw)
                            {
                              i = 1;
                              if (i == 0) {
                                break label4653;
                              }
                              if (localObject1 == null) {
                                break label4665;
                              }
                              i = ((m)localObject1).szy;
                              ((m)localObject1).szy = (i + 1);
                              ??? = localObject3;
                              localObject3 = this.syW;
                              localObject1 = ???;
                              if (localObject3 == null) {
                                continue;
                              }
                              if (((m)localObject3).duw != ((a.a)paramb).duw) {
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
                            aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(7)))));
                            paramb = z.Nhr;
                            localObject1 = ???;
                            break;
                            i = 0;
                            break label4541;
                            localObject1 = null;
                            break label4545;
                            localObject1 = null;
                            break label4545;
                            l1 = ((a.a)paramb).duw;
                            l2 = paramb.rZe;
                            localObject1 = i.syT;
                            ??? = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                            ((m)???).szy += 1;
                            localObject1 = z.Nhr;
                            localObject1 = z.Nhr;
                            break label4568;
                            i = 0;
                            break label4601;
                          }
                        }
                        else
                        {
                          localObject1 = a.a.rYT;
                          if (i == a.a.cAX())
                          {
                            localObject1 = this.syW;
                            if (localObject1 != null) {
                              if (((m)localObject1).duw == ((a.a)paramb).duw)
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
                              i = ((m)localObject1).szA;
                              ((m)localObject1).szA = (i + 1);
                              localObject1 = ???;
                              break;
                              i = 0;
                              break label4787;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((a.a)paramb).duw;
                            l2 = paramb.rZe;
                            localObject1 = i.syT;
                            localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                            ((m)localObject1).szA += 1;
                            paramb = z.Nhr;
                            paramb = z.Nhr;
                          }
                          else
                          {
                            localObject1 = a.a.rYT;
                            if (i == a.a.cAY())
                            {
                              localObject1 = this.syW;
                              if (localObject1 != null) {
                                if (((m)localObject1).duw == ((a.a)paramb).duw)
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
                                i = ((m)localObject1).szB;
                                ((m)localObject1).szB = (i + 1);
                                localObject1 = ???;
                                break;
                                i = 0;
                                break label4944;
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              label4991:
                              l1 = ((a.a)paramb).duw;
                              l2 = paramb.rZe;
                              localObject1 = i.syT;
                              localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                              ((m)localObject1).szB += 1;
                              paramb = z.Nhr;
                              paramb = z.Nhr;
                            }
                            else
                            {
                              localObject1 = a.a.rYT;
                              if (i == a.a.cAZ())
                              {
                                localObject1 = this.syW;
                                if (localObject1 != null) {
                                  if (((m)localObject1).duw == ((a.a)paramb).duw)
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
                                  i = ((m)localObject1).szC;
                                  ((m)localObject1).szC = (i + 1);
                                  localObject1 = ???;
                                  break;
                                  i = 0;
                                  break label5101;
                                  localObject1 = null;
                                  continue;
                                  localObject1 = null;
                                }
                                l1 = ((a.a)paramb).duw;
                                l2 = paramb.rZe;
                                localObject1 = i.syT;
                                localObject1 = new m(l1, l2, i.wJ(((a.a)paramb).duw), null, 56);
                                ((m)localObject1).szC += 1;
                                paramb = z.Nhr;
                                paramb = z.Nhr;
                              }
                              else
                              {
                                localObject1 = a.a.rYT;
                                if (i == a.a.cBa())
                                {
                                  localObject3 = this.syW;
                                  localObject1 = ???;
                                  if (localObject3 != null)
                                  {
                                    if (((m)localObject3).duw == ((a.a)paramb).duw)
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
                                      aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(6)))));
                                      paramb = z.Nhr;
                                      localObject1 = ???;
                                      break;
                                      i = 0;
                                      break label5262;
                                    }
                                  }
                                }
                                else
                                {
                                  localObject1 = a.a.rYT;
                                  if (i == a.a.cBb())
                                  {
                                    localObject3 = this.syW;
                                    localObject1 = ???;
                                    if (localObject3 != null)
                                    {
                                      if (((m)localObject3).duw == ((a.a)paramb).duw)
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
                                        aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(8)))));
                                        paramb = z.Nhr;
                                        localObject1 = ???;
                                        break;
                                        i = 0;
                                        break label5364;
                                      }
                                    }
                                  }
                                  else
                                  {
                                    localObject1 = a.a.rYT;
                                    if (i == a.a.cBc())
                                    {
                                      localObject3 = this.syW;
                                      localObject1 = ???;
                                      if (localObject3 != null)
                                      {
                                        if (((m)localObject3).duw == ((a.a)paramb).duw)
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
                                          aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(9)))));
                                          paramb = z.Nhr;
                                          localObject1 = ???;
                                          break;
                                          i = 0;
                                          break label5466;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      AppMethodBeat.o(203869);
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
          AppMethodBeat.o(203869);
          return;
        }
        if ((paramb instanceof w.b))
        {
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((w.b)paramb).duw)
            {
              i = 1;
              if (i == 0) {
                break label5797;
              }
              if (localObject1 == null) {
                break label5808;
              }
              if (((w.b)paramb).rYV.mediaType != 2) {
                break label5803;
              }
            }
            for (i = 0;; i = 1)
            {
              j = ((w.b)paramb).index;
              if (j + 1 > ((m)localObject1).szq) {
                ((m)localObject1).szq = (j + 1);
              }
              k = ((m)localObject1).szo;
              if (k != j)
              {
                l1 = ch.aDc();
                l2 = l1 - localObject1.szk[localObject1.szo];
                m = localObject1.szm[localObject1.szo];
                n = localObject1.szn[localObject1.szo];
                ((m)localObject1).szl[k] = l2;
                ((m)localObject1).szk[j] = l1;
                ((m)localObject1).szo = j;
                c.a.a(this.rQw, ((m)localObject1).duw, 4, String.valueOf(c.a.a(4, new String[] { String.valueOf(l2), String.valueOf(k), String.valueOf(j), String.valueOf(i), String.valueOf(m), String.valueOf(n) })));
              }
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label5577;
            }
          }
          AppMethodBeat.o(203869);
          return;
        }
        if ((paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) {
          switch (((com.tencent.mm.plugin.finder.event.c.a)paramb).type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              ((m)localObject1).szH = paramb.rZe;
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              if (((m)localObject1).szH != 0L) {
                ((m)localObject1).szG = (paramb.rZe - ((m)localObject1).szH);
              }
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              ((m)localObject1).szF = paramb.rZe;
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              paramb.szn[paramb.szo] += 1;
              i = paramb.szp;
              paramb.szp = (i + 1);
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              ((m)localObject1).szL.add(Integer.valueOf(((com.tencent.mm.plugin.finder.event.c.a)paramb).offset));
              i = (int)(100.0F * ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset / ((com.tencent.mm.plugin.finder.event.c.a)paramb).ihz);
              if (i > localObject1.szm[localObject1.szo]) {
                ((m)localObject1).szm[localObject1.szo] = i;
              }
              if (i > ((m)localObject1).szs)
              {
                ((m)localObject1).szr = ((com.tencent.mm.plugin.finder.event.c.a)paramb).offset;
                ((m)localObject1).szs = i;
              }
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              if (((m)localObject1).szF != 0L)
              {
                ((m)localObject1).szE += paramb.rZe - ((m)localObject1).szF;
                ((m)localObject1).szF = 0L;
              }
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(203869);
          return;
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw != ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw) {
              break label6647;
            }
            i = 1;
            if (i == 0) {
              break label6652;
            }
            if (localObject1 != null)
            {
              ((m)localObject1).szJ = 1;
              localObject1 = z.Nhr;
            }
          }
          if (((com.tencent.mm.plugin.finder.event.c.a)paramb).rYV != null)
          {
            if (((com.tencent.mm.plugin.finder.event.c.a)paramb).rYX <= ((com.tencent.mm.plugin.finder.event.c.a)paramb).rYY) {
              break label6658;
            }
            c.a.a(this.rQw, ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw, 15, String.valueOf(c.a.a(15, new String[] { "-1" })));
          }
          for (;;)
          {
            paramb = z.Nhr;
            AppMethodBeat.o(203869);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label6559;
            if (((com.tencent.mm.plugin.finder.event.c.a)paramb).rYX < ((com.tencent.mm.plugin.finder.event.c.a)paramb).rYY) {
              c.a.a(this.rQw, ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw, 15, String.valueOf(c.a.a(15, new String[] { "1" })));
            }
          }
          localObject1 = this.syW;
          if (localObject1 != null)
          {
            if (((m)localObject1).duw == ((com.tencent.mm.plugin.finder.event.c.a)paramb).duw)
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
              paramb.szI = 1;
              paramb = z.Nhr;
              AppMethodBeat.o(203869);
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
    AppMethodBeat.i(203865);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(203865);
      return true;
    }
    if ((paramb instanceof w.b))
    {
      AppMethodBeat.o(203865);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(203865);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(203865);
      return true;
    }
    AppMethodBeat.o(203865);
    return false;
  }
  
  public final void aiM(String paramString)
  {
    AppMethodBeat.i(203876);
    p.h(paramString, "feedActionValue");
    m localm = this.syW;
    if (localm != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "sendExtStatsReport ".concat(String.valueOf(paramString)));
      aio localaio = new aio();
      localaio.rRn = localm.duw;
      Object localObject = localm.feed;
      if (localObject != null) {
        localaio.sbR = ((FinderItem)localObject).getUserName();
      }
      localObject = i.syT;
      localaio.sessionBuffer = i.I(localm.duw, this.rQw.sch);
      localaio.Gyn = paramString;
      localaio.videoDuration = localm.videoDuration;
      paramString = localm.feed;
      if (paramString != null) {}
      for (int i = paramString.getMediaType();; i = 0)
      {
        localaio.mediaType = i;
        a.a(this.rQw, localaio);
        AppMethodBeat.o(203876);
        return;
      }
    }
    AppMethodBeat.o(203876);
  }
  
  public final LinkedList<dje> cFh()
  {
    AppMethodBeat.i(203871);
    if (this.syV.size() > 0)
    {
      localLinkedList = this.syV;
      this.syV = new LinkedList();
      f(localLinkedList, 0);
      AppMethodBeat.o(203871);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(203871);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203875);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(203875);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(203866);
    onExit();
    super.onRelease();
    AppMethodBeat.o(203866);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(203874);
    super.onVisible();
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)this.activity);
    if (localObject != null)
    {
      localObject = ((FinderReporterUIC)localObject).tnC;
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
        AppMethodBeat.o(203874);
        return;
      }
    }
    AppMethodBeat.o(203874);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "LIMIT_PER_COUNT", "", "getLIMIT_PER_COUNT", "()I", "RETRY_COUNT", "getRETRY_COUNT", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(arn paramarn, aio paramaio)
    {
      AppMethodBeat.i(203861);
      p.h(paramaio, "extStats");
      com.tencent.mm.sdk.platformtools.ae.i(l.access$getTAG$cp(), "sendExtStatsReport " + paramaio.rRn);
      com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)new ac(paramarn, paramaio));
      AppMethodBeat.o(203861);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final int bZz()
    {
      return 0;
    }
    
    public final long lP()
    {
      return this.sze.id;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(l paraml, LinkedList paramLinkedList1, LinkedList paramLinkedList2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */
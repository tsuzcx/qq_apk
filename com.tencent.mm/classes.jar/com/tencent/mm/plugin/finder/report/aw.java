package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.event.base.k;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.l;
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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onExit", "onInvisible", "onRelease", "onVisible", "reportCenterRecord", "record", "stats", "reportExpose", "across", "resumeDataAdapter", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends m
{
  public static final a Fup;
  private ConcurrentLinkedQueue<fhp> Fsn;
  af Fsr;
  HashSet<Long> Fst;
  HashMap<Long, af> Fsu;
  
  static
  {
    AppMethodBeat.i(331207);
    Fup = new a((byte)0);
    AppMethodBeat.o(331207);
  }
  
  public aw(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    super(paramMMFragmentActivity, parambui);
    AppMethodBeat.i(331137);
    this.Fsn = new ConcurrentLinkedQueue();
    this.Fst = new HashSet();
    this.Fsu = new HashMap();
    AppMethodBeat.o(331137);
  }
  
  private final void a(af paramaf, fhp paramfhp)
  {
    AppMethodBeat.i(331164);
    ca localca = paramaf.FsC;
    long l1;
    Object localObject;
    if (localca != null)
    {
      l1 = localca.eDF();
      if (paramaf.FsJ > 0) {
        m.a.a(this.Auc, l1, 5, String.valueOf(paramaf.FsJ), paramaf.hlB, localca);
      }
      long l2 = paramaf.endTime - paramaf.startTime;
      localObject = z.FrZ;
      localObject = z.p(l1, this.Auc.AJo);
      if (localObject != null) {
        break label637;
      }
      localObject = "";
      com.tencent.mm.plugin.datareport.a.b localb = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      r localr1 = v.Y("feed_stay_time", Long.valueOf(l2));
      r localr2 = v.Y("feed_id", com.tencent.mm.ae.d.hF(l1));
      r localr3 = v.Y("session_buffer", localObject);
      r localr4 = v.Y("session_id", this.Auc.sessionId);
      r localr5 = v.Y("context_id", this.Auc.zIO);
      r localr6 = v.Y("click_tab_context_id", this.Auc.zIB);
      r localr7 = v.Y("extra_info", this.Auc.extraInfo);
      r localr8 = v.Y("enter_source_info", this.Auc.zIE);
      r localr9 = v.Y("comment_scene", Integer.valueOf(this.Auc.AJo));
      localObject = paramaf.ANj;
      if (localObject != null) {
        break label666;
      }
      localObject = null;
      label232:
      localb.a("feed_stay", null, ak.e(new r[] { localr1, localr2, localr3, localr4, localr5, localr6, localr7, localr8, localr9, v.Y("finder_username", localObject) }), 24617);
      m.a.a(this.Auc, l1, 2, String.valueOf(l2), paramaf.hlB, localca);
      if (paramaf.FsM > 0) {
        m.a.a(this.Auc, l1, 11, String.valueOf(paramaf.FsM), paramaf.hlB, localca);
      }
      localObject = this.Auc;
      paramfhp = paramfhp.abIh;
      if (paramfhp != null) {
        break label676;
      }
    }
    label666:
    label676:
    for (paramfhp = "";; paramfhp = Long.valueOf(paramfhp.YPj))
    {
      m.a.a((bui)localObject, l1, 3, String.valueOf(paramfhp), paramaf.hlB, localca);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("netType", paramaf.netType);
      ((JSONObject)localObject).put("isPause", paramaf.Fte);
      ((JSONObject)localObject).put("isSeek", paramaf.Ftf);
      ((JSONObject)localObject).put("playProgressInfo", paramaf.Ftg);
      ((JSONObject)localObject).put("maxPlayPercent", paramaf.FsM);
      ((JSONObject)localObject).put("maxPlayLength", paramaf.FsL);
      ((JSONObject)localObject).put("videoDuration", paramaf.videoDuration);
      ((JSONObject)localObject).put("playTime", paramaf.Ftc);
      ((JSONObject)localObject).put("realPlayTime", paramaf.Fta);
      ((JSONObject)localObject).put("voiceInfo", paramaf.Ftk);
      ((JSONObject)localObject).put("playFormat", paramaf.Ftl);
      paramfhp = this.Auc;
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "playInfoObj.toString()");
      m.a.a(paramfhp, l1, 17, n.bV((String)localObject, ",", ";"), paramaf.hlB, localca);
      paramfhp = d.FnC;
      paramfhp = d.pz(paramaf.feedId);
      if (!Util.isNullOrNil(paramfhp)) {
        m.a.a(this.Auc, l1, 18, paramfhp, paramaf.hlB, localca);
      }
      AppMethodBeat.o(331164);
      return;
      label637:
      localObject = n.m((String)localObject, ",", ";", false);
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      break;
      localObject = ((FinderItem)localObject).getUserName();
      break label232;
    }
  }
  
  private final fhp f(af paramaf)
  {
    AppMethodBeat.i(331177);
    af.e(paramaf);
    Object localObject = af.FsA;
    fhp localfhp = af.a.a(paramaf, this.Auc);
    ca localca = paramaf.FsC;
    long l1;
    com.tencent.mm.plugin.datareport.a.b localb;
    r localr1;
    r localr2;
    r localr3;
    r localr4;
    r localr5;
    r localr6;
    r localr7;
    r localr8;
    r localr9;
    if (localca != null)
    {
      l1 = localca.eDF();
      long l2 = paramaf.endTime;
      long l3 = paramaf.startTime;
      localObject = z.FrZ;
      localObject = z.p(l1, this.Auc.AJo);
      if (localObject != null) {
        break label345;
      }
      localObject = "";
      localb = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      localr1 = v.Y("feed_stay_time", Long.valueOf(l2 - l3));
      localr2 = v.Y("feed_id", com.tencent.mm.ae.d.hF(l1));
      localr3 = v.Y("session_buffer", localObject);
      localr4 = v.Y("session_id", this.Auc.sessionId);
      localr5 = v.Y("context_id", this.Auc.zIO);
      localr6 = v.Y("click_tab_context_id", this.Auc.zIB);
      localr7 = v.Y("extra_info", this.Auc.extraInfo);
      localr8 = v.Y("enter_source_info", this.Auc.zIE);
      localr9 = v.Y("comment_scene", Integer.valueOf(this.Auc.AJo));
      localObject = paramaf.ANj;
      if (localObject != null) {
        break label374;
      }
    }
    label345:
    label374:
    for (localObject = null;; localObject = ((FinderItem)localObject).getUserName())
    {
      localb.a("feed_out", null, ak.e(new r[] { localr1, localr2, localr3, localr4, localr5, localr6, localr7, localr8, localr9, v.Y("finder_username", localObject) }), 24617);
      m.a.a(this.Auc, l1, 14, String.valueOf(paramaf.endTime - paramaf.startTime), 0L, localca, 16);
      AppMethodBeat.o(331177);
      return localfhp;
      localObject = n.m((String)localObject, ",", ";", false);
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      break;
    }
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(331145);
    as.a locala = as.GSQ;
    com.tencent.mm.ae.d.e(as.foC(), (a)new c(this));
    AppMethodBeat.o(331145);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331303);
    s.u(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    label317:
    Object localObject4;
    label353:
    Object localObject5;
    long l1;
    long l2;
    label437:
    Object localObject6;
    if ((paramb instanceof k))
    {
      if (!this.visible)
      {
        Log.i("MegaVideoFeedFlowReporter", this.Auc.AJo + " not visible");
        AppMethodBeat.o(331303);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      Object localObject7;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTn().bmg()).intValue() == 1)
      {
        localObject1 = ay.EDk;
        localObject1 = ((k)paramb).AOA;
        if (localObject1 == null)
        {
          localObject1 = null;
          ay.a((List)localObject1, this.Auc);
        }
      }
      else
      {
        if ((((k)paramb).AIv == ((k)paramb).AOv) && (((k)paramb).vIj == ((k)paramb).AOr) && (((k)paramb).vIk == ((k)paramb).AOt)) {
          break label1463;
        }
        localObject3 = new LinkedList();
        if (((k)paramb).AIv == ((k)paramb).AOv) {
          break label620;
        }
        localObject1 = this.Fsr;
        if (localObject1 != null)
        {
          ((af)localObject1).a(this.FpB);
          localObject2 = af.FsA;
          localObject2 = af.a.a((af)localObject1, this.Auc);
          ((LinkedList)localObject3).add(localObject2);
          a((af)localObject1, (fhp)localObject2);
        }
        switch (((k)paramb).type)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          localObject1 = ((k)paramb).AOB;
          if (localObject1 == null) {
            break label620;
          }
          localObject4 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject5 = (g)((Iterator)localObject4).next();
          } while (((g)localObject5).AOm.bZA() != ((k)paramb).AOv);
          l1 = ((g)localObject5).AOm.bZA();
          l2 = paramb.ANT;
          if ((((g)localObject5).AOm instanceof BaseFinderFeed))
          {
            localObject1 = ((BaseFinderFeed)((g)localObject5).AOm).feedObject;
            localObject6 = ((g)localObject5).AOo;
            localObject7 = this.FpB;
            if (!(((g)localObject5).AOm instanceof ca)) {
              break label609;
            }
          }
          break;
        }
      }
      label609:
      for (localObject2 = ((g)localObject5).AOm;; localObject2 = null)
      {
        localObject1 = new af(l1, l2, (FinderItem)localObject1, (l)localObject6, true, (com.tencent.mm.plugin.finder.video.reporter.c)localObject7, (ca)localObject2);
        ((af)localObject1).FsD = ((g)localObject5).AOn;
        localObject2 = ah.aiuX;
        this.Fsr = ((af)localObject1);
        break label353;
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).AOm);
        }
        localObject1 = (List)localObject1;
        break;
        localObject1 = ah.aiuX;
        break label317;
        localObject1 = null;
        break label437;
      }
      localObject1 = ah.aiuX;
      label620:
      localObject5 = new HashSet();
      localObject4 = new HashSet();
      ((HashSet)localObject5).addAll((Collection)this.Fsu.keySet());
      localObject1 = ((k)paramb).AOB;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (g)((Iterator)localObject1).next();
          ((HashSet)localObject5).add(Long.valueOf(((g)localObject2).AOm.bZA()));
          ((HashSet)localObject4).add(Long.valueOf(((g)localObject2).AOm.bZA()));
        }
        localObject1 = ah.aiuX;
      }
      localObject1 = ((k)paramb).AOA;
      if (localObject1 != null)
      {
        localObject6 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (g)((Iterator)localObject6).next();
          if (!((HashSet)localObject5).contains(Long.valueOf(((g)localObject7).AOm.bZA())))
          {
            l1 = ((g)localObject7).AOm.bZA();
            l2 = paramb.ANT;
            label858:
            l locall;
            if ((((g)localObject7).AOm instanceof BaseFinderFeed))
            {
              localObject1 = ((BaseFinderFeed)((g)localObject7).AOm).feedObject;
              locall = ((g)localObject7).AOo;
              if (!(((g)localObject7).AOm instanceof ca)) {
                break label944;
              }
            }
            label944:
            for (localObject2 = ((g)localObject7).AOm;; localObject2 = null)
            {
              localObject1 = new af(l1, l2, (FinderItem)localObject1, locall, false, null, (ca)localObject2, 48);
              ((af)localObject1).Ftm = ((g)localObject7).AOm;
              ((LinkedList)localObject3).add(f((af)localObject1));
              localObject1 = ah.aiuX;
              break;
              localObject1 = null;
              break label858;
            }
          }
        }
        localObject1 = ah.aiuX;
      }
      localObject1 = ((Map)this.Fsu).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject4).contains(((Map.Entry)localObject2).getKey())) {
          ((LinkedList)localObject3).add(f((af)((Map.Entry)localObject2).getValue()));
        }
      }
      localObject4 = new HashMap();
      localObject1 = ((k)paramb).AOB;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (g)((Iterator)localObject5).next();
          localObject1 = (af)this.Fsu.get(Long.valueOf(((g)localObject6).AOm.bZA()));
          if (localObject1 == null)
          {
            localObject1 = null;
            label1124:
            if (localObject1 != null) {
              break label1300;
            }
            l1 = ((g)localObject6).AOm.bZA();
            l2 = paramb.ANT;
            if (!(((g)localObject6).AOm instanceof BaseFinderFeed)) {
              break label1302;
            }
            localObject1 = ((BaseFinderFeed)((g)localObject6).AOm).feedObject;
            label1170:
            localObject7 = ((g)localObject6).AOo;
            if (!(((g)localObject6).AOm instanceof ca)) {
              break label1308;
            }
          }
          label1300:
          label1302:
          label1308:
          for (localObject2 = ((g)localObject6).AOm;; localObject2 = null)
          {
            localObject1 = new af(l1, l2, (FinderItem)localObject1, (l)localObject7, false, null, (ca)localObject2, 48);
            ((af)localObject1).Ftm = ((g)localObject6).AOm;
            ((af)localObject1).FsD = ((g)localObject6).AOn;
            ((HashMap)localObject4).put(Long.valueOf(((g)localObject6).AOm.bZA()), localObject1);
            break;
            ((af)localObject1).Ftm = ((g)localObject6).AOm;
            localObject1 = (af)((HashMap)localObject4).put(Long.valueOf(((g)localObject6).AOm.bZA()), localObject1);
            break label1124;
            break;
            localObject1 = null;
            break label1170;
          }
        }
        localObject1 = ah.aiuX;
      }
      this.Fsu = ((HashMap)localObject4);
      this.Fsn.addAll((Collection)localObject3);
      if (this.Fsn.size() > 20)
      {
        localObject1 = as.GSQ;
        com.tencent.mm.ae.d.e(as.foC(), (a)new b(this));
      }
      localObject2 = (Iterable)this.Fsn;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(com.tencent.mm.ae.d.hF(((fhp)((Iterator)localObject2).next()).hKN));
      }
      Log.i("MegaVideoFeedFlowReporter", s.X("waitForReportStatsList ", (List)localObject1));
      label1463:
      if ((((k)paramb).vIj != ((k)paramb).AOr) || (((k)paramb).vIk != ((k)paramb).AOt))
      {
        this.Fst = new HashSet();
        localObject2 = ((k)paramb).AOC;
        if (localObject2 != null)
        {
          localObject1 = this.Fst;
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(Long.valueOf(((cc)((Iterator)localObject3).next()).bZA()));
          }
          ((HashSet)localObject1).addAll((Collection)localObject2);
        }
      }
      localObject1 = ((k)paramb).AOB;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (g)((Iterator)localObject3).next();
          localObject4 = ((g)localObject2).AOo;
          if (localObject4 != null)
          {
            if (((l)localObject4).agOx)
            {
              localObject5 = this.Auc;
              l1 = ((g)localObject2).AOm.bZA();
              l2 = paramb.ANT;
              if (!(((g)localObject2).AOm instanceof BaseFinderFeed)) {
                break label1833;
              }
              localObject1 = ((BaseFinderFeed)((g)localObject2).AOm).feedObject;
              label1731:
              if (!(((g)localObject2).AOm instanceof ca)) {
                break label1839;
              }
            }
            label1833:
            label1839:
            for (localObject2 = ((g)localObject2).AOm;; localObject2 = null)
            {
              m.a.a((bui)localObject5, new af(l1, l2, (FinderItem)localObject1, (l)localObject4, false, null, (ca)localObject2, 48));
              ((l)localObject4).agOx = false;
              localObject1 = ((l)localObject4).agOz;
              if (localObject1 != null)
              {
                localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
                if (localObject1 != null)
                {
                  ((WxRecyclerAdapter)localObject1).onPause();
                  localObject1 = ah.aiuX;
                }
              }
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
              break;
              localObject1 = null;
              break label1731;
            }
          }
        }
        paramb = ah.aiuX;
      }
      AppMethodBeat.o(331303);
      return;
    }
    int i;
    label1931:
    label1966:
    label1991:
    label3144:
    label3671:
    label3677:
    label3940:
    if ((paramb instanceof a.a))
    {
      localObject3 = null;
      localObject5 = null;
      localObject4 = null;
      localObject2 = null;
      localObject6 = null;
      i = ((a.a)paramb).type;
      localObject1 = a.a.ANi;
      if (i == a.a.dYl())
      {
        localObject1 = this.Fsr;
        if (localObject1 != null) {
          if (((af)localObject1).feedId == ((a.a)paramb).feedId)
          {
            i = 1;
            if (i == 0) {
              break label2075;
            }
            if (localObject1 == null) {
              break label2081;
            }
            ((af)localObject1).sve += 1;
            i = ((af)localObject1).FsR;
            ((af)localObject1).FsR = (i + 1);
            localObject2 = localObject6;
            localObject1 = z.FrZ;
            localObject1 = z.pH(((a.a)paramb).feedId);
            if (localObject1 != null) {
              break label2165;
            }
            localObject3 = null;
            localObject1 = localObject2;
            if (localObject3 == null)
            {
              Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.SHARE_TO_SNS mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
              paramb = ah.aiuX;
              localObject1 = localObject2;
            }
          }
        }
      }
      label2165:
      label2423:
      label3071:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              if (localObject1 != null)
              {
                af.e((af)localObject1);
                paramb = af.FsA;
                paramb = af.a.a((af)localObject1, this.Auc);
                this.Fsn.add(paramb);
              }
              AppMethodBeat.o(331303);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label1931;
              l1 = ((a.a)paramb).feedId;
              l2 = paramb.ANT;
              localObject1 = z.FrZ;
              localObject2 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
              ((af)localObject2).sve += 1;
              ((af)localObject2).FsR += 1;
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
              break label1966;
              l1 = ((ca)localObject1).eDF();
              localObject3 = this.Auc;
              localObject4 = m.c.FpF;
              m.a.a((bui)localObject3, l1, 1, m.c.eMy(), 0L, (ca)localObject1, 16);
              localObject3 = this.Auc;
              localObject4 = com.tencent.mm.model.z.bAM();
              s.s(localObject4, "getUsernameFromUserInfo()");
              localObject4 = m.a.a(10, new String[] { "1", localObject4 }).toString();
              s.s(localObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
              m.a.a((bui)localObject3, l1, 10, (String)localObject4, 0L, (ca)localObject1, 16);
              localObject1 = ah.aiuX;
              localObject3 = ah.aiuX;
              break label1991;
              localObject1 = a.a.ANi;
              if (i == a.a.dYk())
              {
                localObject1 = this.Fsr;
                if (localObject1 != null) {
                  if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                  {
                    i = 1;
                    if (i == 0) {
                      break label2417;
                    }
                    if (localObject1 == null) {
                      break label2423;
                    }
                    i = ((af)localObject1).sve;
                    ((af)localObject1).sve = (i + 1);
                    localObject2 = localObject5;
                    localObject1 = z.FrZ;
                    localObject1 = z.pH(((a.a)paramb).feedId);
                    if (localObject1 != null) {
                      break label2495;
                    }
                  }
                }
                for (localObject3 = null;; localObject3 = ah.aiuX)
                {
                  localObject1 = localObject2;
                  if (localObject3 != null) {
                    break;
                  }
                  Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.SHARE_TO_CHAT mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
                  paramb = ah.aiuX;
                  localObject1 = localObject2;
                  break;
                  i = 0;
                  break label2318;
                  localObject1 = null;
                  break label2322;
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.ANT;
                  localObject1 = z.FrZ;
                  localObject2 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                  ((af)localObject2).sve += 1;
                  localObject1 = ah.aiuX;
                  localObject1 = ah.aiuX;
                  break label2345;
                  l1 = ((ca)localObject1).eDF();
                  localObject3 = this.Auc;
                  localObject4 = m.c.FpF;
                  m.a.a((bui)localObject3, l1, 1, m.c.eMy(), 0L, (ca)localObject1, 16);
                  localObject3 = this.Auc;
                  localObject4 = com.tencent.mm.model.z.bAM();
                  s.s(localObject4, "getUsernameFromUserInfo()");
                  localObject4 = m.a.a(10, new String[] { "2", localObject4 }).toString();
                  s.s(localObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  m.a.a((bui)localObject3, l1, 10, (String)localObject4, 0L, (ca)localObject1, 16);
                  localObject1 = ah.aiuX;
                }
              }
              localObject1 = a.a.ANi;
              if (i == a.a.dYn())
              {
                localObject1 = z.FrZ;
                localObject1 = z.pH(((a.a)paramb).feedId);
                if (localObject1 == null) {}
                for (localObject2 = null;; localObject2 = ah.aiuX)
                {
                  localObject1 = localObject3;
                  if (localObject2 != null) {
                    break;
                  }
                  Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.CANCEL_SHARE_TO_SNS mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
                  paramb = ah.aiuX;
                  localObject1 = localObject3;
                  break;
                  l1 = ((ca)localObject1).eDF();
                  localObject2 = this.Auc;
                  localObject4 = com.tencent.mm.model.z.bAM();
                  s.s(localObject4, "getUsernameFromUserInfo()");
                  localObject4 = m.a.a(13, new String[] { "1", localObject4 }).toString();
                  s.s(localObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  m.a.a((bui)localObject2, l1, 13, (String)localObject4, 0L, (ca)localObject1, 16);
                  localObject1 = ah.aiuX;
                }
              }
              localObject1 = a.a.ANi;
              if (i == a.a.dYm())
              {
                localObject1 = z.FrZ;
                localObject1 = z.pH(((a.a)paramb).feedId);
                if (localObject1 == null) {}
                for (localObject2 = null;; localObject2 = ah.aiuX)
                {
                  localObject1 = localObject3;
                  if (localObject2 != null) {
                    break;
                  }
                  Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.CANCEL_SHARE_TO_CHAT mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
                  paramb = ah.aiuX;
                  localObject1 = localObject3;
                  break;
                  l1 = ((ca)localObject1).eDF();
                  localObject2 = this.Auc;
                  localObject4 = com.tencent.mm.model.z.bAM();
                  s.s(localObject4, "getUsernameFromUserInfo()");
                  localObject4 = m.a.a(13, new String[] { "2", localObject4 }).toString();
                  s.s(localObject4, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  m.a.a((bui)localObject2, l1, 13, (String)localObject4, 0L, (ca)localObject1, 16);
                  localObject1 = ah.aiuX;
                }
              }
              localObject1 = a.a.ANi;
              if (i == a.a.dYs())
              {
                localObject1 = this.Fsr;
                if (localObject1 != null) {
                  if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3071;
                    }
                    if (localObject1 == null) {
                      break label3077;
                    }
                    ((af)localObject1).FsO += 1;
                    localObject1 = localObject4;
                    localObject2 = z.FrZ;
                    localObject2 = z.pH(((a.a)paramb).feedId);
                    if (localObject2 != null) {
                      break label3144;
                    }
                  }
                }
                for (localObject2 = null;; localObject2 = ah.aiuX)
                {
                  if (localObject2 == null)
                  {
                    Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.CLICK_AVATAR mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
                    paramb = ah.aiuX;
                  }
                  paramb = ah.aiuX;
                  break;
                  i = 0;
                  break label2978;
                  localObject1 = null;
                  break label2982;
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.ANT;
                  localObject1 = z.FrZ;
                  localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                  ((af)localObject1).FsO += 1;
                  localObject2 = ah.aiuX;
                  break label3003;
                  l1 = ((ca)localObject2).eDF();
                  localObject3 = this.Auc;
                  localObject4 = m.c.FpF;
                  m.a.a((bui)localObject3, l1, 7, m.c.eMy(), 0L, (ca)localObject2, 16);
                  localObject2 = ah.aiuX;
                }
              }
              localObject1 = a.a.ANi;
              if (i == a.a.dYt())
              {
                localObject1 = this.Fsr;
                if (localObject1 != null) {
                  if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3324;
                    }
                    if (localObject1 == null) {
                      break label3330;
                    }
                    ((af)localObject1).FsP += 1;
                    localObject1 = localObject2;
                    localObject2 = z.FrZ;
                    localObject2 = z.pH(((a.a)paramb).feedId);
                    if (localObject2 != null) {
                      break label3397;
                    }
                  }
                }
                for (localObject2 = null;; localObject2 = ah.aiuX)
                {
                  if (localObject2 == null)
                  {
                    Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.FAV mega video is null id = ", Long.valueOf(((a.a)paramb).feedId)));
                    paramb = ah.aiuX;
                  }
                  paramb = ah.aiuX;
                  break;
                  i = 0;
                  break label3231;
                  localObject1 = null;
                  break label3235;
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.ANT;
                  localObject1 = z.FrZ;
                  localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                  ((af)localObject1).FsP += 1;
                  localObject2 = ah.aiuX;
                  break label3256;
                  l1 = ((ca)localObject2).eDF();
                  localObject3 = this.Auc;
                  localObject4 = m.c.FpF;
                  m.a.a((bui)localObject3, l1, 16, m.c.eMy(), 0L, (ca)localObject2, 16);
                  localObject2 = ah.aiuX;
                }
              }
              localObject1 = a.a.ANi;
              if (i == a.a.dYv())
              {
                localObject1 = this.Fsr;
                if (localObject1 != null) {
                  if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3519;
                    }
                  }
                }
                for (;;)
                {
                  if (localObject1 == null) {
                    break label3525;
                  }
                  i = ((af)localObject1).FsZ;
                  ((af)localObject1).FsZ = (i + 1);
                  localObject1 = localObject3;
                  break;
                  i = 0;
                  break label3484;
                  localObject1 = null;
                }
                l1 = ((a.a)paramb).feedId;
                l2 = paramb.ANT;
                localObject1 = z.FrZ;
                localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                ((af)localObject1).FsZ += 1;
                paramb = ah.aiuX;
                paramb = ah.aiuX;
              }
              else
              {
                localObject1 = a.a.ANi;
                if (i == a.a.dYo())
                {
                  localObject1 = this.Fsr;
                  if (localObject1 != null) {
                    if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                    {
                      i = 1;
                      if (i == 0) {
                        break label3671;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label3677;
                    }
                    i = ((af)localObject1).FsQ;
                    ((af)localObject1).FsQ = (i + 1);
                    localObject1 = localObject3;
                    break;
                    i = 0;
                    break label3636;
                    localObject1 = null;
                  }
                  l1 = ((a.a)paramb).feedId;
                  l2 = paramb.ANT;
                  localObject1 = z.FrZ;
                  localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                  ((af)localObject1).FsQ += 1;
                  paramb = ah.aiuX;
                  paramb = ah.aiuX;
                }
                else
                {
                  localObject1 = a.a.ANi;
                  if (i == a.a.dYw())
                  {
                    localObject1 = this.Fsr;
                    if (localObject1 != null) {
                      if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3823;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject1 == null) {
                        break label3829;
                      }
                      i = ((af)localObject1).FsT;
                      ((af)localObject1).FsT = (i + 1);
                      localObject1 = localObject3;
                      break;
                      i = 0;
                      break label3788;
                      localObject1 = null;
                    }
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.ANT;
                    localObject1 = z.FrZ;
                    localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                    ((af)localObject1).FsT += 1;
                    paramb = ah.aiuX;
                    paramb = ah.aiuX;
                  }
                  else
                  {
                    localObject1 = a.a.ANi;
                    if (i == a.a.dYx())
                    {
                      localObject1 = this.Fsr;
                      if (localObject1 != null) {
                        if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3975;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label3981;
                        }
                        i = ((af)localObject1).FsS;
                        ((af)localObject1).FsS = (i + 1);
                        localObject1 = localObject3;
                        break;
                        i = 0;
                        break label3940;
                        localObject1 = null;
                      }
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.ANT;
                      localObject1 = z.FrZ;
                      localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                      ((af)localObject1).FsS += 1;
                      paramb = ah.aiuX;
                      paramb = ah.aiuX;
                    }
                    else
                    {
                      localObject1 = a.a.ANi;
                      if (i == a.a.dYy())
                      {
                        localObject1 = this.Fsr;
                        if (localObject1 != null) {
                          if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4127;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4133;
                          }
                          i = ((af)localObject1).FsU;
                          ((af)localObject1).FsU = (i + 1);
                          localObject1 = localObject3;
                          break;
                          i = 0;
                          break label4092;
                          localObject1 = null;
                        }
                        l1 = ((a.a)paramb).feedId;
                        l2 = paramb.ANT;
                        localObject1 = z.FrZ;
                        localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                        ((af)localObject1).FsU += 1;
                        paramb = ah.aiuX;
                        paramb = ah.aiuX;
                      }
                      else
                      {
                        localObject1 = a.a.ANi;
                        if (i == a.a.dYz())
                        {
                          localObject1 = this.Fsr;
                          if (localObject1 != null) {
                            if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                            {
                              i = 1;
                              if (i == 0) {
                                break label4279;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4285;
                            }
                            i = ((af)localObject1).FsX;
                            ((af)localObject1).FsX = (i + 1);
                            localObject1 = localObject3;
                            break;
                            i = 0;
                            break label4244;
                            localObject1 = null;
                          }
                          l1 = ((a.a)paramb).feedId;
                          l2 = paramb.ANT;
                          localObject1 = z.FrZ;
                          localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                          ((af)localObject1).FsX += 1;
                          paramb = ah.aiuX;
                          paramb = ah.aiuX;
                        }
                        else
                        {
                          localObject1 = a.a.ANi;
                          if (i != a.a.dYA()) {
                            break label4507;
                          }
                          localObject1 = this.Fsr;
                          if (localObject1 != null) {
                            if (((af)localObject1).feedId == ((a.a)paramb).feedId)
                            {
                              i = 1;
                              if (i == 0) {
                                break label4431;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4437;
                            }
                            i = ((af)localObject1).FsY;
                            ((af)localObject1).FsY = (i + 1);
                            localObject1 = localObject3;
                            break;
                            i = 0;
                            break label4396;
                            localObject1 = null;
                          }
                          l1 = ((a.a)paramb).feedId;
                          l2 = paramb.ANT;
                          localObject1 = z.FrZ;
                          localObject1 = new af(l1, l2, null, null, false, null, z.pH(((a.a)paramb).feedId), 56);
                          ((af)localObject1).FsY += 1;
                          paramb = ah.aiuX;
                          paramb = ah.aiuX;
                        }
                      }
                    }
                  }
                }
              }
            }
            paramb = a.a.ANi;
            localObject1 = localObject3;
          } while (i == a.a.dYB());
          paramb = a.a.ANi;
          localObject1 = localObject3;
        } while (i == a.a.dYC());
        paramb = a.a.ANi;
        localObject1 = localObject3;
      } while (i == a.a.dYD());
      label2417:
      label3324:
      label4092:
      AppMethodBeat.o(331303);
      label3823:
      label3829:
      return;
    }
    label2075:
    label2081:
    label2345:
    label2495:
    label3397:
    label3525:
    label3788:
    label4431:
    label4437:
    if ((paramb instanceof c.a)) {
      switch (((c.a)paramb).type)
      {
      }
    }
    label2318:
    label2322:
    label2978:
    label2982:
    label3003:
    label3519:
    label5577:
    label5580:
    for (;;)
    {
      AppMethodBeat.o(331303);
      return;
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label4725;
        }
        i = 1;
        if (i == 0) {
          break label4730;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((af)localObject1).Ftd = paramb.ANT;
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        label4725:
        i = 0;
        break;
        label4730:
        localObject1 = null;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label4814;
        }
        i = 1;
        if (i == 0) {
          break label4819;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((af)localObject1).Ftd != 0L) {
            ((af)localObject1).Ftc = (paramb.ANT - ((af)localObject1).Ftd);
          }
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        label4814:
        i = 0;
        break;
        label4819:
        localObject1 = null;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label4887;
        }
        i = 1;
        if (i == 0) {
          break label4892;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((af)localObject1).Ftb = paramb.ANT;
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        i = 0;
        break;
        localObject1 = null;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label4977;
        }
        i = 1;
        if (i == 0) {
          break label4982;
        }
      }
      label4977:
      label4982:
      for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
      {
        if (paramb != null)
        {
          paramb.FsH[paramb.FsI] += 1;
          i = paramb.FsJ;
          paramb.FsJ = (i + 1);
        }
        AppMethodBeat.o(331303);
        return;
        i = 0;
        break;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label5136;
        }
        i = 1;
        if (i == 0) {
          break label5141;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((af)localObject1).Fth.add(Integer.valueOf(((c.a)paramb).offset));
          i = (int)(100.0F * ((c.a)paramb).offset / ((c.a)paramb).total);
          if (i > localObject1.FsG[localObject1.FsI]) {
            ((af)localObject1).FsG[localObject1.FsI] = i;
          }
          if (i > ((af)localObject1).FsM)
          {
            ((af)localObject1).FsL = ((c.a)paramb).offset;
            ((af)localObject1).FsM = i;
          }
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        i = 0;
        break;
        localObject1 = null;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label5237;
        }
        i = 1;
        if (i == 0) {
          break label5242;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((af)localObject1).Ftb != 0L)
          {
            ((af)localObject1).Fta += paramb.ANT - ((af)localObject1).Ftb;
            ((af)localObject1).Ftb = 0L;
          }
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        label5237:
        i = 0;
        break;
        label5242:
        localObject1 = null;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId != ((c.a)paramb).feedId) {
          break label5383;
        }
        i = 1;
        if (i == 0) {
          break label5388;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((af)localObject1).Ftf = 1;
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        if (((c.a)paramb).ANJ != null)
        {
          localObject1 = z.FrZ;
          localObject1 = z.pH(((c.a)paramb).feedId);
          if (localObject1 != null) {
            break label5394;
          }
          localObject1 = null;
          if (localObject1 == null)
          {
            Log.i("MegaVideoFeedFlowReporter", s.X("ActionEvent.VIDEO_SEEK mega video is null id = ", Long.valueOf(((c.a)paramb).feedId)));
            paramb = ah.aiuX;
          }
          paramb = ah.aiuX;
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331303);
        return;
        i = 0;
        break;
        localObject1 = null;
      }
      l1 = ((ca)localObject1).eDF();
      if (((c.a)paramb).ANL > ((c.a)paramb).hKX) {
        m.a.a(this.Auc, l1, 15, String.valueOf(m.a.a(15, new String[] { "-1" })), 0L, (ca)localObject1, 16);
      }
      for (;;)
      {
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        break;
        if (((c.a)paramb).ANL < ((c.a)paramb).hKX) {
          m.a.a(this.Auc, l1, 15, String.valueOf(m.a.a(15, new String[] { "1" })), 0L, (ca)localObject1, 16);
        }
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        if (((af)localObject1).feedId == ((c.a)paramb).feedId)
        {
          i = 1;
          if (i == 0) {
            break label5577;
          }
        }
        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
        {
          if (paramb == null) {
            break label5580;
          }
          paramb.Fte = 1;
          paramb = ah.aiuX;
          paramb = ah.aiuX;
          break;
          i = 0;
          break label5545;
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331215);
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(331215);
      return true;
    }
    if ((paramb instanceof ay.b))
    {
      AppMethodBeat.o(331215);
      return true;
    }
    if ((paramb instanceof k))
    {
      AppMethodBeat.o(331215);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(331215);
      return true;
    }
    AppMethodBeat.o(331215);
    return false;
  }
  
  public final LinkedList<fhp> eMx()
  {
    AppMethodBeat.i(331308);
    if (this.Fsn.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.Fsn);
      this.Fsn.clear();
      ai localai = ai.FtE;
      ai.a((List)localLinkedList, this.Auc, 0);
      AppMethodBeat.o(331308);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(331308);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(331320);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(331320);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(331223);
    onExit();
    super.onRelease();
    AppMethodBeat.o(331223);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(331316);
    super.onVisible();
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)dUP());
    if (localObject != null)
    {
      localObject = ((as)localObject).GTv;
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
      }
    }
    AppMethodBeat.o(331316);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(aw paramaw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aw
 * JD-Core Version:    0.7.0.1
 */
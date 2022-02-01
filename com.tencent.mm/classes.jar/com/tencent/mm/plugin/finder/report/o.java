package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.convert.ap;
import com.tencent.mm.plugin.finder.convert.ap.a;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.a.a.a;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.ae;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "", "dailyTopicMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectHotTopic;", "extActionValueList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "feedReportWatcher", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastVisibleFeedMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Lcom/tencent/mm/protocal/protobuf/Stats;", "addActionValue", "", "actionValue", "afterConversationUpdate", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "checkEmptyToHotTabExpose", "messageType", "index", "checkRedDotExpose", "getDailyTopic", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "handleExtStatsRecord", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onDailyShow", "singleFeedRecord", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "optExtStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "feedActionValue", "reportCenterRecord", "record", "stats", "reportDailyShow", "dailyTopic", "reportExpose", "across", "reportExtStatsInCenterSwitch", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExStatsReport", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "sendExtStatsReport", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public class o
  extends e
{
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private static p vfM;
  public static final a vfN;
  private ConcurrentLinkedQueue<ecq> vfE;
  private ConcurrentLinkedQueue<String> vfF;
  private final b vfG;
  private final int vfH;
  p vfI;
  HashSet<Long> vfJ;
  public HashMap<Long, p> vfK;
  private ConcurrentHashMap<Long, azw> vfL;
  
  static
  {
    AppMethodBeat.i(250737);
    vfN = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    AppMethodBeat.o(250737);
  }
  
  public o(MMFragmentActivity paramMMFragmentActivity, bbn parambbn)
  {
    super(paramMMFragmentActivity, parambbn);
    AppMethodBeat.i(250736);
    this.vfE = new ConcurrentLinkedQueue();
    this.vfF = new ConcurrentLinkedQueue();
    paramMMFragmentActivity = new b();
    paramMMFragmentActivity.dnC();
    this.vfG = paramMMFragmentActivity;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.vfH = ((Number)com.tencent.mm.plugin.finder.storage.c.dvI().value()).intValue();
    this.vfJ = new HashSet();
    this.vfK = new HashMap();
    this.vfL = new ConcurrentHashMap();
    AppMethodBeat.o(250736);
  }
  
  private final ecq a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(250727);
    p.c(paramp);
    Object localObject2;
    if (!b.a(this.vfG))
    {
      localObject1 = new StringBuilder();
      if (paramp != null)
      {
        localObject2 = b.dl(paramp);
        if (paramp.dUy < 0L) {
          ((StringBuilder)localObject1).append("stayTime :" + paramp.dUy + " startTime:" + paramp.startTime + " endTime:" + paramp.endTime + "\n obj:" + (String)localObject2);
        }
        if (paramp.vgm < 0L) {
          ((StringBuilder)localObject1).append("realPlayTime :" + paramp.vgm + " realPlayTimestamp:" + paramp.vgn + " endTime:" + paramp.endTime + "\n obj:" + (String)localObject2);
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject1).toString())) {
        Log.e("FeedReportWatcher", "vertify error:\n ".concat(String.valueOf(localObject1)));
      }
    }
    Object localObject3 = paramp.tHo;
    long l1;
    Object localObject4;
    Object localObject5;
    if (localObject3 != null)
    {
      localObject1 = ((FinderItem)localObject3).getFeedObject();
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((FinderObject)localObject1).id);
        if (localObject1 != null)
        {
          l1 = ((Number)localObject1).longValue();
          if (!this.vfL.containsKey(Long.valueOf(l1))) {
            break label682;
          }
          localObject2 = (azw)this.vfL.get(Long.valueOf(l1));
          localObject4 = TAG;
          localObject5 = new StringBuilder("get from cache: ");
          if (localObject2 == null) {
            break label676;
          }
          localObject1 = ((azw)localObject2).riB;
          label318:
          Log.i((String)localObject4, (String)localObject1);
          localObject1 = localObject2;
          if ((localObject3 != null) && (localObject1 != null))
          {
            if (((azw)localObject1).LJO <= 0) {
              break label771;
            }
            i = 1;
            label357:
            localObject2 = k.vfA;
            l1 = ((FinderItem)localObject3).getFeedObject().id;
            long l2 = ((azw)localObject1).twp;
            localObject2 = ((azw)localObject1).riB;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            k.a(l1, 1L, l2, (String)localObject1, i, this.ttO.tCE);
          }
        }
        localObject1 = p.vgC;
        localObject2 = p.a.a(paramp, this.ttO);
        if (paramp.tHo == null) {
          break label776;
        }
        e.a.a(this.ttO, paramp.feedId, 14, String.valueOf(paramp.endTime - paramp.startTime), 0L, null, 48);
        label470:
        e.a.a(this.ttO, paramp, 2);
        if (!paramBoolean) {
          break label1187;
        }
        localObject1 = paramp.tHo;
        if (localObject1 == null) {
          break label852;
        }
        localObject4 = ((FinderItem)localObject1).getFoldedLayout();
        if ((localObject4 == null) || (((ard)localObject4).gAZ <= 0)) {
          break label852;
        }
        localObject1 = paramp.tIw;
        if (localObject1 == null) {
          break label788;
        }
        localObject1 = ((i)localObject1).Rrh;
      }
    }
    label532:
    Object localObject6;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = paramp.tIw;
        if (localObject1 != null)
        {
          localObject3 = new LongSparseArray();
          localObject4 = ((ard)localObject4).LCW;
          kotlin.g.b.p.g(localObject4, "it.objects");
          localObject4 = ((Iterable)localObject4).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((Iterator)localObject4).next();
              if (i < 0) {
                kotlin.a.j.hxH();
              }
              localObject5 = (FinderObject)localObject5;
              if (i <= 2)
              {
                localObject6 = new com.tencent.mm.view.recyclerview.k((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject5));
                ((com.tencent.mm.view.recyclerview.k)localObject6).tIv = i;
                ((LongSparseArray)localObject3).put(((FinderObject)localObject5).id, localObject6);
              }
              i += 1;
              continue;
              localObject1 = null;
              break;
              label676:
              localObject1 = null;
              break label318;
              label682:
              localObject2 = h((FinderItem)localObject3);
              if (localObject2 != null) {
                ((Map)this.vfL).put(Long.valueOf(l1), localObject2);
              }
              localObject4 = TAG;
              localObject5 = new StringBuilder("get from feed update map: ");
              if (localObject2 != null) {}
              for (localObject1 = ((azw)localObject2).riB;; localObject1 = null)
              {
                Log.i((String)localObject4, (String)localObject1);
                localObject1 = localObject2;
                break;
              }
              label771:
              i = 0;
              break label357;
              label776:
              Log.i(TAG, "local feed ignore");
              break label470;
              label788:
              localObject1 = null;
              break label532;
            }
          }
          ((i)localObject1).Rrh = ((LongSparseArray)localObject3);
        }
      }
    }
    e.a.a(this.ttO, paramp);
    Object localObject1 = paramp.tIw;
    if (localObject1 != null)
    {
      localObject1 = ((i)localObject1).Rri;
      if (localObject1 != null)
      {
        localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((WxRecyclerAdapter)localObject1).onPause();
        }
      }
    }
    label852:
    localObject1 = paramp.tHo;
    label870:
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getLongVideoMediaList();
      if ((!Util.isNullOrNil((List)localObject1)) && (this.vfH == 1)) {
        com.tencent.mm.plugin.report.service.h.CyF.a(21346, new Object[] { d.zs(paramp.feedId), Integer.valueOf(this.ttO.tCE), this.ttO.sessionId, this.ttO.sGQ, this.ttO.sGE });
      }
      localObject1 = paramp.vgy;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = (BaseFinderFeed)localObject1;
        if (localObject3 == null) {
          break label1269;
        }
        localObject1 = ((BaseFinderFeed)localObject3).attachFavInfo;
        label993:
        if (localObject1 != null)
        {
          localObject1 = k.vfA;
          l1 = ((BaseFinderFeed)localObject3).lT();
          j = this.ttO.tCE;
          localObject1 = this.ttO.sGE;
          localObject4 = this.ttO.sGQ;
          localObject5 = this.ttO.sessionId;
          localObject6 = k.vfA;
          localObject6 = k.G(((BaseFinderFeed)localObject3).lT(), this.ttO.tCE);
          localObject3 = ((BaseFinderFeed)localObject3).attachFavInfo;
          if ((localObject3 == null) || (((com.tencent.mm.plugin.finder.storage.k)localObject3).vDG != true)) {
            break label1275;
          }
        }
      }
    }
    label1187:
    label1269:
    label1275:
    for (int i = 1;; i = 2)
    {
      k.a(l1, 2, j, (String)localObject1, (String)localObject4, (String)localObject5, (String)localObject6, i);
      localObject1 = paramp.vgy;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = y.vXH;
        if (y.C(((BaseFinderFeed)localObject1).feedObject))
        {
          localObject3 = k.vfA;
          k.a(this.ttO, paramp.feedId, Integer.valueOf(((BaseFinderFeed)localObject1).feedObject.getFeedObject().follow_feed_count));
        }
      }
      AppMethodBeat.o(250727);
      return localObject2;
      localObject1 = paramp.tIw;
      if ((localObject1 == null) || ((!((i)localObject1).Rrf) && (!((i)localObject1).Rrg))) {
        break;
      }
      e.a.a(this.ttO, paramp);
      ((i)localObject1).Rrg = false;
      localObject1 = ((i)localObject1).Rri;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        break;
      }
      ((WxRecyclerAdapter)localObject1).onPause();
      break;
      localObject1 = null;
      break label870;
      localObject1 = null;
      break label993;
    }
  }
  
  private final void a(p paramp, ecq paramecq)
  {
    AppMethodBeat.i(250725);
    if (paramp.vfV > 0) {
      e.a.a(this.ttO, paramp.feedId, 5, String.valueOf(paramp.vfV), paramp.uOV, null, 32);
    }
    long l1 = paramp.endTime;
    long l2 = paramp.startTime;
    e.a.a(this.ttO, paramp.feedId, 2, String.valueOf(l1 - l2), paramp.uOV, null, 32);
    if (paramp.vfY > 0) {
      e.a.a(this.ttO, paramp.feedId, 11, String.valueOf(paramp.vfY), paramp.uOV, null, 32);
    }
    Object localObject = this.ttO;
    l1 = paramp.feedId;
    paramecq = paramecq.NcM;
    if (paramecq != null) {}
    for (paramecq = Long.valueOf(paramecq.KQT);; paramecq = "")
    {
      e.a.a((bbn)localObject, l1, 3, String.valueOf(paramecq), paramp.uOV, null, 32);
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
      l1 = paramp.feedId;
      localObject = ((JSONObject)localObject).toString();
      kotlin.g.b.p.g(localObject, "playInfoObj.toString()");
      e.a.a(paramecq, l1, 17, n.j((String)localObject, ",", ";", false), paramp.uOV, null, 32);
      paramecq = c.vdc;
      paramecq = c.EY(paramp.feedId);
      if (!Util.isNullOrNil(paramecq)) {
        e.a.a(this.ttO, paramp.feedId, 18, paramecq, paramp.uOV, null, 32);
      }
      e.a.a(this.ttO, paramp, 1);
      dog();
      AppMethodBeat.o(250725);
      return;
    }
  }
  
  private final void auM(String paramString)
  {
    AppMethodBeat.i(250734);
    this.vfF.add(paramString);
    AppMethodBeat.o(250734);
  }
  
  private final void dog()
  {
    int j = 0;
    AppMethodBeat.i(250733);
    Object localObject1 = this.vfI;
    if (localObject1 != null)
    {
      if (((p)localObject1).vgr > 0) {
        auM(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(13)))));
      }
      if (((p)localObject1).vgk > 0) {
        auM(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(14)))));
      }
    }
    localObject1 = this.vdP;
    if (((e.b)localObject1).vdV) {
      auM(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(11)))));
    }
    if (((e.b)localObject1).vdU) {
      auM(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(12)))));
    }
    localObject1 = this.vdP;
    ((e.b)localObject1).vdU = false;
    ((e.b)localObject1).vdV = false;
    Object localObject2 = new LinkedList();
    if (this.vfI != null)
    {
      Iterator localIterator = ((Iterable)this.vfF).iterator();
      label340:
      label367:
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        Log.i(TAG, "reportExtStatsInCenterSwitch action: ".concat(String.valueOf(localObject3)));
        kotlin.g.b.p.g(localObject3, "it");
        if (!Util.isNullOrNil((String)localObject3))
        {
          p localp = this.vfI;
          if (localp != null)
          {
            localObject1 = new alc();
            ((alc)localObject1).hFK = localp.feedId;
            Object localObject4 = localp.tHo;
            if (localObject4 != null) {
              ((alc)localObject1).finderUsername = ((FinderItem)localObject4).getUserName();
            }
            localObject4 = k.vfA;
            ((alc)localObject1).sessionBuffer = k.G(localp.feedId, this.ttO.tCE);
            ((alc)localObject1).Lub = ((String)localObject3);
            ((alc)localObject1).videoDuration = localp.videoDuration;
            localObject3 = localp.tHo;
            if (localObject3 != null)
            {
              i = ((FinderItem)localObject3).getMediaType();
              ((alc)localObject1).mediaType = i;
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label367;
          }
          ((LinkedList)localObject2).add(localObject1);
          break;
          i = 0;
          break label340;
          localObject1 = null;
        }
      }
      this.vfF.clear();
      int i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        localObject1 = this.ttO;
        localObject2 = (List)localObject2;
        kotlin.g.b.p.h(localObject2, "extStats");
        Log.i(TAG, "sendExtStatsReport " + ((List)localObject2).size());
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new aw((bbn)localObject1, (List)localObject2));
      }
    }
    AppMethodBeat.o(250733);
  }
  
  private final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250729);
    k localk = k.vfA;
    k.a(1, paramInt1, paramInt2, this.ttO);
    AppMethodBeat.o(250729);
  }
  
  private static azw h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(250735);
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.getFeedObject().hotTopics;
      if (paramFinderItem != null) {}
      for (paramFinderItem = paramFinderItem.Gbc; paramFinderItem != null; paramFinderItem = null)
      {
        paramFinderItem = paramFinderItem.iterator();
        azw localazw;
        do
        {
          if (!paramFinderItem.hasNext()) {
            break;
          }
          localazw = (azw)paramFinderItem.next();
        } while ((localazw == null) || (localazw.LJN != 5));
        AppMethodBeat.o(250735);
        return localazw;
      }
    }
    AppMethodBeat.o(250735);
    return null;
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(250724);
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    d.c(FinderReporterUIC.dIB(), (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(250724);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(250726);
    kotlin.g.b.p.h(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label384:
    label415:
    Object localObject4;
    long l1;
    long l2;
    label592:
    label599:
    Object localObject5;
    Object localObject6;
    label1486:
    int m;
    label1796:
    int n;
    int i1;
    int i2;
    int k;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!this.visible)
      {
        Log.i(TAG, this.ttO.tCE + " not visible");
        AppMethodBeat.o(250726);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
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
            ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next()).tIu);
          }
          localObject1 = (List)localObject1;
          as.a((List)localObject1, this.ttO);
        }
      }
      else
      {
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).tCi == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptb == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIy) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptc == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIA)) {
          break label1486;
        }
        localObject2 = new LinkedList();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).tCi == ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC) {
          break label599;
        }
        localObject1 = this.vfI;
        if (localObject1 != null)
        {
          ((p)localObject1).a(this.vdR);
          localObject3 = p.vgC;
          localObject3 = p.a.a((p)localObject1, this.ttO);
          ((LinkedList)localObject2).add(localObject3);
          a((p)localObject1, (ecq)localObject3);
        }
        switch (((com.tencent.mm.plugin.finder.event.base.j)paramb).type)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          localObject1 = x.SXb;
          localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
          if (localObject1 == null) {
            break label592;
          }
          localObject3 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
          } while (((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIu.lT() != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIC);
          l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIu.lT();
          l2 = paramb.tHW;
          if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIu instanceof BaseFinderFeed)) {
            break;
          }
        }
      }
      for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIu).feedObject;; localObject1 = null)
      {
        localObject1 = new p(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIw, true, this.vdR, null, 64);
        ((p)localObject1).vfP = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).tIv;
        localObject4 = x.SXb;
        this.vfI = ((p)localObject1);
        break label415;
        localObject1 = null;
        break;
        auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(1)))));
        break label384;
      }
      localObject1 = x.SXb;
      vfM = this.vfI;
      localObject4 = new HashSet();
      localObject3 = new HashSet();
      ((HashSet)localObject4).addAll((Collection)this.vfK.keySet());
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
          ((HashSet)localObject4).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT()));
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT()));
        }
        localObject1 = x.SXb;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIH;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject5).next();
          if (!((HashSet)localObject4).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu.lT())))
          {
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu.lT();
            l2 = paramb.tHW;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu instanceof BaseFinderFeed)) {}
            for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu).feedObject;; localObject1 = null)
            {
              localObject1 = new p(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIw, false, null, null, 112);
              ((p)localObject1).vgy = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu;
              this.vfG.a((p)localObject1);
              this.vfG.a(((com.tencent.mm.plugin.finder.event.base.g)localObject6).tIu, "acrossFeedList ", (p)localObject1);
              localObject6 = a((p)localObject1, true);
              this.vfG.b((p)localObject1);
              ((LinkedList)localObject2).add(localObject6);
              localObject1 = x.SXb;
              break;
            }
          }
        }
        localObject1 = x.SXb;
      }
      localObject1 = ((Map)this.vfK).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject3).contains(((Map.Entry)localObject4).getKey()))
        {
          localObject5 = a((p)((Map.Entry)localObject4).getValue(), false);
          this.vfG.b((p)((Map.Entry)localObject4).getValue());
          ((LinkedList)localObject2).add(localObject5);
        }
      }
      localObject3 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
      if (localObject1 != null)
      {
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          localObject1 = (p)this.vfK.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT()));
          if (localObject1 != null)
          {
            ((p)localObject1).vgy = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu;
            ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT()), localObject1);
            if (localObject1 != null) {
              break;
            }
          }
          else
          {
            localObject6 = (o)this;
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT();
            l2 = paramb.tHW;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu instanceof BaseFinderFeed)) {}
            for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu).feedObject;; localObject1 = null)
            {
              localObject1 = new p(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIw, false, null, null, 112);
              ((p)localObject1).vgy = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu;
              ((p)localObject1).vfP = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIv;
              ((o)localObject6).vfG.a((p)localObject1);
              ((o)localObject6).vfG.a(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu, "lastVisibleFeedMap ", (p)localObject1);
              ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).tIu.lT()), localObject1);
              break;
            }
          }
        }
        localObject1 = x.SXb;
      }
      this.vfK = ((HashMap)localObject3);
      this.vfE.addAll((Collection)localObject2);
      if (this.vfE.size() > 20)
      {
        localObject1 = FinderReporterUIC.wzC;
        d.c(FinderReporterUIC.dIB(), (kotlin.g.a.a)new b(this));
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("waitForReportStatsList ");
      localObject4 = (Iterable)this.vfE;
      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(d.zs(((ecq)((Iterator)localObject4).next()).hFK));
      }
      Log.i((String)localObject1, (List)localObject3);
      if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).ptb != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIy) || (((com.tencent.mm.plugin.finder.event.base.j)paramb).ptc != ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIA))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tIJ;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (bo)((Iterator)localObject2).next();
              if (!this.vfJ.contains(Long.valueOf(((bo)localObject1).lT()))) {
                switch (((bo)localObject1).cxn())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.ttO.tCE == 17) || (this.ttO.tCE == 18)) {
                    gf(1, 0);
                  }
                  break;
                case 2011: 
                  if (this.ttO.tCE == 17)
                  {
                    localObject1 = ap.tEt;
                    gf(2, ap.a.Is(3));
                  }
                  else if (this.ttO.tCE == 18)
                  {
                    localObject1 = ap.tEt;
                    gf(2, ap.a.Is(1));
                  }
                  break;
                case -5: 
                  if ((this.ttO.tCE == 17) || (this.ttO.tCE == 18) || (this.ttO.tCE == 20))
                  {
                    localObject1 = FinderReporterUIC.wzC;
                    localObject1 = FinderReporterUIC.a.fH((Context)this.uLr);
                    if (localObject1 != null) {
                      if (((FinderReporterUIC)localObject1).dIs())
                      {
                        if (localObject1 == null) {
                          break label2170;
                        }
                        localObject1 = FinderReporterUIC.d((FinderReporterUIC)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).ptb > 1)) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                        kotlin.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().asX("TLWxBubble");
                        localObject1 = "";
                        if (localObject3 != null)
                        {
                          localObject1 = com.tencent.mm.kernel.g.aAh();
                          kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
                          m = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Olg, 0);
                          localObject1 = com.tencent.mm.kernel.g.aAh();
                          kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
                          n = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Olh, 0);
                          localObject1 = com.tencent.mm.kernel.g.aAh();
                          kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
                          i1 = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Oli, 0);
                          localObject1 = com.tencent.mm.kernel.g.aAh();
                          kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
                          i2 = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Olj, 0);
                          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
                          if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() != 1) {
                            break label2172;
                          }
                          k = 5;
                          if (n <= 0) {
                            break label7044;
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
    label2500:
    label2643:
    label2793:
    label2805:
    label4729:
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
      label2170:
      label7034:
      for (i = j | 0x4;; i = j)
      {
        localObject1 = k.vfA;
        localObject1 = k.fp((Context)this.uLr);
        j = i;
        i = k;
        for (;;)
        {
          localObject4 = k.vfA;
          k.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject3).field_tipsId, null, 0L, this.ttO, 0, 0, 3456);
          localObject4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
          kotlin.g.b.p.g(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject4).getRedDotManager().asW("TLWxBubble");
          if ((localObject3 == null) || (localObject4 == null)) {
            break;
          }
          localObject5 = j.vft;
          j.a((String)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject3, (bdo)localObject4, 1, this.ttO, 0, 0, 96);
          break;
          localObject1 = null;
          break label1796;
          break;
          label2172:
          localObject1 = "2";
          i = 1;
          j = 1;
        }
        localObject1 = x.SXb;
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
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).tII;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next();
            localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).tIw;
            if (localObject3 != null)
            {
              if (((i)localObject3).Rrg)
              {
                localObject4 = this.ttO;
                l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).tIu.lT();
                l2 = paramb.tHW;
                if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject1).tIu instanceof BaseFinderFeed)) {
                  break label2500;
                }
              }
              for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject1).tIu).feedObject;; localObject1 = null)
              {
                e.a.a((bbn)localObject4, new p(l1, l2, (FinderItem)localObject1, (i)localObject3, false, null, null, 112));
                ((i)localObject3).Rrg = false;
                localObject1 = ((i)localObject3).Rri;
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
              }
            }
          }
          paramb = x.SXb;
          AppMethodBeat.o(250726);
          return;
        }
        AppMethodBeat.o(250726);
        return;
        if ((paramb instanceof a.a))
        {
          localObject2 = null;
          localObject1 = null;
          Object localObject7 = null;
          localObject6 = null;
          localObject5 = null;
          localObject4 = null;
          localObject3 = null;
          a.a.a locala1 = null;
          i = ((a.a)paramb).type;
          a.a.a locala2 = a.a.tHJ;
          if (i == a.a.cZT())
          {
            localObject1 = this.vfI;
            if (localObject1 != null) {
              if (((p)localObject1).feedId == ((a.a)paramb).feedId)
              {
                i = 1;
                if (i == 0) {
                  break label2793;
                }
                if (localObject1 == null) {
                  break label2805;
                }
                ((p)localObject1).msj += 1;
                i = ((p)localObject1).vgd;
                ((p)localObject1).vgd = (i + 1);
                localObject1 = locala1;
                localObject2 = this.ttO;
                l1 = ((a.a)paramb).feedId;
                localObject3 = e.c.vdX;
                e.a.a((bbn)localObject2, l1, 1, e.c.dnN(), 0L, null, 48);
                localObject2 = this.ttO;
                l1 = ((a.a)paramb).feedId;
                paramb = z.aTY();
                kotlin.g.b.p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = e.a.a(10, new String[] { "1", paramb }).toString();
                kotlin.g.b.p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                e.a.a((bbn)localObject2, l1, 10, paramb, 0L, null, 48);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              p.c((p)localObject1);
              paramb = p.vgC;
              paramb = p.a.a((p)localObject1, getContextObj());
              this.vfE.add(paramb);
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label2608;
              localObject1 = null;
              break label2608;
              l1 = ((a.a)paramb).feedId;
              l2 = paramb.tHW;
              localObject1 = k.vfA;
              localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
              ((p)localObject1).msj += 1;
              ((p)localObject1).vgd += 1;
              localObject2 = x.SXb;
              localObject2 = x.SXb;
              break label2643;
              locala1 = a.a.tHJ;
              if (i == a.a.cZS())
              {
                localObject2 = this.vfI;
                if (localObject2 != null) {
                  if (((p)localObject2).feedId == ((a.a)paramb).feedId)
                  {
                    i = 1;
                    if (i == 0) {
                      break label3113;
                    }
                  }
                }
                for (;;)
                {
                  if (localObject2 == null)
                  {
                    l1 = ((a.a)paramb).feedId;
                    l2 = paramb.tHW;
                    localObject1 = k.vfA;
                    localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                    localObject2 = x.SXb;
                  }
                  localObject2 = x.SXb;
                  localObject2 = this.ttO;
                  l1 = ((a.a)paramb).feedId;
                  localObject3 = e.c.vdX;
                  e.a.a((bbn)localObject2, l1, 1, e.c.dnN(), 0L, null, 48);
                  localObject2 = this.ttO;
                  l1 = ((a.a)paramb).feedId;
                  paramb = z.aTY();
                  kotlin.g.b.p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = e.a.a(10, new String[] { "2", paramb }).toString();
                  kotlin.g.b.p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  e.a.a((bbn)localObject2, l1, 10, paramb, 0L, null, 48);
                  break;
                  i = 0;
                  break label2932;
                  localObject2 = null;
                  continue;
                  localObject2 = null;
                }
              }
              localObject1 = a.a.tHJ;
              if (i == a.a.cZV())
              {
                localObject1 = this.ttO;
                l1 = ((a.a)paramb).feedId;
                paramb = z.aTY();
                kotlin.g.b.p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = e.a.a(13, new String[] { "1", paramb }).toString();
                kotlin.g.b.p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                e.a.a((bbn)localObject1, l1, 13, paramb, 0L, null, 48);
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = a.a.tHJ;
                if (i == a.a.cZU())
                {
                  localObject1 = this.ttO;
                  l1 = ((a.a)paramb).feedId;
                  paramb = z.aTY();
                  kotlin.g.b.p.g(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = e.a.a(13, new String[] { "2", paramb }).toString();
                  kotlin.g.b.p.g(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  e.a.a((bbn)localObject1, l1, 13, paramb, 0L, null, 48);
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1 = a.a.tHJ;
                  if (i == a.a.cZX())
                  {
                    localObject1 = this.vfI;
                    if (localObject1 != null) {
                      if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3416;
                        }
                        if (localObject1 == null) {
                          break label3428;
                        }
                        ((p)localObject1).vfZ += 1;
                        localObject1 = localObject7;
                      }
                    }
                    for (;;)
                    {
                      localObject2 = this.ttO;
                      l1 = ((a.a)paramb).feedId;
                      paramb = e.c.vdX;
                      e.a.a((bbn)localObject2, l1, 6, e.c.dnN(), 0L, null, 48);
                      paramb = x.SXb;
                      break;
                      i = 0;
                      break label3344;
                      localObject1 = null;
                      break label3348;
                      localObject1 = null;
                      break label3348;
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.tHW;
                      localObject1 = k.vfA;
                      localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                      ((p)localObject1).vfZ += 1;
                      localObject2 = x.SXb;
                    }
                  }
                  localObject1 = a.a.tHJ;
                  if (i == a.a.daa())
                  {
                    localObject1 = this.vfI;
                    if (localObject1 != null) {
                      if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                      {
                        i = 1;
                        if (i == 0) {
                          break label3688;
                        }
                        if (localObject1 == null) {
                          break label3700;
                        }
                        ((p)localObject1).vga += 1;
                        localObject2 = localObject6;
                        localObject1 = this.ttO;
                        l1 = ((a.a)paramb).feedId;
                        localObject3 = e.c.vdX;
                        e.a.a((bbn)localObject1, l1, 7, e.c.dnN(), 0L, null, 48);
                        localObject1 = x.SXb;
                        localObject3 = this.vfI;
                        localObject1 = localObject2;
                        if (localObject3 == null) {
                          continue;
                        }
                        if (((p)localObject3).feedId != ((a.a)paramb).feedId) {
                          break label3769;
                        }
                        i = 1;
                        if (i == 0) {
                          break label3774;
                        }
                      }
                    }
                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                    {
                      localObject1 = localObject2;
                      if (paramb == null) {
                        break;
                      }
                      auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(4)))));
                      paramb = x.SXb;
                      localObject1 = localObject2;
                      break;
                      i = 0;
                      break label3538;
                      localObject1 = null;
                      break label3542;
                      localObject1 = null;
                      break label3542;
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.tHW;
                      localObject1 = k.vfA;
                      localObject2 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                      ((p)localObject2).vga += 1;
                      localObject1 = x.SXb;
                      break label3563;
                      i = 0;
                      break label3637;
                    }
                  }
                  else
                  {
                    localObject1 = a.a.tHJ;
                    if (i == a.a.dab())
                    {
                      localObject1 = this.vfI;
                      if (localObject1 != null) {
                        if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                        {
                          i = 1;
                          if (i == 0) {
                            break label3892;
                          }
                          if (localObject1 == null) {
                            break label3904;
                          }
                          ((p)localObject1).vgb += 1;
                          localObject1 = localObject5;
                        }
                      }
                      for (;;)
                      {
                        localObject2 = this.ttO;
                        l1 = ((a.a)paramb).feedId;
                        paramb = e.c.vdX;
                        e.a.a((bbn)localObject2, l1, 16, e.c.dnN(), 0L, null, 48);
                        paramb = x.SXb;
                        break;
                        i = 0;
                        break label3820;
                        localObject1 = null;
                        break label3824;
                        localObject1 = null;
                        break label3824;
                        l1 = ((a.a)paramb).feedId;
                        l2 = paramb.tHW;
                        localObject1 = k.vfA;
                        localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                        ((p)localObject1).vgb += 1;
                        localObject2 = x.SXb;
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
                          if (i == 0) {
                            break label4049;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label4061;
                        }
                        i = ((p)localObject1).vgl;
                        ((p)localObject1).vgl = (i + 1);
                        localObject1 = localObject2;
                        break;
                        i = 0;
                        break label4014;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      l1 = ((a.a)paramb).feedId;
                      l2 = paramb.tHW;
                      localObject1 = k.vfA;
                      localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                      ((p)localObject1).vgl += 1;
                      paramb = x.SXb;
                      paramb = x.SXb;
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
                            if (i == 0) {
                              break label4244;
                            }
                            if (localObject1 == null) {
                              break label4256;
                            }
                            i = ((p)localObject1).vgc;
                            ((p)localObject1).vgc = (i + 1);
                            localObject1 = localObject4;
                          }
                        }
                        for (;;)
                        {
                          localObject2 = this.ttO;
                          l1 = ((a.a)paramb).feedId;
                          paramb = e.c.vdX;
                          e.a.a((bbn)localObject2, l1, 12, e.c.dnN(), 0L, null, 48);
                          break;
                          i = 0;
                          break label4174;
                          localObject1 = null;
                          break label4178;
                          localObject1 = null;
                          break label4178;
                          l1 = ((a.a)paramb).feedId;
                          l2 = paramb.tHW;
                          localObject1 = k.vfA;
                          localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                          ((p)localObject1).vgc += 1;
                          localObject2 = x.SXb;
                          localObject2 = x.SXb;
                        }
                      }
                      localObject1 = a.a.tHJ;
                      if (i == a.a.dae())
                      {
                        localObject1 = this.vfI;
                        if (localObject1 != null) {
                          if (((p)localObject1).feedId == ((a.a)paramb).feedId)
                          {
                            i = 1;
                            if (i == 0) {
                              break label4406;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4418;
                          }
                          i = ((p)localObject1).vgf;
                          ((p)localObject1).vgf = (i + 1);
                          localObject1 = localObject2;
                          break;
                          i = 0;
                          break label4371;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((a.a)paramb).feedId;
                        l2 = paramb.tHW;
                        localObject1 = k.vfA;
                        localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                        ((p)localObject1).vgf += 1;
                        paramb = x.SXb;
                        paramb = x.SXb;
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
                              if (i == 0) {
                                break label4643;
                              }
                              if (localObject1 == null) {
                                break label4655;
                              }
                              i = ((p)localObject1).vge;
                              ((p)localObject1).vge = (i + 1);
                              localObject2 = localObject3;
                              localObject3 = this.vfI;
                              localObject1 = localObject2;
                              if (localObject3 == null) {
                                continue;
                              }
                              if (((p)localObject3).feedId != ((a.a)paramb).feedId) {
                                break label4729;
                              }
                              i = 1;
                              if (i == 0) {
                                break label4734;
                              }
                            }
                          }
                          label4734:
                          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                          {
                            localObject1 = localObject2;
                            if (paramb == null) {
                              break;
                            }
                            auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(7)))));
                            paramb = x.SXb;
                            localObject1 = localObject2;
                            break;
                            i = 0;
                            break label4531;
                            localObject1 = null;
                            break label4535;
                            localObject1 = null;
                            break label4535;
                            l1 = ((a.a)paramb).feedId;
                            l2 = paramb.tHW;
                            localObject1 = k.vfA;
                            localObject2 = new p(l1, l2, k.Fc(((a.a)paramb).feedId), null, false, null, null, 120);
                            ((p)localObject2).vge += 1;
                            localObject1 = x.SXb;
                            localObject1 = x.SXb;
                            break label4558;
                            i = 0;
                            break label4591;
                          }
                        }
                        else
                        {
                          localObject1 = a.a.tHJ;
                          if (i == a.a.dag())
                          {
                            localObject1 = this.vfI;
                            if (localObject1 != null) {
                              if (((p)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4815;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4827;
                              }
                              i = ((p)localObject1).dom();
                              ((p)localObject1).Kz(i + 1);
                              localObject1 = localObject2;
                              break;
                              i = 0;
                              break label4780;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((a.a)paramb).getFeedId();
                            l2 = paramb.dao();
                            localObject1 = k.vfA;
                            localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                            ((p)localObject1).Kz(((p)localObject1).dom() + 1);
                            paramb = x.SXb;
                            paramb = x.SXb;
                          }
                          else
                          {
                            localObject1 = a.a.tHJ;
                            if (i == a.a.dah())
                            {
                              localObject1 = this.vfI;
                              if (localObject1 != null) {
                                if (((p)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                {
                                  i = 1;
                                  if (i == 0) {
                                    break label4975;
                                  }
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 == null) {
                                  break label4987;
                                }
                                i = ((p)localObject1).don();
                                ((p)localObject1).KA(i + 1);
                                localObject1 = localObject2;
                                break;
                                i = 0;
                                break label4940;
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              label4987:
                              l1 = ((a.a)paramb).getFeedId();
                              l2 = paramb.dao();
                              localObject1 = k.vfA;
                              localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                              ((p)localObject1).KA(((p)localObject1).don() + 1);
                              paramb = x.SXb;
                              paramb = x.SXb;
                            }
                            else
                            {
                              localObject1 = a.a.tHJ;
                              if (i == a.a.dai())
                              {
                                localObject1 = this.vfI;
                                if (localObject1 != null) {
                                  if (((p)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5135;
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  if (localObject1 == null) {
                                    break label5147;
                                  }
                                  i = ((p)localObject1).doo();
                                  ((p)localObject1).KB(i + 1);
                                  localObject1 = localObject2;
                                  break;
                                  i = 0;
                                  break label5100;
                                  localObject1 = null;
                                  continue;
                                  localObject1 = null;
                                }
                                l1 = ((a.a)paramb).getFeedId();
                                l2 = paramb.dao();
                                localObject1 = k.vfA;
                                localObject1 = new p(l1, l2, k.Fc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                                ((p)localObject1).KB(((p)localObject1).doo() + 1);
                                localObject2 = x.SXb;
                                localObject2 = e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(14))));
                                localObject3 = (a.a)paramb;
                                paramb = new alc();
                                paramb.hFK = ((a.a)localObject3).getFeedId();
                                localObject4 = ((a.a)localObject3).tHo;
                                if (localObject4 != null) {
                                  paramb.finderUsername = ((FinderItem)localObject4).getUserName();
                                }
                                localObject4 = k.vfA;
                                paramb.sessionBuffer = k.G(((a.a)localObject3).getFeedId(), getContextObj().tCE);
                                paramb.Lub = ((String)localObject2);
                                if (this.vfK.containsKey(Long.valueOf(paramb.hFK)))
                                {
                                  localObject2 = (p)this.vfK.get(Long.valueOf(paramb.hFK));
                                  if (localObject2 != null)
                                  {
                                    paramb.videoDuration = ((p)localObject2).videoDuration;
                                    localObject2 = ((p)localObject2).tHo;
                                    if (localObject2 == null) {
                                      break label5394;
                                    }
                                  }
                                }
                                for (i = ((FinderItem)localObject2).getMediaType();; i = 0)
                                {
                                  paramb.mediaType = i;
                                  a.a(getContextObj(), paramb);
                                  paramb = x.SXb;
                                  break;
                                }
                              }
                              localObject1 = a.a.tHJ;
                              if (i == a.a.daj())
                              {
                                localObject3 = this.vfI;
                                localObject1 = localObject2;
                                if (localObject3 != null)
                                {
                                  if (((p)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5496;
                                    }
                                  }
                                  for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                  {
                                    localObject1 = localObject2;
                                    if (paramb == null) {
                                      break;
                                    }
                                    auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(6)))));
                                    paramb = x.SXb;
                                    localObject1 = localObject2;
                                    break;
                                    i = 0;
                                    break label5444;
                                  }
                                }
                              }
                              else
                              {
                                localObject1 = a.a.tHJ;
                                if (i == a.a.dak())
                                {
                                  localObject3 = this.vfI;
                                  localObject1 = localObject2;
                                  if (localObject3 != null)
                                  {
                                    if (((p)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                    {
                                      i = 1;
                                      if (i == 0) {
                                        break label5598;
                                      }
                                    }
                                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                    {
                                      localObject1 = localObject2;
                                      if (paramb == null) {
                                        break;
                                      }
                                      auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(8)))));
                                      paramb = x.SXb;
                                      localObject1 = localObject2;
                                      break;
                                      i = 0;
                                      break label5546;
                                    }
                                  }
                                }
                                else
                                {
                                  localObject1 = a.a.tHJ;
                                  if (i == a.a.dal())
                                  {
                                    localObject3 = this.vfI;
                                    localObject1 = localObject2;
                                    if (localObject3 != null)
                                    {
                                      if (((p)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                      {
                                        i = 1;
                                        if (i == 0) {
                                          break label5700;
                                        }
                                      }
                                      for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                      {
                                        localObject1 = localObject2;
                                        if (paramb == null) {
                                          break;
                                        }
                                        auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", Integer.valueOf(9)))));
                                        paramb = x.SXb;
                                        localObject1 = localObject2;
                                        break;
                                        i = 0;
                                        break label5648;
                                      }
                                    }
                                  }
                                  else
                                  {
                                    AppMethodBeat.o(250726);
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
          AppMethodBeat.o(250726);
          return;
        }
        if ((paramb instanceof ag.b))
        {
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((ag.b)paramb).feedId)
            {
              i = 1;
              if (i == 0) {
                break label6022;
              }
              label5759:
              if (localObject1 == null) {
                break label6038;
              }
              if (((ag.b)paramb).tHM.mediaType != 2) {
                break label6028;
              }
              i = 0;
              k = ((ag.b)paramb).index;
              if (k + 1 > ((p)localObject1).vfW) {
                ((p)localObject1).vfW = (k + 1);
              }
              m = ((p)localObject1).dol();
              if (m != k)
              {
                l2 = cl.aWA();
                l1 = l2 - localObject1.doi()[localObject1.dol()];
                n = localObject1.doj()[localObject1.dol()];
                i1 = localObject1.dok()[localObject1.dol()];
                ((p)localObject1).vfR[m] = l1;
                ((p)localObject1).doi()[k] = l2;
                ((p)localObject1).vfU = k;
                localObject2 = getContextObj();
                l2 = ((p)localObject1).getFeedId();
                if (!((ag.b)paramb).viJ) {
                  break label6033;
                }
              }
            }
            for (j = 1;; j = 0)
            {
              e.a.a((bbn)localObject2, l2, 4, String.valueOf(e.a.a(4, new String[] { String.valueOf(l1), String.valueOf(m), String.valueOf(k), String.valueOf(i), String.valueOf(n), String.valueOf(i1), String.valueOf(j) })), 0L, null, 48);
              dog();
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label5759;
              i = 1;
              break label5780;
            }
          }
          AppMethodBeat.o(250726);
          return;
        }
        if ((paramb instanceof c.a)) {
          switch (((c.a)paramb).type)
          {
          }
        }
        label6650:
        label6909:
        label7037:
        for (;;)
        {
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6210;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6216;
              }
              ((p)localObject1).vgp = paramb.dao();
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6302;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6308;
              }
              if (((p)localObject1).doq() != 0L) {
                ((p)localObject1).vgo = (paramb.dao() - ((p)localObject1).doq());
              }
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6378;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6384;
              }
              ((p)localObject1).Fh(paramb.dao());
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6475;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label6480;
              }
              paramb.dok()[paramb.dol()] += 1;
              i = paramb.vfV;
              paramb.vfV = (i + 1);
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6650;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6656;
              }
              ((p)localObject1).vgi = ((c.a)paramb).getOffset();
              ((p)localObject1).vgt.add(Integer.valueOf(((c.a)paramb).getOffset()));
              i = (int)(100.0F * ((c.a)paramb).getOffset() / ((c.a)paramb).jcu);
              if (i > localObject1.doj()[localObject1.dol()]) {
                ((p)localObject1).doj()[localObject1.dol()] = i;
              }
              if (i > ((p)localObject1).vfY)
              {
                ((p)localObject1).vfX = ((c.a)paramb).getOffset();
                ((p)localObject1).vfY = i;
              }
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6766;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6772;
              }
              ((p)localObject1).vgh += 1;
              if (((p)localObject1).dop() != 0L)
              {
                ((p)localObject1).vgm += paramb.dao() - ((p)localObject1).dop();
                ((p)localObject1).Fh(0L);
              }
              paramb = x.SXb;
              AppMethodBeat.o(250726);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(250726);
          return;
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6904;
            }
            i = 1;
            if (i == 0) {
              break label6909;
            }
            if (localObject1 != null)
            {
              ((p)localObject1).vgr = 1;
              localObject1 = x.SXb;
            }
          }
          if (((c.a)paramb).tHM != null)
          {
            if (((c.a)paramb).dam() <= ((c.a)paramb).dan()) {
              break label6915;
            }
            e.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(e.a.a(15, new String[] { "-1" })), 0L, null, 48);
          }
          for (;;)
          {
            paramb = x.SXb;
            AppMethodBeat.o(250726);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label6812;
            if (((c.a)paramb).dam() < ((c.a)paramb).dan()) {
              e.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(e.a.a(15, new String[] { "1" })), 0L, null, 48);
            }
          }
          localObject1 = this.vfI;
          if (localObject1 != null)
          {
            if (((p)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label7034;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label7037;
              }
              paramb.vgq = 1;
              paramb = x.SXb;
              AppMethodBeat.o(250726);
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
    AppMethodBeat.i(250722);
    kotlin.g.b.p.h(paramc, "dispatcher");
    kotlin.g.b.p.h(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(250722);
      return true;
    }
    if ((paramb instanceof ag.b))
    {
      AppMethodBeat.o(250722);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(250722);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(250722);
      return true;
    }
    AppMethodBeat.o(250722);
    return false;
  }
  
  public final void auL(String paramString)
  {
    AppMethodBeat.i(250732);
    kotlin.g.b.p.h(paramString, "feedActionValue");
    p localp = this.vfI;
    if (localp != null)
    {
      Log.i(TAG, "sendExtStatsReport ".concat(String.valueOf(paramString)));
      alc localalc = new alc();
      localalc.hFK = localp.feedId;
      Object localObject = localp.tHo;
      if (localObject != null) {
        localalc.finderUsername = ((FinderItem)localObject).getUserName();
      }
      localObject = k.vfA;
      localalc.sessionBuffer = k.G(localp.feedId, this.ttO.tCE);
      localalc.Lub = paramString;
      localalc.videoDuration = localp.videoDuration;
      paramString = localp.tHo;
      if (paramString != null) {}
      for (int i = paramString.getMediaType();; i = 0)
      {
        localalc.mediaType = i;
        a.a(this.ttO, localalc);
        AppMethodBeat.o(250732);
        return;
      }
    }
    AppMethodBeat.o(250732);
  }
  
  public final void dnL()
  {
    this.vdP.vdU = true;
  }
  
  public final LinkedList<ecq> dnM()
  {
    AppMethodBeat.i(250728);
    if (this.vfE.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.vfE);
      this.vfE.clear();
      s locals = s.vhF;
      s.a((List)localLinkedList, this.ttO, 0);
      AppMethodBeat.o(250728);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(250728);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(250731);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(250731);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(250723);
    onExit();
    super.onRelease();
    AppMethodBeat.o(250723);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(250730);
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
        AppMethodBeat.o(250730);
        return;
      }
    }
    AppMethodBeat.o(250730);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "", "plugin-finder_release"})
  public static final class a
  {
    public static void a(bbn parambbn, alc paramalc)
    {
      AppMethodBeat.i(250719);
      kotlin.g.b.p.h(paramalc, "extStats");
      Log.i(o.access$getTAG$cp(), "sendExtStatsReport " + d.zs(paramalc.hFK));
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new aw(parambbn, paramalc));
      AppMethodBeat.o(250719);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(o paramo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(o paramo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final int cxn()
    {
      return 0;
    }
    
    public final long lT()
    {
      return this.tpH.id;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */
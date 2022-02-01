package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.cj;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.convert.ar;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.a.a.a;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.csg;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "", "curAdPosterId", "", "dailyTopicMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectHotTopic;", "extActionValueList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "feedReportWatcher", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getLastCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setLastCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "lastFocusFeedId", "lastVisibleFeedMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Lcom/tencent/mm/protocal/protobuf/Stats;", "addActionValue", "", "actionValue", "afterConversationUpdate", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "checkEmptyToHotTabExpose", "messageType", "index", "checkRedDotExpose", "getAdH5Cache", "Lcom/tencent/mm/plugin/finder/feed/model/AdMutualCache;", "record", "getDailyTopic", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "handleExtStatsRecord", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onDailyShow", "singleFeedRecord", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "optExtStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "feedActionValue", "recordAd", "recordAdPosterInVisible", "recordAdPosterVisible", "reportCenterRecord", "stats", "reportDailyShow", "dailyTopic", "reportExpose", "across", "reportExtStatsInCenterSwitch", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExStatsReport", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "sendExtStatsReport", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public class s
  extends g
{
  private static final String TAG = "Finder.FinderSingleFeedFlowReporter";
  private static t zWU;
  public static final a zWV;
  private ConcurrentLinkedQueue<emr> zWK;
  private ConcurrentLinkedQueue<String> zWL;
  private final b zWM;
  private final int zWN;
  t zWO;
  HashSet<Long> zWP;
  public HashMap<Long, t> zWQ;
  private ConcurrentHashMap<Long, bgb> zWR;
  private long zWS;
  private long zWT;
  
  static
  {
    AppMethodBeat.i(269527);
    zWV = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    AppMethodBeat.o(269527);
  }
  
  public s(MMFragmentActivity paramMMFragmentActivity, bid parambid)
  {
    super(paramMMFragmentActivity, parambid);
    AppMethodBeat.i(269526);
    this.zWK = new ConcurrentLinkedQueue();
    this.zWL = new ConcurrentLinkedQueue();
    paramMMFragmentActivity = new b();
    paramMMFragmentActivity.dOZ();
    this.zWM = paramMMFragmentActivity;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zWN = ((Number)com.tencent.mm.plugin.finder.storage.d.dWi().aSr()).intValue();
    this.zWP = new HashSet();
    this.zWQ = new HashMap();
    this.zWR = new ConcurrentHashMap();
    AppMethodBeat.o(269526);
  }
  
  private final emr a(t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(269512);
    t.e(paramt);
    Object localObject2;
    if (!b.a(this.zWM))
    {
      localObject1 = new StringBuilder();
      if (paramt != null)
      {
        localObject2 = b.dq(paramt);
        if (paramt.fOa < 0L) {
          ((StringBuilder)localObject1).append("stayTime :" + paramt.fOa + " startTime:" + paramt.startTime + " endTime:" + paramt.endTime + "\n obj:" + (String)localObject2);
        }
        if (paramt.zXu < 0L) {
          ((StringBuilder)localObject1).append("realPlayTime :" + paramt.zXu + " realPlayTimestamp:" + paramt.zXv + " endTime:" + paramt.endTime + "\n obj:" + (String)localObject2);
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject1).toString())) {
        Log.e("FeedReportWatcher", "vertify error:\n ".concat(String.valueOf(localObject1)));
      }
    }
    Object localObject3 = paramt.xpY;
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
          if (!this.zWR.containsKey(Long.valueOf(l1))) {
            break label683;
          }
          localObject2 = (bgb)this.zWR.get(Long.valueOf(l1));
          localObject4 = TAG;
          localObject5 = new StringBuilder("get from cache: ");
          if (localObject2 == null) {
            break label677;
          }
          localObject1 = ((bgb)localObject2).uLJ;
          label319:
          Log.i((String)localObject4, (String)localObject1);
          localObject1 = localObject2;
          if ((localObject3 != null) && (localObject1 != null))
          {
            if (((bgb)localObject1).SQY <= 0) {
              break label772;
            }
            i = 1;
            label358:
            localObject2 = n.zWF;
            l1 = ((FinderItem)localObject3).getFeedObject().id;
            long l2 = ((bgb)localObject1).xee;
            localObject2 = ((bgb)localObject1).uLJ;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            n.a(l1, 1L, l2, (String)localObject1, i, this.xbu.xkX);
          }
        }
        localObject1 = t.zXK;
        localObject2 = t.a.a(paramt, this.xbu);
        if (paramt.xpY == null) {
          break label777;
        }
        g.a.a(this.xbu, paramt.feedId, 14, String.valueOf(paramt.endTime - paramt.startTime), 0L, null, 48);
        label471:
        g.a.a(this.xbu, paramt, 2);
        if (!paramBoolean) {
          break label1188;
        }
        localObject1 = paramt.xpY;
        if (localObject1 == null) {
          break label853;
        }
        localObject4 = ((FinderItem)localObject1).getFoldedLayout();
        if ((localObject4 == null) || (((asz)localObject4).jlf <= 0)) {
          break label853;
        }
        localObject1 = paramt.xrf;
        if (localObject1 == null) {
          break label789;
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).YSH;
      }
    }
    label533:
    Object localObject6;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = paramt.xrf;
        if (localObject1 != null)
        {
          localObject3 = new LongSparseArray();
          localObject4 = ((asz)localObject4).SGi;
          p.j(localObject4, "it.objects");
          localObject4 = ((Iterable)localObject4).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((Iterator)localObject4).next();
              if (i < 0) {
                kotlin.a.j.iBO();
              }
              localObject5 = (FinderObject)localObject5;
              if (i <= 2)
              {
                localObject6 = new com.tencent.mm.view.recyclerview.l((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject5));
                ((com.tencent.mm.view.recyclerview.l)localObject6).xre = i;
                ((LongSparseArray)localObject3).put(((FinderObject)localObject5).id, localObject6);
              }
              i += 1;
              continue;
              localObject1 = null;
              break;
              label677:
              localObject1 = null;
              break label319;
              label683:
              localObject2 = i((FinderItem)localObject3);
              if (localObject2 != null) {
                ((Map)this.zWR).put(Long.valueOf(l1), localObject2);
              }
              localObject4 = TAG;
              localObject5 = new StringBuilder("get from feed update map: ");
              if (localObject2 != null) {}
              for (localObject1 = ((bgb)localObject2).uLJ;; localObject1 = null)
              {
                Log.i((String)localObject4, (String)localObject1);
                localObject1 = localObject2;
                break;
              }
              label772:
              i = 0;
              break label358;
              label777:
              Log.i(TAG, "local feed ignore");
              break label471;
              label789:
              localObject1 = null;
              break label533;
            }
          }
          ((com.tencent.mm.view.recyclerview.j)localObject1).YSH = ((LongSparseArray)localObject3);
        }
      }
    }
    g.a.a(this.xbu, paramt);
    Object localObject1 = paramt.xrf;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).YSI;
      if (localObject1 != null)
      {
        localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((WxRecyclerAdapter)localObject1).onPause();
        }
      }
    }
    label853:
    localObject1 = paramt.xpY;
    label871:
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getLongVideoMediaList();
      if ((!Util.isNullOrNil((List)localObject1)) && (this.zWN == 1)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(21346, new Object[] { com.tencent.mm.ae.d.Fw(paramt.feedId), Integer.valueOf(this.xbu.xkX), this.xbu.sessionId, this.xbu.wmL, this.xbu.wmz });
      }
      localObject1 = paramt.zXG;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = (BaseFinderFeed)localObject1;
        if (localObject3 == null) {
          break label1270;
        }
        localObject1 = ((BaseFinderFeed)localObject3).attachFavInfo;
        label994:
        if (localObject1 != null)
        {
          localObject1 = n.zWF;
          l1 = ((BaseFinderFeed)localObject3).mf();
          j = this.xbu.xkX;
          localObject1 = this.xbu.wmz;
          localObject4 = this.xbu.wmL;
          localObject5 = this.xbu.sessionId;
          localObject6 = n.zWF;
          localObject6 = n.N(((BaseFinderFeed)localObject3).mf(), this.xbu.xkX);
          localObject3 = ((BaseFinderFeed)localObject3).attachFavInfo;
          if ((localObject3 == null) || (((com.tencent.mm.plugin.finder.storage.l)localObject3).Alc != true)) {
            break label1276;
          }
        }
      }
    }
    label1188:
    label1270:
    label1276:
    for (int i = 1;; i = 2)
    {
      n.a(l1, 2, j, (String)localObject1, (String)localObject4, (String)localObject5, (String)localObject6, i);
      localObject1 = paramt.zXG;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.D(((BaseFinderFeed)localObject1).feedObject))
        {
          localObject3 = n.zWF;
          n.a(this.xbu, paramt.feedId, Integer.valueOf(((BaseFinderFeed)localObject1).feedObject.getFeedObject().follow_feed_count));
        }
      }
      AppMethodBeat.o(269512);
      return localObject2;
      localObject1 = paramt.xrf;
      if ((localObject1 == null) || ((!((com.tencent.mm.view.recyclerview.j)localObject1).YSF) && (!((com.tencent.mm.view.recyclerview.j)localObject1).YSG))) {
        break;
      }
      g.a.a(this.xbu, paramt);
      ((com.tencent.mm.view.recyclerview.j)localObject1).YSG = false;
      localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).YSI;
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
      break label871;
      localObject1 = null;
      break label994;
    }
  }
  
  private final void a(t paramt, emr paramemr)
  {
    Object localObject1 = null;
    AppMethodBeat.i(269508);
    if (paramt.zXd > 0) {
      g.a.a(this.xbu, paramt.feedId, 5, String.valueOf(paramt.zXd), paramt.fhq, null, 32);
    }
    long l1 = paramt.endTime;
    long l2 = paramt.startTime;
    g.a.a(this.xbu, paramt.feedId, 2, String.valueOf(l1 - l2), paramt.fhq, null, 32);
    if (paramt.zXg > 0) {
      g.a.a(this.xbu, paramt.feedId, 11, String.valueOf(paramt.zXg), paramt.fhq, null, 32);
    }
    Object localObject2 = this.xbu;
    l1 = paramt.feedId;
    paramemr = paramemr.Upj;
    if (paramemr != null) {}
    for (paramemr = Long.valueOf(paramemr.RRR);; paramemr = "")
    {
      g.a.a((bid)localObject2, l1, 3, String.valueOf(paramemr), paramt.fhq, null, 32);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("netType", paramt.netType);
      ((JSONObject)localObject2).put("isPause", paramt.zXy);
      ((JSONObject)localObject2).put("isSeek", paramt.zXz);
      ((JSONObject)localObject2).put("playProgressInfo", paramt.zXA);
      ((JSONObject)localObject2).put("maxPlayPercent", paramt.zXg);
      ((JSONObject)localObject2).put("maxPlayLength", paramt.zXf);
      ((JSONObject)localObject2).put("videoDuration", paramt.videoDuration);
      ((JSONObject)localObject2).put("playTime", paramt.zXw);
      ((JSONObject)localObject2).put("realPlayTime", paramt.zXu);
      ((JSONObject)localObject2).put("voiceInfo", paramt.zXE);
      ((JSONObject)localObject2).put("playFormat", paramt.zXF);
      paramemr = this.xbu;
      l1 = paramt.feedId;
      localObject2 = ((JSONObject)localObject2).toString();
      p.j(localObject2, "playInfoObj.toString()");
      g.a.a(paramemr, l1, 17, kotlin.n.n.l((String)localObject2, ",", ";", false), paramt.fhq, null, 32);
      paramemr = c.zTT;
      paramemr = c.Mi(paramt.feedId);
      if (!Util.isNullOrNil(paramemr)) {
        g.a.a(this.xbu, paramt.feedId, 18, paramemr, paramt.fhq, null, 32);
      }
      g.a.a(this.xbu, paramt, 1);
      bid localbid = this.xbu;
      p.k(localbid, "contextObj");
      p.k(paramt, "record");
      if ((paramt.xpY != null) && (paramt.xpY.getShowExtendLink()))
      {
        cj localcj = new cj();
        localcj.mo(com.tencent.mm.ae.d.Fw(paramt.xpY.field_id));
        localcj.mp(localbid.sessionId);
        localcj.mq(localbid.wmL);
        paramemr = paramt.xpY;
        if (paramemr != null)
        {
          paramemr = paramemr.getExtReading();
          if (paramemr != null)
          {
            localObject2 = paramemr.link;
            paramemr = (emr)localObject2;
            if (localObject2 != null) {
              break label531;
            }
          }
        }
        paramemr = "";
        label531:
        localcj.mr(paramemr);
        localcj.ahw();
        localcj.ft(1L);
        localcj.ms(localbid.wmz);
        localcj.fu(localbid.xkX);
        paramemr = n.zWF;
        paramemr = paramt.xpY;
        paramt = localObject1;
        if (paramemr != null) {
          paramt = Long.valueOf(paramemr.getId());
        }
        localcj.mt(n.N(paramt.longValue(), localbid.xkX));
        localcj.bpa();
      }
      dPG();
      AppMethodBeat.o(269508);
      return;
    }
  }
  
  private final void aEf(String paramString)
  {
    AppMethodBeat.i(269524);
    this.zWL.add(paramString);
    AppMethodBeat.o(269524);
  }
  
  private final void c(t paramt)
  {
    AppMethodBeat.i(269514);
    com.tencent.mm.plugin.finder.feed.model.a locala = d(paramt);
    if (locala != null)
    {
      if (paramt != null) {}
      for (long l = paramt.feedId;; l = 0L)
      {
        this.zWT = l;
        locala.duf();
        AppMethodBeat.o(269514);
        return;
      }
    }
    AppMethodBeat.o(269514);
  }
  
  private static com.tencent.mm.plugin.finder.feed.model.a d(t paramt)
  {
    AppMethodBeat.i(269516);
    Object localObject = com.tencent.mm.plugin.finder.utils.d.ACS;
    int i;
    if (paramt != null)
    {
      localObject = paramt.xpY;
      if (localObject != null)
      {
        localObject = ((FinderItem)localObject).getFeedObject();
        if (localObject != null)
        {
          i = ((FinderObject)localObject).adFlag;
          if (!com.tencent.mm.plugin.finder.utils.d.gX(i, 1)) {
            break label115;
          }
          localObject = com.tencent.mm.plugin.finder.feed.model.g.xGi;
          localObject = com.tencent.mm.plugin.finder.feed.model.g.dul();
          if (paramt == null) {
            break label110;
          }
        }
      }
    }
    label110:
    for (long l = paramt.feedId;; l = 0L)
    {
      localObject = ((e)localObject).KU(l);
      paramt = (t)localObject;
      if (!(localObject instanceof com.tencent.mm.plugin.finder.feed.model.a)) {
        paramt = null;
      }
      paramt = (com.tencent.mm.plugin.finder.feed.model.a)paramt;
      AppMethodBeat.o(269516);
      return paramt;
      i = 0;
      break;
    }
    label115:
    AppMethodBeat.o(269516);
    return null;
  }
  
  private final void dPG()
  {
    int j = 0;
    AppMethodBeat.i(269523);
    Object localObject1 = this.zWO;
    if (localObject1 != null)
    {
      if (((t)localObject1).zXz > 0) {
        aEf(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(13)))));
      }
      if (((t)localObject1).zXs > 0) {
        aEf(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(14)))));
      }
    }
    localObject1 = dPj();
    if (((g.b)localObject1).zUX) {
      aEf(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(11)))));
    }
    if (((g.b)localObject1).zUW) {
      aEf(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(12)))));
    }
    localObject1 = dPj();
    ((g.b)localObject1).zUW = false;
    ((g.b)localObject1).zUX = false;
    Object localObject2 = new LinkedList();
    if (this.zWO != null)
    {
      Iterator localIterator = ((Iterable)this.zWL).iterator();
      label340:
      label367:
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        Log.i(TAG, "reportExtStatsInCenterSwitch action: ".concat(String.valueOf(localObject3)));
        p.j(localObject3, "it");
        if (!Util.isNullOrNil((String)localObject3))
        {
          t localt = this.zWO;
          if (localt != null)
          {
            localObject1 = new amd();
            ((amd)localObject1).xbk = localt.feedId;
            Object localObject4 = localt.xpY;
            if (localObject4 != null) {
              ((amd)localObject1).finderUsername = ((FinderItem)localObject4).getUserName();
            }
            localObject4 = n.zWF;
            ((amd)localObject1).sessionBuffer = n.N(localt.feedId, this.xbu.xkX);
            ((amd)localObject1).Swz = ((String)localObject3);
            ((amd)localObject1).videoDuration = localt.videoDuration;
            localObject3 = localt.xpY;
            if (localObject3 != null)
            {
              i = ((FinderItem)localObject3).getMediaType();
              ((amd)localObject1).mediaType = i;
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
      this.zWL.clear();
      int i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        localObject1 = this.xbu;
        localObject2 = (List)localObject2;
        p.k(localObject2, "extStats");
        Log.i(TAG, "sendExtStatsReport " + ((List)localObject2).size());
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new az((bid)localObject1, (List)localObject2));
      }
    }
    AppMethodBeat.o(269523);
  }
  
  private final void gR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269518);
    n localn = n.zWF;
    n.a(1, paramInt1, paramInt2, this.xbu);
    AppMethodBeat.o(269518);
  }
  
  private static bgb i(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(269525);
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.getFeedObject().hotTopics;
      if (paramFinderItem != null) {}
      for (paramFinderItem = paramFinderItem.topics; paramFinderItem != null; paramFinderItem = null)
      {
        paramFinderItem = paramFinderItem.iterator();
        bgb localbgb;
        do
        {
          if (!paramFinderItem.hasNext()) {
            break;
          }
          localbgb = (bgb)paramFinderItem.next();
        } while ((localbgb == null) || (localbgb.SQX != 5));
        AppMethodBeat.o(269525);
        return localbgb;
      }
    }
    AppMethodBeat.o(269525);
    return null;
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(269506);
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    com.tencent.mm.ae.d.c(com.tencent.mm.plugin.finder.viewmodel.component.aj.eld(), (kotlin.g.a.a)new c(this));
    c(this.zWO);
    AppMethodBeat.o(269506);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(269511);
    p.k(paramb, "event");
    super.a(paramb);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    long l2;
    label663:
    label725:
    label736:
    label743:
    Object localObject5;
    Object localObject6;
    emr localemr;
    int i;
    label1810:
    label2120:
    int m;
    int n;
    int i1;
    int i2;
    int k;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      if (!getVisible())
      {
        Log.i(TAG, this.xbu.xkX + " not visible");
        AppMethodBeat.o(269511);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUO().aSr()).intValue() == 1)
      {
        localObject1 = au.zBf;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrq;
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next()).xrd);
          }
          localObject1 = (List)localObject1;
          au.a((List)localObject1, this.xbu);
        }
      }
      else
      {
        if ((this.zWS != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).type == 6))
        {
          localObject1 = n.zWF;
          localObject1 = n.h(((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl, this.xbu.xkX);
          if (localObject1 != null)
          {
            ((ao)localObject1).zZQ.SQx = cm.bfE();
            localObject1 = ((ao)localObject1).zZQ;
            ((bft)localObject1).SQy += 1;
            localObject1 = x.aazN;
          }
          this.zWS = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl;
        }
        if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCr == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrh) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCs == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrj)) {
          break label1810;
        }
        localObject2 = new HashMap();
        if (((com.tencent.mm.plugin.finder.event.base.j)paramb).xjA == ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl) {
          break label743;
        }
        localObject1 = this.zWO;
        if (localObject1 != null)
        {
          ((t)localObject1).a(this.zUT);
          localObject3 = t.zXK;
          localObject3 = t.a.a((t)localObject1, this.xbu);
          ((Map)localObject2).put(Long.valueOf(((t)localObject1).feedId), localObject3);
          a((t)localObject1, (emr)localObject3);
          switch (((com.tencent.mm.plugin.finder.event.base.j)paramb).type)
          {
          }
        }
      }
      for (;;)
      {
        localObject1 = x.aazN;
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
        if (localObject1 == null) {
          break label736;
        }
        localObject3 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
        } while (((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf() != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrl);
        l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd.mf();
        l2 = paramb.xqG;
        if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd instanceof BaseFinderFeed)) {
          break label725;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrd;
        if (localObject1 != null) {
          break label663;
        }
        paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(269511);
        throw paramb;
        localObject1 = null;
        break;
        aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(1)))));
      }
      for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
      {
        localObject1 = new t(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xrf, true, this.zUT, null, 64);
        ((t)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).xre;
        localObject4 = x.aazN;
        this.zWO = ((t)localObject1);
        break;
      }
      localObject1 = x.aazN;
      zWU = this.zWO;
      localObject4 = new HashSet();
      localObject3 = new HashSet();
      ((HashSet)localObject4).addAll((Collection)this.zWQ.keySet());
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
          ((HashSet)localObject4).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()));
          ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()));
        }
        localObject1 = x.aazN;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrq;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject5).next();
          if (!((HashSet)localObject4).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf())))
          {
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf();
            l2 = paramb.xqG;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd instanceof BaseFinderFeed))
            {
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;
              if (localObject1 == null)
              {
                paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(269511);
                throw paramb;
              }
            }
            for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
            {
              localObject1 = new t(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrf, false, null, null, 112);
              ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd;
              this.zWM.a((t)localObject1);
              this.zWM.a(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd, "acrossFeedList ", (t)localObject1);
              localemr = a((t)localObject1, true);
              this.zWM.b((t)localObject1);
              if ((emr)((HashMap)localObject2).get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf())) == null)
              {
                ((Map)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).xrd.mf()), localemr);
                localObject1 = x.aazN;
              }
              localObject1 = x.aazN;
              break;
            }
          }
        }
        localObject1 = x.aazN;
      }
      localObject1 = ((Map)this.zWQ).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject3).contains(((Map.Entry)localObject4).getKey()))
        {
          localObject5 = a((t)((Map.Entry)localObject4).getValue(), false);
          this.zWM.b((t)((Map.Entry)localObject4).getValue());
          if ((emr)((HashMap)localObject2).get(Long.valueOf(((t)((Map.Entry)localObject4).getValue()).feedId)) == null)
          {
            ((Map)localObject2).put(Long.valueOf(((t)((Map.Entry)localObject4).getValue()).feedId), localObject5);
            localObject4 = x.aazN;
          }
        }
      }
      localObject3 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
      if (localObject1 != null)
      {
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
          localObject1 = (t)this.zWQ.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()));
          if (localObject1 != null)
          {
            ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd;
            ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()), localObject1);
            if (localObject1 != null) {
              break;
            }
          }
          else
          {
            localObject6 = (s)this;
            l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf();
            l2 = paramb.xqG;
            if ((((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd instanceof BaseFinderFeed))
            {
              localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd;
              if (localObject1 == null)
              {
                paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(269511);
                throw paramb;
              }
            }
            for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
            {
              localObject1 = new t(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrf, false, null, null, 112);
              ((t)localObject1).zXG = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd;
              ((t)localObject1).zWX = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).xre;
              ((s)localObject6).zWM.a((t)localObject1);
              ((s)localObject6).zWM.a(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd, "lastVisibleFeedMap ", (t)localObject1);
              ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).xrd.mf()), localObject1);
              break;
            }
          }
        }
        localObject1 = x.aazN;
      }
      this.zWQ = ((HashMap)localObject3);
      if (!((Map)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          this.zWK.addAll(((HashMap)localObject2).values());
        }
        if (this.zWK.size() > 20)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          com.tencent.mm.ae.d.c(com.tencent.mm.plugin.finder.viewmodel.component.aj.eld(), (kotlin.g.a.a)new b(this));
        }
        localObject1 = TAG;
        localObject2 = new StringBuilder("waitForReportStatsList ");
        localObject4 = (Iterable)this.zWK;
        localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(com.tencent.mm.ae.d.Fw(((emr)((Iterator)localObject4).next()).xbk));
        }
      }
      Log.i((String)localObject1, (List)localObject3);
      if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).sCr != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrh) || (((com.tencent.mm.plugin.finder.event.base.j)paramb).sCs != ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrj))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrs;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (bu)((Iterator)localObject2).next();
              if (!this.zWP.contains(Long.valueOf(((bu)localObject1).mf()))) {
                switch (((bu)localObject1).bAQ())
                {
                default: 
                  break;
                case -7: 
                case -1: 
                  if ((this.xbu.xkX == 17) || (this.xbu.xkX == 18)) {
                    gR(1, 0);
                  }
                  break;
                case 2011: 
                  if (this.xbu.xkX == 17)
                  {
                    localObject1 = ar.xmV;
                    gR(2, com.tencent.mm.plugin.finder.convert.ar.a.Mf(3));
                  }
                  else if (this.xbu.xkX == 18)
                  {
                    localObject1 = ar.xmV;
                    gR(2, com.tencent.mm.plugin.finder.convert.ar.a.Mf(1));
                  }
                  break;
                case -5: 
                  if ((this.xbu.xkX == 17) || (this.xbu.xkX == 18) || (this.xbu.xkX == 20))
                  {
                    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
                    localObject1 = aj.a.fZ((Context)dsB());
                    if (localObject1 != null) {
                      if (((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekT())
                      {
                        if (localObject1 == null) {
                          break label2496;
                        }
                        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.d((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
                        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).sCr > 1)) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
                        p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                        localObject3 = ((PluginFinder)localObject1).getRedDotManager().aBf("TLWxBubble");
                        localObject1 = "";
                        if (localObject3 != null)
                        {
                          localObject1 = com.tencent.mm.kernel.h.aHG();
                          p.j(localObject1, "MMKernel.storage()");
                          m = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(com.tencent.mm.storage.ar.a.VAb, 0);
                          localObject1 = com.tencent.mm.kernel.h.aHG();
                          p.j(localObject1, "MMKernel.storage()");
                          n = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(com.tencent.mm.storage.ar.a.VAc, 0);
                          localObject1 = com.tencent.mm.kernel.h.aHG();
                          p.j(localObject1, "MMKernel.storage()");
                          i1 = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(com.tencent.mm.storage.ar.a.VAd, 0);
                          localObject1 = com.tencent.mm.kernel.h.aHG();
                          p.j(localObject1, "MMKernel.storage()");
                          i2 = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(com.tencent.mm.storage.ar.a.VAe, 0);
                          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
                          if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
                            break label2498;
                          }
                          k = 5;
                          if (n <= 0) {
                            break label7400;
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
    label2496:
    label2498:
    label3147:
    label3159:
    label5083:
    label5088:
    label6113:
    label7012:
    label7271:
    label7400:
    for (int j = 1;; j = 0)
    {
      i = j;
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
        localObject1 = n.zWF;
        localObject1 = n.fC((Context)dsB());
        j = i;
        i = k;
        for (;;)
        {
          localObject4 = n.zWF;
          n.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject3).field_tipsId, null, 0L, this.xbu, 0, 0, 3456);
          localObject4 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject4, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject4).getRedDotManager().aBe("TLWxBubble");
          if ((localObject3 == null) || (localObject4 == null)) {
            break;
          }
          localObject5 = l.zWx;
          l.a((String)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject3, (bkn)localObject4, 1, this.xbu, 0, 0, null, 224);
          break;
          localObject1 = null;
          break label2120;
          break;
          localObject1 = "2";
          i = 1;
          j = 1;
        }
        localObject1 = x.aazN;
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
        localObject1 = ((com.tencent.mm.plugin.finder.event.base.j)paramb).xrr;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next();
            localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).xrf;
            if (localObject3 != null)
            {
              if (((com.tencent.mm.view.recyclerview.j)localObject3).YSG)
              {
                localObject4 = this.xbu;
                l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).xrd.mf();
                l2 = paramb.xqG;
                if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject1).xrd instanceof BaseFinderFeed)) {
                  break label2854;
                }
                localObject1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).xrd;
                if (localObject1 == null)
                {
                  paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                  AppMethodBeat.o(269511);
                  throw paramb;
                }
              }
              for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
              {
                g.a.a((bid)localObject4, new t(l1, l2, (FinderItem)localObject1, (com.tencent.mm.view.recyclerview.j)localObject3, false, null, null, 112));
                ((com.tencent.mm.view.recyclerview.j)localObject3).YSG = false;
                localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject3).YSI;
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
              }
            }
          }
          paramb = x.aazN;
          AppMethodBeat.o(269511);
          return;
        }
        AppMethodBeat.o(269511);
        return;
        if ((paramb instanceof a.a))
        {
          localObject2 = null;
          localObject1 = null;
          localemr = null;
          localObject6 = null;
          localObject5 = null;
          localObject4 = null;
          localObject3 = null;
          a.a.a locala1 = null;
          i = ((a.a)paramb).type;
          a.a.a locala2 = a.a.xqt;
          if (i == a.a.dpQ())
          {
            localObject1 = this.zWO;
            if (localObject1 != null) {
              if (((t)localObject1).feedId == ((a.a)paramb).feedId)
              {
                i = 1;
                if (i == 0) {
                  break label3147;
                }
                if (localObject1 == null) {
                  break label3159;
                }
                ((t)localObject1).pqr += 1;
                i = ((t)localObject1).zXl;
                ((t)localObject1).zXl = (i + 1);
                localObject1 = locala1;
                localObject2 = getContextObj();
                l1 = ((a.a)paramb).getFeedId();
                localObject3 = g.c.zUZ;
                g.a.a((bid)localObject2, l1, 1, g.c.dPm(), 0L, null, 48);
                localObject2 = getContextObj();
                l1 = ((a.a)paramb).getFeedId();
                paramb = z.bcZ();
                p.j(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = g.a.a(10, new String[] { "1", paramb }).toString();
                p.j(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                g.a.a((bid)localObject2, l1, 10, paramb, 0L, null, 48);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              t.e((t)localObject1);
              paramb = t.zXK;
              paramb = t.a.a((t)localObject1, getContextObj());
              this.zWK.add(paramb);
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label2962;
              localObject1 = null;
              break label2962;
              l1 = ((a.a)paramb).feedId;
              l2 = paramb.xqG;
              localObject1 = n.zWF;
              localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).feedId), null, false, null, null, 120);
              ((t)localObject1).PC(((t)localObject1).dPL() + 1);
              ((t)localObject1).PH(((t)localObject1).dPQ() + 1);
              localObject2 = x.aazN;
              localObject2 = x.aazN;
              break label2997;
              locala1 = a.a.xqt;
              if (i == a.a.dpP())
              {
                localObject2 = this.zWO;
                if (localObject2 != null) {
                  if (((t)localObject2).getFeedId() == ((a.a)paramb).getFeedId())
                  {
                    i = 1;
                    if (i == 0) {
                      break label3467;
                    }
                  }
                }
                for (;;)
                {
                  if (localObject2 == null)
                  {
                    l1 = ((a.a)paramb).getFeedId();
                    l2 = paramb.dql();
                    localObject1 = n.zWF;
                    localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                    localObject2 = x.aazN;
                  }
                  localObject2 = x.aazN;
                  localObject2 = getContextObj();
                  l1 = ((a.a)paramb).getFeedId();
                  localObject3 = g.c.zUZ;
                  g.a.a((bid)localObject2, l1, 1, g.c.a.dPn(), 0L, null, 48);
                  localObject2 = getContextObj();
                  l1 = ((a.a)paramb).getFeedId();
                  paramb = z.bcZ();
                  p.j(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = g.a.a(10, new String[] { "2", paramb }).toString();
                  p.j(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  g.a.a((bid)localObject2, l1, 10, paramb, 0L, null, 48);
                  break;
                  i = 0;
                  break label3286;
                  localObject2 = null;
                  continue;
                  localObject2 = null;
                }
              }
              localObject1 = a.a.xqt;
              if (i == a.a.dpS())
              {
                localObject1 = getContextObj();
                l1 = ((a.a)paramb).getFeedId();
                paramb = z.bcZ();
                p.j(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                paramb = g.a.a(13, new String[] { "1", paramb }).toString();
                p.j(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                g.a.a((bid)localObject1, l1, 13, paramb, 0L, null, 48);
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = a.a.xqt;
                if (i == a.a.dpR())
                {
                  localObject1 = getContextObj();
                  l1 = ((a.a)paramb).getFeedId();
                  paramb = z.bcZ();
                  p.j(paramb, "ConfigStorageLogic.getUsernameFromUserInfo()");
                  paramb = g.a.a(13, new String[] { "2", paramb }).toString();
                  p.j(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                  g.a.a((bid)localObject1, l1, 13, paramb, 0L, null, 48);
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1 = a.a.xqt;
                  if (i == a.a.dpU())
                  {
                    localObject1 = this.zWO;
                    if (localObject1 != null) {
                      if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                      {
                        i = 1;
                        label3698:
                        if (i == 0) {
                          break label3770;
                        }
                        label3702:
                        if (localObject1 == null) {
                          break label3782;
                        }
                        ((t)localObject1).PD(((t)localObject1).dPM() + 1);
                        localObject1 = localemr;
                      }
                    }
                    for (;;)
                    {
                      localObject2 = getContextObj();
                      l1 = ((a.a)paramb).getFeedId();
                      paramb = g.c.zUZ;
                      g.a.a((bid)localObject2, l1, 6, g.c.a.dPn(), 0L, null, 48);
                      paramb = x.aazN;
                      break;
                      i = 0;
                      break label3698;
                      localObject1 = null;
                      break label3702;
                      localObject1 = null;
                      break label3702;
                      l1 = ((a.a)paramb).getFeedId();
                      l2 = paramb.dql();
                      localObject1 = n.zWF;
                      localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                      ((t)localObject1).PD(((t)localObject1).dPM() + 1);
                      localObject2 = x.aazN;
                    }
                  }
                  localObject1 = a.a.xqt;
                  if (i == a.a.dpX())
                  {
                    localObject1 = this.zWO;
                    if (localObject1 != null) {
                      if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                      {
                        i = 1;
                        if (i == 0) {
                          break label4042;
                        }
                        if (localObject1 == null) {
                          break label4054;
                        }
                        ((t)localObject1).PE(((t)localObject1).dPN() + 1);
                        localObject2 = localObject6;
                        localObject1 = getContextObj();
                        l1 = ((a.a)paramb).getFeedId();
                        localObject3 = g.c.zUZ;
                        g.a.a((bid)localObject1, l1, 7, g.c.a.dPn(), 0L, null, 48);
                        localObject1 = x.aazN;
                        localObject3 = this.zWO;
                        localObject1 = localObject2;
                        if (localObject3 == null) {
                          continue;
                        }
                        if (((t)localObject3).getFeedId() != ((a.a)paramb).getFeedId()) {
                          break label4123;
                        }
                        i = 1;
                        if (i == 0) {
                          break label4128;
                        }
                      }
                    }
                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                    {
                      localObject1 = localObject2;
                      if (paramb == null) {
                        break;
                      }
                      aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(4)))));
                      paramb = x.aazN;
                      localObject1 = localObject2;
                      break;
                      i = 0;
                      break label3892;
                      localObject1 = null;
                      break label3896;
                      localObject1 = null;
                      break label3896;
                      l1 = ((a.a)paramb).getFeedId();
                      l2 = paramb.dql();
                      localObject1 = n.zWF;
                      localObject2 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                      ((t)localObject2).PE(((t)localObject2).dPN() + 1);
                      localObject1 = x.aazN;
                      break label3917;
                      i = 0;
                      break label3991;
                    }
                  }
                  else
                  {
                    localObject1 = a.a.xqt;
                    if (i == a.a.dpY())
                    {
                      localObject1 = this.zWO;
                      if (localObject1 != null) {
                        if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                        {
                          i = 1;
                          if (i == 0) {
                            break label4246;
                          }
                          if (localObject1 == null) {
                            break label4258;
                          }
                          ((t)localObject1).PF(((t)localObject1).dPO() + 1);
                          localObject1 = localObject5;
                        }
                      }
                      for (;;)
                      {
                        localObject2 = getContextObj();
                        l1 = ((a.a)paramb).getFeedId();
                        paramb = g.c.zUZ;
                        g.a.a((bid)localObject2, l1, 16, g.c.a.dPn(), 0L, null, 48);
                        paramb = x.aazN;
                        break;
                        i = 0;
                        break label4174;
                        localObject1 = null;
                        break label4178;
                        localObject1 = null;
                        break label4178;
                        l1 = ((a.a)paramb).getFeedId();
                        l2 = paramb.dql();
                        localObject1 = n.zWF;
                        localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                        ((t)localObject1).PF(((t)localObject1).dPO() + 1);
                        localObject2 = x.aazN;
                      }
                    }
                    localObject1 = a.a.xqt;
                    if (i == a.a.dqa())
                    {
                      localObject1 = this.zWO;
                      if (localObject1 != null) {
                        if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                        {
                          i = 1;
                          if (i == 0) {
                            break label4403;
                          }
                        }
                      }
                      for (;;)
                      {
                        if (localObject1 == null) {
                          break label4415;
                        }
                        i = ((t)localObject1).dPW();
                        ((t)localObject1).PN(i + 1);
                        localObject1 = localObject2;
                        break;
                        i = 0;
                        break label4368;
                        localObject1 = null;
                        continue;
                        localObject1 = null;
                      }
                      l1 = ((a.a)paramb).getFeedId();
                      l2 = paramb.dql();
                      localObject1 = n.zWF;
                      localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                      ((t)localObject1).PN(((t)localObject1).dPW() + 1);
                      paramb = x.aazN;
                      paramb = x.aazN;
                    }
                    else
                    {
                      localObject1 = a.a.xqt;
                      if (i == a.a.dpT())
                      {
                        localObject1 = this.zWO;
                        if (localObject1 != null) {
                          if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                          {
                            i = 1;
                            if (i == 0) {
                              break label4598;
                            }
                            if (localObject1 == null) {
                              break label4610;
                            }
                            i = ((t)localObject1).dPP();
                            ((t)localObject1).PG(i + 1);
                            localObject1 = localObject4;
                          }
                        }
                        for (;;)
                        {
                          localObject2 = getContextObj();
                          l1 = ((a.a)paramb).getFeedId();
                          paramb = g.c.zUZ;
                          g.a.a((bid)localObject2, l1, 12, g.c.a.dPn(), 0L, null, 48);
                          break;
                          i = 0;
                          break label4528;
                          label4598:
                          localObject1 = null;
                          break label4532;
                          localObject1 = null;
                          break label4532;
                          l1 = ((a.a)paramb).getFeedId();
                          l2 = paramb.dql();
                          localObject1 = n.zWF;
                          localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                          ((t)localObject1).PG(((t)localObject1).dPP() + 1);
                          localObject2 = x.aazN;
                          localObject2 = x.aazN;
                        }
                      }
                      localObject1 = a.a.xqt;
                      if (i == a.a.dqb())
                      {
                        localObject1 = this.zWO;
                        if (localObject1 != null) {
                          if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                          {
                            i = 1;
                            label4725:
                            if (i == 0) {
                              break label4760;
                            }
                          }
                        }
                        for (;;)
                        {
                          if (localObject1 == null) {
                            break label4772;
                          }
                          i = ((t)localObject1).dPS();
                          ((t)localObject1).PJ(i + 1);
                          localObject1 = localObject2;
                          break;
                          i = 0;
                          break label4725;
                          localObject1 = null;
                          continue;
                          localObject1 = null;
                        }
                        l1 = ((a.a)paramb).getFeedId();
                        l2 = paramb.dql();
                        localObject1 = n.zWF;
                        localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                        ((t)localObject1).PJ(((t)localObject1).dPS() + 1);
                        paramb = x.aazN;
                        paramb = x.aazN;
                      }
                      else
                      {
                        localObject1 = a.a.xqt;
                        if (i == a.a.dqc())
                        {
                          localObject1 = this.zWO;
                          if (localObject1 != null) {
                            if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                            {
                              i = 1;
                              if (i == 0) {
                                break label4997;
                              }
                              if (localObject1 == null) {
                                break label5009;
                              }
                              i = ((t)localObject1).dPR();
                              ((t)localObject1).PI(i + 1);
                              localObject2 = localObject3;
                              localObject3 = this.zWO;
                              localObject1 = localObject2;
                              if (localObject3 == null) {
                                continue;
                              }
                              if (((t)localObject3).getFeedId() != ((a.a)paramb).getFeedId()) {
                                break label5083;
                              }
                              i = 1;
                              if (i == 0) {
                                break label5088;
                              }
                            }
                          }
                          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                          {
                            localObject1 = localObject2;
                            if (paramb == null) {
                              break;
                            }
                            aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(7)))));
                            paramb = x.aazN;
                            localObject1 = localObject2;
                            break;
                            i = 0;
                            break label4885;
                            localObject1 = null;
                            break label4889;
                            localObject1 = null;
                            break label4889;
                            l1 = ((a.a)paramb).getFeedId();
                            l2 = paramb.dql();
                            localObject1 = n.zWF;
                            localObject2 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                            ((t)localObject2).PI(((t)localObject2).dPR() + 1);
                            localObject1 = x.aazN;
                            localObject1 = x.aazN;
                            break label4912;
                            i = 0;
                            break label4945;
                          }
                        }
                        else
                        {
                          localObject1 = a.a.xqt;
                          if (i == a.a.dqd())
                          {
                            localObject1 = this.zWO;
                            if (localObject1 != null) {
                              if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                              {
                                i = 1;
                                if (i == 0) {
                                  break label5169;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label5181;
                              }
                              i = ((t)localObject1).dPT();
                              ((t)localObject1).PK(i + 1);
                              localObject1 = localObject2;
                              break;
                              i = 0;
                              break label5134;
                              localObject1 = null;
                              continue;
                              localObject1 = null;
                            }
                            l1 = ((a.a)paramb).getFeedId();
                            l2 = paramb.dql();
                            localObject1 = n.zWF;
                            localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                            ((t)localObject1).PK(((t)localObject1).dPT() + 1);
                            paramb = x.aazN;
                            paramb = x.aazN;
                          }
                          else
                          {
                            localObject1 = a.a.xqt;
                            if (i == a.a.dqe())
                            {
                              localObject1 = this.zWO;
                              if (localObject1 != null) {
                                if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                {
                                  i = 1;
                                  if (i == 0) {
                                    break label5329;
                                  }
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 == null) {
                                  break label5341;
                                }
                                i = ((t)localObject1).dPU();
                                ((t)localObject1).PL(i + 1);
                                localObject1 = localObject2;
                                break;
                                i = 0;
                                break label5294;
                                localObject1 = null;
                                continue;
                                localObject1 = null;
                              }
                              l1 = ((a.a)paramb).getFeedId();
                              l2 = paramb.dql();
                              localObject1 = n.zWF;
                              localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                              ((t)localObject1).PL(((t)localObject1).dPU() + 1);
                              paramb = x.aazN;
                              paramb = x.aazN;
                            }
                            else
                            {
                              localObject1 = a.a.xqt;
                              if (i == a.a.dqf())
                              {
                                localObject1 = this.zWO;
                                if (localObject1 != null) {
                                  if (((t)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5489;
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  if (localObject1 == null) {
                                    break label5501;
                                  }
                                  i = ((t)localObject1).dPV();
                                  ((t)localObject1).PM(i + 1);
                                  localObject1 = localObject2;
                                  break;
                                  i = 0;
                                  break label5454;
                                  label5489:
                                  localObject1 = null;
                                  continue;
                                  localObject1 = null;
                                }
                                label5501:
                                l1 = ((a.a)paramb).getFeedId();
                                l2 = paramb.dql();
                                localObject1 = n.zWF;
                                localObject1 = new t(l1, l2, n.Hc(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                                ((t)localObject1).PM(((t)localObject1).dPV() + 1);
                                localObject2 = x.aazN;
                                localObject2 = g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(14))));
                                localObject3 = (a.a)paramb;
                                paramb = new amd();
                                paramb.xbk = ((a.a)localObject3).getFeedId();
                                localObject4 = ((a.a)localObject3).xpY;
                                if (localObject4 != null) {
                                  paramb.finderUsername = ((FinderItem)localObject4).getUserName();
                                }
                                localObject4 = n.zWF;
                                paramb.sessionBuffer = n.N(((a.a)localObject3).getFeedId(), getContextObj().xkX);
                                paramb.Swz = ((String)localObject2);
                                if (this.zWQ.containsKey(Long.valueOf(paramb.xbk)))
                                {
                                  localObject2 = (t)this.zWQ.get(Long.valueOf(paramb.xbk));
                                  if (localObject2 != null)
                                  {
                                    paramb.videoDuration = ((t)localObject2).videoDuration;
                                    localObject2 = ((t)localObject2).xpY;
                                    if (localObject2 == null) {
                                      break label5748;
                                    }
                                  }
                                }
                                label5748:
                                for (i = ((FinderItem)localObject2).getMediaType();; i = 0)
                                {
                                  paramb.mediaType = i;
                                  a.a(getContextObj(), paramb);
                                  paramb = x.aazN;
                                  break;
                                }
                              }
                              localObject1 = a.a.xqt;
                              if (i == a.a.dqg())
                              {
                                localObject3 = this.zWO;
                                localObject1 = localObject2;
                                if (localObject3 != null)
                                {
                                  if (((t)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5850;
                                    }
                                  }
                                  for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                  {
                                    localObject1 = localObject2;
                                    if (paramb == null) {
                                      break;
                                    }
                                    aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(6)))));
                                    paramb = x.aazN;
                                    localObject1 = localObject2;
                                    break;
                                    i = 0;
                                    break label5798;
                                  }
                                }
                              }
                              else
                              {
                                localObject1 = a.a.xqt;
                                if (i == a.a.dqh())
                                {
                                  localObject3 = this.zWO;
                                  localObject1 = localObject2;
                                  if (localObject3 != null)
                                  {
                                    if (((t)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                    {
                                      i = 1;
                                      if (i == 0) {
                                        break label5952;
                                      }
                                    }
                                    for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                    {
                                      localObject1 = localObject2;
                                      if (paramb == null) {
                                        break;
                                      }
                                      aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(8)))));
                                      paramb = x.aazN;
                                      localObject1 = localObject2;
                                      break;
                                      i = 0;
                                      break label5900;
                                    }
                                  }
                                }
                                else
                                {
                                  localObject1 = a.a.xqt;
                                  if (i == a.a.dqi())
                                  {
                                    localObject3 = this.zWO;
                                    localObject1 = localObject2;
                                    if (localObject3 != null)
                                    {
                                      if (((t)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
                                      {
                                        i = 1;
                                        label6002:
                                        if (i == 0) {
                                          break label6054;
                                        }
                                      }
                                      for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                                      {
                                        localObject1 = localObject2;
                                        if (paramb == null) {
                                          break;
                                        }
                                        aEe(g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(9)))));
                                        paramb = x.aazN;
                                        localObject1 = localObject2;
                                        break;
                                        i = 0;
                                        break label6002;
                                      }
                                    }
                                  }
                                  else
                                  {
                                    AppMethodBeat.o(269511);
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
          AppMethodBeat.o(269511);
          return;
        }
        if ((paramb instanceof aj.b))
        {
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((aj.b)paramb).feedId)
            {
              i = 1;
              if (i == 0) {
                break label6376;
              }
              if (localObject1 == null) {
                break label6392;
              }
              if (((aj.b)paramb).xqw.mediaType != 2) {
                break label6382;
              }
              i = 0;
              label6134:
              k = ((aj.b)paramb).index;
              if (k + 1 > ((t)localObject1).zXe) {
                ((t)localObject1).zXe = (k + 1);
              }
              m = ((t)localObject1).dPK();
              if (m != k)
              {
                l2 = cm.bfE();
                l1 = l2 - localObject1.dPH()[localObject1.dPK()];
                n = localObject1.dPI()[localObject1.dPK()];
                i1 = localObject1.dPJ()[localObject1.dPK()];
                ((t)localObject1).zWZ[m] = l1;
                ((t)localObject1).dPH()[k] = l2;
                ((t)localObject1).zXc = k;
                localObject2 = getContextObj();
                l2 = ((t)localObject1).getFeedId();
                if (!((aj.b)paramb).zZB) {
                  break label6387;
                }
              }
            }
            label6376:
            label6382:
            label6387:
            for (j = 1;; j = 0)
            {
              g.a.a((bid)localObject2, l2, 4, String.valueOf(g.a.a(4, new String[] { String.valueOf(l1), String.valueOf(m), String.valueOf(k), String.valueOf(i), String.valueOf(n), String.valueOf(i1), String.valueOf(j) })), 0L, null, 48);
              dPG();
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
              break label6113;
              i = 1;
              break label6134;
            }
          }
          label6392:
          AppMethodBeat.o(269511);
          return;
        }
        if ((paramb instanceof c.a)) {
          switch (((c.a)paramb).type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6566;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6572;
              }
              ((t)localObject1).zXx = paramb.dql();
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6658;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6664;
              }
              if (((t)localObject1).dPY() != 0L) {
                ((t)localObject1).zXw = (paramb.dql() - ((t)localObject1).dPY());
              }
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6734;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label6740;
              }
              ((t)localObject1).Mq(paramb.dql());
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label6831;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label6836;
              }
              paramb.dPJ()[paramb.dPK()] += 1;
              i = paramb.zXd;
              paramb.zXd = (i + 1);
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label7006;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label7012;
              }
              ((t)localObject1).zXq = ((c.a)paramb).getOffset();
              ((t)localObject1).zXB.add(Integer.valueOf(((c.a)paramb).getOffset()));
              i = (int)(100.0F * ((c.a)paramb).getOffset() / ((c.a)paramb).total);
              if (i > localObject1.dPI()[localObject1.dPK()]) {
                ((t)localObject1).dPI()[localObject1.dPK()] = i;
              }
              if (i > ((t)localObject1).zXg)
              {
                ((t)localObject1).zXf = ((c.a)paramb).getOffset();
                ((t)localObject1).zXg = i;
              }
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label7122;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label7128;
              }
              ((t)localObject1).zXp += 1;
              if (((t)localObject1).dPX() != 0L)
              {
                ((t)localObject1).zXu += paramb.dql() - ((t)localObject1).dPX();
                ((t)localObject1).Mq(0L);
              }
              paramb = x.aazN;
              AppMethodBeat.o(269511);
              return;
              i = 0;
              break;
              localObject1 = null;
            }
          }
          AppMethodBeat.o(269511);
          return;
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label7260;
            }
            i = 1;
            if (i == 0) {
              break label7265;
            }
            if (localObject1 != null)
            {
              ((t)localObject1).zXz = 1;
              localObject1 = x.aazN;
            }
          }
          if (((c.a)paramb).xqw != null)
          {
            if (((c.a)paramb).dqj() <= ((c.a)paramb).dqk()) {
              break label7271;
            }
            g.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(g.a.a(15, new String[] { "-1" })), 0L, null, 48);
          }
          for (;;)
          {
            paramb = x.aazN;
            AppMethodBeat.o(269511);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label7168;
            if (((c.a)paramb).dqj() < ((c.a)paramb).dqk()) {
              g.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(g.a.a(15, new String[] { "1" })), 0L, null, 48);
            }
          }
          localObject1 = this.zWO;
          if (localObject1 != null)
          {
            if (((t)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label7390;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label7393;
              }
              paramb.zXy = 1;
              paramb = x.aazN;
              AppMethodBeat.o(269511);
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
    AppMethodBeat.i(269504);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(269504);
      return true;
    }
    if ((paramb instanceof aj.b))
    {
      AppMethodBeat.o(269504);
      return true;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.j))
    {
      AppMethodBeat.o(269504);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(269504);
      return true;
    }
    AppMethodBeat.o(269504);
    return false;
  }
  
  public final void aEe(String paramString)
  {
    AppMethodBeat.i(269522);
    p.k(paramString, "feedActionValue");
    t localt = this.zWO;
    if (localt != null)
    {
      Log.i(TAG, "sendExtStatsReport ".concat(String.valueOf(paramString)));
      amd localamd = new amd();
      localamd.xbk = localt.feedId;
      Object localObject = localt.xpY;
      if (localObject != null) {
        localamd.finderUsername = ((FinderItem)localObject).getUserName();
      }
      localObject = n.zWF;
      localamd.sessionBuffer = n.N(localt.feedId, this.xbu.xkX);
      localamd.Swz = paramString;
      localamd.videoDuration = localt.videoDuration;
      paramString = localt.xpY;
      if (paramString != null) {}
      for (int i = paramString.getMediaType();; i = 0)
      {
        localamd.mediaType = i;
        a.a(this.xbu, localamd);
        AppMethodBeat.o(269522);
        return;
      }
    }
    AppMethodBeat.o(269522);
  }
  
  public final void dPk()
  {
    AppMethodBeat.i(269521);
    dPj().zUW = true;
    AppMethodBeat.o(269521);
  }
  
  public LinkedList<emr> dPl()
  {
    AppMethodBeat.i(269513);
    if (this.zWK.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.zWK);
      this.zWK.clear();
      w localw = w.zYO;
      w.a((List)localLinkedList, this.xbu, 0);
      AppMethodBeat.o(269513);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(269513);
    return localLinkedList;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(269520);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(269520);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(269505);
    onExit();
    super.onRelease();
    AppMethodBeat.o(269505);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(269519);
    super.onVisible();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)dsB());
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).Bnr;
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
        AppMethodBeat.o(269519);
        return;
      }
    }
    AppMethodBeat.o(269519);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "", "plugin-finder_release"})
  public static final class a
  {
    public static void a(bid parambid, amd paramamd)
    {
      AppMethodBeat.i(288526);
      p.k(paramamd, "extStats");
      Log.i(s.access$getTAG$cp(), "sendExtStatsReport " + com.tencent.mm.ae.d.Fw(paramamd.xbk));
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new az(parambid, paramamd));
      AppMethodBeat.o(288526);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final int bAQ()
    {
      return 0;
    }
    
    public final long mf()
    {
      return this.xXG.id;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.s
 * JD-Core Version:    0.7.0.1
 */
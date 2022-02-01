package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dk;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.al.a;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.a.a.a;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.k;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "curAdPosterId", "", "dailyTopicMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectHotTopic;", "extActionValueList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "feedReportWatcher", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "lastCenterFeed", "getLastCenterFeed", "setLastCenterFeed", "lastFocusFeedId", "lastVisibleFeedMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLastVisibleFeedMap", "()Ljava/util/HashMap;", "setLastVisibleFeedMap", "(Ljava/util/HashMap;)V", "lastVisibleNotFeedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getLastVisibleNotFeedSet", "()Ljava/util/HashSet;", "setLastVisibleNotFeedSet", "(Ljava/util/HashSet;)V", "waitForReportStatsList", "Lcom/tencent/mm/protocal/protobuf/Stats;", "addActionValue", "", "actionValue", "afterConversationUpdate", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "checkEmptyToHotTabExpose", "messageType", "index", "checkRedDotExpose", "getAdH5Cache", "Lcom/tencent/mm/plugin/finder/feed/model/AdMutualInfo;", "record", "getDailyTopic", "feedItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "handleExtStatsRecord", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onDailyShow", "singleFeedRecord", "onEventHappen", "onExit", "onInvisible", "onRelease", "onVisible", "optExtStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "feedActionValue", "recordAd", "recordAdPosterInVisible", "recordAdPosterVisible", "reportCenterRecord", "stats", "reportDailyShow", "dailyTopic", "reportExpose", "across", "reportExtStatsInCenterSwitch", "reportFavSimilarExpose", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "resumeDataAdapter", "sendExStatsReport", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "sendExtStatsReport", "sendStatsList", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ae
  extends m
{
  public static final a Fsm;
  private static af Fsy;
  private static final String TAG;
  private ConcurrentLinkedQueue<fhp> Fsn;
  private ConcurrentLinkedQueue<String> Fso;
  private final b Fsp;
  private final int Fsq;
  af Fsr;
  private af Fss;
  HashSet<Long> Fst;
  public HashMap<Long, af> Fsu;
  private ConcurrentHashMap<Long, brm> Fsv;
  private long Fsw;
  private long Fsx;
  
  static
  {
    AppMethodBeat.i(331477);
    Fsm = new a((byte)0);
    TAG = "Finder.FinderSingleFeedFlowReporter";
    AppMethodBeat.o(331477);
  }
  
  public ae(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    super(paramMMFragmentActivity, parambui);
    AppMethodBeat.i(331348);
    this.Fsn = new ConcurrentLinkedQueue();
    this.Fso = new ConcurrentLinkedQueue();
    paramMMFragmentActivity = new b();
    ((as)paramMMFragmentActivity).eMf();
    parambui = ah.aiuX;
    this.Fsp = paramMMFragmentActivity;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.Fsq = ((Number)com.tencent.mm.plugin.finder.storage.d.eUS().bmg()).intValue();
    this.Fst = new HashSet();
    this.Fsu = new HashMap();
    this.Fsv = new ConcurrentHashMap();
    AppMethodBeat.o(331348);
  }
  
  private final fhp a(af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(331411);
    af.e(paramaf);
    Object localObject2;
    if (!b.a(this.Fsp))
    {
      localObject1 = new StringBuilder();
      if (paramaf != null)
      {
        localObject2 = b.fA(paramaf);
        if (paramaf.hTS < 0L) {
          ((StringBuilder)localObject1).append("stayTime :" + paramaf.hTS + " startTime:" + paramaf.startTime + " endTime:" + paramaf.endTime + "\n obj:" + (String)localObject2);
        }
        if (paramaf.Fta < 0L) {
          ((StringBuilder)localObject1).append("realPlayTime :" + paramaf.Fta + " realPlayTimestamp:" + paramaf.Ftb + " endTime:" + paramaf.endTime + "\n obj:" + (String)localObject2);
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject1).toString())) {
        Log.e("FeedReportWatcher", kotlin.g.b.s.X("vertify error:\n ", localObject1));
      }
    }
    Object localObject3 = paramaf.ANj;
    long l1;
    Object localObject4;
    label281:
    label318:
    Object localObject5;
    label445:
    Object localObject6;
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        l1 = ((Number)localObject1).longValue();
        if (!this.Fsv.containsKey(Long.valueOf(l1))) {
          break label952;
        }
        localObject2 = (brm)this.Fsv.get(Long.valueOf(l1));
        localObject4 = TAG;
        if (localObject2 != null) {
          break label942;
        }
        localObject1 = null;
        Log.i((String)localObject4, kotlin.g.b.s.X("get from cache: ", localObject1));
        localObject1 = localObject2;
        if ((localObject3 != null) && (localObject1 != null))
        {
          if (((brm)localObject1).ZZL <= 0) {
            break label1027;
          }
          i = 1;
          localObject2 = z.FrZ;
          l1 = ((FinderItem)localObject3).getFeedObject().id;
          l2 = ((brm)localObject1).ADo;
          localObject2 = ((brm)localObject1).xUk;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          z.a(l1, 1L, l2, (String)localObject1, i, this.Auc.AJo);
        }
      }
      localObject1 = af.FsA;
      localObject2 = af.a.a(paramaf, this.Auc);
      if (paramaf.ANj == null) {
        break label1071;
      }
      l1 = paramaf.endTime;
      long l2 = paramaf.startTime;
      localObject1 = z.FrZ;
      localObject1 = z.p(paramaf.feedId, this.Auc.AJo);
      if (localObject1 != null) {
        break label1032;
      }
      localObject1 = "";
      localObject3 = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      localObject4 = v.Y("feed_stay_time", Long.valueOf(l1 - l2));
      localObject5 = v.Y("feed_id", com.tencent.mm.ae.d.hF(paramaf.feedId));
      localObject6 = v.Y("session_buffer", localObject1);
      r localr1 = v.Y("session_id", this.Auc.sessionId);
      r localr2 = v.Y("context_id", this.Auc.zIO);
      r localr3 = v.Y("click_tab_context_id", this.Auc.zIB);
      r localr4 = v.Y("extra_info", this.Auc.extraInfo);
      r localr5 = v.Y("enter_source_info", this.Auc.zIE);
      r localr6 = v.Y("comment_scene", Integer.valueOf(this.Auc.AJo));
      localObject1 = paramaf.ANj;
      if (localObject1 != null) {
        break label1061;
      }
      localObject1 = null;
      label604:
      ((com.tencent.mm.plugin.datareport.a.b)localObject3).a("feed_out", null, ak.e(new r[] { localObject4, localObject5, localObject6, localr1, localr2, localr3, localr4, localr5, localr6, v.Y("finder_username", localObject1) }), 24617);
      m.a.a(this.Auc, paramaf.feedId, 14, String.valueOf(paramaf.endTime - paramaf.startTime), 0L, null, 48);
      label715:
      m.a.a(this.Auc, paramaf, 2);
      if (!paramBoolean) {
        break label1488;
      }
      localObject1 = paramaf.ANj;
      if (localObject1 == null) {
        break label1156;
      }
      localObject4 = ((FinderItem)localObject1).getFoldedLayout();
      if ((localObject4 == null) || (((axn)localObject4).lNX <= 0)) {
        break label1156;
      }
      localObject1 = paramaf.AOo;
      if (localObject1 != null) {
        break label1083;
      }
      localObject1 = null;
    }
    label1027:
    for (;;)
    {
      label773:
      if (localObject1 == null)
      {
        localObject1 = paramaf.AOo;
        if (localObject1 != null)
        {
          localObject3 = new LongSparseArray();
          localObject4 = ((axn)localObject4).ZIQ;
          kotlin.g.b.s.s(localObject4, "it.objects");
          localObject4 = ((Iterable)localObject4).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((Iterator)localObject4).next();
              if (i < 0) {
                kotlin.a.p.kkW();
              }
              localObject5 = (FinderObject)localObject5;
              if (i <= 2)
              {
                localObject6 = new com.tencent.mm.view.recyclerview.n((com.tencent.mm.view.recyclerview.a)new d((FinderObject)localObject5));
                ((com.tencent.mm.view.recyclerview.n)localObject6).AOn = i;
                ((LongSparseArray)localObject3).put(((FinderObject)localObject5).id, localObject6);
              }
              i += 1;
              continue;
              localObject1 = ((FinderItem)localObject3).getFeedObject();
              if (localObject1 == null)
              {
                localObject1 = null;
                break;
              }
              localObject1 = Long.valueOf(((FinderObject)localObject1).id);
              break;
              label942:
              localObject1 = ((brm)localObject2).xUk;
              break label281;
              label952:
              localObject2 = l((FinderItem)localObject3);
              if (localObject2 != null) {
                ((Map)this.Fsv).put(Long.valueOf(l1), localObject2);
              }
              localObject4 = TAG;
              if (localObject2 == null) {}
              for (localObject1 = null;; localObject1 = ((brm)localObject2).xUk)
              {
                Log.i((String)localObject4, kotlin.g.b.s.X("get from feed update map: ", localObject1));
                localObject1 = localObject2;
                break;
              }
              i = 0;
              break label318;
              label1032:
              localObject1 = kotlin.n.n.bV((String)localObject1, ",", ";");
              if (localObject1 == null)
              {
                localObject1 = "";
                break label445;
              }
              break label445;
              label1061:
              localObject1 = ((FinderItem)localObject1).getUserName();
              break label604;
              label1071:
              Log.i(TAG, "local feed ignore");
              break label715;
              label1083:
              localObject1 = ((l)localObject1).agOy;
              break label773;
            }
          }
          localObject4 = ah.aiuX;
          ((l)localObject1).agOy = ((LongSparseArray)localObject3);
        }
      }
    }
    m.a.a(this.Auc, paramaf);
    Object localObject1 = paramaf.AOo;
    if (localObject1 != null)
    {
      localObject1 = ((l)localObject1).agOz;
      if (localObject1 != null)
      {
        localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((WxRecyclerAdapter)localObject1).onPause();
        }
      }
    }
    label1156:
    localObject1 = paramaf.ANj;
    label1170:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((!Util.isNullOrNil((List)localObject1)) && (this.Fsq == 1)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(21346, new Object[] { com.tencent.mm.ae.d.hF(paramaf.feedId), Integer.valueOf(this.Auc.AJo), this.Auc.sessionId, this.Auc.zIO, this.Auc.zIB });
      }
      localObject1 = paramaf.Ftm;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = (BaseFinderFeed)localObject1;
        if (localObject3 != null) {
          break label1574;
        }
        localObject1 = null;
        label1289:
        if (localObject1 != null)
        {
          localObject1 = z.FrZ;
          l1 = ((BaseFinderFeed)localObject3).bZA();
          j = this.Auc.AJo;
          localObject1 = this.Auc.zIB;
          localObject4 = this.Auc.zIO;
          localObject5 = this.Auc.sessionId;
          localObject6 = z.FrZ;
          localObject6 = z.p(((BaseFinderFeed)localObject3).bZA(), this.Auc.AJo);
          localObject3 = ((BaseFinderFeed)localObject3).attachFavInfo;
          if ((localObject3 == null) || (((com.tencent.mm.plugin.finder.storage.m)localObject3).FKE != true)) {
            break label1584;
          }
          i = 1;
          label1387:
          if (i == 0) {
            break label1589;
          }
        }
      }
    }
    label1574:
    label1584:
    label1589:
    for (int i = 1;; i = 2)
    {
      z.a(l1, j, (String)localObject1, (String)localObject4, (String)localObject5, (String)localObject6, i);
      localObject1 = paramaf.Ftm;
      if ((localObject1 != null) && ((localObject1 instanceof BaseFinderFeed)))
      {
        localObject3 = av.GiL;
        if (av.I(((BaseFinderFeed)localObject1).feedObject))
        {
          localObject3 = z.FrZ;
          z.a(this.Auc, paramaf.feedId, Integer.valueOf(((BaseFinderFeed)localObject1).feedObject.getFeedObject().follow_feed_count));
        }
      }
      AppMethodBeat.o(331411);
      return localObject2;
      label1488:
      localObject1 = paramaf.AOo;
      if ((localObject1 == null) || ((!((l)localObject1).agOw) && (!((l)localObject1).agOx))) {
        break;
      }
      m.a.a(this.Auc, paramaf);
      ((l)localObject1).agOx = false;
      localObject1 = ((l)localObject1).agOz;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        break;
      }
      ((WxRecyclerAdapter)localObject1).onPause();
      break;
      localObject1 = ((FinderItem)localObject1).getLongVideoMediaList();
      break label1170;
      localObject1 = ((BaseFinderFeed)localObject3).attachFavInfo;
      break label1289;
      i = 0;
      break label1387;
    }
  }
  
  private final void a(af paramaf, fhp paramfhp)
  {
    AppMethodBeat.i(331373);
    if (paramaf.FsJ > 0) {
      m.a.a(this.Auc, paramaf.feedId, 5, String.valueOf(paramaf.FsJ), paramaf.hlB, null, 32);
    }
    long l = paramaf.endTime - paramaf.startTime;
    Object localObject1 = z.FrZ;
    localObject1 = z.p(paramaf.feedId, this.Auc.AJo);
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      localObject3 = v.Y("feed_stay_time", Long.valueOf(l));
      r localr1 = v.Y("feed_id", com.tencent.mm.ae.d.hF(paramaf.feedId));
      r localr2 = v.Y("session_buffer", localObject1);
      r localr3 = v.Y("session_id", this.Auc.sessionId);
      r localr4 = v.Y("context_id", this.Auc.zIO);
      r localr5 = v.Y("click_tab_context_id", this.Auc.zIB);
      r localr6 = v.Y("extra_info", this.Auc.extraInfo);
      r localr7 = v.Y("enter_source_info", this.Auc.zIE);
      r localr8 = v.Y("comment_scene", Integer.valueOf(this.Auc.AJo));
      localObject1 = paramaf.ANj;
      if (localObject1 != null) {
        break label882;
      }
      localObject1 = null;
      label235:
      ((com.tencent.mm.plugin.datareport.a.b)localObject2).a("feed_stay", null, ak.e(new r[] { localObject3, localr1, localr2, localr3, localr4, localr5, localr6, localr7, localr8, v.Y("finder_username", localObject1) }), 24617);
      m.a.a(this.Auc, paramaf.feedId, 2, String.valueOf(l), paramaf.hlB, null, 32);
      if (paramaf.FsM > 0) {
        m.a.a(this.Auc, paramaf.feedId, 11, String.valueOf(paramaf.FsM), paramaf.hlB, null, 32);
      }
      localObject1 = this.Auc;
      l = paramaf.feedId;
      paramfhp = paramfhp.abIh;
      if (paramfhp != null) {
        break label892;
      }
      paramfhp = "";
      label398:
      m.a.a((bui)localObject1, l, 3, String.valueOf(paramfhp), paramaf.hlB, null, 32);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("netType", paramaf.netType);
      ((JSONObject)localObject1).put("isPause", paramaf.Fte);
      ((JSONObject)localObject1).put("isSeek", paramaf.Ftf);
      ((JSONObject)localObject1).put("playProgressInfo", paramaf.Ftg);
      ((JSONObject)localObject1).put("maxPlayPercent", paramaf.FsM);
      ((JSONObject)localObject1).put("maxPlayLength", paramaf.FsL);
      ((JSONObject)localObject1).put("videoDuration", paramaf.videoDuration);
      ((JSONObject)localObject1).put("playTime", paramaf.Ftc);
      ((JSONObject)localObject1).put("realPlayTime", paramaf.Fta);
      ((JSONObject)localObject1).put("voiceInfo", paramaf.Ftk);
      ((JSONObject)localObject1).put("playFormat", paramaf.Ftl);
      paramfhp = this.Auc;
      l = paramaf.feedId;
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "playInfoObj.toString()");
      m.a.a(paramfhp, l, 17, kotlin.n.n.bV((String)localObject1, ",", ";"), paramaf.hlB, null, 32);
      paramfhp = d.FnC;
      paramfhp = d.pz(paramaf.feedId);
      if (!Util.isNullOrNil(paramfhp)) {
        m.a.a(this.Auc, paramaf.feedId, 18, paramfhp, paramaf.hlB, null, 32);
      }
      m.a.a(this.Auc, paramaf, 1);
      localObject2 = this.Auc;
      kotlin.g.b.s.u(localObject2, "contextObj");
      kotlin.g.b.s.u(paramaf, "record");
      if ((paramaf.ANj != null) && (paramaf.ANj.getShowExtendLink()))
      {
        localObject3 = new dk();
        ((dk)localObject3).nr(com.tencent.mm.ae.d.hF(paramaf.ANj.field_id));
        ((dk)localObject3).ns(((bui)localObject2).sessionId);
        ((dk)localObject3).nt(((bui)localObject2).zIO);
        paramfhp = paramaf.ANj;
        if (paramfhp != null) {
          break label903;
        }
        paramfhp = "";
        label764:
        ((dk)localObject3).nu(paramfhp);
        ((dk)localObject3).izD = 1L;
        ((dk)localObject3).ioV = 1L;
        ((dk)localObject3).nv(((bui)localObject2).zIB);
        ((dk)localObject3).iwD = ((bui)localObject2).AJo;
        paramfhp = z.FrZ;
        paramaf = paramaf.ANj;
        if (paramaf != null) {
          break label940;
        }
      }
    }
    label903:
    label940:
    for (l = 0L;; l = paramaf.getId())
    {
      ((dk)localObject3).nw(z.p(l, ((bui)localObject2).AJo));
      ((dk)localObject3).bMH();
      eNd();
      AppMethodBeat.o(331373);
      return;
      localObject1 = kotlin.n.n.m((String)localObject1, ",", ";", false);
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      break;
      label882:
      localObject1 = ((FinderItem)localObject1).getUserName();
      break label235;
      label892:
      paramfhp = Long.valueOf(paramfhp.YPj);
      break label398;
      paramfhp = paramfhp.getExtReading();
      if (paramfhp == null)
      {
        paramfhp = "";
        break label764;
      }
      localObject1 = paramfhp.link;
      paramfhp = (fhp)localObject1;
      if (localObject1 != null) {
        break label764;
      }
      paramfhp = "";
      break label764;
    }
  }
  
  private final void azW(String paramString)
  {
    AppMethodBeat.i(331436);
    this.Fso.add(paramString);
    AppMethodBeat.o(331436);
  }
  
  private final void c(af paramaf)
  {
    AppMethodBeat.i(331417);
    com.tencent.mm.plugin.finder.feed.model.a locala = d(paramaf);
    if (locala != null) {
      if (paramaf != null) {
        break label40;
      }
    }
    label40:
    for (long l = 0L;; l = paramaf.feedId)
    {
      this.Fsx = l;
      locala.edE();
      AppMethodBeat.o(331417);
      return;
    }
  }
  
  private static com.tencent.mm.plugin.finder.feed.model.a d(af paramaf)
  {
    int j = 0;
    AppMethodBeat.i(331423);
    Object localObject = com.tencent.mm.plugin.finder.utils.g.GfZ;
    int i;
    if (paramaf == null)
    {
      i = j;
      if (!com.tencent.mm.plugin.finder.utils.g.io(i, 1)) {
        break label122;
      }
      localObject = com.tencent.mm.plugin.finder.feed.model.g.BeY;
      localObject = com.tencent.mm.plugin.finder.feed.model.g.edK();
      if (paramaf != null) {
        break label106;
      }
    }
    label106:
    for (long l = 0L;; l = paramaf.feedId)
    {
      paramaf = ((e)localObject).nz(l);
      if (!(paramaf instanceof com.tencent.mm.plugin.finder.feed.model.a)) {
        break label114;
      }
      paramaf = (com.tencent.mm.plugin.finder.feed.model.a)paramaf;
      AppMethodBeat.o(331423);
      return paramaf;
      localObject = paramaf.ANj;
      i = j;
      if (localObject == null) {
        break;
      }
      localObject = ((FinderItem)localObject).getFeedObject();
      i = j;
      if (localObject == null) {
        break;
      }
      i = ((FinderObject)localObject).adFlag;
      break;
    }
    label114:
    AppMethodBeat.o(331423);
    return null;
    label122:
    AppMethodBeat.o(331423);
    return null;
  }
  
  private HashSet<Long> eNc()
  {
    return this.Fst;
  }
  
  private final void eNd()
  {
    AppMethodBeat.i(331434);
    Object localObject1 = this.Fsr;
    if (localObject1 != null)
    {
      if (((af)localObject1).Ftf > 0) {
        azW(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(13)))));
      }
      if (((af)localObject1).FsY > 0) {
        azW(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(14)))));
      }
    }
    localObject1 = eMu();
    if (((m.b)localObject1).FpE) {
      azW(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(11)))));
    }
    if (((m.b)localObject1).FpD) {
      azW(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(12)))));
    }
    localObject1 = eMu();
    ((m.b)localObject1).FpD = false;
    ((m.b)localObject1).FpE = false;
    Object localObject2 = new LinkedList();
    if (this.Fsr != null)
    {
      Iterator localIterator = ((Iterable)this.Fso).iterator();
      label330:
      label360:
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        Log.i(TAG, kotlin.g.b.s.X("reportExtStatsInCenterSwitch action: ", localObject3));
        kotlin.g.b.s.s(localObject3, "it");
        if (!Util.isNullOrNil((String)localObject3))
        {
          af localaf = this.Fsr;
          if (localaf != null)
          {
            localObject1 = new aps();
            ((aps)localObject1).hKN = localaf.feedId;
            Object localObject4 = localaf.ANj;
            if (localObject4 != null) {
              ((aps)localObject1).finderUsername = ((FinderItem)localObject4).getUserName();
            }
            localObject4 = z.FrZ;
            ((aps)localObject1).sessionBuffer = z.p(localaf.feedId, this.Auc.AJo);
            ((aps)localObject1).ZwW = ((String)localObject3);
            ((aps)localObject1).videoDuration = localaf.videoDuration;
            localObject3 = localaf.ANj;
            if (localObject3 == null)
            {
              i = 0;
              ((aps)localObject1).mediaType = i;
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label360;
          }
          ((LinkedList)localObject2).add(localObject1);
          break;
          i = ((FinderItem)localObject3).getMediaType();
          break label330;
          localObject1 = null;
        }
      }
      this.Fso.clear();
      if (((Collection)localObject2).isEmpty()) {
        break label455;
      }
    }
    label455:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.Auc;
        localObject2 = (List)localObject2;
        kotlin.g.b.s.u(localObject2, "extStats");
        Log.i(TAG, kotlin.g.b.s.X("sendExtStatsReport ", Integer.valueOf(((List)localObject2).size())));
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new bu((bui)localObject1, 18054, (List)localObject2), 0);
      }
      AppMethodBeat.o(331434);
      return;
    }
  }
  
  private final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331428);
    z localz = z.FrZ;
    z.a(1, paramInt1, paramInt2, this.Auc);
    AppMethodBeat.o(331428);
  }
  
  private static brm l(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(331438);
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.getFeedObject().hotTopics;
      if (paramFinderItem == null) {}
      for (paramFinderItem = null; paramFinderItem != null; paramFinderItem = paramFinderItem.topics)
      {
        paramFinderItem = paramFinderItem.iterator();
        brm localbrm;
        do
        {
          if (!paramFinderItem.hasNext()) {
            break;
          }
          localbrm = (brm)paramFinderItem.next();
        } while ((localbrm == null) || (localbrm.ZZK != 5));
        AppMethodBeat.o(331438);
        return localbrm;
      }
    }
    AppMethodBeat.o(331438);
    return null;
  }
  
  private final void onExit()
  {
    AppMethodBeat.i(331354);
    as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    com.tencent.mm.ae.d.e(com.tencent.mm.plugin.finder.viewmodel.component.as.foC(), (kotlin.g.a.a)new c(this));
    c(this.Fsr);
    AppMethodBeat.o(331354);
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331607);
    kotlin.g.b.s.u(paramb, "event");
    super.a(paramb);
    Object localObject2 = this.Auc;
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject1 = as.a.hu((Context)dUP());
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).DUN)
    {
      ((bui)localObject2).DUN = ((String)localObject1);
      if (!(paramb instanceof k)) {
        break label2642;
      }
      if (this.visible) {
        break;
      }
      Log.i(TAG, this.Auc.AJo + " not visible");
      AppMethodBeat.o(331607);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    label485:
    long l1;
    label521:
    long l2;
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
      if ((this.Fsw != ((k)paramb).AOv) && (((k)paramb).type == 6))
      {
        localObject1 = z.FrZ;
        localObject1 = z.q(((k)paramb).AOv, this.Auc.AJo);
        if (localObject1 != null)
        {
          ((bd)localObject1).FuM.ZZc = cn.bDw();
          localObject1 = ((bd)localObject1).FuM;
          ((bra)localObject1).ZZd += 1;
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        this.Fsw = ((k)paramb).AOv;
      }
      if ((((k)paramb).AIv == ((k)paramb).AOv) && (((k)paramb).vIj == ((k)paramb).AOr) && (((k)paramb).vIk == ((k)paramb).AOt)) {
        break label1676;
      }
      localObject2 = new HashMap();
      if (((k)paramb).AIv == ((k)paramb).AOv) {
        break label791;
      }
      localObject1 = this.Fsr;
      if (localObject1 != null)
      {
        ((af)localObject1).a(this.FpB);
        localObject3 = af.FsA;
        localObject3 = af.a.a((af)localObject1, this.Auc);
        ((Map)localObject2).put(Long.valueOf(((af)localObject1).getFeedId()), localObject3);
        a((af)localObject1, (fhp)localObject3);
      }
      switch (((k)paramb).getType())
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        localObject1 = ((k)paramb).dYR();
        if (localObject1 == null) {
          break label784;
        }
        localObject3 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject3).next();
        } while (((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYK().bZA() != ((k)paramb).dYP());
        l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYK().bZA();
        l2 = paramb.dYH();
        if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYK() instanceof BaseFinderFeed)) {
          break;
        }
      }
    }
    for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYK()).eDf();; localObject1 = null)
    {
      localObject1 = new af(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYM(), true, eMv(), null, 64);
      ((af)localObject1).SG(((com.tencent.mm.plugin.finder.event.base.g)localObject4).dYL());
      localObject4 = ah.aiuX;
      this.Fsr = ((af)localObject1);
      this.Fss = this.Fsr;
      break label521;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next()).AOm);
      }
      localObject1 = (List)localObject1;
      break;
      azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(1)))));
      localObject1 = ah.aiuX;
      break label485;
    }
    localObject1 = ah.aiuX;
    label784:
    Fsy = this.Fsr;
    label791:
    Object localObject4 = new HashSet();
    Object localObject3 = new HashSet();
    ((HashSet)localObject4).addAll((Collection)this.Fsu.keySet());
    localObject1 = ((k)paramb).dYR();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
        ((HashSet)localObject4).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA()));
        ((HashSet)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA()));
      }
      localObject1 = ah.aiuX;
    }
    localObject1 = ((k)paramb).AOA;
    Object localObject6;
    if (localObject1 != null)
    {
      localObject5 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject5).next();
        if (!((HashSet)localObject4).contains(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK().bZA())))
        {
          l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK().bZA();
          l2 = paramb.dYH();
          if ((((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK() instanceof BaseFinderFeed)) {}
          for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK()).eDf();; localObject1 = null)
          {
            localObject1 = new af(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYM(), false, null, null, 112);
            ((af)localObject1).g(((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK());
            this.Fsp.a((af)localObject1);
            this.Fsp.a(((com.tencent.mm.plugin.finder.event.base.g)localObject6).dYK(), "acrossFeedList ", (af)localObject1);
            a((af)localObject1, true);
            this.Fsp.b((af)localObject1);
            localObject1 = ah.aiuX;
            break;
          }
        }
      }
      localObject1 = ah.aiuX;
    }
    localObject1 = ((Map)this.Fsu).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject1).next();
      if (!((HashSet)localObject3).contains(((Map.Entry)localObject4).getKey()))
      {
        a((af)((Map.Entry)localObject4).getValue(), false);
        this.Fsp.b((af)((Map.Entry)localObject4).getValue());
      }
    }
    localObject3 = new HashMap();
    localObject1 = ((k)paramb).dYR();
    if (localObject1 != null)
    {
      localObject4 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject4).next();
        localObject1 = (af)this.Fsu.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA()));
        if (localObject1 == null)
        {
          localObject1 = null;
          label1309:
          if (localObject1 != null) {
            break label1491;
          }
          localObject6 = (ae)this;
          l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA();
          l2 = paramb.dYH();
          if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK() instanceof BaseFinderFeed)) {
            break label1493;
          }
        }
        label1491:
        label1493:
        for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK()).eDf();; localObject1 = null)
        {
          localObject1 = new af(l1, l2, (FinderItem)localObject1, ((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYM(), false, null, null, 112);
          ((af)localObject1).g(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK());
          ((af)localObject1).SG(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYL());
          ((ae)localObject6).Fsp.a((af)localObject1);
          ((ae)localObject6).Fsp.a(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK(), "lastVisibleFeedMap ", (af)localObject1);
          ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA()), localObject1);
          break;
          ((af)localObject1).g(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK());
          ((HashMap)localObject3).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.base.g)localObject5).dYK().bZA()), localObject1);
          break label1309;
          break;
        }
      }
      localObject1 = ah.aiuX;
    }
    this.Fsu = ((HashMap)localObject3);
    if (!((Map)localObject2).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Fsn.addAll(((HashMap)localObject2).values());
      }
      if (this.Fsn.size() > 20)
      {
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        com.tencent.mm.ae.d.e(com.tencent.mm.plugin.finder.viewmodel.component.as.foC(), (kotlin.g.a.a)new ae.b(this));
      }
      localObject1 = TAG;
      localObject3 = (Iterable)this.Fsn;
      localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ae.d.hF(((fhp)((Iterator)localObject3).next()).hKN));
      }
    }
    Log.i((String)localObject1, kotlin.g.b.s.X("waitForReportStatsList ", (List)localObject2));
    label1676:
    label1988:
    int m;
    int n;
    int i1;
    int i2;
    int k;
    if ((((k)paramb).dYQ() != ((k)paramb).dYN()) || (((k)paramb).dYI() != ((k)paramb).dYO()))
    {
      localObject1 = ((k)paramb).dYS();
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (cc)((Iterator)localObject2).next();
            if (!eNc().contains(Long.valueOf(((cc)localObject1).bZA()))) {
              switch (((cc)localObject1).bZB())
              {
              default: 
                break;
              case -7: 
              case -1: 
                if ((getContextObj().AJo == 17) || (getContextObj().AJo == 18)) {
                  ih(1, 0);
                }
                break;
              case 2011: 
                if (getContextObj().AJo == 17)
                {
                  localObject1 = al.ALb;
                  ih(2, al.a.Nj(3));
                }
                else if (getContextObj().AJo == 18)
                {
                  localObject1 = al.ALb;
                  ih(2, al.a.Nj(1));
                }
                break;
              case -5: 
                if ((getContextObj().AJo == 17) || (getContextObj().AJo == 18) || (getContextObj().AJo == 20))
                {
                  localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
                  localObject1 = as.a.hu((Context)dUP());
                  if (localObject1 != null) {
                    if (((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fop())
                    {
                      if (localObject1 == null) {
                        break label2290;
                      }
                      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1);
                      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.event.base.f)localObject1).vIj > 1)) {
                        continue;
                      }
                      localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLWxBubble");
                      localObject1 = "";
                      if (localObject3 != null)
                      {
                        m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcq, 0);
                        n = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcs, 0);
                        i1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adct, 0);
                        i2 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcu, 0);
                        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
                        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
                          break label2292;
                        }
                        k = 5;
                        if (n <= 0) {
                          break label7087;
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
    label2726:
    label4141:
    label6958:
    label7087:
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
        localObject1 = z.FrZ;
        localObject1 = z.gO((Context)dUP());
        j = i;
        i = k;
        for (;;)
        {
          localObject4 = z.FrZ;
          z.a((String)localObject1, i, 1, 2, j, m + n + i1 + i2, ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject3).field_tipsId, null, 0L, getContextObj(), 0, 0, 3456);
          localObject4 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLWxBubble");
          if ((localObject3 == null) || (localObject4 == null)) {
            break;
          }
          w.a(w.FrV, (String)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject3, (bxq)localObject4, 1, getContextObj(), 0, null, 0, 480);
          break;
          localObject1 = null;
          break label1988;
          label2290:
          break;
          label2292:
          localObject1 = "2";
          i = 1;
          j = 1;
        }
        localObject1 = ah.aiuX;
        this.Fst = new HashSet();
        localObject2 = ((k)paramb).dYS();
        if (localObject2 != null)
        {
          localObject1 = eNc();
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(Long.valueOf(((cc)((Iterator)localObject3).next()).bZA()));
          }
          ((HashSet)localObject1).addAll((Collection)localObject2);
        }
        localObject1 = ((k)paramb).dYR();
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject2).next();
            localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).dYM();
            if (localObject3 != null)
            {
              if (((l)localObject3).agOx)
              {
                localObject4 = getContextObj();
                l1 = ((com.tencent.mm.plugin.finder.event.base.g)localObject1).dYK().bZA();
                l2 = paramb.dYH();
                if (!(((com.tencent.mm.plugin.finder.event.base.g)localObject1).dYK() instanceof BaseFinderFeed)) {
                  break label2625;
                }
              }
              label2625:
              for (localObject1 = ((BaseFinderFeed)((com.tencent.mm.plugin.finder.event.base.g)localObject1).dYK()).eDf();; localObject1 = null)
              {
                m.a.a((bui)localObject4, new af(l1, l2, (FinderItem)localObject1, (l)localObject3, false, null, null, 112));
                ((l)localObject3).agOx = false;
                localObject1 = ((l)localObject3).agOz;
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
              }
            }
          }
          paramb = ah.aiuX;
        }
        AppMethodBeat.o(331607);
        return;
        label2642:
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
          a.a.a locala2 = a.a.ANi;
          if (i == a.a.dYl())
          {
            localObject1 = this.Fsr;
            if (localObject1 != null) {
              if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
              {
                i = 1;
                if (i == 0) {
                  break label2911;
                }
                if (localObject1 == null) {
                  break label2917;
                }
                ((af)localObject1).SH(((af)localObject1).eNi() + 1);
                i = ((af)localObject1).eNn();
                ((af)localObject1).SM(i + 1);
                localObject1 = locala1;
                localObject2 = getContextObj();
                l1 = ((a.a)paramb).getFeedId();
                localObject3 = m.c.FpF;
                m.a.a((bui)localObject2, l1, 1, m.c.eMy(), 0L, null, 48);
                localObject2 = getContextObj();
                l1 = ((a.a)paramb).getFeedId();
                paramb = com.tencent.mm.model.z.bAM();
                kotlin.g.b.s.s(paramb, "getUsernameFromUserInfo()");
                paramb = m.a.a(10, new String[] { "1", paramb }).toString();
                kotlin.g.b.s.s(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                m.a.a((bui)localObject2, l1, 10, paramb, 0L, null, 48);
              }
            }
          }
          label2911:
          label2917:
          label3450:
          label3454:
          label5119:
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
                    paramb = af.a.a((af)localObject1, getContextObj());
                    this.Fsn.add(paramb);
                  }
                  AppMethodBeat.o(331607);
                  return;
                  i = 0;
                  break;
                  localObject1 = null;
                  break label2726;
                  l1 = ((a.a)paramb).getFeedId();
                  l2 = paramb.dYH();
                  localObject1 = z.FrZ;
                  localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                  ((af)localObject1).SH(((af)localObject1).eNi() + 1);
                  ((af)localObject1).SM(((af)localObject1).eNn() + 1);
                  localObject2 = ah.aiuX;
                  localObject2 = ah.aiuX;
                  break label2761;
                  locala1 = a.a.ANi;
                  if (i == a.a.dYk())
                  {
                    localObject2 = this.Fsr;
                    if (localObject2 != null) {
                      if (((af)localObject2).getFeedId() == ((a.a)paramb).getFeedId())
                      {
                        i = 1;
                        if (i == 0) {
                          break label3225;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (localObject2 == null)
                      {
                        l1 = ((a.a)paramb).getFeedId();
                        l2 = paramb.dYH();
                        localObject1 = z.FrZ;
                        localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                        localObject2 = ah.aiuX;
                      }
                      localObject2 = ah.aiuX;
                      localObject2 = getContextObj();
                      l1 = ((a.a)paramb).getFeedId();
                      localObject3 = m.c.FpF;
                      m.a.a((bui)localObject2, l1, 1, m.c.a.eMz(), 0L, null, 48);
                      localObject2 = getContextObj();
                      l1 = ((a.a)paramb).getFeedId();
                      paramb = com.tencent.mm.model.z.bAM();
                      kotlin.g.b.s.s(paramb, "getUsernameFromUserInfo()");
                      paramb = m.a.a(10, new String[] { "2", paramb }).toString();
                      kotlin.g.b.s.s(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                      m.a.a((bui)localObject2, l1, 10, paramb, 0L, null, 48);
                      break;
                      i = 0;
                      break label3044;
                      localObject2 = null;
                    }
                  }
                  localObject1 = a.a.ANi;
                  if (i == a.a.dYn())
                  {
                    localObject1 = getContextObj();
                    l1 = ((a.a)paramb).getFeedId();
                    paramb = com.tencent.mm.model.z.bAM();
                    kotlin.g.b.s.s(paramb, "getUsernameFromUserInfo()");
                    paramb = m.a.a(13, new String[] { "1", paramb }).toString();
                    kotlin.g.b.s.s(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                    m.a.a((bui)localObject1, l1, 13, paramb, 0L, null, 48);
                    localObject1 = localObject2;
                  }
                  else
                  {
                    localObject1 = a.a.ANi;
                    if (i == a.a.dYm())
                    {
                      localObject1 = getContextObj();
                      l1 = ((a.a)paramb).getFeedId();
                      paramb = com.tencent.mm.model.z.bAM();
                      kotlin.g.b.s.s(paramb, "getUsernameFromUserInfo()");
                      paramb = m.a.a(13, new String[] { "2", paramb }).toString();
                      kotlin.g.b.s.s(paramb, "buildJson(ConstantsFinde…romUserInfo()).toString()");
                      m.a.a((bui)localObject1, l1, 13, paramb, 0L, null, 48);
                      localObject1 = localObject2;
                    }
                    else
                    {
                      localObject1 = a.a.ANi;
                      if (i == a.a.dYp())
                      {
                        localObject1 = this.Fsr;
                        if (localObject1 != null) {
                          if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                          {
                            i = 1;
                            if (i == 0) {
                              break label3522;
                            }
                            if (localObject1 == null) {
                              break label3528;
                            }
                            ((af)localObject1).SI(((af)localObject1).eNj() + 1);
                            localObject1 = localObject7;
                          }
                        }
                        for (;;)
                        {
                          localObject2 = getContextObj();
                          l1 = ((a.a)paramb).getFeedId();
                          paramb = m.c.FpF;
                          m.a.a((bui)localObject2, l1, 6, m.c.a.eMz(), 0L, null, 48);
                          paramb = ah.aiuX;
                          break;
                          i = 0;
                          break label3450;
                          localObject1 = null;
                          break label3454;
                          l1 = ((a.a)paramb).getFeedId();
                          l2 = paramb.dYH();
                          localObject1 = z.FrZ;
                          localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                          ((af)localObject1).SI(((af)localObject1).eNj() + 1);
                          localObject2 = ah.aiuX;
                        }
                      }
                      localObject1 = a.a.ANi;
                      if (i == a.a.dYs())
                      {
                        localObject1 = this.Fsr;
                        if (localObject1 != null) {
                          if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                          {
                            i = 1;
                            if (i == 0) {
                              break label3792;
                            }
                            if (localObject1 == null) {
                              break label3798;
                            }
                            ((af)localObject1).SJ(((af)localObject1).eNk() + 1);
                            localObject2 = localObject6;
                            localObject1 = getContextObj();
                            l1 = ((a.a)paramb).getFeedId();
                            localObject3 = m.c.FpF;
                            m.a.a((bui)localObject1, l1, 7, m.c.a.eMz(), 0L, null, 48);
                            localObject1 = ah.aiuX;
                            localObject3 = this.Fsr;
                            localObject1 = localObject2;
                            if (localObject3 == null) {
                              continue;
                            }
                            if (((af)localObject3).getFeedId() != ((a.a)paramb).getFeedId()) {
                              break label3867;
                            }
                            i = 1;
                            if (i == 0) {
                              break label3872;
                            }
                          }
                        }
                        for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                        {
                          localObject1 = localObject2;
                          if (paramb == null) {
                            break;
                          }
                          azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(4)))));
                          paramb = ah.aiuX;
                          paramb = ah.aiuX;
                          localObject1 = localObject2;
                          break;
                          i = 0;
                          break label3638;
                          localObject1 = null;
                          break label3642;
                          l1 = ((a.a)paramb).getFeedId();
                          l2 = paramb.dYH();
                          localObject1 = z.FrZ;
                          localObject2 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                          ((af)localObject2).SJ(((af)localObject2).eNk() + 1);
                          localObject1 = ah.aiuX;
                          break label3663;
                          i = 0;
                          break label3737;
                        }
                      }
                      else
                      {
                        localObject1 = a.a.ANi;
                        if (i == a.a.dYt())
                        {
                          localObject1 = this.Fsr;
                          if (localObject1 != null) {
                            if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                            {
                              i = 1;
                              if (i == 0) {
                                break label3990;
                              }
                              if (localObject1 == null) {
                                break label3996;
                              }
                              ((af)localObject1).SK(((af)localObject1).eNl() + 1);
                              localObject1 = localObject5;
                            }
                          }
                          for (;;)
                          {
                            localObject2 = getContextObj();
                            l1 = ((a.a)paramb).getFeedId();
                            paramb = m.c.FpF;
                            m.a.a((bui)localObject2, l1, 16, m.c.a.eMz(), 0L, null, 48);
                            paramb = ah.aiuX;
                            break;
                            i = 0;
                            break label3918;
                            localObject1 = null;
                            break label3922;
                            l1 = ((a.a)paramb).getFeedId();
                            l2 = paramb.dYH();
                            localObject1 = z.FrZ;
                            localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                            ((af)localObject1).SK(((af)localObject1).eNl() + 1);
                            localObject2 = ah.aiuX;
                          }
                        }
                        localObject1 = a.a.ANi;
                        if (i == a.a.dYv())
                        {
                          localObject1 = this.Fsr;
                          if (localObject1 != null) {
                            if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                            {
                              i = 1;
                              if (i == 0) {
                                break label4141;
                              }
                            }
                          }
                          for (;;)
                          {
                            if (localObject1 == null) {
                              break label4147;
                            }
                            i = ((af)localObject1).eNt();
                            ((af)localObject1).SS(i + 1);
                            localObject1 = localObject2;
                            break;
                            i = 0;
                            break label4106;
                            localObject1 = null;
                          }
                          l1 = ((a.a)paramb).getFeedId();
                          l2 = paramb.dYH();
                          localObject1 = z.FrZ;
                          localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                          ((af)localObject1).SS(((af)localObject1).eNt() + 1);
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
                              if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4330;
                                }
                                if (localObject1 == null) {
                                  break label4336;
                                }
                                i = ((af)localObject1).eNm();
                                ((af)localObject1).SL(i + 1);
                                localObject1 = localObject4;
                              }
                            }
                            for (;;)
                            {
                              localObject2 = getContextObj();
                              l1 = ((a.a)paramb).getFeedId();
                              paramb = m.c.FpF;
                              m.a.a((bui)localObject2, l1, 12, m.c.a.eMz(), 0L, null, 48);
                              break;
                              i = 0;
                              break label4260;
                              localObject1 = null;
                              break label4264;
                              l1 = ((a.a)paramb).getFeedId();
                              l2 = paramb.dYH();
                              localObject1 = z.FrZ;
                              localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                              ((af)localObject1).SL(((af)localObject1).eNm() + 1);
                              localObject2 = ah.aiuX;
                              localObject2 = ah.aiuX;
                            }
                          }
                          localObject1 = a.a.ANi;
                          if (i == a.a.dYw())
                          {
                            localObject1 = this.Fsr;
                            if (localObject1 != null) {
                              if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                              {
                                i = 1;
                                if (i == 0) {
                                  break label4486;
                                }
                              }
                            }
                            for (;;)
                            {
                              if (localObject1 == null) {
                                break label4492;
                              }
                              i = ((af)localObject1).eNp();
                              ((af)localObject1).SO(i + 1);
                              localObject1 = localObject2;
                              break;
                              i = 0;
                              break label4451;
                              localObject1 = null;
                            }
                            l1 = ((a.a)paramb).getFeedId();
                            l2 = paramb.dYH();
                            localObject1 = z.FrZ;
                            localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                            ((af)localObject1).SO(((af)localObject1).eNp() + 1);
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
                                if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                {
                                  i = 1;
                                  if (i == 0) {
                                    break label4721;
                                  }
                                  if (localObject1 == null) {
                                    break label4727;
                                  }
                                  i = ((af)localObject1).eNo();
                                  ((af)localObject1).SN(i + 1);
                                  localObject2 = localObject3;
                                  localObject3 = this.Fsr;
                                  localObject1 = localObject2;
                                  if (localObject3 == null) {
                                    continue;
                                  }
                                  if (((af)localObject3).getFeedId() != ((a.a)paramb).getFeedId()) {
                                    break label4801;
                                  }
                                  i = 1;
                                  if (i == 0) {
                                    break label4806;
                                  }
                                }
                              }
                              for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
                              {
                                localObject1 = localObject2;
                                if (paramb == null) {
                                  break;
                                }
                                azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(7)))));
                                paramb = ah.aiuX;
                                paramb = ah.aiuX;
                                localObject1 = localObject2;
                                break;
                                i = 0;
                                break label4605;
                                localObject1 = null;
                                break label4609;
                                l1 = ((a.a)paramb).getFeedId();
                                l2 = paramb.dYH();
                                localObject1 = z.FrZ;
                                localObject2 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                                ((af)localObject2).SN(((af)localObject2).eNo() + 1);
                                localObject1 = ah.aiuX;
                                localObject1 = ah.aiuX;
                                break label4632;
                                i = 0;
                                break label4665;
                              }
                            }
                            else
                            {
                              localObject1 = a.a.ANi;
                              if (i == a.a.dYy())
                              {
                                localObject1 = this.Fsr;
                                if (localObject1 != null) {
                                  if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label4887;
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  if (localObject1 == null) {
                                    break label4893;
                                  }
                                  i = ((af)localObject1).eNq();
                                  ((af)localObject1).SP(i + 1);
                                  localObject1 = localObject2;
                                  break;
                                  i = 0;
                                  break label4852;
                                  localObject1 = null;
                                }
                                l1 = ((a.a)paramb).getFeedId();
                                l2 = paramb.dYH();
                                localObject1 = z.FrZ;
                                localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                                ((af)localObject1).SP(((af)localObject1).eNq() + 1);
                                paramb = ah.aiuX;
                                paramb = ah.aiuX;
                              }
                              else
                              {
                                localObject1 = a.a.ANi;
                                if (i != a.a.dYz()) {
                                  break label5119;
                                }
                                localObject1 = this.Fsr;
                                if (localObject1 != null) {
                                  if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                                  {
                                    i = 1;
                                    if (i == 0) {
                                      break label5041;
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  if (localObject1 == null) {
                                    break label5047;
                                  }
                                  i = ((af)localObject1).eNr();
                                  ((af)localObject1).SQ(i + 1);
                                  localObject1 = localObject2;
                                  break;
                                  i = 0;
                                  break label5006;
                                  localObject1 = null;
                                }
                                l1 = ((a.a)paramb).getFeedId();
                                l2 = paramb.dYH();
                                localObject1 = z.FrZ;
                                localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                                ((af)localObject1).SQ(((af)localObject1).eNr() + 1);
                                paramb = ah.aiuX;
                                paramb = ah.aiuX;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                localObject1 = a.a.ANi;
                if (i == a.a.dYA())
                {
                  localObject1 = this.Fsr;
                  if (localObject1 != null) {
                    if (((af)localObject1).getFeedId() == ((a.a)paramb).getFeedId())
                    {
                      i = 1;
                      if (i == 0) {
                        break label5195;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (localObject1 == null) {
                      break label5201;
                    }
                    i = ((af)localObject1).eNs();
                    ((af)localObject1).SR(i + 1);
                    localObject1 = localObject2;
                    break;
                    i = 0;
                    break label5160;
                    localObject1 = null;
                  }
                  l1 = ((a.a)paramb).getFeedId();
                  l2 = paramb.dYH();
                  localObject1 = z.FrZ;
                  localObject1 = new af(l1, l2, z.jm(((a.a)paramb).getFeedId()), null, false, null, null, 120);
                  ((af)localObject1).SR(((af)localObject1).eNs() + 1);
                  localObject2 = ah.aiuX;
                  localObject2 = m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(14))));
                  localObject3 = (a.a)paramb;
                  paramb = new aps();
                  paramb.hKN = ((a.a)localObject3).feedId;
                  localObject4 = ((a.a)localObject3).ANj;
                  if (localObject4 != null) {
                    paramb.finderUsername = ((FinderItem)localObject4).getUserName();
                  }
                  localObject4 = z.FrZ;
                  paramb.sessionBuffer = z.p(((a.a)localObject3).feedId, getContextObj().AJo);
                  paramb.ZwW = ((String)localObject2);
                  if (this.Fsu.containsKey(Long.valueOf(paramb.hKN)))
                  {
                    localObject2 = (af)this.Fsu.get(Long.valueOf(paramb.hKN));
                    if (localObject2 != null)
                    {
                      paramb.videoDuration = ((af)localObject2).videoDuration;
                      localObject2 = ((af)localObject2).ANj;
                      if (localObject2 != null) {
                        break label5444;
                      }
                    }
                  }
                  for (i = 0;; i = ((FinderItem)localObject2).getMediaType())
                  {
                    paramb.mediaType = i;
                    a.b(getContextObj(), paramb);
                    paramb = ah.aiuX;
                    break;
                  }
                }
                localObject1 = a.a.ANi;
                if (i != a.a.dYB()) {
                  break label5559;
                }
                localObject3 = this.Fsr;
                localObject1 = localObject2;
              } while (localObject3 == null);
              if (((af)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
              {
                i = 1;
                if (i == 0) {
                  break label5554;
                }
              }
              for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
              {
                localObject1 = localObject2;
                if (paramb == null) {
                  break;
                }
                azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(6)))));
                paramb = ah.aiuX;
                paramb = ah.aiuX;
                localObject1 = localObject2;
                break;
                i = 0;
                break label5498;
              }
              localObject1 = a.a.ANi;
              if (i != a.a.dYC()) {
                break label5665;
              }
              localObject3 = this.Fsr;
              localObject1 = localObject2;
            } while (localObject3 == null);
            if (((af)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label5660;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
            {
              localObject1 = localObject2;
              if (paramb == null) {
                break;
              }
              azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(8)))));
              paramb = ah.aiuX;
              paramb = ah.aiuX;
              localObject1 = localObject2;
              break;
              i = 0;
              break label5604;
            }
            localObject1 = a.a.ANi;
            if (i != a.a.dYD()) {
              break label5771;
            }
            localObject3 = this.Fsr;
            localObject1 = localObject2;
          } while (localObject3 == null);
          label3044:
          label4330:
          label4336:
          label4605:
          if (((af)localObject3).getFeedId() == ((a.a)paramb).getFeedId())
          {
            i = 1;
            if (i == 0) {
              break label5766;
            }
          }
          label3798:
          label4451:
          label4721:
          label4727:
          label5498:
          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject3;; paramb = null)
          {
            localObject1 = localObject2;
            if (paramb == null) {
              break;
            }
            azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(9)))));
            paramb = ah.aiuX;
            paramb = ah.aiuX;
            localObject1 = localObject2;
            break;
            i = 0;
            break label5710;
          }
          label3922:
          label4852:
          AppMethodBeat.o(331607);
          label5604:
          return;
        }
        label2761:
        label3663:
        label3792:
        label5201:
        if ((paramb instanceof ay.b))
        {
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((ay.b)paramb).feedId) {
              break label6080;
            }
            i = 1;
            if (i == 0) {
              break label6085;
            }
            if (localObject1 != null)
            {
              if (((ay.b)paramb).ANJ.mediaType != 2) {
                break label6091;
              }
              i = 0;
              k = ((ay.b)paramb).index;
              if (k + 1 > ((af)localObject1).FsK) {
                ((af)localObject1).FsK = (k + 1);
              }
              m = ((af)localObject1).eNh();
              if (m != k)
              {
                l2 = cn.bDw();
                l1 = l2 - localObject1.eNe()[localObject1.eNh()];
                n = localObject1.eNf()[localObject1.eNh()];
                i1 = localObject1.eNg()[localObject1.eNh()];
                ((af)localObject1).FsF[m] = l1;
                ((af)localObject1).eNe()[k] = l2;
                ((af)localObject1).FsI = k;
                localObject2 = getContextObj();
                l2 = ((af)localObject1).getFeedId();
                if (!((ay.b)paramb).AAc) {
                  break label6096;
                }
              }
            }
          }
          for (j = 1;; j = 0)
          {
            m.a.a((bui)localObject2, l2, 4, String.valueOf(m.a.a(4, new String[] { String.valueOf(l1), String.valueOf(m), String.valueOf(k), String.valueOf(i), String.valueOf(n), String.valueOf(i1), String.valueOf(j) })), 0L, null, 48);
            eNd();
            paramb = ah.aiuX;
            paramb = ah.aiuX;
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label5818;
            i = 1;
            break label5839;
          }
        }
        label3522:
        label3528:
        label3918:
        label5710:
        label5839:
        label6096:
        if ((paramb instanceof c.a)) {
          switch (((c.a)paramb).type)
          {
          }
        }
        for (;;)
        {
          label3638:
          label3642:
          label4801:
          label4806:
          label5195:
          AppMethodBeat.o(331607);
          label4147:
          label4665:
          label5444:
          label6085:
          label6091:
          return;
          label5041:
          label5047:
          label5818:
          label6080:
          localObject1 = this.Fsr;
          label5554:
          label5559:
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6265;
            }
            i = 1;
            if (i == 0) {
              break label6270;
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((af)localObject1).Ftd = paramb.dYH();
              paramb = ah.aiuX;
              paramb = ah.aiuX;
            }
            AppMethodBeat.o(331607);
            return;
            label6265:
            i = 0;
            break;
            label6270:
            localObject1 = null;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6354;
            }
            i = 1;
            if (i == 0) {
              break label6359;
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              if (((af)localObject1).eNv() != 0L) {
                ((af)localObject1).Ftc = (paramb.dYH() - ((af)localObject1).eNv());
              }
              paramb = ah.aiuX;
              paramb = ah.aiuX;
            }
            AppMethodBeat.o(331607);
            return;
            label6354:
            i = 0;
            break;
            label6359:
            localObject1 = null;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6427;
            }
            i = 1;
            if (i == 0) {
              break label6432;
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((af)localObject1).pM(paramb.dYH());
              paramb = ah.aiuX;
              paramb = ah.aiuX;
            }
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6517;
            }
            i = 1;
            if (i == 0) {
              break label6522;
            }
          }
          label6517:
          label6522:
          for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
          {
            if (paramb != null)
            {
              paramb.eNg()[paramb.eNh()] += 1;
              i = paramb.FsJ;
              paramb.FsJ = (i + 1);
            }
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6689;
            }
            i = 1;
            if (i == 0) {
              break label6694;
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((af)localObject1).FsW = ((c.a)paramb).getOffset();
              ((af)localObject1).Fth.add(Integer.valueOf(((c.a)paramb).getOffset()));
              i = (int)(100.0F * ((c.a)paramb).getOffset() / ((c.a)paramb).total);
              if (i > localObject1.eNf()[localObject1.eNh()]) {
                ((af)localObject1).eNf()[localObject1.eNh()] = i;
              }
              if (i > ((af)localObject1).FsM)
              {
                ((af)localObject1).FsL = ((c.a)paramb).getOffset();
                ((af)localObject1).FsM = i;
              }
              paramb = ah.aiuX;
              paramb = ah.aiuX;
            }
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6802;
            }
            i = 1;
            if (i == 0) {
              break label6807;
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((af)localObject1).FsV += 1;
              if (((af)localObject1).eNu() != 0L)
              {
                ((af)localObject1).Fta += paramb.dYH() - ((af)localObject1).eNu();
                ((af)localObject1).pM(0L);
              }
              paramb = ah.aiuX;
              paramb = ah.aiuX;
            }
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
            localObject1 = null;
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() != ((c.a)paramb).getFeedId()) {
              break label6947;
            }
            i = 1;
            if (i == 0) {
              break label6952;
            }
            label6846:
            if (localObject1 != null)
            {
              ((af)localObject1).Ftf = 1;
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
          }
          if (((c.a)paramb).ANJ != null)
          {
            if (((c.a)paramb).dYF() <= ((c.a)paramb).dYG()) {
              break label6958;
            }
            m.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(m.a.a(15, new String[] { "-1" })), 0L, null, 48);
          }
          for (;;)
          {
            paramb = ah.aiuX;
            paramb = ah.aiuX;
            AppMethodBeat.o(331607);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label6846;
            if (((c.a)paramb).dYF() < ((c.a)paramb).dYG()) {
              m.a.a(getContextObj(), ((c.a)paramb).getFeedId(), 15, String.valueOf(m.a.a(15, new String[] { "1" })), 0L, null, 48);
            }
          }
          localObject1 = this.Fsr;
          if (localObject1 != null)
          {
            if (((af)localObject1).getFeedId() == ((c.a)paramb).getFeedId())
            {
              i = 1;
              if (i == 0) {
                break label7077;
              }
            }
            for (paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;; paramb = null)
            {
              if (paramb == null) {
                break label7080;
              }
              paramb.Fte = 1;
              paramb = ah.aiuX;
              paramb = ah.aiuX;
              break;
              i = 0;
              break label7045;
            }
          }
        }
      }
    }
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331484);
    kotlin.g.b.s.u(paramc, "dispatcher");
    kotlin.g.b.s.u(paramb, "event");
    if (super.a(paramc, paramb))
    {
      AppMethodBeat.o(331484);
      return true;
    }
    if ((paramb instanceof ay.b))
    {
      AppMethodBeat.o(331484);
      return true;
    }
    if ((paramb instanceof k))
    {
      AppMethodBeat.o(331484);
      return true;
    }
    if ((paramb instanceof a.a))
    {
      AppMethodBeat.o(331484);
      return true;
    }
    AppMethodBeat.o(331484);
    return false;
  }
  
  public final void azV(String paramString)
  {
    AppMethodBeat.i(331645);
    kotlin.g.b.s.u(paramString, "feedActionValue");
    af localaf = this.Fsr;
    aps localaps;
    if (localaf != null)
    {
      Log.i(TAG, kotlin.g.b.s.X("sendExtStatsReport ", paramString));
      localaps = new aps();
      localaps.hKN = localaf.feedId;
      Object localObject = localaf.ANj;
      if (localObject != null) {
        localaps.finderUsername = ((FinderItem)localObject).getUserName();
      }
      localObject = z.FrZ;
      localaps.sessionBuffer = z.p(localaf.feedId, this.Auc.AJo);
      localaps.ZwW = paramString;
      localaps.videoDuration = localaf.videoDuration;
      paramString = localaf.ANj;
      if (paramString != null) {
        break label145;
      }
    }
    label145:
    for (int i = 0;; i = paramString.getMediaType())
    {
      localaps.mediaType = i;
      a.b(this.Auc, localaps);
      AppMethodBeat.o(331645);
      return;
    }
  }
  
  public final void eMw()
  {
    AppMethodBeat.i(331639);
    eMu().FpD = true;
    AppMethodBeat.o(331639);
  }
  
  public LinkedList<fhp> eMx()
  {
    AppMethodBeat.i(331614);
    if (this.Fsn.size() > 0)
    {
      localLinkedList = new LinkedList((Collection)this.Fsn);
      this.Fsn.clear();
      ai localai = ai.FtE;
      ai.a((List)localLinkedList, this.Auc, 0);
      AppMethodBeat.o(331614);
      return localLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    AppMethodBeat.o(331614);
    return localLinkedList;
  }
  
  public final af eNb()
  {
    return this.Fss;
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(331629);
    super.onInvisible();
    onExit();
    AppMethodBeat.o(331629);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(331490);
    onExit();
    super.onRelease();
    AppMethodBeat.o(331490);
  }
  
  public final void onVisible()
  {
    AppMethodBeat.i(331622);
    super.onVisible();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)dUP());
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).GTv;
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
    AppMethodBeat.o(331622);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hotStreamCenterFeed", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "getHotStreamCenterFeed", "()Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "setHotStreamCenterFeed", "(Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;)V", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void b(bui parambui, aps paramaps)
    {
      AppMethodBeat.i(331397);
      kotlin.g.b.s.u(paramaps, "extStats");
      Log.i(ae.access$getTAG$cp(), kotlin.g.b.s.X("sendExtStatsReport ", com.tencent.mm.ae.d.hF(paramaps.hKN)));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new bu(parambui, 18054, paramaps), 0);
      AppMethodBeat.o(331397);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter$reportExpose$1$1$1$convertData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    d(FinderObject paramFinderObject) {}
    
    public final long bZA()
    {
      return this.AQf.id;
    }
    
    public final int bZB()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ae
 * JD-Core Version:    0.7.0.1
 */
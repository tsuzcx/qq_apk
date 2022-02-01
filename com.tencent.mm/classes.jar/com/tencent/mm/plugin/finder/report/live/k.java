package com.tencent.mm.plugin.finder.report.live;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.cw;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.g.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveReport;", "", "()V", "INVALIDATE_NEARBY_TAB_TYPE", "", "NEARBY_TAB_TYPE_ARRAY", "", "TAG", "", "fullStatic", "Lcom/tencent/mm/plugin/finder/report/live/FullFeedExploreStatics;", "isClickStartLive", "", "m21053Reporter", "Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report;", "mConfig", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig;", "_doReport21053OnClick", "", "clickData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "_doReport21053OnEnter", "enterData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "getCacheExitEvent", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "getConfig", "getCoverType", "handleLinkMicDuration", "linkType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "initBeauty", "initClickEvent", "pos", "", "commentscene", "initCommField", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderFaceVerifyStreamStruct;", "userName", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveActionStruct;", "timestamp", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveEntranceLogStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveResultStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderNoticeLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderStartLiveResultStruct;", "initEnterEvent", "initFilter", "report", "finderLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "report21017", "actionType", "actionJson", "report21024", "type", "report21053", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "visibleItemCount", "headerShow", "report21053FeedOnFull", "centerFeed", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "report21053OnClick", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "feedId", "liveId", "onlineNum", "report21053OnClickOnAvatar", "report21053OnClickOnShare", "report21053OnEnter", "enterStatus", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "report21053OnFull", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "report21053OnNearby", "fromType", "toType", "report21054", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorActionType;", "json", "report21054OnLottery", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLotteryType;", "result", "report21056", "report21106", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveBookAction;", "value", "report21113", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveVerified;", "report21631", "action", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyAction2;", "report21919", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLiveClose;", "actionResult", "setCacheExitEvent", "exitType", "setCoverType", "coverType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType2;", "setDesc", "desc", "setErrorCode", "errCode", "setPoiJSONObject", "jsonObject", "Lorg/json/JSONObject;", "setRule", "setTimestampOfEnterLiveAnchorUI", "plugin-finder_release"})
public final class k
{
  private static boolean hIM;
  private static final s vjZ;
  private static final a vka;
  private static final b vkb;
  private static final List<Integer> vkc;
  public static final k vkd;
  
  static
  {
    AppMethodBeat.i(250982);
    vkd = new k();
    vjZ = new s();
    vka = new a();
    vkb = new b();
    vkc = j.listOf(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1002), Integer.valueOf(1003) });
    AppMethodBeat.o(250982);
  }
  
  public static void KI(int paramInt)
  {
    vjZ.vmd = paramInt;
  }
  
  public static void a(RecyclerView paramRecyclerView, s.p paramp, String paramString, c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250967);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    kotlin.g.b.p.h(paramc, "event");
    if (paramc == c.vjf)
    {
      localObject = vjZ;
      kotlin.g.b.p.h(paramString, "<set-?>");
      ((s)localObject).vlS = paramString;
    }
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
    com.tencent.mm.plugin.expt.hellhound.core.b.aoW(com.tencent.mm.plugin.finder.nearby.report.d.acj());
    localObject = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
    com.tencent.mm.plugin.expt.hellhound.core.b.aoV(com.tencent.mm.plugin.finder.nearby.report.d.dlA());
    if ((paramInt1 == -1) && (vkc.contains(Integer.valueOf(paramInt2))))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEA = paramInt2;
      AppMethodBeat.o(250967);
      return;
    }
    if ((paramInt1 != -100) && (paramInt2 != -100))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEA = paramInt2;
      if (paramInt1 == 1001) {
        localObject = c.vjg;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          vka.a(paramRecyclerView, paramp, paramString, (c)localObject);
          AppMethodBeat.o(250967);
          return;
          if (paramInt2 != 1001) {
            break;
          }
          localObject = c.vjf;
        }
        AppMethodBeat.o(250967);
        return;
        if (paramc == c.vjf) {
          break;
        }
        localObject = paramc;
      } while (paramc != c.vjg);
      localObject = paramc;
    } while (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEA == 1001);
    AppMethodBeat.o(250967);
  }
  
  public static void a(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, c.e parame, int paramInt1, int paramInt2, s.p paramp, String paramString, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(250963);
    kotlin.g.b.p.h(parame, "visibleState");
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    kotlin.g.b.p.h(paramc, "event");
    Object localObject = vka;
    kotlin.g.b.p.h(parame, "visibleState");
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    kotlin.g.b.p.h(paramc, "event");
    localObject = ((a)localObject).vja;
    kotlin.g.b.p.h(parame, "visibleState");
    kotlin.g.b.p.h(paramc, "event");
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    if (kotlin.a.e.contains(((f)localObject).vjC, paramString))
    {
      int i;
      switch (g.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        if (kotlin.g.b.p.j(paramString, "61"))
        {
          paramString = "temp_6";
          i = 1;
          label175:
          ((f)localObject).vjA = paramp;
          ((f)localObject).vjB = paramString;
          if (i == 0) {
            break label789;
          }
          if (paramc != c.vjg) {
            break label579;
          }
          parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
          parame = (com.tencent.mm.plugin.expt.hellhound.a.g.a)((f)localObject).vjI;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion = -1;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount = -1;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.clear();
          if (parame != null) {
            com.tencent.mm.plugin.expt.hellhound.a.g.d.listeners.remove(parame);
          }
          ((f)localObject).vjG = true;
          label247:
          if (((f)localObject).vjG) {
            break label782;
          }
          parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
          if (paramAbsListView == null) {
            break label894;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenHeight <= 0)
          {
            paramp = paramAbsListView.getContext();
            parame = paramp;
            if (!(paramp instanceof AppCompatActivity)) {
              parame = null;
            }
            parame = (AppCompatActivity)parame;
            paramp = (Activity)parame;
            if (paramp != null)
            {
              paramp = paramp.getResources();
              i = paramp.getDimensionPixelSize(paramp.getIdentifier("status_bar_height", "dimen", "android"));
              com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = i;
              if (i <= 0) {
                com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = paramp.getDimensionPixelSize(2131166312);
              }
            }
            com.tencent.mm.plugin.expt.hellhound.a.g.d.initActionBarHeight((Activity)parame);
            com.tencent.mm.plugin.expt.hellhound.a.g.d.initScreenHeight((Activity)parame);
            Log.i("HABBYGE-MALI.SnsFeedMonitor", "init: mScreenRealHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenRealHeight + ", mScreenHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenHeight + ", mStatusBarHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight + ", mActionBarHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.mActionBarHeight + ", virtualKeyHeight=" + com.tencent.mm.plugin.expt.hellhound.a.g.d.virtualKeyHeight);
          }
          if ((paramInt1 >= 0) && (paramInt2 > 0))
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion = paramInt1;
            com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount = paramInt2;
          }
          paramInt1 = com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount - 1;
          label464:
          if (paramInt1 < 0) {
            break label782;
          }
          parame = paramAbsListView.getChildAt(paramInt1);
          if (parame != null) {
            break label611;
          }
        }
        break;
      }
      for (;;)
      {
        paramInt1 -= 1;
        break label464;
        if (((f)localObject).vjz) {
          break;
        }
        ((f)localObject).dpc();
        ((f)localObject).vjz = true;
        break;
        if (!((f)localObject).vjz) {
          break;
        }
        ((f)localObject).dpd();
        ((f)localObject).vjz = false;
        break;
        if (!paramBoolean) {
          break;
        }
        ((f)localObject).dpc();
        ((f)localObject).vjz = true;
        break;
        ((f)localObject).dpd();
        ((f)localObject).vjz = false;
        break;
        ((f)localObject).vjv.clear();
        break;
        i = 0;
        break label175;
        label579:
        if (paramc != c.vjf) {
          break label247;
        }
        ((f)localObject).vjG = false;
        parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.sJr;
        com.tencent.mm.plugin.expt.hellhound.a.g.d.registerListener((com.tencent.mm.plugin.expt.hellhound.a.g.a)((f)localObject).vjI);
        break label247;
        label611:
        paramString = com.tencent.mm.plugin.expt.hellhound.a.g.d._getHellFeed(parame, paramInt1, paramAbsListView, com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion);
        if (paramString != null)
        {
          paramp = (com.tencent.mm.plugin.expt.hellhound.a.a.c)paramString.hdM();
          paramString = (Boolean)paramString.hdN();
          kotlin.g.b.p.g(paramString, "isShow");
          if (paramString.booleanValue())
          {
            if (!com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.containsKey(paramp.sBK.feedId))
            {
              paramString = (Map)com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk;
              paramc = paramp.sBK.feedId;
              kotlin.g.b.p.g(paramc, "snsFeed.feed.feedId");
              kotlin.g.b.p.g(paramp, "snsFeed");
              paramString.put(paramc, paramp);
              com.tencent.mm.plugin.expt.hellhound.a.g.d.onFeedAppear(paramBaseAdapter, paramp, parame);
            }
          }
          else if (com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.containsKey(paramp.sBK.feedId))
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.d.sJk.remove(paramp.sBK.feedId);
            kotlin.g.b.p.g(paramp, "snsFeed");
            com.tencent.mm.plugin.expt.hellhound.a.g.d.cQU();
          }
        }
      }
      label782:
      AppMethodBeat.o(250963);
      return;
      label789:
      if (paramc != c.vjg) {
        break label901;
      }
      parame = ((f)localObject).vjF;
      if (parame == null) {
        kotlin.g.b.p.btv("unregister_method");
      }
      parame.invoke(null, new Object[] { ((f)localObject).vjH });
      ((f)localObject).vjG = true;
    }
    for (;;)
    {
      if (!((f)localObject).vjG)
      {
        parame = ((f)localObject).vjD;
        if (parame == null) {
          kotlin.g.b.p.btv("monitor_method");
        }
        parame.invoke(null, new Object[] { paramAbsListView, paramBaseAdapter, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
      label894:
      AppMethodBeat.o(250963);
      return;
      label901:
      if (paramc == c.vjf)
      {
        ((f)localObject).vjG = false;
        parame = ((f)localObject).vjE;
        if (parame == null) {
          kotlin.g.b.p.btv("register_method");
        }
        parame.invoke(null, new Object[] { ((f)localObject).vjH });
      }
    }
  }
  
  private static void a(cn paramcn, long paramLong)
  {
    AppMethodBeat.i(250978);
    paramcn.mx(s.dpt());
    paramcn.my(vjZ.dpp());
    paramcn.ke(s.dpu());
    paramcn.mz(s.dps());
    paramcn.gJ(paramLong);
    AppMethodBeat.o(250978);
  }
  
  public static void a(cp paramcp, String paramString)
  {
    AppMethodBeat.i(250979);
    kotlin.g.b.p.h(paramcp, "struct");
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      paramcp.mQ(str);
      paramcp.hF(s.auU(paramString));
      paramcp.mS(s.dps());
      paramcp.hz(System.currentTimeMillis());
      AppMethodBeat.o(250979);
      return;
    }
  }
  
  private static void a(cy paramcy)
  {
    AppMethodBeat.i(250977);
    paramcy.ob(s.dpt());
    paramcy.oc(vjZ.dpp());
    paramcy.kA(s.dpu());
    paramcy.od(s.dps());
    paramcy.iC(System.currentTimeMillis());
    AppMethodBeat.o(250977);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.c paramc, FinderLiveConfig paramFinderLiveConfig)
  {
    AppMethodBeat.i(250952);
    if (vjZ.vml)
    {
      AppMethodBeat.o(250952);
      return;
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    JSONObject localJSONObject = new JSONObject();
    int i;
    if ((paramc == null) || (paramc.uCs.liveInfo.liveId <= 0L)) {
      if (paramFinderLiveConfig != null)
      {
        paramc = paramFinderLiveConfig.uiv;
        if (paramc != null) {
          break label187;
        }
        paramc = com.tencent.mm.plugin.expt.hellhound.a.b.b.g.sFI;
        i = g.a.cPm();
        if (i > 0) {
          break label146;
        }
        localJSONObject.put("type", s.ae.vqj.type);
      }
    }
    for (;;)
    {
      q(s.a.vmw.hlf, localJSONObject.toString());
      b(s.o.vox);
      a(s.m.vol);
      vjZ.vmc = System.currentTimeMillis();
      AppMethodBeat.o(250952);
      return;
      paramc = null;
      break;
      label146:
      if (j < i)
      {
        localJSONObject.put("type", s.ae.vqk.type);
      }
      else
      {
        localJSONObject.put("type", s.ae.vqj.type);
        continue;
        label187:
        if (paramFinderLiveConfig != null)
        {
          paramc = paramFinderLiveConfig.uiv;
          if (paramc == null) {}
        }
        for (i = paramc.dvv;; i = 0)
        {
          if (j >= i) {
            break label233;
          }
          localJSONObject.put("type", s.ae.vqk.type);
          break;
        }
        label233:
        localJSONObject.put("type", s.ae.vqj.type);
        continue;
        localJSONObject.put("type", s.ae.vql.type);
        localJSONObject.put("liveid", paramc.uCs.liveInfo.liveId);
      }
    }
  }
  
  public static void a(s.ab paramab, String paramString)
  {
    AppMethodBeat.i(250962);
    kotlin.g.b.p.h(paramab, "actionType");
    if (paramab == s.ab.vpW)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.g.sFI;
      g.a.Hg(0);
    }
    Object localObject = new de();
    ((de)localObject).or(s.dpt());
    ((de)localObject).os(vjZ.dpp());
    ((de)localObject).kI(s.dpu());
    ((de)localObject).ot(s.dps());
    ((de)localObject).iY(System.currentTimeMillis());
    ((de)localObject).iZ(paramab.hlf);
    paramab = paramString;
    if (paramString == null) {
      paramab = "";
    }
    ((de)localObject).ou(paramab);
    ((de)localObject).ja(vjZ.vmt.source);
    ((de)localObject).bfK();
    Log.i("HABBYGE-MALI.HellLiveReport", "report21106: finderUsrname=" + ((de)localObject).acG() + ", finderWxAppInfo=" + ((de)localObject).acH() + ", isPrivate=" + ((de)localObject).acI() + ", finderSessionId=" + ((de)localObject).acJ() + ", actionTimeMs=" + ((de)localObject).acK() + ", actionType=" + ((de)localObject).acL() + ", sourceScene=" + ((de)localObject).adn() + ", actionJson=" + ((de)localObject).aeO());
    AppMethodBeat.o(250962);
  }
  
  public static void a(s.ad paramad, String paramString)
  {
    AppMethodBeat.i(250961);
    kotlin.g.b.p.h(paramad, "actionType");
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoZ(paramString))
    {
      AppMethodBeat.o(250961);
      return;
    }
    bt localbt = new bt();
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      localbt.ke(str);
      localbt.kf(vjZ.dpp());
      localbt.jX(s.auU(paramString));
      localbt.kg(s.dps());
      localbt.eF(System.currentTimeMillis());
      localbt.eG(paramad.hlf);
      localbt.bfK();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21113: finderUsrname=" + localbt.acG() + ", finderWxAppInfo=" + localbt.acH() + ", isPrivate=" + localbt.acI() + ", finderSessionId=" + localbt.acJ() + ", actionTimeMs=" + localbt.acK() + ", actionJson=" + localbt.acL());
      AppMethodBeat.o(250961);
      return;
    }
  }
  
  public static void a(s.af paramaf)
  {
    AppMethodBeat.i(250951);
    kotlin.g.b.p.h(paramaf, "action");
    switch (l.$EnumSwitchMapping$0[paramaf.ordinal()])
    {
    }
    do
    {
      for (;;)
      {
        cq localcq = new cq();
        localcq.hJ(System.currentTimeMillis());
        localcq.hK(paramaf.action);
        localcq.hI(vjZ.vmr.type);
        String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        paramaf = str;
        if (str == null) {
          paramaf = "";
        }
        localcq.nd(paramaf);
        paramaf = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        localcq.nb(com.tencent.mm.plugin.finder.nearby.report.d.acj());
        paramaf = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        localcq.nc(com.tencent.mm.plugin.finder.nearby.report.d.dlA());
        localcq.bfK();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21631: actionTS=" + localcq.acs() + ", pageType=" + localcq.acw() + ", action=" + localcq.act() + ", clickid=" + localcq.aec() + ", session_Id=" + localcq.aee() + ", contextID=" + localcq.aed() + ", clickTabContextId=" + localcq.ack());
        AppMethodBeat.o(250951);
        return;
        hIM = false;
        continue;
        hIM = true;
        vjZ.b(s.ao.vqY);
      }
    } while (!hIM);
    hIM = false;
    AppMethodBeat.o(250951);
  }
  
  public static void a(s.c paramc, String paramString)
  {
    AppMethodBeat.i(250958);
    kotlin.g.b.p.h(paramc, "actionType");
    Object localObject = m.vVH;
    if (!m.dBP())
    {
      AppMethodBeat.o(250958);
      return;
    }
    long l = System.currentTimeMillis();
    cn localcn;
    switch (l.vke[paramc.ordinal()])
    {
    default: 
      localcn = new cn();
      a(localcn, l);
      localcn.mA(vjZ.dpq());
      localcn.mB(vjZ.dpr());
      if (TextUtils.isEmpty((CharSequence)vjZ.vmj.description))
      {
        localObject = s.getDescription();
        label138:
        localcn.mC((String)localObject);
        localcn.gK(vjZ.vmi);
        localcn.gL(vjZ.vmg);
        localcn.gM(vjZ.vmh);
        localcn.gN(paramc.action);
        switch (l.vkf[paramc.ordinal()])
        {
        default: 
          if (paramString != null)
          {
            paramString = n.j(paramString, ",", ";", false);
            paramc = paramString;
            if (paramString != null) {}
          }
          else
          {
            paramc = "";
          }
          localcn.mD(paramc);
        }
      }
      break;
    }
    for (;;)
    {
      localcn.gO(vjZ.vms.source);
      localcn.bfK();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21054: finderUsrname=" + localcn.acG() + ", finderWxAppInfo=" + localcn.acH() + ", isPrivate=" + localcn.acI() + ", finderSessionId=" + localcn.acJ() + ", actionTimeMs=" + localcn.acK() + ", liveId=" + localcn.adj() + ", feedId=" + localcn.adk() + ", description=" + localcn.getDescription() + ", sourceScene=" + localcn.adn() + ", liveTime=" + localcn.aco() + ", likeCount=" + localcn.adl() + ", onlineCount=" + localcn.adm() + ", actionType=" + localcn.acL() + ", actionResult=" + localcn.acu());
      AppMethodBeat.o(250958);
      return;
      vjZ.vlO = l;
      vjZ.vmj.vtj = l;
      break;
      if (!kotlin.g.b.p.j(paramString, String.valueOf(s.u.vpl.action))) {
        break;
      }
      vjZ.a(s.v.vpn);
      break;
      if (vjZ.vmi > 0L) {
        break;
      }
      AppMethodBeat.o(250958);
      return;
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.x.vpx.action)))
      {
        localObject = vjZ;
        ((s)localObject).vlI += 1;
        vjZ.vkW.add(com.tencent.mm.vending.j.a.i(s.z.vpG, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        break;
      }
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.x.vpy.action)))
      {
        localObject = vjZ;
        ((s)localObject).vlI += 1;
        vjZ.vkW.add(com.tencent.mm.vending.j.a.i(s.z.vpH, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        break;
      }
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.x.vpz.action)))
      {
        if (!vjZ.vlK)
        {
          a(s.z.vpG);
          AppMethodBeat.o(250958);
          return;
        }
        vjZ.vlK = false;
        a(s.z.vpG);
        break;
      }
      if (!kotlin.g.b.p.j(paramString, String.valueOf(s.x.vpA.action))) {
        break;
      }
      if (vjZ.vlM)
      {
        a(s.z.vpH);
        vjZ.vlM = false;
        AppMethodBeat.o(250958);
        return;
      }
      a(s.z.vpH);
      break;
      if (!kotlin.g.b.p.j(paramString, String.valueOf(s.r.voW.type))) {
        break;
      }
      vjZ.vlB = false;
      vjZ.vlC = false;
      break;
      localObject = vjZ.vmj.description;
      break label138;
      localcn.mD(dpf());
      continue;
      localcn.mD(dpg());
    }
  }
  
  public static void a(s.e parame, String paramString)
  {
    AppMethodBeat.i(250950);
    kotlin.g.b.p.h(parame, "action");
    kotlin.g.b.p.h(paramString, "actionResult");
    long l = System.currentTimeMillis();
    if (parame == s.e.vnm) {
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.i.vnK.action)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw = String.valueOf(vjZ.vlO);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx = l;
      }
    }
    for (;;)
    {
      ct localct = new ct();
      localct.hO(parame.type);
      localct.nu(paramString);
      localct.hP(l);
      localct.nv(String.valueOf(vjZ.vlO));
      localct.bfK();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21919: actionType=" + localct.acL() + ", actionResult=" + localct.acu() + ", actionTimeMs=" + localct.acK() + ", sessionId=" + localct.getSessionId());
      AppMethodBeat.o(250950);
      return;
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.i.vnJ.action)))
      {
        vjZ.vlP = true;
      }
      else if ((kotlin.g.b.p.j(paramString, String.valueOf(s.i.vnL.action))) && (!vjZ.vlP))
      {
        AppMethodBeat.o(250950);
        return;
        if (parame == s.e.vnn) {
          vjZ.vlP = false;
        }
      }
    }
  }
  
  public static void a(s.f paramf, String paramString)
  {
    AppMethodBeat.i(250957);
    kotlin.g.b.p.h(paramf, "type");
    Object localObject1;
    switch (l.uqL[paramf.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        localObject1 = null;
        for (;;)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("type", paramf.type);
          paramf = (s.f)localObject1;
          if (localObject1 == null) {
            paramf = paramString;
          }
          paramString = paramf;
          if (paramf == null) {
            paramString = "";
          }
          ((JSONObject)localObject2).put("result", paramString);
          a(s.c.vmZ, ((JSONObject)localObject2).toString());
          AppMethodBeat.o(250957);
          return;
          vjZ.vlB = true;
          localObject1 = null;
          continue;
          vjZ.vlC = true;
          localObject1 = null;
        }
      } while (!TextUtils.isEmpty((CharSequence)paramString));
      AppMethodBeat.o(250957);
      return;
    }
    if (paramString != null) {}
    try
    {
      localObject1 = n.a((CharSequence)paramString, new String[] { "@" });
      if (localObject1 == null)
      {
        AppMethodBeat.o(250957);
        return;
      }
    }
    catch (Exception paramf)
    {
      Log.e("HABBYGE-MALI.HellLiveReport", "START_LOTTERY_SUCCESS crash: " + paramf.getMessage());
      AppMethodBeat.o(250957);
      return;
    }
    int i = Integer.parseInt((String)((List)localObject1).get(0));
    Object localObject2 = n.a((CharSequence)((List)localObject1).get(1), new String[] { ";" });
    if (i == 1)
    {
      if (TextUtils.isEmpty((CharSequence)((List)localObject2).get(0))) {
        break label420;
      }
      localObject1 = (String)((List)localObject2).get(0);
    }
    for (;;)
    {
      kotlin.g.b.p.g(localObject1, "if (lotteryType == Const…live_lottery_any_comment)");
      localObject1 = (String)localObject1 + ';' + (String)((List)localObject2).get(1) + ';' + (String)((List)localObject2).get(2) + ';' + (String)((List)localObject2).get(3);
      localObject2 = vjZ;
      ((s)localObject2).vlA += 1L;
      break;
      if (i == 2) {
        localObject1 = MMApplicationContext.getResources().getString(2131760050);
      } else {
        label420:
        localObject1 = MMApplicationContext.getResources().getString(2131760014);
      }
    }
  }
  
  public static void a(s.m paramm)
  {
    AppMethodBeat.i(250981);
    kotlin.g.b.p.h(paramm, "coverType");
    vjZ.vmf = paramm.type;
    AppMethodBeat.o(250981);
  }
  
  public static void a(s.o paramo)
  {
    AppMethodBeat.i(250954);
    kotlin.g.b.p.h(paramo, "type");
    eb localeb = new eb();
    localeb.qq(s.dpt());
    localeb.qr(vjZ.dpp());
    localeb.ld(s.dpu());
    localeb.qs(s.dps());
    localeb.lo(System.currentTimeMillis());
    localeb.lv(paramo.dDw);
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
    localeb.lp(((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.OlC, 0));
    localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    kotlin.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDG().hBp == 0) {}
    for (int i = 2;; i = 1)
    {
      localeb.lq(i);
      localeb.lr(vjZ.vmc);
      localeb.ls(System.currentTimeMillis() - localeb.afn());
      localeb.lu(vjZ.vmd);
      Object localObject3 = vjZ;
      localObject1 = ((s)localObject3).vme;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).toString();
        if (localObject1 != null)
        {
          localObject2 = n.j((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label242;
          }
        }
      }
      localObject1 = "";
      label242:
      ((s)localObject3).vme = null;
      localeb.qt((String)localObject1);
      localObject3 = vjZ;
      localObject1 = ((s)localObject3).desc;
      if (localObject1 != null)
      {
        localObject2 = n.j((String)localObject1, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((s)localObject3).desc = null;
      localeb.qu((String)localObject1);
      localeb.lt(vjZ.vmf);
      localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
      localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEl;
        if (localObject1 != null)
        {
          localObject2 = ((awc)localObject1).vtD;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label376;
          }
        }
      }
      localObject1 = "";
      label376:
      localeb.qz((String)localObject1);
      localeb.qy("");
      localObject1 = vjZ.vmp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localObject3 = localeb.aft();
        localeb.qy((String)localObject3 + localObject2 + '#');
      }
    }
    localObject1 = localeb.aft();
    kotlin.g.b.p.g(localObject1, "struct.goodsListJson");
    if (n.K((String)localObject1, "#", false))
    {
      localObject1 = localeb.aft();
      kotlin.g.b.p.g(localObject1, "struct.goodsListJson");
      i = localeb.aft().length();
      if (localObject1 == null)
      {
        paramo = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(250954);
        throw paramo;
      }
      localObject1 = ((String)localObject1).substring(0, i - 1);
      kotlin.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localeb.qy((String)localObject1);
    }
    switch (l.haE[paramo.ordinal()])
    {
    default: 
      localeb.qA(dpf());
      localeb.qB(dpg());
      localeb.qE(String.valueOf(vjZ.vlL.action));
      localeb.lw(vjZ.vms.source);
      localeb.qC(com.tencent.mm.compatible.util.q.encode(vjZ.tag, "UTF-8"));
      localeb.qD(com.tencent.mm.compatible.util.q.encode(vjZ.vlT, "UTF-8"));
      localeb.lx(vjZ.vlW.type);
      if (vjZ.vlW != s.aq.vrf) {
        break;
      }
    }
    for (long l = vjZ.vlX;; l = 0L)
    {
      localeb.ly(l);
      localeb.bfK();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21024: finderUsrname=" + localeb.acG() + ", finderWxAppInfo=" + localeb.acH() + ", isPrivate=" + localeb.acI() + ", finderSessionId=" + localeb.acJ() + ", actionTimeMs=" + localeb.acK() + ", exitType=" + localeb.adH() + ", fansCount=" + localeb.afl() + ", cameraStatus=" + localeb.afm() + ", enterUITimeMs=" + localeb.afn() + ", stayTimeMs=" + localeb.afo() + ", coverType=" + localeb.afp() + ", ruleType=" + localeb.afq() + ", poiJson=" + localeb.afr() + ", description=" + localeb.getDescription() + ", liveId=" + localeb.adj() + ", feedId=" + localeb.adk() + ", errorCode=" + localeb.afs() + ", goodsListJson=" + localeb.aft() + ", retouchResult=" + localeb.afu() + ", filtersResult=" + localeb.afv() + ", connectSwitch=" + localeb.afw() + ", sourceScene=" + localeb.adn() + ", tag=" + localeb.getTag() + ", subTag=" + localeb.aeL() + ", visibleRange=" + localeb.aeN() + ", shopWindowId=" + localeb.aeH());
      AppMethodBeat.o(250954);
      return;
      localeb.qv(vjZ.dpq());
      localeb.qw(vjZ.dpr());
      localeb.qx("0");
      break;
      localeb.qv(vjZ.dpq());
      localeb.qw(vjZ.dpr());
      localeb.qx(String.valueOf(vjZ.errCode));
      break;
      localeb.qv("0");
      localeb.qw("0");
      localeb.qx(String.valueOf(vjZ.errCode));
      break;
      localeb.qv("0");
      localeb.qw("0");
      localeb.qx("0");
      vjZ.setTag("");
      vjZ.auS("");
      vjZ.a(s.aq.vre);
      vjZ.vlX = 0L;
      break;
    }
  }
  
  public static void a(s.p paramp, FeedData paramFeedData)
  {
    AppMethodBeat.i(250965);
    kotlin.g.b.p.h(paramp, "type");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(250965);
      return;
    }
    vka.a(paramp, vjZ.vlQ, String.valueOf(vjZ.vlR), paramFeedData);
    AppMethodBeat.o(250965);
  }
  
  private static void a(s.z paramz)
  {
    AppMethodBeat.i(250959);
    int i = vjZ.vkW.size() - 1;
    while (i >= 0)
    {
      Object localObject = vjZ.vkW.get(i);
      kotlin.g.b.p.g(localObject, "mConfig.gLinkMicTimeList[i]");
      localObject = (com.tencent.mm.vending.j.d)localObject;
      if (((s.z)((com.tencent.mm.vending.j.d)localObject).hdM() == paramz) && (((Number)((com.tencent.mm.vending.j.d)localObject).hdN()).longValue() > 0L) && (kotlin.g.b.p.j((Boolean)((com.tencent.mm.vending.j.d)localObject).hdO(), Boolean.FALSE)))
      {
        long l = System.currentTimeMillis();
        localObject = ((com.tencent.mm.vending.j.d)localObject).hdN();
        kotlin.g.b.p.g(localObject, "tuple.`$2`()");
        l = (l - ((Number)localObject).longValue()) / 1000L;
        if (l >= 0L)
        {
          vjZ.vkW.set(i, com.tencent.mm.vending.j.a.i(paramz, Long.valueOf(l), Boolean.TRUE));
          AppMethodBeat.o(250959);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(250959);
  }
  
  public static void a(y.a parama)
  {
    AppMethodBeat.i(250966);
    Object localObject = vkb;
    a locala = vka;
    s locals = vjZ;
    kotlin.g.b.p.h(locala, "m21053Reporter");
    kotlin.g.b.p.h(locals, "config");
    if (parama == null)
    {
      AppMethodBeat.o(250966);
      return;
    }
    if (parama.feed == null)
    {
      AppMethodBeat.o(250966);
      return;
    }
    FeedData localFeedData = parama.feed;
    long l;
    if (localFeedData != null) {
      l = localFeedData.getFeedId();
    }
    while (((b)localObject).vjc != l)
    {
      ((b)localObject).vjc = l;
      if (parama.vXJ != 9)
      {
        localObject = parama.feed;
        if (localObject != null)
        {
          if (((FeedData)localObject).getLiveStatus() != 1)
          {
            AppMethodBeat.o(250966);
            return;
            l = 0L;
          }
        }
        else
        {
          AppMethodBeat.o(250966);
          return;
        }
        locala.a(s.p.voB, parama.vXK, String.valueOf(locals.vlR), parama.feed);
      }
    }
    AppMethodBeat.o(250966);
  }
  
  public static void aM(JSONObject paramJSONObject)
  {
    vjZ.vme = paramJSONObject;
  }
  
  public static void b(RecyclerView paramRecyclerView, s.p paramp, String paramString, c paramc)
  {
    AppMethodBeat.i(250964);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    kotlin.g.b.p.h(paramc, "event");
    Object localObject = paramString;
    String str;
    if (kotlin.g.b.p.j(paramString, "25"))
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      kotlin.g.b.p.g(localObject, "HellSessionMonitor.getInstance()");
      str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).cPQ();
      localObject = paramString;
      if (str != null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject = paramString;
        if (!c.a.apK(str)) {
          switch (str.hashCode())
          {
          default: 
            paramString = "39";
          }
        }
      }
    }
    for (;;)
    {
      label140:
      localObject = paramString;
      vka.a(paramRecyclerView, paramp, (String)localObject, paramc);
      AppMethodBeat.o(250964);
      return;
      if (!str.equals("101")) {
        break;
      }
      for (;;)
      {
        paramString = "25";
        break label140;
        if (!str.equals("123")) {
          break;
        }
        paramString = "38";
        break label140;
        if (!str.equals("102")) {
          break;
        }
        continue;
        if (!str.equals("999")) {
          break;
        }
      }
      if (!str.equals("150")) {
        break;
      }
      paramString = "15";
    }
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(250973);
    r(paramp.vln, paramp.vjM);
    vjZ.a(paramp.vjL, paramp.vjM);
    vka.a(paramp);
    AppMethodBeat.o(250973);
  }
  
  public static void b(q paramq)
  {
    AppMethodBeat.i(250971);
    kotlin.g.b.p.h(paramq, "enterData");
    r(paramq.vln, paramq.vjM);
    vjZ.a(paramq.vjL, "");
    a locala = vka;
    kotlin.g.b.p.h(paramq, "enterData");
    cp localcp = new cp();
    Object localObject = vkd;
    a(localcp, paramq.userName);
    localcp.mR(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramq.feedId));
    localcp.hy(paramq.liveId);
    localcp.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramq.liveId));
    localcp.hA(paramq.vjL.dDw);
    localcp.mT(paramq.vjM);
    localcp.hB(paramq.vln);
    localcp.hC(paramq.vlt);
    localcp.hD(paramq.vlp);
    localcp.mU(paramq.vlq);
    localcp.mZ(paramq.vlr);
    localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
    localcp.hE(paramq.vlo);
    localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
    if (n.J(paramq.vjM, "temp_", false)) {
      if (kotlin.g.b.p.j(localcp.ach(), "temp_2"))
      {
        localObject = vkd;
        localcp.mX(vjZ.vlV);
        localcp.hG(paramq.enterTime);
        localcp.hH(paramq.vlu.type);
        if (kotlin.g.b.p.j(localcp.ach(), "61"))
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)) {
            break label812;
          }
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          kotlin.g.b.p.g(paramq, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label812:
    for (paramq = paramq.cPR();; paramq = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)
    {
      localcp.na(paramq);
      localcp.bfK();
      Log.i(locala.TAG, "report21053OnClickOnShare, struct=\nfeedId=" + localcp.acf() + '\n' + "liveId=" + localcp.adY() + '\n' + "userName=" + localcp.getUserName() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionID=" + localcp.acl() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "enterSessionId=" + localcp.aea() + '\n' + "enterIconType=" + localcp.acv() + '\n' + "snsSessionID=" + localcp.aeb() + '\n' + "snsFeedId=" + localcp.adZ());
      AppMethodBeat.o(250971);
      return;
      localcp.mX(paramq.vjM);
      break;
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      long l = paramq.feedId;
      localObject = localcp.ach();
      kotlin.g.b.p.g(localObject, "struct.commentScene");
      localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
      if (localObject != null)
      {
        String str = n.j((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = paramq.vjM;
      }
      localcp.mX((String)localObject);
      break;
    }
  }
  
  public static void b(s.o paramo)
  {
    AppMethodBeat.i(250980);
    kotlin.g.b.p.h(paramo, "exitType");
    vjZ.c(paramo);
    AppMethodBeat.o(250980);
  }
  
  private static void c(q paramq)
  {
    AppMethodBeat.i(250974);
    dpi();
    vka.a(paramq);
    AppMethodBeat.o(250974);
  }
  
  private static String dpf()
  {
    int j = 0;
    AppMethodBeat.i(250955);
    s locals = vjZ;
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGk();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
      if (localObject1 != null)
      {
        localObject2 = e.c.hxm;
        localObject2 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCh()));
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label97;
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfV();
    label97:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
      if (localObject1 != null)
      {
        localObject2 = e.c.hxm;
        localObject1 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCh()));
        if (localObject1 == null) {
          break label619;
        }
        i = ((Integer)localObject1).intValue();
        label106:
        locals.vlD = i;
        locals = vjZ;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGk();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
          if (localObject1 != null)
          {
            localObject2 = e.c.hxm;
            localObject2 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCj()));
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label201;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfV();
        if (localObject1 == null) {
          break label624;
        }
        localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
        if (localObject1 == null) {
          break label624;
        }
        localObject2 = e.c.hxm;
        localObject1 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCj()));
        label201:
        if (localObject1 == null) {
          break label629;
        }
        i = ((Integer)localObject1).intValue();
        label210:
        locals.vlE = i;
        locals = vjZ;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGk();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
          if (localObject1 != null)
          {
            localObject2 = e.c.hxm;
            localObject2 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCk()));
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label305;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfV();
        if (localObject1 == null) {
          break label634;
        }
        localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
        if (localObject1 == null) {
          break label634;
        }
        localObject2 = e.c.hxm;
        localObject1 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCk()));
        label305:
        if (localObject1 == null) {
          break label639;
        }
        i = ((Integer)localObject1).intValue();
        label314:
        locals.hDg = i;
        locals = vjZ;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGk();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
          if (localObject1 != null)
          {
            localObject2 = e.c.hxm;
            localObject2 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCi()));
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label409;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfV();
        if (localObject1 == null) {
          break label644;
        }
        localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
        if (localObject1 == null) {
          break label644;
        }
        localObject2 = e.c.hxm;
        localObject1 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCi()));
        label409:
        if (localObject1 == null) {
          break label649;
        }
        i = ((Integer)localObject1).intValue();
        label418:
        locals.vlF = i;
        locals = vjZ;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGk();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
          if (localObject1 != null)
          {
            localObject2 = e.c.hxm;
            localObject2 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCl()));
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label513;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfV();
        if (localObject1 == null) {
          break label654;
        }
        localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).hDh;
        if (localObject1 == null) {
          break label654;
        }
        localObject2 = e.c.hxm;
      }
    }
    label513:
    label644:
    label649:
    label654:
    for (localObject1 = (Integer)((HashMap)localObject1).get(Integer.valueOf(e.c.aCl()));; localObject1 = null)
    {
      i = j;
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      }
      locals.vlG = i;
      localObject1 = vjZ.vlD + ';' + vjZ.vlE + ';' + vjZ.hDg + ';' + vjZ.vlF + ';' + vjZ.vlG;
      AppMethodBeat.o(250955);
      return localObject1;
      localObject1 = null;
      break;
      label619:
      i = 0;
      break label106;
      label624:
      localObject1 = null;
      break label201;
      label629:
      i = 0;
      break label210;
      label634:
      localObject1 = null;
      break label305;
      label639:
      i = 0;
      break label314;
      localObject1 = null;
      break label409;
      i = 0;
      break label418;
    }
  }
  
  private static String dpg()
  {
    AppMethodBeat.i(250956);
    Object localObject2 = vjZ;
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
    localObject1 = com.tencent.mm.plugin.finder.live.model.o.aGl();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.b.b)localObject1).hDj;
      ((s)localObject2).vlH = s.auT((String)localObject1).type;
      localObject1 = vjZ;
      localObject2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
      localObject2 = com.tencent.mm.plugin.finder.live.model.o.aGl();
      if (localObject2 == null) {
        break label137;
      }
    }
    label137:
    for (int i = ((com.tencent.mm.live.core.b.b)localObject2).hDk;; i = 0)
    {
      ((s)localObject1).hDk = i;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", vjZ.vlH);
      ((JSONObject)localObject1).put("result", vjZ.hDk);
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.p.g(localObject1, "json.toString()");
      localObject1 = n.j((String)localObject1, ",", ";", false);
      AppMethodBeat.o(250956);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static void dph()
  {
    AppMethodBeat.i(250960);
    long l = vjZ.vmj.vtj;
    if (l <= 0L)
    {
      AppMethodBeat.o(250960);
      return;
    }
    cw localcw = new cw();
    localcw.nK(s.dpt());
    localcw.nL(vjZ.dpp());
    localcw.ko(s.dpu());
    localcw.nM(s.dps());
    localcw.hT(System.currentTimeMillis());
    localcw.hY(vjZ.vmj.vtn);
    localcw.hZ(vjZ.vmj.vto);
    localcw.ia(vjZ.vmj.vtp);
    localcw.hW(vjZ.vmj.vtm);
    Object localObject2 = vjZ.vmj.hJs;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!kotlin.g.b.p.j(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!kotlin.g.b.p.j(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = vjZ.dpq();
    }
    localcw.nN((String)localObject1);
    localObject2 = vjZ.vmj.feedId;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!kotlin.g.b.p.j(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!kotlin.g.b.p.j(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = vjZ.dpr();
    }
    localcw.nO((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)vjZ.vmj.description))
    {
      localObject1 = s.getDescription();
      localcw.nP((String)localObject1);
      localcw.hU(l);
      localcw.hV(vjZ.vmj.vtk);
      localcw.hX(vjZ.vmj.vtl);
      localcw.kp(vjZ.vmj.errorCode);
      localcw.ib(vjZ.vmj.vtq);
      localcw.ic(vjZ.vmj.vtr);
      localcw.id(vjZ.vmj.vts);
      localcw.ie(vjZ.vmj.vtt);
      localcw.jdMethod_if(vjZ.vmj.vtu);
      localcw.ig(vjZ.vmj.vtv);
      localcw.ih(vjZ.vmj.vtw);
      localcw.ii(vjZ.vmj.vtx);
      localcw.ij(vjZ.vmj.vty);
      localcw.ik(vjZ.vmj.vtz);
      localObject1 = vjZ;
      if (!((s)localObject1).vmj.vtA.isEmpty()) {
        break label1646;
      }
      localObject2 = "";
    }
    label593:
    label1646:
    Object localObject3;
    label779:
    Object localObject4;
    int i;
    for (;;)
    {
      localcw.nQ((String)localObject2);
      localcw.il(vjZ.vmj.vtA.size());
      localObject1 = com.tencent.mm.plugin.finder.live.model.o.ujN;
      localObject1 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEl;
        if (localObject1 != null)
        {
          localObject2 = ((awc)localObject1).vtD;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label593;
          }
        }
      }
      localObject1 = vjZ.vmj.vtD;
      localcw.nR((String)localObject1);
      localcw.im(vjZ.vmj.vtB);
      localcw.ip(vjZ.vmj.vtC);
      localcw.io(vjZ.vlA);
      localcw.in(vjZ.vms.source);
      localcw.iq(vjZ.vlI);
      localcw.nT(com.tencent.mm.compatible.util.q.encode(vjZ.tag, "UTF-8"));
      localcw.nU(com.tencent.mm.compatible.util.q.encode(vjZ.vlT, "UTF-8"));
      if (!vjZ.vkW.isEmpty()) {
        break label1863;
      }
      localcw.nS("");
      localcw.ir(vjZ.vlN.type);
      localcw.is(vjZ.vlW.type);
      if (vjZ.vlW != s.aq.vrf) {
        break label2051;
      }
      l = vjZ.vlX;
      localcw.iu(l);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localcw.it(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK());
      localcw.bfK();
      localObject1 = vjZ.vmj;
      ((u)localObject1).hJs = "";
      ((u)localObject1).feedId = "";
      ((u)localObject1).description = "";
      ((u)localObject1).vtj = 0L;
      ((u)localObject1).vtk = 0L;
      ((u)localObject1).vtm = 0L;
      ((u)localObject1).vtl = 0L;
      ((u)localObject1).vtn = 0L;
      ((u)localObject1).vto = 0L;
      ((u)localObject1).vtp = 0L;
      ((u)localObject1).errorCode = 0;
      ((u)localObject1).vtq = 0L;
      ((u)localObject1).vtr = 0L;
      ((u)localObject1).vts = 0L;
      ((u)localObject1).vtt = 0L;
      ((u)localObject1).vtu = 0L;
      ((u)localObject1).vtv = 0L;
      ((u)localObject1).vtw = 0L;
      ((u)localObject1).vtx = 0L;
      ((u)localObject1).vty = 0L;
      ((u)localObject1).vtz = 0L;
      ((u)localObject1).vtD = "";
      ((u)localObject1).vtB = 0L;
      ((u)localObject1).vtC = 0L;
      ((u)localObject1).vtA.clear();
      localObject1 = vjZ;
      ((s)localObject1).vmg = 0L;
      ((s)localObject1).vmh = 0L;
      ((s)localObject1).vmi = 0L;
      ((s)localObject1).vmk = false;
      ((s)localObject1).vml = false;
      ((s)localObject1).vmm = false;
      ((s)localObject1).vmn = false;
      ((s)localObject1).vmo = false;
      ((s)localObject1).vlI = 0;
      ((s)localObject1).vkW.clear();
      ((s)localObject1).vmp.clear();
      ((s)localObject1).vlA = 0L;
      ((s)localObject1).vlB = false;
      ((s)localObject1).vlC = false;
      ((s)localObject1).tag = "";
      ((s)localObject1).vlT = "";
      ((s)localObject1).vlW = s.aq.vre;
      ((s)localObject1).vlX = 0L;
      ((s)localObject1).vlN = s.v.vpo;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.Hf(0);
      Log.i("HABBYGE-MALI.HellLiveReport", "report21056: finderUsrname=" + localcw.acG() + ", finderWxAppInfo=" + localcw.acH() + ", isPrivate=" + localcw.acI() + ", finderSessionId=" + localcw.acJ() + ", actionTimeMs=" + localcw.acK() + ", audienceCount=" + localcw.aeu() + ", likeCount=" + localcw.adl() + ", newFansNum=" + localcw.aev() + ", liveDurationSeconds=" + localcw.aes() + ", liveId=" + localcw.adj() + ", feedId=" + localcw.adk() + ", description=" + localcw.getDescription() + ", liveStartTimeMs=" + localcw.aeq() + ", liveEndTimeMs=" + localcw.aer() + ", oriFansCount=" + localcw.aet() + ", errorCode=" + localcw.getErrorCode() + ", floatingCount=" + localcw.adx() + ", shareSnsCount=" + localcw.aew() + ", shareSessionCount=" + localcw.aex() + ", exchangeCameraCount=" + localcw.aey() + ", complainCount=" + localcw.aez() + ", allCommentCloseCount=" + localcw.aeA() + ", allCommentOpenCount=" + localcw.aeB() + ", personalCommentCloseCount=" + localcw.aeC() + ", personalCommentOpenCount=" + localcw.aeD() + ", kickOutCount=" + localcw.aeE() + ", promoteGoodsJson=" + localcw.aeF() + ", promoteGoodsCount=" + localcw.aeG() + ", shopWindowId=" + localcw.aeH() + ", nudgeCount=" + localcw.aeJ() + ", lotteryCount=" + localcw.adO() + ", connectCount=" + localcw.aeK() + ", connectDuration=" + localcw.adR() + ", sourceScene=" + localcw.adn() + ", isGift=" + localcw.aeM() + ", tag=" + localcw.getTag() + ", subTag=" + localcw.aeL() + ", visibleRange=" + localcw.aeN() + ", topComment=" + localcw.aeI());
      AppMethodBeat.o(250960);
      return;
      localObject1 = vjZ.vmj.description;
      break;
      localObject2 = ((Map)((s)localObject1).vmj.vtA).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + ((Number)((Map.Entry)localObject3).getKey()).longValue() + ':' + l + '#')
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = ((LinkedList)((Map.Entry)localObject3).getValue()).iterator();
        l = 0L;
        while (((Iterator)localObject4).hasNext())
        {
          o localo = (o)((Iterator)localObject4).next();
          if (localo.vlm) {
            l += localo.time;
          }
        }
      }
      localObject2 = localObject1;
      if (n.K((String)localObject1, "#", false))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(250960);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        kotlin.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    label1863:
    Object localObject1 = "";
    localObject2 = vjZ.vkW.iterator();
    label1878:
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.vending.j.d)((Iterator)localObject2).next();
      localObject4 = ((com.tencent.mm.vending.j.d)localObject3).hdO();
      kotlin.g.b.p.g(localObject4, "tuple.`$3`()");
      if (!((Boolean)localObject4).booleanValue()) {
        break label2056;
      }
      localObject1 = (String)localObject1 + ((s.z)((com.tencent.mm.vending.j.d)localObject3).hdM()).type + '|' + (Long)((com.tencent.mm.vending.j.d)localObject3).hdN() + ';';
    }
    label2051:
    label2056:
    for (;;)
    {
      break label1878;
      localObject2 = localObject1;
      if ((kotlin.g.b.p.j(localObject1, "") ^ true))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(250960);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        kotlin.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localcw.nS((String)localObject2);
      break;
      l = 0L;
      break label779;
    }
  }
  
  private static void dpi()
  {
    AppMethodBeat.i(250976);
    vjZ.vlx = false;
    vjZ.auQ("");
    AppMethodBeat.o(250976);
  }
  
  public static s.o dpj()
  {
    return vjZ.vmb;
  }
  
  public static int dpk()
  {
    return vjZ.vmf;
  }
  
  public static s dpl()
  {
    return vjZ;
  }
  
  public static void q(long paramLong, String paramString)
  {
    AppMethodBeat.i(250953);
    Object localObject;
    if (paramLong == s.a.vmv.hlf)
    {
      localObject = vjZ;
      ((s)localObject).b(((s)localObject).vlU);
    }
    cy localcy = new cy();
    a(localcy);
    if (paramLong == s.a.vmI.hlf)
    {
      if (!kotlin.g.b.p.j(paramString, String.valueOf(s.y.vpC.action))) {
        break label273;
      }
      vjZ.a(s.y.vpC);
    }
    for (;;)
    {
      localcy.iD(paramLong);
      if (paramString != null)
      {
        localObject = n.j(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localcy.oe(paramString);
      localcy.iE(vjZ.vms.source);
      localcy.bfK();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21017: finderUsrname=" + localcy.acG() + ", finderWxAppInfo=" + localcy.acH() + ", isPrivate=" + localcy.acI() + ", finderSessionId=" + localcy.acJ() + ", actionTimeMs=" + localcy.acK() + ", actionType=" + localcy.acL() + ", sourceScene=" + localcy.adn() + ", actionJson=" + localcy.aeO());
      AppMethodBeat.o(250953);
      return;
      label273:
      if (kotlin.g.b.p.j(paramString, String.valueOf(s.y.vpD.action))) {
        vjZ.a(s.y.vpD);
      }
    }
  }
  
  private static void r(long paramLong, String paramString)
  {
    AppMethodBeat.i(250975);
    com.tencent.mm.plugin.expt.hellhound.a.aox(paramString);
    vjZ.auQ(paramString);
    vjZ.vlw = paramLong;
    AppMethodBeat.o(250975);
  }
  
  public static void setDesc(String paramString)
  {
    if (paramString == null) {
      return;
    }
    vjZ.desc = paramString;
  }
  
  public static void setErrorCode(int paramInt)
  {
    vjZ.errCode = paramInt;
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.p paramp, String paramString2)
  {
    AppMethodBeat.i(250970);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString2, "commentscene");
    if (kotlin.g.b.p.j(paramString2, s.w.vpq.type))
    {
      paramString2 = s.j.vnX.scene;
      if (paramString1 != null) {
        break label173;
      }
      paramString1 = "";
    }
    label173:
    for (;;)
    {
      b(new p(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramp, paramString2));
      AppMethodBeat.o(250970);
      return;
      if (kotlin.g.b.p.j(paramString2, s.w.vpr.type))
      {
        paramString2 = s.j.vnW.scene;
        break;
      }
      if (kotlin.g.b.p.j(paramString2, s.w.vps.type))
      {
        paramString2 = s.j.vnZ.scene;
        break;
      }
      if ((!kotlin.g.b.p.j(paramString2, s.w.vpt.type)) && (kotlin.g.b.p.j(paramString2, s.w.vpu.type)))
      {
        paramString2 = s.j.vnY.scene;
        break;
      }
      break;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.p paramp, String paramString2, long paramLong5, long paramLong6, s.av paramav)
  {
    AppMethodBeat.i(250972);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString2, "commentscene");
    kotlin.g.b.p.h(paramav, "enterType");
    Object localObject;
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      kotlin.g.b.p.g(paramString2, "HellSessionMonitor.getInstance()");
      paramString2 = paramString2.cPQ();
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (c.a.apK(paramString2))
      {
        if (paramString1 != null) {
          break label238;
        }
        paramString1 = "";
      }
    }
    label238:
    for (;;)
    {
      String str2 = s.j.vnS.scene;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      paramLong3 = c.a.apJ(paramString2);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq;
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = "";
      }
      String str1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      c(new q(paramLong1, paramLong2, paramString1, 0L, paramLong4, paramp, str2, paramLong5, paramLong3, paramString2, (String)localObject, paramLong6, paramav));
      AppMethodBeat.o(250972);
      return;
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        c(new q(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramp, paramString2, paramLong5, -1L, "", "", paramLong6, paramav));
        AppMethodBeat.o(250972);
        return;
      }
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, s.p paramp, String paramString)
  {
    AppMethodBeat.i(250969);
    kotlin.g.b.p.h(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    long l3 = paramBaseFinderFeed.lT();
    Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
    long l1;
    if (localObject != null)
    {
      l1 = ((awe)localObject).liveId;
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label118;
      }
    }
    label118:
    for (long l2 = paramBaseFinderFeed.uBn;; l2 = -1L)
    {
      b(new p(l3, l1, (String)localObject, paramLong, l2, paramp, paramString));
      AppMethodBeat.o(250969);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public final void a(y paramy, String paramString1, long paramLong, s.p paramp, String paramString2)
  {
    AppMethodBeat.i(250968);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString2, "commentscene");
    if (paramy == null) {
      if (paramString1 != null) {
        break label170;
      }
    }
    label162:
    label170:
    for (paramy = "";; paramy = paramString1)
    {
      b(new p(0L, 0L, paramy, paramLong, -1L, paramp, paramString2));
      AppMethodBeat.o(250968);
      return;
      long l3 = paramy.uOo.id;
      paramString1 = paramy.uOo.liveInfo;
      long l1;
      if (paramString1 != null)
      {
        l1 = paramString1.liveId;
        String str = paramy.uOo.username;
        paramString1 = str;
        if (str == null) {
          paramString1 = "";
        }
        paramy = paramy.uOo.liveInfo;
        if (paramy == null) {
          break label162;
        }
      }
      for (long l2 = paramy.uBn;; l2 = -1L)
      {
        b(new p(l3, l1, paramString1, paramLong, l2, paramp, paramString2));
        AppMethodBeat.o(250968);
        return;
        l1 = 0L;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.k
 * JD-Core Version:    0.7.0.1
 */
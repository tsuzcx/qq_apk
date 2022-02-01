package com.tencent.mm.plugin.finder.live.report;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ck;
import com.tencent.mm.f.b.a.de;
import com.tencent.mm.f.b.a.dg;
import com.tencent.mm.f.b.a.dh;
import com.tencent.mm.f.b.a.dk;
import com.tencent.mm.f.b.a.do;
import com.tencent.mm.f.b.a.dp;
import com.tencent.mm.f.b.a.du;
import com.tencent.mm.f.b.a.ey;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.g.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.a.a;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.ejv;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveReport;", "", "()V", "INVALIDATE_NEARBY_TAB_TYPE", "", "NEARBY_TAB_TYPE_ARRAY", "", "TAG", "", "fullStatic", "Lcom/tencent/mm/plugin/finder/live/report/FullFeedExploreStatics;", "isClickStartLive", "", "isPullupListHalfPage", "m21053Reporter", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "mConfig", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig;", "_doReport21053OnClick", "", "clickData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "_doReport21053OnEnter", "enterData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "getCacheExitEvent", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "getConfig", "getCoverType", "handleAnchorLinkMicDuration", "handleLinkMicDuration", "linkType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "initBeauty", "initClickEvent", "pos", "", "commentscene", "initCommField", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderFaceVerifyStreamStruct;", "userName", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveActionStruct;", "timestamp", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveEntranceLogStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveResultStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderNoticeLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderStartLiveResultStruct;", "initEnterEvent", "initFilter", "report", "finderLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "report21017", "actionType", "actionJson", "report21024", "type", "report21053", "recyclerView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "visibleItemCount", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "headerShow", "Landroidx/recyclerview/widget/RecyclerView;", "report21053FeedOnFull", "centerFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "report21053OnClick", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "feedId", "liveId", "onlineNum", "chnlExtra", "clickTabContextId", "clickSubTabContextId", "report21053OnClickForLiveSquare", "report21053OnClickNearByReddot", "contextId", "report21053OnClickOnAvatar", "report21053OnClickOnShare", "report21053OnEnter", "enterStatus", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "sessionBuf", "report21053OnFull", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "report21053OnNearby", "fromType", "toType", "report21054", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorActionType;", "json", "report21054AnchorPauseLive", "pauseTime", "report21054OnLottery", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLotteryType;", "result", "report21056", "report21106", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveBookAction;", "value", "description", "report21113", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveVerified;", "report21631", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyAction2;", "report21919", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLiveClose;", "actionResult", "report21919OnVest", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "reportLinkMic", "linkOp", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkOp;", "micType", "inviteType", "reportVest", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "setCacheExitEvent", "exitType", "setCoverType", "coverType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType2;", "setDesc", "desc", "setErrorCode", "errCode", "setPoiJSONObject", "jsonObject", "Lorg/json/JSONObject;", "setRule", "setTimestampOfEnterLiveAnchorUI", "plugin-finder_release"})
public final class k
{
  private static boolean kwg;
  private static final s yBe;
  private static final a yBf;
  private static final b yBg;
  private static boolean yBh;
  private static final List<Integer> yBi;
  public static final k yBj;
  
  static
  {
    AppMethodBeat.i(288965);
    yBj = new k();
    yBe = new s();
    yBf = new a();
    yBg = new b();
    yBi = j.listOf(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1002), Integer.valueOf(1003) });
    AppMethodBeat.o(288965);
  }
  
  public static void ND(int paramInt)
  {
    yBe.yDq = paramInt;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.t paramt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(288952);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString2, "commentscene");
    kotlin.g.b.p.k(paramString3, "clickTabContextId");
    kotlin.g.b.p.k(paramString4, "clickSubTabContextId");
    kotlin.g.b.p.k(paramString5, "chnlExtra");
    if (kotlin.g.b.p.h(paramString2, s.ac.yHN.type))
    {
      paramString2 = s.l.yFZ.scene;
      if (paramString1 != null) {
        break label203;
      }
      paramString1 = "";
    }
    label203:
    for (;;)
    {
      b(new p(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramt, paramString2, null, null, paramString3, paramString4, paramString5, 1920));
      AppMethodBeat.o(288952);
      return;
      if (kotlin.g.b.p.h(paramString2, s.ac.yHO.type))
      {
        paramString2 = s.l.yFY.scene;
        break;
      }
      if (kotlin.g.b.p.h(paramString2, s.ac.yHP.type))
      {
        paramString2 = s.l.yGb.scene;
        break;
      }
      if ((!kotlin.g.b.p.h(paramString2, s.ac.yHQ.type)) && (kotlin.g.b.p.h(paramString2, s.ac.yHR.type)))
      {
        paramString2 = s.l.yGa.scene;
        break;
      }
      break;
    }
  }
  
  public static void a(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, c.e parame, int paramInt1, int paramInt2, s.t paramt, String paramString, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(288937);
    kotlin.g.b.p.k(parame, "visibleState");
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    kotlin.g.b.p.k(paramc, "event");
    Object localObject = yBf;
    kotlin.g.b.p.k(parame, "visibleState");
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    kotlin.g.b.p.k(paramc, "event");
    localObject = ((a)localObject).yAd;
    kotlin.g.b.p.k(parame, "visibleState");
    kotlin.g.b.p.k(paramc, "event");
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    if (kotlin.a.e.contains(((f)localObject).yAF, paramString))
    {
      int i;
      switch (g.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        if (kotlin.g.b.p.h(paramString, "61"))
        {
          paramString = "temp_6";
          i = 1;
          label179:
          ((f)localObject).yAD = paramt;
          ((f)localObject).yAE = paramString;
          if (i == 0) {
            break label793;
          }
          if (paramc != c.yAj) {
            break label583;
          }
          parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.wpp;
          parame = (com.tencent.mm.plugin.expt.hellhound.a.g.a)((f)localObject).yAL;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion = -1;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.mVisibleItemCount = -1;
          com.tencent.mm.plugin.expt.hellhound.a.g.d.wph.clear();
          if (parame != null) {
            com.tencent.mm.plugin.expt.hellhound.a.g.d.listeners.remove(parame);
          }
          ((f)localObject).yAJ = true;
          label251:
          if (((f)localObject).yAJ) {
            break label786;
          }
          parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.wpp;
          if (paramAbsListView == null) {
            break label898;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.g.d.mScreenHeight <= 0)
          {
            paramt = paramAbsListView.getContext();
            parame = paramt;
            if (!(paramt instanceof AppCompatActivity)) {
              parame = null;
            }
            parame = (AppCompatActivity)parame;
            paramt = (Activity)parame;
            if (paramt != null)
            {
              paramt = paramt.getResources();
              i = paramt.getDimensionPixelSize(paramt.getIdentifier("status_bar_height", "dimen", "android"));
              com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = i;
              if (i <= 0) {
                com.tencent.mm.plugin.expt.hellhound.a.g.d.mStatusBarHeight = paramt.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
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
          label468:
          if (paramInt1 < 0) {
            break label786;
          }
          parame = paramAbsListView.getChildAt(paramInt1);
          if (parame != null) {
            break label615;
          }
        }
        break;
      }
      for (;;)
      {
        paramInt1 -= 1;
        break label468;
        if (((f)localObject).yAC) {
          break;
        }
        ((f)localObject).dDc();
        ((f)localObject).yAC = true;
        break;
        if (!((f)localObject).yAC) {
          break;
        }
        ((f)localObject).dDd();
        ((f)localObject).yAC = false;
        break;
        if (!paramBoolean) {
          break;
        }
        ((f)localObject).dDc();
        ((f)localObject).yAC = true;
        break;
        ((f)localObject).dDd();
        ((f)localObject).yAC = false;
        break;
        ((f)localObject).yAy.clear();
        break;
        i = 0;
        break label179;
        label583:
        if (paramc != c.yAi) {
          break label251;
        }
        ((f)localObject).yAJ = false;
        parame = com.tencent.mm.plugin.expt.hellhound.a.g.d.wpp;
        com.tencent.mm.plugin.expt.hellhound.a.g.d.registerListener((com.tencent.mm.plugin.expt.hellhound.a.g.a)((f)localObject).yAL);
        break label251;
        label615:
        paramString = com.tencent.mm.plugin.expt.hellhound.a.g.d._getHellFeed(parame, paramInt1, paramAbsListView, com.tencent.mm.plugin.expt.hellhound.a.g.d.mFirstPostion);
        if (paramString != null)
        {
          paramt = (com.tencent.mm.plugin.expt.hellhound.a.a.c)paramString.ieT();
          paramString = (Boolean)paramString.ieU();
          kotlin.g.b.p.j(paramString, "isShow");
          if (paramString.booleanValue())
          {
            if (!com.tencent.mm.plugin.expt.hellhound.a.g.d.wph.containsKey(paramt.whE.feedId))
            {
              paramString = (Map)com.tencent.mm.plugin.expt.hellhound.a.g.d.wph;
              paramc = paramt.whE.feedId;
              kotlin.g.b.p.j(paramc, "snsFeed.feed.feedId");
              kotlin.g.b.p.j(paramt, "snsFeed");
              paramString.put(paramc, paramt);
              com.tencent.mm.plugin.expt.hellhound.a.g.d.onFeedAppear(paramBaseAdapter, paramt, parame);
            }
          }
          else if (com.tencent.mm.plugin.expt.hellhound.a.g.d.wph.containsKey(paramt.whE.feedId))
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.d.wph.remove(paramt.whE.feedId);
            kotlin.g.b.p.j(paramt, "snsFeed");
            com.tencent.mm.plugin.expt.hellhound.a.g.d.dfP();
          }
        }
      }
      label786:
      AppMethodBeat.o(288937);
      return;
      label793:
      if (paramc != c.yAj) {
        break label905;
      }
      parame = ((f)localObject).yAI;
      if (parame == null) {
        kotlin.g.b.p.bGy("unregister_method");
      }
      parame.invoke(null, new Object[] { ((f)localObject).yAK });
      ((f)localObject).yAJ = true;
    }
    for (;;)
    {
      if (!((f)localObject).yAJ)
      {
        parame = ((f)localObject).yAG;
        if (parame == null) {
          kotlin.g.b.p.bGy("monitor_method");
        }
        parame.invoke(null, new Object[] { paramAbsListView, paramBaseAdapter, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
      label898:
      AppMethodBeat.o(288937);
      return;
      label905:
      if (paramc == c.yAi)
      {
        ((f)localObject).yAJ = false;
        parame = ((f)localObject).yAH;
        if (parame == null) {
          kotlin.g.b.p.bGy("register_method");
        }
        parame.invoke(null, new Object[] { ((f)localObject).yAK });
      }
    }
  }
  
  public static void a(RecyclerView paramRecyclerView, s.t paramt, String paramString, c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288941);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    kotlin.g.b.p.k(paramc, "event");
    if (!kotlin.g.b.p.h(paramString, "80"))
    {
      str = paramString;
      if (!kotlin.g.b.p.h(paramString, "94")) {}
    }
    else
    {
      paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (!com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddB()) {
        break label166;
      }
    }
    label166:
    for (String str = "80";; str = "94")
    {
      if (paramc == c.yAi)
      {
        paramString = yBe;
        kotlin.g.b.p.k(str, "<set-?>");
        paramString.yDf = str;
      }
      com.tencent.mm.plugin.expt.hellhound.core.b.awV(((com.tencent.c.a.b.a.e)h.ag(com.tencent.c.a.b.a.e.class)).getNearbyTabLifecycleReporter().agX());
      com.tencent.mm.plugin.expt.hellhound.core.b.awU(((com.tencent.c.a.b.a.e)h.ag(com.tencent.c.a.b.a.e.class)).getNearbyTabLifecycleReporter().dMz());
      if ((paramInt1 != -1) || (!yBi.contains(Integer.valueOf(paramInt2)))) {
        break;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkv = paramInt2;
      AppMethodBeat.o(288941);
      return;
    }
    if ((paramInt1 != -100) && (paramInt2 != -100))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkv = paramInt2;
      if (paramInt1 == 1001) {
        paramString = c.yAj;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          yBf.a(paramRecyclerView, paramt, str, paramString);
          AppMethodBeat.o(288941);
          return;
          if (paramInt2 != 1001) {
            break;
          }
          paramString = c.yAi;
        }
        AppMethodBeat.o(288941);
        return;
        if (paramc == c.yAi) {
          break;
        }
        paramString = paramc;
      } while (paramc != c.yAj);
      paramString = paramc;
    } while (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkv == 1001);
    AppMethodBeat.o(288941);
  }
  
  private static void a(de paramde, long paramLong)
  {
    AppMethodBeat.i(288961);
    paramde.oQ(s.dDw());
    paramde.oR(yBe.dDs());
    paramde.ly(s.dDx());
    paramde.oS(s.dDv());
    paramde.hB(paramLong);
    AppMethodBeat.o(288961);
  }
  
  public static void a(dg paramdg, String paramString)
  {
    AppMethodBeat.i(288962);
    kotlin.g.b.p.k(paramdg, "struct");
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      paramdg.pk(str);
      paramdg.ix(s.aCG(paramString));
      paramdg.pm(s.dDv());
      paramdg.ir(System.currentTimeMillis());
      AppMethodBeat.o(288962);
      return;
    }
  }
  
  private static void a(dp paramdp)
  {
    AppMethodBeat.i(288960);
    paramdp.qG(s.dDw());
    paramdp.qH(yBe.dDs());
    paramdp.lK(s.dDx());
    paramdp.qI(s.dDv());
    paramdp.ju(System.currentTimeMillis());
    AppMethodBeat.o(288960);
  }
  
  public static void a(s.ae paramae, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288928);
    kotlin.g.b.p.k(paramae, "linkOp");
    switch (l.yBl[paramae.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        for (;;)
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("type", paramae.action);
          paramae = paramString;
          if (paramString == null) {
            paramae = "";
          }
          ((JSONObject)localObject).put("result", paramae);
          ((JSONObject)localObject).put("MicType", paramInt1);
          ((JSONObject)localObject).put("InviteType", paramInt2);
          a(s.c.yEz, ((JSONObject)localObject).toString());
          AppMethodBeat.o(288928);
          return;
          localObject = yBe;
          ((s)localObject).yCT += 1;
          yBe.yCe.add(com.tencent.mm.vending.j.a.h(s.ag.yIt, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
          continue;
          localObject = yBe;
          ((s)localObject).yCT += 1;
          yBe.yCe.add(com.tencent.mm.vending.j.a.h(s.ag.yIu, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
          continue;
          if (!yBe.yCX)
          {
            a(s.ag.yIt);
            AppMethodBeat.o(288928);
            return;
          }
          yBe.yCX = false;
          a(s.ag.yIt);
          continue;
          if (yBe.yCZ)
          {
            a(s.ag.yIu);
            yBe.yCZ = false;
            AppMethodBeat.o(288928);
            return;
          }
          a(s.ag.yIu);
          continue;
          if (paramString == null)
          {
            AppMethodBeat.o(288928);
            return;
          }
          yBe.yCU = true;
          yBe.yCV.add(com.tencent.mm.vending.j.a.h(paramString, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        }
      } while (!yBe.yCU);
      dDh();
      AppMethodBeat.o(288928);
      return;
    }
    dDh();
    AppMethodBeat.o(288928);
  }
  
  private static void a(s.ag paramag)
  {
    AppMethodBeat.i(288931);
    long l1 = System.currentTimeMillis();
    int i = yBe.yCe.size() - 1;
    while (i >= 0)
    {
      Object localObject = yBe.yCe.get(i);
      kotlin.g.b.p.j(localObject, "mConfig.gLinkMicTimeList[i]");
      localObject = (com.tencent.mm.vending.j.d)localObject;
      if (((s.ag)((com.tencent.mm.vending.j.d)localObject).ieT() == paramag) && (((Number)((com.tencent.mm.vending.j.d)localObject).ieU()).longValue() > 0L) && (kotlin.g.b.p.h((Boolean)((com.tencent.mm.vending.j.d)localObject).ieV(), Boolean.FALSE)))
      {
        localObject = ((com.tencent.mm.vending.j.d)localObject).ieU();
        kotlin.g.b.p.j(localObject, "tuple.`$2`()");
        long l2 = (l1 - ((Number)localObject).longValue()) / 1000L;
        if (l2 >= 0L)
        {
          yBe.yCe.set(i, com.tencent.mm.vending.j.a.h(paramag, Long.valueOf(l2), Boolean.TRUE));
          AppMethodBeat.o(288931);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(288931);
  }
  
  public static void a(s.ak paramak, String paramString1, String paramString2)
  {
    AppMethodBeat.i(288935);
    kotlin.g.b.p.k(paramak, "actionType");
    kotlin.g.b.p.k(paramString2, "description");
    if (paramak == s.ak.yJc)
    {
      localObject = g.wlD;
      g.a.KQ(0);
    }
    Object localObject = new du();
    ((du)localObject).qO(s.dDw());
    ((du)localObject).qP(yBe.dDs());
    ((du)localObject).lL(s.dDx());
    ((du)localObject).qQ(s.dDv());
    ((du)localObject).jS(System.currentTimeMillis());
    ((du)localObject).jT(paramak.jWO);
    paramak = paramString1;
    if (paramString1 == null) {
      paramak = "";
    }
    ((du)localObject).qR(paramak);
    ((du)localObject).jU(yBe.yDG.source);
    ((du)localObject).ajW();
    paramak = paramString2.getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.p.j(paramak, "(this as java.lang.String).getBytes(charset)");
    ((du)localObject).qS(Base64.encodeToString(paramak, 0));
    ((du)localObject).bpa();
    Log.i("HABBYGE-MALI.HellLiveReport", "report21106: finderUsrname=" + ((du)localObject).ahx() + ", finderWxAppInfo=" + ((du)localObject).ahy() + ", isPrivate=" + ((du)localObject).ahz() + ", finderSessionId=" + ((du)localObject).ahA() + ", actionTimeMs=" + ((du)localObject).ahB() + ", actionType=" + ((du)localObject).ahC() + ", sourceScene=" + ((du)localObject).aic() + ", actionJson=" + ((du)localObject).ajI());
    AppMethodBeat.o(288935);
  }
  
  public static void a(s.am paramam, String paramString)
  {
    AppMethodBeat.i(288934);
    kotlin.g.b.p.k(paramam, "actionType");
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.awY(paramString))
    {
      AppMethodBeat.o(288934);
      return;
    }
    ck localck = new ck();
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      localck.mu(str);
      localck.mv(yBe.dDs());
      localck.lr(s.aCG(paramString));
      localck.mw(s.dDv());
      localck.fv(System.currentTimeMillis());
      localck.fw(paramam.jWO);
      localck.bpa();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21113: finderUsrname=" + localck.ahx() + ", finderWxAppInfo=" + localck.ahy() + ", isPrivate=" + localck.ahz() + ", finderSessionId=" + localck.ahA() + ", actionTimeMs=" + localck.ahB() + ", actionJson=" + localck.ahC());
      AppMethodBeat.o(288934);
      return;
    }
  }
  
  public static void a(s.aq paramaq)
  {
    AppMethodBeat.i(288920);
    kotlin.g.b.p.k(paramaq, "action");
    switch (l.jLJ[paramaq.ordinal()])
    {
    }
    do
    {
      for (;;)
      {
        dh localdh = new dh();
        localdh.iB(System.currentTimeMillis());
        localdh.iC(paramaq.action);
        localdh.iA(yBe.yDE.type);
        String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
        paramaq = str;
        if (str == null) {
          paramaq = "";
        }
        localdh.pA(paramaq);
        localdh.py(((com.tencent.c.a.b.a.e)h.ag(com.tencent.c.a.b.a.e.class)).getNearbyTabLifecycleReporter().agX());
        localdh.pz(((com.tencent.c.a.b.a.e)h.ag(com.tencent.c.a.b.a.e.class)).getNearbyTabLifecycleReporter().dMz());
        localdh.bpa();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21631: actionTS=" + localdh.ahg() + ", pageType=" + localdh.ahk() + ", action=" + localdh.ahh() + ", clickid=" + localdh.aiT() + ", session_Id=" + localdh.aiV() + ", contextID=" + localdh.aiU() + ", clickTabContextId=" + localdh.agY());
        AppMethodBeat.o(288920);
        return;
        kwg = false;
        continue;
        kwg = true;
        yBe.b(s.bc.yKO);
      }
    } while (!kwg);
    kwg = false;
    AppMethodBeat.o(288920);
  }
  
  public static void a(s.ax paramax)
  {
    AppMethodBeat.i(288929);
    kotlin.g.b.p.k(paramax, "action");
    Log.w("HABBYGE-MALI.HellLiveReport", "reportVest, action: " + paramax.name());
    switch (l.yBm[paramax.ordinal()])
    {
    default: 
      if (yBe.yDc)
      {
        kotlin.g.b.p.k(paramax, "action");
        switch (t.jLJ[paramax.ordinal()])
        {
        default: 
          paramax = s.k.yFF;
        }
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        a(paramax);
        AppMethodBeat.o(288929);
        return;
        if ((yBh) || (yBe.yDc)) {
          break;
        }
        AppMethodBeat.o(288929);
        return;
        paramax = s.k.yFJ;
        continue;
        paramax = s.k.yFK;
        continue;
        paramax = s.k.yFL;
        continue;
        paramax = s.k.yFM;
        continue;
        paramax = s.k.yFN;
      }
    }
    a(s.c.yEB, String.valueOf(paramax.action));
    AppMethodBeat.o(288929);
  }
  
  public static void a(s.c paramc, String paramString)
  {
    AppMethodBeat.i(288930);
    kotlin.g.b.p.k(paramc, "actionType");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      AppMethodBeat.o(288930);
      return;
    }
    long l = System.currentTimeMillis();
    de localde;
    switch (l.yBn[paramc.ordinal()])
    {
    default: 
      localde = new de();
      a(localde, l);
      localde.oT(yBe.dDt());
      localde.oU(yBe.dDu());
      if (TextUtils.isEmpty((CharSequence)yBe.yDw.description))
      {
        localObject = s.getDescription();
        label138:
        localde.oV((String)localObject);
        localde.hC(yBe.yDv);
        localde.hD(yBe.yDt);
        localde.hE(yBe.yDu);
        localde.hF(paramc.action);
        switch (l.yBo[paramc.ordinal()])
        {
        default: 
          if (paramString != null)
          {
            paramString = n.l(paramString, ",", ";", false);
            paramc = paramString;
            if (paramString != null) {}
          }
          else
          {
            paramc = "";
          }
          localde.oW(paramc);
        }
      }
      break;
    }
    for (;;)
    {
      localde.hG(yBe.yDF.source);
      localde.bpa();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21054: finderUsrname=" + localde.ahx() + ", finderWxAppInfo=" + localde.ahy() + ", isPrivate=" + localde.ahz() + ", finderSessionId=" + localde.ahA() + ", actionTimeMs=" + localde.ahB() + ", liveId=" + localde.ahY() + ", feedId=" + localde.ahZ() + ", description=" + localde.getDescription() + ", sourceScene=" + localde.aic() + ", liveTime=" + localde.ahc() + ", likeCount=" + localde.aia() + ", onlineCount=" + localde.aib() + ", actionType=" + localde.ahC() + ", actionResult=" + localde.ahi());
      AppMethodBeat.o(288930);
      return;
      yBe.yDb = l;
      yBe.yDw.yNq = l;
      break;
      if (!kotlin.g.b.p.h(paramString, String.valueOf(s.z.yHF.action))) {
        break;
      }
      yBe.a(s.ab.yHK);
      break;
      if (yBe.yDv > 0L) {
        break;
      }
      AppMethodBeat.o(288930);
      return;
      if (!kotlin.g.b.p.h(paramString, String.valueOf(s.v.yHm.type))) {
        break;
      }
      yBe.yCL = false;
      yBe.yCM = false;
      break;
      if (kotlin.g.b.p.h(paramString, String.valueOf(s.ax.yKm.action)))
      {
        yBh = true;
        break;
      }
      if (!kotlin.g.b.p.h(paramString, String.valueOf(s.ax.yKo.action))) {
        break;
      }
      yBh = false;
      break;
      localObject = yBe.yDw.description;
      break label138;
      localde.oW(dDf());
      continue;
      localde.oW(dDg());
    }
  }
  
  public static void a(s.e parame, String paramString)
  {
    AppMethodBeat.i(288919);
    kotlin.g.b.p.k(parame, "action");
    kotlin.g.b.p.k(paramString, "actionResult");
    long l = System.currentTimeMillis();
    switch (l.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      dk localdk = new dk();
      localdk.iI(parame.type);
      localdk.pV(paramString);
      localdk.iJ(l);
      localdk.pW(String.valueOf(yBe.yDb));
      localdk.bpa();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21919: actionType=" + localdk.ahC() + ", actionResult=" + localdk.ahi() + ", actionTimeMs=" + localdk.ahB() + ", sessionId=" + localdk.getSessionId());
      AppMethodBeat.o(288919);
      return;
      if (kotlin.g.b.p.h(paramString, String.valueOf(s.k.yFH.action)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkr = String.valueOf(yBe.yDb);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wks = l;
      }
      else if (kotlin.g.b.p.h(paramString, String.valueOf(s.k.yFG.action)))
      {
        yBe.yDc = true;
      }
      else if ((kotlin.g.b.p.h(paramString, String.valueOf(s.k.yFI.action))) && (!yBe.yDc))
      {
        AppMethodBeat.o(288919);
        return;
        yBe.yDc = false;
      }
    }
  }
  
  public static void a(s.f paramf, String paramString)
  {
    AppMethodBeat.i(288926);
    kotlin.g.b.p.k(paramf, "type");
    Object localObject1;
    switch (l.yBk[paramf.ordinal()])
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
          a(s.c.yEt, ((JSONObject)localObject2).toString());
          AppMethodBeat.o(288926);
          return;
          yBe.yCL = true;
          localObject1 = null;
          continue;
          yBe.yCM = true;
          localObject1 = null;
        }
      } while (!TextUtils.isEmpty((CharSequence)paramString));
      AppMethodBeat.o(288926);
      return;
    }
    if (paramString != null) {}
    try
    {
      localObject1 = n.a((CharSequence)paramString, new String[] { "@" });
      if (localObject1 == null)
      {
        AppMethodBeat.o(288926);
        return;
      }
    }
    catch (Exception paramf)
    {
      Log.e("HABBYGE-MALI.HellLiveReport", "START_LOTTERY_SUCCESS crash: " + paramf.getMessage());
      AppMethodBeat.o(288926);
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
      kotlin.g.b.p.j(localObject1, "if (lotteryType == Const…live_lottery_any_comment)");
      localObject1 = (String)localObject1 + ';' + (String)((List)localObject2).get(1) + ';' + (String)((List)localObject2).get(2) + ';' + (String)((List)localObject2).get(3);
      localObject2 = yBe;
      ((s)localObject2).yCK += 1L;
      break;
      if (i == 2) {
        localObject1 = MMApplicationContext.getResources().getString(b.j.finder_live_lottery_like);
      } else {
        label420:
        localObject1 = MMApplicationContext.getResources().getString(b.j.finder_live_lottery_any_comment);
      }
    }
  }
  
  public static void a(s.k paramk)
  {
    AppMethodBeat.i(288918);
    kotlin.g.b.p.k(paramk, "action");
    Log.w("HABBYGE-MALI.HellLiveReport", "report21919OnVest, action: " + paramk.name());
    if (paramk == s.k.yFF)
    {
      AppMethodBeat.o(288918);
      return;
    }
    a(s.e.yEP, String.valueOf(paramk.action));
    AppMethodBeat.o(288918);
  }
  
  public static void a(s.o paramo)
  {
    AppMethodBeat.i(288964);
    kotlin.g.b.p.k(paramo, "coverType");
    yBe.yDs = paramo.type;
    AppMethodBeat.o(288964);
  }
  
  public static void a(s.s params)
  {
    AppMethodBeat.i(288923);
    kotlin.g.b.p.k(params, "type");
    ey localey = new ey();
    localey.ts(s.dDw());
    localey.tt(yBe.dDs());
    localey.mr(s.dDx());
    localey.tu(s.dDv());
    localey.mA(System.currentTimeMillis());
    localey.mH(params.fwf);
    Object localObject1 = h.aHG();
    kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
    localey.mB(((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VAx, 0));
    localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    kotlin.g.b.p.j(localObject1, "ConfigHelper.getInstance()");
    if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLM().kpc == 0) {}
    for (int i = 2;; i = 1)
    {
      localey.mC(i);
      localey.mD(yBe.yDp);
      localey.mE(System.currentTimeMillis() - localey.akk());
      localey.mG(yBe.yDq);
      Object localObject3 = yBe;
      localObject1 = ((s)localObject3).yDr;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).toString();
        if (localObject1 != null)
        {
          localObject2 = n.l((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label242;
          }
        }
      }
      localObject1 = "";
      label242:
      ((s)localObject3).yDr = null;
      localey.tv((String)localObject1);
      localObject3 = yBe;
      localObject1 = ((s)localObject3).desc;
      if (localObject1 != null)
      {
        localObject2 = n.l((String)localObject1, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((s)localObject3).desc = null;
      localey.tw((String)localObject1);
      localey.mF(yBe.yDs);
      localey.tB("");
      localey.tA("");
      localObject1 = yBe.yDC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localObject3 = localey.akq();
        localey.tA((String)localObject3 + localObject2 + '#');
      }
    }
    localObject1 = localey.akq();
    kotlin.g.b.p.j(localObject1, "struct.goodsListJson");
    if (n.pu((String)localObject1, "#"))
    {
      localObject1 = localey.akq();
      kotlin.g.b.p.j(localObject1, "struct.goodsListJson");
      i = localey.akq().length();
      if (localObject1 == null)
      {
        params = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(288923);
        throw params;
      }
      localObject1 = ((String)localObject1).substring(0, i - 1);
      kotlin.g.b.p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localey.tA((String)localObject1);
    }
    switch (l.tKM[params.ordinal()])
    {
    default: 
      localey.tC(dDf());
      localey.tD(dDg());
      localey.tG(String.valueOf(yBe.yCY.action));
      localey.mI(yBe.yDF.source);
      localey.tE(com.tencent.mm.compatible.util.q.an(yBe.tag, "UTF-8"));
      localey.tF(com.tencent.mm.compatible.util.q.an(yBe.yDg, "UTF-8"));
      localey.mJ(yBe.yDj.type);
      if (yBe.yDj != s.be.yKV) {
        break;
      }
    }
    for (long l = yBe.yDk;; l = 0L)
    {
      localey.mK(l);
      params = a.a.ydc;
      localey.tH(a.a.dxM());
      localey.bpa();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21024: finderUsrname=" + localey.ahx() + ", finderWxAppInfo=" + localey.ahy() + ", isPrivate=" + localey.ahz() + ", finderSessionId=" + localey.ahA() + ", actionTimeMs=" + localey.ahB() + ", exitType=" + localey.aiw() + ", fansCount=" + localey.aki() + ", cameraStatus=" + localey.akj() + ", enterUITimeMs=" + localey.akk() + ", stayTimeMs=" + localey.akl() + ", coverType=" + localey.akm() + ", ruleType=" + localey.akn() + ", poiJson=" + localey.ako() + ", description=" + localey.getDescription() + ", liveId=" + localey.ahY() + ", feedId=" + localey.ahZ() + ", errorCode=" + localey.akp() + ", goodsListJson=" + localey.akq() + ", retouchResult=" + localey.akr() + ", filtersResult=" + localey.aks() + ", connectSwitch=" + localey.akt() + ", sourceScene=" + localey.aic() + ", tag=" + yBe.tag + ", subTag=" + yBe.yDg + ", visibleRange=" + localey.ajG() + ", beautyResult=" + localey.aku() + ", shopWindowId=" + localey.ajA());
      AppMethodBeat.o(288923);
      return;
      localey.tx(yBe.dDt());
      localey.ty(yBe.dDu());
      localey.tz("0");
      break;
      localey.tx(yBe.dDt());
      localey.ty(yBe.dDu());
      localey.tz(String.valueOf(yBe.errCode));
      break;
      localey.tx("0");
      localey.ty("0");
      localey.tz(String.valueOf(yBe.errCode));
      break;
      localey.tx("0");
      localey.ty("0");
      localey.tz("0");
      yBe.setTag("");
      yBe.aCE("");
      yBe.a(s.be.yKU);
      yBe.yDk = 0L;
      break;
    }
  }
  
  public static void a(s.t paramt, FeedData paramFeedData)
  {
    AppMethodBeat.i(288939);
    kotlin.g.b.p.k(paramt, "type");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(288939);
      return;
    }
    yBf.a(paramt, yBe.yDd, String.valueOf(yBe.yDe), paramFeedData);
    AppMethodBeat.o(288939);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, FinderLiveBundle paramFinderLiveBundle)
  {
    AppMethodBeat.i(288921);
    if (yBe.yDy)
    {
      AppMethodBeat.o(288921);
      return;
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    JSONObject localJSONObject = new JSONObject();
    int i;
    if ((paramf == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramf.xWR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId <= 0L)) {
      if (paramFinderLiveBundle != null)
      {
        paramf = paramFinderLiveBundle.xPy;
        if (paramf != null) {
          break label196;
        }
        paramf = g.wlD;
        i = g.a.deg();
        if (i > 0) {
          break label155;
        }
        localJSONObject.put("type", s.an.yJr.type);
      }
    }
    for (;;)
    {
      t(s.a.yDL.jWO, localJSONObject.toString());
      b(s.s.yGK);
      a(s.o.yGp);
      yBe.yDp = System.currentTimeMillis();
      AppMethodBeat.o(288921);
      return;
      paramf = null;
      break;
      label155:
      if (j < i)
      {
        localJSONObject.put("type", s.an.yJs.type);
      }
      else
      {
        localJSONObject.put("type", s.an.yJr.type);
        continue;
        label196:
        if (paramFinderLiveBundle != null)
        {
          paramf = paramFinderLiveBundle.xPy;
          if (paramf == null) {}
        }
        for (i = paramf.fod;; i = 0)
        {
          if (j >= i) {
            break label242;
          }
          localJSONObject.put("type", s.an.yJs.type);
          break;
        }
        label242:
        localJSONObject.put("type", s.an.yJr.type);
        continue;
        localJSONObject.put("type", s.an.yJt.type);
        localJSONObject.put("liveid", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramf.xWR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.utils.b paramb)
  {
    AppMethodBeat.i(288940);
    Object localObject = yBg;
    a locala = yBf;
    s locals = yBe;
    kotlin.g.b.p.k(locala, "m21053Reporter");
    kotlin.g.b.p.k(locals, "config");
    if (paramb == null)
    {
      AppMethodBeat.o(288940);
      return;
    }
    if (paramb.feed == null)
    {
      AppMethodBeat.o(288940);
      return;
    }
    if (!kotlin.g.b.p.h(s.l.yFW.scene, String.valueOf(locals.yDe)))
    {
      FeedData localFeedData = paramb.feed;
      long l;
      if (localFeedData != null) {
        l = localFeedData.getFeedId();
      }
      while (((b)localObject).yAf != l)
      {
        ((b)localObject).yAf = l;
        if (paramb.ACQ != 9)
        {
          localObject = paramb.feed;
          if (localObject != null)
          {
            if (((FeedData)localObject).getLiveStatus() != 1)
            {
              AppMethodBeat.o(288940);
              return;
              l = 0L;
            }
          }
          else
          {
            AppMethodBeat.o(288940);
            return;
          }
          locala.a(s.t.yGO, paramb.ACR, String.valueOf(locals.yDe), paramb.feed);
        }
      }
    }
    AppMethodBeat.o(288940);
  }
  
  public static void aR(JSONObject paramJSONObject)
  {
    yBe.yDr = paramJSONObject;
  }
  
  public static void b(RecyclerView paramRecyclerView, s.t paramt, String paramString, c paramc)
  {
    AppMethodBeat.i(288938);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    kotlin.g.b.p.k(paramc, "event");
    Object localObject = paramString;
    String str;
    if (kotlin.g.b.p.h(paramString, "25"))
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      kotlin.g.b.p.j(localObject, "HellSessionMonitor.getInstance()");
      str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).deK();
      localObject = paramString;
      if (str != null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localObject = paramString;
        if (!c.a.axK(str)) {
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
      yBf.a(paramRecyclerView, paramt, (String)localObject, paramc);
      AppMethodBeat.o(288938);
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
  
  private static void b(p paramp)
  {
    AppMethodBeat.i(288956);
    u(paramp.yCx, paramp.yAP);
    yBe.a(paramp.yAO, paramp.yAP);
    yBf.a(paramp);
    AppMethodBeat.o(288956);
  }
  
  public static void b(q paramq)
  {
    AppMethodBeat.i(288953);
    kotlin.g.b.p.k(paramq, "enterData");
    u(paramq.yCx, paramq.yAP);
    yBe.a(paramq.yAO, "");
    a locala = yBf;
    kotlin.g.b.p.k(paramq, "enterData");
    dg localdg = new dg();
    Object localObject = yBj;
    a(localdg, paramq.userName);
    localdg.pl(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramq.feedId));
    localdg.iq(paramq.liveId);
    localdg.pt(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramq.liveId));
    localdg.is(paramq.yAO.fwf);
    localdg.pn(paramq.yAP);
    localdg.it(paramq.yCx);
    localdg.iu(paramq.yCC);
    localdg.iv(paramq.yCz);
    localdg.po(paramq.kit);
    localdg.pu(paramq.yCA);
    localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
    localdg.iw(paramq.yCy);
    localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
    if (n.M(paramq.yAP, "temp_", false)) {
      if (kotlin.g.b.p.h(localdg.agV(), "temp_2"))
      {
        localObject = yBj;
        localdg.pr(yBe.yDi);
        localdg.iy(paramq.enterTime);
        localdg.iz(paramq.yCD.type);
        if (!kotlin.g.b.p.h(localdg.agV(), "61"))
        {
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
          if (!kotlin.g.b.p.h(b.a.deK(), "123")) {}
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)) {
            break label795;
          }
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          kotlin.g.b.p.j(paramq, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label795:
    for (paramq = paramq.deL();; paramq = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)
    {
      localdg.pv(paramq);
      localdg.bpa();
      Log.i(locala.TAG, "report21053OnClickOnShare, struct=\nfeedId=" + localdg.agT() + '\n' + "liveId=" + localdg.aiN() + '\n' + "userName=" + localdg.getUserName() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionID=" + localdg.agZ() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "enterSessionId=" + localdg.aiP() + '\n' + "enterIconType=" + localdg.ahj() + '\n' + "snsSessionID=" + localdg.aiQ() + '\n' + "snsFeedId=" + localdg.aiO());
      AppMethodBeat.o(288953);
      return;
      localdg.pr(paramq.yAP);
      break;
      long l = paramq.feedId;
      localObject = localdg.agV();
      kotlin.g.b.p.j(localObject, "struct.commentScene");
      localdg.pr(a.T(l, Long.parseLong((String)localObject)));
      break;
    }
  }
  
  public static void b(s.s params)
  {
    AppMethodBeat.i(288963);
    kotlin.g.b.p.k(params, "exitType");
    yBe.c(params);
    AppMethodBeat.o(288963);
  }
  
  private static void c(q paramq)
  {
    AppMethodBeat.i(288957);
    dDj();
    yBf.a(paramq);
    AppMethodBeat.o(288957);
  }
  
  private static String dDf()
  {
    int j = 0;
    AppMethodBeat.i(288924);
    Object localObject1 = yBe;
    Object localObject2 = ah.yhC;
    localObject2 = ah.aOk();
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).kra;
      if (localObject2 != null)
      {
        localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(0));
        if (localObject2 != null)
        {
          i = ((Integer)localObject2).intValue();
          ((s)localObject1).yCN = i;
          localObject1 = yBe;
          localObject2 = ah.yhC;
          localObject2 = ah.aOk();
          if (localObject2 == null) {
            break label358;
          }
          localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).kra;
          if (localObject2 == null) {
            break label358;
          }
          localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(2));
          if (localObject2 == null) {
            break label358;
          }
          i = ((Integer)localObject2).intValue();
          label105:
          ((s)localObject1).yCO = i;
          localObject1 = yBe;
          localObject2 = ah.yhC;
          localObject2 = ah.aOk();
          if (localObject2 == null) {
            break label363;
          }
          localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).kra;
          if (localObject2 == null) {
            break label363;
          }
          localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(3));
          if (localObject2 == null) {
            break label363;
          }
          i = ((Integer)localObject2).intValue();
          label156:
          ((s)localObject1).yCP = i;
          localObject1 = yBe;
          localObject2 = ah.yhC;
          localObject2 = ah.aOk();
          if (localObject2 == null) {
            break label368;
          }
          localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).kra;
          if (localObject2 == null) {
            break label368;
          }
          localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(1));
          if (localObject2 == null) {
            break label368;
          }
        }
      }
    }
    label358:
    label363:
    label368:
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      ((s)localObject1).yCQ = i;
      localObject1 = yBe;
      localObject2 = ah.yhC;
      localObject2 = ah.aOk();
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).kra;
        i = j;
        if (localObject2 != null)
        {
          localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(4));
          i = j;
          if (localObject2 != null) {
            i = ((Integer)localObject2).intValue();
          }
        }
      }
      ((s)localObject1).yCR = i;
      localObject1 = yBe.yCN + ';' + yBe.yCO + ';' + yBe.yCP + ';' + yBe.yCQ + ';' + yBe.yCR;
      AppMethodBeat.o(288924);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label105;
      i = 0;
      break label156;
    }
  }
  
  private static String dDg()
  {
    AppMethodBeat.i(288925);
    Object localObject2 = yBe;
    Object localObject1 = ah.yhC;
    localObject1 = ah.aOl();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.b.b)localObject1).krc;
      ((s)localObject2).yCS = s.aCF((String)localObject1).type;
      localObject1 = yBe;
      localObject2 = ah.yhC;
      localObject2 = ah.aOl();
      if (localObject2 == null) {
        break label137;
      }
    }
    label137:
    for (int i = ((com.tencent.mm.live.core.b.b)localObject2).krd;; i = 0)
    {
      ((s)localObject1).krd = i;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", yBe.yCS);
      ((JSONObject)localObject1).put("result", yBe.krd);
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.p.j(localObject1, "json.toString()");
      localObject1 = n.l((String)localObject1, ",", ";", false);
      AppMethodBeat.o(288925);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  private static void dDh()
  {
    AppMethodBeat.i(288932);
    long l1 = System.currentTimeMillis();
    int i = yBe.yCV.size() - 1;
    while (i >= 0)
    {
      Object localObject1 = yBe.yCV.get(i);
      kotlin.g.b.p.j(localObject1, "mConfig.gAnchorLinkMicTimeList[i]");
      localObject1 = (com.tencent.mm.vending.j.d)localObject1;
      if ((((Number)((com.tencent.mm.vending.j.d)localObject1).ieU()).longValue() > 0L) && (kotlin.g.b.p.h((Boolean)((com.tencent.mm.vending.j.d)localObject1).ieV(), Boolean.FALSE)))
      {
        Object localObject2 = ((com.tencent.mm.vending.j.d)localObject1).ieU();
        kotlin.g.b.p.j(localObject2, "tuple.`$2`()");
        long l2 = (l1 - ((Number)localObject2).longValue()) / 1000L;
        if (l2 >= 0L)
        {
          yBe.yCV.set(i, com.tencent.mm.vending.j.a.h(((com.tencent.mm.vending.j.d)localObject1).ieT(), Long.valueOf(l2), Boolean.TRUE));
          AppMethodBeat.o(288932);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(288932);
  }
  
  public static void dDi()
  {
    AppMethodBeat.i(288933);
    long l = yBe.yDw.yNq;
    if (l <= 0L)
    {
      AppMethodBeat.o(288933);
      return;
    }
    do localdo = new do();
    localdo.qt(s.dDw());
    localdo.qu(yBe.dDs());
    localdo.lI(s.dDx());
    localdo.qv(s.dDv());
    localdo.iS(System.currentTimeMillis());
    localdo.iX(yBe.yDw.yNu);
    localdo.iY(yBe.yDw.yNv);
    localdo.iZ(yBe.yDw.yNw);
    localdo.iV(yBe.yDw.yNt);
    Object localObject2 = yBe.yDw.kwM;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!kotlin.g.b.p.h(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!kotlin.g.b.p.h(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = yBe.dDt();
    }
    localdo.qw((String)localObject1);
    localObject2 = yBe.yDw.feedId;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!kotlin.g.b.p.h(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!kotlin.g.b.p.h(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = yBe.dDu();
    }
    localdo.qx((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)yBe.yDw.description))
    {
      localObject1 = s.getDescription();
      localdo.qy((String)localObject1);
      localdo.iT(l);
      localdo.iU(yBe.yDw.yNr);
      localdo.iW(yBe.yDw.yNs);
      localdo.lJ(yBe.yDw.errorCode);
      localdo.ja(yBe.yDw.yNx);
      localdo.jb(yBe.yDw.yNy);
      localdo.jc(yBe.yDw.yNz);
      localdo.jd(yBe.yDw.yNA);
      localdo.je(yBe.yDw.yNB);
      localdo.jf(yBe.yDw.yNC);
      localdo.jg(yBe.yDw.yND);
      localdo.jh(yBe.yDw.yNE);
      localdo.ji(yBe.yDw.yNF);
      localdo.jj(yBe.yDw.yNG);
      localObject1 = yBe;
      if (!((s)localObject1).yDw.yNH.isEmpty()) {
        break label1706;
      }
      localObject2 = "";
    }
    label763:
    Object localObject3;
    label1706:
    Object localObject4;
    int i;
    for (;;)
    {
      localdo.qz((String)localObject2);
      localdo.jk(yBe.yDw.yNH.size());
      localdo.qA(yBe.yDw.yNK);
      localdo.jl(yBe.yDw.yNI);
      localdo.jo(yBe.yDw.yNJ);
      localdo.jn(yBe.yCK);
      localdo.jm(yBe.yDF.source);
      localdo.jp(yBe.yCT);
      localdo.qC(com.tencent.mm.compatible.util.q.an(yBe.tag, "UTF-8"));
      localdo.qD(com.tencent.mm.compatible.util.q.an(yBe.yDg, "UTF-8"));
      if (!yBe.yCe.isEmpty()) {
        break label1922;
      }
      localdo.qB("");
      if (!yBe.yCV.isEmpty()) {
        break label2110;
      }
      localdo.qE("");
      localdo.jq(yBe.yDa.type);
      localdo.jr(yBe.yDj.type);
      if (yBe.yDj != s.be.yKV) {
        break label2295;
      }
      l = yBe.yDk;
      localdo.jt(l);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      localdo.js(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD());
      localObject1 = yBe.yDI.toString();
      kotlin.g.b.p.j(localObject1, "getConfig().screenShareHistory.toString()");
      localdo.qF(n.l((String)localObject1, ",", ";", false));
      localdo.bpa();
      localObject1 = yBe.yDw;
      ((u)localObject1).kwM = "";
      ((u)localObject1).feedId = "";
      ((u)localObject1).description = "";
      ((u)localObject1).yNq = 0L;
      ((u)localObject1).yNr = 0L;
      ((u)localObject1).yNt = 0L;
      ((u)localObject1).yNs = 0L;
      ((u)localObject1).yNu = 0L;
      ((u)localObject1).yNv = 0L;
      ((u)localObject1).yNw = 0L;
      ((u)localObject1).errorCode = 0;
      ((u)localObject1).yNx = 0L;
      ((u)localObject1).yNy = 0L;
      ((u)localObject1).yNz = 0L;
      ((u)localObject1).yNA = 0L;
      ((u)localObject1).yNB = 0L;
      ((u)localObject1).yNC = 0L;
      ((u)localObject1).yND = 0L;
      ((u)localObject1).yNE = 0L;
      ((u)localObject1).yNF = 0L;
      ((u)localObject1).yNG = 0L;
      ((u)localObject1).yNK = "";
      ((u)localObject1).yNI = 0L;
      ((u)localObject1).yNJ = 0L;
      ((u)localObject1).yNH.clear();
      localObject1 = yBe;
      ((s)localObject1).yDt = 0L;
      ((s)localObject1).yDu = 0L;
      ((s)localObject1).yDv = 0L;
      ((s)localObject1).yDx = false;
      ((s)localObject1).yDy = false;
      ((s)localObject1).yDz = false;
      ((s)localObject1).yDA = false;
      ((s)localObject1).yDB = false;
      ((s)localObject1).yCT = 0;
      ((s)localObject1).yCe.clear();
      ((s)localObject1).yCU = false;
      ((s)localObject1).yCV.clear();
      ((s)localObject1).yDC.clear();
      ((s)localObject1).yCK = 0L;
      ((s)localObject1).yCL = false;
      ((s)localObject1).yCM = false;
      ((s)localObject1).tag = "";
      ((s)localObject1).yDg = "";
      ((s)localObject1).yDj = s.be.yKU;
      ((s)localObject1).yDk = 0L;
      ((s)localObject1).yDa = s.ab.yHL;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KP(0);
      Log.i("HABBYGE-MALI.HellLiveReport", "report21056: finderUsrname=" + localdo.ahx() + ", finderWxAppInfo=" + localdo.ahy() + ", isPrivate=" + localdo.ahz() + ", finderSessionId=" + localdo.ahA() + ", actionTimeMs=" + localdo.ahB() + ", audienceCount=" + localdo.ajn() + ", likeCount=" + localdo.aia() + ", newFansNum=" + localdo.ajo() + ", liveDurationSeconds=" + localdo.ajl() + ", liveId=" + localdo.ahY() + ", feedId=" + localdo.ahZ() + ", description=" + localdo.getDescription() + ", liveStartTimeMs=" + localdo.ajj() + ", liveEndTimeMs=" + localdo.ajk() + ", oriFansCount=" + localdo.ajm() + ", errorCode=" + localdo.getErrorCode() + ", floatingCount=" + localdo.aim() + ", shareSnsCount=" + localdo.ajp() + ", shareSessionCount=" + localdo.ajq() + ", exchangeCameraCount=" + localdo.ajr() + ", complainCount=" + localdo.ajs() + ", allCommentCloseCount=" + localdo.ajt() + ", allCommentOpenCount=" + localdo.aju() + ", personalCommentCloseCount=" + localdo.ajv() + ", personalCommentOpenCount=" + localdo.ajw() + ", kickOutCount=" + localdo.ajx() + ", promoteGoodsJson=" + localdo.ajy() + ", promoteGoodsCount=" + localdo.ajz() + ", shopWindowId=" + localdo.ajA() + ", nudgeCount=" + localdo.ajC() + ", lotteryCount=" + localdo.aiD() + ", connectCount=" + localdo.ajD() + ", connectDuration=" + localdo.aiG() + ", micWithAnchor=" + localdo.ajF() + ", sourceScene=" + localdo.aic() + ", isGift=" + localdo.ajE() + ", tag=" + yBe.tag + ", subTag=" + yBe.yDg + ", visibleRange=" + localdo.ajG() + ", topComment=" + localdo.ajB() + ", presentationJson=" + localdo.ajH());
      AppMethodBeat.o(288933);
      return;
      localObject1 = yBe.yDw.description;
      break;
      localObject2 = ((Map)((s)localObject1).yDw.yNH).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + ((Number)((Map.Entry)localObject3).getKey()).longValue() + ':' + l + '#')
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = ((LinkedList)((Map.Entry)localObject3).getValue()).iterator();
        l = 0L;
        while (((Iterator)localObject4).hasNext())
        {
          o localo = (o)((Iterator)localObject4).next();
          if (localo.yCw) {
            l += localo.time;
          }
        }
      }
      localObject2 = localObject1;
      if (n.pu((String)localObject1, "#"))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(288933);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        kotlin.g.b.p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    label1922:
    Object localObject1 = "";
    localObject2 = yBe.yCe.iterator();
    label1937:
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.vending.j.d)((Iterator)localObject2).next();
      localObject4 = ((com.tencent.mm.vending.j.d)localObject3).ieV();
      kotlin.g.b.p.j(localObject4, "tuple.`$3`()");
      if (!((Boolean)localObject4).booleanValue()) {
        break label2303;
      }
      localObject1 = (String)localObject1 + ((s.ag)((com.tencent.mm.vending.j.d)localObject3).ieT()).type + '|' + (Long)((com.tencent.mm.vending.j.d)localObject3).ieU() + ';';
    }
    label2110:
    label2125:
    label2295:
    label2300:
    label2303:
    for (;;)
    {
      break label1937;
      localObject2 = localObject1;
      if ((kotlin.g.b.p.h(localObject1, "") ^ true))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(288933);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        kotlin.g.b.p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localdo.qB((String)localObject2);
      break;
      localObject1 = "";
      localObject2 = yBe.yCV.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.vending.j.d)((Iterator)localObject2).next();
        localObject4 = ((com.tencent.mm.vending.j.d)localObject3).ieV();
        kotlin.g.b.p.j(localObject4, "tuple.`$3`()");
        if (!((Boolean)localObject4).booleanValue()) {
          break label2300;
        }
        localObject1 = (String)localObject1 + (String)((com.tencent.mm.vending.j.d)localObject3).ieT() + '|' + (Long)((com.tencent.mm.vending.j.d)localObject3).ieU() + ';';
      }
      for (;;)
      {
        break label2125;
        localObject2 = localObject1;
        if ((kotlin.g.b.p.h(localObject1, "") ^ true))
        {
          i = ((String)localObject1).length();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(288933);
            throw ((Throwable)localObject1);
          }
          localObject2 = ((String)localObject1).substring(0, i - 1);
          kotlin.g.b.p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        localdo.qE((String)localObject2);
        break;
        l = 0L;
        break label763;
      }
    }
  }
  
  private static void dDj()
  {
    AppMethodBeat.i(288959);
    yBe.aCC("");
    AppMethodBeat.o(288959);
  }
  
  public static s.s dDk()
  {
    return yBe.yDo;
  }
  
  public static int dDl()
  {
    return yBe.yDs;
  }
  
  public static s dDm()
  {
    return yBe;
  }
  
  public static void gI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(288927);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt1);
    if (paramInt1 == 2) {
      localJSONObject.put("times", paramInt2);
    }
    a(s.c.yEG, localJSONObject.toString());
    AppMethodBeat.o(288927);
  }
  
  public static void setDesc(String paramString)
  {
    if (paramString == null) {
      return;
    }
    yBe.desc = paramString;
  }
  
  public static void setErrorCode(int paramInt)
  {
    yBe.errCode = paramInt;
  }
  
  public static void t(long paramLong, String paramString)
  {
    AppMethodBeat.i(288922);
    Object localObject;
    if (paramLong == s.a.yDK.jWO)
    {
      localObject = yBe;
      ((s)localObject).b(((s)localObject).yDh);
    }
    dp localdp = new dp();
    a(localdp);
    if (paramLong == s.a.yDX.jWO)
    {
      if (!kotlin.g.b.p.h(paramString, String.valueOf(s.af.yIl.action))) {
        break label273;
      }
      yBe.a(s.af.yIl);
    }
    for (;;)
    {
      localdp.jv(paramLong);
      if (paramString != null)
      {
        localObject = n.l(paramString, ",", ";", false);
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localdp.qJ(paramString);
      localdp.jw(yBe.yDF.source);
      localdp.bpa();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21017: finderUsrname=" + localdp.ahx() + ", finderWxAppInfo=" + localdp.ahy() + ", isPrivate=" + localdp.ahz() + ", finderSessionId=" + localdp.ahA() + ", actionTimeMs=" + localdp.ahB() + ", actionType=" + localdp.ahC() + ", sourceScene=" + localdp.aic() + ", actionJson=" + localdp.ajI());
      AppMethodBeat.o(288922);
      return;
      label273:
      if (kotlin.g.b.p.h(paramString, String.valueOf(s.af.yIm.action))) {
        yBe.a(s.af.yIm);
      }
    }
  }
  
  private static void u(long paramLong, String paramString)
  {
    AppMethodBeat.i(288958);
    com.tencent.mm.plugin.expt.hellhound.a.aww(paramString);
    yBe.aCC(paramString);
    yBe.yCG = paramLong;
    AppMethodBeat.o(288958);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.t paramt, String paramString2, long paramLong5, long paramLong6, s.bj parambj, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(288955);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString2, "commentscene");
    kotlin.g.b.p.k(parambj, "enterType");
    kotlin.g.b.p.k(paramString4, "clickSubTabContextId");
    kotlin.g.b.p.k(paramString5, "chnlExtra");
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      kotlin.g.b.p.j(paramString2, "HellSessionMonitor.getInstance()");
      paramString2 = paramString2.deK();
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (c.a.axK(paramString2))
      {
        if (paramString1 != null) {
          break label284;
        }
        paramString1 = "";
      }
    }
    label284:
    for (;;)
    {
      String str2 = s.l.yFU.scene;
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      paramLong3 = c.a.axJ(paramString2);
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl;
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      String str1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm;
      paramString3 = str1;
      if (str1 == null) {
        paramString3 = "";
      }
      c(new q(paramLong1, paramLong2, paramString1, 0L, paramLong4, paramt, str2, paramLong5, paramLong3, paramString2, paramString3, paramLong6, parambj, null, null, paramString4, paramString5, 24576));
      AppMethodBeat.o(288955);
      return;
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        if (paramString3 == null) {
          paramString3 = "";
        }
        for (;;)
        {
          c(new q(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramt, paramString2, paramLong5, -1L, "", "", paramLong6, parambj, paramString3, null, paramString4, paramString5, 16384));
          AppMethodBeat.o(288955);
          return;
        }
      }
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.t paramt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(288950);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString2, "commentscene");
    kotlin.g.b.p.k(paramString3, "chnlExtra");
    a(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramt, paramString2, "", "", paramString3);
    AppMethodBeat.o(288950);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, s.t paramt, String paramString)
  {
    AppMethodBeat.i(288944);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    long l3 = paramBaseFinderFeed.mf();
    Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
    long l1;
    if (localObject != null)
    {
      l1 = ((bac)localObject).liveId;
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label126;
      }
    }
    label126:
    for (long l2 = paramBaseFinderFeed.yYz;; l2 = -1L)
    {
      b(new p(l3, l1, (String)localObject, paramLong, l2, paramt, paramString, null, null, null, null, null, 16256));
      AppMethodBeat.o(288944);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, s.t paramt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(288946);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString1, "commentscene");
    kotlin.g.b.p.k(paramString2, "clickTabContextId");
    kotlin.g.b.p.k(paramString3, "clickSubTabContextId");
    kotlin.g.b.p.k(paramString4, "chnlExtra");
    long l3 = paramBaseFinderFeed.mf();
    Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
    long l1;
    if (localObject != null)
    {
      l1 = ((bac)localObject).liveId;
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label150;
      }
    }
    label150:
    for (long l2 = paramBaseFinderFeed.yYz;; l2 = -1L)
    {
      b(new p(l3, l1, (String)localObject, paramLong, l2, paramt, paramString1, null, null, paramString2, paramString3, paramString4, 1920));
      AppMethodBeat.o(288946);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString)
  {
    AppMethodBeat.i(288954);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(paramString, "commentscene");
    s.t localt;
    long l3;
    Object localObject;
    long l1;
    if (paramBaseFinderFeed.bAQ() == 9)
    {
      localt = s.t.yGQ;
      l3 = paramBaseFinderFeed.mf();
      localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject == null) {
        break label135;
      }
      l1 = ((bac)localObject).liveId;
      label61:
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label141;
      }
    }
    label135:
    label141:
    for (long l2 = paramBaseFinderFeed.yYz;; l2 = -1L)
    {
      b(new p(l3, l1, (String)localObject, paramLong, l2, localt, paramString, null, null, null, null, null, 16256));
      AppMethodBeat.o(288954);
      return;
      localt = s.t.yGR;
      break;
      l1 = 0L;
      break label61;
    }
  }
  
  public final void a(y paramy, String paramString1, long paramLong, s.t paramt, String paramString2)
  {
    AppMethodBeat.i(288942);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString2, "commentscene");
    if (paramy == null) {
      if (paramString1 != null) {
        break label186;
      }
    }
    label178:
    label186:
    for (paramy = "";; paramy = paramString1)
    {
      b(new p(0L, 0L, paramy, paramLong, -1L, paramt, paramString2, null, null, null, null, null, 16256));
      AppMethodBeat.o(288942);
      return;
      long l3 = paramy.zAF.id;
      paramString1 = paramy.zAF.liveInfo;
      long l1;
      if (paramString1 != null)
      {
        l1 = paramString1.liveId;
        String str = paramy.zAF.username;
        paramString1 = str;
        if (str == null) {
          paramString1 = "";
        }
        paramy = paramy.zAF.liveInfo;
        if (paramy == null) {
          break label178;
        }
      }
      for (long l2 = paramy.yYz;; l2 = -1L)
      {
        b(new p(l3, l1, paramString1, paramLong, l2, paramt, paramString2, null, null, null, null, null, 16256));
        AppMethodBeat.o(288942);
        return;
        l1 = 0L;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.k
 * JD-Core Version:    0.7.0.1
 */
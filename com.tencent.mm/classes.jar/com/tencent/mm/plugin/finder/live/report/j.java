package com.tencent.mm.plugin.finder.live.report;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.autogen.mmdata.rpt.cq;
import com.tencent.mm.autogen.mmdata.rpt.dl;
import com.tencent.mm.autogen.mmdata.rpt.eh;
import com.tencent.mm.autogen.mmdata.rpt.ek;
import com.tencent.mm.autogen.mmdata.rpt.el;
import com.tencent.mm.autogen.mmdata.rpt.em;
import com.tencent.mm.autogen.mmdata.rpt.ep;
import com.tencent.mm.autogen.mmdata.rpt.ev;
import com.tencent.mm.autogen.mmdata.rpt.ew;
import com.tencent.mm.autogen.mmdata.rpt.fe;
import com.tencent.mm.autogen.mmdata.rpt.gm;
import com.tencent.mm.autogen.mmdata.rpt.jd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.g.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveReport;", "Lcom/tencent/mm/plugin/findersdk/api/IHellLiveReport;", "()V", "EldUdfKVKey_AnchorStatus", "", "EldUdfKVKey_FeedId", "EldUdfKVKey_IsMmbizLive", "EldUdfKVKey_LiveId", "EldUdfKVKey_ShareId", "INVALIDATE_NEARBY_TAB_TYPE", "", "NEARBY_TAB_TYPE_ARRAY", "", "TAG", "deviceStatusReporter", "Lcom/tencent/mm/plugin/finder/live/report/DeviceStatusReporter;", "fullStatic", "Lcom/tencent/mm/plugin/finder/live/report/FullFeedExploreStatics;", "isClickStartLive", "", "isPullupListHalfPage", "m21053Reporter", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "mConfig", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig;", "_doReport21053OnClick", "", "clickData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "_doReport21053OnEnter", "enterData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "fillCommonEldUdfKVMap", "map", "", "genEldUdfKey", "eidUdfKVMap", "genShareId", "shareId", "getCacheExitEvent", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExitType;", "getConfig", "getCoverType", "handleAnchorLinkMicDuration", "handleLinkMicDuration", "linkType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "initBeauty", "initClickEvent", "pos", "", "commentscene", "initCommField", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderFaceVerifyStreamStruct;", "userName", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveActionStruct;", "timestamp", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveEntranceLogStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveResultStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderNoticeLiveStreamStruct;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderStartLiveResultStruct;", "initEnterEvent", "initFilter", "initShareReport", "anchorUsername", "liveId", "objectId", "makeAnchorStatusEldUdfKVMap", "status", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EldUdfKVAnchorStatus;", "makeCustomCommonEldUdfKVMap", "feedId", "report", "finderLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "report21017", "actionType", "actionJson", "report21024", "type", "report21053", "recyclerView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "visibleItemCount", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "headerShow", "Landroidx/recyclerview/widget/RecyclerView;", "report21053FeedOnFull", "centerFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "report21053OnClick", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "onlineNum", "chnlExtra", "clickTabContextId", "clickSubTabContextId", "report21053OnClickForLiveSquare", "report21053OnClickNearByReddot", "contextId", "report21053OnClickOnAvatar", "report21053OnClickOnShare", "report21053OnEnter", "enterStatus", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "sessionBuf", "report21053OnFull", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "report21053OnNearby", "fromType", "toType", "report21054", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorActionType;", "json", "report21054AnchorApplaud", "subAction", "report21054AnchorComment", "action", "report21054AnchorPauseLive", "pauseTime", "report21054AnchorRandomMatchLinkMic", "result", "report21054CommentOperation", "report21054OnLottery", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLotteryType;", "report21056", "report21106", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveBookAction;", "value", "description", "report21113", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveVerified;", "report21631", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyAction2;", "report21919", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorLiveClose;", "actionResult", "report21919OnVest", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CloseUISeeGiftList;", "report24524", "sdkLiveId", "anchorNickname", "liveScene", "role", "wave3AEnable", "wave3AAllEnable", "wave3AMode", "trtc3AEnable", "livePushMode", "videoCustomRenderEnable", "VideoCustomRenderMode", "reportAnchorModifyPayGameTeam", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ModifyPayGameTeam;", "money", "errorInfo", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveReport$CgiErrorInfo;", "reportAnchorProductRecord", "recordMode", "productId", "duration", "reportDeviceStatus", "finderNickname", "isAnchor", "reportElementClick", "elementId", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementClickId;", "reportElementExpose", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "reportHalfProfile21054", "scene", "reportLinkMic", "linkOp", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkOp;", "micType", "inviteType", "reportProductRecommend", "reportReplay", "paramsJson", "reportVest", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$SEE_GIFT_LIST;", "resetConfig", "setCacheExitEvent", "exitType", "setCoverType", "coverType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType2;", "setDesc", "desc", "setErrorCode", "errCode", "setPoiJSONObject", "jsonObject", "Lorg/json/JSONObject;", "setRule", "setTimestampOfEnterLiveAnchorUI", "stopDeviceStatus", "CgiErrorInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements ce
{
  public static final j Dob;
  public static final q Doc;
  private static final a Dod;
  private static final c Doe;
  private static final b Dof;
  private static boolean Dog;
  private static final List<Integer> Doh;
  private static boolean mZI;
  
  static
  {
    AppMethodBeat.i(352415);
    Dob = new j();
    Doc = new q();
    Dod = new a();
    Doe = new c();
    Dof = new b();
    Doh = p.listOf(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1002), Integer.valueOf(1003) });
    AppMethodBeat.o(352415);
  }
  
  public static void C(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(352265);
    q localq = Doc;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localq.mIC = str;
    localq.liveId = com.tencent.mm.ae.d.hF(paramLong1);
    localq.objectId = com.tencent.mm.ae.d.hF(paramLong2);
    AppMethodBeat.o(352265);
  }
  
  private static void D(long paramLong, String paramString)
  {
    AppMethodBeat.i(352217);
    com.tencent.mm.plugin.expt.hellhound.a.aqz(paramString);
    Doc.axz(paramString);
    Doc.Dpz = paramLong;
    AppMethodBeat.o(352217);
  }
  
  public static void Pj(int paramInt)
  {
    Doc.Dqk = paramInt;
  }
  
  public static Map<String, String> a(q.r paramr)
  {
    AppMethodBeat.i(352354);
    s.u(paramr, "status");
    paramr = ak.f(new kotlin.r[] { new kotlin.r("anchor_status", String.valueOf(paramr.status)) });
    AppMethodBeat.o(352354);
    return paramr;
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    AppMethodBeat.i(352397);
    s.u(paramString, "anchorNickname");
    ek localek = new ek();
    localek.iDP = paramLong1;
    localek.iDQ = paramLong2;
    localek.iDR = localek.F("FinderName", paramString, true);
    localek.iDS = paramLong3;
    localek.imY = paramLong4;
    localek.iDT = 0L;
    localek.iDU = 0L;
    localek.iDV = 0L;
    localek.iDW = 0L;
    localek.iDX = 0L;
    localek.iDY = paramLong5;
    localek.iDZ = paramLong6;
    localek.bMH();
    Log.i("HABBYGE-MALI.HellLiveReport", s.X("report24524 info:", localek.aIF()));
    AppMethodBeat.o(352397);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(352177);
    s.u(paramw, "actionType");
    s.u(paramString2, "commentscene");
    s.u(paramString3, "clickTabContextId");
    s.u(paramString4, "clickSubTabContextId");
    s.u(paramString5, "chnlExtra");
    if (s.p(paramString2, q.an.DyC.type))
    {
      paramString2 = q.n.DtD.scene;
      if (paramString1 != null) {
        break label236;
      }
      paramString1 = "";
    }
    label236:
    for (;;)
    {
      b(new n(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramw, paramString2, null, null, paramString3, paramString4, paramString5, 1920));
      AppMethodBeat.o(352177);
      return;
      if (s.p(paramString2, q.an.DyD.type))
      {
        paramString2 = q.n.DtC.scene;
        break;
      }
      if (s.p(paramString2, q.an.DyE.type))
      {
        paramString2 = q.n.DtF.scene;
        break;
      }
      if (!s.p(paramString2, q.an.DyF.type))
      {
        if (s.p(paramString2, q.an.DyG.type))
        {
          paramString2 = q.n.DtE.scene;
          break;
        }
        if (s.p(paramString2, q.an.DyH.type))
        {
          paramString2 = q.n.DtK.scene;
          break;
        }
      }
      break;
    }
  }
  
  public static void a(RecyclerView paramRecyclerView, q.w paramw, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352169);
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    s.u(paramd, "event");
    if (!s.p(paramString, "80"))
    {
      str = paramString;
      if (!s.p(paramString, "94")) {}
    }
    else
    {
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (!com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKl()) {
        break label168;
      }
    }
    label168:
    for (String str = "80";; str = "94")
    {
      if (paramd == d.Dnf)
      {
        paramString = Doc;
        s.u(str, "<set-?>");
        paramString.DpY = str;
      }
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(((e)h.az(e.class)).getNearbyTabLifecycleReporter().eeL());
      com.tencent.mm.plugin.expt.hellhound.core.b.aqY(((e)h.az(e.class)).getNearbyTabLifecycleReporter().eGM());
      if ((paramInt1 != -1) || (!Doh.contains(Integer.valueOf(paramInt2)))) {
        break;
      }
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGA = paramInt2;
      AppMethodBeat.o(352169);
      return;
    }
    if ((paramInt1 != -100) && (paramInt2 != -100))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGA = paramInt2;
      if (paramInt1 == 1001) {
        paramString = d.Dng;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          Dod.a(paramRecyclerView, paramw, str, paramString);
          AppMethodBeat.o(352169);
          return;
          if (paramInt2 != 1001) {
            break;
          }
          paramString = d.Dnf;
        }
        AppMethodBeat.o(352169);
        return;
        if (paramd == d.Dnf) {
          break;
        }
        paramString = paramd;
      } while (paramd != d.Dng);
      paramString = paramd;
    } while (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGA == 1001);
    AppMethodBeat.o(352169);
  }
  
  private static void a(eh parameh, long paramLong)
  {
    AppMethodBeat.i(352241);
    parameh.oC(q.egv());
    parameh.oD(Doc.etv());
    parameh.izI = q.etz();
    parameh.oE(q.ety());
    parameh.eN(paramLong);
    AppMethodBeat.o(352241);
  }
  
  public static void a(el paramel, String paramString)
  {
    AppMethodBeat.i(352260);
    s.u(paramel, "struct");
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      paramel.oL(str);
      paramel.iwP = q.axD(paramString);
      paramel.oN(q.ety());
      paramel.iwW = System.currentTimeMillis();
      AppMethodBeat.o(352260);
      return;
    }
  }
  
  private static void a(ew paramew)
  {
    AppMethodBeat.i(352233);
    paramew.pq(q.egv());
    paramew.pr(Doc.etv());
    paramew.izI = q.etz();
    paramew.pt(q.ety());
    paramew.eT(System.currentTimeMillis());
    AppMethodBeat.o(352233);
  }
  
  private static void a(fe paramfe)
  {
    AppMethodBeat.i(352252);
    paramfe.pA(q.egv());
    paramfe.pB(Doc.etv());
    paramfe.izI = q.etz();
    paramfe.pC(q.ety());
    paramfe.eU(System.currentTimeMillis());
    AppMethodBeat.o(352252);
  }
  
  private static void a(q.ar paramar)
  {
    AppMethodBeat.i(352058);
    long l1 = System.currentTimeMillis();
    int i = Doc.Dpa.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject1 = Doc.Dpa.get(i);
      s.s(localObject1, "mConfig.gLinkMicTimeList[i]");
      localObject1 = (com.tencent.mm.vending.j.d)localObject1;
      if (((com.tencent.mm.vending.j.b)localObject1).get(0) == paramar)
      {
        Object localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(1);
        s.s(localObject2, "tuple.`$2`()");
        if ((((Number)localObject2).longValue() > 0L) && (s.p(((com.tencent.mm.vending.j.d)localObject1).get(2), Boolean.FALSE)))
        {
          localObject1 = ((com.tencent.mm.vending.j.c)localObject1).get(1);
          s.s(localObject1, "tuple.`$2`()");
          long l2 = (l1 - ((Number)localObject1).longValue()) / 1000L;
          if (l2 >= 0L)
          {
            Doc.Dpa.set(i, com.tencent.mm.vending.j.a.g(paramar, Long.valueOf(l2), Boolean.TRUE));
            AppMethodBeat.o(352058);
            return;
          }
        }
      }
      if (j < 0)
      {
        AppMethodBeat.o(352058);
        return;
      }
      i = j;
    }
  }
  
  public static void a(q.ax paramax, String paramString)
  {
    AppMethodBeat.i(352149);
    s.u(paramax, "actionType");
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.arc(paramString))
    {
      AppMethodBeat.o(352149);
      return;
    }
    dl localdl = new dl();
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      localdl.izG = localdl.F("FinderUsrname", str, true);
      localdl.izH = localdl.F("FinderWxAppInfo", Doc.etv(), true);
      localdl.izI = q.axD(paramString);
      localdl.izJ = localdl.F("FinderSessionId", q.ety(), true);
      localdl.eI(System.currentTimeMillis());
      localdl.ioV = paramax.mwI;
      localdl.bMH();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21113: finderUsrname=" + localdl.izG + ", finderWxAppInfo=" + localdl.izH + ", isPrivate=" + localdl.izI + ", finderSessionId=" + localdl.izJ + ", actionTimeMs=" + localdl.izK + ", actionJson=" + localdl.ioV);
      AppMethodBeat.o(352149);
      return;
    }
  }
  
  public static void a(q.g paramg, String paramString)
  {
    AppMethodBeat.i(351923);
    s.u(paramg, "action");
    s.u(paramString, "actionResult");
    long l = System.currentTimeMillis();
    switch (b.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    }
    for (;;)
    {
      ep localep = new ep();
      localep.ioV = paramg.type;
      localep.pc(paramString);
      localep.eP(l);
      localep.pd(String.valueOf(Doc.DpU));
      localep.bMH();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21919: actionType=" + localep.ioV + ", actionResult=" + localep.iwX + ", actionTimeMs=" + localep.izK + ", sessionId=" + localep.ijk);
      AppMethodBeat.o(351923);
      return;
      if (s.p(paramString, String.valueOf(q.m.Dtl.action)))
      {
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGw = String.valueOf(Doc.DpU);
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGx = l;
      }
      else if (s.p(paramString, String.valueOf(q.m.Dtk.action)))
      {
        Doc.DpV = true;
      }
      else if ((s.p(paramString, String.valueOf(q.m.Dtm.action))) && (!Doc.DpV))
      {
        AppMethodBeat.o(351923);
        return;
        Doc.DpV = false;
      }
    }
  }
  
  public static void a(q.m paramm)
  {
    AppMethodBeat.i(351897);
    s.u(paramm, "action");
    Log.w("HABBYGE-MALI.HellLiveReport", s.X("report21919OnVest, action: ", paramm.name()));
    if (paramm == q.m.Dtj)
    {
      AppMethodBeat.o(351897);
      return;
    }
    a(q.g.Dsn, String.valueOf(paramm.action));
    AppMethodBeat.o(351897);
  }
  
  public static void a(q.q paramq)
  {
    AppMethodBeat.i(352332);
    s.u(paramq, "coverType");
    Doc.Dqm = paramq.type;
    AppMethodBeat.o(352332);
  }
  
  public static void a(q.v paramv)
  {
    long l = 0L;
    AppMethodBeat.i(351989);
    s.u(paramv, "type");
    gm localgm = new gm();
    localgm.izG = localgm.F("FinderUsrname", q.egv(), true);
    localgm.izH = localgm.F("FinderWxAppInfo", Doc.etv(), true);
    localgm.izI = q.etz();
    localgm.izJ = localgm.F("FinderSessionId", q.ety(), true);
    localgm.eW(System.currentTimeMillis());
    localgm.iDn = paramv.beV;
    localgm.iLd = h.baE().ban().getInt(at.a.adcP, 0);
    int i;
    q localq;
    if (com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfq().cameraId == 0)
    {
      i = 2;
      localgm.iLe = i;
      localgm.eX(Doc.Dqj);
      localgm.eY(System.currentTimeMillis() - localgm.iLf);
      localgm.iLh = Doc.Dqk;
      localq = Doc;
      localObject1 = localq.Dql;
      if (localObject1 != null) {
        break label386;
      }
      localObject1 = "";
      label204:
      localq.Dql = null;
      localgm.iLi = localgm.F("PoiJson", (String)localObject1, true);
      localq = Doc;
      localObject1 = localq.desc;
      if (localObject1 != null) {
        break label437;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localq.desc = null;
      localgm.iCS = localgm.F("Description", (String)localObject1, true);
      localgm.iLg = Doc.Dqm;
      localgm.iFU = localgm.F("ShopWindowId", "", true);
      localgm.rj("");
      localObject1 = Doc.Dqw.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localgm.rj(localgm.iLk + ((Long)localObject2).longValue() + '#');
      }
      i = 1;
      break;
      label386:
      localObject1 = ((JSONObject)localObject1).toString();
      if (localObject1 == null)
      {
        localObject1 = "";
        break label204;
      }
      Object localObject2 = kotlin.n.n.m((String)localObject1, ",", ";", false);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label204;
      }
      localObject1 = "";
      break label204;
      label437:
      localObject2 = kotlin.n.n.m((String)localObject1, ",", ";", false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    Object localObject1 = localgm.iLk;
    s.s(localObject1, "struct.goodsListJson");
    if (kotlin.n.n.rs((String)localObject1, "#"))
    {
      localObject1 = localgm.iLk;
      s.s(localObject1, "struct.goodsListJson");
      localObject1 = ((String)localObject1).substring(0, localgm.iLk.length() - 1);
      s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localgm.rj((String)localObject1);
    }
    switch (b.avM[paramv.ordinal()])
    {
    }
    for (;;)
    {
      localgm.iLl = localgm.F("RetouchResult", ete(), true);
      localgm.iLm = localgm.F("FiltersResult", etf(), true);
      localgm.iLn = localgm.F("ConnectSwitch", String.valueOf(Doc.DpR.action), true);
      localgm.iCU = Doc.Dqz.source;
      localgm.iyA = localgm.F("Tag", com.tencent.mm.compatible.util.r.as(Doc.tag, "UTF-8"), true);
      localgm.iFY = localgm.F("SubTag", com.tencent.mm.compatible.util.r.as(Doc.DpZ, "UTF-8"), true);
      localgm.iGb = Doc.Dqc.type;
      if (Doc.Dqc == q.bt.DCe) {
        l = Doc.Dqd;
      }
      localgm.iGc = l;
      paramv = com.tencent.mm.plugin.finder.live.model.a.a.CDx;
      localgm.iLp = localgm.F("BeautyResult", com.tencent.mm.plugin.finder.live.model.a.a.ekb(), true);
      localgm.bMH();
      paramv = new StringBuilder();
      paramv.append("report21024: finderUsrname=").append(localgm.izG).append(", finderWxAppInfo=").append(localgm.izH).append(", isPrivate=").append(localgm.izI).append(", finderSessionId=").append(localgm.izJ).append(", actionTimeMs=").append(localgm.izK).append(", exitType=").append(localgm.iDn).append(", fansCount=").append(localgm.iLd).append(", cameraStatus=").append(localgm.iLe).append(", enterUITimeMs=").append(localgm.iLf).append(", stayTimeMs=").append(localgm.ipo).append(", coverType=").append(localgm.iLg).append(", ruleType=");
      paramv.append(localgm.iLh).append(", poiJson=").append(localgm.iLi).append(", description=").append(localgm.iCS).append(", liveId=").append(localgm.iCR).append(", feedId=").append(localgm.ivZ).append(", errorCode=").append(localgm.iLj).append(", goodsListJson=").append(localgm.iLk).append(", retouchResult=").append(localgm.iLl).append(", filtersResult=").append(localgm.iLm).append(", connectSwitch=").append(localgm.iLn).append(", sourceScene=").append(localgm.iCU).append(", tag=").append(Doc.tag);
      paramv.append(", subTag=").append(Doc.DpZ).append(", visibleRange=").append(localgm.iGb).append(", beautyResult=").append(localgm.iLp).append(", shopWindowId=").append(localgm.iFU);
      Log.i("HABBYGE-MALI.HellLiveReport", paramv.toString());
      AppMethodBeat.o(351989);
      return;
      localgm.rg(Doc.etw());
      localgm.rh(Doc.etx());
      localgm.ri("0");
      continue;
      localgm.rg(Doc.etw());
      localgm.rh(Doc.etx());
      localgm.ri(String.valueOf(Doc.errCode));
      continue;
      localgm.rg("0");
      localgm.rh("0");
      localgm.ri(String.valueOf(Doc.errCode));
      continue;
      localgm.rg("0");
      localgm.rh("0");
      localgm.ri("0");
      Doc.setTag("");
      Doc.axB("");
      Doc.a(q.bt.DCd);
      Doc.Dqd = 0L;
    }
  }
  
  public static void a(q.w paramw, FeedData paramFeedData)
  {
    AppMethodBeat.i(352157);
    s.u(paramw, "type");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(352157);
      return;
    }
    Dod.a(paramw, Doc.DpW, String.valueOf(Doc.DpX), paramFeedData);
    AppMethodBeat.o(352157);
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(352384);
    Log.i("HABBYGE-MALI.HellLiveReport", "reportDeviceStatus liveId:" + paramString1 + " liveScene:" + paramLong + " finderNickname:" + paramString2 + " isAnchor:" + paramBoolean);
    b localb = Dof;
    localb.liveId = paramString1;
    localb.Dnb = paramLong;
    localb.mPd = paramString2;
    localb.mPe.stopTimer();
    if (paramBoolean)
    {
      localb.mPe.startTimer(0L, 5000L);
      AppMethodBeat.o(352384);
      return;
    }
    localb.mPe.startTimer(0L, 120000L);
    AppMethodBeat.o(352384);
  }
  
  public static Map<String, String> ah(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(352346);
    Map localMap = (Map)new LinkedHashMap();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localMap.put("liveId", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localMap.put("feedId", paramString1);
    localMap.put("share_id", paramString3);
    AppMethodBeat.o(352346);
    return localMap;
  }
  
  private static String al(Map<String, String> paramMap)
  {
    AppMethodBeat.i(352370);
    Object localObject = (CharSequence)paramMap.get("liveId");
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramMap.put("liveId", Doc.liveId);
      }
      localObject = (CharSequence)paramMap.get("feedId");
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label247;
      }
      i = 1;
      label82:
      if (i != 0) {
        paramMap.put("feedId", Doc.objectId);
      }
      localObject = (CharSequence)paramMap.get("share_id");
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label252;
      }
      i = 1;
      label130:
      if (i != 0) {
        paramMap.put("share_id", Doc.Dqe);
      }
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).Ecg != true)) {
        break label257;
      }
      i = 1;
      label178:
      if (i == 0) {
        break label262;
      }
    }
    label257:
    label262:
    for (localObject = "1";; localObject = "0")
    {
      paramMap.put("is_mmbiz_live", localObject);
      localObject = ah.aiuX;
      paramMap = new JSONObject(ak.dv(paramMap)).toString();
      s.s(paramMap, "JSONObject(eidUdfKVMap.a…              .toString()");
      paramMap = kotlin.n.n.bV(paramMap, ",", ";");
      AppMethodBeat.o(352370);
      return paramMap;
      i = 0;
      break;
      label247:
      i = 0;
      break label82;
      label252:
      i = 0;
      break label130;
      i = 0;
      break label178;
    }
  }
  
  public static void axq(String paramString)
  {
    AppMethodBeat.i(352270);
    s.u(paramString, "shareId");
    q localq = Doc;
    s.u(paramString, "shareId");
    localq.Dqe = paramString;
    AppMethodBeat.o(352270);
  }
  
  private final void b(n paramn)
  {
    AppMethodBeat.i(352201);
    D(paramn.Dpr, paramn.DnN);
    Doc.a(paramn.DnM, paramn.DnN);
    Dod.a(paramn);
    AppMethodBeat.o(352201);
  }
  
  public static void b(q.v paramv)
  {
    AppMethodBeat.i(352278);
    s.u(paramv, "exitType");
    Doc.c(paramv);
    AppMethodBeat.o(352278);
  }
  
  private final void c(o paramo)
  {
    AppMethodBeat.i(352209);
    eti();
    Dod.a(paramo);
    AppMethodBeat.o(352209);
  }
  
  private static String ete()
  {
    int j = 0;
    AppMethodBeat.i(352011);
    Object localObject1 = Doc;
    Object localObject2 = aj.CGT;
    localObject2 = aj.bhX();
    int i;
    if (localObject2 == null)
    {
      i = 0;
      ((q)localObject1).DpG = i;
      localObject1 = Doc;
      localObject2 = aj.CGT;
      localObject2 = aj.bhX();
      if (localObject2 != null) {
        break label250;
      }
      i = 0;
      label49:
      ((q)localObject1).DpH = i;
      localObject1 = Doc;
      localObject2 = aj.CGT;
      localObject2 = aj.bhX();
      if (localObject2 != null) {
        break label293;
      }
      i = 0;
      label72:
      ((q)localObject1).DpI = i;
      localObject1 = Doc;
      localObject2 = aj.CGT;
      localObject2 = aj.bhX();
      if (localObject2 != null) {
        break label336;
      }
      i = 0;
      label95:
      ((q)localObject1).DpJ = i;
      localObject1 = Doc;
      localObject2 = aj.CGT;
      localObject2 = aj.bhX();
      if (localObject2 != null) {
        break label379;
      }
      i = j;
    }
    for (;;)
    {
      ((q)localObject1).DpK = i;
      localObject1 = Doc.DpG + ';' + Doc.DpH + ';' + Doc.DpI + ';' + Doc.DpJ + ';' + Doc.DpK;
      AppMethodBeat.o(352011);
      return localObject1;
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).mUV;
      if (localObject2 == null)
      {
        i = 0;
        break;
      }
      localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(0));
      if (localObject2 == null)
      {
        i = 0;
        break;
      }
      i = ((Integer)localObject2).intValue();
      break;
      label250:
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).mUV;
      if (localObject2 == null)
      {
        i = 0;
        break label49;
      }
      localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(2));
      if (localObject2 == null)
      {
        i = 0;
        break label49;
      }
      i = ((Integer)localObject2).intValue();
      break label49;
      label293:
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).mUV;
      if (localObject2 == null)
      {
        i = 0;
        break label72;
      }
      localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(3));
      if (localObject2 == null)
      {
        i = 0;
        break label72;
      }
      i = ((Integer)localObject2).intValue();
      break label72;
      label336:
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).mUV;
      if (localObject2 == null)
      {
        i = 0;
        break label95;
      }
      localObject2 = (Integer)((HashMap)localObject2).get(Integer.valueOf(1));
      if (localObject2 == null)
      {
        i = 0;
        break label95;
      }
      i = ((Integer)localObject2).intValue();
      break label95;
      label379:
      localObject2 = ((com.tencent.mm.live.core.b.a)localObject2).mUV;
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
  }
  
  private static String etf()
  {
    AppMethodBeat.i(352024);
    Object localObject2 = Doc;
    Object localObject1 = aj.CGT;
    localObject1 = aj.bhY();
    if (localObject1 == null)
    {
      localObject1 = null;
      ((q)localObject2).DpL = q.axC((String)localObject1).type;
      localObject1 = Doc;
      localObject2 = aj.CGT;
      localObject2 = aj.bhY();
      if (localObject2 != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = ((com.tencent.mm.live.core.b.b)localObject2).mUZ)
    {
      ((q)localObject1).mUZ = i;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", Doc.DpL);
      ((JSONObject)localObject1).put("result", Doc.mUZ);
      localObject1 = ((JSONObject)localObject1).toString();
      s.s(localObject1, "json.toString()");
      localObject1 = kotlin.n.n.bV((String)localObject1, ",", ";");
      AppMethodBeat.o(352024);
      return localObject1;
      localObject1 = ((com.tencent.mm.live.core.b.b)localObject1).mUY;
      break;
    }
  }
  
  private static void etg()
  {
    AppMethodBeat.i(352073);
    long l1 = System.currentTimeMillis();
    int i = Doc.DpO.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject1 = Doc.DpO.get(i);
      s.s(localObject1, "mConfig.gAnchorLinkMicTimeList[i]");
      localObject1 = (com.tencent.mm.vending.j.d)localObject1;
      Object localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(1);
      s.s(localObject2, "tuple.`$2`()");
      if ((((Number)localObject2).longValue() > 0L) && (s.p(((com.tencent.mm.vending.j.d)localObject1).get(2), Boolean.FALSE)))
      {
        localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(1);
        s.s(localObject2, "tuple.`$2`()");
        long l2 = (l1 - ((Number)localObject2).longValue()) / 1000L;
        if (l2 >= 0L)
        {
          Doc.DpO.set(i, com.tencent.mm.vending.j.a.g(((com.tencent.mm.vending.j.b)localObject1).get(0), Long.valueOf(l2), Boolean.TRUE));
          AppMethodBeat.o(352073);
          return;
        }
      }
      if (j < 0)
      {
        AppMethodBeat.o(352073);
        return;
      }
      i = j;
    }
  }
  
  public static void eth()
  {
    AppMethodBeat.i(352133);
    long l = Doc.Dqq.DFR;
    if (l <= 0L)
    {
      AppMethodBeat.o(352133);
      return;
    }
    ev localev = new ev();
    localev.izG = localev.F("FinderUsrname", q.egv(), true);
    localev.izH = localev.F("FinderWxAppInfo", Doc.etv(), true);
    localev.izI = q.etz();
    localev.izJ = localev.F("FinderSessionId", q.ety(), true);
    localev.eQ(System.currentTimeMillis());
    localev.iFH = Doc.Dqq.DFV;
    localev.iBZ = Doc.Dqq.DFW;
    localev.iFI = Doc.Dqq.DFX;
    localev.iFF = Doc.Dqq.DFU;
    Object localObject2 = Doc.Dqq.liveId;
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!s.p(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!s.p(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = Doc.etw();
    }
    localev.iCR = localev.F("LiveId", (String)localObject1, true);
    localObject2 = Doc.Dqq.feedId;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!s.p(localObject2, "0")))
    {
      localObject1 = localObject2;
      if (!s.p(localObject2, "-1")) {}
    }
    else
    {
      localObject1 = Doc.etx();
    }
    localev.ivZ = localev.F("FeedId", (String)localObject1, true);
    if (TextUtils.isEmpty((CharSequence)Doc.Dqq.description))
    {
      localObject1 = q.getDescription();
      localev.iCS = localev.F("Description", (String)localObject1, true);
      localev.eR(l);
      localev.eS(Doc.Dqq.DFS);
      localev.iFG = Doc.Dqq.DFT;
      localev.inj = Doc.Dqq.errorCode;
      localev.iDd = Doc.Dqq.DFY;
      localev.iFJ = Doc.Dqq.DFZ;
      localev.iFK = Doc.Dqq.DGa;
      localev.iFL = Doc.Dqq.DGb;
      localev.iFM = Doc.Dqq.DGc;
      localev.iFN = Doc.Dqq.DGd;
      localev.iFO = Doc.Dqq.DGe;
      localev.iFP = Doc.Dqq.DGf;
      localev.iFQ = Doc.Dqq.DGg;
      localev.iFR = Doc.Dqq.DGh;
      localObject1 = Doc;
      if (!((q)localObject1).Dqq.DGi.isEmpty()) {
        break label1779;
      }
      localObject2 = "";
      label552:
      localev.iFS = localev.F("PromoteGoodsJson", (String)localObject2, true);
      localev.iFT = Doc.Dqq.DGi.size();
      localev.iFU = localev.F("ShopWindowId", Doc.Dqq.DGl, true);
      localev.iFV = Doc.Dqq.DGj;
      localev.iFW = Doc.Dqq.DGk;
      localev.iDu = Doc.DpD;
      localev.iCU = Doc.Dqz.source;
      localev.iFX = Doc.DpM;
      localev.iyA = localev.F("Tag", com.tencent.mm.compatible.util.r.as(Doc.tag, "UTF-8"), true);
      localev.iFY = localev.F("SubTag", com.tencent.mm.compatible.util.r.as(Doc.DpZ, "UTF-8"), true);
      if (!Doc.Dpa.isEmpty()) {
        break label1995;
      }
      localev.po("");
      label748:
      if (!Doc.DpO.isEmpty()) {
        break label2181;
      }
      localev.pp("");
      label769:
      localev.iFZ = Doc.DpT.type;
      localev.iGb = Doc.Dqc.type;
      if (Doc.Dqc != q.bt.DCe) {
        break label2361;
      }
    }
    label2181:
    label2361:
    for (l = Doc.Dqd;; l = 0L)
    {
      localev.iGc = l;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      localev.iDz = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn();
      localObject1 = Doc.DqC.toString();
      s.s(localObject1, "getConfig().screenShareHistory.toString()");
      localev.iGd = localev.F("PresentationJson", kotlin.n.n.bV((String)localObject1, ",", ";"), true);
      localev.bMH();
      localObject1 = Doc.Dqq;
      ((r)localObject1).liveId = "";
      ((r)localObject1).feedId = "";
      ((r)localObject1).description = "";
      ((r)localObject1).DFR = 0L;
      ((r)localObject1).DFS = 0L;
      ((r)localObject1).DFU = 0L;
      ((r)localObject1).DFT = 0L;
      ((r)localObject1).DFV = 0L;
      ((r)localObject1).DFW = 0L;
      ((r)localObject1).DFX = 0L;
      ((r)localObject1).errorCode = 0;
      ((r)localObject1).DFY = 0L;
      ((r)localObject1).DFZ = 0L;
      ((r)localObject1).DGa = 0L;
      ((r)localObject1).DGb = 0L;
      ((r)localObject1).DGc = 0L;
      ((r)localObject1).DGd = 0L;
      ((r)localObject1).DGe = 0L;
      ((r)localObject1).DGf = 0L;
      ((r)localObject1).DGg = 0L;
      ((r)localObject1).DGh = 0L;
      ((r)localObject1).DGl = "";
      ((r)localObject1).DGj = 0L;
      ((r)localObject1).DGk = 0L;
      ((r)localObject1).DGi.clear();
      localObject1 = Doc;
      ((q)localObject1).Dqn = 0L;
      ((q)localObject1).Dqo = 0L;
      ((q)localObject1).Dqp = 0L;
      ((q)localObject1).Dqr = false;
      ((q)localObject1).Dqs = false;
      ((q)localObject1).Dqt = false;
      ((q)localObject1).Dqu = false;
      ((q)localObject1).Dqv = false;
      ((q)localObject1).DpM = 0;
      ((q)localObject1).Dpa.clear();
      ((q)localObject1).DpN = false;
      ((q)localObject1).DpO.clear();
      ((q)localObject1).Dqw.clear();
      ((q)localObject1).DpD = 0L;
      ((q)localObject1).DpE = false;
      ((q)localObject1).DpF = false;
      ((q)localObject1).tag = "";
      ((q)localObject1).DpZ = "";
      ((q)localObject1).Dqc = q.bt.DCd;
      ((q)localObject1).Dqd = 0L;
      ((q)localObject1).DpT = q.am.DyA;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.LO(0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report21056: finderUsrname=").append(localev.izG).append(", finderWxAppInfo=").append(localev.izH).append(", isPrivate=").append(localev.izI).append(", finderSessionId=").append(localev.izJ).append(", actionTimeMs=").append(localev.izK).append(", audienceCount=").append(localev.iFH).append(", likeCount=").append(localev.iBZ).append(", newFansNum=").append(localev.iFI).append(", liveDurationSeconds=").append(localev.iFF).append(", liveId=").append(localev.iCR).append(", feedId=").append(localev.ivZ).append(", description=");
      ((StringBuilder)localObject1).append(localev.iCS).append(", liveStartTimeMs=").append(localev.iFD).append(", liveEndTimeMs=").append(localev.iFE).append(", oriFansCount=").append(localev.iFG).append(", errorCode=").append(localev.inj).append(", floatingCount=").append(localev.iDd).append(", shareSnsCount=").append(localev.iFJ).append(", shareSessionCount=").append(localev.iFK).append(", exchangeCameraCount=").append(localev.iFL).append(", complainCount=").append(localev.iFM).append(", allCommentCloseCount=").append(localev.iFN).append(", allCommentOpenCount=").append(localev.iFO);
      ((StringBuilder)localObject1).append(", personalCommentCloseCount=").append(localev.iFP).append(", personalCommentOpenCount=").append(localev.iFQ).append(", kickOutCount=").append(localev.iFR).append(", promoteGoodsJson=").append(localev.iFS).append(", promoteGoodsCount=").append(localev.iFT).append(", shopWindowId=").append(localev.iFU).append(", nudgeCount=").append(localev.iFW).append(", lotteryCount=").append(localev.iDu).append(", connectCount=").append(localev.iFX).append(", connectDuration=").append(localev.iDx).append(", micWithAnchor=").append(localev.iGa).append(", sourceScene=");
      ((StringBuilder)localObject1).append(localev.iCU).append(", isGift=").append(localev.iFZ).append(", tag=").append(Doc.tag).append(", subTag=").append(Doc.DpZ).append(", visibleRange=").append(localev.iGb).append(", topComment=").append(localev.iFV).append(", presentationJson=").append(localev.iGd);
      Log.i("HABBYGE-MALI.HellLiveReport", ((StringBuilder)localObject1).toString());
      AppMethodBeat.o(352133);
      return;
      localObject1 = Doc.Dqq.description;
      break;
      label1779:
      localObject2 = ((Map)((q)localObject1).Dqq.DGi).entrySet().iterator();
      Object localObject3;
      Object localObject4;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + ((Number)((Map.Entry)localObject3).getKey()).longValue() + ':' + l + '#')
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = ((LinkedList)((Map.Entry)localObject3).getValue()).iterator();
        l = 0L;
        while (((Iterator)localObject4).hasNext())
        {
          m localm = (m)((Iterator)localObject4).next();
          if (localm.Dpq) {
            l += localm.time;
          }
        }
      }
      localObject2 = localObject1;
      if (!kotlin.n.n.rs((String)localObject1, "#")) {
        break label552;
      }
      int i = ((String)localObject1).length();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(352133);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((String)localObject1).substring(0, i - 1);
      s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      break label552;
      label1995:
      localObject2 = Doc.Dpa.iterator();
      localObject1 = "";
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.vending.j.d)((Iterator)localObject2).next();
        localObject4 = ((com.tencent.mm.vending.j.d)localObject3).get(2);
        s.s(localObject4, "tuple.`$3`()");
        if (((Boolean)localObject4).booleanValue()) {
          localObject1 = (String)localObject1 + ((q.ar)((com.tencent.mm.vending.j.b)localObject3).get(0)).type + '|' + ((com.tencent.mm.vending.j.c)localObject3).get(1) + ';';
        }
      }
      localObject2 = localObject1;
      if (!s.p(localObject1, ""))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(352133);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localev.po((String)localObject2);
      break label748;
      localObject2 = Doc.DpO.iterator();
      localObject1 = "";
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.vending.j.d)((Iterator)localObject2).next();
        localObject4 = ((com.tencent.mm.vending.j.d)localObject3).get(2);
        s.s(localObject4, "tuple.`$3`()");
        if (((Boolean)localObject4).booleanValue()) {
          localObject1 = (String)localObject1 + ((com.tencent.mm.vending.j.b)localObject3).get(0) + '|' + ((com.tencent.mm.vending.j.c)localObject3).get(1) + ';';
        }
      }
      localObject2 = localObject1;
      if (!s.p(localObject1, ""))
      {
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(352133);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(0, i - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localev.pp((String)localObject2);
      break label769;
    }
  }
  
  private static void eti()
  {
    AppMethodBeat.i(352224);
    Doc.DpA = false;
    Doc.axz("");
    AppMethodBeat.o(352224);
  }
  
  public static q.v etj()
  {
    return Doc.Dqi;
  }
  
  private static void etk()
  {
    AppMethodBeat.i(352298);
    Doc.Dqj = System.currentTimeMillis();
    AppMethodBeat.o(352298);
  }
  
  public static int etl()
  {
    return Doc.Dqm;
  }
  
  public static void etn()
  {
    AppMethodBeat.i(352389);
    Log.i("HABBYGE-MALI.HellLiveReport", "stopDeviceStatus");
    Dof.mPe.stopTimer();
    AppMethodBeat.o(352389);
  }
  
  public static void resetConfig()
  {
    q localq = Doc;
    localq.mIC = "";
    localq.liveId = "";
    localq.objectId = "";
    localq.Dqe = "";
  }
  
  public static void setDesc(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Doc.desc = paramString;
  }
  
  public static void setErrorCode(int paramInt)
  {
    Doc.errCode = paramInt;
  }
  
  public final void C(long paramLong, String paramString)
  {
    AppMethodBeat.i(352458);
    Object localObject;
    if (paramLong == q.a.DqE.mwI)
    {
      localObject = Doc;
      ((q)localObject).b(((q)localObject).Dqa);
    }
    ew localew = new ew();
    a(localew);
    if (paramLong == q.a.DqR.mwI)
    {
      if (s.p(paramString, String.valueOf(q.aq.Dzb.action))) {
        Doc.a(q.aq.Dzb);
      }
    }
    else
    {
      localew.ioV = paramLong;
      if (paramString != null) {
        break label284;
      }
      paramString = "";
    }
    for (;;)
    {
      localew.pu(paramString);
      localew.iCU = Doc.Dqz.source;
      localew.bMH();
      Log.i("HABBYGE-MALI.HellLiveReport", "report21017: finderUsrname=" + localew.izG + ", finderWxAppInfo=" + localew.izH + ", isPrivate=" + localew.izI + ", finderSessionId=" + localew.izJ + ", actionTimeMs=" + localew.izK + ", actionType=" + localew.ioV + ", sourceScene=" + localew.iCU + ", actionJson=" + localew.iGe);
      AppMethodBeat.o(352458);
      return;
      if (!s.p(paramString, String.valueOf(q.aq.Dzc.action))) {
        break;
      }
      Doc.a(q.aq.Dzc);
      break;
      label284:
      localObject = kotlin.n.n.m(paramString, ",", ";", false);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
  }
  
  public final void Pg(int paramInt)
  {
    AppMethodBeat.i(352693);
    a(q.c.DrK, String.valueOf(paramInt));
    AppMethodBeat.o(352693);
  }
  
  public final void Ph(int paramInt)
  {
    AppMethodBeat.i(352698);
    try
    {
      new JSONObject().put("button_type", String.valueOf(paramInt));
      a(q.c.DrU, String.valueOf(paramInt));
      return;
    }
    finally
    {
      AppMethodBeat.o(352698);
    }
  }
  
  public final void Pi(int paramInt)
  {
    AppMethodBeat.i(352704);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("sub_action", paramInt);
    a(q.c.DrQ, localJSONObject.toString());
    AppMethodBeat.o(352704);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, long paramLong5, long paramLong6, q.ca paramca, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(352682);
    s.u(paramw, "actionType");
    s.u(paramString2, "commentscene");
    s.u(paramca, "enterType");
    s.u(paramString4, "clickSubTabContextId");
    s.u(paramString5, "chnlExtra");
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      paramString2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (c.a.arO(paramString2))
      {
        if (paramString1 != null) {
          break label197;
        }
        paramString1 = "";
      }
      label197:
      for (;;)
      {
        String str2 = q.n.Dty.scene;
        paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        paramLong3 = c.a.arN(paramString2);
        paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq;
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = "";
        }
        String str1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr;
        paramString3 = str1;
        if (str1 == null) {
          paramString3 = "";
        }
        c(new o(paramLong1, paramLong2, paramString1, 0L, paramLong4, paramw, str2, paramLong5, paramLong3, paramString2, paramString3, paramLong6, paramca, null, null, paramString4, paramString5, 24576));
        AppMethodBeat.o(352682);
        return;
      }
    }
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString3 != null) {
        break label278;
      }
      paramString3 = "";
    }
    label278:
    for (;;)
    {
      c(new o(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramw, paramString2, paramLong5, -1L, "", "", paramLong6, paramca, paramString3, null, paramString4, paramString5, 16384));
      AppMethodBeat.o(352682);
      return;
      break;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, String paramString3)
  {
    AppMethodBeat.i(352650);
    s.u(paramw, "actionType");
    s.u(paramString2, "commentscene");
    s.u(paramString3, "chnlExtra");
    a(paramLong1, paramLong2, paramString1, paramLong3, paramLong4, paramw, paramString2, "", "", paramString3);
    AppMethodBeat.o(352650);
  }
  
  public final void a(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, c.e parame, int paramInt1, int paramInt2, q.w paramw, String paramString, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(352600);
    s.u(parame, "visibleState");
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    s.u(paramd, "event");
    Object localObject = Dod;
    s.u(parame, "visibleState");
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    s.u(paramd, "event");
    localObject = ((a)localObject).DmZ;
    s.u(parame, "visibleState");
    s.u(paramd, "event");
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    int i;
    if (k.contains(((f)localObject).DnC, paramString)) {
      switch (f.a.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        if (s.p(paramString, "61"))
        {
          paramString = "temp_6";
          i = 1;
          label187:
          ((f)localObject).DnA = paramw;
          ((f)localObject).DnB = paramString;
          if (i == 0) {
            break label808;
          }
          if (paramd != d.Dng) {
            break label725;
          }
          parame = com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLm;
          parame = (com.tencent.mm.plugin.expt.hellhound.ext.f.a)((f)localObject).DnI;
          com.tencent.mm.plugin.expt.hellhound.ext.f.d.mFirstPostion = -1;
          com.tencent.mm.plugin.expt.hellhound.ext.f.d.mVisibleItemCount = -1;
          com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLn.clear();
          if (parame != null) {
            com.tencent.mm.plugin.expt.hellhound.ext.f.d.listeners.remove(parame);
          }
          ((f)localObject).DnG = true;
          label259:
          if (!((f)localObject).DnG)
          {
            parame = com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLm;
            if (paramAbsListView != null)
            {
              if (com.tencent.mm.plugin.expt.hellhound.ext.f.d.mScreenHeight <= 0)
              {
                parame = paramAbsListView.getContext();
                if (!(parame instanceof AppCompatActivity)) {
                  break label757;
                }
                parame = (AppCompatActivity)parame;
                label298:
                paramw = (Activity)parame;
                if (paramw != null)
                {
                  paramw = paramw.getResources();
                  i = paramw.getDimensionPixelSize(paramw.getIdentifier("status_bar_height", "dimen", "android"));
                  com.tencent.mm.plugin.expt.hellhound.ext.f.d.mStatusBarHeight = i;
                  if (i <= 0) {
                    com.tencent.mm.plugin.expt.hellhound.ext.f.d.mStatusBarHeight = paramw.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
                  }
                }
                com.tencent.mm.plugin.expt.hellhound.ext.f.d.initActionBarHeight((Activity)parame);
                com.tencent.mm.plugin.expt.hellhound.ext.f.d.initScreenHeight((Activity)parame);
                Log.i("HABBYGE-MALI.SnsFeedMonitor", "init: mScreenRealHeight=" + com.tencent.mm.plugin.expt.hellhound.ext.f.d.mScreenRealHeight + ", mScreenHeight=" + com.tencent.mm.plugin.expt.hellhound.ext.f.d.mScreenHeight + ", mStatusBarHeight=" + com.tencent.mm.plugin.expt.hellhound.ext.f.d.mStatusBarHeight + ", mActionBarHeight=" + com.tencent.mm.plugin.expt.hellhound.ext.f.d.mActionBarHeight + ", virtualKeyHeight=" + com.tencent.mm.plugin.expt.hellhound.ext.f.d.virtualKeyHeight);
              }
              if ((paramInt1 >= 0) && (paramInt2 > 0))
              {
                com.tencent.mm.plugin.expt.hellhound.ext.f.d.mFirstPostion = paramInt1;
                com.tencent.mm.plugin.expt.hellhound.ext.f.d.mVisibleItemCount = paramInt2;
              }
              paramInt1 = com.tencent.mm.plugin.expt.hellhound.ext.f.d.mVisibleItemCount - 1;
              if (paramInt1 < 0) {
                break;
              }
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1 - 1;
      parame = paramAbsListView.getChildAt(paramInt1);
      if (parame != null)
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.ext.f.d._getHellFeed(parame, paramInt1, paramAbsListView, com.tencent.mm.plugin.expt.hellhound.ext.f.d.mFirstPostion);
        if (paramString != null)
        {
          paramw = (com.tencent.mm.plugin.expt.hellhound.ext.a.c)paramString.get(0);
          paramString = (Boolean)paramString.get(1);
          s.s(paramString, "isShow");
          if (!paramString.booleanValue()) {
            break label762;
          }
          if (!com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLn.containsKey(paramw.zDG.feedId))
          {
            paramString = (Map)com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLn;
            paramd = paramw.zDG.feedId;
            s.s(paramd, "snsFeed.feed.feedId");
            s.s(paramw, "snsFeed");
            paramString.put(paramd, paramw);
            com.tencent.mm.plugin.expt.hellhound.ext.f.d.onFeedAppear(paramBaseAdapter, paramw, parame);
          }
        }
      }
      for (;;)
      {
        label808:
        if (paramInt2 < 0)
        {
          AppMethodBeat.o(352600);
          return;
          if (((f)localObject).Dnz) {
            break;
          }
          ((f)localObject).etb();
          ((f)localObject).Dnz = true;
          break;
          if (!((f)localObject).Dnz) {
            break;
          }
          ((f)localObject).etc();
          ((f)localObject).Dnz = false;
          break;
          if (!paramBoolean) {
            break;
          }
          ((f)localObject).etb();
          ((f)localObject).Dnz = true;
          break;
          ((f)localObject).etc();
          ((f)localObject).Dnz = false;
          break;
          ((f)localObject).Dnw.clear();
          break;
          i = 0;
          break label187;
          label725:
          if (paramd != d.Dnf) {
            break label259;
          }
          ((f)localObject).DnG = false;
          parame = com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLm;
          com.tencent.mm.plugin.expt.hellhound.ext.f.d.registerListener((com.tencent.mm.plugin.expt.hellhound.ext.f.a)((f)localObject).DnI);
          break label259;
          label757:
          parame = null;
          break label298;
          label762:
          if (com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLn.containsKey(paramw.zDG.feedId))
          {
            com.tencent.mm.plugin.expt.hellhound.ext.f.d.zLn.remove(paramw.zDG.feedId);
            s.s(paramw, "snsFeed");
            com.tencent.mm.plugin.expt.hellhound.ext.f.d.dMD();
            continue;
            if (paramd == d.Dng)
            {
              paramw = ((f)localObject).DnF;
              parame = paramw;
              if (paramw == null)
              {
                s.bIx("unregister_method");
                parame = null;
              }
              parame.invoke(null, new Object[] { ((f)localObject).DnH });
              ((f)localObject).DnG = true;
            }
            for (;;)
            {
              if (!((f)localObject).DnG)
              {
                paramw = ((f)localObject).DnD;
                parame = paramw;
                if (paramw == null)
                {
                  s.bIx("monitor_method");
                  parame = null;
                }
                parame.invoke(null, new Object[] { paramAbsListView, paramBaseAdapter, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
              }
              AppMethodBeat.o(352600);
              return;
              if (paramd == d.Dnf)
              {
                ((f)localObject).DnG = false;
                paramw = ((f)localObject).DnE;
                parame = paramw;
                if (paramw == null)
                {
                  s.bIx("register_method");
                  parame = null;
                }
                parame.invoke(null, new Object[] { ((f)localObject).DnH });
              }
            }
          }
        }
      }
      paramInt1 = paramInt2;
    }
  }
  
  public final void a(q.ap paramap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352499);
    s.u(paramap, "linkOp");
    switch (b.bOM[paramap.ordinal()])
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
          ((JSONObject)localObject).put("type", paramap.action);
          paramap = paramString;
          if (paramString == null) {
            paramap = "";
          }
          ((JSONObject)localObject).put("result", paramap);
          ((JSONObject)localObject).put("MicType", paramInt1);
          ((JSONObject)localObject).put("InviteType", paramInt2);
          a(q.c.Drx, ((JSONObject)localObject).toString());
          AppMethodBeat.o(352499);
          return;
          localObject = Doc;
          ((q)localObject).DpM += 1;
          Doc.Dpa.add(com.tencent.mm.vending.j.a.g(q.ar.Dzj, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
          continue;
          localObject = Doc;
          ((q)localObject).DpM += 1;
          Doc.Dpa.add(com.tencent.mm.vending.j.a.g(q.ar.Dzk, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
          continue;
          if (!Doc.DpQ)
          {
            a(q.ar.Dzj);
            AppMethodBeat.o(352499);
            return;
          }
          Doc.DpQ = false;
          a(q.ar.Dzj);
          continue;
          if (Doc.DpS)
          {
            a(q.ar.Dzk);
            Doc.DpS = false;
            AppMethodBeat.o(352499);
            return;
          }
          a(q.ar.Dzk);
          continue;
          if (paramString == null)
          {
            AppMethodBeat.o(352499);
            return;
          }
          Doc.DpN = true;
          Doc.DpO.add(com.tencent.mm.vending.j.a.g(paramString, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        }
      } while (!Doc.DpN);
      etg();
      AppMethodBeat.o(352499);
      return;
    }
    etg();
    AppMethodBeat.o(352499);
  }
  
  public final void a(q.av paramav, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352576);
    s.u(paramav, "actionType");
    s.u(paramString2, "description");
    if (paramav == q.av.DzU)
    {
      localObject = g.zHI;
      g.a.LP(0);
    }
    Object localObject = new fe();
    a((fe)localObject);
    ((fe)localObject).ioV = paramav.mwI;
    paramav = paramString1;
    if (paramString1 == null) {
      paramav = "";
    }
    ((fe)localObject).pD(paramav);
    ((fe)localObject).iCU = Doc.DqA.source;
    ((fe)localObject).iGI = 1L;
    paramav = paramString2.getBytes(kotlin.n.d.UTF_8);
    s.s(paramav, "(this as java.lang.String).getBytes(charset)");
    ((fe)localObject).pE(Base64.encodeToString(paramav, 0));
    ((fe)localObject).bMH();
    Log.i("HABBYGE-MALI.HellLiveReport", "report21106: finderUsrname=" + ((fe)localObject).izG + ", finderWxAppInfo=" + ((fe)localObject).izH + ", isPrivate=" + ((fe)localObject).izI + ", finderSessionId=" + ((fe)localObject).izJ + ", actionTimeMs=" + ((fe)localObject).izK + ", actionType=" + ((fe)localObject).ioV + ", sourceScene=" + ((fe)localObject).iCU + ", actionJson=" + ((fe)localObject).iGe);
    AppMethodBeat.o(352576);
  }
  
  public final void a(q.bd parambd)
  {
    AppMethodBeat.i(352429);
    s.u(parambd, "action");
    switch (b.avl[parambd.ordinal()])
    {
    }
    do
    {
      for (;;)
      {
        em localem = new em();
        localem.iwW = System.currentTimeMillis();
        localem.ikE = parambd.action;
        localem.iwZ = Doc.Dqy.type;
        String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        parambd = str;
        if (str == null) {
          parambd = "";
        }
        localem.iEk = localem.F("Session_Id", parambd, true);
        localem.iqP = localem.F("ContextID", ((e)h.az(e.class)).getNearbyTabLifecycleReporter().eeL(), true);
        localem.ipU = localem.F("ClickTabContextId", ((e)h.az(e.class)).getNearbyTabLifecycleReporter().eGM(), true);
        localem.bMH();
        Log.i("HABBYGE-MALI.HellLiveReport", "report21631: actionTS=" + localem.iwW + ", pageType=" + localem.iwZ + ", action=" + localem.ikE + ", clickid=" + localem.iEi + ", session_Id=" + localem.iEk + ", contextID=" + localem.iqP + ", clickTabContextId=" + localem.ipU);
        AppMethodBeat.o(352429);
        return;
        mZI = false;
        continue;
        mZI = true;
        Doc.b(q.br.DBX);
      }
    } while (!mZI);
    mZI = false;
    AppMethodBeat.o(352429);
  }
  
  public final void a(q.bm parambm)
  {
    AppMethodBeat.i(352509);
    s.u(parambm, "action");
    Log.w("HABBYGE-MALI.HellLiveReport", s.X("reportVest, action: ", parambm.name()));
    switch (b.bPp[parambm.ordinal()])
    {
    }
    while (Doc.DpV)
    {
      a(q.b(parambm));
      AppMethodBeat.o(352509);
      return;
      if ((!Dog) && (!Doc.DpV))
      {
        AppMethodBeat.o(352509);
        return;
      }
    }
    a(q.c.Drz, String.valueOf(parambm.action));
    AppMethodBeat.o(352509);
  }
  
  public final void a(q.c paramc, String paramString)
  {
    AppMethodBeat.i(352540);
    s.u(paramc, "actionType");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(352540);
      return;
    }
    long l = System.currentTimeMillis();
    eh localeh;
    switch (b.bPq[paramc.ordinal()])
    {
    default: 
      localeh = new eh();
      a(localeh, l);
      localeh.oF(Doc.etw());
      localeh.oG(Doc.etx());
      if (TextUtils.isEmpty((CharSequence)Doc.Dqq.description))
      {
        localObject = q.getDescription();
        label138:
        localeh.oH((String)localObject);
        localeh.iwS = Doc.Dqp;
        localeh.iBZ = Doc.Dqn;
        localeh.iCT = Doc.Dqo;
        localeh.ioV = paramc.action;
        switch (b.bPq[paramc.ordinal()])
        {
        default: 
          if (paramString == null) {
            paramc = "";
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      localeh.oI(paramc);
      for (;;)
      {
        localeh.iCU = Doc.Dqz.source;
        localeh.bMH();
        paramc = new StringBuilder();
        paramc.append("report21054: finderUsrname=").append(localeh.izG).append(", finderWxAppInfo=").append(localeh.izH).append(", isPrivate=").append(localeh.izI).append(", finderSessionId=").append(localeh.izJ).append(", actionTimeMs=").append(localeh.izK).append(", liveId=").append(localeh.iCR).append(", feedId=").append(localeh.ivZ).append(", description=").append(localeh.iCS).append(", sourceScene=").append(localeh.iCU).append(", liveTime=").append(localeh.iwS).append(", likeCount=").append(localeh.iBZ).append(", onlineCount=");
        paramc.append(localeh.iCT).append(", actionType=").append(localeh.ioV).append(", actionResult=").append(localeh.iwX);
        Log.i("HABBYGE-MALI.HellLiveReport", paramc.toString());
        AppMethodBeat.o(352540);
        return;
        Doc.DpU = l;
        Doc.Dqq.DFR = l;
        break;
        if (!s.p(paramString, String.valueOf(q.ag.Dyd.action))) {
          break;
        }
        Doc.a(q.am.Dyz);
        break;
        if (Doc.Dqp > 0L) {
          break;
        }
        AppMethodBeat.o(352540);
        return;
        if (!s.p(paramString, String.valueOf(q.z.Dxx.type))) {
          break;
        }
        Doc.DpE = false;
        Doc.DpF = false;
        break;
        if (s.p(paramString, String.valueOf(q.bm.DBv.action)))
        {
          Dog = true;
          break;
        }
        if (!s.p(paramString, String.valueOf(q.bm.DBx.action))) {
          break;
        }
        Dog = false;
        break;
        localObject = Doc.Dqq.description;
        break label138;
        localeh.oI(ete());
        continue;
        localeh.oI(etf());
      }
      paramString = kotlin.n.n.m(paramString, ",", ";", false);
      paramc = paramString;
      if (paramString == null) {
        paramc = "";
      }
    }
  }
  
  public final void a(q.h paramh, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(352478);
    s.u(paramh, "type");
    switch (b.bOL[paramh.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      label96:
      do
      {
        localObject1 = null;
        for (;;)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("type", paramh.type);
          if (localObject1 != null) {
            break;
          }
          paramh = paramString;
          if (paramString == null) {
            paramh = "";
          }
          ((JSONObject)localObject2).put("result", paramh);
          a(q.c.Drr, ((JSONObject)localObject2).toString());
          AppMethodBeat.o(352478);
          return;
          Doc.DpE = true;
          localObject1 = null;
          continue;
          Doc.DpF = true;
          localObject1 = null;
        }
      } while (!TextUtils.isEmpty((CharSequence)paramString));
      AppMethodBeat.o(352478);
      return;
    }
    if (paramString == null) {}
    while (localObject1 == null)
    {
      try
      {
        AppMethodBeat.o(352478);
        return;
      }
      catch (Exception paramh)
      {
        Log.e("HABBYGE-MALI.HellLiveReport", s.X("START_LOTTERY_SUCCESS crash: ", paramh.getMessage()));
        AppMethodBeat.o(352478);
        return;
      }
      localObject1 = kotlin.n.n.a((CharSequence)paramString, new String[] { "@" });
    }
    int i = Integer.parseInt((String)((List)localObject1).get(0));
    Object localObject2 = kotlin.n.n.a((CharSequence)((List)localObject1).get(1), new String[] { ";" });
    switch (i)
    {
    }
    for (;;)
    {
      label304:
      localObject1 = MMApplicationContext.getResources().getString(p.h.Cms);
      for (;;)
      {
        s.s(localObject1, "if (lotteryType == Const…chooser_type_any_comment)");
        localObject1 = (String)localObject1 + ';' + (String)((List)localObject2).get(1) + ';' + (String)((List)localObject2).get(2) + ';' + (String)((List)localObject2).get(3);
        localObject2 = Doc;
        ((q)localObject2).DpD += 1L;
        break;
        if (TextUtils.isEmpty((CharSequence)((List)localObject2).get(0))) {
          break label304;
        }
        localObject1 = (String)((List)localObject2).get(0);
        continue;
        localObject1 = MMApplicationContext.getResources().getString(p.h.CmL);
        continue;
        localObject1 = MMApplicationContext.getResources().getString(p.h.Cmx);
        continue;
        localObject1 = MMApplicationContext.getResources().getString(p.h.Cmv);
      }
      paramh = (q.h)localObject1;
      break label96;
    }
  }
  
  public final void a(q.s params, Map<String, String> paramMap)
  {
    AppMethodBeat.i(352751);
    s.u(params, "elementId");
    s.u(paramMap, "eidUdfKVMap");
    cp localcp = new cp();
    localcp.ixo = Util.nowMilliSecond();
    localcp.lV(Doc.mIC);
    localcp.lW("");
    localcp.lX("");
    localcp.lY("");
    String str2 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcp.lZ(str1);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcp.ma(str1);
    localcp.mb(com.tencent.mm.plugin.expt.hellhound.a.dIJ());
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcp.mc(str1);
    localcp.md("");
    localcp.me("");
    localcp.mf(params.id);
    localcp.mg(al(paramMap));
    localcp.bMH();
    AppMethodBeat.o(352751);
  }
  
  public final void a(q.t paramt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(352736);
    s.u(paramt, "elementId");
    s.u(paramMap, "eidUdfKVMap");
    cq localcq = new cq();
    localcq.ixo = Util.nowMilliSecond();
    localcq.mh(Doc.mIC);
    localcq.mi("");
    localcq.mj("");
    localcq.mk("");
    String str2 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcq.ml(str1);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcq.mm(str1);
    localcq.mn(com.tencent.mm.plugin.expt.hellhound.a.dIJ());
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcq.mo(str1);
    localcq.mp("");
    localcq.mq("");
    localcq.mr("");
    localcq.ms(paramt.id);
    localcq.mt(al(paramMap));
    localcq.bMH();
    AppMethodBeat.o(352736);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, FinderLiveBundle paramFinderLiveBundle)
  {
    AppMethodBeat.i(352445);
    if (Doc.Dqs)
    {
      AppMethodBeat.o(352445);
      return;
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    JSONObject localJSONObject = new JSONObject();
    int i;
    if ((paramf == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId <= 0L)) {
      if (paramFinderLiveBundle == null)
      {
        paramf = null;
        if (paramf != null) {
          break label193;
        }
        paramf = g.zHI;
        i = g.a.dKQ();
        if (i > 0) {
          break label151;
        }
        localJSONObject.put("type", q.ay.DAj.type);
      }
    }
    for (;;)
    {
      C(q.a.DqF.mwI, localJSONObject.toString());
      b(q.v.DwM);
      a(q.q.Dua);
      etk();
      AppMethodBeat.o(352445);
      return;
      paramf = paramFinderLiveBundle.Bpo;
      break;
      label151:
      if (j < i)
      {
        localJSONObject.put("type", q.ay.DAk.type);
      }
      else
      {
        localJSONObject.put("type", q.ay.DAj.type);
        continue;
        label193:
        if (paramFinderLiveBundle == null) {
          i = 0;
        }
        for (;;)
        {
          if (j >= i) {
            break label245;
          }
          localJSONObject.put("type", q.ay.DAk.type);
          break;
          paramf = paramFinderLiveBundle.Bpo;
          if (paramf == null) {
            i = 0;
          } else {
            i = paramf.startTime;
          }
        }
        label245:
        localJSONObject.put("type", q.ay.DAj.type);
        continue;
        localJSONObject.put("type", q.ay.DAl.type);
        localJSONObject.put("liveid", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      }
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, q.w paramw, String paramString)
  {
    AppMethodBeat.i(352637);
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    long l3 = paramBaseFinderFeed.bZA();
    Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed != null) {
        break label127;
      }
    }
    label127:
    for (long l2 = -1L;; l2 = paramBaseFinderFeed.DSe)
    {
      b(new n(l3, l1, (String)localObject, paramLong, l2, paramw, paramString, null, null, null, null, null, 16256));
      AppMethodBeat.o(352637);
      return;
      l1 = ((bip)localObject).liveId;
      break;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, q.w paramw, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(352643);
    s.u(paramw, "actionType");
    s.u(paramString1, "commentscene");
    s.u(paramString2, "clickTabContextId");
    s.u(paramString3, "clickSubTabContextId");
    s.u(paramString4, "chnlExtra");
    long l3;
    long l1;
    label60:
    Object localObject;
    label69:
    long l2;
    if (paramBaseFinderFeed == null)
    {
      l3 = 0L;
      if (paramBaseFinderFeed != null) {
        break label129;
      }
      l1 = 0L;
      if (paramBaseFinderFeed != null) {
        break label174;
      }
      localObject = "";
      if (paramBaseFinderFeed != null) {
        break label217;
      }
      l2 = -1L;
    }
    for (;;)
    {
      b(new n(l3, l1, (String)localObject, paramLong, l2, paramw, paramString1, null, null, paramString2, paramString3, paramString4, 1920));
      AppMethodBeat.o(352643);
      return;
      l3 = paramBaseFinderFeed.bZA();
      break;
      label129:
      localObject = paramBaseFinderFeed.feedObject;
      if (localObject == null)
      {
        l1 = 0L;
        break label60;
      }
      localObject = ((FinderItem)localObject).getLiveInfo();
      if (localObject == null)
      {
        l1 = 0L;
        break label60;
      }
      l1 = ((bip)localObject).liveId;
      break label60;
      label174:
      localObject = paramBaseFinderFeed.feedObject;
      if (localObject == null)
      {
        localObject = "";
        break label69;
      }
      String str = ((FinderItem)localObject).getUserName();
      localObject = str;
      if (str != null) {
        break label69;
      }
      localObject = "";
      break label69;
      label217:
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject;
      if (paramBaseFinderFeed == null)
      {
        l2 = -1L;
      }
      else
      {
        paramBaseFinderFeed = paramBaseFinderFeed.getLiveInfo();
        if (paramBaseFinderFeed == null) {
          l2 = -1L;
        } else {
          l2 = paramBaseFinderFeed.DSe;
        }
      }
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString)
  {
    AppMethodBeat.i(352678);
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramString, "commentscene");
    q.w localw;
    long l3;
    Object localObject;
    long l1;
    if (paramBaseFinderFeed.bZB() == 9)
    {
      localw = q.w.DwS;
      l3 = paramBaseFinderFeed.bZA();
      localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject != null) {
        break label131;
      }
      l1 = 0L;
      label58:
      localObject = paramBaseFinderFeed.feedObject.getUserName();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed != null) {
        break label141;
      }
    }
    label131:
    label141:
    for (long l2 = -1L;; l2 = paramBaseFinderFeed.DSe)
    {
      b(new n(l3, l1, (String)localObject, paramLong, l2, localw, paramString, null, null, null, null, null, 16256));
      AppMethodBeat.o(352678);
      return;
      localw = q.w.DwT;
      break;
      l1 = ((bip)localObject).liveId;
      break label58;
    }
  }
  
  public final void a(z paramz, String paramString1, long paramLong, q.w paramw, String paramString2)
  {
    AppMethodBeat.i(352629);
    s.u(paramw, "actionType");
    s.u(paramString2, "commentscene");
    if (paramz == null)
    {
      if (paramString1 == null) {}
      for (paramz = "";; paramz = paramString1)
      {
        b(new n(0L, 0L, paramz, paramLong, -1L, paramw, paramString2, null, null, null, null, null, 16256));
        AppMethodBeat.o(352629);
        return;
      }
    }
    long l3 = paramz.ECN.id;
    paramString1 = paramz.ECN.liveInfo;
    long l1;
    if (paramString1 == null)
    {
      l1 = 0L;
      String str = paramz.ECN.username;
      paramString1 = str;
      if (str == null) {
        paramString1 = "";
      }
      paramz = paramz.ECN.liveInfo;
      if (paramz != null) {
        break label185;
      }
    }
    label185:
    for (long l2 = -1L;; l2 = paramz.DSe)
    {
      b(new n(l3, l1, paramString1, paramLong, l2, paramw, paramString2, null, null, null, null, null, 16256));
      AppMethodBeat.o(352629);
      return;
      l1 = paramString1.liveId;
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.utils.d paramd)
  {
    AppMethodBeat.i(352620);
    Object localObject = Doe;
    a locala = Dod;
    q localq = Doc;
    s.u(locala, "m21053Reporter");
    s.u(localq, "config");
    FeedData localFeedData;
    long l;
    if ((paramd != null) && (paramd.feed != null) && (!s.p(q.n.DtA.scene, String.valueOf(localq.DpX))))
    {
      localFeedData = paramd.feed;
      if (localFeedData != null) {
        break label163;
      }
      l = 0L;
      if (((c)localObject).Dnc != l)
      {
        ((c)localObject).Dnc = l;
        if (paramd.GfT != 9)
        {
          localObject = paramd.feed;
          if ((localObject == null) || (((FeedData)localObject).getLiveStatus() != 1)) {
            break label172;
          }
        }
      }
    }
    label163:
    label172:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        locala.a(q.w.DwQ, paramd.GfU, String.valueOf(localq.DpX), paramd.feed);
      }
      AppMethodBeat.o(352620);
      return;
      l = localFeedData.getFeedId();
      break;
    }
  }
  
  public final void axp(String paramString)
  {
    AppMethodBeat.i(352519);
    a(q.c.DrX, paramString);
    AppMethodBeat.o(352519);
  }
  
  public final void az(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(352557);
    Object localObject = new i();
    switch (paramInt2)
    {
    default: 
      paramInt2 = 0;
      switch (paramInt3)
      {
      default: 
        paramInt3 = i;
      }
      break;
    }
    for (;;)
    {
      ((i)localObject).n("result", Integer.valueOf(paramInt1));
      ((i)localObject).n("scene", Integer.valueOf(paramInt2));
      ((i)localObject).n("type", Integer.valueOf(paramInt3));
      localObject = ((i)localObject).toString();
      s.s(localObject, "JSONObject().apply {\n   …ype)\n        }.toString()");
      a(q.c.DrN, (String)localObject);
      AppMethodBeat.o(352557);
      return;
      paramInt2 = q.ai.Dyl.value;
      break;
      paramInt2 = q.ai.Dyk.value;
      break;
      paramInt2 = q.ai.Dym.value;
      break;
      paramInt3 = q.aj.Dyo.value;
      continue;
      paramInt3 = q.aj.Dyp.value;
      continue;
      paramInt3 = q.aj.Dyq.value;
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, q.w paramw, String paramString, d paramd)
  {
    AppMethodBeat.i(352611);
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    s.u(paramd, "event");
    Object localObject = paramString;
    String str;
    if (s.p(paramString, "25"))
    {
      str = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      localObject = paramString;
      if (str != null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localObject = paramString;
        if (!c.a.arO(str)) {
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
      label132:
      localObject = paramString;
      Dod.a(paramRecyclerView, paramw, (String)localObject, paramd);
      AppMethodBeat.o(352611);
      return;
      if (!str.equals("101")) {
        break;
      }
      do
      {
        do
        {
          paramString = "25";
          break label132;
          if (!str.equals("123")) {
            break;
          }
          paramString = "38";
          break label132;
        } while (str.equals("102"));
        break;
      } while (str.equals("999"));
      if ((goto 128) || (!str.equals("150"))) {
        break;
      }
      paramString = "15";
    }
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(352668);
    s.u(paramo, "enterData");
    D(paramo.Dpr, paramo.DnN);
    Doc.a(paramo.DnM, "");
    Object localObject = Dod;
    s.u(paramo, "enterData");
    el localel = new el();
    a(localel, paramo.userName);
    localel.oM(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramo.feedId));
    localel.iEa = paramo.liveId;
    localel.oT(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramo.liveId));
    localel.ikE = paramo.DnM.beV;
    localel.oO(paramo.DnN);
    localel.iAO = paramo.Dpr;
    localel.iwV = paramo.Dpv;
    localel.iEb = paramo.Dpt;
    localel.oP(paramo.mIS);
    localel.oU(paramo.Dpu);
    localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
    localel.iEd = paramo.Dps;
    localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
    if (kotlin.n.n.U(paramo.DnN, "temp_", false)) {
      if (s.p(localel.iwO, "temp_2"))
      {
        localel.oS(Doc.Dqb);
        localel.iEg = paramo.enterTime;
        localel.iwY = paramo.Dpw.type;
        if (!s.p(localel.iwO, "61"))
        {
          paramo = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
          if (!s.p(b.a.dLz(), "123")) {}
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)) {
            break label690;
          }
        }
      }
    }
    label690:
    for (paramo = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();; paramo = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)
    {
      localel.oV(paramo);
      localel.bMH();
      paramo = ((a)localObject).TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report21053OnClickOnShare, struct=\nfeedId=").append(localel.iuI).append("\nliveId=").append(localel.iEe).append("\nuserName=").append(localel.irj).append("\nisPrivate=").append(localel.iwP).append("\nsessionID=").append(localel.iqO).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\ncontextId=").append(localel.ipT).append("\nonlineNum=");
      ((StringBuilder)localObject).append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nsessionBuffer=").append(localel.iqp).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\nenterSessionId=").append(localel.iEg).append("\nenterIconType=").append(localel.iwY).append("\nsnsSessionID=").append(localel.iEh).append("\nsnsFeedId=").append(localel.iEf);
      Log.i(paramo, ((StringBuilder)localObject).toString());
      AppMethodBeat.o(352668);
      return;
      localel.oS(paramo.DnN);
      break;
      long l = paramo.feedId;
      String str = localel.iwO;
      s.s(str, "struct.commentScene");
      localel.oS(a.aq(l, Long.parseLong(str)));
      break;
    }
  }
  
  public final void bc(JSONObject paramJSONObject)
  {
    Doc.Dql = paramJSONObject;
  }
  
  public final void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(352712);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt);
    localJSONObject.putOpt("result", paramString);
    a(q.c.DrF, localJSONObject.toString());
    AppMethodBeat.o(352712);
  }
  
  public final void c(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(352689);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt1);
    if (paramInt2 == 0) {
      localJSONObject.put("result", 1);
    }
    for (;;)
    {
      if (paramLong > 0L) {
        localJSONObject.put("product", paramLong);
      }
      if (paramInt3 > 0L) {
        localJSONObject.put("total_during", paramInt3);
      }
      a(q.c.DrW, localJSONObject.toString());
      AppMethodBeat.o(352689);
      return;
      if (paramInt2 == 1) {
        localJSONObject.put("result", 2);
      } else if (paramInt2 > 0) {
        localJSONObject.put("result", paramInt2);
      }
    }
  }
  
  public final q etm()
  {
    return Doc;
  }
  
  public final void hJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352487);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt1);
    if (paramInt1 == 2) {
      localJSONObject.put("times", paramInt2);
    }
    a(q.c.DrE, localJSONObject.toString());
    AppMethodBeat.o(352487);
  }
  
  public final void hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(352743);
    s.u(paramString1, "event");
    s.u(paramString2, "paramsJson");
    jd localjd = new jd();
    localjd.iQR = localjd.F("Event", paramString1, true);
    localjd.iGf = localjd.F("Params", kotlin.n.n.m(paramString2, ",", ";", false), true);
    localjd.bMH();
    AppMethodBeat.o(352743);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveReport$CgiErrorInfo;", "", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final int errCode;
    final String errMsg;
    final int errType;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.errMsg = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(351963);
      if (this == paramObject)
      {
        AppMethodBeat.o(351963);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(351963);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.errType != paramObject.errType)
      {
        AppMethodBeat.o(351963);
        return false;
      }
      if (this.errCode != paramObject.errCode)
      {
        AppMethodBeat.o(351963);
        return false;
      }
      if (!s.p(this.errMsg, paramObject.errMsg))
      {
        AppMethodBeat.o(351963);
        return false;
      }
      AppMethodBeat.o(351963);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(351953);
      int j = this.errType;
      int k = this.errCode;
      if (this.errMsg == null) {}
      for (int i = 0;; i = this.errMsg.hashCode())
      {
        AppMethodBeat.o(351953);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(351944);
      String str = "CgiErrorInfo(errType=" + this.errType + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
      AppMethodBeat.o(351944);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.j
 * JD-Core Version:    0.7.0.1
 */
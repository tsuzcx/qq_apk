package com.tencent.mm.plugin.finder.live.report;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bx;
import com.tencent.mm.autogen.mmdata.rpt.cm;
import com.tencent.mm.autogen.mmdata.rpt.ei;
import com.tencent.mm.autogen.mmdata.rpt.ej;
import com.tencent.mm.autogen.mmdata.rpt.en;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveVisitorReoprter;", "Lcom/tencent/mm/plugin/findersdk/api/IHellLiveVisitorReoprter;", "()V", "TAG", "", "activeCloselinkMic", "", "getActiveCloselinkMic", "()Z", "setActiveCloselinkMic", "(Z)V", "autoFillComment", "value", "chnlExtra", "getChnlExtra", "()Ljava/lang/String;", "setChnlExtra", "(Ljava/lang/String;)V", "clearCount", "", "clickSubTabContextId", "getClickSubTabContextId", "setClickSubTabContextId", "clickToLandscape", "", "clickToPortrait", "commentScene", "getCommentScene", "setCommentScene", "commentsCount", "complainAnchor", "complainVisitor", "emojiCount", "enterFollow", "enterLiveTimeCostStructMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveCdnUserEnterLiveTimeCostStruct;", "Lkotlin/collections/HashMap;", "enterProfileEventInLiveRoom", "enterTime", "getEnterTime", "()J", "setEnterTime", "(J)V", "enterType", "exitFollow", "feedId", "finderUserName", "forbidden", "gLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "Lkotlin/collections/ArrayList;", "giftCount", "giftIconReprtedYet", "goodsClickData", "groupChat", "inLiveRedPacket", "isBubbleShow", "isPrivate", "isShopExp", "setShopExp", "isWeAppOpen", "lastShowBubbleInfo", "linkMicDuration", "linkMicSuccCount", "linkMicType", "linkMicing", "linkmicIconReprtedYet", "liveId", "liveRoomState", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "getLiveRoomState", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "setLiveRoomState", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;)V", "liveStartTime", "liveStatus", "liveTopic", "mClickJoinLottery", "mClickLotteryHistory", "getMClickLotteryHistory", "setMClickLotteryHistory", "mIsEnterLivingRoom", "mIsFloat", "mLastFloatTS", "mLastFullTS", "mLotterySuccCount", "mPageType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenDirection;", "mSwitchScreenByHand", "mSwithcScreenEvent", "mTotalFloatTime", "mTotalFullTime", "minizaionCount", "profileCount", "redPacketSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketSrc;", "redPacketVisiable", "replyCommentCount", "rotateToLandscape", "rotateToPortrait", "scenenote", "getScenenote", "setScenenote", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "shareMoments", "shopPermit", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShopPermitAction;", "singleChat", "tryToLinkMicCount", "appendTigerFlag", "src", "assignScenenote", "", "_scenenote", "bundleToMap", "", "bundle", "Landroid/os/Bundle;", "doReportRedPacket", "type", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketType;", "fillOrderReport", "struct", "Lcom/tencent/mm/protocal/protobuf/OrderReportStruct;", "getEnterLiveTimeCostStruct", "getLinkType", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLinkMicAction;", "getSessionBuf", "mFeedId", "mScene", "getVisitorRoleType", "markBeginEnterLive", "markFirstFrameAvailable", "markHasMicInfo", "hasMicInfo", "markJoinResp", "markMicLaunched", "markPlayerConnect", "markShowCdnPlayerView", "markStartCdnPlay", "markTapEnterLive", "msgReport", "content", "title", "grade", "isInBox", "groupId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;)V", "report21084", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAction;", "actionJson", "actionMs", "actionStyleJson", "newCommentScene", "newChnlExtra", "report21158", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "finderUsrName", "enterLiveId", "enterStatus", "commentscene", "forcePushId", "noticeType", "reportContent", "notificationId", "desc", "scene", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "report21178", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCloseType;", "report23083", "errorReason", "report23432", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FinderAudienceHistoryLiveActionLogAction;", "index", "reportAnchorPauseLive", "actionResult", "reportAssistantLottery", "reportAssistantMoreAction", "theme", "reportAssistantShopAction", "model_type", "click_type", "card_index", "reportAtBtnClick", "reportAtSomeOneExpose", "enable", "reportAtSomeoneChosen", "method", "userList", "", "reportBizHeadClick", "isBizMode", "reportBizNameClick", "reportBoxLive", "json", "Lorg/json/JSONObject;", "reportCastScreen", "result", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CastScreenResult;", "reportChangeSideBar", "reportChargeLive", "duration", "reportClearScreen", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ClearScreenAction;", "reportClickLinkmicAvatar", "reportCommentOperation", "isBox", "boxId", "likeComment", "reportCommerceAction", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "shopSessionId", "productId", "canvasid", "aid", "uxinfo", "reportCommerceReplayAction", "actionStyle", "reportComplaintAnchor", "reportComplaintVisitor", "username", "source", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ComplaintVisitorSource;", "reportCopyComment", "reportEnterLiveTimeCost", "objectId", "reportEnterProfile", "reportFansClub", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorFansClub;", "needPurcahse", "isFromGift", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorFansClub;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "reportFloat", "isMini", "floatType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FloatActionType;", "reportFloatMode", "isInner", "event_type", "stay_time", "windows_type", "liveid_type", "reportFollowBtn", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowBtnAction;", "reportGameRank", "appid", "error", "reportGameTeamAction", "money", "errMsg", "reportGameWelfare", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GameWelfareType;", "data", "Lcom/tencent/mm/protobuf/ByteString;", "reportGetCityInfoFail", "reportGift", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorGift;", "giftid", "num", "reportGiftAllowance", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$GiftAllowanceVisitor;", "giftId", "reportHistoryLiveEvent", "reportJoinLive", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "screenStateOfConfig", "reportJumpToGameMessage", "isClick", "gameInfoReport", "reportJumpToOfficialAccountMessage", "bizuin", "bizusername", "reportLettery", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLotteryType;", "comment", "reportLike", "reportLikeOnApplauding", "reportLinkMic", "linkeType", "linkmicIconState", "reportLiveDesc", "reportModifyDefinition", "fromBitrate", "toBitrate", "reportNearbyLiveToMore", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyMoreActionResult;", "tabId", "reportOnScreenBtnExposure", "showState", "screenTypeOfConfig", "event", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;", "(Ljava/lang/Integer;ILcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;)V", "reportOpenHandOff", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$OpenHandOffResult;", "reportPlayProductRecord", "sessionId", "entrance", "reportPlusBtnClick", "reportPromoteAction", "reportPromoteBannerAction", "reportQuitLive", "context", "Landroid/content/Context;", "outChnlExtra", "reportRealAuth", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAuthAction;", "reportRedPacket", "inLive", "visiable", "reportReplyComment", "replyContent", "reportScrollGuide", "isLoadMore", "isExposure", "reportSendBoxMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "reportSendLocationBtnClick", "poiClassifyId", "poiName", "city", "reportSendMsg", "reportShare", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShareType;", "reportSlideRoom", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "reportSomeoneAtMe", "userId", "reportSwitchScreen", "isAuto", "screenAction", "reportVisitorMusic", "reportVrMode", "repportHalfProfile", "setForbidden", "setRealScreenType", "setupReportParams", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements cf
{
  public static int ACR;
  private static String DnS;
  public static String DnT;
  public static int DoA;
  public static int DoB;
  private static int DoC;
  private static int DoD;
  public static int DoE;
  private static boolean DoF;
  private static long DoG;
  private static long DoH;
  private static long DoI;
  private static long DoJ;
  private static boolean DoK;
  private static boolean DoL;
  private static String DoM;
  private static q.u DoN;
  public static boolean DoO;
  private static q.bo DoP;
  private static long DoQ;
  private static long DoR;
  private static long DoS;
  private static long DoT;
  private static int DoU;
  private static boolean DoV;
  private static boolean DoW;
  private static int DoX;
  private static int DoY;
  private static String DoZ;
  public static final k Doi;
  private static long Doj;
  private static String Dok;
  public static String Dol;
  private static int Dom;
  private static q.bq Doo;
  public static int Dop;
  public static int Doq;
  private static int Dor;
  private static int Dos;
  private static int Dou;
  private static int Dov;
  private static ArrayList<String> Dow;
  private static int Dox;
  public static int Doy;
  public static int Doz;
  private static final ArrayList<com.tencent.mm.vending.j.d<q.ar, Long, Boolean>> Dpa;
  private static boolean Dpb;
  private static boolean Dpc;
  private static q.ar Dpd;
  private static int Dpe;
  private static String Dpf;
  private static boolean Dpg;
  private static boolean Dph;
  private static boolean Dpi;
  private static boolean Dpj;
  private static String Dpk;
  private static boolean Dpl;
  private static q.bh Dpm;
  private static boolean Dpn;
  public static boolean Dpo;
  public static HashMap<Long, ej> Dpp;
  private static long enterTime;
  public static long feedId;
  public static long liveId;
  private static int liveStatus;
  private static String sessionBuffer;
  public static String zDJ;
  
  static
  {
    AppMethodBeat.i(352194);
    Doi = new k();
    zDJ = "";
    Dok = "";
    Dol = "";
    Doo = q.bq.DBS;
    sessionBuffer = "";
    DnS = "";
    Dow = new ArrayList();
    DnT = "";
    DoM = "";
    DoN = q.u.DwE;
    DoP = q.bo.DBM;
    DoZ = "";
    Dpa = new ArrayList();
    Dpd = q.ar.Dzi;
    Dpf = "";
    Dpk = "";
    Dpm = q.bh.DAR;
    Dpp = new HashMap();
    AppMethodBeat.o(352194);
  }
  
  public static void C(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352141);
    s.u(paramString1, "feedId");
    s.u(paramString2, "liveId");
    com.tencent.mm.plugin.finder.extension.reddot.p localp = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Su("FinderLiveEntrance");
    bx localbx = new bx();
    localbx.ioV = 1L;
    String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbx.ln(str1);
    localbx.iuH = paramInt;
    localbx.lj(paramString1);
    localbx.lk(paramString2);
    if (localp == null) {}
    for (paramString1 = null;; paramString1 = localp.field_tipsId)
    {
      localbx.ll(paramString1);
      if (localp != null)
      {
        paramString1 = com.tencent.mm.ae.f.dg(localp.eav());
        paramString1.put("object_id", com.tencent.mm.ae.d.hF(localp.eav().object_id));
        paramString1 = paramString1.toString();
        s.s(paramString1, "extInfo.toString()");
        localbx.lo(n.m(paramString1, ",", ";", false));
      }
      paramString2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbx.lm(paramString1);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("report ", localbx.aIF()));
      localbx.bMH();
      AppMethodBeat.o(352141);
      return;
    }
  }
  
  public static String E(long paramLong, String paramString)
  {
    AppMethodBeat.i(352128);
    Object localObject2;
    if ((!Util.isNullOrNil(paramString)) && (!n.a((CharSequence)paramString, (CharSequence)"temp", false)))
    {
      localObject2 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).p(paramLong, Integer.parseInt(paramString));
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = "";; localObject1 = "")
    {
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = sessionBuffer;
        Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", "getSessionBuf error " + com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramLong) + " feedId:" + com.tencent.mm.plugin.expt.hellhound.core.b.hF(feedId) + " mScene:" + paramString + " result" + ((String)localObject2).length());
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(352128);
        return "";
      }
      paramString = n.bV((String)localObject2, ",", ";");
      if (paramString == null)
      {
        AppMethodBeat.o(352128);
        return "";
      }
      AppMethodBeat.o(352128);
      return paramString;
    }
  }
  
  private static void Pk(int paramInt)
  {
    q.bo localbo;
    switch (paramInt)
    {
    default: 
      localbo = q.bo.DBL;
    }
    for (;;)
    {
      DoP = localbo;
      return;
      localbo = q.bo.DBL;
      continue;
      localbo = q.bo.DBM;
    }
  }
  
  public static void a(q.bu parambu, int paramInt, long paramLong)
  {
    AppMethodBeat.i(352033);
    s.u(parambu, "action");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("duration", paramLong);
    a(parambu, String.valueOf(paramInt), 0L, localJSONObject.toString(), null, null, 52);
    AppMethodBeat.o(352033);
  }
  
  private static void a(q.bu parambu, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(352067);
    s.u(parambu, "action");
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    String str = bkq((String)localObject);
    if (DoN == q.u.DwF)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(352067);
      return;
    }
    long l1 = paramLong;
    if (paramLong <= 0L) {
      l1 = System.currentTimeMillis();
    }
    cm localcm = new cm();
    localcm.lK(com.tencent.mm.plugin.expt.hellhound.core.b.hF(liveId));
    localcm.lL(com.tencent.mm.plugin.expt.hellhound.core.b.hF(feedId));
    localcm.lM(zDJ);
    localcm.lN(URLEncoder.encode(Dok, "UTF-8"));
    localcm.ixg = localcm.F("ClickSubTabContextId", DnS, true);
    if (s.p(Dol, q.n.Dty.scene))
    {
      paramString1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
      if (s.p(b.a.dLz(), "111")) {
        Dol = q.n.Dtz.scene;
      }
    }
    paramString1 = Dol;
    localObject = (CharSequence)paramString3;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label1455;
      }
    }
    for (;;)
    {
      localcm.lO(paramString3);
      localcm.iwP = Dom;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      paramString1 = (String)localObject;
      if (localObject == null) {
        paramString1 = "";
      }
      localcm.lP(paramString1);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      paramString1 = (String)localObject;
      if (localObject == null) {
        paramString1 = "";
      }
      localcm.lQ(paramString1);
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      paramString1 = (String)localObject;
      if (localObject == null) {
        paramString1 = "";
      }
      localcm.lR(paramString1);
      paramString1 = (CharSequence)paramString4;
      label333:
      label347:
      boolean bool1;
      label376:
      boolean bool2;
      label391:
      label405:
      label442:
      long l3;
      long l2;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label1214;
        }
        localcm.lT(DnT);
        localcm.lS(E(feedId, paramString3));
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramString1 != null) {
          break label1225;
        }
        bool1 = false;
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramString1 != null) {
          break label1255;
        }
        bool2 = false;
        if ((!bool1) || (!bool2)) {
          break label1285;
        }
        paramString1 = q.bq.DBU;
        Doo = paramString1;
        localcm.iwQ = Doo.action;
        localcm.iwR = enterTime;
        paramLong = l1 - Doj;
        if (paramLong <= 0L) {
          break label1304;
        }
        localcm.iwS = paramLong;
        l3 = DoI;
        paramLong = DoJ;
        if (!DoK) {
          break label1315;
        }
        if (DoH <= 0L) {
          break label1448;
        }
        l2 = l1 - DoH;
        if (l2 <= 0L) {
          break label1309;
        }
        label486:
        paramLong = l2 + paramLong;
        l2 = l3;
      }
      for (;;)
      {
        localcm.iwU = paramLong;
        localcm.iwT = l2;
        localcm.iwV = DoN.status;
        localcm.iwW = l1;
        localcm.ikE = parambu.action;
        if (str == null)
        {
          paramString1 = "";
          label545:
          localcm.iwX = localcm.F("ActionResult", paramString1, true);
          paramString1 = j.Dob;
          localcm.iwY = q.aB(localcm.iwO, ACR);
          if (parambu == q.bu.DCh)
          {
            parambu = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
            i = com.tencent.mm.plugin.finder.live.olympic.report.b.eon();
            if (i > 0) {
              localcm.iwY = i;
            }
          }
          localcm.iwZ = DoP.action;
          parambu = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          localcm.ixa = localcm.F("AdData", n.m(c.a.arQ(zDJ), ",", ";", false), true);
          parambu = Dpf;
          if (parambu != null) {
            break label1383;
          }
          parambu = "";
          label668:
          localcm.ixb = localcm.F("Scenenote", parambu, true);
          localcm.ixc = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 0);
          parambu = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          parambu = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (parambu != null) {
            break label1408;
          }
          parambu = "";
        }
        for (;;)
        {
          localcm.ixd = localcm.F("request_id", parambu, true);
          localcm.lU("");
          if (paramString2 != null) {
            localcm.ixh = localcm.F("ActionStyle", n.m(paramString2, ",", ";", false), true);
          }
          localcm.bMH();
          parambu = new StringBuilder();
          parambu.append("report21084, liveId=").append(localcm.iuJ).append(", feedId=").append(localcm.iuI).append(", username=").append(localcm.irj).append(", topic=").append(localcm.iwN).append(", commentScene=").append(localcm.iwO).append(", isPrivate=").append(localcm.iwP).append(", contextId=").append(localcm.ipT).append(", clickTabContextId=").append(localcm.ipU).append(", sessionId=").append(localcm.iqO).append(", sessionBuffer=").append(localcm.iqp).append(", shopPermit=").append(localcm.iwQ).append(", enterSessionId=");
          parambu.append(localcm.iwR).append(", liveTime=").append(localcm.iwS).append(", floatDuration=").append(localcm.iwU).append(", fullDuration=").append(localcm.iwT).append(", enterStatus=").append(localcm.iwV).append(", actionTS=").append(localcm.iwW).append(", action=").append(localcm.ikE).append(", enterIconType=").append(localcm.iwY).append(", pageType=").append(localcm.iwZ).append(", adData=").append(localcm.ixa).append(", scenenote=").append(localcm.ixb).append(", identityType=").append(localcm.ixc);
          parambu.append(", request_id=").append(localcm.ixd).append(", actionStyle=").append(localcm.ixh).append(", actionResult=").append(localcm.iwX).append(", couponId=").append(localcm.ixi).append(", chnlExtra=").append(localcm.ixf);
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", parambu.toString());
          AppMethodBeat.o(352067);
          return;
          i = 0;
          break;
          i = 0;
          break label333;
          label1214:
          localcm.lT(paramString4);
          break label347;
          label1225:
          paramString1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramString1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          if (paramString1 == null)
          {
            bool1 = false;
            break label376;
          }
          bool1 = paramString1.EhZ;
          break label376;
          label1255:
          paramString1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramString1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          if (paramString1 == null)
          {
            bool2 = false;
            break label391;
          }
          bool2 = paramString1.CEZ;
          break label391;
          label1285:
          if (bool1)
          {
            paramString1 = q.bq.DBT;
            break label405;
          }
          paramString1 = q.bq.DBS;
          break label405;
          label1304:
          paramLong = 0L;
          break label442;
          label1309:
          l2 = 0L;
          break label486;
          label1315:
          if (DoG <= 0L) {
            break label1448;
          }
          l2 = l1 - DoG;
          if (l2 > 0L) {}
          for (;;)
          {
            l2 = l3 + l2;
            break;
            l2 = 0L;
          }
          paramString3 = n.m(str, ",", ";", false);
          paramString1 = paramString3;
          if (paramString3 != null) {
            break label545;
          }
          paramString1 = "";
          break label545;
          label1383:
          paramString1 = n.m(parambu, ",", ";", false);
          parambu = paramString1;
          if (paramString1 != null) {
            break label668;
          }
          parambu = "";
          break label668;
          label1408:
          parambu = (e)parambu.business(e.class);
          if (parambu == null)
          {
            parambu = "";
          }
          else
          {
            paramString1 = parambu.hOG;
            parambu = paramString1;
            if (paramString1 == null) {
              parambu = "";
            }
          }
        }
        label1448:
        l2 = l3;
      }
      label1455:
      paramString3 = paramString1;
    }
  }
  
  private static void a(q.bw parambw, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352117);
    if (DoN == q.u.DwF)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(352117);
      return;
    }
    long l4 = System.currentTimeMillis();
    ei localei = new ei();
    localei.iuJ = localei.F("LiveID", com.tencent.mm.plugin.expt.hellhound.core.b.hF(liveId), true);
    localei.iuI = localei.F("FeedID", com.tencent.mm.plugin.expt.hellhound.core.b.hF(feedId), true);
    localei.irj = localei.F("UserName", zDJ, true);
    localei.iwN = localei.F("Topic", URLEncoder.encode(Dok, "UTF-8"), true);
    Object localObject = (CharSequence)paramString2;
    int i;
    label167:
    long l1;
    label198:
    label220:
    label242:
    long l2;
    long l3;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label1570;
      }
      paramString2 = bkq(DnT);
      if (paramString2 != null) {
        break label1542;
      }
      paramString2 = "";
      localei.oK(paramString2);
      localei.iwR = enterTime;
      l1 = enterTime - Doj;
      if (l1 <= 0L) {
        break label1621;
      }
      localei.iuE = l1;
      l1 = l4 - Doj;
      if (l1 <= 0L) {
        break label1627;
      }
      localei.iCV = l1;
      l1 = l4 - enterTime;
      if (l1 <= 0L) {
        break label1633;
      }
      localei.iCW = l1;
      l2 = DoJ;
      l3 = DoI;
      if (!DoK) {
        break label1645;
      }
      if (DoH <= 0L) {
        break label1912;
      }
      l1 = l4 - DoH;
      if (l1 <= 0L) {
        break label1639;
      }
      label288:
      l2 += l1;
      l1 = localei.iCW - l2;
    }
    for (;;)
    {
      localei.iwU = l2;
      localei.iwT = l1;
      localei.iwV = DoN.status;
      localei.iCX = Dop;
      localei.iCY = 0L;
      localei.iCZ = 0L;
      localei.ill = Doq;
      localei.iDa = 0L;
      localei.iDb = Dow.size();
      localei.iDc = Dox;
      localei.iDd = Dor;
      localei.iDe = Dos;
      localei.iDf = Dou;
      localei.iDg = Dov;
      localei.iDh = Doy;
      localei.iDi = Doz;
      localei.iDj = DoA;
      localei.iDk = DoB;
      localei.iDl = DoC;
      localei.iDm = DoD;
      if (DoF)
      {
        l1 = q.ci.DFD.state;
        label492:
        localei.iDo = l1;
        localei.iDn = parambw.type;
        paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
        parambw = paramString2;
        if (paramString2 == null) {
          parambw = "";
        }
        localei.ipT = localei.F("ContextId", parambw, true);
        paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
        parambw = paramString2;
        if (paramString2 == null) {
          parambw = "";
        }
        localei.ipU = localei.F("ClickTabContextId", parambw, true);
        parambw = Dol;
        paramString2 = (CharSequence)paramString1;
        if ((paramString2 != null) && (paramString2.length() != 0)) {
          break label1706;
        }
        i = 1;
        label591:
        if (i != 0) {
          break label1907;
        }
      }
      for (;;)
      {
        localei.iwO = localei.F("CommentScene", paramString1, true);
        localei.iqp = localei.F("SessionBuffer", E(feedId, paramString1), true);
        paramString1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
        parambw = paramString1;
        if (paramString1 == null) {
          parambw = "";
        }
        localei.iqO = localei.F("SessionID", parambw, true);
        localei.iwP = Dom;
        parambw = j.Dob;
        localei.iwY = q.aB(localei.iwO, ACR);
        localei.iDp = DoQ;
        localei.iDq = DoR;
        localei.iDr = DoS;
        localei.iDs = DoT;
        localei.iDt = DoE;
        parambw = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localei.ixa = localei.F("AdData", n.m(c.a.arQ(zDJ), ",", ";", false), true);
        localei.iDu = DoU;
        localei.iDv = DoX;
        localei.iDw = DoY;
        parambw = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localei.iDz = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn();
        localei.iDy = Dpe;
        if (Dpa.isEmpty())
        {
          localei.oJ("");
          label835:
          parambw = Dpf;
          if (parambw != null) {
            break label1883;
          }
          parambw = "";
        }
        for (;;)
        {
          localei.ixb = localei.F("Scenenote", parambw, true);
          localei.bMH();
          parambw = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.n(null);
          parambw = new StringBuilder();
          parambw.append("report21178, duration=").append(localei.iCW).append(", floatDuration=").append(localei.iwU).append(", fullDuration=").append(localei.iwT).append(", diffTime=").append(localei.iwT + localei.iwU - localei.iCW).append(", commentScene=").append(localei.iwO).append(", pressLikeCount=").append(localei.iCZ).append(", enterStatus=").append(localei.iwV).append(", acclaimCount=").append(localei.iDa).append(", clickLikeCount=").append(localei.iCY).append(", goodsClickCount=").append(localei.iDb).append(", floatingCount=").append(localei.iDd).append(", shareMoments=");
          parambw.append(localei.iDe).append(", singleChat=").append(localei.iDf).append(", groupChat=").append(localei.iDg).append(", profileCount=").append(localei.iDh).append(", complainAnchor=").append(localei.iDi).append(", complainAudience=").append(localei.iDj).append(", forbidden=").append(localei.iDk).append(", enterFollow=").append(localei.iDl).append(", exitFollow=").append(localei.iDm).append(", exitType=").append(localei.iDn).append(", contextId=").append(localei.ipT).append(", clickTabContextId=").append(localei.ipU);
          parambw.append(", sessionBuffer=").append(localei.iqp).append(", sessionID=").append(localei.iqO).append(", isPrivate=").append(localei.iwP).append(", shopExp=").append(localei.iDo).append(", enterIconType=").append(localei.iwY).append(", clickToLandscape=").append(localei.iDp).append(", clickToPortrait=").append(localei.iDr).append(", rotateToLandscape=").append(localei.iDq).append(", rotateToPortrait=").append(localei.iDs).append(", lotteryCount=").append(localei.iDu).append(", adData=").append(localei.ixa).append(", commentsCount=");
          parambw.append(localei.iCX).append(", replycount=").append(localei.iDt).append(", tryToConnectCount=").append(localei.iDv).append(", connectSuccessCount=").append(localei.iDw).append(", connectDuration=").append(localei.iDx).append(", giftCount=").append(localei.iDy).append(", scenenote=").append(localei.ixb).append("shareToStatus=").append(localei.iDz).append("chnl_extra=").append(localei.ixf).append("emojiCount=").append(localei.ill);
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", parambw.toString());
          AppMethodBeat.o(352117);
          return;
          i = 0;
          break;
          label1542:
          localObject = n.m(paramString2, ",", ";", false);
          paramString2 = (String)localObject;
          if (localObject != null) {
            break label167;
          }
          paramString2 = "";
          break label167;
          label1570:
          paramString2 = bkq(paramString2);
          if (paramString2 == null) {
            paramString2 = "";
          }
          for (;;)
          {
            localei.oK(paramString2);
            break;
            localObject = n.m(paramString2, ",", ";", false);
            paramString2 = (String)localObject;
            if (localObject == null) {
              paramString2 = "";
            }
          }
          label1621:
          l1 = 0L;
          break label198;
          label1627:
          l1 = 0L;
          break label220;
          label1633:
          l1 = 0L;
          break label242;
          label1639:
          l1 = 0L;
          break label288;
          label1645:
          if (DoG <= 0L) {
            break label1912;
          }
          l1 = l4 - DoG;
          if (l1 > 0L) {}
          for (;;)
          {
            l1 += l3;
            l2 = localei.iCW - l1;
            break;
            l1 = 0L;
          }
          l1 = q.ci.DFC.state;
          break label492;
          label1706:
          i = 0;
          break label591;
          paramString1 = Dpa.iterator();
          parambw = "";
          while (paramString1.hasNext())
          {
            paramString2 = (com.tencent.mm.vending.j.d)paramString1.next();
            localObject = paramString2.get(2);
            s.s(localObject, "tuple.`$3`()");
            if (((Boolean)localObject).booleanValue()) {
              parambw = parambw + ((q.ar)paramString2.get(0)).type + '|' + paramString2.get(1) + ';';
            }
          }
          paramString1 = parambw;
          if (!s.p(parambw, ""))
          {
            i = parambw.length();
            if (parambw == null)
            {
              parambw = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(352117);
              throw parambw;
            }
            paramString1 = parambw.substring(0, i - 1);
            s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
          localei.oJ(paramString1);
          break label835;
          label1883:
          paramString1 = n.bV(parambw, ",", ";");
          parambw = paramString1;
          if (paramString1 == null) {
            parambw = "";
          }
        }
        label1907:
        paramString1 = parambw;
      }
      label1912:
      l1 = l3;
    }
  }
  
  public static void a(q.u paramu)
  {
    AppMethodBeat.i(351905);
    s.u(paramu, "<set-?>");
    DoN = paramu;
    AppMethodBeat.o(351905);
  }
  
  public static void a(q.y paramy, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(352017);
    s.u(paramy, "action");
    com.tencent.mm.autogen.mmdata.rpt.cn localcn = new com.tencent.mm.autogen.mmdata.rpt.cn();
    String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcn.iny = localcn.F("contextid", str1, true);
    localcn.ila = paramy.action;
    if (paramLong1 == -1L)
    {
      paramy = String.valueOf(paramLong1);
      localcn.ixk = localcn.F("liveid", paramy, true);
      if (paramLong2 != -1L) {
        break label268;
      }
    }
    label268:
    for (paramy = String.valueOf(paramLong2);; paramy = com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramLong2))
    {
      localcn.ipW = localcn.F("feedid", paramy, true);
      localcn.iqx = localcn.F("index", String.valueOf(paramInt), true);
      localcn.ixl = System.currentTimeMillis();
      localcn.bMH();
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report23432, action=" + localcn.ila + ", liveid=" + localcn.ixk + ", feedid=" + localcn.ipW + ", index=" + localcn.iqx + ", actionts_new=" + localcn.ixl + ", contextid=" + localcn.iny);
      AppMethodBeat.o(352017);
      return;
      paramy = com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramLong1);
      break;
    }
  }
  
  public static void axr(String paramString)
  {
    AppMethodBeat.i(351894);
    s.u(paramString, "value");
    String str = paramString;
    if (n.a((CharSequence)paramString, (CharSequence)",", false)) {
      str = n.m(paramString, ",", ";", false);
    }
    DnT = str;
    AppMethodBeat.o(351894);
  }
  
  public static void axs(String paramString)
  {
    AppMethodBeat.i(351932);
    s.u(paramString, "<set-?>");
    Dpf = paramString;
    AppMethodBeat.o(351932);
  }
  
  private static String bkq(String paramString)
  {
    AppMethodBeat.i(371515);
    try
    {
      localObject1 = (CharSequence)paramString;
      if (localObject1 == null) {
        break label134;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label92;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        label39:
        label92:
        label109:
        Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("appendTigerFlag err:", localObject2.getMessage()));
        continue;
        int i = 1;
      }
    }
    if (i != 0)
    {
      localObject1 = new com.tencent.mm.ad.i();
      if (new com.tencent.mm.ad.i(DnT).getInt("is_temporary") != 1) {
        break label109;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.ad.i)localObject1).n("is_temporary", Integer.valueOf(1));
      }
      localObject1 = ((com.tencent.mm.ad.i)localObject1).toString();
      paramString = (String)localObject1;
      AppMethodBeat.o(371515);
      return paramString;
      i = 0;
      break;
      localObject1 = new com.tencent.mm.ad.i(paramString);
      break label39;
    }
  }
  
  public static Map<String, String> cd(Bundle paramBundle)
  {
    AppMethodBeat.i(371523);
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (paramBundle == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        try
        {
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            Map localMap = (Map)localHashMap;
            s.s(str, "key");
            localMap.put(str, String.valueOf(paramBundle.get(str)));
          }
          paramBundle = (Map)localHashMap;
        }
        catch (Exception paramBundle)
        {
          Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("buildActionResult err:", paramBundle.getMessage()));
        }
      }
      AppMethodBeat.o(371523);
      return paramBundle;
      localObject = paramBundle.keySet();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((Set)localObject).iterator();
      }
    }
  }
  
  public static String eto()
  {
    return Dol;
  }
  
  public static long etq()
  {
    return enterTime;
  }
  
  public static void etr()
  {
    DoF = true;
  }
  
  public static String ets()
  {
    return DnT;
  }
  
  public static boolean ett()
  {
    return DoV;
  }
  
  public static String etu()
  {
    return Dpf;
  }
  
  public static String getSessionBuffer()
  {
    return sessionBuffer;
  }
  
  public static ej or(long paramLong)
  {
    AppMethodBeat.i(352159);
    ej localej2 = (ej)Dpp.get(Long.valueOf(paramLong));
    ej localej1 = localej2;
    if (localej2 == null)
    {
      localej1 = new ej();
      localej1.iDB = paramLong;
      ((Map)Dpp).put(Long.valueOf(paramLong), localej1);
    }
    AppMethodBeat.o(352159);
    return localej1;
  }
  
  public static void os(long paramLong)
  {
    AppMethodBeat.i(352165);
    Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("#markPlayerConnect ", Long.valueOf(paramLong)));
    ej localej = or(paramLong);
    localej.iDB = paramLong;
    if (localej.iDE == 0L) {
      localej.iDE = com.tencent.mm.model.cn.bDv();
    }
    AppMethodBeat.o(352165);
  }
  
  public static void ot(long paramLong)
  {
    AppMethodBeat.i(352171);
    Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("#markHasMicInfo ", Long.valueOf(paramLong)));
    ej localej = or(paramLong);
    localej.iDB = paramLong;
    localej.iDI = 1;
    AppMethodBeat.o(352171);
  }
  
  public static void ou(long paramLong)
  {
    AppMethodBeat.i(352176);
    Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("#markMicLaunched ", Long.valueOf(paramLong)));
    ej localej = or(paramLong);
    localej.iDB = paramLong;
    localej.iDJ = com.tencent.mm.model.cn.bDv();
    AppMethodBeat.o(352176);
  }
  
  public static void rO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(371524);
    s.u(paramString1, "newChnlExtra");
    s.u(paramString2, "clickSubTabContextId");
    axr(paramString1);
    DnS = paramString2;
    AppMethodBeat.o(371524);
  }
  
  public static void rQ(boolean paramBoolean)
  {
    Dpb = paramBoolean;
  }
  
  public final void B(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(352604);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("method", paramInt);
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
    }
    localJSONObject.put("user_list", localJSONArray);
    a(q.bu.DDn, localJSONObject.toString(), 0L, null, null, null, 60);
    AppMethodBeat.o(352604);
  }
  
  public final void N(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(352256);
    Dph = true;
    if (!paramBoolean)
    {
      Dpg = true;
      switch (paramInt)
      {
      default: 
        Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("reportSwitchScreen err:screenAction=", Integer.valueOf(paramInt)));
        AppMethodBeat.o(352256);
        return;
      }
    }
    for (i = 2;; i = paramInt)
    {
      q.bl localbl;
      switch (i)
      {
      default: 
        Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportSwitchScreen err:isAuto=" + paramBoolean + ",screenAction=" + paramInt);
        AppMethodBeat.o(352256);
        return;
      case 1: 
        if (paramBoolean)
        {
          if (Dpg)
          {
            Dpg = false;
            AppMethodBeat.o(352256);
            return;
          }
          DoT += 1L;
          localbl = q.bl.DBt;
          if ((localbl != q.bl.DBt) && (localbl != q.bl.DBs)) {
            break label299;
          }
        }
        break;
      }
      for (DoP = q.bo.DBM;; DoP = q.bo.DBL) {
        label299:
        do
        {
          a(q.bu.DCw, String.valueOf(localbl.action), 0L, null, null, null, 60);
          if (DoP != q.bo.DBL) {
            break label324;
          }
          DoP = q.bo.DBM;
          AppMethodBeat.o(352256);
          return;
          DoS += 1L;
          localbl = q.bl.DBs;
          break;
          if (paramBoolean)
          {
            if (Dpg)
            {
              Dpg = false;
              AppMethodBeat.o(352256);
              return;
            }
            DoR += 1L;
            localbl = q.bl.DBr;
            break;
          }
          DoQ += 1L;
          localbl = q.bl.DBq;
          break;
        } while ((localbl != q.bl.DBr) && (localbl != q.bl.DBr));
      }
      label324:
      if (DoP == q.bo.DBM) {
        DoP = q.bo.DBL;
      }
      AppMethodBeat.o(352256);
      return;
    }
  }
  
  public final void Pl(int paramInt)
  {
    AppMethodBeat.i(352402);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("button_type", paramInt);
      a(q.bu.DCY, localJSONObject.toString(), 0L, null, null, null, 60);
      return;
    }
    finally
    {
      AppMethodBeat.o(352402);
    }
  }
  
  public final void Pm(int paramInt)
  {
    AppMethodBeat.i(352528);
    a(q.bu.DCH, String.valueOf(paramInt), 0L, null, null, null, 60);
    AppMethodBeat.o(352528);
  }
  
  public final void Pn(int paramInt)
  {
    AppMethodBeat.i(352609);
    a(q.bu.DCM, String.valueOf(paramInt), 0L, null, null, null, 60);
    AppMethodBeat.o(352609);
  }
  
  public final void Z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(371535);
    s.u(paramString1, "userId");
    s.u(paramString2, "boxId");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("user_id", paramString1);
    localJSONObject.put("is_group_box", paramInt);
    localJSONObject.put("group_box_number", paramString2);
    a(q.bu.DDo, localJSONObject.toString(), 0L, null, null, null, 60);
    AppMethodBeat.o(371535);
  }
  
  public final void a(Context paramContext, q.bw parambw, Bundle paramBundle)
  {
    AppMethodBeat.i(371527);
    s.u(parambw, "type");
    if (!DoW)
    {
      AppMethodBeat.o(371527);
      return;
    }
    Object localObject1;
    if ((paramContext instanceof AppCompatActivity))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      paramContext = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramContext).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
      s.s(paramContext, "UICProvider.of(context).…veSideBarUIC::class.java)");
      paramContext = (com.tencent.mm.plugin.finder.live.sidebar.d)paramContext;
      if (paramContext.DGD)
      {
        paramContext = paramContext.DGH.etG();
        boolean bool = ((Boolean)paramContext.bsC).booleanValue();
        paramContext = (String)paramContext.bsD;
        if (bool) {
          localObject1 = q.n.DtN.scene;
        }
      }
    }
    for (;;)
    {
      int i;
      Object localObject2;
      if ((Util.isEqual(Dol, "135")) && (paramBundle != null))
      {
        paramBundle = cd(paramBundle);
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label550;
        }
        i = 1;
        if (i == 0) {
          try
          {
            localObject2 = new JSONObject();
            Iterator localIterator = ((Iterable)paramBundle.keySet()).iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ((JSONObject)localObject2).putOpt(str, (String)paramBundle.get(str));
            }
            paramBundle = paramContext;
          }
          finally
          {
            Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("err:", paramBundle.getMessage()));
          }
        }
      }
      label242:
      paramContext = com.tencent.mm.plugin.finder.api.d.AwY;
      if (com.tencent.mm.plugin.finder.api.d.a.a(zDJ, null, false, false, 14))
      {
        i = q.ab.DxK.state;
        label268:
        DoD = i;
        DoW = false;
        switch (a.avl[parambw.ordinal()])
        {
        default: 
          if (Dpc)
          {
            Dpb = false;
            paramContext = Dpd;
          }
          switch (a.avM[paramContext.ordinal()])
          {
          default: 
            paramContext = q.cd.DEI;
            label364:
            a(this, paramContext, null, 6);
            label372:
            paramContext = new JSONObject();
            localObject2 = aj.CGT;
            localObject2 = aj.elL();
            if (localObject2 == null) {
              i = 0;
            }
            break;
          }
          break;
        }
      }
      for (;;)
      {
        paramContext.put("birate", i);
        a(q.bu.DCt, String.valueOf(parambw.type), 0L, paramContext.toString(), null, null, 52);
        a(parambw, (String)localObject1, paramBundle);
        DoN = q.u.DwF;
        paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        if (c.a.arP(zDJ))
        {
          paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          c.a.dKP();
        }
        paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oU(false);
        paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        c.a.arG("");
        Dpc = false;
        Dpd = q.ar.Dzk;
        Dpa.clear();
        DoZ = "";
        DoX = 0;
        DoY = 0;
        Dpe = 0;
        Dpl = false;
        Dpi = false;
        Dpo = false;
        paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arw(null);
        paramContext = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.LO(0);
        AppMethodBeat.o(371527);
        return;
        label550:
        i = 0;
        break;
        paramBundle = ((JSONObject)localObject2).toString();
        break label242;
        i = q.ab.DxJ.state;
        break label268;
        if (!Dpc) {
          break label372;
        }
        Dpb = true;
        paramContext = Dpd;
        switch (a.avM[paramContext.ordinal()])
        {
        default: 
          paramContext = q.cd.DEI;
        }
        for (;;)
        {
          a(this, paramContext, null, 6);
          break;
          paramContext = q.cd.DEQ;
          continue;
          paramContext = q.cd.DEP;
        }
        paramContext = q.cd.DEQ;
        break label364;
        paramContext = q.cd.DEP;
        break label364;
        localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
        if (localObject2 == null)
        {
          i = 0;
        }
        else
        {
          localObject2 = ((com.tencent.mm.live.core.core.d)localObject2).mJH;
          if (localObject2 == null) {
            i = 0;
          } else {
            i = ((g)localObject2).bem();
          }
        }
      }
      localObject1 = "";
      continue;
      paramContext = "";
      localObject1 = "";
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt, String paramString1, String paramString2, q.bu parambu, Map<String, String> paramMap)
  {
    AppMethodBeat.i(352277);
    s.u(parama, "liveData");
    s.u(parambu, "action");
    s.u(paramMap, "actionResult");
    long l = System.currentTimeMillis();
    Doj = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.startTime * 1000L;
    liveId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    zDJ = ((e)parama.business(e.class)).mIC;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    c.a.arG(zDJ);
    localObject1 = ((l)parama.business(l.class)).EgE;
    s.s(localObject1, "liveData.business(LiveMs…lice::class.java).msgList");
    localObject1 = (com.tencent.mm.plugin.finder.live.model.aq)kotlin.a.p.oL((List)localObject1);
    Object localObject2;
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = "";
      Dok = (String)localObject1;
      feedId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.dIJ();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Dol = (String)localObject1;
      localObject1 = j.Dob;
      ACR = j.Doc.Dqh.type;
      localObject1 = j.Dob;
      Dom = q.axD(zDJ);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportJoinLive: commentScene=" + Dol + ", isPrivate=" + Dom);
      bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).EhZ;
      boolean bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ;
      if ((!bool1) || (!bool2)) {
        break label827;
      }
      localObject1 = q.bq.DBU;
      label305:
      Doo = (q.bq)localObject1;
      liveStatus = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveStatus;
      enterTime = l;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer;
      if (localObject1 != null) {
        break label848;
      }
      localObject1 = "";
      label359:
      sessionBuffer = (String)localObject1;
      Dop = 0;
      Doq = 0;
      Dor = 0;
      Dos = 0;
      Dou = 0;
      Dov = 0;
      Dow.clear();
      Dox = 0;
      Doy = 0;
      Doz = 0;
      DoA = 0;
      DoB = 0;
      DoE = 0;
      Pk(paramInt);
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      if (!com.tencent.mm.plugin.finder.api.d.a.a(zDJ, null, false, false, 14)) {
        break label878;
      }
      paramInt = q.ab.DxK.state;
      label448:
      DoC = paramInt;
      DoD = paramInt;
      DoF = false;
      DoG = l;
      DoH = 0L;
      DoI = 0L;
      DoJ = 0L;
      DoK = false;
      DoL = false;
      DoM = "";
      DoN = q.u.DwE;
      DoO = false;
      DoQ = 0L;
      DoR = 0L;
      DoS = 0L;
      DoT = 0L;
      DoU = 0;
      Dpj = false;
      Dpk = "";
      DoV = false;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oU(true);
      DoW = true;
      Dpb = false;
      Dpc = false;
      Dpd = q.ar.Dzk;
      DoX = 0;
      DoY = 0;
      DoZ = "";
      Dpa.clear();
      Dpl = false;
      Dpi = false;
      Dpo = false;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arw(null);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.LO(0);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "HABBYGE-MALI, reportJoinLive, liveId=" + liveId + ", feedId=" + feedId);
      localObject1 = new JSONObject();
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
      if (parama != null) {
        break label888;
      }
      paramInt = 0;
      label678:
      ((JSONObject)localObject1).put("birate", paramInt);
      if (!paramMap.isEmpty()) {
        break label910;
      }
      paramInt = 1;
      label700:
      if (paramInt == 0) {
        try
        {
          parama = new JSONObject();
          localObject2 = ((Iterable)paramMap.keySet()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            parama.put(str, (String)paramMap.get(str));
            continue;
            parama = "";
          }
        }
        finally {}
      }
    }
    for (;;)
    {
      a(parambu, parama, 0L, ((JSONObject)localObject1).toString(), paramString1, paramString2, 4);
      AppMethodBeat.o(352277);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.live.model.aq)localObject1).getContent();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label827:
      if (bool1)
      {
        localObject1 = q.bq.DBT;
        break label305;
      }
      localObject1 = q.bq.DBS;
      break label305;
      label848:
      localObject2 = n.bV((String)localObject1, ",", ";");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label359;
      }
      localObject1 = "";
      break label359;
      label878:
      paramInt = q.ab.DxJ.state;
      break label448;
      label888:
      parama = parama.mJH;
      if (parama == null)
      {
        paramInt = 0;
        break label678;
      }
      paramInt = parama.bem();
      break label678;
      label910:
      paramInt = 0;
      break label700;
      parama = parama.toString();
      s.s(parama, "json2.toString()");
    }
  }
  
  public final void a(q.aa paramaa, boolean paramBoolean)
  {
    AppMethodBeat.i(352463);
    s.u(paramaa, "action");
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localJSONObject.put("focus_types", i);
      a(q.bu.DCC, String.valueOf(paramaa.action), 0L, localJSONObject.toString(), null, null, 52);
      AppMethodBeat.o(352463);
      return;
    }
  }
  
  public final void a(q.ad paramad, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(352564);
    s.u(paramad, "type");
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("type=").append(paramad.type).append(";extra_info=");
        if (paramb != null) {
          continue;
        }
        paramb = "";
        paramb = paramb;
        paramad = paramb;
      }
      catch (Exception paramb)
      {
        String str;
        paramad = s.X("type=", Integer.valueOf(paramad.type));
        continue;
      }
      a(q.bu.DCU, paramad, 0L, null, null, null, 60);
      AppMethodBeat.o(352564);
      return;
      str = paramb.ZV();
      paramb = str;
      if (str == null) {
        paramb = "";
      }
    }
  }
  
  public final void a(q.af paramaf, String paramString)
  {
    AppMethodBeat.i(352474);
    s.u(paramaf, "type");
    s.u(paramString, "giftId");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramaf.action);
    localJSONObject.put("giftid", paramString);
    a(q.bu.DCS, String.valueOf(localJSONObject), 0L, null, null, null, 60);
    AppMethodBeat.o(352474);
  }
  
  public final void a(q.be parambe, int paramInt)
  {
    AppMethodBeat.i(352446);
    s.u(parambe, "result");
    if (parambe == q.be.DAH)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.oQ(true);
    }
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("style", paramInt);
    a(q.bu.DCB, String.valueOf(parambe.result), 0L, ((JSONObject)localObject).toString(), null, null, 52);
    AppMethodBeat.o(352446);
  }
  
  public final void a(q.bg parambg)
  {
    AppMethodBeat.i(352497);
    s.u(parambg, "result");
    int i = parambg.type;
    a(q.bu.DCK, String.valueOf(i), 0L, null, null, null, 60);
    AppMethodBeat.o(352497);
  }
  
  public final void a(q.bi parambi, q.bh parambh)
  {
    AppMethodBeat.i(352520);
    Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", "doReportRedPacket, type=" + parambi.type + ", src" + parambh.src);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", parambi.type);
    localJSONObject.put("source", parambh.src);
    a(q.bu.DCE, localJSONObject.toString(), 0L, null, null, null, 60);
    AppMethodBeat.o(352520);
  }
  
  public final void a(q.bi parambi, q.bh parambh, boolean paramBoolean)
  {
    AppMethodBeat.i(352456);
    s.u(parambi, "type");
    s.u(parambh, "src");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(352456);
      return;
    }
    Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", "reportRedPacket, type=" + parambi.type + ", src" + parambh.src + ", inLive=" + paramBoolean);
    switch (a.bPr[parambi.ordinal()])
    {
    default: 
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", parambi.type);
      if (parambh != q.bh.DAQ) {
        break;
      }
    }
    for (parambi = String.valueOf(Dpm.src);; parambi = String.valueOf(parambh.src))
    {
      ((JSONObject)localObject).put("source", parambi);
      a(q.bu.DCE, ((JSONObject)localObject).toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352456);
      return;
      Dpn = paramBoolean;
      if (paramBoolean) {
        break;
      }
      AppMethodBeat.o(352456);
      return;
      if (Dpn) {
        break;
      }
      AppMethodBeat.o(352456);
      return;
      Dpm = parambh;
    }
  }
  
  public final void a(q.bv parambv)
  {
    AppMethodBeat.i(352381);
    s.u(parambv, "action");
    a(q.bu.DCu, String.valueOf(parambv.action), 0L, null, null, null, 60);
    AppMethodBeat.o(352381);
  }
  
  public final void a(q.bx parambx, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = null;
    AppMethodBeat.i(352369);
    s.u(parambx, "action");
    s.u(paramString3, "canvasid");
    s.u(paramString4, "aid");
    s.u(paramString5, "uxinfo");
    JSONObject localJSONObject = new JSONObject();
    switch (a.bOL[parambx.ordinal()])
    {
    default: 
      localJSONObject.put("commerceAction", parambx.action);
      if (!org.apache.commons.c.i.hm(paramString1)) {
        localJSONObject.put("session", paramString1);
      }
      if (!org.apache.commons.c.i.hm(paramString2)) {
        localJSONObject.put("productid", paramString2);
      }
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      localJSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKr());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      localJSONObject.put("appid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKs());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKt()))
      {
        paramString3 = Long.valueOf(liveId);
        label206:
        localJSONObject.put("liveid", paramString3);
        paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localJSONObject.put("shopwindowid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKu());
        paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        localJSONObject.put("sessionid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKv());
        paramString3 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramString3 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramString3 != null)
        {
          paramString3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramString3.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          if (paramString3 != null)
          {
            paramString3 = paramString3.Eim;
            if (paramString3 != null) {
              localJSONObject.put("couponid", paramString3);
            }
          }
        }
        paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        c.a.dKM();
        a(q.bu.DCs, localJSONObject.toString(), 0L, null, null, null, 60);
        paramString3 = new StringBuilder("reportCommerceAction, action=").append(parambx.name()).append(", shopSessionId=").append(paramString1).append(", productId=").append(paramString2).append(" couponId=");
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramString1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramString1 != null) {
          break label694;
        }
        paramString1 = localObject;
      }
      break;
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", paramString1);
      if (((parambx == q.bx.DDG) || (parambx == q.bx.DDJ) || (parambx == q.bx.DDK)) && (paramString2 != null) && (!Dow.contains(paramString2))) {
        Dow.add(paramString2);
      }
      if ((parambx == q.bx.DDJ) || (parambx == q.bx.DDI)) {
        DoL = true;
      }
      AppMethodBeat.o(352369);
      return;
      if (paramString2 == null) {}
      for (String str = ""; s.p(str, DoM); str = paramString2)
      {
        AppMethodBeat.o(352369);
        return;
      }
      if (paramString2 == null) {}
      for (str = "";; str = paramString2)
      {
        DoM = str;
        localJSONObject.put("type", parambx.action);
        localJSONObject.put("canvasid", paramString3);
        localJSONObject.put("aid", paramString4);
        localJSONObject.put("uxinfo", paramString5);
        break;
      }
      DoM = "";
      localJSONObject.put("type", parambx.action);
      localJSONObject.put("canvasid", paramString3);
      localJSONObject.put("aid", paramString4);
      localJSONObject.put("uxinfo", paramString5);
      break;
      localJSONObject.put("type", parambx.action);
      localJSONObject.put("canvasid", paramString3);
      localJSONObject.put("aid", paramString4);
      localJSONObject.put("uxinfo", paramString5);
      break;
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      paramString3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKt();
      break label206;
      label694:
      paramString4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramString1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      paramString1 = localObject;
      if (paramString4 != null) {
        paramString1 = paramString4.Eim;
      }
    }
  }
  
  public final void a(q.cb paramcb, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(352623);
    s.u(paramcb, "type");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramcb.type);
    if (paramBoolean1 != null)
    {
      if (paramBoolean1.booleanValue())
      {
        i = 0;
        localJSONObject.put("ispaid", i);
      }
    }
    else if (paramBoolean2 != null) {
      if (!paramBoolean2.booleanValue()) {
        break label119;
      }
    }
    label119:
    for (int i = j;; i = 0)
    {
      localJSONObject.put("isgift", i);
      a(q.bu.DCQ, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352623);
      return;
      i = 1;
      break;
    }
  }
  
  public final void a(q.cc paramcc, String paramString, int paramInt)
  {
    AppMethodBeat.i(352438);
    s.u(paramcc, "type");
    long l = System.currentTimeMillis();
    switch (a.bPq[paramcc.ordinal()])
    {
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramcc.type);
      localJSONObject.put("giftid", paramString);
      localJSONObject.put("num", paramInt);
      a(q.bu.DCz, localJSONObject.toString(), l, null, null, null, 56);
      AppMethodBeat.o(352438);
      return;
      if (paramInt == 0)
      {
        if (Dpl)
        {
          AppMethodBeat.o(352438);
          return;
        }
        Dpl = true;
      }
      else
      {
        AppMethodBeat.o(352438);
        return;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGw = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGx = l;
        Dpe += paramInt;
        continue;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGw = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGx = l;
      }
    }
  }
  
  public final void a(q.cd paramcd, q.ar paramar, int paramInt)
  {
    AppMethodBeat.i(352393);
    s.u(paramcd, "action");
    s.u(paramar, "linkeType");
    switch (a.bOM[paramcd.ordinal()])
    {
    }
    label432:
    do
    {
      for (;;)
      {
        a(q.bu.DCA, String.valueOf(paramcd.action), 0L, null, null, null, 60);
        AppMethodBeat.o(352393);
        return;
        if (paramInt == 0)
        {
          if (Dpi)
          {
            AppMethodBeat.o(352393);
            return;
          }
          Dpi = true;
        }
        else
        {
          AppMethodBeat.o(352393);
          return;
          AppMethodBeat.o(352393);
          return;
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLinkMic, action=" + paramcd.name() + ", gLinkMicTimeList=" + Dpa.size() + ", activeCloselinkMic=" + Dpb);
          Dpc = false;
          paramInt = Dpa.size() - 1;
          if (paramInt >= 0) {}
          for (;;)
          {
            int i = paramInt - 1;
            paramar = Dpa.get(paramInt);
            s.s(paramar, "gLinkMicTimeList[i]");
            com.tencent.mm.vending.j.d locald = (com.tencent.mm.vending.j.d)paramar;
            Object localObject = locald.get(0);
            switch (a.bOM[paramcd.ordinal()])
            {
            default: 
              paramar = q.ar.Dzi;
              if (localObject == paramar)
              {
                paramar = locald.get(1);
                s.s(paramar, "tuple.`$2`()");
                if ((((Number)paramar).longValue() > 0L) && (s.p(locald.get(2), Boolean.FALSE)))
                {
                  long l = System.currentTimeMillis();
                  paramar = locald.get(1);
                  s.s(paramar, "tuple.`$2`()");
                  l = (l - ((Number)paramar).longValue()) / 1000L;
                  if (l >= 0L) {
                    Dpa.set(paramInt, com.tencent.mm.vending.j.a.g(locald.get(0), Long.valueOf(l), Boolean.TRUE));
                  }
                }
              }
              break;
            }
            while (i < 0)
            {
              if (Dpb) {
                break label432;
              }
              AppMethodBeat.o(352393);
              return;
              paramar = q.ar.Dzj;
              break;
              paramar = q.ar.Dzk;
              break;
            }
            paramInt = i;
          }
          Dpb = false;
          continue;
          DoX += 1;
          continue;
          Dpc = true;
          DoY += 1;
          if (paramar != q.ar.Dzi) {
            Dpd = paramar;
          }
          Dpa.add(com.tencent.mm.vending.j.a.g(Dpd, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        }
      }
    } while (!Dpc);
    AppMethodBeat.o(352393);
  }
  
  public final void a(q.cf paramcf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352430);
    s.u(paramcf, "type");
    s.u(paramString2, "comment");
    switch (a.bPp[paramcf.ordinal()])
    {
    default: 
      Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("reportLettery ERROR: ", paramcf.name()));
    }
    for (;;)
    {
      paramString2 = new JSONObject();
      paramString2.put("type", paramcf.type);
      paramcf = paramString1;
      if (paramString1 == null) {
        paramcf = "";
      }
      paramString2.put("result", paramcf);
      a(q.bu.DCy, paramString2.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352430);
      return;
      Dpj = false;
      Dpk = "";
      continue;
      Dpj = true;
      Dpk = paramString2;
      continue;
      if ((Dpj) && (!TextUtils.isEmpty((CharSequence)Dpk)))
      {
        paramString1 = Dpk;
      }
      else
      {
        AppMethodBeat.o(352430);
        return;
        DoU += 1;
        continue;
        DoV = true;
      }
    }
  }
  
  public final void a(q.cg paramcg, String paramString1, long paramLong, String paramString2, String paramString3, Long paramLong1, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(352594);
    s.u(paramcg, "action");
    if (q.cg.DFv == paramcg) {
      com.tencent.mm.plugin.expt.hellhound.a.oJ(true);
    }
    en localen = new en();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localen.oY(str);
    str = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localen.izJ = localen.F("FinderSessionId", paramString1, true);
    localen.eO(System.currentTimeMillis());
    localen.ioV = paramcg.action;
    localen.iEm = localen.F("EnterLiveId", com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramLong), true);
    localen.iwV = 0L;
    paramcg = paramString2;
    if (paramString2 == null) {
      paramcg = "";
    }
    localen.oZ(paramcg);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    paramcg = paramString1;
    if (paramString1 == null) {
      paramcg = "";
    }
    localen.pa(paramcg);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
    paramcg = paramString1;
    if (paramString1 == null) {
      paramcg = "";
    }
    localen.ipU = localen.F("ClickTabContextId", paramcg, true);
    paramcg = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    localen.ixa = localen.F("AdData", n.m(c.a.arQ(localen.iEl), ",", ";", false), true);
    paramcg = Dpf;
    int i;
    if (paramcg == null)
    {
      paramcg = "";
      localen.ixb = localen.F("Scenenote", paramcg, true);
      if (paramString3 != null)
      {
        if (((CharSequence)paramString3).length() <= 0) {
          break label728;
        }
        i = 1;
        label284:
        if (i != 0) {
          localen.iEn = localen.F("ForcePushId", paramString3, true);
        }
      }
      if (paramLong1 != null) {
        break label734;
      }
      paramLong = 0L;
      label312:
      localen.iEo = paramLong;
      paramcg = paramString5;
      if (paramString5 == null) {
        paramcg = "";
      }
      localen.pb(paramcg);
      paramcg = paramString4;
      if (paramString4 == null) {
        paramcg = "";
      }
      localen.iEq = localen.F("ReportContent", paramcg, true);
      if (paramString6 != null) {
        break label743;
      }
      paramcg = null;
      label371:
      localen.iCS = localen.F("Description", Base64.encodeToString(paramcg, 0), true);
      if (paramString7 != null) {
        break label762;
      }
      paramcg = "";
    }
    for (;;)
    {
      localen.iEs = localen.F("Scene", paramcg, true);
      localen.bMH();
      paramString2 = new StringBuilder();
      paramString2.append("report21158, finderUsrName=").append(localen.iEl).append(", finderSessionId=").append(localen.izJ).append(", actionTimeMs=").append(localen.izK).append(", actionType=").append(localen.ioV).append(", enterLiveId=").append(localen.iEm).append(", enterStatus=").append(localen.iwV).append(", commentscene=").append(localen.ixs).append(", contextid=").append(localen.iny).append(", adData=").append(localen.ixa).append(", scenenote=").append(localen.ixb).append(", clickTabContextId=").append(localen.ipU).append(", forcePushId=");
      paramString1 = localen.iEn;
      paramcg = paramString1;
      if (paramString1 == null) {
        paramcg = "";
      }
      paramString2.append(paramcg).append(",clickTabContextId=").append(localen.ipU).append(",notificationId=").append(localen.iEp).append(",reportContent=").append(localen.iEq).append(",noticetype=").append(localen.iEo).append(",description=").append(localen.iCS);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", paramString2.toString());
      AppMethodBeat.o(352594);
      return;
      paramString1 = n.m(paramcg, ",", ";", false);
      paramcg = paramString1;
      if (paramString1 != null) {
        break;
      }
      paramcg = "";
      break;
      label728:
      i = 0;
      break label284;
      label734:
      paramLong = paramLong1.longValue();
      break label312;
      label743:
      paramcg = paramString6.getBytes(kotlin.n.d.UTF_8);
      s.s(paramcg, "(this as java.lang.String).getBytes(charset)");
      break label371;
      label762:
      paramString1 = n.m(paramString7, ",", ";", false);
      paramcg = paramString1;
      if (paramString1 == null) {
        paramcg = "";
      }
    }
  }
  
  public final void a(q.k paramk)
  {
    AppMethodBeat.i(352490);
    s.u(paramk, "result");
    int i = paramk.type;
    a(q.bu.DCG, String.valueOf(i), 0L, null, null, null, 60);
    AppMethodBeat.o(352490);
  }
  
  public final void a(q.l paraml)
  {
    AppMethodBeat.i(352347);
    s.u(paraml, "action");
    a(q.bu.DCo, String.valueOf(paraml.action), 0L, null, null, null, 60);
    if (paraml != q.l.Dtg) {
      Dox += 1;
    }
    AppMethodBeat.o(352347);
  }
  
  public final void a(Integer paramInteger, int paramInt, q.bn parambn)
  {
    int i = 1;
    AppMethodBeat.i(352214);
    s.u(parambn, "event");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(352214);
      return;
    }
    Pk(paramInt);
    if (Dph)
    {
      Dph = false;
      AppMethodBeat.o(352214);
      return;
    }
    if (paramInteger == null)
    {
      AppMethodBeat.o(352214);
      return;
    }
    if (paramInteger.intValue() == 0)
    {
      paramInt = i;
      switch (a.$EnumSwitchMapping$0[parambn.ordinal()])
      {
      default: 
        paramInteger = new kotlin.p();
        AppMethodBeat.o(352214);
        throw paramInteger;
      case 3: 
        paramInt = 0;
      }
      if (paramInt != 0) {
        a(q.bu.DCv, "", 0L, null, null, null, 60);
      }
    }
    AppMethodBeat.o(352214);
  }
  
  public final void a(String paramString, q.ch paramch, Map<String, String> paramMap)
  {
    AppMethodBeat.i(352331);
    s.u(paramch, "type");
    s.u(paramMap, "actionResult");
    JSONObject localJSONObject = new JSONObject();
    if (!org.apache.commons.c.i.hm(paramString)) {
      localJSONObject.put("username", paramString);
    }
    localJSONObject.put("type", paramch.type);
    try
    {
      Iterator localIterator = ((Iterable)paramMap.keySet()).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, (String)paramMap.get(str));
      }
      int i;
      return;
    }
    finally
    {
      if (paramch == q.ch.DFA)
      {
        paramMap = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arw(null);
      }
      a(q.bu.DCn, localJSONObject.toString(), 0L, null, null, null, 60);
      if (paramch == q.ch.DFy)
      {
        if ((paramString != null) && (n.i((CharSequence)paramString, (CharSequence)"@chatroom") == true)) {}
        for (i = 1; i != 0; i = 0)
        {
          Dov += 1;
          AppMethodBeat.o(352331);
          return;
        }
        Dou += 1;
        AppMethodBeat.o(352331);
        return;
      }
      if (paramch == q.ch.DFz) {
        Dos += 1;
      }
      AppMethodBeat.o(352331);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, Integer paramInteger, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(371532);
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localJSONObject.put("content", URLEncoder.encode(str, "UTF-8"));
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localJSONObject.put("title", URLEncoder.encode(paramString1, "UTF-8"));
    if (paramString3 != null) {
      localJSONObject.put("grade", URLEncoder.encode(paramString3, "UTF-8"));
    }
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label216;
      }
      label100:
      localJSONObject.put("comment_type", URLEncoder.encode("0", "UTF-8"));
      label118:
      if (!paramBoolean) {
        break label248;
      }
      localJSONObject.put("is_group_box", "1");
    }
    for (;;)
    {
      localJSONObject.put("group_box_number", paramString4);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", s.X("reportSendMsg: ", localJSONObject));
      a(q.bu.DCi, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(371532);
      return;
      if (paramInteger.intValue() != 20035) {
        break;
      }
      localJSONObject.put("comment_type", URLEncoder.encode("2", "UTF-8"));
      break label118;
      label216:
      if (paramInteger.intValue() != 1000066) {
        break label100;
      }
      localJSONObject.put("comment_type", URLEncoder.encode("1", "UTF-8"));
      break label118;
      label248:
      localJSONObject.put("is_group_box", "0");
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(352508);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event_type", paramInt1);
    localJSONObject.put("windows_type", paramInt2);
    localJSONObject.put("liveid_type", paramInt3);
    switch (paramInt1)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder("reportFloatMode 21084, action:");
      if (paramBoolean)
      {
        localbu = q.bu.DDe;
        label93:
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", localbu + ", chnlExtra:" + localJSONObject);
        if (!paramBoolean) {
          break label173;
        }
      }
      break;
    }
    label173:
    for (q.bu localbu = q.bu.DDe;; localbu = q.bu.DDd)
    {
      a(localbu, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352508);
      return;
      localJSONObject.put("stay_time", paramLong);
      break;
      localbu = q.bu.DDd;
      break label93;
    }
  }
  
  public final void a(boolean paramBoolean, q.z paramz)
  {
    AppMethodBeat.i(352317);
    s.u(paramz, "floatType");
    if (paramz == q.z.Dxx) {
      DoV = false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    long l3;
    q.z localz;
    if (paramBoolean)
    {
      if (DoK)
      {
        AppMethodBeat.o(352317);
        return;
      }
      if (DoG > 0L)
      {
        l1 = l2 - DoG;
        l3 = DoI;
        if (l1 > 0L)
        {
          DoI = l1 + l3;
          DoG = 0L;
        }
      }
      else
      {
        DoH = l2;
        DoK = true;
        Dor += 1;
        if (paramz != q.z.Dxw) {
          break label258;
        }
        if (!com.tencent.mm.plugin.expt.hellhound.a.zAJ) {
          break label232;
        }
        localz = q.z.DxB;
      }
    }
    label258:
    for (;;)
    {
      if (DoO)
      {
        localz = q.z.DxC;
        DoO = false;
      }
      a(q.bu.DCm, String.valueOf(localz.type), 0L, null, null, null, 60);
      AppMethodBeat.o(352317);
      return;
      l1 = 0L;
      break;
      if (!DoK)
      {
        AppMethodBeat.o(352317);
        return;
      }
      if (DoH > 0L)
      {
        l1 = l2 - DoH;
        l3 = DoJ;
        if (l1 <= 0L) {
          break label227;
        }
      }
      for (;;)
      {
        DoJ = l1 + l3;
        DoH = 0L;
        DoG = l2;
        DoK = false;
        break;
        label227:
        l1 = 0L;
      }
      label232:
      if (DoL)
      {
        localz = q.z.DxA;
        DoL = false;
      }
      else
      {
        localz = q.z.Dxz;
        continue;
        localz = paramz;
        if (paramz == q.z.Dxx)
        {
          DoL = false;
          localz = paramz;
        }
      }
    }
  }
  
  public final void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(352419);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("model_type", paramInt1);
      localJSONObject.put("click_type", paramInt2);
      localJSONObject.put("card_index", paramInt3);
      a(q.bu.DCZ, localJSONObject.toString(), 0L, null, null, null, 60);
      return;
    }
    finally
    {
      AppMethodBeat.o(352419);
    }
  }
  
  public final void aa(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(371536);
    s.u(paramString1, "boxId");
    s.u(paramString2, "likeComment");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("is_group_box", 1);
    localJSONObject.put("group_box_number", paramString1);
    localJSONObject.put("like_comment", paramString2);
    a(q.bu.DCM, paramInt + ';' + localJSONObject, 0L, null, null, null, 60);
    AppMethodBeat.o(371536);
  }
  
  public final void ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(352571);
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean1)
    {
      i = 1;
      localJSONObject.put("event", i);
      if (!paramBoolean2) {
        break label80;
      }
    }
    label80:
    for (int i = j;; i = 2)
    {
      localJSONObject.put("event_res", i);
      a(q.bu.DCW, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352571);
      return;
      i = 2;
      break;
    }
  }
  
  public final void axt(String paramString)
  {
    AppMethodBeat.i(352202);
    s.u(paramString, "_scenenote");
    Dpf = paramString;
    AppMethodBeat.o(352202);
  }
  
  public final void axu(String paramString)
  {
    AppMethodBeat.i(352234);
    s.u(paramString, "actionResult");
    a(q.bu.DCF, paramString.toString(), 0L, null, null, null, 60);
    AppMethodBeat.o(352234);
  }
  
  public final void axv(String paramString)
  {
    AppMethodBeat.i(352240);
    s.u(paramString, "chnlExtra");
    a(q.bu.DCX, "", 0L, null, q.n.DtN.scene, paramString, 12);
    AppMethodBeat.o(352240);
  }
  
  public final void axw(String paramString)
  {
    AppMethodBeat.i(352482);
    s.u(paramString, "actionResult");
    a(q.bu.DDb, paramString, 0L, null, null, null, 60);
    AppMethodBeat.o(352482);
  }
  
  public final void axx(String paramString)
  {
    AppMethodBeat.i(352536);
    s.u(paramString, "actionResult");
    a(q.bu.DCR, paramString, 0L, null, null, null, 60);
    AppMethodBeat.o(352536);
  }
  
  public final void axy(String paramString)
  {
    AppMethodBeat.i(352581);
    paramString = new JSONObject(URLDecoder.decode(paramString, "utf-8"));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("actionType", 1);
    localJSONObject.put("WxaGameReportInfo", paramString);
    a(q.bu.DCL, URLEncoder.encode(localJSONObject.toString(), "utf-8"), 0L, null, null, null, 60);
    AppMethodBeat.o(352581);
  }
  
  public final void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(352374);
    q.bu localbu = q.bu.DCs;
    if (paramJSONObject1 == null)
    {
      paramJSONObject1 = null;
      if (paramJSONObject2 != null) {
        break label48;
      }
    }
    label48:
    for (paramJSONObject2 = null;; paramJSONObject2 = paramJSONObject2.toString())
    {
      a(localbu, paramJSONObject1, 0L, paramJSONObject2, null, null, 52);
      AppMethodBeat.o(352374);
      return;
      paramJSONObject1 = paramJSONObject1.toString();
      break;
    }
  }
  
  public final void bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(352410);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("button_type", paramInt);
      if (paramString != null) {
        localJSONObject.put("theme_content", paramString);
      }
      a(q.bu.DDa, localJSONObject.toString(), 0L, null, null, null, 60);
      return;
    }
    finally
    {
      AppMethodBeat.o(352410);
    }
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352225);
    q.bu localbu = q.bu.DCF;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt1);
    if (paramInt2 > 0) {
      localJSONObject.put("money", paramInt2);
    }
    if (paramString1 != null) {
      if (((CharSequence)paramString1).length() > 0)
      {
        paramInt1 = 1;
        if (paramInt1 != 1) {
          break label116;
        }
      }
    }
    label116:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        localJSONObject.put("errmsg", paramString1);
      }
      paramString1 = ah.aiuX;
      a(localbu, localJSONObject.toString(), 0L, null, null, paramString2, 28);
      AppMethodBeat.o(352225);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void cH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(371534);
    s.u(paramJSONObject, "json");
    paramJSONObject = paramJSONObject.toString();
    s.s(paramJSONObject, "json.toString()");
    paramJSONObject = n.m(paramJSONObject, ",", ";", false);
    a(q.bu.akfs, paramJSONObject, 0L, null, null, null, 60);
    AppMethodBeat.o(371534);
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(352546);
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localJSONObject.put("exposeClick", i);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      localJSONObject.put("bizuin", str);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localJSONObject.put("bizusername", paramString1);
      a(q.bu.DCJ, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352546);
      return;
    }
  }
  
  public final void hK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352617);
    Object localObject = new com.tencent.mm.ad.i();
    switch (paramInt2)
    {
    default: 
      paramInt2 = 0;
    }
    for (;;)
    {
      ((com.tencent.mm.ad.i)localObject).n("result", Integer.valueOf(paramInt1));
      ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(paramInt2));
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      s.s(localObject, "JSONObject().apply {\n   …ype)\n        }.toString()");
      a(q.bu.DCO, (String)localObject, 0L, null, null, null, 60);
      AppMethodBeat.o(352617);
      return;
      paramInt2 = q.aj.Dyo.value;
      continue;
      paramInt2 = q.aj.Dyp.value;
      continue;
      paramInt2 = q.aj.Dyq.value;
    }
  }
  
  public final void hL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352632);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("from_birate", paramInt1);
    localJSONObject.put("to_birate", paramInt2);
    a(q.bu.DCP, null, 0L, localJSONObject.toString(), null, null, 52);
    AppMethodBeat.o(352632);
  }
  
  public final void p(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(352341);
    s.u(paramString, "appid");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (paramInt1 == 6) {
        localJSONObject.put("error", paramInt2);
      }
      a(q.bu.DDf, localJSONObject.toString(), 0L, null, null, null, 60);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportGameRank 21084 type:" + paramInt1 + ", appid:" + paramString + ", error:" + paramInt2);
      AppMethodBeat.o(352341);
      return;
      localJSONObject.put("appid", paramString);
    }
  }
  
  public final void rR(boolean paramBoolean)
  {
    AppMethodBeat.i(352558);
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    for (String str = "mmbiz_profile";; str = "findervideo_profile")
    {
      localJSONObject.put("jump_type", str);
      a(q.bu.DCT, localJSONObject.toString(), 0L, null, null, null, 60);
      AppMethodBeat.o(352558);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.bb;
import com.tencent.mm.f.b.a.bp;
import com.tencent.mm.f.b.a.br;
import com.tencent.mm.f.b.a.bs;
import com.tencent.mm.f.b.a.df;
import com.tencent.mm.f.b.a.di;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveVisitorReoprter;", "", "()V", "TAG", "", "activeCloselinkMic", "", "getActiveCloselinkMic", "()Z", "setActiveCloselinkMic", "(Z)V", "autoFillComment", "value", "chnlExtra", "getChnlExtra", "()Ljava/lang/String;", "setChnlExtra", "(Ljava/lang/String;)V", "clearCount", "", "clickToLandscape", "", "clickToPortrait", "commentScene", "commentsCount", "complainAnchor", "complainVisitor", "emojiCount", "enterFollow", "enterProfileEventInLiveRoom", "enterTime", "getEnterTime", "()J", "setEnterTime", "(J)V", "enterType", "exitFollow", "feedId", "finderUserName", "forbidden", "gLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "Lkotlin/collections/ArrayList;", "giftCount", "giftIconReprtedYet", "goodsClickData", "groupChat", "inLiveRedPacket", "isBubbleShow", "isPrivate", "isShopExp", "setShopExp", "isWeAppOpen", "linkMicDuration", "linkMicSuccCount", "linkMicType", "linkMicing", "linkmicIconReprtedYet", "liveId", "liveRoomState", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "getLiveRoomState", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;", "setLiveRoomState", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$EnterRoomStatus;)V", "liveStartTime", "liveStatus", "liveTopic", "mClickJoinLottery", "mClickLotteryHistory", "getMClickLotteryHistory", "setMClickLotteryHistory", "mIsEnterLivingRoom", "mIsFloat", "mLastFloatTS", "mLastFullTS", "mLotterySuccCount", "mPageType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenDirection;", "mSwitchScreenByHand", "mSwithcScreenEvent", "mTotalFloatTime", "mTotalFullTime", "minizaionCount", "profileCount", "redPacketSrc", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketSrc;", "redPacketVisiable", "replyCommentCount", "rotateToLandscape", "rotateToPortrait", "scenenote", "getScenenote", "setScenenote", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "shareMoments", "shopPermit", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ShopPermitAction;", "singleChat", "tryToLinkMicCount", "doReportRedPacket", "", "type", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketType;", "src", "getLinkType", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLinkMicAction;", "getSessionBuf", "commencene", "getVisitorRoleType", "report21084", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAction;", "actionJson", "actionMs", "report21158", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "finderUsrName", "enterLiveId", "enterStatus", "commentscene", "forcePushId", "noticeType", "reportContent", "notificationId", "desc", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "report21178", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCloseType;", "report23083", "errorReason", "reportAnchorPauseLive", "actionResult", "reportCastScreen", "result", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CastScreenResult;", "reportClearScreen", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ClearScreenAction;", "reportClickLinkmicAvatar", "reportCommerceAction", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorCommerceAction;", "shopSessionId", "productId", "canvasid", "aid", "uxinfo", "reportComplaintAnchor", "reportComplaintVisitor", "username", "source", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ComplaintVisitorSource;", "reportCopyComment", "reportElementClick", "elementId", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementClickId;", "reportElementExpose", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "reportEnterProfile", "reportFloat", "isMini", "floatType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FloatActionType;", "reportFollowBtn", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FollowBtnAction;", "reportGameTeamAction", "reportGift", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorGift;", "giftid", "num", "reportJoinLive", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "screenStateOfConfig", "reportJumpToOfficialAccountMessage", "isClick", "bizuin", "bizusername", "reportLettery", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLotteryType;", "reportLike", "reportLinkMic", "linkeType", "linkmicIconState", "reportNearbyLiveToMore", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyMoreActionResult;", "reportOnScreenBtnExposure", "showState", "screenTypeOfConfig", "event", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;", "(Ljava/lang/Integer;ILcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ScreenBtnEvent;)V", "reportQuitLive", "reportRealAuth", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorAuthAction;", "reportRedPacket", "inLive", "visiable", "reportReplyComment", "replyContent", "reportSendMsg", "content", "title", "reportShare", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShareType;", "reportSlideRoom", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "reportSwitchScreen", "isAuto", "screenAction", "reportVisitorMusic", "setForbidden", "setRealScreenType", "plugin-finder_release"})
public final class m
{
  public static long enterTime;
  public static long feedId;
  public static long liveId;
  public static int liveStatus;
  public static String sessionBuffer;
  public static String whH;
  public static int xbJ;
  private static String yAV;
  public static ArrayList<String> yBA;
  public static int yBB;
  public static int yBC;
  public static int yBD;
  public static int yBE;
  public static int yBF;
  public static int yBG;
  public static int yBH;
  public static int yBI;
  public static boolean yBJ;
  public static long yBK;
  public static long yBL;
  public static long yBM;
  public static long yBN;
  public static boolean yBO;
  public static boolean yBP;
  public static boolean yBQ;
  public static s.r yBR;
  public static boolean yBS;
  private static s.az yBT;
  public static long yBU;
  public static long yBV;
  public static long yBW;
  public static long yBX;
  public static int yBY;
  public static boolean yBZ;
  public static long yBp;
  public static String yBq;
  public static String yBr;
  public static int yBs;
  public static s.bb yBt;
  public static int yBu;
  public static int yBv;
  public static int yBw;
  public static int yBx;
  public static int yBy;
  public static int yBz;
  public static boolean yCa;
  public static int yCb;
  public static int yCc;
  public static String yCd;
  public static final ArrayList<com.tencent.mm.vending.j.d<s.ag, Long, Boolean>> yCe;
  public static boolean yCf;
  public static boolean yCg;
  public static s.ag yCh;
  private static int yCi;
  private static String yCj;
  private static boolean yCk;
  private static boolean yCl;
  public static boolean yCm;
  public static boolean yCn;
  public static String yCo;
  public static boolean yCp;
  private static s.at yCq;
  private static boolean yCr;
  public static boolean yCs;
  public static final m yCt;
  
  static
  {
    AppMethodBeat.i(290924);
    yCt = new m();
    whH = "";
    yBq = "";
    yBr = "";
    yBt = s.bb.yKJ;
    sessionBuffer = "";
    yBA = new ArrayList();
    yAV = "";
    yBR = s.r.yGC;
    yBT = s.az.yKD;
    yCd = "";
    yCe = new ArrayList();
    yCh = s.ag.yIs;
    yCj = "";
    yCo = "";
    yCq = s.at.yJO;
    AppMethodBeat.o(290924);
  }
  
  public static void NF(int paramInt)
  {
    s.az localaz;
    switch (paramInt)
    {
    default: 
      localaz = s.az.yKC;
    }
    for (;;)
    {
      yBT = localaz;
      return;
      localaz = s.az.yKC;
      continue;
      localaz = s.az.yKD;
    }
  }
  
  private static void a(s.bf parambf, String paramString, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(290913);
    if (yBR == s.r.yGD)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(290913);
      return;
    }
    long l2 = paramLong;
    if (paramLong <= 0L) {
      l2 = System.currentTimeMillis();
    }
    bp localbp = new bp();
    localbp.kg(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(liveId));
    localbp.kh(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(feedId));
    localbp.ki(whH);
    localbp.kj(URLEncoder.encode(yBq, "UTF-8"));
    if (p.h(yBr, s.l.yFU.scene))
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
      if (p.h(b.a.deK(), "111")) {
        yBr = s.l.yFV.scene;
      }
    }
    localbp.kk(yBr);
    localbp.dP(yBs);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbp.kl((String)localObject);
    str = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbp.km((String)localObject);
    str = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbp.kn((String)localObject);
    localbp.kt(yAV);
    boolean bool1;
    label341:
    boolean bool2;
    label381:
    long l3;
    label396:
    label436:
    long l4;
    if (TextUtils.isEmpty((CharSequence)sessionBuffer))
    {
      localObject = kotlin.n.n.l(aCB(yBr), ",", ";", false);
      sessionBuffer = (String)localObject;
      localbp.ko((String)localObject);
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject == null) {
        break label1127;
      }
      localObject = (j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(j.class);
      if (localObject == null) {
        break label1127;
      }
      bool1 = ((j)localObject).ziH;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject == null) {
        break label1133;
      }
      localObject = (j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(j.class);
      if (localObject == null) {
        break label1133;
      }
      bool2 = ((j)localObject).yeB;
      if ((!bool1) || (!bool2)) {
        break label1139;
      }
      localObject = s.bb.yKL;
      yBt = (s.bb)localObject;
      localbp.dQ(yBt.action);
      localbp.dR(enterTime);
      paramLong = l2 - yBp;
      if (paramLong <= 0L) {
        break label1160;
      }
      localbp.dS(paramLong);
      paramLong = yBM;
      l3 = yBN;
      if (!yBO) {
        break label1165;
      }
      if (yBL <= 0L) {
        break label1204;
      }
      l4 = l2 - yBL;
      if (l4 > 0L) {
        l1 = l4;
      }
      l3 += l1;
      l1 = paramLong;
      paramLong = l3;
    }
    for (;;)
    {
      localbp.dU(paramLong);
      localbp.dT(l1);
      localbp.dV(yBR.status);
      localbp.dW(l2);
      localbp.dX(parambf.action);
      if (paramString != null)
      {
        paramString = kotlin.n.n.l(paramString, ",", ";", false);
        parambf = paramString;
        if (paramString != null) {}
      }
      else
      {
        parambf = "";
      }
      localbp.kp(parambf);
      parambf = k.yBj;
      localbp.dY(s.at(localbp.agV(), xbJ));
      localbp.dZ(yBT.action);
      parambf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      localbp.kq(kotlin.n.n.l(c.a.axM(whH), ",", ";", false));
      parambf = yCj;
      if (parambf != null)
      {
        paramString = kotlin.n.n.l(parambf, ",", ";", false);
        parambf = paramString;
        if (paramString != null) {}
      }
      else
      {
        parambf = "";
      }
      localbp.kr(parambf);
      localbp.ea(dDq());
      parambf = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      parambf = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (parambf != null)
      {
        parambf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parambf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (parambf != null)
        {
          paramString = parambf.fIY;
          parambf = paramString;
          if (paramString != null) {
            break label726;
          }
        }
      }
      parambf = "";
      label726:
      localbp.ks(parambf);
      localbp.bpa();
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, liveId=" + localbp.agS() + ", feedId=" + localbp.agT() + ", username=" + localbp.getUserName() + ", topic=" + localbp.agU() + ", commentScene=" + localbp.agV() + ", isPrivate=" + localbp.agW() + ", contextId=" + localbp.agX() + ", clickTabContextId=" + localbp.agY() + ", sessionId=" + localbp.agZ() + ", sessionBuffer=" + localbp.getSessionBuffer() + ", shopPermit=" + localbp.aha() + ", enterSessionId=" + localbp.ahb() + ", liveTime=" + localbp.ahc() + ", floatDuration=" + localbp.ahe() + ", fullDuration=" + localbp.ahd() + ", enterStatus=" + localbp.ahf() + ", actionTS=" + localbp.ahg() + ", action=" + localbp.ahh() + ", enterIconType=" + localbp.ahj() + ", pageType=" + localbp.ahk() + ", adData=" + localbp.ahl() + ", scenenote=" + localbp.ahm() + ", identityType=" + localbp.ahn() + ", request_id=" + localbp.aho() + ", actionResult=" + localbp.ahi());
      AppMethodBeat.o(290913);
      return;
      localObject = kotlin.n.n.l(sessionBuffer, ",", ";", false);
      break;
      label1127:
      bool1 = false;
      break label341;
      label1133:
      bool2 = false;
      break label381;
      label1139:
      if (bool1)
      {
        localObject = s.bb.yKK;
        break label396;
      }
      localObject = s.bb.yKJ;
      break label396;
      label1160:
      paramLong = 0L;
      break label436;
      label1165:
      if (yBK > 0L)
      {
        l4 = l2 - yBK;
        if (l4 > 0L) {
          l1 = l4;
        }
        l1 += paramLong;
        paramLong = l3;
      }
      else
      {
        label1204:
        l1 = paramLong;
        paramLong = l3;
      }
    }
  }
  
  public static void a(s.bk parambk, String paramString, int paramInt)
  {
    AppMethodBeat.i(290903);
    p.k(parambk, "type");
    long l = System.currentTimeMillis();
    switch (n.yBo[parambk.ordinal()])
    {
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", parambk.type);
      localJSONObject.put("giftid", paramString);
      localJSONObject.put("num", paramInt);
      a(s.bf.yLq, localJSONObject.toString(), l);
      AppMethodBeat.o(290903);
      return;
      if (paramInt == 0)
      {
        if (yCp)
        {
          AppMethodBeat.o(290903);
          return;
        }
        yCp = true;
      }
      else
      {
        AppMethodBeat.o(290903);
        return;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkr = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wks = l;
        yCi += paramInt;
        continue;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkr = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wks = l;
      }
    }
  }
  
  public static void a(s.bn parambn, String paramString1, long paramLong, String paramString2, String paramString3, Long paramLong1, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(290916);
    p.k(parambn, "action");
    if (s.bn.yNc == parambn) {
      com.tencent.mm.plugin.expt.hellhound.a.nj(true);
    }
    di localdi = new di();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localdi.pB(str);
    str = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localdi.pC(paramString1);
    localdi.iD(System.currentTimeMillis());
    localdi.iE(parambn.action);
    localdi.pD(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramLong));
    localdi.iF(0L);
    parambn = paramString2;
    if (paramString2 == null) {
      parambn = "";
    }
    localdi.pE(parambn);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
    parambn = paramString1;
    if (paramString1 == null) {
      parambn = "";
    }
    localdi.pF(parambn);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
    parambn = paramString1;
    if (paramString1 == null) {
      parambn = "";
    }
    localdi.pG(parambn);
    parambn = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    localdi.pH(kotlin.n.n.l(c.a.axM(localdi.aiW()), ",", ";", false));
    parambn = yCj;
    if (parambn != null)
    {
      paramString1 = kotlin.n.n.l(parambn, ",", ";", false);
      parambn = paramString1;
      if (paramString1 != null) {}
    }
    else
    {
      parambn = "";
    }
    localdi.pI(parambn);
    int i;
    if (paramString3 != null)
    {
      if (((CharSequence)paramString3).length() <= 0) {
        break label366;
      }
      i = 1;
      if (i != 0) {
        localdi.pJ(paramString3);
      }
    }
    if (paramLong1 != null) {}
    for (paramLong = paramLong1.longValue();; paramLong = 0L)
    {
      localdi.iG(paramLong);
      parambn = paramString5;
      if (paramString5 == null) {
        parambn = "";
      }
      localdi.pK(parambn);
      parambn = paramString4;
      if (paramString4 == null) {
        parambn = "";
      }
      localdi.pL(parambn);
      if (paramString6 == null) {
        break label707;
      }
      parambn = kotlin.n.d.UTF_8;
      if (paramString6 != null) {
        break label377;
      }
      parambn = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(290916);
      throw parambn;
      label366:
      i = 0;
      break;
    }
    label377:
    parambn = paramString6.getBytes(parambn);
    p.j(parambn, "(this as java.lang.String).getBytes(charset)");
    for (;;)
    {
      localdi.pM(Base64.encodeToString(parambn, 0));
      localdi.bpa();
      paramString2 = new StringBuilder("report21158, finderUsrName=").append(localdi.aiW()).append(", finderSessionId=").append(localdi.ahA()).append(", actionTimeMs=").append(localdi.ahB()).append(", actionType=").append(localdi.ahC()).append(", enterLiveId=").append(localdi.aiX()).append(", enterStatus=").append(localdi.ahf()).append(", commentscene=").append(localdi.aiY()).append(", contextid=").append(localdi.aiZ()).append(", adData=").append(localdi.ahl()).append(", scenenote=").append(localdi.ahm()).append(", clickTabContextId=").append(localdi.agY()).append(", forcePushId=");
      paramString1 = localdi.aja();
      parambn = paramString1;
      if (paramString1 == null) {
        parambn = "";
      }
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", parambn + ',' + "clickTabContextId=" + localdi.agY() + ',' + "notificationId=" + localdi.ajc() + ',' + "reportContent=" + localdi.getReportContent() + ',' + "noticetype=" + localdi.ajb() + ',' + "description=" + localdi.getDescription());
      AppMethodBeat.o(290916);
      return;
      label707:
      parambn = null;
    }
  }
  
  public static void a(s.p paramp)
  {
    AppMethodBeat.i(290923);
    p.k(paramp, "elementId");
    br localbr = new br();
    localbr.ee(Util.nowMilliSecond());
    localbr.kx(whH);
    localbr.ky(yAV);
    localbr.kz("");
    localbr.kA("");
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbr.kB(str1);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbr.kC(str1);
    localbr.kD(yBr);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbr.kE(str1);
    localbr.kF("");
    localbr.kG("");
    localbr.kH(paramp.id);
    localbr.kI("");
    localbr.bpa();
    AppMethodBeat.o(290923);
  }
  
  public static void a(s.q paramq)
  {
    AppMethodBeat.i(290922);
    p.k(paramq, "elementId");
    bs localbs = new bs();
    localbs.ef(Util.nowMilliSecond());
    localbs.kJ(whH);
    localbs.kK(yAV);
    localbs.kL("");
    localbs.kM("");
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbs.kN(str1);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbs.kO(str1);
    localbs.kP(yBr);
    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbs.kQ(str1);
    localbs.kR("");
    localbs.kS("");
    localbs.kT("");
    localbs.kU(paramq.id);
    localbs.kV("");
    localbs.bpa();
    AppMethodBeat.o(290922);
  }
  
  public static void a(s.r paramr)
  {
    AppMethodBeat.i(290883);
    p.k(paramr, "<set-?>");
    yBR = paramr;
    AppMethodBeat.o(290883);
  }
  
  public static void aCA(String paramString)
  {
    AppMethodBeat.i(290885);
    p.k(paramString, "<set-?>");
    yCj = paramString;
    AppMethodBeat.o(290885);
  }
  
  public static String aCB(String paramString)
  {
    AppMethodBeat.i(290919);
    if (!TextUtils.isEmpty((CharSequence)sessionBuffer))
    {
      paramString = sessionBuffer;
      AppMethodBeat.o(290919);
      return paramString;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).sessionBuffer; !TextUtils.isEmpty((CharSequence)localObject1); localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = kotlin.n.n.l((String)localObject1, ",", ";", false);
        paramString = (String)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramString = "";
      }
      AppMethodBeat.o(290919);
      return paramString;
    }
    if (p.h(paramString, s.l.yFQ.scene))
    {
      paramString = k.yBj;
      paramString = k.dDm().yDi;
    }
    for (;;)
    {
      Object localObject2 = paramString;
      do
      {
        do
        {
          if (localObject2 != null)
          {
            localObject1 = kotlin.n.n.l((String)localObject2, ",", ";", false);
            paramString = (String)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramString = "";
          }
          AppMethodBeat.o(290919);
          return paramString;
          localObject2 = localObject1;
        } while (org.apache.commons.b.g.fK(paramString));
        localObject2 = localObject1;
      } while (kotlin.n.n.a((CharSequence)paramString, (CharSequence)"temp", false));
      localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
      localObject1 = com.tencent.mm.plugin.finder.report.n.N(feedId, Integer.parseInt(paramString));
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
    }
  }
  
  public static void aCz(String paramString)
  {
    AppMethodBeat.i(290882);
    p.k(paramString, "value");
    String str = paramString;
    if (kotlin.n.n.a((CharSequence)paramString, (CharSequence)",", false)) {
      str = kotlin.n.n.l(paramString, ",", ";", false);
    }
    yAV = str;
    AppMethodBeat.o(290882);
  }
  
  public static long amU()
  {
    return enterTime;
  }
  
  private static void b(s.bh parambh)
  {
    long l1 = 0L;
    AppMethodBeat.i(290915);
    if (yBR == s.r.yGD)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(290915);
      return;
    }
    long l4 = System.currentTimeMillis();
    df localdf = new df();
    localdf.oX(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(liveId));
    localdf.oY(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(feedId));
    localdf.oZ(whH);
    localdf.pa(URLEncoder.encode(yBq, "UTF-8"));
    localdf.pj(yAV);
    localdf.hH(enterTime);
    long l2 = enterTime - yBp;
    label152:
    label175:
    long l3;
    if (l2 > 0L)
    {
      localdf.hI(l2);
      l2 = l4 - yBp;
      if (l2 <= 0L) {
        break label1446;
      }
      localdf.hJ(l2);
      l2 = l4 - enterTime;
      if (l2 <= 0L) {
        break label1452;
      }
      localdf.hK(l2);
      l2 = yBN;
      l3 = yBM;
      if (!yBO) {
        break label1458;
      }
      if (yBL <= 0L) {
        break label1717;
      }
      l3 = l4 - yBL;
      if (l3 > 0L) {
        l1 = l3;
      }
      l2 = l1 + l2;
      l1 = localdf.getDuration() - l2;
    }
    for (;;)
    {
      label240:
      localdf.hL(l2);
      localdf.hM(l1);
      localdf.hN(yBR.status);
      localdf.hO(yBu);
      localdf.aie();
      localdf.aig();
      localdf.hP(yBv);
      localdf.aij();
      localdf.hQ(yBA.size());
      localdf.hR(yBB);
      localdf.hS(yBw);
      localdf.hT(yBx);
      localdf.hU(yBy);
      localdf.hV(yBz);
      localdf.hW(yBC);
      localdf.hX(yBD);
      localdf.hY(yBE);
      localdf.hZ(yBF);
      localdf.ia(yBG);
      localdf.ib(yBH);
      if (yBJ)
      {
        l1 = s.bp.yNk.state;
        label442:
        localdf.ie(l1);
        localdf.ic(parambh.type);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
        parambh = (s.bh)localObject1;
        if (localObject1 == null) {
          parambh = "";
        }
        localdf.pb(parambh);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
        parambh = (s.bh)localObject1;
        if (localObject1 == null) {
          parambh = "";
        }
        localdf.pc(parambh);
        if (!TextUtils.isEmpty((CharSequence)sessionBuffer)) {
          break label1512;
        }
        parambh = kotlin.n.n.l(aCB(yBr), ",", ";", false);
        sessionBuffer = parambh;
      }
      for (;;)
      {
        localdf.pd(parambh);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
        parambh = (s.bh)localObject1;
        if (localObject1 == null) {
          parambh = "";
        }
        localdf.pe(parambh);
        localdf.id(yBs);
        localdf.pf(yBr);
        parambh = k.yBj;
        localdf.jdMethod_if(s.at(localdf.agV(), xbJ));
        localdf.ig(yBU);
        localdf.ih(yBV);
        localdf.ii(yBW);
        localdf.ij(yBX);
        localdf.ik(yBI);
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localdf.pg(kotlin.n.n.l(c.a.axM(whH), ",", ";", false));
        localdf.il(yBY);
        localdf.im(yCb);
        localdf.in(yCc);
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        localdf.ip(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD());
        localdf.io(yCi);
        if (!yCe.isEmpty()) {
          break label1529;
        }
        localdf.ph("");
        parambh = yCj;
        if (parambh != null)
        {
          localObject1 = kotlin.n.n.l(parambh, ",", ";", false);
          parambh = (s.bh)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          parambh = "";
        }
        localdf.pi(parambh);
        localdf.bpa();
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, duration=" + localdf.getDuration() + ", floatDuration=" + localdf.ahe() + ", fullDuration=" + localdf.ahd() + ", diffTime=" + (localdf.ahd() + localdf.ahe() - localdf.getDuration()) + ", commentScene=" + localdf.agV() + ", pressLikeCount=" + localdf.aih() + ", enterStatus=" + localdf.ahf() + ", acclaimCount=" + localdf.aik() + ", clickLikeCount=" + localdf.aif() + ", goodsClickCount=" + localdf.ail() + ", floatingCount=" + localdf.aim() + ", shareMoments=" + localdf.ain() + ", singleChat=" + localdf.aio() + ", groupChat=" + localdf.aip() + ", profileCount=" + localdf.aiq() + ", complainAnchor=" + localdf.air() + ", complainAudience=" + localdf.ais() + ", forbidden=" + localdf.ait() + ", enterFollow=" + localdf.aiu() + ", exitFollow=" + localdf.aiv() + ", exitType=" + localdf.aiw() + ", contextId=" + localdf.agX() + ", clickTabContextId=" + localdf.agY() + ", sessionBuffer=" + localdf.getSessionBuffer() + ", sessionID=" + localdf.agZ() + ", isPrivate=" + localdf.agW() + ", shopExp=" + localdf.aix() + ", enterIconType=" + localdf.ahj() + ", clickToLandscape=" + localdf.aiy() + ", clickToPortrait=" + localdf.aiA() + ", rotateToLandscape=" + localdf.aiz() + ", rotateToPortrait=" + localdf.aiB() + ", lotteryCount=" + localdf.aiD() + ", adData=" + localdf.ahl() + ", commentsCount=" + localdf.aid() + ", replycount=" + localdf.aiC() + ", tryToConnectCount=" + localdf.aiE() + ", connectSuccessCount=" + localdf.aiF() + ", connectDuration=" + localdf.aiG() + ", giftCount=" + localdf.aiH() + ", scenenote=" + localdf.ahm() + "shareToStatus=" + localdf.aiI() + "emojiCount=" + localdf.aii());
        AppMethodBeat.o(290915);
        return;
        l2 = 0L;
        break;
        label1446:
        l2 = 0L;
        break label152;
        label1452:
        l2 = 0L;
        break label175;
        label1458:
        if (yBK <= 0L) {
          break label1717;
        }
        l2 = l4 - yBK;
        if (l2 > 0L) {
          l1 = l2;
        }
        l1 = l3 + l1;
        l2 = localdf.getDuration() - l1;
        break label240;
        l1 = s.bp.yNj.state;
        break label442;
        label1512:
        parambh = kotlin.n.n.l(sessionBuffer, ",", ";", false);
      }
      label1529:
      parambh = "";
      Object localObject1 = yCe.iterator();
      label1541:
      if (((Iterator)localObject1).hasNext())
      {
        com.tencent.mm.vending.j.d locald = (com.tencent.mm.vending.j.d)((Iterator)localObject1).next();
        Object localObject2 = locald.ieV();
        p.j(localObject2, "tuple.`$3`()");
        if (!((Boolean)localObject2).booleanValue()) {
          break label1714;
        }
        parambh = parambh + ((s.ag)locald.ieT()).type + '|' + (Long)locald.ieU() + ';';
      }
      label1714:
      for (;;)
      {
        break label1541;
        localObject1 = parambh;
        if ((p.h(parambh, "") ^ true))
        {
          int i = parambh.length();
          if (parambh == null)
          {
            parambh = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(290915);
            throw parambh;
          }
          localObject1 = parambh.substring(0, i - 1);
          p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        localdf.ph((String)localObject1);
        break;
      }
      label1717:
      l1 = l3;
    }
  }
  
  public static void bvU()
  {
    AppMethodBeat.i(290895);
    yBF += 1;
    Log.d("HABBYGE-MALI.HellLiveVisitorReoprter", "HABBYGE-MALI, setForbidden: " + yBF);
    AppMethodBeat.o(290895);
  }
  
  public static void dDn()
  {
    yBJ = true;
  }
  
  public static boolean dDo()
  {
    return yBZ;
  }
  
  private static long dDq()
  {
    AppMethodBeat.i(290918);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().getInt(ar.a.VyS, 0);
    AppMethodBeat.o(290918);
    return l;
  }
  
  public static String dDr()
  {
    AppMethodBeat.i(290920);
    Object localObject;
    if (!TextUtils.isEmpty((CharSequence)sessionBuffer))
    {
      localObject = sessionBuffer;
      AppMethodBeat.o(290920);
      return localObject;
    }
    if (p.h(yBr, s.l.yFQ.scene))
    {
      localObject = k.yBj;
      localObject = k.dDm().yDi;
    }
    for (;;)
    {
      localObject = kotlin.n.n.l((String)localObject, ",", ";", false);
      AppMethodBeat.o(290920);
      return localObject;
      if ((!org.apache.commons.b.g.fK(yBr)) && (!kotlin.n.n.a((CharSequence)yBr, (CharSequence)"temp", false)))
      {
        localObject = com.tencent.mm.plugin.finder.report.n.zWF;
        String str = com.tencent.mm.plugin.finder.report.n.N(feedId, Integer.parseInt(yBr));
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
      else
      {
        localObject = "";
      }
    }
  }
  
  public static String getSessionBuffer()
  {
    return sessionBuffer;
  }
  
  public static void ps(boolean paramBoolean)
  {
    yCf = paramBoolean;
  }
  
  public static void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(290921);
    p.k(paramString1, "feedId");
    p.k(paramString2, "liveId");
    Object localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)localObject).getRedDotManager().aBf("FinderLiveEntrance");
    bb localbb = new bb();
    localbb.agR();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.dcv();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbb.jF((String)localObject);
    localbb.dC(paramInt);
    localbb.jB(paramString1);
    localbb.jC(paramString2);
    if (locall != null) {}
    for (paramString1 = locall.field_tipsId;; paramString1 = null)
    {
      localbb.jD(paramString1);
      if (locall != null)
      {
        paramString1 = com.tencent.mm.ae.g.bN(locall.drG());
        paramString1.put("object_id", com.tencent.mm.ae.d.Fw(locall.drG().object_id));
        paramString1 = paramString1.toString();
        p.j(paramString1, "extInfo.toString()");
        localbb.jG(kotlin.n.n.l(paramString1, ",", ";", false));
      }
      paramString2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbb.jE(paramString1);
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report " + localbb.agI());
      localbb.bpa();
      AppMethodBeat.o(290921);
      return;
    }
  }
  
  public final void NE(int paramInt)
  {
    AppMethodBeat.i(290888);
    a(s.bf.yLw, String.valueOf(paramInt));
    AppMethodBeat.o(290888);
  }
  
  public final void NG(int paramInt)
  {
    AppMethodBeat.i(290911);
    a(s.bf.yLy, String.valueOf(paramInt));
    AppMethodBeat.o(290911);
  }
  
  public final void O(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(290890);
    yCl = true;
    if (!paramBoolean)
    {
      yCk = true;
      switch (paramInt)
      {
      default: 
        Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportSwitchScreen err:screenAction=".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(290890);
        return;
      }
    }
    for (i = 2;; i = paramInt)
    {
      s.aw localaw;
      switch (i)
      {
      default: 
        Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportSwitchScreen err:isAuto=" + paramBoolean + ",screenAction=" + paramInt);
        AppMethodBeat.o(290890);
        return;
      case 1: 
        if (paramBoolean)
        {
          if (yCk)
          {
            yCk = false;
            AppMethodBeat.o(290890);
            return;
          }
          yBX += 1L;
          localaw = s.aw.yKk;
          if ((localaw != s.aw.yKk) && (localaw != s.aw.yKj)) {
            break label293;
          }
        }
        break;
      }
      for (yBT = s.az.yKD;; yBT = s.az.yKC) {
        label293:
        do
        {
          a(s.bf.yLn, String.valueOf(localaw.action));
          if (yBT != s.az.yKC) {
            break label318;
          }
          yBT = s.az.yKD;
          AppMethodBeat.o(290890);
          return;
          yBW += 1L;
          localaw = s.aw.yKj;
          break;
          if (paramBoolean)
          {
            if (yCk)
            {
              yCk = false;
              AppMethodBeat.o(290890);
              return;
            }
            yBV += 1L;
            localaw = s.aw.yKi;
            break;
          }
          yBU += 1L;
          localaw = s.aw.yKh;
          break;
        } while ((localaw != s.aw.yKi) && (localaw != s.aw.yKi));
      }
      label318:
      if (yBT == s.az.yKD) {
        yBT = s.az.yKC;
      }
      AppMethodBeat.o(290890);
      return;
    }
  }
  
  public final void a(s.ar paramar)
  {
    AppMethodBeat.i(290904);
    p.k(paramar, "result");
    if (paramar == s.ar.yJH)
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.nq(true);
    }
    a(s.bf.yLs, String.valueOf(paramar.result));
    AppMethodBeat.o(290904);
  }
  
  public final void a(s.au paramau, s.at paramat)
  {
    AppMethodBeat.i(290910);
    Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", "doReportRedPacket, type=" + paramau.type + ", src" + paramat.src);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramau.type);
    localJSONObject.put("source", paramat.src);
    a(s.bf.yLv, localJSONObject.toString());
    AppMethodBeat.o(290910);
  }
  
  public final void a(s.au paramau, s.at paramat, boolean paramBoolean)
  {
    AppMethodBeat.i(290906);
    p.k(paramau, "type");
    p.k(paramat, "src");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      AppMethodBeat.o(290906);
      return;
    }
    Log.w("HABBYGE-MALI.HellLiveVisitorReoprter", "reportRedPacket, type=" + paramau.type + ", src" + paramat.src + ", inLive=" + paramBoolean);
    switch (n.yCu[paramau.ordinal()])
    {
    default: 
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramau.type);
      if (paramat != s.at.yJN) {
        break;
      }
    }
    for (paramau = String.valueOf(yCq.src);; paramau = String.valueOf(paramat.src))
    {
      ((JSONObject)localObject).put("source", paramau);
      a(s.bf.yLv, ((JSONObject)localObject).toString());
      AppMethodBeat.o(290906);
      return;
      yCr = paramBoolean;
      if (paramBoolean) {
        break;
      }
      AppMethodBeat.o(290906);
      return;
      if (yCr) {
        break;
      }
      AppMethodBeat.o(290906);
      return;
      yCq = paramat;
    }
  }
  
  public final void a(s.bg parambg)
  {
    AppMethodBeat.i(290899);
    p.k(parambg, "action");
    a(s.bf.yLl, String.valueOf(parambg.action));
    AppMethodBeat.o(290899);
  }
  
  public final void a(s.bh parambh)
  {
    AppMethodBeat.i(290892);
    p.k(parambh, "type");
    if (!yCa)
    {
      AppMethodBeat.o(290892);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    int i;
    if (d.a.aAN(whH))
    {
      i = s.x.yHz.state;
      yBH = i;
      yCa = false;
      switch (n.yBk[parambh.ordinal()])
      {
      default: 
        if (yCg)
        {
          yCf = false;
          localObject = yCh;
          switch (n.tKM[localObject.ordinal()])
          {
          default: 
            localObject = s.bl.yMx;
          }
        }
        break;
      }
    }
    for (;;)
    {
      a(this, (s.bl)localObject, null, 6);
      do
      {
        a(s.bf.yLk, String.valueOf(parambh.type));
        b(parambh);
        yBR = s.r.yGD;
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        if (c.a.axL(whH))
        {
          parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          c.a.def();
        }
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.nu(false);
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        c.a.axC("");
        yCg = false;
        yCh = s.ag.yIu;
        yCe.clear();
        yCd = "";
        yCb = 0;
        yCc = 0;
        yCi = 0;
        yCp = false;
        yCm = false;
        yCs = false;
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axr(null);
        parambh = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KP(0);
        AppMethodBeat.o(290892);
        return;
        i = s.x.yHy.state;
        break;
      } while (!yCg);
      yCf = true;
      localObject = yCh;
      switch (n.jLJ[localObject.ordinal()])
      {
      default: 
        localObject = s.bl.yMx;
      }
      for (;;)
      {
        a(this, (s.bl)localObject, null, 6);
        break;
        localObject = s.bl.yMF;
        continue;
        localObject = s.bl.yME;
      }
      localObject = s.bl.yMF;
      continue;
      localObject = s.bl.yME;
    }
  }
  
  public final void a(s.bi parambi, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(290897);
    p.k(parambi, "action");
    p.k(paramString3, "canvasid");
    p.k(paramString4, "aid");
    p.k(paramString5, "uxinfo");
    i locali = new i();
    switch (n.yBl[parambi.ordinal()])
    {
    default: 
      locali.al("commerceAction", parambi.action);
      if (!org.apache.commons.b.g.fK(paramString1)) {
        locali.g("session", paramString1);
      }
      if (!org.apache.commons.b.g.fK(paramString2)) {
        locali.g("productid", paramString2);
      }
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      locali.g("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddH());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      locali.g("appid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddI());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddJ())) {
        break;
      }
    }
    for (paramString3 = Long.valueOf(liveId);; paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddJ())
    {
      locali.g("liveid", paramString3);
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      locali.g("shopwindowid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddK());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      locali.g("sessionid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddL());
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.dec();
      a(s.bf.yLj, locali.toString());
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportCommerceAction, action=" + parambi.name() + ", shopSessionId=" + paramString1 + ", productId=" + paramString2);
      if (((parambi == s.bi.yLP) || (parambi == s.bi.yLS) || (parambi == s.bi.yLT)) && (paramString2 != null) && (!yBA.contains(paramString2))) {
        yBA.add(paramString2);
      }
      if ((parambi == s.bi.yLS) || (parambi == s.bi.yLR)) {
        yBP = true;
      }
      AppMethodBeat.o(290897);
      return;
      if (yBQ)
      {
        AppMethodBeat.o(290897);
        return;
      }
      yBQ = true;
      locali.al("type", parambi.action);
      locali.g("canvasid", paramString3);
      locali.g("aid", paramString4);
      locali.g("uxinfo", paramString5);
      break;
      yBQ = false;
      locali.al("type", parambi.action);
      locali.g("canvasid", paramString3);
      locali.g("aid", paramString4);
      locali.g("uxinfo", paramString5);
      break;
      locali.al("type", parambi.action);
      locali.g("canvasid", paramString3);
      locali.g("aid", paramString4);
      locali.g("uxinfo", paramString5);
      break;
      paramString3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    }
  }
  
  public final void a(s.bl parambl, s.ag paramag, int paramInt)
  {
    AppMethodBeat.i(290900);
    p.k(parambl, "action");
    p.k(paramag, "linkeType");
    switch (n.yBm[parambl.ordinal()])
    {
    }
    label406:
    do
    {
      for (;;)
      {
        a(s.bf.yLr, String.valueOf(parambl.action));
        AppMethodBeat.o(290900);
        return;
        if (paramInt == 0)
        {
          if (yCm)
          {
            AppMethodBeat.o(290900);
            return;
          }
          yCm = true;
        }
        else
        {
          AppMethodBeat.o(290900);
          return;
          AppMethodBeat.o(290900);
          return;
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLinkMic, action=" + parambl.name() + ", gLinkMicTimeList=" + yCe.size() + ", activeCloselinkMic=" + yCf);
          yCg = false;
          paramInt = yCe.size() - 1;
          for (;;)
          {
            com.tencent.mm.vending.j.d locald;
            s.ag localag;
            if (paramInt >= 0)
            {
              paramag = yCe.get(paramInt);
              p.j(paramag, "gLinkMicTimeList[i]");
              locald = (com.tencent.mm.vending.j.d)paramag;
              localag = (s.ag)locald.ieT();
              switch (n.yCv[parambl.ordinal()])
              {
              default: 
                paramag = s.ag.yIs;
              }
            }
            while ((localag == paramag) && (((Number)locald.ieU()).longValue() > 0L) && (p.h((Boolean)locald.ieV(), Boolean.FALSE)))
            {
              long l = System.currentTimeMillis();
              paramag = locald.ieU();
              p.j(paramag, "tuple.`$2`()");
              l = (l - ((Number)paramag).longValue()) / 1000L;
              if (l < 0L) {
                break;
              }
              yCe.set(paramInt, com.tencent.mm.vending.j.a.h(locald.ieT(), Long.valueOf(l), Boolean.TRUE));
              if (yCf) {
                break label406;
              }
              AppMethodBeat.o(290900);
              return;
              paramag = s.ag.yIt;
              continue;
              paramag = s.ag.yIu;
            }
            paramInt -= 1;
          }
          yCf = false;
          continue;
          yCb += 1;
          continue;
          yCg = true;
          yCc += 1;
          if (paramag != s.ag.yIs) {
            yCh = paramag;
          }
          yCe.add(com.tencent.mm.vending.j.a.h(yCh, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        }
      }
    } while (!yCg);
    AppMethodBeat.o(290900);
  }
  
  public final void a(s.bm parambm, String paramString)
  {
    AppMethodBeat.i(290902);
    p.k(parambm, "type");
    switch (n.yBn[parambm.ordinal()])
    {
    default: 
      Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLettery ERROR: " + parambm.name());
    case 1: 
      for (;;)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", parambm.type);
        parambm = paramString;
        if (paramString == null) {
          parambm = "";
        }
        ((JSONObject)localObject).put("result", parambm);
        a(s.bf.yLp, ((JSONObject)localObject).toString());
        AppMethodBeat.o(290902);
        return;
        yCn = false;
        yCo = "";
      }
    case 2: 
      yCn = true;
      if (paramString != null) {
        break;
      }
    }
    for (Object localObject = "";; localObject = paramString)
    {
      yCo = (String)localObject;
      break;
      if ((yCn) && (!TextUtils.isEmpty((CharSequence)yCo)))
      {
        paramString = yCo;
        break;
      }
      AppMethodBeat.o(290902);
      return;
      yBY += 1;
      break;
      yBZ = true;
      break;
    }
  }
  
  public final void a(s.i parami)
  {
    AppMethodBeat.i(290909);
    p.k(parami, "result");
    int i = parami.type;
    a(s.bf.yLx, String.valueOf(i));
    AppMethodBeat.o(290909);
  }
  
  public final void a(s.j paramj)
  {
    AppMethodBeat.i(290896);
    p.k(paramj, "action");
    a(s.bf.yLf, String.valueOf(paramj.action));
    if (paramj != s.j.yFC) {
      yBB += 1;
    }
    AppMethodBeat.o(290896);
  }
  
  public final void a(s.w paramw)
  {
    AppMethodBeat.i(290908);
    p.k(paramw, "action");
    a(s.bf.yLt, String.valueOf(paramw.action));
    AppMethodBeat.o(290908);
  }
  
  public final void a(Integer paramInteger, int paramInt, s.ay paramay)
  {
    int i = 1;
    AppMethodBeat.i(290887);
    p.k(paramay, "event");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      AppMethodBeat.o(290887);
      return;
    }
    NF(paramInt);
    if (yCl)
    {
      yCl = false;
      AppMethodBeat.o(290887);
      return;
    }
    if (paramInteger == null)
    {
      AppMethodBeat.o(290887);
      return;
    }
    if (paramInteger.intValue() == 0)
    {
      paramInt = i;
      switch (n.$EnumSwitchMapping$0[paramay.ordinal()])
      {
      default: 
        paramInteger = new kotlin.m();
        AppMethodBeat.o(290887);
        throw paramInteger;
      case 3: 
        paramInt = 0;
      }
      if (paramInt != 0) {
        a(s.bf.yLm, "");
      }
    }
    AppMethodBeat.o(290887);
  }
  
  public final void a(String paramString, s.bo parambo)
  {
    AppMethodBeat.i(290894);
    p.k(parambo, "type");
    i locali = new i();
    if (!org.apache.commons.b.g.fK(paramString)) {
      locali.g("username", paramString);
    }
    locali.al("type", parambo.type);
    if (parambo == s.bo.yNh)
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axr(null);
    }
    a(s.bf.yLe, locali.toString());
    if (parambo == s.bo.yNf)
    {
      if ((paramString != null) && (kotlin.n.n.a((CharSequence)paramString, (CharSequence)"@chatroom", false) == true))
      {
        yBz += 1;
        AppMethodBeat.o(290894);
        return;
      }
      yBy += 1;
      AppMethodBeat.o(290894);
      return;
    }
    if (parambo == s.bo.yNg) {
      yBx += 1;
    }
    AppMethodBeat.o(290894);
  }
  
  public final void a(boolean paramBoolean, s.v paramv)
  {
    AppMethodBeat.i(290893);
    p.k(paramv, "floatType");
    if (paramv == s.v.yHm) {
      yBZ = false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    long l3;
    s.v localv;
    if (paramBoolean)
    {
      if (yBO)
      {
        AppMethodBeat.o(290893);
        return;
      }
      if (yBK > 0L)
      {
        l1 = l2 - yBK;
        l3 = yBM;
        if (l1 > 0L)
        {
          yBM = l1 + l3;
          yBK = 0L;
        }
      }
      else
      {
        yBL = l2;
        yBO = true;
        yBw += 1;
        if (paramv != s.v.yHl) {
          break label252;
        }
        if (!com.tencent.mm.plugin.expt.hellhound.a.weM) {
          break label226;
        }
        localv = s.v.yHq;
      }
    }
    for (;;)
    {
      if (yBS)
      {
        localv = s.v.yHr;
        yBS = false;
      }
      a(s.bf.yLd, String.valueOf(localv.type));
      AppMethodBeat.o(290893);
      return;
      l1 = 0L;
      break;
      if (!yBO)
      {
        AppMethodBeat.o(290893);
        return;
      }
      if (yBL > 0L)
      {
        l1 = l2 - yBL;
        l3 = yBN;
        if (l1 <= 0L) {
          break label221;
        }
      }
      for (;;)
      {
        yBN = l1 + l3;
        yBL = 0L;
        yBK = l2;
        yBO = false;
        break;
        label221:
        l1 = 0L;
      }
      label226:
      if (yBP)
      {
        localv = s.v.yHp;
        yBP = false;
      }
      else
      {
        localv = s.v.yHo;
        continue;
        label252:
        localv = paramv;
        if (paramv == s.v.yHm)
        {
          yBP = false;
          localv = paramv;
        }
      }
    }
  }
  
  public final void dDp()
  {
    AppMethodBeat.i(290905);
    a(s.bf.yLu, "");
    AppMethodBeat.o(290905);
  }
  
  public final void e(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(290912);
    i locali = new i();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      locali.al("exposeClick", i);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      locali.g("bizuin", str);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      locali.g("bizusername", paramString1);
      a(s.bf.yLA, locali.toString());
      AppMethodBeat.o(290912);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.m
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.report.live;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveVisitorReoprter;", "", "()V", "TAG", "", "activeCloselinkMic", "", "getActiveCloselinkMic", "()Z", "setActiveCloselinkMic", "(Z)V", "autoFillComment", "clearCount", "", "clickToLandscape", "", "clickToPortrait", "commentScene", "commentsCount", "complainAnchor", "complainVisitor", "emojiCount", "enterFollow", "enterProfileEventInLiveRoom", "enterTime", "getEnterTime", "()J", "setEnterTime", "(J)V", "enterType", "exitFollow", "feedId", "finderUserName", "forbidden", "gLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "Lkotlin/collections/ArrayList;", "giftCount", "giftIconReprtedYet", "goodsClickData", "groupChat", "isBubbleShow", "isPrivate", "isShopExp", "setShopExp", "isWeAppOpen", "linkMicDuration", "linkMicSuccCount", "linkMicType", "linkMicing", "linkmicIconReprtedYet", "liveId", "liveRoomState", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$EnterRoomStatus;", "getLiveRoomState", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$EnterRoomStatus;", "setLiveRoomState", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$EnterRoomStatus;)V", "liveStartTime", "liveStatus", "liveTopic", "mClickJoinLottery", "mClickLotteryHistory", "getMClickLotteryHistory", "setMClickLotteryHistory", "mIsEnterLivingRoom", "mIsFloat", "mLastFloatTS", "mLastFullTS", "mLotterySuccCount", "mPageType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenDirection;", "mSwitchScreenByHand", "mSwithcScreenEvent", "mTotalFloatTime", "mTotalFullTime", "minizaionCount", "profileCount", "replyCommentCount", "rotateToLandscape", "rotateToPortrait", "scenenote", "getScenenote", "()Ljava/lang/String;", "setScenenote", "(Ljava/lang/String;)V", "sessionBuffer", "shareMoments", "shopPermit", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ShopPermitAction;", "singleChat", "tryToLinkMicCount", "getLinkType", "action", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLinkMicAction;", "report21084", "", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAction;", "actionJson", "actionMs", "report21158", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorNoticeAction;", "finderUsrName", "enterLiveId", "enterStatus", "commentscene", "report21178", "type", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCloseType;", "reportClearScreen", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ClearScreenAction;", "reportCommerceAction", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCommerceAction;", "shopSessionId", "productId", "reportComplaintAnchor", "reportComplaintVisitor", "username", "source", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ComplaintVisitorSource;", "reportCopyComment", "reportEnterProfile", "reportFloat", "isMini", "floatType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FloatActionType;", "reportGift", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorGift;", "giftid", "num", "reportJoinLive", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "screenStateOfConfig", "reportLettery", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLotteryType;", "result", "reportLike", "reportLinkMic", "linkeType", "linkmicIconState", "reportNearbyLiveToMore", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyMoreActionResult;", "reportOnScreenBtnExposure", "showState", "screenTypeOfConfig", "event", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenBtnEvent;", "(Ljava/lang/Integer;ILcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenBtnEvent;)V", "reportQuitLive", "reportRealAuth", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAuthAction;", "reportReplyComment", "replyContent", "reportSendMsg", "content", "title", "reportShare", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorShareType;", "reportSlideRoom", "reportSwitchScreen", "isAuto", "screenAction", "setForbidden", "setRealScreenType", "plugin-finder_release"})
public final class m
{
  public static long enterTime;
  public static long feedId;
  public static long liveId;
  public static int liveStatus;
  public static String sBN;
  public static String sessionBuffer;
  public static int vkA;
  public static boolean vkB;
  public static long vkC;
  public static long vkD;
  public static long vkE;
  public static long vkF;
  public static boolean vkG;
  public static boolean vkH;
  public static boolean vkI;
  public static s.n vkJ;
  public static boolean vkK;
  private static s.am vkL;
  public static long vkM;
  public static long vkN;
  public static long vkO;
  public static long vkP;
  public static int vkQ;
  public static boolean vkR;
  public static boolean vkS;
  public static int vkT;
  public static int vkU;
  public static String vkV;
  public static final ArrayList<d<s.z, Long, Boolean>> vkW;
  public static boolean vkX;
  public static boolean vkY;
  public static s.z vkZ;
  public static long vkg;
  public static String vkh;
  public static String vki;
  public static int vkj;
  public static int vkk;
  public static s.an vkl;
  public static int vkm;
  public static int vkn;
  public static int vko;
  public static int vkp;
  public static int vkq;
  public static int vkr;
  public static ArrayList<String> vks;
  public static int vkt;
  public static int vku;
  public static int vkv;
  public static int vkw;
  public static int vkx;
  public static int vky;
  public static int vkz;
  private static int vla;
  private static String vlb;
  private static boolean vlc;
  private static boolean vld;
  public static boolean vle;
  public static boolean vlf;
  public static String vlg;
  public static boolean vlh;
  public static final m vli;
  
  static
  {
    AppMethodBeat.i(251005);
    vli = new m();
    sBN = "";
    vkh = "";
    vki = "";
    vkl = s.an.vqT;
    sessionBuffer = "";
    vks = new ArrayList();
    vkJ = s.n.vop;
    vkL = s.am.vqR;
    vkV = "";
    vkW = new ArrayList();
    vkZ = s.z.vpF;
    vlb = "";
    vlg = "";
    AppMethodBeat.o(251005);
  }
  
  public static void KJ(int paramInt)
  {
    AppMethodBeat.i(250987);
    vld = true;
    s.aj localaj;
    switch (paramInt)
    {
    default: 
      Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportSwitchScreen err:isAuto=true,screenAction=" + paramInt);
      AppMethodBeat.o(250987);
      return;
    case 1: 
      if (vlc)
      {
        vlc = false;
        AppMethodBeat.o(250987);
        return;
      }
      vkP += 1L;
      localaj = s.aj.vqG;
      if ((localaj != s.aj.vqG) && (localaj != s.aj.vqF)) {
        break;
      }
    }
    for (vkL = s.am.vqR;; vkL = s.am.vqQ) {
      do
      {
        a(s.ar.vrx, String.valueOf(localaj.action));
        if (vkL != s.am.vqQ) {
          break label201;
        }
        vkL = s.am.vqR;
        AppMethodBeat.o(250987);
        return;
        if (vlc)
        {
          vlc = false;
          AppMethodBeat.o(250987);
          return;
        }
        vkN += 1L;
        localaj = s.aj.vqE;
        break;
      } while ((localaj != s.aj.vqE) && (localaj != s.aj.vqE));
    }
    label201:
    if (vkL == s.am.vqR) {
      vkL = s.am.vqQ;
    }
    AppMethodBeat.o(250987);
  }
  
  public static void KK(int paramInt)
  {
    s.am localam;
    switch (paramInt)
    {
    default: 
      localam = s.am.vqQ;
    }
    for (;;)
    {
      vkL = localam;
      return;
      localam = s.am.vqQ;
      continue;
      localam = s.am.vqR;
    }
  }
  
  public static void a(s.ag paramag)
  {
    AppMethodBeat.i(251000);
    p.h(paramag, "result");
    a(s.ar.vrC, String.valueOf(paramag.result));
    AppMethodBeat.o(251000);
  }
  
  private static void a(s.ar paramar, String paramString, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(251001);
    if (vkJ == s.n.voq)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(251001);
      return;
    }
    long l2 = paramLong;
    if (paramLong <= 0L) {
      l2 = System.currentTimeMillis();
    }
    bd localbd = new bd();
    localbd.iQ(b.zs(liveId));
    localbd.iR(b.zs(feedId));
    localbd.iS(sBN);
    localbd.iT(URLEncoder.encode(vkh, "UTF-8"));
    localbd.iU(vki);
    localbd.dg(vkk);
    String str = b.cND();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbd.iV((String)localObject);
    str = b.cNB();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbd.iW((String)localObject);
    str = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbd.iX((String)localObject);
    localbd.iY(n.j(sessionBuffer, ",", ";", false));
    localObject = o.ujN;
    localObject = o.dfZ();
    boolean bool1;
    boolean bool2;
    label268:
    label283:
    label323:
    long l3;
    long l4;
    if (localObject != null)
    {
      bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEk;
      localObject = o.ujN;
      localObject = o.dfZ();
      if (localObject == null) {
        break label914;
      }
      bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uit;
      if ((!bool1) || (!bool2)) {
        break label920;
      }
      localObject = s.an.vqV;
      vkl = (s.an)localObject;
      localbd.dh(vkl.action);
      localbd.di(enterTime);
      paramLong = l2 - vkg;
      if (paramLong <= 0L) {
        break label941;
      }
      localbd.dj(paramLong);
      paramLong = vkE;
      l3 = vkF;
      if (!vkG) {
        break label946;
      }
      if (vkD <= 0L) {
        break label985;
      }
      l4 = l2 - vkD;
      if (l4 > 0L) {
        l1 = l4;
      }
      l3 += l1;
      l1 = paramLong;
      paramLong = l3;
    }
    for (;;)
    {
      localbd.dl(paramLong);
      localbd.dk(l1);
      localbd.dm(vkJ.jii);
      localbd.dn(l2);
      localbd.jdMethod_do(paramar.action);
      if (paramString != null)
      {
        paramString = n.j(paramString, ",", ";", false);
        paramar = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramar = "";
      }
      localbd.iZ(paramar);
      paramar = k.vkd;
      localbd.dp(s.as(localbd.ach(), vkj));
      localbd.dq(vkL.action);
      paramar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localbd.ja(n.j(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apM(sBN), ",", ";", false));
      paramar = vlb;
      if (paramar != null)
      {
        paramString = n.j(paramar, ",", ";", false);
        paramar = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramar = "";
      }
      localbd.jb(paramar);
      localbd.bfK();
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, liveId=" + localbd.ace() + ", feedId=" + localbd.acf() + ", username=" + localbd.getUserName() + ", topic=" + localbd.acg() + ", commentScene=" + localbd.ach() + ", isPrivate=" + localbd.aci() + ", contextId=" + localbd.acj() + ", clickTabContextId=" + localbd.ack() + ", sessionId=" + localbd.acl() + ", sessionBuffer=" + localbd.getSessionBuffer() + ", shopPermit=" + localbd.acm() + ", enterSessionId=" + localbd.acn() + ", liveTime=" + localbd.aco() + ", floatDuration=" + localbd.acq() + ", fullDuration=" + localbd.acp() + ", enterStatus=" + localbd.acr() + ", actionTS=" + localbd.acs() + ", action=" + localbd.act() + ", enterIconType=" + localbd.acv() + ", pageType=" + localbd.acw() + ", adData=" + localbd.acx() + ", scenenote=" + localbd.acy() + ", actionResult=" + localbd.acu());
      AppMethodBeat.o(251001);
      return;
      bool1 = false;
      break;
      label914:
      bool2 = false;
      break label268;
      label920:
      if (bool1)
      {
        localObject = s.an.vqU;
        break label283;
      }
      localObject = s.an.vqT;
      break label283;
      label941:
      paramLong = 0L;
      break label323;
      label946:
      if (vkC > 0L)
      {
        l4 = l2 - vkC;
        if (l4 > 0L) {
          l1 = l4;
        }
        l1 += paramLong;
        paramLong = l3;
      }
      else
      {
        label985:
        l1 = paramLong;
        paramLong = l3;
      }
    }
  }
  
  public static void a(s.as paramas)
  {
    AppMethodBeat.i(250995);
    p.h(paramas, "action");
    a(s.ar.vrv, String.valueOf(paramas.action));
    AppMethodBeat.o(250995);
  }
  
  public static void a(s.au paramau, String paramString1, String paramString2)
  {
    AppMethodBeat.i(250994);
    p.h(paramau, "action");
    if (paramau == s.au.vrQ) {
      if (vkI)
      {
        AppMethodBeat.o(250994);
        return;
      }
    }
    for (vkI = true;; vkI = false) {
      do
      {
        i locali = new i();
        locali.U("commerceAction", paramau.action);
        if (!org.apache.commons.b.g.eP(paramString1)) {
          locali.h("session", paramString1);
        }
        if (!org.apache.commons.b.g.eP(paramString2)) {
          locali.h("productid", paramString2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        locali.h("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOO());
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        locali.h("appid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOP());
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        locali.h("liveid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOQ());
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        locali.h("shopwindowid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOR());
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        locali.h("sessionid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOS());
        locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apE("");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apF("");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apG("");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apH("");
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apI("");
        a(s.ar.vrt, locali.toString());
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportCommerceAction, action=" + paramau.name() + ", shopSessionId=" + paramString1 + ", productId=" + paramString2);
        if (((paramau == s.au.vrR) || (paramau == s.au.vrU) || (paramau == s.au.vrV)) && (paramString2 != null) && (!vks.contains(paramString2))) {
          vks.add(paramString2);
        }
        if ((paramau == s.au.vrU) || (paramau == s.au.vrT)) {
          vkH = true;
        }
        AppMethodBeat.o(250994);
        return;
      } while ((paramau != s.au.vrX) && (paramau != s.au.vrY));
    }
  }
  
  public static void a(s.aw paramaw, String paramString, int paramInt)
  {
    AppMethodBeat.i(250999);
    p.h(paramaw, "type");
    long l = System.currentTimeMillis();
    switch (n.vlk[paramaw.ordinal()])
    {
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramaw.type);
      localJSONObject.put("giftid", paramString);
      localJSONObject.put("num", paramInt);
      a(s.ar.vrA, localJSONObject.toString(), l);
      AppMethodBeat.o(250999);
      return;
      if (paramInt == 0)
      {
        if (vlh)
        {
          AppMethodBeat.o(250999);
          return;
        }
        vlh = true;
      }
      else
      {
        AppMethodBeat.o(250999);
        return;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx = l;
        vla += paramInt;
        continue;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw = String.valueOf(enterTime);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx = l;
      }
    }
  }
  
  public static void a(s.ax paramax, s.z paramz, int paramInt)
  {
    AppMethodBeat.i(250996);
    p.h(paramax, "action");
    p.h(paramz, "linkeType");
    switch (n.vkf[paramax.ordinal()])
    {
    }
    label401:
    do
    {
      for (;;)
      {
        a(s.ar.vrB, String.valueOf(paramax.action));
        AppMethodBeat.o(250996);
        return;
        if (paramInt == 0)
        {
          if (vle)
          {
            AppMethodBeat.o(250996);
            return;
          }
          vle = true;
        }
        else
        {
          AppMethodBeat.o(250996);
          return;
          AppMethodBeat.o(250996);
          return;
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLinkMic, action=" + paramax.name() + ", gLinkMicTimeList=" + vkW.size() + ", activeCloselinkMic=" + vkX);
          vkY = false;
          paramInt = vkW.size() - 1;
          for (;;)
          {
            d locald;
            s.z localz;
            if (paramInt >= 0)
            {
              paramz = vkW.get(paramInt);
              p.g(paramz, "gLinkMicTimeList[i]");
              locald = (d)paramz;
              localz = (s.z)locald.hdM();
              switch (n.vll[paramax.ordinal()])
              {
              default: 
                paramz = s.z.vpF;
              }
            }
            while ((localz == paramz) && (((Number)locald.hdN()).longValue() > 0L) && (p.j((Boolean)locald.hdO(), Boolean.FALSE)))
            {
              long l = System.currentTimeMillis();
              paramz = locald.hdN();
              p.g(paramz, "tuple.`$2`()");
              l = (l - ((Number)paramz).longValue()) / 1000L;
              if (l < 0L) {
                break;
              }
              vkW.set(paramInt, com.tencent.mm.vending.j.a.i(locald.hdM(), Long.valueOf(l), Boolean.TRUE));
              if (vkX) {
                break label401;
              }
              AppMethodBeat.o(250996);
              return;
              paramz = s.z.vpG;
              continue;
              paramz = s.z.vpH;
            }
            paramInt -= 1;
          }
          vkX = false;
          continue;
          vkT += 1;
          continue;
          vkY = true;
          vkU += 1;
          if (paramz != s.z.vpF) {
            vkZ = paramz;
          }
          vkW.add(com.tencent.mm.vending.j.a.i(vkZ, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
        }
      }
    } while (!vkY);
    AppMethodBeat.o(250996);
  }
  
  public static void a(s.ay paramay, String paramString)
  {
    AppMethodBeat.i(250998);
    p.h(paramay, "type");
    switch (n.vlj[paramay.ordinal()])
    {
    default: 
      Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLettery ERROR: " + paramay.name());
    case 1: 
      for (;;)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", paramay.type);
        paramay = paramString;
        if (paramString == null) {
          paramay = "";
        }
        ((JSONObject)localObject).put("result", paramay);
        a(s.ar.vrz, ((JSONObject)localObject).toString());
        AppMethodBeat.o(250998);
        return;
        vlf = false;
        vlg = "";
      }
    case 2: 
      vlf = true;
      if (paramString != null) {
        break;
      }
    }
    for (Object localObject = "";; localObject = paramString)
    {
      vlg = (String)localObject;
      break;
      if ((vlf) && (!TextUtils.isEmpty((CharSequence)vlg)))
      {
        paramString = vlg;
        break;
      }
      AppMethodBeat.o(250998);
      return;
      vkQ += 1;
      break;
      vkR = true;
      break;
    }
  }
  
  public static void a(s.az paramaz, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(251004);
    p.h(paramaz, "action");
    if (s.az.vsW == paramaz) {
      com.tencent.mm.plugin.expt.hellhound.a.lX(true);
    }
    cr localcr = new cr();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localcr.ne(str);
    str = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localcr.nf(paramString1);
    localcr.hL(System.currentTimeMillis());
    localcr.hM(paramaz.action);
    localcr.ng(b.zs(paramLong));
    localcr.aeh();
    paramaz = paramString2;
    if (paramString2 == null) {
      paramaz = "";
    }
    localcr.nh(paramaz);
    paramString1 = b.cND();
    paramaz = paramString1;
    if (paramString1 == null) {
      paramaz = "";
    }
    localcr.ni(paramaz);
    paramString1 = b.cNB();
    paramaz = paramString1;
    if (paramString1 == null) {
      paramaz = "";
    }
    localcr.nj(paramaz);
    paramaz = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    localcr.nk(n.j(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apM(localcr.aef()), ",", ";", false));
    paramaz = vlb;
    if (paramaz != null)
    {
      paramString1 = n.j(paramaz, ",", ";", false);
      paramaz = paramString1;
      if (paramString1 != null) {}
    }
    else
    {
      paramaz = "";
    }
    localcr.nl(paramaz);
    localcr.bfK();
    Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21158, finderUsrName=" + localcr.aef() + ", finderSessionId=" + localcr.acJ() + ", actionTimeMs=" + localcr.acK() + ", actionType=" + localcr.acL() + ", enterLiveId=" + localcr.aeg() + ", enterStatus=" + localcr.acr() + ", commentscene=" + localcr.aei() + ", contextid=" + localcr.aej() + ", adData=" + localcr.acx() + ", scenenote=" + localcr.acy() + ", clickTabContextId=" + localcr.ack());
    AppMethodBeat.o(251004);
  }
  
  public static void a(s.h paramh)
  {
    AppMethodBeat.i(250993);
    p.h(paramh, "action");
    a(s.ar.vrp, String.valueOf(paramh.action));
    if (paramh != s.h.vnG) {
      vkt += 1;
    }
    AppMethodBeat.o(250993);
  }
  
  public static void a(s.n paramn)
  {
    AppMethodBeat.i(250984);
    p.h(paramn, "<set-?>");
    vkJ = paramn;
    AppMethodBeat.o(250984);
  }
  
  public static void a(Integer paramInteger, int paramInt, s.al paramal)
  {
    int i = 1;
    AppMethodBeat.i(250986);
    p.h(paramal, "event");
    com.tencent.mm.plugin.finder.utils.m localm = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP())
    {
      AppMethodBeat.o(250986);
      return;
    }
    KK(paramInt);
    if (vld)
    {
      vld = false;
      AppMethodBeat.o(250986);
      return;
    }
    if (paramInteger == null)
    {
      AppMethodBeat.o(250986);
      return;
    }
    if (paramInteger.intValue() == 0)
    {
      paramInt = i;
      switch (n.$EnumSwitchMapping$0[paramal.ordinal()])
      {
      default: 
        paramInteger = new kotlin.m();
        AppMethodBeat.o(250986);
        throw paramInteger;
      case 3: 
        paramInt = 0;
      }
      if (paramInt != 0) {
        a(s.ar.vrw, "");
      }
    }
    AppMethodBeat.o(250986);
  }
  
  public static void a(String paramString, s.ba paramba)
  {
    AppMethodBeat.i(250990);
    p.h(paramba, "type");
    i locali = new i();
    if (!org.apache.commons.b.g.eP(paramString)) {
      locali.h("username", paramString);
    }
    locali.U("type", paramba.type);
    if (paramba == s.ba.vta)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apr(null);
    }
    a(s.ar.vro, locali.toString());
    if (paramba == s.ba.vsY)
    {
      if ((paramString != null) && (n.a((CharSequence)paramString, (CharSequence)"@chatroom", false) == true))
      {
        vkr += 1;
        AppMethodBeat.o(250990);
        return;
      }
      vkq += 1;
      AppMethodBeat.o(250990);
      return;
    }
    if (paramba == s.ba.vsZ) {
      vkp += 1;
    }
    AppMethodBeat.o(250990);
  }
  
  public static void a(String paramString, s.k paramk)
  {
    AppMethodBeat.i(250992);
    p.h(paramk, "source");
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localJSONObject.put("username", str);
    localJSONObject.put("source", paramk.source);
    a(s.ar.vrl, localJSONObject.toString());
    vkw += 1;
    AppMethodBeat.o(250992);
  }
  
  public static void a(boolean paramBoolean, s.r paramr)
  {
    AppMethodBeat.i(250989);
    p.h(paramr, "floatType");
    if (paramr == s.r.voW) {
      vkR = false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    long l3;
    s.r localr;
    if (paramBoolean)
    {
      if (vkG)
      {
        AppMethodBeat.o(250989);
        return;
      }
      if (vkC > 0L)
      {
        l1 = l2 - vkC;
        l3 = vkE;
        if (l1 > 0L)
        {
          vkE = l1 + l3;
          vkC = 0L;
        }
      }
      else
      {
        vkD = l2;
        vkG = true;
        vko += 1;
        if (paramr != s.r.voV) {
          break label252;
        }
        if (!com.tencent.mm.plugin.expt.hellhound.a.syQ) {
          break label226;
        }
        localr = s.r.vpa;
      }
    }
    for (;;)
    {
      if (vkK)
      {
        localr = s.r.vpb;
        vkK = false;
      }
      a(s.ar.vrn, String.valueOf(localr.type));
      AppMethodBeat.o(250989);
      return;
      l1 = 0L;
      break;
      if (!vkG)
      {
        AppMethodBeat.o(250989);
        return;
      }
      if (vkD > 0L)
      {
        l1 = l2 - vkD;
        l3 = vkF;
        if (l1 <= 0L) {
          break label221;
        }
      }
      for (;;)
      {
        vkF = l1 + l3;
        vkD = 0L;
        vkC = l2;
        vkG = false;
        break;
        label221:
        l1 = 0L;
      }
      label226:
      if (vkH)
      {
        localr = s.r.voZ;
        vkH = false;
      }
      else
      {
        localr = s.r.voY;
        continue;
        label252:
        localr = paramr;
        if (paramr == s.r.voW)
        {
          vkH = false;
          localr = paramr;
        }
      }
    }
  }
  
  public static long ahy()
  {
    return enterTime;
  }
  
  public static void auP(String paramString)
  {
    AppMethodBeat.i(250985);
    p.h(paramString, "<set-?>");
    vlb = paramString;
    AppMethodBeat.o(250985);
  }
  
  private static void b(s.at paramat)
  {
    long l1 = 0L;
    AppMethodBeat.i(251003);
    if (vkJ == s.n.voq)
    {
      Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, LIVE_STOPPED, do need to report !");
      AppMethodBeat.o(251003);
      return;
    }
    long l4 = System.currentTimeMillis();
    co localco = new co();
    localco.mE(b.zs(liveId));
    localco.mF(b.zs(feedId));
    localco.mG(sBN);
    localco.mH(URLEncoder.encode(vkh, "UTF-8"));
    localco.gP(enterTime);
    long l2 = enterTime - vkg;
    label143:
    label166:
    long l3;
    if (l2 > 0L)
    {
      localco.gQ(l2);
      l2 = l4 - vkg;
      if (l2 <= 0L) {
        break label1411;
      }
      localco.gR(l2);
      l2 = l4 - enterTime;
      if (l2 <= 0L) {
        break label1417;
      }
      localco.gS(l2);
      l2 = vkF;
      l3 = vkE;
      if (!vkG) {
        break label1423;
      }
      if (vkD <= 0L) {
        break label1663;
      }
      l3 = l4 - vkD;
      if (l3 > 0L) {
        l1 = l3;
      }
      l2 = l1 + l2;
      l1 = localco.getDuration() - l2;
    }
    for (;;)
    {
      label231:
      localco.gT(l2);
      localco.gU(l1);
      localco.gV(vkJ.jii);
      localco.gW(vkm);
      localco.adp();
      localco.adr();
      localco.gX(vkn);
      localco.adu();
      localco.gY(vks.size());
      localco.gZ(vkt);
      localco.ha(vko);
      localco.hb(vkp);
      localco.hc(vkq);
      localco.hd(vkr);
      localco.he(vku);
      localco.hf(vkv);
      localco.hg(vkw);
      localco.hh(vkx);
      localco.hi(vky);
      localco.hj(vkz);
      if (vkB) {}
      for (l1 = s.bb.vtd.state;; l1 = s.bb.vtc.state)
      {
        localco.hm(l1);
        localco.hk(paramat.type);
        localObject1 = b.cND();
        paramat = (s.at)localObject1;
        if (localObject1 == null) {
          paramat = "";
        }
        localco.mI(paramat);
        localObject1 = b.cNB();
        paramat = (s.at)localObject1;
        if (localObject1 == null) {
          paramat = "";
        }
        localco.mJ(paramat);
        localco.mK(n.j(sessionBuffer, ",", ";", false));
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        paramat = (s.at)localObject1;
        if (localObject1 == null) {
          paramat = "";
        }
        localco.mL(paramat);
        localco.hl(vkk);
        localco.mM(vki);
        paramat = k.vkd;
        localco.hn(s.as(localco.ach(), vkj));
        localco.ho(vkM);
        localco.hp(vkN);
        localco.hq(vkO);
        localco.hr(vkP);
        localco.hs(vkA);
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localco.mN(n.j(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apM(sBN), ",", ";", false));
        localco.ht(vkQ);
        localco.hu(vkT);
        localco.hv(vkU);
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localco.hx(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK());
        localco.hw(vla);
        if (!vkW.isEmpty()) {
          break label1477;
        }
        localco.mO("");
        paramat = vlb;
        if (paramat != null)
        {
          localObject1 = n.j(paramat, ",", ";", false);
          paramat = (s.at)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramat = "";
        }
        localco.mP(paramat);
        localco.bfK();
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, duration=" + localco.getDuration() + ", floatDuration=" + localco.acq() + ", fullDuration=" + localco.acp() + ", diffTime=" + (localco.acp() + localco.acq() - localco.getDuration()) + ", commentScene=" + localco.ach() + ", pressLikeCount=" + localco.ads() + ", enterStatus=" + localco.acr() + ", acclaimCount=" + localco.adv() + ", clickLikeCount=" + localco.adq() + ", goodsClickCount=" + localco.adw() + ", floatingCount=" + localco.adx() + ", shareMoments=" + localco.ady() + ", singleChat=" + localco.adz() + ", groupChat=" + localco.adA() + ", profileCount=" + localco.adB() + ", complainAnchor=" + localco.adC() + ", complainAudience=" + localco.adD() + ", forbidden=" + localco.adE() + ", enterFollow=" + localco.adF() + ", exitFollow=" + localco.adG() + ", exitType=" + localco.adH() + ", contextId=" + localco.acj() + ", clickTabContextId=" + localco.ack() + ", sessionBuffer=" + localco.getSessionBuffer() + ", sessionID=" + localco.acl() + ", isPrivate=" + localco.aci() + ", shopExp=" + localco.adI() + ", enterIconType=" + localco.acv() + ", clickToLandscape=" + localco.adJ() + ", clickToPortrait=" + localco.adL() + ", rotateToLandscape=" + localco.adK() + ", rotateToPortrait=" + localco.adM() + ", lotteryCount=" + localco.adO() + ", adData=" + localco.acx() + ", commentsCount=" + localco.ado() + ", replycount=" + localco.adN() + ", tryToConnectCount=" + localco.adP() + ", connectSuccessCount=" + localco.adQ() + ", connectDuration=" + localco.adR() + ", giftCount=" + localco.adS() + ", scenenote=" + localco.acy() + "shareToStatus=" + localco.adT() + "emojiCount=" + localco.adt());
        AppMethodBeat.o(251003);
        return;
        l2 = 0L;
        break;
        label1411:
        l2 = 0L;
        break label143;
        label1417:
        l2 = 0L;
        break label166;
        label1423:
        if (vkC <= 0L) {
          break label1663;
        }
        l2 = l4 - vkC;
        if (l2 > 0L) {
          l1 = l2;
        }
        l1 = l3 + l1;
        l2 = localco.getDuration() - l1;
        break label231;
      }
      label1477:
      paramat = "";
      Object localObject1 = vkW.iterator();
      label1488:
      if (((Iterator)localObject1).hasNext())
      {
        d locald = (d)((Iterator)localObject1).next();
        Object localObject2 = locald.hdO();
        p.g(localObject2, "tuple.`$3`()");
        if (!((Boolean)localObject2).booleanValue()) {
          break label1660;
        }
        paramat = paramat + ((s.z)locald.hdM()).type + '|' + (Long)locald.hdN() + ';';
      }
      label1660:
      for (;;)
      {
        break label1488;
        localObject1 = paramat;
        if ((p.j(paramat, "") ^ true))
        {
          int i = paramat.length();
          if (paramat == null)
          {
            paramat = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251003);
            throw paramat;
          }
          localObject1 = paramat.substring(0, i - 1);
          p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        localco.mO((String)localObject1);
        break;
      }
      label1663:
      l1 = l3;
    }
  }
  
  public static void dpm()
  {
    vkB = true;
  }
  
  public static boolean dpn()
  {
    return vkR;
  }
  
  public static void dpo()
  {
    AppMethodBeat.i(250991);
    vkx += 1;
    Log.d("HABBYGE-MALI.HellLiveVisitorReoprter", "HABBYGE-MALI, setForbidden: " + vkx);
    AppMethodBeat.o(250991);
  }
  
  public static void ou(boolean paramBoolean)
  {
    vkX = paramBoolean;
  }
  
  public final void a(s.at paramat)
  {
    AppMethodBeat.i(250988);
    p.h(paramat, "type");
    if (!vkS)
    {
      AppMethodBeat.o(250988);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    int i;
    if (com.tencent.mm.plugin.finder.api.c.a.asJ(sBN))
    {
      i = s.s.vpf.state;
      vkz = i;
      vkS = false;
      switch (n.vke[paramat.ordinal()])
      {
      default: 
        if (vkY)
        {
          vkX = false;
          localObject = vkZ;
          switch (n.uqL[localObject.ordinal()])
          {
          default: 
            localObject = s.ax.vsw;
          }
        }
        break;
      }
    }
    for (;;)
    {
      a(this, (s.ax)localObject, null, 6);
      do
      {
        a(s.ar.vru, String.valueOf(paramat.type));
        b(paramat);
        vkJ = s.n.voq;
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apL(sBN))
        {
          paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cPl();
        }
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.mh(false);
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apC("");
        vkY = false;
        vkZ = s.z.vpH;
        vkW.clear();
        vkV = "";
        vkT = 0;
        vkU = 0;
        vla = 0;
        vlh = false;
        vle = false;
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apr(null);
        paramat = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.Hf(0);
        AppMethodBeat.o(250988);
        return;
        i = s.s.vpe.state;
        break;
      } while (!vkY);
      vkX = true;
      localObject = vkZ;
      switch (n.haE[localObject.ordinal()])
      {
      default: 
        localObject = s.ax.vsw;
      }
      for (;;)
      {
        a(this, (s.ax)localObject, null, 6);
        break;
        localObject = s.ax.vsE;
        continue;
        localObject = s.ax.vsD;
      }
      localObject = s.ax.vsE;
      continue;
      localObject = s.ax.vsD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.m
 * JD-Core Version:    0.7.0.1
 */
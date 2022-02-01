package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveStatisticsReport;", "", "()V", "ANCHOR_POST_FAIL", "", "getANCHOR_POST_FAIL", "()I", "CLOSE_LIVE", "", "getCLOSE_LIVE", "()Ljava/lang/String;", "CREATE_LIVE", "getCREATE_LIVE", "ENTER_ROOM", "getENTER_ROOM", "FACE_VERIFY", "getFACE_VERIFY", "JOIN_LIVE", "getJOIN_LIVE", "MANUAL_CLOSE_LIVE", "getMANUAL_CLOSE_LIVE", "MAX_REPORT_FREQUENCY", "MAX_REPORT_TIMES", "POST", "getPOST", "PRODUCT_DELETE", "getPRODUCT_DELETE", "PRODUCT_LIST", "getPRODUCT_LIST", "PRODUCT_MODIFY", "getPRODUCT_MODIFY", "PRODUCT_PROMOTING", "getPRODUCT_PROMOTING", "ROLE_ANCHOR", "ROLE_VISITOR", "SET_COMMENT", "getSET_COMMENT", "SHARE_LIVE", "getSHARE_LIVE", "TAG", "anchorPostTime", "", "anchorShareLiveTime", "curNetworkQuality", "enterRoomTime", "joinLiveTime", "lastReportTime", "liveCallbackEvent", "liveCgiErrorCode", "liveCgiEvent", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "reportTimes", "anchorCgiErrorReport", "", "cgiEvent", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "extra", "anchorLiveStatusChangeReport", "liveEventCode", "param", "Landroid/os/Bundle;", "anchorStatisticsReport", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "liveStates", "uiStates", "statistics", "liveEventSubCode", "liveEventMsg", "snn", "liveid", "networkQuality", "getLiveCoreNetQuality", "getLiveCoreNetType", "printMsg", "msg", "reset", "setEnterRoomTime", "setJoinLiveTime", "setLiveAnchorCore", "setPostTime", "setShareLiveTime", "plugin-finder_release"})
public final class aq
{
  private static final int AIA = 100;
  public static long AIB = 0L;
  public static long AIC = 0L;
  public static long AID = 0L;
  public static long AIE = 0L;
  public static int AIF = 0;
  public static String AIG;
  public static int AIH = 0;
  public static int AII = 0;
  public static final aq AIJ;
  private static final int AIj = 1001;
  private static final String AIk = "post";
  private static final String AIl = "createLive";
  private static final String AIm = "faceVerify";
  private static final String AIn = "joinLive";
  private static final String AIo = "enterRoom";
  private static final String AIp = "shareLive";
  private static final String AIq = "closeLive";
  private static final String AIr = "manualCloseLive";
  private static final String AIs = "setComment";
  private static final String AIt = "productList";
  private static final String AIu = "productPromoting";
  private static final String AIv = "productDelete";
  private static final String AIw = "productModify";
  private static final int AIx = 1;
  private static final int AIy = 2;
  private static final int AIz;
  private static final String TAG = "Finder.LiveStatisticsReport";
  public static int curNetworkQuality;
  public static b kDk;
  public static long lastReportTime;
  
  static
  {
    AppMethodBeat.i(253706);
    AIJ = new aq();
    AIj = 1001;
    TAG = "Finder.LiveStatisticsReport";
    AIk = "post";
    AIl = "createLive";
    AIm = "faceVerify";
    AIn = "joinLive";
    AIo = "enterRoom";
    AIp = "shareLive";
    AIq = "closeLive";
    AIr = "manualCloseLive";
    AIs = "setComment";
    AIt = "productList";
    AIu = "productPromoting";
    AIv = "productDelete";
    AIw = "productModify";
    AIx = 1;
    AIy = 2;
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    AIz = com.tencent.c.a.a.a.a.a.imT();
    AIA = 100;
    AIG = "";
    localObject = e.m.kkI;
    curNetworkQuality = e.m.aKH();
    AppMethodBeat.o(253706);
  }
  
  public static void Nl(long paramLong)
  {
    AIB = paramLong;
  }
  
  public static void Nm(long paramLong)
  {
    AIC = paramLong;
  }
  
  public static void Nn(long paramLong)
  {
    AID = paramLong;
  }
  
  public static void No(long paramLong)
  {
    AIE = paramLong;
  }
  
  public static void aGa(String paramString)
  {
    AppMethodBeat.i(253702);
    Log.i(TAG, paramString);
    AppMethodBeat.o(253702);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, String paramString)
  {
    AppMethodBeat.i(253701);
    p.k(parama, "liveRoomData");
    p.k(paramString, "extra");
    AppMethodBeat.o(253701);
  }
  
  public static int efI()
  {
    return AIj;
  }
  
  public static String efJ()
  {
    return AIk;
  }
  
  public static String efK()
  {
    return AIl;
  }
  
  public static String efL()
  {
    return AIm;
  }
  
  public static String efM()
  {
    return AIn;
  }
  
  public static String efN()
  {
    return AIo;
  }
  
  public static String efO()
  {
    return AIp;
  }
  
  public static String efP()
  {
    return AIq;
  }
  
  public static String efQ()
  {
    return AIr;
  }
  
  public static String efR()
  {
    return AIs;
  }
  
  public static String efS()
  {
    return AIt;
  }
  
  public static String efT()
  {
    return AIu;
  }
  
  public static void f(b paramb)
  {
    AppMethodBeat.i(253696);
    p.k(paramb, "liveCore");
    kDk = paramb;
    AppMethodBeat.o(253696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aq
 * JD-Core Version:    0.7.0.1
 */
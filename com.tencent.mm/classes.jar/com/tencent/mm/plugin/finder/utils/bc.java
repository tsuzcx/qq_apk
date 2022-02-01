package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveStatisticsReport;", "", "()V", "ANCHOR_POST_FAIL", "", "getANCHOR_POST_FAIL", "()I", "CLOSE_LIVE", "", "getCLOSE_LIVE", "()Ljava/lang/String;", "CREATE_LIVE", "getCREATE_LIVE", "ENTER_ROOM", "getENTER_ROOM", "FACE_VERIFY", "getFACE_VERIFY", "JOIN_LIVE", "getJOIN_LIVE", "MANUAL_CLOSE_LIVE", "getMANUAL_CLOSE_LIVE", "MAX_REPORT_FREQUENCY", "MAX_REPORT_TIMES", "POST", "getPOST", "PRODUCT_DELETE", "getPRODUCT_DELETE", "PRODUCT_LIST", "getPRODUCT_LIST", "PRODUCT_MODIFY", "getPRODUCT_MODIFY", "PRODUCT_PROMOTING", "getPRODUCT_PROMOTING", "ROLE_ANCHOR", "ROLE_VISITOR", "SET_COMMENT", "getSET_COMMENT", "SHARE_LIVE", "getSHARE_LIVE", "TAG", "anchorPostTime", "", "anchorShareLiveTime", "curNetworkQuality", "enterRoomTime", "joinLiveTime", "lastReportTime", "liveCallbackEvent", "liveCgiErrorCode", "liveCgiEvent", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "reportTimes", "anchorCgiErrorReport", "", "cgiEvent", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "extra", "anchorLiveStatusChangeReport", "liveEventCode", "param", "Landroid/os/Bundle;", "anchorStatisticsReport", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "liveStates", "uiStates", "statistics", "liveEventSubCode", "liveEventMsg", "snn", "liveid", "networkQuality", "getLiveCoreNetQuality", "getLiveCoreNetType", "printMsg", "msg", "reset", "setEnterRoomTime", "setJoinLiveTime", "setLiveAnchorCore", "setPostTime", "setShareLiveTime", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
{
  public static final bc GkH;
  private static final int GkI;
  private static final String GkJ;
  private static final String GkK;
  private static final String GkL;
  private static final String GkM;
  private static final String GkN;
  private static final String GkO;
  private static final String GkP;
  private static final String GkQ;
  private static final String GkR;
  private static final String GkS;
  private static final String GkT;
  private static final String GkU;
  private static final String GkV;
  private static final int GkW;
  private static final int GkX;
  private static final int GkY;
  private static final int GkZ;
  public static long Gla;
  public static long Glb;
  public static long Glc;
  public static long Gld;
  public static int Gle;
  public static String Glf;
  public static int Glg;
  public static int Glh;
  private static final String TAG;
  public static int curNetworkQuality;
  public static long lastReportTime;
  public static b ngB;
  
  static
  {
    AppMethodBeat.i(333218);
    GkH = new bc();
    GkI = 1001;
    TAG = "Finder.LiveStatisticsReport";
    GkJ = "post";
    GkK = "createLive";
    GkL = "faceVerify";
    GkM = "joinLive";
    GkN = "enterRoom";
    GkO = "shareLive";
    GkP = "closeLive";
    GkQ = "manualCloseLive";
    GkR = "setComment";
    GkS = "productList";
    GkT = "productPromoting";
    GkU = "productDelete";
    GkV = "productModify";
    GkW = 1;
    GkX = 2;
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    GkY = com.tencent.d.a.a.a.a.a.jTA();
    GkZ = 100;
    Glf = "";
    localObject = e.o.mLz;
    curNetworkQuality = e.o.bdD();
    AppMethodBeat.o(333218);
  }
  
  public static void aCb(String paramString)
  {
    AppMethodBeat.i(333208);
    Log.i(TAG, paramString);
    AppMethodBeat.o(333208);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, String paramString)
  {
    AppMethodBeat.i(333200);
    s.u(parama, "liveRoomData");
    s.u(paramString, "extra");
    AppMethodBeat.o(333200);
  }
  
  public static void f(b paramb)
  {
    AppMethodBeat.i(333158);
    s.u(paramb, "liveCore");
    ngB = paramb;
    AppMethodBeat.o(333158);
  }
  
  public static int fhF()
  {
    return GkI;
  }
  
  public static String fhG()
  {
    return GkJ;
  }
  
  public static String fhH()
  {
    return GkK;
  }
  
  public static String fhI()
  {
    return GkL;
  }
  
  public static String fhJ()
  {
    return GkM;
  }
  
  public static String fhK()
  {
    return GkN;
  }
  
  public static String fhL()
  {
    return GkO;
  }
  
  public static String fhM()
  {
    return GkP;
  }
  
  public static String fhN()
  {
    return GkQ;
  }
  
  public static String fhO()
  {
    return GkR;
  }
  
  public static String fhP()
  {
    return GkS;
  }
  
  public static String fhQ()
  {
    return GkT;
  }
  
  public static void qP(long paramLong)
  {
    Gla = paramLong;
  }
  
  public static void qQ(long paramLong)
  {
    Glb = paramLong;
  }
  
  public static void qR(long paramLong)
  {
    Glc = paramLong;
  }
  
  public static void qS(long paramLong)
  {
    Gld = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bc
 * JD-Core Version:    0.7.0.1
 */
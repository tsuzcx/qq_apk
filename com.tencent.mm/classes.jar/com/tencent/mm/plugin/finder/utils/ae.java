package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.trtc.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveStatisticsReport;", "", "()V", "ANCHOR_POST_FAIL", "", "getANCHOR_POST_FAIL", "()I", "CLOSE_LIVE", "", "getCLOSE_LIVE", "()Ljava/lang/String;", "CREATE_LIVE", "getCREATE_LIVE", "ENTER_ROOM", "getENTER_ROOM", "FACE_VERIFY", "getFACE_VERIFY", "JOIN_LIVE", "getJOIN_LIVE", "MANUAL_CLOSE_LIVE", "getMANUAL_CLOSE_LIVE", "MAX_REPORT_FREQUENCY", "MAX_REPORT_TIMES", "POST", "getPOST", "PRODUCT_DELETE", "getPRODUCT_DELETE", "PRODUCT_LIST", "getPRODUCT_LIST", "PRODUCT_MODIFY", "getPRODUCT_MODIFY", "PRODUCT_PROMOTING", "getPRODUCT_PROMOTING", "ROLE_ANCHOR", "ROLE_VISITOR", "SET_COMMENT", "getSET_COMMENT", "SHARE_LIVE", "getSHARE_LIVE", "TAG", "anchorPostTime", "", "anchorShareLiveTime", "curNetworkQuality", "enterRoomTime", "joinLiveTime", "lastReportTime", "liveCallbackEvent", "liveCgiErrorCode", "liveCgiEvent", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "reportTimes", "anchorCgiErrorReport", "", "cgiEvent", "cgiErrcode", "cgiErrtype", "cgiErrmsg", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "extra", "anchorLiveStatusChangeReport", "liveEventCode", "param", "Landroid/os/Bundle;", "anchorStatisticsReport", "liveRole", "shop", "prerenderType", "postTime", "shareLiveTime", "liveStates", "uiStates", "statistics", "liveEventSubCode", "liveEventMsg", "snn", "liveid", "networkQuality", "getLiveCoreNetQuality", "getLiveCoreNetType", "printMsg", "msg", "reset", "setEnterRoomTime", "setJoinLiveTime", "setLiveAnchorCore", "setPostTime", "setShareLiveTime", "plugin-finder_release"})
public final class ae
{
  private static final String TAG = "Finder.LiveStatisticsReport";
  public static int curNetworkQuality = 0;
  public static b hOO;
  public static long lastReportTime = 0L;
  private static final String vZA = "joinLive";
  private static final String vZB = "enterRoom";
  private static final String vZC = "shareLive";
  private static final String vZD = "closeLive";
  private static final String vZE = "manualCloseLive";
  private static final String vZF = "setComment";
  private static final String vZG = "productList";
  private static final String vZH = "productPromoting";
  private static final String vZI = "productDelete";
  private static final String vZJ = "productModify";
  private static final int vZK = 1;
  private static final int vZL = 2;
  private static final int vZM;
  private static final int vZN = 100;
  public static long vZO = 0L;
  public static long vZP = 0L;
  public static long vZQ = 0L;
  public static long vZR = 0L;
  public static int vZS = 0;
  public static String vZT;
  public static int vZU = 0;
  public static int vZV = 0;
  public static final ae vZW;
  private static final int vZw = 1001;
  private static final String vZx = "post";
  private static final String vZy = "createLive";
  private static final String vZz = "faceVerify";
  
  static
  {
    AppMethodBeat.i(253767);
    vZW = new ae();
    vZw = 1001;
    TAG = "Finder.LiveStatisticsReport";
    vZx = "post";
    vZy = "createLive";
    vZz = "faceVerify";
    vZA = "joinLive";
    vZB = "enterRoom";
    vZC = "shareLive";
    vZD = "closeLive";
    vZE = "manualCloseLive";
    vZF = "setComment";
    vZG = "productList";
    vZH = "productPromoting";
    vZI = "productDelete";
    vZJ = "productModify";
    vZK = 1;
    vZL = 2;
    Object localObject = c.vCb;
    vZM = c.dvf();
    vZN = 100;
    vZT = "";
    localObject = e.h.hya;
    curNetworkQuality = e.h.aCT();
    AppMethodBeat.o(253767);
  }
  
  public static void Gk(long paramLong)
  {
    vZO = paramLong;
  }
  
  public static void Gl(long paramLong)
  {
    vZP = paramLong;
  }
  
  public static void Gm(long paramLong)
  {
    vZQ = paramLong;
  }
  
  public static void Gn(long paramLong)
  {
    vZR = paramLong;
  }
  
  public static void a(int paramInt, com.tencent.mm.plugin.finder.live.viewmodel.g paramg, String paramString)
  {
    AppMethodBeat.i(253764);
    p.h(paramg, "liveRoomData");
    p.h(paramString, "extra");
    Object localObject1 = e.d.hxF;
    if ((paramInt != e.d.aCr()) && (paramInt == vZV))
    {
      paramg = "anchorStatisticsReport liveCallbackEvent:".concat(String.valueOf(paramInt));
      Log.i(TAG, paramg);
      AppMethodBeat.o(253764);
      return;
    }
    int i = dEl();
    localObject1 = e.d.hxF;
    if ((paramInt == e.d.aCr()) && (i == curNetworkQuality))
    {
      paramg = m.vVH;
      m.hd(TAG, "anchorStatisticsReport liveCallbackEvent:" + paramInt + ", curNetworkQuality:" + curNetworkQuality);
      AppMethodBeat.o(253764);
      return;
    }
    vZV = paramInt;
    curNetworkQuality = i;
    int j;
    label164:
    int k;
    label193:
    int m;
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    long l7;
    int n;
    int i1;
    Object localObject2;
    if (paramg.uit)
    {
      i = 1;
      localObject1 = h.ufY;
      if (!h.deW()) {
        break label384;
      }
      j = 1;
      localObject1 = hOO;
      if (localObject1 == null) {
        break label390;
      }
      localObject1 = ((a)localObject1).hAz;
      if (localObject1 == null) {
        break label390;
      }
      k = ((com.tencent.mm.live.core.core.b.g)localObject1).networkType;
      m = vZK;
      l1 = vZO;
      l2 = vZP;
      l3 = vZO;
      l4 = vZQ;
      l5 = vZO;
      l6 = vZR;
      l7 = vZO;
      n = paramg.uEg;
      i1 = paramg.uEf;
      localObject2 = paramg.uEs;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = paramg.uDz;
      if (localObject2 != null)
      {
        String str = ((FinderObject)localObject2).nickname;
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = z.aUa();
        p.g(localObject2, "ConfigStorageLogic.getNicknameFromUserInfo()");
      }
      paramg = paramg.liveInfo;
      if (paramg == null) {
        break label397;
      }
    }
    label384:
    label390:
    label397:
    for (paramg = Long.valueOf(paramg.liveId);; paramg = null)
    {
      b(m, i, j, l1, l2 - l3, l4 - l5, l6 - l7, n, i1, (String)localObject1, 0, 0, "", paramInt, k, "", paramString, (String)localObject2, paramg.longValue(), curNetworkQuality);
      AppMethodBeat.o(253764);
      return;
      i = 0;
      break;
      j = 0;
      break label164;
      k = -2;
      break label193;
    }
  }
  
  public static void awy(String paramString)
  {
    AppMethodBeat.i(258556);
    Log.i(TAG, paramString);
    AppMethodBeat.o(258556);
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, int paramInt8, int paramInt9, String paramString3, String paramString4, String paramString5, long paramLong5, long paramLong6)
  {
    AppMethodBeat.i(253765);
    if ((lastReportTime != 0L) && (cl.aWy() - lastReportTime < vZM))
    {
      paramString1 = "anchorStatisticsReport too fast,frequency:" + (cl.aWy() - lastReportTime) + '!';
      Log.i(TAG, paramString1);
      AppMethodBeat.o(253765);
      return;
    }
    if (vZS >= vZN)
    {
      Log.i(TAG, "anchorStatisticsReport too much times!");
      AppMethodBeat.o(253765);
      return;
    }
    if (paramLong1 == 0L)
    {
      paramLong1 = cl.aWy();
      vZO = paramLong1;
    }
    for (;;)
    {
      lastReportTime = cl.aWy();
      vZS += 1;
      k localk = k.vfA;
      k.a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3, paramLong4, paramInt4, paramInt5, paramString1, paramInt6, paramInt7, paramString2, paramInt8, paramInt9, paramString3, paramString4, paramString5, paramLong5, paramLong6);
      AppMethodBeat.o(253765);
      return;
    }
  }
  
  public static int dDZ()
  {
    return vZw;
  }
  
  public static String dEa()
  {
    return vZx;
  }
  
  public static String dEb()
  {
    return vZy;
  }
  
  public static String dEc()
  {
    return vZz;
  }
  
  public static String dEd()
  {
    return vZA;
  }
  
  public static String dEe()
  {
    return vZB;
  }
  
  public static String dEf()
  {
    return vZC;
  }
  
  public static String dEg()
  {
    return vZD;
  }
  
  public static String dEh()
  {
    return vZE;
  }
  
  public static String dEi()
  {
    return vZF;
  }
  
  public static String dEj()
  {
    return vZG;
  }
  
  public static String dEk()
  {
    return vZH;
  }
  
  private static int dEl()
  {
    Object localObject = hOO;
    if (localObject != null)
    {
      localObject = ((a)localObject).hAz;
      if (localObject != null) {
        return ((com.tencent.mm.live.core.core.b.g)localObject).hzL;
      }
    }
    return -1;
  }
  
  public static void e(b paramb)
  {
    AppMethodBeat.i(253762);
    p.h(paramb, "liveCore");
    hOO = paramb;
    AppMethodBeat.o(253762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ae
 * JD-Core Version:    0.7.0.1
 */
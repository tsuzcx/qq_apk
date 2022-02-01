package com.tencent.mm.plugin.finder.report;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.do;
import com.tencent.mm.autogen.mmdata.rpt.dp;
import com.tencent.mm.autogen.mmdata.rpt.dx;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter;", "", "()V", "CGI_TYPE_HISTORY", "", "CGI_TYPE_OTHER", "CGI_TYPE_STREAM", "CGI_TYPE_STREAM_AND_HISTORY", "FAIL_VALUE", "", "INNER_VERSION_20672", "LOADING_STATUS_FAIL", "LOADING_STATUS_FINISH_BY_USER", "LOADING_STATUS_SUCCESS", "TAG", "", "WAITING_TIME_OUT", "clickEnterTime", "enterFinderWithRedDot", "", "laterReportCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "loadingTimeConsumeDataMap", "recordStandingTimeMap", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabResumeTimeMap", "addCgiBackFeedCount", "", "tabType", "count", "applyClickEnterTime", "buildExtraInfoJson", "Lorg/json/JSONObject;", "data", "cacheLateReportData", "clearClickEnterTime", "genClickEnterTime", "getData", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isOutSideEnterFinderTabType", "isSupport20672TabType", "isSupportCgiReportTabType", "isSupportReportPullType", "pullType", "isSupportTabTabType", "notifyAppBackground", "notifyCgiEnd", "clear", "notifyDecodeStart", "notifyEnterLoad", "notifyFinishScene", "isChangeTab", "notifyFirstFeedShow", "notifyFirstPageData", "hasData", "notifyGetDetailCgi", "isBegin", "hasFeedId", "hasEncryptId", "notifyGetRelatedCgi", "notifyHistoryCgi", "notifyLoadingDisposed", "exposeTime", "notifyLoadingStatus", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstFeedIsPhoto", "notifyStreamCgi", "message", "Lcom/tencent/mm/protobuf/ByteString;", "profile", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "notifyUsePreloadCache", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPlay", "onTabResume", "prepare", "cgiType", "report20672and20713", "report21680", "json", "majorData", "reportCacheData", "reportFailed", "reportFinishByUser", "reportTimeConsumingIDKey", "TimeConsumeData", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  private static long EQt;
  private static final ConcurrentHashMap<Integer, a> EQy;
  private static final HashSet<a> EQz;
  public static final s Fqv;
  private static boolean Fqw;
  private static final ConcurrentHashMap<Integer, Long> Fqx;
  private static final ConcurrentHashMap<Integer, a> Fqy;
  private static final ConcurrentHashMap<a, Integer> Fqz;
  
  static
  {
    AppMethodBeat.i(331769);
    Fqv = new s();
    EQy = new ConcurrentHashMap();
    Fqx = new ConcurrentHashMap();
    Fqy = new ConcurrentHashMap();
    Fqz = new ConcurrentHashMap();
    EQz = new HashSet();
    AppMethodBeat.o(331769);
  }
  
  private static void F(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(331738);
    dx localdx = new dx();
    localdx.aIM();
    if (Sm(paramInt)) {}
    for (long l = 2L;; l = 1L)
    {
      localdx.ixD = l;
      localdx.nZ(paramString1);
      localdx.ob(paramString2);
      localdx.bMH();
      Log.i("Finder.FinderLoadingTimeReporter", kotlin.g.b.s.X("report21680 info:", localdx.aIF()));
      AppMethodBeat.o(331738);
      return;
    }
  }
  
  public static a Sk(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(331450);
    int i = j;
    if (paramInt != 4)
    {
      i = j;
      if (paramInt != 3)
      {
        i = j;
        if (paramInt != 1)
        {
          i = j;
          if (paramInt != 2)
          {
            i = j;
            if (paramInt != 6)
            {
              i = j;
              if (paramInt != 5)
              {
                i = j;
                if (paramInt != 7)
                {
                  i = j;
                  if (paramInt != 8) {
                    if (paramInt != 9) {
                      break label85;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label85:
    for (i = j; i == 0; i = 0)
    {
      AppMethodBeat.o(331450);
      return null;
    }
    a locala2 = (a)EQy.get(Integer.valueOf(paramInt));
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (!locala2.FqA) {}
    }
    else
    {
      locala1 = new a();
      locala1.hJx = paramInt;
      ((Map)EQy).put(Integer.valueOf(paramInt), locala1);
    }
    AppMethodBeat.o(331450);
    return locala1;
  }
  
  private static boolean Sl(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 5);
  }
  
  private static boolean Sm(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 5) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  private static boolean Sn(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1);
  }
  
  public static void So(int paramInt)
  {
    AppMethodBeat.i(331485);
    a locala = (a)Fqy.get(Integer.valueOf(paramInt));
    if (locala != null) {
      locala.FpW = cn.bDw();
    }
    AppMethodBeat.o(331485);
  }
  
  public static void Sp(int paramInt)
  {
    AppMethodBeat.i(331492);
    a locala = (a)Fqy.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.FpY = cn.bDw();
      if ((locala.FqT != 0L) || (locala.FqC <= 0L)) {
        break label82;
      }
      ((Map)Fqz).put(locala, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      Fqy.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(331492);
      return;
      label82:
      a(locala, paramInt);
    }
  }
  
  public static void Sq(int paramInt)
  {
    AppMethodBeat.i(331497);
    a locala = (a)Fqy.get(Integer.valueOf(paramInt));
    if (locala != null) {
      locala.FpX = cn.bDw();
    }
    AppMethodBeat.o(331497);
  }
  
  public static void Sr(int paramInt)
  {
    AppMethodBeat.i(331503);
    a locala = (a)Fqy.get(Integer.valueOf(paramInt));
    if (locala != null) {
      locala.FpU = cn.bDw();
    }
    AppMethodBeat.o(331503);
  }
  
  public static void Ss(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(331528);
    a locala = Sk(paramInt);
    Long localLong;
    long l1;
    if ((locala != null) && (EQt > 0L))
    {
      locala.FqC = EQt;
      localLong = (Long)Fqx.get(Integer.valueOf(paramInt));
      if (localLong != null) {
        break label122;
      }
      l1 = 0L;
      locala.FqD = l1;
      EQt = 0L;
      l1 = l2;
      if (locala.FqD > 0L) {
        l1 = locala.FqD - locala.FqC;
      }
      locala.EQK = l1;
      if (!Fqw) {
        break label131;
      }
    }
    label131:
    for (paramInt = 1;; paramInt = 0)
    {
      locala.Frb = paramInt;
      Fqw = false;
      AppMethodBeat.o(331528);
      return;
      label122:
      l1 = localLong.longValue();
      break;
    }
  }
  
  public static void St(int paramInt)
  {
    AppMethodBeat.i(331541);
    ((Map)Fqx).put(Integer.valueOf(paramInt), Long.valueOf(cn.bDw()));
    AppMethodBeat.o(331541);
  }
  
  public static void Su(int paramInt)
  {
    AppMethodBeat.i(331655);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((!locala.hS) || (locala.FqA) || (locala.Frj != 0)) {
        break label58;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label63;
      }
    }
    for (;;)
    {
      if (locala != null) {
        locala.Frd = 1;
      }
      AppMethodBeat.o(331655);
      return;
      label58:
      paramInt = 0;
      break;
      label63:
      locala = null;
    }
  }
  
  public static void Sv(int paramInt)
  {
    AppMethodBeat.i(331690);
    if (paramInt != -1)
    {
      localObject = (a)Fqy.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        a((a)localObject, paramInt);
      }
      Fqy.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(331690);
      return;
    }
    Object localObject = ((Map)Fqy).entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getValue(), ((Number)localEntry.getKey()).intValue());
    }
    Fqy.clear();
    localObject = ((Map)Fqz).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getKey(), ((Number)localEntry.getValue()).intValue());
    }
    Fqz.clear();
    AppMethodBeat.o(331690);
  }
  
  private static JSONObject a(a parama)
  {
    AppMethodBeat.i(331733);
    if ((parama.EQC > 0L) && (parama.EQD > 0L) && (parama.EQD > parama.EQC)) {
      parama.FqU = (parama.EQD - parama.EQC);
    }
    if ((parama.FqG > 0L) && (parama.FqH > 0L) && (parama.FqH > parama.FqG)) {
      parama.FqW = (parama.FqH - parama.FqG);
    }
    if ((parama.EQD > 0L) && (parama.FqG > 0L) && (parama.FqG > parama.EQD)) {
      parama.FqV = (parama.FqG - parama.EQD);
    }
    parama.FqX = (parama.FqU + parama.FqW + parama.FqV);
    long l1;
    long l4;
    label218:
    long l2;
    label257:
    int i;
    long l3;
    if ((parama.FqT == 0L) && (parama.FqC > 0L))
    {
      l1 = parama.FqJ - parama.FqC;
      parama.FqY = l1;
      if ((parama.FqI <= 0L) || (parama.FqI >= parama.FqJ)) {
        break label725;
      }
      l4 = parama.FqJ - parama.FqI;
      parama.Frl = parama.FqY;
      l2 = 0L;
      if (parama.FpY <= 0L) {
        break label750;
      }
      if (parama.FpW <= 0L) {
        break label731;
      }
      l1 = parama.FpY - parama.FpW;
      i = 1;
      l3 = cn.bDw() - parama.FpY;
      l2 = l3;
      if (l3 > 10000L)
      {
        i = 3;
        l2 = 10000L;
      }
      if ((parama.FqT != 0L) || (parama.FqC <= 0L)) {
        break label736;
      }
      l3 = parama.FpY - parama.FqC;
      label318:
      parama.Frl = l3;
      l3 = 0L;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enterCost", parama.EQK);
      localJSONObject.put("resumeToLoadingStartCost", parama.Frk);
      if (Sm(parama.hJx))
      {
        if (parama.FqO > 0L)
        {
          l1 = parama.FqO - parama.FqE;
          label391:
          localJSONObject.put("firstFeedShowCost", l1);
          if ((parama.FqL <= parama.FqK) || (parama.FqK <= 0L)) {
            break label831;
          }
          l1 = parama.FqL - parama.FqK;
          label432:
          localJSONObject.put("getDetailCost", l1);
          if ((parama.FqN <= parama.FqM) || (parama.FqM <= 0L)) {
            break label836;
          }
        }
        label831:
        label836:
        for (l1 = parama.FqN - parama.FqM;; l1 = 0L)
        {
          localJSONObject.put("getRelatedCost", l1);
          localJSONObject.put("cgiEndToLoadingEndCost", l4);
          localJSONObject.put("loadCost", parama.FqY);
          localJSONObject.put("loadCostWitchActivityCost", parama.FqJ - parama.FqE);
          localJSONObject.put("feedIdType", parama.Frf);
          localJSONObject.put("cgiBackFeedCount", parama.Fre);
          localJSONObject.put("finishStatus", parama.FqS);
          localJSONObject.put("commentScene", parama.FqQ);
          localJSONObject.put("tabType", parama.hJx);
          localJSONObject.put("pullType", parama.FqT);
          localJSONObject.put("api", Build.VERSION.SDK_INT);
          localJSONObject.put("hasBeenAppBackground", parama.Fri);
          if (parama.EQK > 0L)
          {
            localJSONObject.put("isEnterLoad", parama.Frj);
            com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            localJSONObject.put("finderEnterLoadSwitch", ((Number)com.tencent.mm.plugin.finder.storage.d.eVO().bmg()).intValue());
          }
          if ((parama.EQK > 0L) && (i == 3)) {
            com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 30L, 1L);
          }
          AppMethodBeat.o(331733);
          return localJSONObject;
          l1 = parama.FqJ - parama.FqE;
          break;
          label725:
          l4 = 0L;
          break label218;
          label731:
          l1 = 0L;
          break label257;
          label736:
          l3 = parama.FpY - parama.FqE;
          break label318;
          label750:
          if (parama.FpW <= 0L) {
            break label1108;
          }
          l3 = cn.bDw();
          long l5 = parama.FpW;
          if ((parama.FqT == 0L) && (parama.FqC > 0L)) {}
          for (l1 = l3 - parama.FqC;; l1 = l3 - parama.FqE)
          {
            parama.Frl = l1;
            l3 -= l5;
            i = 2;
            l1 = 0L;
            break;
          }
          l1 = 0L;
          break label391;
          l1 = 0L;
          break label432;
        }
      }
      localJSONObject.put("streamCost", parama.FqU);
      localJSONObject.put("spanCgiCost", parama.FqV);
      localJSONObject.put("historyCost", parama.FqW);
      localJSONObject.put("cgiAllCost", parama.FqX);
      localJSONObject.put("loadCost", parama.FqY);
      localJSONObject.put("cgiEndToLoadingEndCost", l4);
      localJSONObject.put("startDownloadTimeStamp", parama.FpW);
      localJSONObject.put("videoDecodeStartTimeStamp", parama.FpX);
      localJSONObject.put("firstFrameDrawTimeStamp", parama.FpY);
      localJSONObject.put("downLoadToFirstFrameDrawCost", l1);
      localJSONObject.put("downloadToExitCost", l3);
      localJSONObject.put("totalCost", parama.Frl);
      localJSONObject.put("firstFrameStatus", i);
      localJSONObject.put("standingMsAfterFirstFrame", l2);
      localJSONObject.put("exitStatus", parama.FqZ);
      localJSONObject.put("firstFeedIsPhoto", parama.Fra);
      localJSONObject.put("enterWithRedDot", parama.Frb);
      if (parama.EQK > 0L) {}
      for (int j = parama.Frc;; j = 0)
      {
        localJSONObject.put("enterWithFirstPageData", j);
        localJSONObject.put("cgiBackFeedCount", parama.Fre);
        localJSONObject.put("usePreloadCache", parama.Frd);
        break;
      }
      label1108:
      l3 = 0L;
      i = 0;
      l1 = 0L;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bui parambui, long paramLong)
  {
    a locala = null;
    AppMethodBeat.i(331474);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {}
    for (int i = 1; (i == 0) || (parambui == null); i = 0)
    {
      Log.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + paramInt1 + ", contextObj = " + parambui);
      AppMethodBeat.o(331474);
      return;
    }
    Object localObject1 = Sk(paramInt1);
    if (localObject1 != null)
    {
      if ((((a)localObject1).hS) && (!((a)localObject1).FqA))
      {
        i = 1;
        if (i == 0) {
          break label162;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if ((((a)localObject1).Frj == 1) && (!((a)localObject1).FqB) && (paramInt2 == 0))
          {
            Log.i("Finder.FinderLoadingTimeReporter", "prepare: remove duplicate enter report");
            AppMethodBeat.o(331474);
            return;
            i = 0;
            break;
            label162:
            localObject1 = null;
            continue;
          }
          if ((((a)localObject1).FqI != 0L) || (((a)localObject1).FqS != 2L)) {
            break label329;
          }
          i = 1;
          if (i == 0) {
            break label335;
          }
          localObject2 = localObject1;
          label202:
          if (localObject2 != null) {
            break label341;
          }
        }
      }
    }
    for (Object localObject2 = locala;; localObject2 = ah.aiuX)
    {
      if (localObject2 == null)
      {
        ((a)localObject1).FqA = true;
        a((a)localObject1, paramInt1);
      }
      locala = Sk(paramInt1);
      if (locala != null)
      {
        locala.hS = true;
        locala.FqT = paramInt2;
        localObject2 = parambui.sessionId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        locala.setSessionId((String)localObject1);
        localObject2 = parambui.zIB;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        locala.azJ((String)localObject1);
        locala.FqQ = parambui.AJo;
        locala.FqR = paramLong;
      }
      AppMethodBeat.o(331474);
      return;
      label329:
      i = 0;
      break;
      label335:
      localObject2 = null;
      break label202;
      label341:
      aM(paramInt1, false);
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, com.tencent.mm.bx.b paramb, yf paramyf)
  {
    AppMethodBeat.i(331578);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((locala.hS) && (!locala.FqA))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label88;
        }
        label39:
        if (locala == null) {
          break label122;
        }
        if (!paramBoolean) {
          break label102;
        }
        locala.EQC = cn.bDw();
        if (locala.FqR != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 1L;; l = 3L)
      {
        locala.FqR = l;
        AppMethodBeat.o(331578);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label102:
      locala.EQD = cn.bDw();
      locala.EQQ = paramyf;
      locala.EQI = paramb;
    }
    label122:
    AppMethodBeat.o(331578);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, bui parambui, boolean paramBoolean2)
  {
    long l2 = 0L;
    AppMethodBeat.i(331554);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((locala.hS) && (!locala.FqA))
      {
        i = 1;
        if (i == 0) {
          break label201;
        }
        label44:
        if (locala == null) {
          break label409;
        }
        if (parambui != null)
        {
          String str2 = parambui.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambui.zIB;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.azJ(str1);
          locala.FqQ = parambui.AJo;
        }
        if (!paramBoolean1) {
          break label276;
        }
        if ((locala.FqE <= 0L) || (locala.Frj != 1)) {
          break label213;
        }
        locala.FqF = cn.bDw();
        if ((locala.EQK <= 0L) || (locala.FqD <= 0L)) {
          break label207;
        }
      }
      label201:
      label207:
      for (long l1 = locala.FqF - locala.FqD;; l1 = 0L)
      {
        locala.Frk = l1;
        AppMethodBeat.o(331554);
        return;
        i = 0;
        break;
        locala = null;
        break label44;
      }
      label213:
      locala.FqE = cn.bDw();
      l1 = l2;
      if (locala.EQK > 0L)
      {
        l1 = l2;
        if (locala.FqD > 0L) {
          l1 = locala.FqE - locala.FqD;
        }
      }
      locala.Frk = l1;
      AppMethodBeat.o(331554);
      return;
      label276:
      locala.FqA = true;
      locala.FqJ = cn.bDw();
      locala.FqS = 1L;
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        locala.Fra = i;
        if (locala.Frg == 0)
        {
          locala.Frg = 1;
          locala.Frh = 1;
        }
        if (((paramInt != 4) && (paramInt != 3) && (paramInt != 1)) || (paramBoolean2)) {
          break;
        }
        parambui = (a)Fqy.get(Integer.valueOf(paramInt));
        if (parambui != null) {
          a(parambui, paramInt);
        }
        ((Map)Fqy).put(Integer.valueOf(paramInt), locala);
        AppMethodBeat.o(331554);
        return;
      }
      a(locala, paramInt);
    }
    label409:
    AppMethodBeat.o(331554);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(331712);
    Object localObject1 = new dp();
    ((dp)localObject1).nB(parama.sessionId);
    ((dp)localObject1).nC(parama.FqP);
    ((dp)localObject1).ipV = parama.FqQ;
    ((dp)localObject1).iAd = parama.FqR;
    long l2 = parama.FqJ;
    long l1;
    if (parama.Frj == 1)
    {
      l1 = parama.FqF;
      ((dp)localObject1).iAe = (l2 - l1);
      if (parama.Frd != 0) {
        break label302;
      }
      l1 = parama.FqE;
      label93:
      ((dp)localObject1).iAf = l1;
      ??? = a(parama).toString();
      kotlin.g.b.s.s(???, "buildExtraInfoJson(data).toString()");
      ((dp)localObject1).nD(n.m((String)???, ",", ";", false));
      ((dp)localObject1).iAg = parama.FqS;
      ((dp)localObject1).aIL();
      ((dp)localObject1).iAh = parama.FqT;
      if (parama.Frd != 0) {
        break label307;
      }
      l1 = parama.FqI;
      label170:
      ((dp)localObject1).iAi = l1;
      if ((((dp)localObject1).iAi >= ((dp)localObject1).iAf) && (((dp)localObject1).iAe > 0L) && (parama.FqY > 0L))
      {
        ??? = (CharSequence)((dp)localObject1).ixm;
        if ((??? != null) && (((CharSequence)???).length() != 0)) {
          break label312;
        }
        i = 1;
        label236:
        if (i == 0) {
          break label322;
        }
        ??? = (CharSequence)((dp)localObject1).ijl;
        if ((??? != null) && (((CharSequence)???).length() != 0)) {
          break label317;
        }
      }
    }
    label302:
    label307:
    label312:
    label317:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label322;
      }
      Log.w("Finder.FinderLoadingTimeReporter", kotlin.g.b.s.X("report20672and20713 error info:", ((dp)localObject1).aIF()));
      AppMethodBeat.o(331712);
      return;
      l1 = parama.FqE;
      break;
      l1 = 0L;
      break label93;
      l1 = 0L;
      break label170;
      i = 0;
      break label236;
    }
    label322:
    if (Sl(paramInt))
    {
      ((dp)localObject1).bMH();
      ??? = new StringBuilder("report20672 ");
      String str = ((dp)localObject1).aIF();
      kotlin.g.b.s.s(str, "struct.toShowString()");
      Log.i("Finder.FinderLoadingTimeReporter", n.bV(str, "\r\n", " "));
    }
    if ((parama.FqX > 600000L) || (parama.FqY > 600000L) || (parama.EQK < 0L))
    {
      Log.e("Finder.FinderLoadingTimeReporter", "report20672and20713 waiting time out cgiAllCost = " + parama.FqX + ", loadCost = " + parama.FqY + ", enterCose = " + parama.EQK);
      AppMethodBeat.o(331712);
      return;
    }
    if (Sn(paramInt)) {
      b(parama);
    }
    ??? = new do();
    ((do)???).ny(((dp)localObject1).ixm);
    ((do)???).nz(((dp)localObject1).ijl);
    ((do)???).ipV = ((dp)localObject1).ipV;
    ((do)???).iAd = ((dp)localObject1).iAd;
    ((do)???).iAe = ((dp)localObject1).iAe;
    ((do)???).iAf = ((dp)localObject1).iAf;
    ((do)???).nA(((dp)localObject1).iwJ);
    ((do)???).iAg = ((dp)localObject1).iAg;
    ((do)???).iwf = ((dp)localObject1).iwf;
    ((do)???).iAh = ((dp)localObject1).iAh;
    ((do)???).iAi = ((dp)localObject1).iAi;
    ((do)???).bMH();
    Log.i("Finder.FinderLoadingTimeReporter", kotlin.g.b.s.X("report20672and20713 info:", ((do)???).aIF()));
    if (Sn(paramInt)) {}
    synchronized (EQz)
    {
      EQz.add(parama);
      localObject1 = ((dp)localObject1).iwJ;
      kotlin.g.b.s.s(localObject1, "struct.extraInfo");
      F(paramInt, (String)localObject1, String.valueOf(parama.FqY));
      AppMethodBeat.o(331712);
      return;
    }
  }
  
  public static void aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331534);
    a locala = Sk(paramInt);
    if (locala != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramInt = 1;; paramInt = 0)
    {
      locala.Frc = paramInt;
      AppMethodBeat.o(331534);
      return;
    }
  }
  
  public static void aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331591);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((locala.hS) && (!locala.FqA))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label88;
        }
        label39:
        if (locala == null) {
          break label109;
        }
        if (!paramBoolean) {
          break label101;
        }
        locala.FqG = cn.bDw();
        if (locala.FqR != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 2L;; l = 3L)
      {
        locala.FqR = l;
        AppMethodBeat.o(331591);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label101:
      locala.FqH = cn.bDw();
    }
    label109:
    AppMethodBeat.o(331591);
  }
  
  public static void aM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331600);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.hS) && (!locala.FqA))
      {
        i = 1;
        if (i == 0) {
          break label60;
        }
      }
      for (;;)
      {
        if (locala != null)
        {
          if (paramBoolean)
          {
            locala.FqI = 0L;
            AppMethodBeat.o(331600);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          if ((locala.FqI > 0L) && (locala.Frj == 1))
          {
            AppMethodBeat.o(331600);
            return;
          }
          locala.FqI = cn.bDw();
          if (locala.FqS == 2L)
          {
            locala.FqA = true;
            locala.FqB = false;
            a(locala, paramInt);
          }
        }
      }
    }
    AppMethodBeat.o(331600);
  }
  
  public static void aN(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331634);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((locala.hS) && (!locala.FqA))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label62;
        }
      }
      for (;;)
      {
        if (locala != null)
        {
          if (paramBoolean)
          {
            locala.FqM = cn.bDw();
            AppMethodBeat.o(331634);
            return;
            paramInt = 0;
            break;
            label62:
            locala = null;
            continue;
          }
          locala.FqN = cn.bDw();
        }
      }
    }
    AppMethodBeat.o(331634);
  }
  
  public static void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331640);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((!locala.hS) || (locala.FqA)) {
        break label69;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label74;
      }
      label35:
      if ((locala != null) && (locala.Frg == 0)) {
        if (!paramBoolean) {
          break label79;
        }
      }
    }
    label69:
    label74:
    label79:
    for (paramInt = 3;; paramInt = 4)
    {
      locala.Frg = paramInt;
      locala.Frh = 4;
      AppMethodBeat.o(331640);
      return;
      paramInt = 0;
      break;
      locala = null;
      break label35;
    }
  }
  
  public static void aq(int paramInt, long paramLong)
  {
    AppMethodBeat.i(331570);
    a locala = (a)Fqy.get(Integer.valueOf(paramInt));
    if (locala != null) {
      locala.Frm = paramLong;
    }
    AppMethodBeat.o(331570);
  }
  
  public static void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(331618);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      if ((locala.hS) && (!locala.FqA))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label87;
        }
        label42:
        if (locala == null) {
          break label113;
        }
        if (!paramBoolean1) {
          break label105;
        }
        locala.FqK = cn.bDw();
        if ((!paramBoolean2) || (!paramBoolean3)) {
          break label93;
        }
        paramInt = 3;
      }
      for (;;)
      {
        locala.Frf = paramInt;
        AppMethodBeat.o(331618);
        return;
        paramInt = 0;
        break;
        label87:
        locala = null;
        break label42;
        label93:
        paramInt = i;
        if (!paramBoolean2) {
          paramInt = 2;
        }
      }
      label105:
      locala.FqL = cn.bDw();
    }
    label113:
    AppMethodBeat.o(331618);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(331760);
    if (parama.FqS == 1L)
    {
      if (parama.FqU > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 0L, parama.FqU);
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 3L, 1L);
      }
      if (parama.FqW > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 1L, parama.FqW);
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 4L, 1L);
      }
      if ((parama.FqU > 0L) && (parama.FqW > 0L))
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 2L, parama.FqX);
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 5L, 1L);
      }
      if (parama.EQK > 0L)
      {
        if (parama.FqX > 0L) {}
        switch (parama.hJx)
        {
        case 2: 
        default: 
          com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 20L, parama.EQK);
          com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 21L, 1L);
          l = parama.FqE - parama.FqD;
          if (l > 0L)
          {
            com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 23L, l);
            com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 24L, 1L);
          }
          if (parama.FqI >= parama.FqJ) {
            break;
          }
        }
      }
    }
    for (long l = parama.FqJ - parama.FqI;; l = 0L)
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 26L, l);
        com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 27L, 1L);
      }
      AppMethodBeat.o(331760);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 10L, parama.FqX);
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 11L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 13L, parama.FqX);
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 14L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 16L, parama.FqX);
      com.tencent.mm.plugin.report.service.h.OAn.p(1458L, 17L, 1L);
      break;
    }
  }
  
  public static void d(int paramInt, bui parambui)
  {
    AppMethodBeat.i(331667);
    a locala = Sk(paramInt);
    int i;
    if (locala != null)
    {
      if ((!locala.hS) || (locala.FqA)) {
        break label192;
      }
      i = 1;
      if (i == 0) {
        break label197;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        if (parambui != null)
        {
          String str2 = parambui.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambui.zIB;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.azJ(str1);
          locala.FqQ = parambui.AJo;
        }
        locala.FqA = true;
        locala.FqJ = cn.bDw();
        if ((locala.EQC > 0L) && (locala.EQD == 0L)) {
          locala.EQD = locala.FqJ;
        }
        if ((locala.FqG > 0L) && (locala.FqH == 0L)) {
          locala.FqH = locala.FqJ;
        }
        locala.FqS = 3L;
        locala.Frh = 3;
        a(locala, paramInt);
      }
      AppMethodBeat.o(331667);
      return;
      label192:
      i = 0;
      break;
      label197:
      locala = null;
    }
  }
  
  public static void e(int paramInt, bui parambui)
  {
    AppMethodBeat.i(331677);
    a locala = Sk(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.hS) && (!locala.FqA))
      {
        i = 1;
        if (i == 0) {
          break label125;
        }
      }
      for (;;)
      {
        if (locala != null)
        {
          if (parambui != null)
          {
            String str2 = parambui.sessionId;
            String str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.setSessionId(str1);
            str2 = parambui.zIB;
            str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.azJ(str1);
            locala.FqQ = parambui.AJo;
          }
          if (locala.FqS != 0L)
          {
            AppMethodBeat.o(331677);
            return;
            i = 0;
            break;
            label125:
            locala = null;
            continue;
          }
          locala.FqJ = cn.bDw();
          locala.FqZ = 3;
          if ((locala.EQC > 0L) && (locala.EQD == 0L))
          {
            locala.EQD = locala.FqJ;
            locala.FqZ = 1;
          }
          if ((locala.FqG > 0L) && (locala.FqH == 0L))
          {
            locala.FqH = locala.FqJ;
            locala.FqZ = 2;
          }
          locala.Frg = 2;
          locala.Frh = 2;
          locala.FqS = 2L;
          if (locala.FqI > 0L)
          {
            locala.FqA = true;
            a(locala, paramInt);
            AppMethodBeat.o(331677);
            return;
          }
          locala.FqB = true;
        }
      }
    }
    AppMethodBeat.o(331677);
  }
  
  public static List<axm> eGJ()
  {
    AppMethodBeat.i(331753);
    LinkedList localLinkedList = new LinkedList();
    label1036:
    label1066:
    for (;;)
    {
      Object localObject3;
      a locala;
      long l1;
      synchronized (EQz)
      {
        localObject3 = ((Iterable)EQz).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label1036;
        }
        locala = (a)((Iterator)localObject3).next();
        axm localaxm = new axm();
        localaxm.scene = 2;
        localaxm.pullType = ((int)locala.FqT);
        localaxm.ZIz = ((int)locala.EQK);
        if (locala.Frh == 2)
        {
          i = 100000000;
          localaxm.ZIA = i;
          long l2 = 0L;
          l1 = l2;
          if (locala.Frd == 1)
          {
            l1 = l2;
            if (locala.FqE < locala.FqJ)
            {
              l1 = l2;
              if (locala.FqE > 0L)
              {
                l1 = l2;
                if (locala.FqJ > 0L) {
                  l1 = locala.FqJ - locala.FqE;
                }
              }
            }
          }
          l2 = l1;
          if (locala.Frd == 0)
          {
            l2 = l1;
            if (locala.FqI < locala.FqJ)
            {
              l2 = l1;
              if (locala.FqI > 0L)
              {
                l2 = l1;
                if (locala.FqJ > 0L) {
                  l2 = locala.FqJ - locala.FqI;
                }
              }
            }
          }
          localaxm.ZIB = ((int)l2);
          if (locala.Fra == 0)
          {
            if ((locala.FpX <= 0L) || (locala.FpW <= 0L) || (locala.FpX <= locala.FpW)) {
              break label1066;
            }
            i = (int)(locala.FpX - locala.FpW);
            localaxm.ZIC = i;
            l1 = 0L;
            if (locala.FpX <= 0L) {
              break label976;
            }
            l1 = locala.FpX;
            if ((l1 <= 0L) || (locala.FpY <= 0L) || (locala.FpY <= l1)) {
              break label995;
            }
            i = (int)(locala.FpY - l1);
            label362:
            localaxm.ZID = i;
          }
          localaxm.Frg = locala.Frg;
          localaxm.ZIF = locala.EQI;
          localaxm.ZIG = ((int)locala.FqQ);
          localaxm.status = locala.Frh;
          localaxm.Znb = ((int)locala.FqR);
          localaxm.ZIH = ((int)locala.Frl);
          localaxm.ZII = ((int)locala.Frl);
          if (locala.FqT == 2L)
          {
            localaxm.ZII = ((int)locala.Frm);
            if (locala.Frm <= 0L)
            {
              localaxm.ZID = 0;
              localaxm.ZIC = 0;
              localaxm.ZIH = ((int)(locala.FqJ - locala.FqE));
            }
          }
          Object localObject4 = locala.EQQ;
          if (localObject4 != null)
          {
            localaxm.Rsc = ((yf)localObject4).taskStartTime;
            localaxm.ZIJ = ((yf)localObject4).startConnectTime;
            localaxm.ZIK = ((yf)localObject4).connectSuccessfulTime;
            localaxm.ZIL = ((yf)localObject4).startHandshakeTime;
            localaxm.ZIM = ((yf)localObject4).handshakeSuccessfulTime;
            localaxm.ZIN = ((yf)localObject4).startSendPacketTime;
            localaxm.ZIO = ((yf)localObject4).startReadPacketTime;
            localaxm.ZIP = ((yf)localObject4).readPacketFinishedTime;
            Log.i("Finder.FinderLoadingTimeReporter", "profile time\nstartConnectTime: " + ((yf)localObject4).startConnectTime + " \nconnectSuccessfulTime：" + ((yf)localObject4).connectSuccessfulTime + " \nstartHandshakeTime：" + ((yf)localObject4).startHandshakeTime + " \nhandshakeSuccessfulTime：" + ((yf)localObject4).handshakeSuccessfulTime + " \nstartSendPacketTime：" + ((yf)localObject4).startSendPacketTime + " \nstartReadPacketTime：" + ((yf)localObject4).startReadPacketTime + " \nreadPacketFinishedTime： " + ((yf)localObject4).readPacketFinishedTime + " \ntaskStartTime：" + ((yf)localObject4).taskStartTime);
          }
          localLinkedList.add(localaxm);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("finderFluencyInfo: scene = ").append(localaxm.scene).append(", pullType = ").append(localaxm.pullType).append(", globalInitMs = ").append(localaxm.ZIz).append(", pullCgiMs = ").append(localaxm.ZIA).append(", showUiMs = ").append(localaxm.ZIB).append(", downloadToDecodeMs = ").append(localaxm.ZIC).append(", decodeToFirstFrameMs = ").append(localaxm.ZID).append(", finishScene = ").append(localaxm.Frg).append(", commentScene = ").append(localaxm.ZIG).append(", status = ").append(localaxm.status).append(", it.cgiType = ").append(localaxm.Znb).append(", total_time_ms = ");
          ((StringBuilder)localObject4).append(localaxm.ZIH).append(", loading_time_ms = ").append(localaxm.ZII).append(", firstFeedIsPhoto = ").append(locala.Fra);
          Log.i("Finder.FinderLoadingTimeReporter", ((StringBuilder)localObject4).toString());
        }
      }
      int i = (int)locala.FqX;
      continue;
      label976:
      if (locala.FpU > 0L)
      {
        l1 = locala.FpU;
        continue;
        label995:
        if (locala.Frh == 1)
        {
          if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUe()) {}
          for (i = 4;; i = 2)
          {
            locala.Frh = i;
            i = 100000000;
            break label362;
            EQz.clear();
            localObject3 = ah.aiuX;
            ??? = (List)localObject2;
            AppMethodBeat.o(331753);
            return ???;
            i = 0;
            break;
          }
        }
        i = 0;
      }
    }
  }
  
  public static void eMM()
  {
    Fqw = true;
  }
  
  public static void eMN()
  {
    AppMethodBeat.i(331515);
    EQt = cn.bDw();
    AppMethodBeat.o(331515);
  }
  
  public static void eMO()
  {
    EQt = 0L;
    Fqw = false;
  }
  
  public static void eMQ()
  {
    AppMethodBeat.i(331705);
    com.tencent.mm.ae.d.uiThread((a)b.Frn);
    AppMethodBeat.o(331705);
  }
  
  public static void jdMethod_if(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331660);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(331660);
      return;
    }
    a locala = Sk(paramInt1);
    if (locala != null)
    {
      if ((!locala.hS) || (locala.FqA)) {
        break label67;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label72;
      }
    }
    for (;;)
    {
      if (locala != null) {
        locala.Fre += paramInt2;
      }
      AppMethodBeat.o(331660);
      return;
      label67:
      paramInt1 = 0;
      break;
      label72:
      locala = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "", "()V", "cgiAllCost", "", "getCgiAllCost", "()J", "setCgiAllCost", "(J)V", "cgiBackFeedCount", "", "getCgiBackFeedCount", "()I", "setCgiBackFeedCount", "(I)V", "cgiEndTimestamp", "getCgiEndTimestamp", "setCgiEndTimestamp", "cgiProfile", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "getCgiProfile", "()Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "setCgiProfile", "(Lcom/tencent/mm/protocal/protobuf/CgiProfile;)V", "cgiType", "getCgiType", "setCgiType", "clickEnter", "getClickEnter", "setClickEnter", "clickTabContextID", "", "getClickTabContextID", "()Ljava/lang/String;", "setClickTabContextID", "(Ljava/lang/String;)V", "commentScene", "getCommentScene", "setCommentScene", "debugMessage", "Lcom/tencent/mm/protobuf/ByteString;", "getDebugMessage", "()Lcom/tencent/mm/protobuf/ByteString;", "setDebugMessage", "(Lcom/tencent/mm/protobuf/ByteString;)V", "enterCost", "getEnterCost", "setEnterCost", "enterWithFirstPageData", "getEnterWithFirstPageData", "setEnterWithFirstPageData", "enterWithRedDot", "getEnterWithRedDot", "setEnterWithRedDot", "exitStatus", "getExitStatus", "setExitStatus", "feedIdType", "getFeedIdType", "setFeedIdType", "finishScene", "getFinishScene", "setFinishScene", "finishStatus", "getFinishStatus", "setFinishStatus", "firstFeedIsPhoto", "getFirstFeedIsPhoto", "setFirstFeedIsPhoto", "firstFeedShowTime", "getFirstFeedShowTime", "setFirstFeedShowTime", "fluencyStatus", "getFluencyStatus", "setFluencyStatus", "getDetailCgiBegin", "getGetDetailCgiBegin", "setGetDetailCgiBegin", "getDetailCgiEnd", "getGetDetailCgiEnd", "setGetDetailCgiEnd", "getRelatedCgiBegin", "getGetRelatedCgiBegin", "setGetRelatedCgiBegin", "getRelatedCgiEnd", "getGetRelatedCgiEnd", "setGetRelatedCgiEnd", "hasBeenAppBackground", "getHasBeenAppBackground", "setHasBeenAppBackground", "historyCgiBegin", "getHistoryCgiBegin", "setHistoryCgiBegin", "historyCgiEnd", "getHistoryCgiEnd", "setHistoryCgiEnd", "historyCost", "getHistoryCost", "setHistoryCost", "isEnterLoad", "setEnterLoad", "isFinishLoad", "", "()Z", "setFinishLoad", "(Z)V", "isPrepared", "setPrepared", "isWaitingCgiBack", "setWaitingCgiBack", "loadCost", "getLoadCost", "setLoadCost", "loadingBegin", "getLoadingBegin", "setLoadingBegin", "loadingEnd", "getLoadingEnd", "setLoadingEnd", "loadingExposeTime", "getLoadingExposeTime", "setLoadingExposeTime", "pullType", "getPullType", "setPullType", "resumeToLoadingStartCost", "getResumeToLoadingStartCost", "setResumeToLoadingStartCost", "sessionId", "getSessionId", "setSessionId", "spanCgiCost", "getSpanCgiCost", "setSpanCgiCost", "streamCgiBegin", "getStreamCgiBegin", "setStreamCgiBegin", "streamCgiEnd", "getStreamCgiEnd", "setStreamCgiEnd", "streamCost", "getStreamCost", "setStreamCost", "tabResume", "getTabResume", "setTabResume", "tabType", "getTabType", "setTabType", "totalCost", "getTotalCost", "setTotalCost", "trulyLoadingBeginWhenEnterLoad", "getTrulyLoadingBeginWhenEnterLoad", "setTrulyLoadingBeginWhenEnterLoad", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long EQC;
    long EQD;
    com.tencent.mm.bx.b EQI;
    long EQK;
    yf EQQ;
    long FpU;
    long FpW;
    long FpX;
    long FpY;
    public boolean FqA;
    boolean FqB;
    long FqC;
    long FqD;
    long FqE;
    long FqF;
    long FqG;
    long FqH;
    long FqI;
    long FqJ;
    long FqK;
    long FqL;
    long FqM;
    long FqN;
    public long FqO;
    String FqP = "";
    long FqQ;
    long FqR;
    long FqS;
    long FqT;
    long FqU;
    long FqV;
    long FqW;
    long FqX;
    long FqY;
    int FqZ;
    int Fra;
    int Frb;
    int Frc;
    int Frd;
    int Fre;
    int Frf;
    int Frg;
    int Frh;
    int Fri;
    public int Frj;
    long Frk;
    long Frl;
    long Frm;
    int hJx;
    public boolean hS;
    String sessionId = "";
    
    public final void azJ(String paramString)
    {
      AppMethodBeat.i(331342);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.FqP = paramString;
      AppMethodBeat.o(331342);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(331336);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(331336);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    public static final b Frn;
    
    static
    {
      AppMethodBeat.i(331313);
      Frn = new b();
      AppMethodBeat.o(331313);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.s
 * JD-Core Version:    0.7.0.1
 */
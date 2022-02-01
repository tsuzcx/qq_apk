package com.tencent.mm.plugin.finder.report;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.co;
import com.tencent.mm.f.b.a.cp;
import com.tencent.mm.f.b.a.cx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter;", "", "()V", "CGI_TYPE_HISTORY", "", "CGI_TYPE_OTHER", "CGI_TYPE_STREAM", "CGI_TYPE_STREAM_AND_HISTORY", "INNER_VERSION_20672", "INNER_VERSION_21680", "LOADING_STATUS_FAIL", "LOADING_STATUS_FINISH_BY_USER", "LOADING_STATUS_SUCCESS", "TAG", "", "WAITING_TIME_OUT", "clickEnterTime", "enterFinderWithRedDot", "", "laterReportCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "loadingTimeConsumeDataMap", "recordStandingTimeMap", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabResumeTimeMap", "addCgiBackFeedCount", "", "tabType", "count", "applyClickEnterTime", "buildExtraInfoJson", "Lorg/json/JSONObject;", "data", "cacheLateReportData", "clearClickEnterTime", "genClickEnterTime", "getData", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isOutSideEnterFinderTabType", "isSupport20672TabType", "isSupportCgiReportTabType", "isSupportReportPullType", "pullType", "isSupportTabTabType", "notifyAppBackground", "notifyCgiEnd", "clear", "notifyDecodeStart", "notifyEnterLoad", "notifyFinishScene", "isChangeTab", "notifyFirstFeedShow", "notifyFirstPageData", "hasData", "notifyGetDetailCgi", "isBegin", "hasFeedId", "hasEncryptId", "notifyGetRelatedCgi", "notifyHistoryCgi", "notifyLoadingStatus", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstFeedIsPhoto", "notifyStreamCgi", "message", "Lcom/tencent/mm/protobuf/ByteString;", "notifyUsePreloadCache", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPlay", "onTabResume", "prepare", "cgiType", "report20672and20713", "report21680", "json", "majorData", "reportCacheData", "reportFailed", "reportFinishByUser", "reportTimeConsumingIDKey", "FinderGlobalRptType", "TimeConsumeData", "plugin-finder-base_release"})
public final class j
{
  private static long zUH;
  private static boolean zVs;
  private static final ConcurrentHashMap<Integer, a> zVt;
  private static final ConcurrentHashMap<Integer, Long> zVu;
  private static final ConcurrentHashMap<Integer, a> zVv;
  private static final ConcurrentHashMap<a, Integer> zVw;
  private static final HashSet<a> zVx;
  public static final j zVy;
  
  static
  {
    AppMethodBeat.i(259289);
    zVy = new j();
    zVt = new ConcurrentHashMap();
    zVu = new ConcurrentHashMap();
    zVv = new ConcurrentHashMap();
    zVw = new ConcurrentHashMap();
    zVx = new HashSet();
    AppMethodBeat.o(259289);
  }
  
  public static a Ph(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(259247);
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
      AppMethodBeat.o(259247);
      return null;
    }
    a locala2 = (a)zVt.get(Integer.valueOf(paramInt));
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (!locala2.zVz) {}
    }
    else
    {
      locala1 = new a();
      locala1.fEH = paramInt;
      ((Map)zVt).put(Integer.valueOf(paramInt), locala1);
    }
    AppMethodBeat.o(259247);
    return locala1;
  }
  
  private static boolean Pi(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 5);
  }
  
  private static boolean Pj(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 5) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  private static boolean Pk(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1);
  }
  
  public static void Pl(int paramInt)
  {
    AppMethodBeat.i(259251);
    a locala = (a)zVv.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.zVg = cm.bfE();
      AppMethodBeat.o(259251);
      return;
    }
    AppMethodBeat.o(259251);
  }
  
  public static void Pm(int paramInt)
  {
    AppMethodBeat.i(259252);
    a locala = (a)zVv.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.zVi = cm.bfE();
      if ((locala.zVV == 0L) && (locala.zVB > 0L))
      {
        Map localMap = (Map)zVw;
        p.j(locala, "it");
        localMap.put(locala, Integer.valueOf(paramInt));
      }
      for (;;)
      {
        zVv.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(259252);
        return;
        p.j(locala, "it");
        a(locala, paramInt);
      }
    }
    AppMethodBeat.o(259252);
  }
  
  public static void Pn(int paramInt)
  {
    AppMethodBeat.i(259253);
    a locala = (a)zVv.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.zVh = cm.bfE();
      AppMethodBeat.o(259253);
      return;
    }
    AppMethodBeat.o(259253);
  }
  
  public static void Po(int paramInt)
  {
    AppMethodBeat.i(259254);
    a locala = (a)zVv.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.zVe = cm.bfE();
      AppMethodBeat.o(259254);
      return;
    }
    AppMethodBeat.o(259254);
  }
  
  public static void Pp(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(259256);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      long l1;
      if (zUH > 0L)
      {
        locala.zVB = zUH;
        Long localLong = (Long)zVu.get(Integer.valueOf(paramInt));
        if (localLong == null) {
          break label124;
        }
        l1 = localLong.longValue();
        locala.zVC = l1;
        zUH = 0L;
        l1 = l2;
        if (locala.zVC > 0L) {
          l1 = locala.zVC - locala.zVB;
        }
        locala.zVW = l1;
        if (!zVs) {
          break label129;
        }
      }
      label129:
      for (paramInt = 1;; paramInt = 0)
      {
        locala.zWe = paramInt;
        zVs = false;
        AppMethodBeat.o(259256);
        return;
        label124:
        l1 = 0L;
        break;
      }
    }
    AppMethodBeat.o(259256);
  }
  
  public static void Pq(int paramInt)
  {
    AppMethodBeat.i(259258);
    ((Map)zVu).put(Integer.valueOf(paramInt), Long.valueOf(cm.bfE()));
    AppMethodBeat.o(259258);
  }
  
  public static void Pr(int paramInt)
  {
    AppMethodBeat.i(259278);
    if (paramInt != -1)
    {
      localObject = (a)zVv.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        p.j(localObject, "this");
        a((a)localObject, paramInt);
      }
      zVv.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(259278);
      return;
    }
    Object localObject = ((Map)zVv).entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getValue(), ((Number)localEntry.getKey()).intValue());
    }
    zVv.clear();
    localObject = ((Map)zVw).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getKey(), ((Number)localEntry.getValue()).intValue());
    }
    zVw.clear();
    AppMethodBeat.o(259278);
  }
  
  private static JSONObject a(a parama)
  {
    AppMethodBeat.i(259282);
    if ((parama.zVF > 0L) && (parama.zVG > 0L) && (parama.zVG > parama.zVF)) {
      parama.zVX = (parama.zVG - parama.zVF);
    }
    if ((parama.zVH > 0L) && (parama.zVI > 0L) && (parama.zVI > parama.zVH)) {
      parama.zVZ = (parama.zVI - parama.zVH);
    }
    if ((parama.zVG > 0L) && (parama.zVH > 0L) && (parama.zVH > parama.zVG)) {
      parama.zVY = (parama.zVH - parama.zVG);
    }
    parama.zWa = (parama.zVX + parama.zVZ + parama.zVY);
    long l1;
    long l4;
    label218:
    long l2;
    long l5;
    long l6;
    long l3;
    label262:
    int i;
    if ((parama.zVV == 0L) && (parama.zVB > 0L))
    {
      l1 = parama.zVK - parama.zVB;
      parama.zWb = l1;
      if ((parama.zVJ <= 0L) || (parama.zVJ >= parama.zVK)) {
        break label731;
      }
      l4 = parama.zVK - parama.zVJ;
      l2 = parama.zWb;
      l5 = 0L;
      l6 = 0L;
      l3 = 0L;
      if (parama.zVi <= 0L) {
        break label757;
      }
      if (parama.zVg <= 0L) {
        break label737;
      }
      l2 = parama.zVi - parama.zVg;
      i = 1;
      l3 = cm.bfE() - parama.zVi;
      l1 = l3;
      if (l3 > 10000L)
      {
        i = 3;
        l1 = 10000L;
      }
      if ((parama.zVV != 0L) || (parama.zVB <= 0L)) {
        break label743;
      }
      l3 = parama.zVi - parama.zVB;
      label321:
      l5 = l2;
      l2 = l3;
      l3 = l6;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enterCost", parama.zVW);
      localJSONObject.put("resumeToLoadingStartCost", parama.zWm);
      if (Pj(parama.fEH))
      {
        if (parama.zVP > 0L)
        {
          l1 = parama.zVP - parama.zVD;
          label397:
          localJSONObject.put("firstFeedShowCost", l1);
          if ((parama.zVM <= parama.zVL) || (parama.zVL <= 0L)) {
            break label841;
          }
          l1 = parama.zVM - parama.zVL;
          label438:
          localJSONObject.put("getDetailCost", l1);
          if ((parama.zVO <= parama.zVN) || (parama.zVN <= 0L)) {
            break label846;
          }
        }
        label841:
        label846:
        for (l1 = parama.zVO - parama.zVN;; l1 = 0L)
        {
          localJSONObject.put("getRelatedCost", l1);
          localJSONObject.put("cgiEndToLoadingEndCost", l4);
          localJSONObject.put("loadCost", parama.zWb);
          localJSONObject.put("loadCostWitchActivityCost", parama.zVK - parama.zVD);
          localJSONObject.put("feedIdType", parama.zWi);
          localJSONObject.put("cgiBackFeedCount", parama.zWh);
          localJSONObject.put("finishStatus", parama.zVU);
          localJSONObject.put("commentScene", parama.zVS);
          localJSONObject.put("tabType", parama.fEH);
          localJSONObject.put("pullType", parama.zVV);
          localJSONObject.put("api", Build.VERSION.SDK_INT);
          localJSONObject.put("hasBeenAppBackground", parama.zWk);
          if (parama.zVW > 0L)
          {
            localJSONObject.put("isEnterLoad", parama.zWl);
            com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
            localJSONObject.put("finderEnterLoadSwitch", ((Number)com.tencent.mm.plugin.finder.storage.d.dXa().aSr()).intValue());
          }
          if ((parama.zVW > 0L) && (i == 3)) {
            h.IzE.p(1458L, 30L, 1L);
          }
          AppMethodBeat.o(259282);
          return localJSONObject;
          l1 = parama.zVK - parama.zVD;
          break;
          label731:
          l4 = 0L;
          break label218;
          label737:
          l2 = 0L;
          break label262;
          label743:
          l3 = parama.zVi - parama.zVD;
          break label321;
          label757:
          if (parama.zVg <= 0L) {
            break label1116;
          }
          l2 = cm.bfE();
          l6 = parama.zVg;
          if ((parama.zVV == 0L) && (parama.zVB > 0L)) {}
          for (l1 = l2 - parama.zVB;; l1 = l2 - parama.zVD)
          {
            l6 = l2 - l6;
            i = 2;
            l2 = l1;
            l1 = l3;
            l3 = l6;
            break;
          }
          l1 = 0L;
          break label397;
          l1 = 0L;
          break label438;
        }
      }
      localJSONObject.put("streamCost", parama.zVX);
      localJSONObject.put("spanCgiCost", parama.zVY);
      localJSONObject.put("historyCost", parama.zVZ);
      localJSONObject.put("cgiAllCost", parama.zWa);
      localJSONObject.put("loadCost", parama.zWb);
      localJSONObject.put("cgiEndToLoadingEndCost", l4);
      localJSONObject.put("startDownloadTimeStamp", parama.zVg);
      localJSONObject.put("videoDecodeStartTimeStamp", parama.zVh);
      localJSONObject.put("firstFrameDrawTimeStamp", parama.zVi);
      localJSONObject.put("downLoadToFirstFrameDrawCost", l5);
      localJSONObject.put("downloadToExitCost", l3);
      localJSONObject.put("totalCost", l2);
      localJSONObject.put("firstFrameStatus", i);
      localJSONObject.put("standingMsAfterFirstFrame", l1);
      localJSONObject.put("exitStatus", parama.zWc);
      localJSONObject.put("firstFeedIsPhoto", parama.zWd);
      localJSONObject.put("enterWithRedDot", parama.zWe);
      if (parama.zVW > 0L) {}
      for (int j = parama.zWf;; j = 0)
      {
        localJSONObject.put("enterWithFirstPageData", j);
        localJSONObject.put("cgiBackFeedCount", parama.zWh);
        localJSONObject.put("usePreloadCache", parama.zWg);
        break;
      }
      label1116:
      i = 0;
      l1 = l3;
      l3 = l6;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bid parambid, long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(259249);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {}
    for (int i = 1; (i == 0) || (parambid == null); i = 0)
    {
      Log.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + paramInt1 + ", contextObj = " + parambid);
      AppMethodBeat.o(259249);
      return;
    }
    Object localObject1 = Ph(paramInt1);
    if (localObject1 != null)
    {
      if ((((a)localObject1).gX) && (!((a)localObject1).zVz))
      {
        i = 1;
        if (i == 0) {
          break label164;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if ((((a)localObject1).zWl == 1) && (!((a)localObject1).zVA) && (paramInt2 == 0))
          {
            Log.i("Finder.FinderLoadingTimeReporter", "prepare: remove duplicate enter report");
            AppMethodBeat.o(259249);
            return;
            i = 0;
            break;
            label164:
            localObject1 = null;
            continue;
          }
          if ((((a)localObject1).zVJ != 0L) || (((a)localObject1).zVU != 2L)) {
            break label315;
          }
          i = 1;
          if (i != 0) {
            localObject2 = localObject1;
          }
          if (localObject2 == null) {
            break label321;
          }
          as(paramInt1, false);
        }
      }
    }
    for (;;)
    {
      a locala = Ph(paramInt1);
      if (locala == null) {
        break label336;
      }
      locala.gX = true;
      locala.zVV = paramInt2;
      localObject2 = parambid.sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      locala.setSessionId((String)localObject1);
      localObject2 = parambid.wmz;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      locala.aDV((String)localObject1);
      locala.zVS = parambid.xkX;
      locala.zVT = paramLong;
      AppMethodBeat.o(259249);
      return;
      label315:
      i = 0;
      break;
      label321:
      ((a)localObject1).zVz = true;
      a((a)localObject1, paramInt1);
    }
    label336:
    AppMethodBeat.o(259249);
  }
  
  public static void a(int paramInt, boolean paramBoolean, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(259261);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label86;
        }
        label39:
        if (locala == null) {
          break label120;
        }
        if (!paramBoolean) {
          break label99;
        }
        locala.zVF = cm.bfE();
        if (locala.zVT != 0L) {
          break label92;
        }
      }
      label86:
      label92:
      for (long l = 1L;; l = 3L)
      {
        locala.zVT = l;
        AppMethodBeat.o(259261);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label99:
      locala.zVG = cm.bfE();
      locala.zVQ = paramb;
      AppMethodBeat.o(259261);
      return;
    }
    label120:
    AppMethodBeat.o(259261);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, bid parambid, boolean paramBoolean2)
  {
    long l2 = 0L;
    AppMethodBeat.i(259259);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        i = 1;
        if (i == 0) {
          break label201;
        }
        label44:
        if (locala == null) {
          break label417;
        }
        if (parambid != null)
        {
          String str2 = parambid.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambid.wmz;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.aDV(str1);
          locala.zVS = parambid.xkX;
        }
        if (!paramBoolean1) {
          break label276;
        }
        if ((locala.zVD <= 0L) || (locala.zWl != 1)) {
          break label213;
        }
        locala.zVE = cm.bfE();
        if ((locala.zVW <= 0L) || (locala.zVC <= 0L)) {
          break label207;
        }
      }
      label201:
      label207:
      for (long l1 = locala.zVE - locala.zVC;; l1 = 0L)
      {
        locala.zWm = l1;
        AppMethodBeat.o(259259);
        return;
        i = 0;
        break;
        locala = null;
        break label44;
      }
      label213:
      locala.zVD = cm.bfE();
      l1 = l2;
      if (locala.zVW > 0L)
      {
        l1 = l2;
        if (locala.zVC > 0L) {
          l1 = locala.zVD - locala.zVC;
        }
      }
      locala.zWm = l1;
      AppMethodBeat.o(259259);
      return;
      label276:
      locala.zVz = true;
      locala.zVK = cm.bfE();
      locala.zVU = 1L;
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        locala.zWd = i;
        if (locala.zWj == 0) {
          locala.zWj = 1;
        }
        if (((paramInt != 4) && (paramInt != 3) && (paramInt != 1)) || (paramBoolean2)) {
          break;
        }
        parambid = (a)zVv.get(Integer.valueOf(paramInt));
        if (parambid != null)
        {
          p.j(parambid, "this");
          a(parambid, paramInt);
        }
        ((Map)zVv).put(Integer.valueOf(paramInt), locala);
        AppMethodBeat.o(259259);
        return;
      }
      a(locala, paramInt);
      AppMethodBeat.o(259259);
      return;
    }
    label417:
    AppMethodBeat.o(259259);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(259281);
    Object localObject1 = new cp();
    ((cp)localObject1).mS(parama.sessionId);
    ((cp)localObject1).mT(parama.zVR);
    ((cp)localObject1).fR(parama.zVS);
    ((cp)localObject1).fS(parama.zVT);
    long l2 = parama.zVK;
    long l1;
    if (parama.zWl == 1)
    {
      l1 = parama.zVE;
      ((cp)localObject1).fT(l2 - l1);
      if (parama.zWg != 0) {
        break label320;
      }
      l1 = parama.zVD;
      label96:
      ((cp)localObject1).fU(l1);
      ??? = a(parama).toString();
      p.j(???, "buildExtraInfoJson(data).toString()");
      ((cp)localObject1).mU(n.l((String)???, ",", ";", false));
      ((cp)localObject1).fV(parama.zVU);
      ((cp)localObject1).ahK();
      ((cp)localObject1).fW(parama.zVV);
      if (parama.zWg != 0) {
        break label325;
      }
      l1 = parama.zVJ;
      label176:
      ((cp)localObject1).fX(l1);
      if ((((cp)localObject1).ahN() >= ((cp)localObject1).ahH()) && (((cp)localObject1).ahG() > 0L) && (parama.zWb > 0L))
      {
        ??? = (CharSequence)((cp)localObject1).ahq();
        if ((??? != null) && (((CharSequence)???).length() != 0)) {
          break label330;
        }
        i = 1;
        label243:
        if (i == 0) {
          break label340;
        }
        ??? = (CharSequence)((cp)localObject1).ahD();
        if ((??? != null) && (((CharSequence)???).length() != 0)) {
          break label335;
        }
      }
    }
    label320:
    label325:
    label330:
    label335:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label340;
      }
      Log.w("Finder.FinderLoadingTimeReporter", "report20672and20713 error info:" + ((cp)localObject1).agI());
      AppMethodBeat.o(259281);
      return;
      l1 = parama.zVD;
      break;
      l1 = 0L;
      break label96;
      l1 = 0L;
      break label176;
      i = 0;
      break label243;
    }
    label340:
    if (Pi(paramInt))
    {
      ((cp)localObject1).bpa();
      ??? = new StringBuilder("report").append(((cp)localObject1).getId()).append(' ');
      String str = ((cp)localObject1).agI();
      p.j(str, "struct.toShowString()");
      Log.i("Finder.FinderLoadingTimeReporter", n.l(str, "\r\n", " ", false));
    }
    if ((parama.zWa > 600000L) || (parama.zWb > 600000L) || (parama.zVW < 0L))
    {
      Log.e("Finder.FinderLoadingTimeReporter", "report20672and20713 waiting time out cgiAllCost = " + parama.zWa + ", loadCost = " + parama.zWb + ", enterCose = " + parama.zVW);
      AppMethodBeat.o(259281);
      return;
    }
    if (Pk(paramInt)) {
      b(parama);
    }
    ??? = new co();
    ((co)???).mP(((cp)localObject1).ahq());
    ((co)???).mQ(((cp)localObject1).ahD());
    ((co)???).fJ(((cp)localObject1).ahE());
    ((co)???).fK(((cp)localObject1).ahF());
    ((co)???).fL(((cp)localObject1).ahG());
    ((co)???).fM(((cp)localObject1).ahH());
    ((co)???).mR(((cp)localObject1).ahJ());
    ((co)???).fN(((cp)localObject1).ahI());
    ((co)???).fO(((cp)localObject1).ahL());
    ((co)???).fP(((cp)localObject1).ahM());
    ((co)???).fQ(((cp)localObject1).ahN());
    ((co)???).bpa();
    Log.i("Finder.FinderLoadingTimeReporter", "report20672and20713 info:" + ((co)???).agI());
    if (Pk(paramInt)) {}
    synchronized (zVx)
    {
      zVx.add(parama);
      localObject1 = ((cp)localObject1).ahJ();
      p.j(localObject1, "struct.extraInfo");
      z(paramInt, (String)localObject1, String.valueOf(parama.zWb));
      AppMethodBeat.o(259281);
      return;
    }
  }
  
  public static void aq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(259257);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        locala.zWf = paramInt;
        AppMethodBeat.o(259257);
        return;
      }
    }
    AppMethodBeat.o(259257);
  }
  
  public static void ar(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(259265);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label88;
        }
        label39:
        if (locala == null) {
          break label116;
        }
        if (!paramBoolean) {
          break label101;
        }
        locala.zVH = cm.bfE();
        if (locala.zVT != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 2L;; l = 3L)
      {
        locala.zVT = l;
        AppMethodBeat.o(259265);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label101:
      locala.zVI = cm.bfE();
      AppMethodBeat.o(259265);
      return;
    }
    label116:
    AppMethodBeat.o(259265);
  }
  
  public static void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(259266);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.gX) && (!locala.zVz))
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
            locala.zVJ = 0L;
            AppMethodBeat.o(259266);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          if ((locala.zVJ > 0L) && (locala.zWl == 1))
          {
            AppMethodBeat.o(259266);
            return;
          }
          locala.zVJ = cm.bfE();
          if (locala.zVU == 2L)
          {
            locala.zVz = true;
            locala.zVA = false;
            a(locala, paramInt);
          }
          AppMethodBeat.o(259266);
          return;
        }
      }
    }
    AppMethodBeat.o(259266);
  }
  
  public static void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(259270);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
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
            locala.zVN = cm.bfE();
            AppMethodBeat.o(259270);
            return;
            paramInt = 0;
            break;
            label62:
            locala = null;
            continue;
          }
          locala.zVO = cm.bfE();
          AppMethodBeat.o(259270);
          return;
        }
      }
    }
    AppMethodBeat.o(259270);
  }
  
  public static void au(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(259271);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label69;
        }
        label35:
        if (locala == null) {
          break label79;
        }
        if (locala.zWj == 0) {
          if (!paramBoolean) {
            break label74;
          }
        }
      }
      label69:
      label74:
      for (paramInt = 3;; paramInt = 4)
      {
        locala.zWj = paramInt;
        AppMethodBeat.o(259271);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label35;
      }
    }
    label79:
    AppMethodBeat.o(259271);
  }
  
  public static void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(259268);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label87;
        }
        label42:
        if (locala == null) {
          break label120;
        }
        if (!paramBoolean1) {
          break label105;
        }
        locala.zVL = cm.bfE();
        if ((!paramBoolean2) || (!paramBoolean3)) {
          break label93;
        }
        paramInt = 3;
      }
      for (;;)
      {
        locala.zWi = paramInt;
        AppMethodBeat.o(259268);
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
      locala.zVM = cm.bfE();
      AppMethodBeat.o(259268);
      return;
    }
    label120:
    AppMethodBeat.o(259268);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(259288);
    if (parama.zVU == 1L)
    {
      if (parama.zVX > 0L)
      {
        h.IzE.p(1458L, 0L, parama.zVX);
        h.IzE.p(1458L, 3L, 1L);
      }
      if (parama.zVZ > 0L)
      {
        h.IzE.p(1458L, 1L, parama.zVZ);
        h.IzE.p(1458L, 4L, 1L);
      }
      if ((parama.zVX > 0L) && (parama.zVZ > 0L))
      {
        h.IzE.p(1458L, 2L, parama.zWa);
        h.IzE.p(1458L, 5L, 1L);
      }
      if (parama.zVW > 0L)
      {
        if (parama.zWa > 0L) {}
        switch (parama.fEH)
        {
        case 2: 
        default: 
          h.IzE.p(1458L, 20L, parama.zVW);
          h.IzE.p(1458L, 21L, 1L);
          l = parama.zVD - parama.zVC;
          if (l > 0L)
          {
            h.IzE.p(1458L, 23L, l);
            h.IzE.p(1458L, 24L, 1L);
          }
          if (parama.zVJ >= parama.zVK) {
            break;
          }
        }
      }
    }
    for (long l = parama.zVK - parama.zVJ;; l = 0L)
    {
      if (l > 0L)
      {
        h.IzE.p(1458L, 26L, l);
        h.IzE.p(1458L, 27L, 1L);
      }
      AppMethodBeat.o(259288);
      return;
      h.IzE.p(1458L, 10L, parama.zWa);
      h.IzE.p(1458L, 11L, 1L);
      break;
      h.IzE.p(1458L, 13L, parama.zWa);
      h.IzE.p(1458L, 14L, 1L);
      break;
      h.IzE.p(1458L, 16L, parama.zWa);
      h.IzE.p(1458L, 17L, 1L);
      break;
    }
  }
  
  public static void d(int paramInt, bid parambid)
  {
    AppMethodBeat.i(259274);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.gX) && (!locala.zVz))
      {
        i = 1;
        if (i == 0) {
          break label192;
        }
      }
      for (;;)
      {
        if (locala == null) {
          break label197;
        }
        if (parambid != null)
        {
          String str2 = parambid.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambid.wmz;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.aDV(str1);
          locala.zVS = parambid.xkX;
        }
        locala.zVz = true;
        locala.zVK = cm.bfE();
        if ((locala.zVF > 0L) && (locala.zVG == 0L)) {
          locala.zVG = locala.zVK;
        }
        if ((locala.zVH > 0L) && (locala.zVI == 0L)) {
          locala.zVI = locala.zVK;
        }
        locala.zVU = 3L;
        a(locala, paramInt);
        AppMethodBeat.o(259274);
        return;
        i = 0;
        break;
        label192:
        locala = null;
      }
    }
    label197:
    AppMethodBeat.o(259274);
  }
  
  public static List<asy> dPp()
  {
    AppMethodBeat.i(259286);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject3;
      a locala;
      long l1;
      synchronized (zVx)
      {
        localObject3 = ((Iterable)zVx).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label544;
        }
        locala = (a)((Iterator)localObject3).next();
        asy localasy = new asy();
        localasy.scene = 2;
        localasy.pullType = ((int)locala.zVV);
        localasy.SGb = ((int)locala.zVW);
        localasy.SGc = ((int)locala.zWa);
        if ((locala.zWg != 1) || (locala.zVD >= locala.zVK) || (locala.zVD <= 0L) || (locala.zVK <= 0L)) {
          break label579;
        }
        l1 = locala.zVK - locala.zVD;
        long l2 = l1;
        if (locala.zWg == 0)
        {
          l2 = l1;
          if (locala.zVJ < locala.zVK)
          {
            l2 = l1;
            if (locala.zVJ > 0L)
            {
              l2 = l1;
              if (locala.zVK > 0L) {
                l2 = locala.zVK - locala.zVJ;
              }
            }
          }
        }
        localasy.SGd = ((int)l2);
        if ((locala.zVh > 0L) && (locala.zVg > 0L) && (locala.zVh > locala.zVg))
        {
          i = (int)(locala.zVh - locala.zVg);
          localasy.SGe = i;
          if (locala.zVh <= 0L) {
            break label525;
          }
          l1 = locala.zVh;
          if ((l1 <= 0L) || (locala.zVi <= 0L) || (locala.zVi <= l1)) {
            break label584;
          }
          i = (int)(locala.zVi - l1);
          localasy.SGf = i;
          localasy.zWj = locala.zWj;
          localasy.SGh = locala.zVQ;
          localLinkedList.add(localasy);
          Log.i("Finder.FinderLoadingTimeReporter", "finderFluencyInfo: scene = " + localasy.scene + ", pullType = " + localasy.pullType + ", globalInitMs = " + localasy.SGb + ',' + " pullCgiMs = " + localasy.SGc + ", showUiMs = " + localasy.SGd + ", downloadToDecodeMs = " + localasy.SGe + ',' + " decodeToFirstFrameMs = " + localasy.SGf + ", finishScene = " + localasy.zWj);
        }
      }
      int i = 0;
      continue;
      label525:
      if (locala.zVe > 0L)
      {
        l1 = locala.zVe;
        continue;
        label544:
        zVx.clear();
        localObject3 = x.aazN;
        ??? = (List)localObject2;
        AppMethodBeat.o(259286);
        return ???;
      }
      else
      {
        l1 = 0L;
        continue;
        label579:
        l1 = 0L;
        continue;
        label584:
        i = 0;
      }
    }
  }
  
  public static void dPs()
  {
    zVs = true;
  }
  
  public static void dPt()
  {
    AppMethodBeat.i(259255);
    zUH = cm.bfE();
    AppMethodBeat.o(259255);
  }
  
  public static void dPu()
  {
    zUH = 0L;
    zVs = false;
  }
  
  public static void dPw()
  {
    AppMethodBeat.i(259280);
    com.tencent.mm.ae.d.uiThread((a)b.zWn);
    AppMethodBeat.o(259280);
  }
  
  public static void e(int paramInt, bid parambid)
  {
    AppMethodBeat.i(259276);
    a locala = Ph(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.gX) && (!locala.zVz))
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
          if (parambid != null)
          {
            String str2 = parambid.sessionId;
            String str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.setSessionId(str1);
            str2 = parambid.wmz;
            str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.aDV(str1);
            locala.zVS = parambid.xkX;
          }
          if (locala.zVU != 0L)
          {
            AppMethodBeat.o(259276);
            return;
            i = 0;
            break;
            label125:
            locala = null;
            continue;
          }
          locala.zVK = cm.bfE();
          locala.zWc = 3;
          if ((locala.zVF > 0L) && (locala.zVG == 0L))
          {
            locala.zVG = locala.zVK;
            locala.zWc = 1;
          }
          if ((locala.zVH > 0L) && (locala.zVI == 0L))
          {
            locala.zVI = locala.zVK;
            locala.zWc = 2;
          }
          locala.zWj = 2;
          locala.zVU = 2L;
          if (locala.zVJ > 0L)
          {
            locala.zVz = true;
            a(locala, paramInt);
            AppMethodBeat.o(259276);
            return;
          }
          locala.zVA = true;
          AppMethodBeat.o(259276);
          return;
        }
      }
    }
    AppMethodBeat.o(259276);
  }
  
  public static void gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259273);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(259273);
      return;
    }
    a locala = Ph(paramInt1);
    if (locala != null)
    {
      if ((locala.gX) && (!locala.zVz))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label72;
        }
      }
      for (;;)
      {
        if (locala == null) {
          break label77;
        }
        locala.zWh += paramInt2;
        AppMethodBeat.o(259273);
        return;
        paramInt1 = 0;
        break;
        label72:
        locala = null;
      }
    }
    label77:
    AppMethodBeat.o(259273);
  }
  
  private static void z(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(259284);
    cx localcx = new cx();
    localcx.ahR();
    if (Pj(paramInt)) {}
    for (long l = 2L;; l = 1L)
    {
      localcx.gK(l);
      localcx.nX(paramString1);
      localcx.nZ(paramString2);
      localcx.bpa();
      Log.i("Finder.FinderLoadingTimeReporter", "report21680 info:" + localcx.agI());
      AppMethodBeat.o(259284);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "", "()V", "cgiAllCost", "", "getCgiAllCost", "()J", "setCgiAllCost", "(J)V", "cgiBackFeedCount", "", "getCgiBackFeedCount", "()I", "setCgiBackFeedCount", "(I)V", "cgiEndTimestamp", "getCgiEndTimestamp", "setCgiEndTimestamp", "cgiType", "getCgiType", "setCgiType", "clickEnter", "getClickEnter", "setClickEnter", "clickTabContextID", "", "getClickTabContextID", "()Ljava/lang/String;", "setClickTabContextID", "(Ljava/lang/String;)V", "commentScene", "getCommentScene", "setCommentScene", "debugMessage", "Lcom/tencent/mm/protobuf/ByteString;", "getDebugMessage", "()Lcom/tencent/mm/protobuf/ByteString;", "setDebugMessage", "(Lcom/tencent/mm/protobuf/ByteString;)V", "enterCost", "getEnterCost", "setEnterCost", "enterWithFirstPageData", "getEnterWithFirstPageData", "setEnterWithFirstPageData", "enterWithRedDot", "getEnterWithRedDot", "setEnterWithRedDot", "exitStatus", "getExitStatus", "setExitStatus", "feedIdType", "getFeedIdType", "setFeedIdType", "finishScene", "getFinishScene", "setFinishScene", "finishStatus", "getFinishStatus", "setFinishStatus", "firstFeedIsPhoto", "getFirstFeedIsPhoto", "setFirstFeedIsPhoto", "firstFeedShowTime", "getFirstFeedShowTime", "setFirstFeedShowTime", "getDetailCgiBegin", "getGetDetailCgiBegin", "setGetDetailCgiBegin", "getDetailCgiEnd", "getGetDetailCgiEnd", "setGetDetailCgiEnd", "getRelatedCgiBegin", "getGetRelatedCgiBegin", "setGetRelatedCgiBegin", "getRelatedCgiEnd", "getGetRelatedCgiEnd", "setGetRelatedCgiEnd", "hasBeenAppBackground", "getHasBeenAppBackground", "setHasBeenAppBackground", "historyCgiBegin", "getHistoryCgiBegin", "setHistoryCgiBegin", "historyCgiEnd", "getHistoryCgiEnd", "setHistoryCgiEnd", "historyCost", "getHistoryCost", "setHistoryCost", "isEnterLoad", "setEnterLoad", "isFinishLoad", "", "()Z", "setFinishLoad", "(Z)V", "isPrepared", "setPrepared", "isWaitingCgiBack", "setWaitingCgiBack", "loadCost", "getLoadCost", "setLoadCost", "loadingBegin", "getLoadingBegin", "setLoadingBegin", "loadingEnd", "getLoadingEnd", "setLoadingEnd", "pullType", "getPullType", "setPullType", "resumeToLoadingStartCost", "getResumeToLoadingStartCost", "setResumeToLoadingStartCost", "sessionId", "getSessionId", "setSessionId", "spanCgiCost", "getSpanCgiCost", "setSpanCgiCost", "streamCgiBegin", "getStreamCgiBegin", "setStreamCgiBegin", "streamCgiEnd", "getStreamCgiEnd", "setStreamCgiEnd", "streamCost", "getStreamCost", "setStreamCost", "tabResume", "getTabResume", "setTabResume", "tabType", "getTabType", "setTabType", "trulyLoadingBeginWhenEnterLoad", "getTrulyLoadingBeginWhenEnterLoad", "setTrulyLoadingBeginWhenEnterLoad", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder-base_release"})
  public static final class a
  {
    int fEH;
    public boolean gX;
    String sessionId = "";
    boolean zVA;
    long zVB;
    long zVC;
    long zVD;
    long zVE;
    long zVF;
    long zVG;
    long zVH;
    long zVI;
    long zVJ;
    long zVK;
    long zVL;
    long zVM;
    long zVN;
    long zVO;
    public long zVP;
    com.tencent.mm.cd.b zVQ;
    String zVR = "";
    long zVS;
    long zVT;
    long zVU;
    long zVV;
    long zVW;
    long zVX;
    long zVY;
    long zVZ;
    long zVe;
    long zVg;
    long zVh;
    long zVi;
    public boolean zVz;
    long zWa;
    long zWb;
    int zWc;
    int zWd;
    int zWe;
    int zWf;
    public int zWg;
    int zWh;
    int zWi;
    int zWj;
    int zWk;
    public int zWl;
    long zWm;
    
    public final void aDV(String paramString)
    {
      AppMethodBeat.i(259598);
      p.k(paramString, "<set-?>");
      this.zVR = paramString;
      AppMethodBeat.o(259598);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(259597);
      p.k(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(259597);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    public static final b zWn;
    
    static
    {
      AppMethodBeat.i(258955);
      zWn = new b();
      AppMethodBeat.o(258955);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */
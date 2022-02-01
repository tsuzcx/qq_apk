package com.tencent.mm.plugin.finder.report;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter;", "", "()V", "CGI_TYPE_HISTORY", "", "CGI_TYPE_OTHER", "CGI_TYPE_STREAM", "CGI_TYPE_STREAM_AND_HISTORY", "INNER_VERSION_20672", "INNER_VERSION_21680", "LOADING_STATUS_FAIL", "LOADING_STATUS_FINISH_BY_USER", "LOADING_STATUS_SUCCESS", "TAG", "", "WAITING_TIME_OUT", "clickEnterTime", "enterFinderWithRedDot", "", "laterReportCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "loadingTimeConsumeDataMap", "recordStandingTimeMap", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabResumeTimeMap", "addCgiBackFeedCount", "", "tabType", "count", "applyClickEnterTime", "buildExtraInfoJson", "Lorg/json/JSONObject;", "data", "cacheLateReportData", "clearClickEnterTime", "genClickEnterTime", "getData", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isOutSideEnterFinderTabType", "isSupport20672TabType", "isSupportCgiReportTabType", "isSupportReportPullType", "pullType", "isSupportTabTabType", "notifyAppBackground", "notifyCgiEnd", "clear", "notifyDecodeStart", "notifyEnterLoad", "notifyFinishScene", "isChangeTab", "notifyFirstFeedShow", "notifyFirstPageData", "hasData", "notifyGetDetailCgi", "isBegin", "hasFeedId", "hasEncryptId", "notifyGetRelatedCgi", "notifyHistoryCgi", "notifyLoadingStatus", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstFeedIsPhoto", "notifyStreamCgi", "message", "Lcom/tencent/mm/protobuf/ByteString;", "notifyUsePreloadCache", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPlay", "onTabResume", "prepare", "cgiType", "report20672and20713", "report21680", "json", "reportCacheData", "reportFailed", "reportFinishByUser", "reportTimeConsumingIDKey", "FinderGlobalRptType", "TimeConsumeData", "plugin-finder_release"})
public final class h
{
  private static long vem;
  private static boolean ven;
  private static final ConcurrentHashMap<Integer, a> veo;
  private static final ConcurrentHashMap<Integer, Long> vep;
  private static final ConcurrentHashMap<Integer, a> veq;
  private static final ConcurrentHashMap<a, Integer> ves;
  private static final HashSet<a> vet;
  public static final h veu;
  
  static
  {
    AppMethodBeat.i(250598);
    veu = new h();
    veo = new ConcurrentHashMap();
    vep = new ConcurrentHashMap();
    veq = new ConcurrentHashMap();
    ves = new ConcurrentHashMap();
    vet = new HashSet();
    AppMethodBeat.o(250598);
  }
  
  public static a Kd(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(250562);
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
      AppMethodBeat.o(250562);
      return null;
    }
    a locala2 = (a)veo.get(Integer.valueOf(paramInt));
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (!locala2.vev) {}
    }
    else
    {
      locala1 = new a();
      locala1.dLS = paramInt;
      ((Map)veo).put(Integer.valueOf(paramInt), locala1);
    }
    AppMethodBeat.o(250562);
    return locala1;
  }
  
  private static boolean Ke(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 5);
  }
  
  private static boolean Kf(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 5) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  private static boolean Kg(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1);
  }
  
  public static void Kh(int paramInt)
  {
    AppMethodBeat.i(250565);
    a locala = (a)veq.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.vee = cl.aWA();
      AppMethodBeat.o(250565);
      return;
    }
    AppMethodBeat.o(250565);
  }
  
  public static void Ki(int paramInt)
  {
    AppMethodBeat.i(250566);
    a locala = (a)veq.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.veg = cl.aWA();
      if ((locala.veR == 0L) && (locala.vex > 0L))
      {
        Map localMap = (Map)ves;
        p.g(locala, "it");
        localMap.put(locala, Integer.valueOf(paramInt));
      }
      for (;;)
      {
        veq.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(250566);
        return;
        p.g(locala, "it");
        a(locala, paramInt);
      }
    }
    AppMethodBeat.o(250566);
  }
  
  public static void Kj(int paramInt)
  {
    AppMethodBeat.i(250567);
    a locala = (a)veq.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.vef = cl.aWA();
      AppMethodBeat.o(250567);
      return;
    }
    AppMethodBeat.o(250567);
  }
  
  public static void Kk(int paramInt)
  {
    AppMethodBeat.i(250568);
    a locala = (a)veq.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.vec = cl.aWA();
      AppMethodBeat.o(250568);
      return;
    }
    AppMethodBeat.o(250568);
  }
  
  public static void Kl(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(250570);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      long l1;
      if (vem > 0L)
      {
        locala.vex = vem;
        Long localLong = (Long)vep.get(Integer.valueOf(paramInt));
        if (localLong == null) {
          break label124;
        }
        l1 = localLong.longValue();
        locala.vey = l1;
        vem = 0L;
        l1 = l2;
        if (locala.vey > 0L) {
          l1 = locala.vey - locala.vex;
        }
        locala.veS = l1;
        if (!ven) {
          break label129;
        }
      }
      label129:
      for (paramInt = 1;; paramInt = 0)
      {
        locala.vfa = paramInt;
        ven = false;
        AppMethodBeat.o(250570);
        return;
        label124:
        l1 = 0L;
        break;
      }
    }
    AppMethodBeat.o(250570);
  }
  
  public static void Km(int paramInt)
  {
    AppMethodBeat.i(250572);
    ((Map)vep).put(Integer.valueOf(paramInt), Long.valueOf(cl.aWA()));
    AppMethodBeat.o(250572);
  }
  
  public static void Kn(int paramInt)
  {
    AppMethodBeat.i(250590);
    if (paramInt != -1)
    {
      localObject = (a)veq.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        p.g(localObject, "this");
        a((a)localObject, paramInt);
      }
      veq.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(250590);
      return;
    }
    Object localObject = ((Map)veq).entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getValue(), ((Number)localEntry.getKey()).intValue());
    }
    veq.clear();
    localObject = ((Map)ves).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getKey(), ((Number)localEntry.getValue()).intValue());
    }
    ves.clear();
    AppMethodBeat.o(250590);
  }
  
  private static JSONObject a(a parama)
  {
    AppMethodBeat.i(250594);
    if ((parama.veB > 0L) && (parama.veC > 0L) && (parama.veC > parama.veB)) {
      parama.veT = (parama.veC - parama.veB);
    }
    if ((parama.veD > 0L) && (parama.veE > 0L) && (parama.veE > parama.veD)) {
      parama.veV = (parama.veE - parama.veD);
    }
    if ((parama.veC > 0L) && (parama.veD > 0L) && (parama.veD > parama.veC)) {
      parama.veU = (parama.veD - parama.veC);
    }
    parama.veW = (parama.veT + parama.veV + parama.veU);
    long l1;
    long l4;
    label218:
    long l2;
    long l5;
    long l6;
    long l3;
    label262:
    int i;
    if ((parama.veR == 0L) && (parama.vex > 0L))
    {
      l1 = parama.veG - parama.vex;
      parama.veX = l1;
      if ((parama.veF <= 0L) || (parama.veF >= parama.veG)) {
        break label731;
      }
      l4 = parama.veG - parama.veF;
      l2 = parama.veX;
      l5 = 0L;
      l6 = 0L;
      l3 = 0L;
      if (parama.veg <= 0L) {
        break label757;
      }
      if (parama.vee <= 0L) {
        break label737;
      }
      l2 = parama.veg - parama.vee;
      i = 1;
      l3 = cl.aWA() - parama.veg;
      l1 = l3;
      if (l3 > 10000L)
      {
        i = 3;
        l1 = 10000L;
      }
      if ((parama.veR != 0L) || (parama.vex <= 0L)) {
        break label743;
      }
      l3 = parama.veg - parama.vex;
      label321:
      l5 = l2;
      l2 = l3;
      l3 = l6;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enterCost", parama.veS);
      localJSONObject.put("resumeToLoadingStartCost", parama.vfi);
      if (Kf(parama.dLS))
      {
        if (parama.veL > 0L)
        {
          l1 = parama.veL - parama.vez;
          label397:
          localJSONObject.put("firstFeedShowCost", l1);
          if ((parama.veI <= parama.veH) || (parama.veH <= 0L)) {
            break label841;
          }
          l1 = parama.veI - parama.veH;
          label438:
          localJSONObject.put("getDetailCost", l1);
          if ((parama.veK <= parama.veJ) || (parama.veJ <= 0L)) {
            break label846;
          }
        }
        label841:
        label846:
        for (l1 = parama.veK - parama.veJ;; l1 = 0L)
        {
          localJSONObject.put("getRelatedCost", l1);
          localJSONObject.put("cgiEndToLoadingEndCost", l4);
          localJSONObject.put("loadCost", parama.veX);
          localJSONObject.put("loadCostWitchActivityCost", parama.veG - parama.vez);
          localJSONObject.put("feedIdType", parama.vfe);
          localJSONObject.put("cgiBackFeedCount", parama.vfd);
          localJSONObject.put("finishStatus", parama.veQ);
          localJSONObject.put("commentScene", parama.veO);
          localJSONObject.put("tabType", parama.dLS);
          localJSONObject.put("pullType", parama.veR);
          localJSONObject.put("api", Build.VERSION.SDK_INT);
          localJSONObject.put("hasBeenAppBackground", parama.vfg);
          if (parama.veS > 0L)
          {
            localJSONObject.put("isEnterLoad", parama.vfh);
            c localc = c.vCb;
            localJSONObject.put("finderEnterLoadSwitch", ((Number)c.dwX().value()).intValue());
          }
          if ((parama.veS > 0L) && (i == 3)) {
            com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 30L, 1L);
          }
          AppMethodBeat.o(250594);
          return localJSONObject;
          l1 = parama.veG - parama.vez;
          break;
          label731:
          l4 = 0L;
          break label218;
          label737:
          l2 = 0L;
          break label262;
          label743:
          l3 = parama.veg - parama.vez;
          break label321;
          label757:
          if (parama.vee <= 0L) {
            break label1116;
          }
          l2 = cl.aWA();
          l6 = parama.vee;
          if ((parama.veR == 0L) && (parama.vex > 0L)) {}
          for (l1 = l2 - parama.vex;; l1 = l2 - parama.vez)
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
      localJSONObject.put("streamCost", parama.veT);
      localJSONObject.put("spanCgiCost", parama.veU);
      localJSONObject.put("historyCost", parama.veV);
      localJSONObject.put("cgiAllCost", parama.veW);
      localJSONObject.put("loadCost", parama.veX);
      localJSONObject.put("cgiEndToLoadingEndCost", l4);
      localJSONObject.put("startDownloadTimeStamp", parama.vee);
      localJSONObject.put("videoDecodeStartTimeStamp", parama.vef);
      localJSONObject.put("firstFrameDrawTimeStamp", parama.veg);
      localJSONObject.put("downLoadToFirstFrameDrawCost", l5);
      localJSONObject.put("downloadToExitCost", l3);
      localJSONObject.put("totalCost", l2);
      localJSONObject.put("firstFrameStatus", i);
      localJSONObject.put("standingMsAfterFirstFrame", l1);
      localJSONObject.put("exitStatus", parama.veY);
      localJSONObject.put("firstFeedIsPhoto", parama.veZ);
      localJSONObject.put("enterWithRedDot", parama.vfa);
      if (parama.veS > 0L) {}
      for (int j = parama.vfb;; j = 0)
      {
        localJSONObject.put("enterWithFirstPageData", j);
        localJSONObject.put("cgiBackFeedCount", parama.vfd);
        localJSONObject.put("usePreloadCache", parama.vfc);
        break;
      }
      label1116:
      i = 0;
      l1 = l3;
      l3 = l6;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, bbn parambbn, long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(250563);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {}
    for (int i = 1; (i == 0) || (parambbn == null); i = 0)
    {
      Log.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + paramInt1 + ", contextObj = " + parambbn);
      AppMethodBeat.o(250563);
      return;
    }
    Object localObject1 = Kd(paramInt1);
    if (localObject1 != null)
    {
      if ((((a)localObject1).ZA) && (!((a)localObject1).vev))
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
          if ((((a)localObject1).vfh == 1) && (!((a)localObject1).vew) && (paramInt2 == 0))
          {
            Log.i("Finder.FinderLoadingTimeReporter", "prepare: remove duplicate enter report");
            AppMethodBeat.o(250563);
            return;
            i = 0;
            break;
            label164:
            localObject1 = null;
            continue;
          }
          if ((((a)localObject1).veF != 0L) || (((a)localObject1).veQ != 2L)) {
            break label315;
          }
          i = 1;
          if (i != 0) {
            localObject2 = localObject1;
          }
          if (localObject2 == null) {
            break label321;
          }
          ap(paramInt1, false);
        }
      }
    }
    for (;;)
    {
      a locala = Kd(paramInt1);
      if (locala == null) {
        break label336;
      }
      locala.ZA = true;
      locala.veR = paramInt2;
      localObject2 = parambbn.sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      locala.setSessionId((String)localObject1);
      localObject2 = parambbn.sGE;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      locala.auD((String)localObject1);
      locala.veO = parambbn.tCE;
      locala.veP = paramLong;
      AppMethodBeat.o(250563);
      return;
      label315:
      i = 0;
      break;
      label321:
      ((a)localObject1).vev = true;
      a((a)localObject1, paramInt1);
    }
    label336:
    AppMethodBeat.o(250563);
  }
  
  public static void a(int paramInt, boolean paramBoolean, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(250575);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
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
        locala.veB = cl.aWA();
        if (locala.veP != 0L) {
          break label92;
        }
      }
      label86:
      label92:
      for (long l = 1L;; l = 3L)
      {
        locala.veP = l;
        AppMethodBeat.o(250575);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label99:
      locala.veC = cl.aWA();
      locala.veM = paramb;
      AppMethodBeat.o(250575);
      return;
    }
    label120:
    AppMethodBeat.o(250575);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, bbn parambbn, boolean paramBoolean2)
  {
    long l2 = 0L;
    AppMethodBeat.i(250573);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
      {
        i = 1;
        if (i == 0) {
          break label201;
        }
        label44:
        if (locala == null) {
          break label417;
        }
        if (parambbn != null)
        {
          String str2 = parambbn.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambbn.sGE;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.auD(str1);
          locala.veO = parambbn.tCE;
        }
        if (!paramBoolean1) {
          break label276;
        }
        if ((locala.vez <= 0L) || (locala.vfh != 1)) {
          break label213;
        }
        locala.veA = cl.aWA();
        if ((locala.veS <= 0L) || (locala.vey <= 0L)) {
          break label207;
        }
      }
      label201:
      label207:
      for (long l1 = locala.veA - locala.vey;; l1 = 0L)
      {
        locala.vfi = l1;
        AppMethodBeat.o(250573);
        return;
        i = 0;
        break;
        locala = null;
        break label44;
      }
      label213:
      locala.vez = cl.aWA();
      l1 = l2;
      if (locala.veS > 0L)
      {
        l1 = l2;
        if (locala.vey > 0L) {
          l1 = locala.vez - locala.vey;
        }
      }
      locala.vfi = l1;
      AppMethodBeat.o(250573);
      return;
      label276:
      locala.vev = true;
      locala.veG = cl.aWA();
      locala.veQ = 1L;
      if (paramBoolean2) {}
      for (int i = 1;; i = 0)
      {
        locala.veZ = i;
        if (locala.vff == 0) {
          locala.vff = 1;
        }
        if (((paramInt != 4) && (paramInt != 3) && (paramInt != 1)) || (paramBoolean2)) {
          break;
        }
        parambbn = (a)veq.get(Integer.valueOf(paramInt));
        if (parambbn != null)
        {
          p.g(parambbn, "this");
          a(parambbn, paramInt);
        }
        ((Map)veq).put(Integer.valueOf(paramInt), locala);
        AppMethodBeat.o(250573);
        return;
      }
      a(locala, paramInt);
      AppMethodBeat.o(250573);
      return;
    }
    label417:
    AppMethodBeat.o(250573);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(250593);
    by localby = new by();
    localby.kC(parama.sessionId);
    localby.kD(parama.veN);
    localby.fb(parama.veO);
    localby.fc(parama.veP);
    long l2 = parama.veG;
    long l1;
    if (parama.vfh == 1)
    {
      l1 = parama.veA;
      localby.fd(l2 - l1);
      if (parama.vfc != 0) {
        break label320;
      }
      l1 = parama.vez;
      label96:
      localby.fe(l1);
      localObject = a(parama).toString();
      p.g(localObject, "buildExtraInfoJson(data).toString()");
      localby.kE(n.j((String)localObject, ",", ";", false));
      localby.ff(parama.veQ);
      localby.acS();
      localby.fg(parama.veR);
      if (parama.vfc != 0) {
        break label325;
      }
      l1 = parama.veF;
      label176:
      localby.fh(l1);
      if ((localby.acV() >= localby.acQ()) && (localby.acP() > 0L) && (parama.veX > 0L))
      {
        localObject = (CharSequence)localby.acA();
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label330;
        }
        i = 1;
        label243:
        if (i == 0) {
          break label340;
        }
        localObject = (CharSequence)localby.acM();
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
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
      Log.w("Finder.FinderLoadingTimeReporter", "report20672and20713 error info:" + localby.abW());
      AppMethodBeat.o(250593);
      return;
      l1 = parama.vez;
      break;
      l1 = 0L;
      break label96;
      l1 = 0L;
      break label176;
      i = 0;
      break label243;
    }
    label340:
    if (Ke(paramInt))
    {
      localby.bfK();
      localObject = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)localby);
    }
    if ((parama.veW > 600000L) || (parama.veX > 600000L) || (parama.veS < 0L))
    {
      Log.e("Finder.FinderLoadingTimeReporter", "report20672and20713 waiting time out cgiAllCost = " + parama.veW + ", loadCost = " + parama.veX + ", enterCose = " + parama.veS);
      AppMethodBeat.o(250593);
      return;
    }
    if (Kg(paramInt)) {
      b(parama);
    }
    Object localObject = new bx();
    ((bx)localObject).kz(localby.acA());
    ((bx)localObject).kA(localby.acM());
    ((bx)localObject).eT(localby.acN());
    ((bx)localObject).eU(localby.acO());
    ((bx)localObject).eV(localby.acP());
    ((bx)localObject).eW(localby.acQ());
    ((bx)localObject).kB(localby.getExtraInfo());
    ((bx)localObject).eX(localby.acR());
    ((bx)localObject).eY(localby.acT());
    ((bx)localObject).eZ(localby.acU());
    ((bx)localObject).fa(localby.acV());
    ((bx)localObject).bfK();
    Log.i("Finder.FinderLoadingTimeReporter", "report20672and20713 info:" + ((bx)localObject).abW());
    if (Kg(paramInt)) {
      vet.add(parama);
    }
    parama = localby.getExtraInfo();
    p.g(parama, "struct.extraInfo");
    aZ(paramInt, parama);
    AppMethodBeat.o(250593);
  }
  
  private static void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(250595);
    cg localcg = new cg();
    localcg.adb();
    if (Kf(paramInt)) {}
    for (long l = 2L;; l = 1L)
    {
      localcg.fS(l);
      localcg.lH(paramString);
      localcg.bfK();
      Log.i("Finder.FinderLoadingTimeReporter", "report21680 info:" + localcg.abW());
      AppMethodBeat.o(250595);
      return;
    }
  }
  
  public static void an(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250571);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        locala.vfb = paramInt;
        AppMethodBeat.o(250571);
        return;
      }
    }
    AppMethodBeat.o(250571);
  }
  
  public static void ao(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250577);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
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
        locala.veD = cl.aWA();
        if (locala.veP != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 2L;; l = 3L)
      {
        locala.veP = l;
        AppMethodBeat.o(250577);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label101:
      locala.veE = cl.aWA();
      AppMethodBeat.o(250577);
      return;
    }
    label116:
    AppMethodBeat.o(250577);
  }
  
  public static void ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250578);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.ZA) && (!locala.vev))
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
            locala.veF = 0L;
            AppMethodBeat.o(250578);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          if ((locala.veF > 0L) && (locala.vfh == 1))
          {
            AppMethodBeat.o(250578);
            return;
          }
          locala.veF = cl.aWA();
          if (locala.veQ == 2L)
          {
            locala.vev = true;
            locala.vew = false;
            a(locala, paramInt);
          }
          AppMethodBeat.o(250578);
          return;
        }
      }
    }
    AppMethodBeat.o(250578);
  }
  
  public static void aq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250582);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
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
            locala.veJ = cl.aWA();
            AppMethodBeat.o(250582);
            return;
            paramInt = 0;
            break;
            label62:
            locala = null;
            continue;
          }
          locala.veK = cl.aWA();
          AppMethodBeat.o(250582);
          return;
        }
      }
    }
    AppMethodBeat.o(250582);
  }
  
  public static void ar(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250583);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label69;
        }
        label35:
        if (locala == null) {
          break label79;
        }
        if (locala.vff == 0) {
          if (!paramBoolean) {
            break label74;
          }
        }
      }
      label69:
      label74:
      for (paramInt = 3;; paramInt = 4)
      {
        locala.vff = paramInt;
        AppMethodBeat.o(250583);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label35;
      }
    }
    label79:
    AppMethodBeat.o(250583);
  }
  
  public static void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    AppMethodBeat.i(250580);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
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
        locala.veH = cl.aWA();
        if ((!paramBoolean2) || (!paramBoolean3)) {
          break label93;
        }
        paramInt = 3;
      }
      for (;;)
      {
        locala.vfe = paramInt;
        AppMethodBeat.o(250580);
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
      locala.veI = cl.aWA();
      AppMethodBeat.o(250580);
      return;
    }
    label120:
    AppMethodBeat.o(250580);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(250597);
    if (parama.veQ == 1L)
    {
      if (parama.veT > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 0L, parama.veT);
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 3L, 1L);
      }
      if (parama.veV > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 1L, parama.veV);
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 4L, 1L);
      }
      if ((parama.veT > 0L) && (parama.veV > 0L))
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 2L, parama.veW);
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 5L, 1L);
      }
      if (parama.veS > 0L)
      {
        if (parama.veW > 0L) {}
        switch (parama.dLS)
        {
        case 2: 
        default: 
          com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 20L, parama.veS);
          com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 21L, 1L);
          l = parama.vez - parama.vey;
          if (l > 0L)
          {
            com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 23L, l);
            com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 24L, 1L);
          }
          if (parama.veF >= parama.veG) {
            break;
          }
        }
      }
    }
    for (long l = parama.veG - parama.veF;; l = 0L)
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 26L, l);
        com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 27L, 1L);
      }
      AppMethodBeat.o(250597);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 10L, parama.veW);
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 11L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 13L, parama.veW);
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 14L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 16L, parama.veW);
      com.tencent.mm.plugin.report.service.h.CyF.n(1458L, 17L, 1L);
      break;
    }
  }
  
  public static void d(int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(250586);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.ZA) && (!locala.vev))
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
        if (parambbn != null)
        {
          String str2 = parambbn.sessionId;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.setSessionId(str1);
          str2 = parambbn.sGE;
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          locala.auD(str1);
          locala.veO = parambbn.tCE;
        }
        locala.vev = true;
        locala.veG = cl.aWA();
        if ((locala.veB > 0L) && (locala.veC == 0L)) {
          locala.veC = locala.veG;
        }
        if ((locala.veD > 0L) && (locala.veE == 0L)) {
          locala.veE = locala.veG;
        }
        locala.veQ = 3L;
        a(locala, paramInt);
        AppMethodBeat.o(250586);
        return;
        i = 0;
        break;
        label192:
        locala = null;
      }
    }
    label197:
    AppMethodBeat.o(250586);
  }
  
  public static List<arc> dnP()
  {
    AppMethodBeat.i(250596);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject3;
      a locala;
      long l1;
      synchronized (vet)
      {
        localObject3 = ((Iterable)vet).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label544;
        }
        locala = (a)((Iterator)localObject3).next();
        arc localarc = new arc();
        localarc.scene = 2;
        localarc.pullType = ((int)locala.veR);
        localarc.LCP = ((int)locala.veS);
        localarc.LCQ = ((int)locala.veW);
        if ((locala.vfc != 1) || (locala.vez >= locala.veG) || (locala.vez <= 0L) || (locala.veG <= 0L)) {
          break label579;
        }
        l1 = locala.veG - locala.vez;
        long l2 = l1;
        if (locala.vfc == 0)
        {
          l2 = l1;
          if (locala.veF < locala.veG)
          {
            l2 = l1;
            if (locala.veF > 0L)
            {
              l2 = l1;
              if (locala.veG > 0L) {
                l2 = locala.veG - locala.veF;
              }
            }
          }
        }
        localarc.LCR = ((int)l2);
        if ((locala.vef > 0L) && (locala.vee > 0L) && (locala.vef > locala.vee))
        {
          i = (int)(locala.vef - locala.vee);
          localarc.LCS = i;
          if (locala.vef <= 0L) {
            break label525;
          }
          l1 = locala.vef;
          if ((l1 <= 0L) || (locala.veg <= 0L) || (locala.veg <= l1)) {
            break label584;
          }
          i = (int)(locala.veg - l1);
          localarc.LCT = i;
          localarc.vff = locala.vff;
          localarc.LCV = locala.veM;
          localLinkedList.add(localarc);
          Log.i("Finder.FinderLoadingTimeReporter", "finderFluencyInfo: scene = " + localarc.scene + ", pullType = " + localarc.pullType + ", globalInitMs = " + localarc.LCP + ',' + " pullCgiMs = " + localarc.LCQ + ", showUiMs = " + localarc.LCR + ", downloadToDecodeMs = " + localarc.LCS + ',' + " decodeToFirstFrameMs = " + localarc.LCT + ", finishScene = " + localarc.vff);
        }
      }
      int i = 0;
      continue;
      label525:
      if (locala.vec > 0L)
      {
        l1 = locala.vec;
        continue;
        label544:
        vet.clear();
        localObject3 = x.SXb;
        ??? = (List)localObject2;
        AppMethodBeat.o(250596);
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
  
  public static void dnR()
  {
    ven = true;
  }
  
  public static void dnS()
  {
    AppMethodBeat.i(250569);
    vem = cl.aWA();
    AppMethodBeat.o(250569);
  }
  
  public static void dnT()
  {
    vem = 0L;
    ven = false;
  }
  
  public static void dnV()
  {
    AppMethodBeat.i(250592);
    d.h((kotlin.g.a.a)b.vfj);
    AppMethodBeat.o(250592);
  }
  
  public static void e(int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(250588);
    a locala = Kd(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.ZA) && (!locala.vev))
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
          if (parambbn != null)
          {
            String str2 = parambbn.sessionId;
            String str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.setSessionId(str1);
            str2 = parambbn.sGE;
            str1 = str2;
            if (str2 == null) {
              str1 = "";
            }
            locala.auD(str1);
            locala.veO = parambbn.tCE;
          }
          if (locala.veQ != 0L)
          {
            AppMethodBeat.o(250588);
            return;
            i = 0;
            break;
            label125:
            locala = null;
            continue;
          }
          locala.veG = cl.aWA();
          locala.veY = 3;
          if ((locala.veB > 0L) && (locala.veC == 0L))
          {
            locala.veC = locala.veG;
            locala.veY = 1;
          }
          if ((locala.veD > 0L) && (locala.veE == 0L))
          {
            locala.veE = locala.veG;
            locala.veY = 2;
          }
          locala.vff = 2;
          locala.veQ = 2L;
          if (locala.veF > 0L)
          {
            locala.vev = true;
            a(locala, paramInt);
            AppMethodBeat.o(250588);
            return;
          }
          locala.vew = true;
          AppMethodBeat.o(250588);
          return;
        }
      }
    }
    AppMethodBeat.o(250588);
  }
  
  public static void gd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250585);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(250585);
      return;
    }
    a locala = Kd(paramInt1);
    if (locala != null)
    {
      if ((locala.ZA) && (!locala.vev))
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
        locala.vfd += paramInt2;
        AppMethodBeat.o(250585);
        return;
        paramInt1 = 0;
        break;
        label72:
        locala = null;
      }
    }
    label77:
    AppMethodBeat.o(250585);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "", "()V", "cgiAllCost", "", "getCgiAllCost", "()J", "setCgiAllCost", "(J)V", "cgiBackFeedCount", "", "getCgiBackFeedCount", "()I", "setCgiBackFeedCount", "(I)V", "cgiEndTimestamp", "getCgiEndTimestamp", "setCgiEndTimestamp", "cgiType", "getCgiType", "setCgiType", "clickEnter", "getClickEnter", "setClickEnter", "clickTabContextID", "", "getClickTabContextID", "()Ljava/lang/String;", "setClickTabContextID", "(Ljava/lang/String;)V", "commentScene", "getCommentScene", "setCommentScene", "debugMessage", "Lcom/tencent/mm/protobuf/ByteString;", "getDebugMessage", "()Lcom/tencent/mm/protobuf/ByteString;", "setDebugMessage", "(Lcom/tencent/mm/protobuf/ByteString;)V", "enterCost", "getEnterCost", "setEnterCost", "enterWithFirstPageData", "getEnterWithFirstPageData", "setEnterWithFirstPageData", "enterWithRedDot", "getEnterWithRedDot", "setEnterWithRedDot", "exitStatus", "getExitStatus", "setExitStatus", "feedIdType", "getFeedIdType", "setFeedIdType", "finishScene", "getFinishScene", "setFinishScene", "finishStatus", "getFinishStatus", "setFinishStatus", "firstFeedIsPhoto", "getFirstFeedIsPhoto", "setFirstFeedIsPhoto", "firstFeedShowTime", "getFirstFeedShowTime", "setFirstFeedShowTime", "getDetailCgiBegin", "getGetDetailCgiBegin", "setGetDetailCgiBegin", "getDetailCgiEnd", "getGetDetailCgiEnd", "setGetDetailCgiEnd", "getRelatedCgiBegin", "getGetRelatedCgiBegin", "setGetRelatedCgiBegin", "getRelatedCgiEnd", "getGetRelatedCgiEnd", "setGetRelatedCgiEnd", "hasBeenAppBackground", "getHasBeenAppBackground", "setHasBeenAppBackground", "historyCgiBegin", "getHistoryCgiBegin", "setHistoryCgiBegin", "historyCgiEnd", "getHistoryCgiEnd", "setHistoryCgiEnd", "historyCost", "getHistoryCost", "setHistoryCost", "isEnterLoad", "setEnterLoad", "isFinishLoad", "", "()Z", "setFinishLoad", "(Z)V", "isPrepared", "setPrepared", "isWaitingCgiBack", "setWaitingCgiBack", "loadCost", "getLoadCost", "setLoadCost", "loadingBegin", "getLoadingBegin", "setLoadingBegin", "loadingEnd", "getLoadingEnd", "setLoadingEnd", "pullType", "getPullType", "setPullType", "resumeToLoadingStartCost", "getResumeToLoadingStartCost", "setResumeToLoadingStartCost", "sessionId", "getSessionId", "setSessionId", "spanCgiCost", "getSpanCgiCost", "setSpanCgiCost", "streamCgiBegin", "getStreamCgiBegin", "setStreamCgiBegin", "streamCgiEnd", "getStreamCgiEnd", "setStreamCgiEnd", "streamCost", "getStreamCost", "setStreamCost", "tabResume", "getTabResume", "setTabResume", "tabType", "getTabType", "setTabType", "trulyLoadingBeginWhenEnterLoad", "getTrulyLoadingBeginWhenEnterLoad", "setTrulyLoadingBeginWhenEnterLoad", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public boolean ZA;
    int dLS;
    String sessionId = "";
    long veA;
    long veB;
    long veC;
    long veD;
    long veE;
    long veF;
    long veG;
    long veH;
    long veI;
    long veJ;
    long veK;
    public long veL;
    com.tencent.mm.bw.b veM;
    String veN = "";
    long veO;
    long veP;
    long veQ;
    long veR;
    long veS;
    long veT;
    long veU;
    long veV;
    long veW;
    long veX;
    int veY;
    int veZ;
    long vec;
    long vee;
    long vef;
    long veg;
    public boolean vev;
    boolean vew;
    long vex;
    long vey;
    long vez;
    int vfa;
    int vfb;
    public int vfc;
    int vfd;
    int vfe;
    int vff;
    int vfg;
    public int vfh;
    long vfi;
    
    public final void auD(String paramString)
    {
      AppMethodBeat.i(250559);
      p.h(paramString, "<set-?>");
      this.veN = paramString;
      AppMethodBeat.o(250559);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(250558);
      p.h(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(250558);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final b vfj;
    
    static
    {
      AppMethodBeat.i(250561);
      vfj = new b();
      AppMethodBeat.o(250561);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */
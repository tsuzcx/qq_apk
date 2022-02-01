package com.tencent.mm.plugin.finder.report;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter;", "", "()V", "CGI_TYPE_HISTORY", "", "CGI_TYPE_OTHER", "CGI_TYPE_STREAM", "CGI_TYPE_STREAM_AND_HISTORY", "INNER_VERSION_20672", "LOADING_STATUS_FAIL", "LOADING_STATUS_FINISH_BY_USER", "LOADING_STATUS_SUCCESS", "TAG", "", "clickEnterTime", "enterFinderWithRedDot", "", "laterReportCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "loadingTimeConsumeDataMap", "recordStandingTimeMap", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabResumeTimeMap", "addCgiBackFeedCount", "", "tabType", "count", "applyClickEnterTime", "buildExtraInfoJson", "Lorg/json/JSONObject;", "data", "cacheLateReportData", "clearClickEnterTime", "genClickEnterTime", "getData", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isSupportCgiReportTabType", "isSupportReportPullType", "pullType", "isSupportTabTabType", "notifyCgiEnd", "clear", "notifyDecodeStart", "notifyFinishScene", "isChangeTab", "notifyFirstPageData", "hasData", "notifyHistoryCgi", "isBegin", "notifyLoadingStatus", "firstFeedIsPhoto", "notifyStreamCgi", "notifyUsePreloadCache", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPlay", "onTabResume", "prepare", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "cgiType", "report20672and20713", "reportCacheData", "reportFailed", "reportFinishByUser", "TimeConsumeData", "plugin-finder_release"})
public final class f
{
  private static long sxV;
  private static boolean sxW;
  private static final ConcurrentHashMap<Integer, a> sxX;
  private static final ConcurrentHashMap<Integer, Long> sxY;
  private static final ConcurrentHashMap<Integer, a> sxZ;
  private static final ConcurrentHashMap<a, Integer> sya;
  private static final HashSet<a> syb;
  public static final f syc;
  
  static
  {
    AppMethodBeat.i(203785);
    syc = new f();
    sxX = new ConcurrentHashMap();
    sxY = new ConcurrentHashMap();
    sxZ = new ConcurrentHashMap();
    sya = new ConcurrentHashMap();
    syb = new HashSet();
    AppMethodBeat.o(203785);
  }
  
  public static a Fe(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(203759);
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
            if (paramInt != 6) {
              if (paramInt != 5) {
                break label61;
              }
            }
          }
        }
      }
    }
    label61:
    for (i = j; i == 0; i = 0)
    {
      AppMethodBeat.o(203759);
      return null;
    }
    a locala2 = (a)sxX.get(Integer.valueOf(paramInt));
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (!locala2.syd) {}
    }
    else
    {
      locala1 = new a();
      locala1.dvm = paramInt;
      ((Map)sxX).put(Integer.valueOf(paramInt), locala1);
    }
    AppMethodBeat.o(203759);
    return locala1;
  }
  
  private static boolean Ff(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1);
  }
  
  public static void Fg(int paramInt)
  {
    AppMethodBeat.i(203762);
    a locala = (a)sxZ.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.sxR = ch.aDc();
      AppMethodBeat.o(203762);
      return;
    }
    AppMethodBeat.o(203762);
  }
  
  public static void Fh(int paramInt)
  {
    AppMethodBeat.i(203763);
    a locala = (a)sxZ.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.sxT = ch.aDc();
      if ((locala.syr == 0L) && (locala.sye > 0L))
      {
        Map localMap = (Map)sya;
        p.g(locala, "it");
        localMap.put(locala, Integer.valueOf(paramInt));
      }
      for (;;)
      {
        sxZ.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(203763);
        return;
        p.g(locala, "it");
        a(locala, paramInt);
      }
    }
    AppMethodBeat.o(203763);
  }
  
  public static void Fi(int paramInt)
  {
    AppMethodBeat.i(203764);
    a locala = (a)sxZ.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.sxS = ch.aDc();
      AppMethodBeat.o(203764);
      return;
    }
    AppMethodBeat.o(203764);
  }
  
  public static void Fj(int paramInt)
  {
    AppMethodBeat.i(203765);
    a locala = (a)sxZ.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.sxP = ch.aDc();
      AppMethodBeat.o(203765);
      return;
    }
    AppMethodBeat.o(203765);
  }
  
  public static void Fk(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(203767);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      long l1;
      if (sxV > 0L)
      {
        locala.sye = sxV;
        Long localLong = (Long)sxY.get(Integer.valueOf(paramInt));
        if (localLong == null) {
          break label124;
        }
        l1 = localLong.longValue();
        locala.syf = l1;
        sxV = 0L;
        l1 = l2;
        if (locala.syf > 0L) {
          l1 = locala.syf - locala.sye;
        }
        locala.sys = l1;
        if (!sxW) {
          break label129;
        }
      }
      label129:
      for (paramInt = 1;; paramInt = 0)
      {
        locala.syA = paramInt;
        sxW = false;
        AppMethodBeat.o(203767);
        return;
        label124:
        l1 = 0L;
        break;
      }
    }
    AppMethodBeat.o(203767);
  }
  
  public static void Fl(int paramInt)
  {
    AppMethodBeat.i(203768);
    ((Map)sxY).put(Integer.valueOf(paramInt), Long.valueOf(ch.aDc()));
    AppMethodBeat.o(203768);
  }
  
  public static void Fo(int paramInt)
  {
    AppMethodBeat.i(203778);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.syd))
      {
        i = 1;
        if (i == 0) {
          break label125;
        }
      }
      for (;;)
      {
        if (locala == null) {
          break label130;
        }
        locala.syd = true;
        locala.sym = ch.aDc();
        if ((locala.syh > 0L) && (locala.syi == 0L)) {
          locala.syi = locala.sym;
        }
        if ((locala.syj > 0L) && (locala.syk == 0L)) {
          locala.syk = locala.sym;
        }
        locala.syq = 3L;
        a(locala, paramInt);
        AppMethodBeat.o(203778);
        return;
        i = 0;
        break;
        label125:
        locala = null;
      }
    }
    label130:
    AppMethodBeat.o(203778);
  }
  
  public static void Fp(int paramInt)
  {
    AppMethodBeat.i(203779);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.syd))
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
          if (locala.syq != 0L)
          {
            AppMethodBeat.o(203779);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          locala.sym = ch.aDc();
          locala.syy = 3;
          if ((locala.syh > 0L) && (locala.syi == 0L))
          {
            locala.syi = locala.sym;
            locala.syy = 1;
          }
          if ((locala.syj > 0L) && (locala.syk == 0L))
          {
            locala.syk = locala.sym;
            locala.syy = 2;
          }
          locala.syE = 2;
          locala.syq = 2L;
          if (locala.syl > 0L)
          {
            locala.syd = true;
            a(locala, paramInt);
          }
          AppMethodBeat.o(203779);
          return;
        }
      }
    }
    AppMethodBeat.o(203779);
  }
  
  public static void Fq(int paramInt)
  {
    AppMethodBeat.i(203780);
    if (paramInt != -1)
    {
      localObject = (a)sxZ.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        p.g(localObject, "this");
        a((a)localObject, paramInt);
      }
      sxZ.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(203780);
      return;
    }
    Object localObject = ((Map)sxZ).entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getValue(), ((Number)localEntry.getKey()).intValue());
    }
    sxZ.clear();
    localObject = ((Map)sya).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getKey(), ((Number)localEntry.getValue()).intValue());
    }
    sya.clear();
    AppMethodBeat.o(203780);
  }
  
  private static JSONObject a(a parama)
  {
    AppMethodBeat.i(203783);
    if ((parama.syh > 0L) && (parama.syi > 0L) && (parama.syi > parama.syh)) {
      parama.syt = (parama.syi - parama.syh);
    }
    if ((parama.syj > 0L) && (parama.syk > 0L) && (parama.syk > parama.syj)) {
      parama.syv = (parama.syk - parama.syj);
    }
    if ((parama.syi > 0L) && (parama.syj > 0L) && (parama.syj > parama.syi)) {
      parama.syu = (parama.syj - parama.syi);
    }
    parama.syw = (parama.syt + parama.syv + parama.syu);
    long l1;
    long l4;
    label209:
    long l2;
    long l5;
    long l6;
    long l3;
    label253:
    int i;
    if ((parama.syr == 0L) && (parama.sye > 0L))
    {
      l1 = parama.sym - parama.sye;
      parama.syx = l1;
      if (parama.syl >= parama.sym) {
        break label681;
      }
      l4 = parama.sym - parama.syl;
      l2 = parama.syx;
      l5 = 0L;
      l6 = 0L;
      l3 = 0L;
      if (parama.sxT <= 0L) {
        break label707;
      }
      if (parama.sxR <= 0L) {
        break label687;
      }
      l2 = parama.sxT - parama.sxR;
      i = 1;
      l3 = ch.aDc() - parama.sxT;
      l1 = l3;
      if (l3 > 10000L)
      {
        i = 3;
        l1 = 10000L;
      }
      if ((parama.syr != 0L) || (parama.sye <= 0L)) {
        break label693;
      }
      l3 = parama.sxT - parama.sye;
      label312:
      l5 = l2;
      l2 = l3;
      l3 = l6;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enterCost", parama.sys);
      if (parama.sys > 0L)
      {
        l6 = parama.syg - parama.syf;
        label366:
        localJSONObject.put("resumeToLoadingStartCost", l6);
        localJSONObject.put("streamCost", parama.syt);
        localJSONObject.put("spanCgiCost", parama.syu);
        localJSONObject.put("historyCost", parama.syv);
        localJSONObject.put("cgiAllCost", parama.syw);
        localJSONObject.put("loadCost", parama.syx);
        localJSONObject.put("cgiEndToLoadingEndCost", l4);
        localJSONObject.put("startDownloadTimeStamp", parama.sxR);
        localJSONObject.put("videoDecodeStartTimeStamp", parama.sxS);
        localJSONObject.put("firstFrameDrawTimeStamp", parama.sxT);
        localJSONObject.put("downLoadToFirstFrameDrawCost", l5);
        localJSONObject.put("downloadToExitCost", l3);
        localJSONObject.put("totalCost", l2);
        localJSONObject.put("firstFrameStatus", i);
        localJSONObject.put("standingMsAfterFirstFrame", l1);
        localJSONObject.put("exitStatus", parama.syy);
        localJSONObject.put("firstFeedIsPhoto", parama.syz);
        localJSONObject.put("enterWithRedDot", parama.syA);
        if (parama.sys <= 0L) {
          break label792;
        }
      }
      label792:
      for (i = parama.syB;; i = 0)
      {
        localJSONObject.put("enterWithFirstPageData", i);
        localJSONObject.put("cgiBackFeedCount", parama.syD);
        localJSONObject.put("usePreloadCache", parama.syC);
        localJSONObject.put("tabType", parama.dvm);
        localJSONObject.put("api", Build.VERSION.SDK_INT);
        AppMethodBeat.o(203783);
        return localJSONObject;
        l1 = parama.sym - parama.syg;
        break;
        label681:
        l4 = 0L;
        break label209;
        label687:
        l2 = 0L;
        break label253;
        label693:
        l3 = parama.sxT - parama.syg;
        break label312;
        label707:
        if (parama.sxR <= 0L) {
          break label797;
        }
        l2 = ch.aDc();
        l6 = parama.sxR;
        if ((parama.syr == 0L) && (parama.sye > 0L)) {}
        for (l1 = l2 - parama.sye;; l1 = l2 - parama.syg)
        {
          l6 = l2 - l6;
          i = 2;
          l2 = l1;
          l1 = l3;
          l3 = l6;
          break;
        }
        l6 = 0L;
        break label366;
      }
      label797:
      i = 0;
      l1 = l3;
      l3 = l6;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, arn paramarn, long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(203760);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {}
    for (int i = 1; (i == 0) || (paramarn == null); i = 0)
    {
      ae.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + paramInt1 + ", contextObj = " + paramarn);
      AppMethodBeat.o(203760);
      return;
    }
    Object localObject1 = Fe(paramInt1);
    label146:
    if (localObject1 != null)
    {
      if ((!((a)localObject1).Zn) || (((a)localObject1).syd)) {
        break label282;
      }
      i = 1;
      if (i == 0) {
        break label288;
      }
      label116:
      if (localObject1 != null)
      {
        if ((((a)localObject1).syl != 0L) || (((a)localObject1).syq != 2L)) {
          break label294;
        }
        i = 1;
        if (i != 0) {
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label300;
        }
        ak(paramInt1, false);
      }
    }
    for (;;)
    {
      a locala = Fe(paramInt1);
      if (locala == null) {
        break label315;
      }
      locala.Zn = true;
      locala.syr = paramInt2;
      localObject2 = paramarn.sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      locala.sessionId = ((String)localObject1);
      localObject2 = paramarn.rfo;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      locala.syn = ((String)localObject1);
      locala.syo = paramarn.sch;
      locala.syp = paramLong;
      AppMethodBeat.o(203760);
      return;
      label282:
      i = 0;
      break;
      label288:
      localObject1 = null;
      break label116;
      label294:
      i = 0;
      break label146;
      label300:
      ((a)localObject1).syd = true;
      a((a)localObject1, paramInt1);
    }
    label315:
    AppMethodBeat.o(203760);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(203782);
    at localat = new at();
    localat.iu(parama.sessionId);
    localat.iv(parama.syn);
    localat.dM(parama.syo);
    localat.dN(parama.syp);
    localat.dO(parama.sym - parama.syg);
    if (parama.syC == 0)
    {
      l = parama.syg;
      localat.dP(l);
      localObject = a(parama).toString();
      p.g(localObject, "buildExtraInfoJson(data).toString()");
      localat.iw(n.h((String)localObject, ",", ";", false));
      localat.dQ(parama.syq);
      localat.RV();
      localat.dR(parama.syr);
      if (parama.syC != 0) {
        break label241;
      }
    }
    label241:
    for (long l = parama.syl;; l = 0L)
    {
      localat.dS(l);
      if ((localat.RY() >= localat.RT()) && (localat.RS() > 0L) && (parama.syx > 0L)) {
        break label246;
      }
      ae.w("Finder.FinderLoadingTimeReporter", "report20672and20713 error info:" + localat.RD());
      AppMethodBeat.o(203782);
      return;
      l = 0L;
      break;
    }
    label246:
    localat.aLH();
    Object localObject = i.syT;
    i.a((a)localat);
    if (parama.syq == 1L)
    {
      if (parama.syt > 0L)
      {
        g.yxI.n(1458L, 0L, parama.syt);
        g.yxI.n(1458L, 3L, 1L);
      }
      if (parama.syv > 0L)
      {
        g.yxI.n(1458L, 1L, parama.syv);
        g.yxI.n(1458L, 4L, 1L);
      }
      if ((parama.syt > 0L) && (parama.syv > 0L))
      {
        g.yxI.n(1458L, 2L, parama.syw);
        g.yxI.n(1458L, 5L, 1L);
      }
    }
    localObject = new as();
    ((as)localObject).ir(localat.RJ());
    ((as)localObject).is(localat.RP());
    ((as)localObject).dE(localat.RQ());
    ((as)localObject).dF(localat.RR());
    ((as)localObject).dG(localat.RS());
    ((as)localObject).dH(localat.RT());
    ((as)localObject).it(localat.getExtraInfo());
    ((as)localObject).dI(localat.RU());
    ((as)localObject).dJ(localat.RW());
    ((as)localObject).dK(localat.RX());
    ((as)localObject).dL(localat.RY());
    ((as)localObject).aLH();
    ae.i("Finder.FinderLoadingTimeReporter", "report20672and20713 info:" + ((as)localObject).RD());
    if (Ff(paramInt)) {
      syb.add(parama);
    }
    AppMethodBeat.o(203782);
  }
  
  public static void ai(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203771);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.syd))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label86;
        }
        label39:
        if (locala == null) {
          break label114;
        }
        if (!paramBoolean) {
          break label99;
        }
        locala.syh = ch.aDc();
        if (locala.syp != 0L) {
          break label92;
        }
      }
      label86:
      label92:
      for (long l = 1L;; l = 3L)
      {
        locala.syp = l;
        AppMethodBeat.o(203771);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label99:
      locala.syi = ch.aDc();
      AppMethodBeat.o(203771);
      return;
    }
    label114:
    AppMethodBeat.o(203771);
  }
  
  public static void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203772);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.syd))
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
        locala.syj = ch.aDc();
        if (locala.syp != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 2L;; l = 3L)
      {
        locala.syp = l;
        AppMethodBeat.o(203772);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label101:
      locala.syk = ch.aDc();
      AppMethodBeat.o(203772);
      return;
    }
    label116:
    AppMethodBeat.o(203772);
  }
  
  public static void ak(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203773);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.syd))
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
            locala.syl = 0L;
            AppMethodBeat.o(203773);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          locala.syl = ch.aDc();
          if (locala.syq == 2L)
          {
            locala.syd = true;
            a(locala, paramInt);
          }
          AppMethodBeat.o(203773);
          return;
        }
      }
    }
    AppMethodBeat.o(203773);
  }
  
  public static void al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203775);
    a locala = Fe(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.syd))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label69;
        }
        label35:
        if (locala == null) {
          break label79;
        }
        if (locala.syE == 0) {
          if (!paramBoolean) {
            break label74;
          }
        }
      }
      label69:
      label74:
      for (paramInt = 3;; paramInt = 4)
      {
        locala.syE = paramInt;
        AppMethodBeat.o(203775);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label35;
      }
    }
    label79:
    AppMethodBeat.o(203775);
  }
  
  public static List<anj> cFl()
  {
    AppMethodBeat.i(203784);
    Object localObject = new LinkedList();
    Iterator localIterator = ((Iterable)syb).iterator();
    a locala;
    anj localanj;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      localanj = new anj();
      localanj.scene = 2;
      localanj.pullType = ((int)locala.syr);
      localanj.GFp = ((int)locala.sys);
      localanj.GFq = ((int)locala.syw);
      if ((locala.syC != 1) || (locala.syg >= locala.sym) || (locala.syg <= 0L) || (locala.sym <= 0L)) {
        break label544;
      }
    }
    label269:
    label539:
    label544:
    for (long l1 = locala.sym - locala.syg;; l1 = 0L)
    {
      long l2 = l1;
      if (locala.syC == 0)
      {
        l2 = l1;
        if (locala.syl < locala.sym)
        {
          l2 = l1;
          if (locala.syl > 0L)
          {
            l2 = l1;
            if (locala.sym > 0L) {
              l2 = locala.sym - locala.syl;
            }
          }
        }
      }
      localanj.GFr = ((int)l2);
      int i;
      if ((locala.sxS > 0L) && (locala.sxR > 0L) && (locala.sxS > locala.sxR))
      {
        i = (int)(locala.sxS - locala.sxR);
        localanj.GFs = i;
        if (locala.sxS <= 0L) {
          break label493;
        }
        l1 = locala.sxS;
      }
      for (;;)
      {
        label291:
        if ((l1 > 0L) && (locala.sxT > 0L) && (locala.sxT > l1)) {}
        for (i = (int)(locala.sxT - l1);; i = 0)
        {
          localanj.GFt = i;
          localanj.syE = locala.syE;
          ((LinkedList)localObject).add(localanj);
          ae.i("Finder.FinderLoadingTimeReporter", "finderFluencyInfo: scene = " + localanj.scene + ", pullType = " + localanj.pullType + ", globalInitMs = " + localanj.GFp + ',' + " pullCgiMs = " + localanj.GFq + ", showUiMs = " + localanj.GFr + ", downloadToDecodeMs = " + localanj.GFs + ',' + " decodeToFirstFrameMs = " + localanj.GFt + ", finishScene = " + localanj.syE);
          break;
          i = 0;
          break label269;
          label493:
          if (locala.sxP <= 0L) {
            break label539;
          }
          l1 = locala.sxP;
          break label291;
        }
        syb.clear();
        localObject = (List)localObject;
        AppMethodBeat.o(203784);
        return localObject;
        l1 = 0L;
      }
    }
  }
  
  public static void cFm()
  {
    sxW = true;
  }
  
  public static void cFn()
  {
    AppMethodBeat.i(203766);
    sxV = ch.aDc();
    AppMethodBeat.o(203766);
  }
  
  public static void cFo()
  {
    sxV = 0L;
    sxW = false;
  }
  
  public static void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    AppMethodBeat.i(203769);
    a locala1 = Fe(paramInt);
    if (locala1 != null)
    {
      int i;
      if ((locala1.Zn) && (!locala1.syd))
      {
        i = 1;
        if (i == 0) {
          break label71;
        }
      }
      for (;;)
      {
        if (locala1 != null)
        {
          if (paramBoolean1)
          {
            locala1.syg = ch.aDc();
            AppMethodBeat.o(203769);
            return;
            i = 0;
            break;
            label71:
            locala1 = null;
            continue;
          }
          locala1.syd = true;
          locala1.sym = ch.aDc();
          locala1.syq = 1L;
          i = j;
          if (paramBoolean2) {
            i = 1;
          }
          locala1.syz = i;
          if (locala1.syE == 0) {
            locala1.syE = 1;
          }
          if (((paramInt == 4) || (paramInt == 3) || (paramInt == 1)) && (!paramBoolean2))
          {
            a locala2 = (a)sxZ.get(Integer.valueOf(paramInt));
            if (locala2 != null)
            {
              p.g(locala2, "this");
              a(locala2, paramInt);
            }
            ((Map)sxZ).put(Integer.valueOf(paramInt), locala1);
            AppMethodBeat.o(203769);
            return;
          }
          a(locala1, paramInt);
          AppMethodBeat.o(203769);
          return;
        }
      }
    }
    AppMethodBeat.o(203769);
  }
  
  public static void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203777);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(203777);
      return;
    }
    a locala = Fe(paramInt1);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.syd))
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
        locala.syD += paramInt2;
        AppMethodBeat.o(203777);
        return;
        paramInt1 = 0;
        break;
        label72:
        locala = null;
      }
    }
    label77:
    AppMethodBeat.o(203777);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "", "()V", "cgiAllCost", "", "getCgiAllCost", "()J", "setCgiAllCost", "(J)V", "cgiBackFeedCount", "", "getCgiBackFeedCount", "()I", "setCgiBackFeedCount", "(I)V", "cgiEndTimestamp", "getCgiEndTimestamp", "setCgiEndTimestamp", "cgiType", "getCgiType", "setCgiType", "clickEnter", "getClickEnter", "setClickEnter", "clickTabContextID", "", "getClickTabContextID", "()Ljava/lang/String;", "setClickTabContextID", "(Ljava/lang/String;)V", "commentScene", "getCommentScene", "setCommentScene", "enterCost", "getEnterCost", "setEnterCost", "enterWithFirstPageData", "getEnterWithFirstPageData", "setEnterWithFirstPageData", "enterWithRedDot", "getEnterWithRedDot", "setEnterWithRedDot", "exitStatus", "getExitStatus", "setExitStatus", "finishScene", "getFinishScene", "setFinishScene", "finishStatus", "getFinishStatus", "setFinishStatus", "firstFeedIsPhoto", "getFirstFeedIsPhoto", "setFirstFeedIsPhoto", "historyCgiBegin", "getHistoryCgiBegin", "setHistoryCgiBegin", "historyCgiEnd", "getHistoryCgiEnd", "setHistoryCgiEnd", "historyCost", "getHistoryCost", "setHistoryCost", "isFinishLoad", "", "()Z", "setFinishLoad", "(Z)V", "isPrepared", "setPrepared", "loadCost", "getLoadCost", "setLoadCost", "loadingBegin", "getLoadingBegin", "setLoadingBegin", "loadingEnd", "getLoadingEnd", "setLoadingEnd", "pullType", "getPullType", "setPullType", "sessionId", "getSessionId", "setSessionId", "spanCgiCost", "getSpanCgiCost", "setSpanCgiCost", "streamCgiBegin", "getStreamCgiBegin", "setStreamCgiBegin", "streamCgiEnd", "getStreamCgiEnd", "setStreamCgiEnd", "streamCost", "getStreamCost", "setStreamCost", "tabResume", "getTabResume", "setTabResume", "tabType", "getTabType", "setTabType", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public boolean Zn;
    int dvm;
    String sessionId = "";
    long sxP;
    long sxR;
    long sxS;
    long sxT;
    int syA;
    public int syB;
    public int syC;
    int syD;
    int syE;
    public boolean syd;
    long sye;
    long syf;
    long syg;
    long syh;
    long syi;
    long syj;
    long syk;
    long syl;
    long sym;
    String syn = "";
    long syo;
    long syp;
    long syq;
    long syr;
    long sys;
    long syt;
    long syu;
    long syv;
    long syw;
    long syx;
    int syy;
    int syz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */
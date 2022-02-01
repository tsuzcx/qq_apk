package com.tencent.mm.plugin.finder.report;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter;", "", "()V", "CGI_TYPE_HISTORY", "", "CGI_TYPE_OTHER", "CGI_TYPE_STREAM", "CGI_TYPE_STREAM_AND_HISTORY", "INNER_VERSION_20672", "LOADING_STATUS_FAIL", "LOADING_STATUS_FINISH_BY_USER", "LOADING_STATUS_SUCCESS", "TAG", "", "clickEnterTime", "enterFinderWithRedDot", "", "laterReportCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "loadingTimeConsumeDataMap", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabResumeTimeMap", "addCgiBackFeedCount", "", "tabType", "count", "applyClickEnterTime", "buildExtraInfoJson", "Lorg/json/JSONObject;", "data", "cacheLateReportData", "clearClickEnterTime", "genClickEnterTime", "getData", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isSupportCgiReportTabType", "isSupportReportPullType", "pullType", "isSupportTabTabType", "notifyCgiEnd", "clear", "notifyDecodeStart", "notifyFinishScene", "isChangeTab", "notifyFirstPageData", "hasData", "notifyHistoryCgi", "isBegin", "notifyLoadingStatus", "firstFeedIsPhoto", "notifyStreamCgi", "notifyUsePreloadCache", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPlay", "onTabResume", "prepare", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "cgiType", "report20672and20713", "reportCacheData", "reportFailed", "reportFinishByUser", "TimeConsumeData", "plugin-finder_release"})
public final class e
{
  private static final HashSet<a> LjT;
  private static boolean Lka;
  private static long snU;
  private static final ConcurrentHashMap<Integer, a> snV;
  private static final ConcurrentHashMap<Integer, Long> snW;
  private static final ConcurrentHashMap<Integer, a> snX;
  public static final e snY;
  
  static
  {
    AppMethodBeat.i(203233);
    snY = new e();
    snV = new ConcurrentHashMap();
    snW = new ConcurrentHashMap();
    snX = new ConcurrentHashMap();
    LjT = new HashSet();
    AppMethodBeat.o(203233);
  }
  
  public static a EL(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(203215);
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
      AppMethodBeat.o(203215);
      return null;
    }
    a locala2 = (a)snV.get(Integer.valueOf(paramInt));
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (!locala2.snZ) {}
    }
    else
    {
      locala1 = new a();
      locala1.duh = paramInt;
      ((Map)snV).put(Integer.valueOf(paramInt), locala1);
    }
    AppMethodBeat.o(203215);
    return locala1;
  }
  
  public static void EM(int paramInt)
  {
    AppMethodBeat.i(203216);
    a locala = (a)snX.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.soj = cf.aCM();
      AppMethodBeat.o(203216);
      return;
    }
    AppMethodBeat.o(203216);
  }
  
  public static void EN(int paramInt)
  {
    AppMethodBeat.i(203217);
    a locala = (a)snX.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.sok = cf.aCM();
      p.g(locala, "it");
      a(locala, paramInt);
      snX.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(203217);
      return;
    }
    AppMethodBeat.o(203217);
  }
  
  public static void EO(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(203219);
    a locala = EL(paramInt);
    if (locala != null)
    {
      long l1;
      if (snU > 0L)
      {
        locala.soa = snU;
        Long localLong = (Long)snW.get(Integer.valueOf(paramInt));
        if (localLong == null) {
          break label124;
        }
        l1 = localLong.longValue();
        locala.sob = l1;
        snU = 0L;
        l1 = l2;
        if (locala.sob > 0L) {
          l1 = locala.sob - locala.soa;
        }
        locala.soq = l1;
        if (!Lka) {
          break label129;
        }
      }
      label129:
      for (paramInt = 1;; paramInt = 0)
      {
        locala.Lkb = paramInt;
        Lka = false;
        AppMethodBeat.o(203219);
        return;
        label124:
        l1 = 0L;
        break;
      }
    }
    AppMethodBeat.o(203219);
  }
  
  public static void EP(int paramInt)
  {
    AppMethodBeat.i(203220);
    ((Map)snW).put(Integer.valueOf(paramInt), Long.valueOf(cf.aCM()));
    AppMethodBeat.o(203220);
  }
  
  public static void ES(int paramInt)
  {
    AppMethodBeat.i(203227);
    a locala = EL(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.snZ))
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
        locala.snZ = true;
        locala.soi = cf.aCM();
        if ((locala.sod > 0L) && (locala.soe == 0L)) {
          locala.soe = locala.soi;
        }
        if ((locala.sof > 0L) && (locala.sog == 0L)) {
          locala.sog = locala.soi;
        }
        locala.soo = 3L;
        a(locala, paramInt);
        AppMethodBeat.o(203227);
        return;
        i = 0;
        break;
        label125:
        locala = null;
      }
    }
    label130:
    AppMethodBeat.o(203227);
  }
  
  public static void ET(int paramInt)
  {
    AppMethodBeat.i(203228);
    a locala = EL(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.snZ))
      {
        i = 1;
        if (i == 0) {
          break label58;
        }
      }
      for (;;)
      {
        if (locala != null)
        {
          if (locala.soo != 0L)
          {
            AppMethodBeat.o(203228);
            return;
            i = 0;
            break;
            label58:
            locala = null;
            continue;
          }
          locala.soi = cf.aCM();
          locala.sow = 3;
          if ((locala.sod > 0L) && (locala.soe == 0L))
          {
            locala.soe = locala.soi;
            locala.sow = 1;
          }
          if ((locala.sof > 0L) && (locala.sog == 0L))
          {
            locala.sog = locala.soi;
            locala.sow = 2;
          }
          locala.OcH = 2;
          locala.soo = 2L;
          if (locala.soh > 0L)
          {
            locala.snZ = true;
            a(locala, paramInt);
          }
          AppMethodBeat.o(203228);
          return;
        }
      }
    }
    AppMethodBeat.o(203228);
  }
  
  public static void EU(int paramInt)
  {
    AppMethodBeat.i(203229);
    if (paramInt != -1)
    {
      localObject = (a)snX.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        p.g(localObject, "this");
        a((a)localObject, paramInt);
      }
      snX.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(203229);
      return;
    }
    Object localObject = ((Map)snX).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      a((a)localEntry.getValue(), ((Number)localEntry.getKey()).intValue());
    }
    snX.clear();
    AppMethodBeat.o(203229);
  }
  
  public static void a(int paramInt1, int paramInt2, aqy paramaqy, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(221527);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {}
    for (int i = 1; (i == 0) || (paramaqy == null); i = 0)
    {
      ad.i("Finder.FinderLoadingTimeReporter", "prepare: not support to report tabType = " + paramInt1 + ", contextObj = " + paramaqy);
      AppMethodBeat.o(221527);
      return;
    }
    a locala = EL(paramInt1);
    label146:
    if (locala != null)
    {
      if ((!locala.Zn) || (locala.snZ)) {
        break label270;
      }
      i = 1;
      if (i == 0) {
        break label276;
      }
      label116:
      if (locala != null)
      {
        if ((locala.soh != 0L) || (locala.soo != 2L)) {
          break label282;
        }
        i = 1;
        if (i != 0) {
          localObject = locala;
        }
        if (localObject == null) {
          break label288;
        }
        ah(paramInt1, false);
      }
    }
    for (;;)
    {
      locala = EL(paramInt1);
      if (locala == null) {
        break label303;
      }
      locala.Zn = true;
      locala.sop = paramInt2;
      localObject = paramaqy.sessionId;
      p.g(localObject, "contextObj.sessionId");
      p.h(localObject, "<set-?>");
      locala.sessionId = ((String)localObject);
      localObject = paramaqy.qXj;
      p.g(localObject, "contextObj.clickTabContextId");
      p.h(localObject, "<set-?>");
      locala.sol = ((String)localObject);
      locala.som = paramaqy.rTD;
      locala.son = paramLong;
      AppMethodBeat.o(221527);
      return;
      label270:
      i = 0;
      break;
      label276:
      locala = null;
      break label116;
      label282:
      i = 0;
      break label146;
      label288:
      locala.snZ = true;
      a(locala, paramInt1);
    }
    label303:
    AppMethodBeat.o(221527);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(221534);
    at localat = new at();
    localat.ik(parama.sessionId);
    localat.il(parama.sol);
    localat.dL(parama.som);
    localat.dM(parama.son);
    localat.dN(parama.soi - parama.soc);
    if (parama.Lkd == 0)
    {
      l = parama.soc;
      localat.dO(l);
      localObject = b(parama).toString();
      p.g(localObject, "buildExtraInfoJson(data).toString()");
      localat.im(n.h((String)localObject, ",", ";", false));
      localat.dP(parama.soo);
      localat.RX();
      localat.dQ(parama.sop);
      if (parama.Lkd != 0) {
        break label241;
      }
    }
    label241:
    for (long l = parama.soh;; l = 0L)
    {
      localat.dR(l);
      if ((localat.Sa() >= localat.RV()) && (localat.RU() > 0L) && (parama.sov > 0L)) {
        break label246;
      }
      ad.w("Finder.FinderLoadingTimeReporter", "report20672and20713 error info:" + localat.RE());
      AppMethodBeat.o(221534);
      return;
      l = 0L;
      break;
    }
    label246:
    localat.aLk();
    Object localObject = h.soM;
    h.a((a)localat);
    if (parama.soo == 1L)
    {
      if (parama.sor > 0L)
      {
        g.yhR.n(1458L, 0L, parama.sor);
        g.yhR.n(1458L, 3L, 1L);
      }
      if (parama.sot > 0L)
      {
        g.yhR.n(1458L, 1L, parama.sot);
        g.yhR.n(1458L, 4L, 1L);
      }
      if ((parama.sor > 0L) && (parama.sot > 0L))
      {
        g.yhR.n(1458L, 2L, parama.sou);
        g.yhR.n(1458L, 5L, 1L);
      }
    }
    localObject = new as();
    ((as)localObject).ih(localat.RK());
    ((as)localObject).ii(localat.RR());
    ((as)localObject).dD(localat.RS());
    ((as)localObject).dE(localat.RT());
    ((as)localObject).dF(localat.RU());
    ((as)localObject).dG(localat.RV());
    ((as)localObject).ij(localat.getExtraInfo());
    ((as)localObject).dH(localat.RW());
    ((as)localObject).dI(localat.RY());
    ((as)localObject).dJ(localat.RZ());
    ((as)localObject).dK(localat.Sa());
    ((as)localObject).aLk();
    ad.i("Finder.FinderLoadingTimeReporter", "report20672and20713 info:" + ((as)localObject).RE());
    if (aba(paramInt)) {
      LjT.add(parama);
    }
    AppMethodBeat.o(221534);
  }
  
  public static void abY(int paramInt)
  {
    AppMethodBeat.i(221529);
    a locala = (a)snX.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.LjY = cf.aCM();
      AppMethodBeat.o(221529);
      return;
    }
    AppMethodBeat.o(221529);
  }
  
  private static boolean aba(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 3) || (paramInt == 1);
  }
  
  public static void af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203223);
    a locala = EL(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.snZ))
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
        locala.sod = cf.aCM();
        if (locala.son != 0L) {
          break label92;
        }
      }
      label86:
      label92:
      for (long l = 1L;; l = 3L)
      {
        locala.son = l;
        AppMethodBeat.o(203223);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label99:
      locala.soe = cf.aCM();
      AppMethodBeat.o(203223);
      return;
    }
    label114:
    AppMethodBeat.o(203223);
  }
  
  public static void ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203224);
    a locala = EL(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.snZ))
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
        locala.sof = cf.aCM();
        if (locala.son != 0L) {
          break label94;
        }
      }
      label88:
      label94:
      for (long l = 2L;; l = 3L)
      {
        locala.son = l;
        AppMethodBeat.o(203224);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label39;
      }
      label101:
      locala.sog = cf.aCM();
      AppMethodBeat.o(203224);
      return;
    }
    label116:
    AppMethodBeat.o(203224);
  }
  
  public static void ah(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203225);
    a locala = EL(paramInt);
    if (locala != null)
    {
      int i;
      if ((locala.Zn) && (!locala.snZ))
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
            locala.soh = 0L;
            AppMethodBeat.o(203225);
            return;
            i = 0;
            break;
            label60:
            locala = null;
            continue;
          }
          locala.soh = cf.aCM();
          if (locala.soo == 2L)
          {
            locala.snZ = true;
            a(locala, paramInt);
          }
          AppMethodBeat.o(203225);
          return;
        }
      }
    }
    AppMethodBeat.o(203225);
  }
  
  public static void amd(int paramInt)
  {
    AppMethodBeat.i(221530);
    a locala = (a)snX.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      locala.LjW = cf.aCM();
      AppMethodBeat.o(221530);
      return;
    }
    AppMethodBeat.o(221530);
  }
  
  private static JSONObject b(a parama)
  {
    AppMethodBeat.i(203232);
    if ((parama.sod > 0L) && (parama.soe > 0L) && (parama.soe > parama.sod)) {
      parama.sor = (parama.soe - parama.sod);
    }
    if ((parama.sof > 0L) && (parama.sog > 0L) && (parama.sog > parama.sof)) {
      parama.sot = (parama.sog - parama.sof);
    }
    if ((parama.soe > 0L) && (parama.sof > 0L) && (parama.sof > parama.soe)) {
      parama.sos = (parama.sof - parama.soe);
    }
    parama.sou = (parama.sor + parama.sot + parama.sos);
    long l1;
    long l3;
    label209:
    long l4;
    long l5;
    label248:
    int i;
    long l2;
    if ((parama.sop == 0L) && (parama.soa > 0L))
    {
      l1 = parama.soi - parama.soa;
      parama.sov = l1;
      if (parama.soh >= parama.soi) {
        break label635;
      }
      l3 = parama.soi - parama.soh;
      l1 = parama.sov;
      l4 = 0L;
      l5 = 0L;
      if (parama.sok <= 0L) {
        break label660;
      }
      if (parama.soj <= 0L) {
        break label641;
      }
      l1 = parama.sok - parama.soj;
      i = 1;
      if ((parama.sop != 0L) || (parama.soa <= 0L)) {
        break label646;
      }
      l2 = parama.sok - parama.soa;
      label279:
      l4 = l1;
      l1 = l2;
      l2 = l5;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enterCost", parama.soq);
      if (parama.soq > 0L)
      {
        l5 = parama.soc - parama.sob;
        label331:
        localJSONObject.put("resumeToLoadingStartCost", l5);
        localJSONObject.put("streamCost", parama.sor);
        localJSONObject.put("spanCgiCost", parama.sos);
        localJSONObject.put("historyCost", parama.sot);
        localJSONObject.put("cgiAllCost", parama.sou);
        localJSONObject.put("loadCost", parama.sov);
        localJSONObject.put("cgiEndToLoadingEndCost", l3);
        localJSONObject.put("startDownloadTimeStamp", parama.soj);
        localJSONObject.put("videoDecodeStartTimeStamp", parama.LjY);
        localJSONObject.put("firstFrameDrawTimeStamp", parama.sok);
        localJSONObject.put("downLoadToFirstFrameDrawCost", l4);
        localJSONObject.put("downloadToExitCost", l2);
        localJSONObject.put("totalCost", l1);
        localJSONObject.put("firstFrameStatus", i);
        localJSONObject.put("exitStatus", parama.sow);
        localJSONObject.put("firstFeedIsPhoto", parama.sox);
        localJSONObject.put("enterWithRedDot", parama.Lkb);
        if (parama.soq <= 0L) {
          break label735;
        }
      }
      label641:
      label646:
      label660:
      label735:
      for (i = parama.Lkc;; i = 0)
      {
        localJSONObject.put("enterWithFirstPageData", i);
        localJSONObject.put("cgiBackFeedCount", parama.OcG);
        localJSONObject.put("usePreloadCache", parama.Lkd);
        localJSONObject.put("tabType", parama.duh);
        localJSONObject.put("api", Build.VERSION.SDK_INT);
        AppMethodBeat.o(203232);
        return localJSONObject;
        l1 = parama.soi - parama.soc;
        break;
        label635:
        l3 = 0L;
        break label209;
        l1 = 0L;
        break label248;
        l2 = parama.sok - parama.soc;
        break label279;
        if (parama.soj <= 0L) {
          break label740;
        }
        l2 = cf.aCM();
        l5 = parama.soj;
        i = 2;
        if ((parama.sop == 0L) && (parama.soa > 0L)) {}
        for (l1 = l2 - parama.soa;; l1 = l2 - parama.soc)
        {
          l2 -= l5;
          break;
        }
        l5 = 0L;
        break label331;
      }
      label740:
      i = 0;
      l2 = l5;
    }
  }
  
  public static List<ejc> bMX()
  {
    AppMethodBeat.i(221535);
    Object localObject = new LinkedList();
    Iterator localIterator = ((Iterable)LjT).iterator();
    a locala;
    ejc localejc;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      localejc = new ejc();
      localejc.scene = 2;
      localejc.pullType = ((int)locala.sop);
      localejc.Oeu = ((int)locala.soq);
      localejc.Oev = ((int)locala.sou);
      if ((locala.Lkd != 1) || (locala.soc >= locala.soi) || (locala.soc <= 0L) || (locala.soi <= 0L)) {
        break label544;
      }
    }
    label269:
    label539:
    label544:
    for (long l1 = locala.soi - locala.soc;; l1 = 0L)
    {
      long l2 = l1;
      if (locala.Lkd == 0)
      {
        l2 = l1;
        if (locala.soh < locala.soi)
        {
          l2 = l1;
          if (locala.soh > 0L)
          {
            l2 = l1;
            if (locala.soi > 0L) {
              l2 = locala.soi - locala.soh;
            }
          }
        }
      }
      localejc.Oew = ((int)l2);
      int i;
      if ((locala.LjY > 0L) && (locala.soj > 0L) && (locala.LjY > locala.soj))
      {
        i = (int)(locala.LjY - locala.soj);
        localejc.Oex = i;
        if (locala.LjY <= 0L) {
          break label493;
        }
        l1 = locala.LjY;
      }
      for (;;)
      {
        label291:
        if ((l1 > 0L) && (locala.sok > 0L) && (locala.sok > l1)) {}
        for (i = (int)(locala.sok - l1);; i = 0)
        {
          localejc.Oey = i;
          localejc.OcH = locala.OcH;
          ((LinkedList)localObject).add(localejc);
          ad.i("Finder.FinderLoadingTimeReporter", "finderFluencyInfo: scene = " + localejc.scene + ", pullType = " + localejc.pullType + ", globalInitMs = " + localejc.Oeu + ',' + " pullCgiMs = " + localejc.Oev + ", showUiMs = " + localejc.Oew + ", downloadToDecodeMs = " + localejc.Oex + ',' + " decodeToFirstFrameMs = " + localejc.Oey + ", finishScene = " + localejc.OcH);
          break;
          i = 0;
          break label269;
          label493:
          if (locala.LjW <= 0L) {
            break label539;
          }
          l1 = locala.LjW;
          break label291;
        }
        LjT.clear();
        localObject = (List)localObject;
        AppMethodBeat.o(221535);
        return localObject;
        l1 = 0L;
      }
    }
  }
  
  public static void bSQ()
  {
    Lka = true;
  }
  
  public static void bv(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221531);
    a locala = EL(paramInt);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.snZ))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label69;
        }
        label35:
        if (locala == null) {
          break label79;
        }
        if (locala.OcH == 0) {
          if (!paramBoolean) {
            break label74;
          }
        }
      }
      label69:
      label74:
      for (paramInt = 3;; paramInt = 4)
      {
        locala.OcH = paramInt;
        AppMethodBeat.o(221531);
        return;
        paramInt = 0;
        break;
        locala = null;
        break label35;
      }
    }
    label79:
    AppMethodBeat.o(221531);
  }
  
  public static void cDs()
  {
    AppMethodBeat.i(203218);
    snU = cf.aCM();
    AppMethodBeat.o(203218);
  }
  
  public static void cDt()
  {
    snU = 0L;
    Lka = false;
  }
  
  public static void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    AppMethodBeat.i(203221);
    a locala1 = EL(paramInt);
    if (locala1 != null)
    {
      int i;
      if ((locala1.Zn) && (!locala1.snZ))
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
            locala1.soc = cf.aCM();
            AppMethodBeat.o(203221);
            return;
            i = 0;
            break;
            label71:
            locala1 = null;
            continue;
          }
          locala1.snZ = true;
          locala1.soi = cf.aCM();
          locala1.soo = 1L;
          i = j;
          if (paramBoolean2) {
            i = 1;
          }
          locala1.sox = i;
          if (locala1.OcH == 0) {
            locala1.OcH = 1;
          }
          if (((paramInt == 4) || (paramInt == 3) || (paramInt == 1)) && (!paramBoolean2))
          {
            a locala2 = (a)snX.get(Integer.valueOf(paramInt));
            if (locala2 != null)
            {
              p.g(locala2, "this");
              a(locala2, paramInt);
            }
            ((Map)snX).put(Integer.valueOf(paramInt), locala1);
            AppMethodBeat.o(203221);
            return;
          }
          a(locala1, paramInt);
          AppMethodBeat.o(203221);
          return;
        }
      }
    }
    AppMethodBeat.o(203221);
  }
  
  public static void jz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221533);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(221533);
      return;
    }
    a locala = EL(paramInt1);
    if (locala != null)
    {
      if ((locala.Zn) && (!locala.snZ))
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
        locala.OcG += paramInt2;
        AppMethodBeat.o(221533);
        return;
        paramInt1 = 0;
        break;
        label72:
        locala = null;
      }
    }
    label77:
    AppMethodBeat.o(221533);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderLoadingTimeReporter$TimeConsumeData;", "", "()V", "cgiAllCost", "", "getCgiAllCost", "()J", "setCgiAllCost", "(J)V", "cgiBackFeedCount", "", "getCgiBackFeedCount", "()I", "setCgiBackFeedCount", "(I)V", "cgiEndTimestamp", "getCgiEndTimestamp", "setCgiEndTimestamp", "cgiType", "getCgiType", "setCgiType", "clickEnter", "getClickEnter", "setClickEnter", "clickTabContextID", "", "getClickTabContextID", "()Ljava/lang/String;", "setClickTabContextID", "(Ljava/lang/String;)V", "commentScene", "getCommentScene", "setCommentScene", "enterCost", "getEnterCost", "setEnterCost", "enterWithFirstPageData", "getEnterWithFirstPageData", "setEnterWithFirstPageData", "enterWithRedDot", "getEnterWithRedDot", "setEnterWithRedDot", "exitStatus", "getExitStatus", "setExitStatus", "finishScene", "getFinishScene", "setFinishScene", "finishStatus", "getFinishStatus", "setFinishStatus", "firstFeedIsPhoto", "getFirstFeedIsPhoto", "setFirstFeedIsPhoto", "historyCgiBegin", "getHistoryCgiBegin", "setHistoryCgiBegin", "historyCgiEnd", "getHistoryCgiEnd", "setHistoryCgiEnd", "historyCost", "getHistoryCost", "setHistoryCost", "isFinishLoad", "", "()Z", "setFinishLoad", "(Z)V", "isPrepared", "setPrepared", "loadCost", "getLoadCost", "setLoadCost", "loadingBegin", "getLoadingBegin", "setLoadingBegin", "loadingEnd", "getLoadingEnd", "setLoadingEnd", "pullType", "getPullType", "setPullType", "sessionId", "getSessionId", "setSessionId", "spanCgiCost", "getSpanCgiCost", "setSpanCgiCost", "streamCgiBegin", "getStreamCgiBegin", "setStreamCgiBegin", "streamCgiEnd", "getStreamCgiEnd", "setStreamCgiEnd", "streamCost", "getStreamCost", "setStreamCost", "tabResume", "getTabResume", "setTabResume", "tabType", "getTabType", "setTabType", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    long LjW;
    long LjY;
    int Lkb;
    public int Lkc;
    public int Lkd;
    int OcG;
    int OcH;
    public boolean Zn;
    int duh;
    String sessionId = "";
    public boolean snZ;
    long soa;
    long sob;
    long soc;
    long sod;
    long soe;
    long sof;
    long sog;
    long soh;
    long soi;
    long soj;
    long sok;
    String sol = "";
    long som;
    long son;
    long soo;
    long sop;
    long soq;
    long sor;
    long sos;
    long sot;
    long sou;
    long sov;
    int sow;
    int sox;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e
 * JD-Core Version:    0.7.0.1
 */
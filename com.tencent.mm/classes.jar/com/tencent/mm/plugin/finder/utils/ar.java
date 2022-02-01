package com.tencent.mm.plugin.finder.utils;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.protocal.protobuf.emk;>;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats;", "", "()V", "INNER_VERSION", "", "getINNER_VERSION", "()I", "KEY_ID", "", "RV_VISITOR", "", "getRV_VISITOR", "()Ljava/lang/String;", "TAG", "containBeingPlay", "", "getContainBeingPlay", "()Z", "setContainBeingPlay", "(Z)V", "flows", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getFlows", "()Ljava/util/HashMap;", "historyLog", "getHistoryLog", "playPath", "getPlayPath", "setPlayPath", "(I)V", "preloadMap", "getPreloadMap", "timeRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/utils/PlayTimeCostRecord;", "getTimeRecord", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkEndState", "id", "stage", "isEnd", "stateList", "checkStage", "checkStartState", "isStart", "clear", "", "clearAll", "end", "delay", "getData", "maxIndex", "dataList", "logStage", "config", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "reportLinkAppluSuc", "reportLinkApplyFail", "reportLinkHangupFail", "reportLinkHangupSuc", "reportRewardConsumeFail", "reportRewardFail", "reportRewardLevel", "wecoin", "reportRewardSuc", "saveTime", "beginPlayTime", "selectToPlayTimeCost", "setPreloadLiveState", "preloadLive", "tag", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "tagEnterLive", "userClickPlay", "StageLogConfig", "TimeCost", "plugin-finder_release"})
public final class ar
{
  private static final long AGW = 1552L;
  private static final int AIK = 1;
  private static final String AIL = "RV_VISITOR_";
  private static final HashMap<String, ArrayList<emk>> AIM;
  private static final HashMap<String, String> AIN;
  private static final HashMap<String, Boolean> AIO;
  public static final ConcurrentHashMap<String, aw> AIP;
  private static int AIQ = 0;
  private static boolean AIR = false;
  public static final ar AIS;
  private static final String TAG = "Finder.LiveFlowStats";
  
  static
  {
    AppMethodBeat.i(287089);
    AIS = new ar();
    TAG = "Finder.LiveFlowStats";
    AIK = 1;
    AIL = "RV_VISITOR_";
    AIM = new HashMap();
    AIN = new HashMap();
    AIO = new HashMap();
    AIP = new ConcurrentHashMap();
    AGW = 1552L;
    AppMethodBeat.o(287089);
  }
  
  public static void Rp(int paramInt)
  {
    AIQ = paramInt;
  }
  
  public static void Rq(int paramInt)
  {
    AppMethodBeat.i(287088);
    if (paramInt < 10)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 82L);
      AppMethodBeat.o(287088);
      return;
    }
    if (paramInt < 50)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 83L);
      AppMethodBeat.o(287088);
      return;
    }
    if (paramInt < 200)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 84L);
      AppMethodBeat.o(287088);
      return;
    }
    if (paramInt < 500)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 85L);
      AppMethodBeat.o(287088);
      return;
    }
    if (paramInt < 1000)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 86L);
      AppMethodBeat.o(287088);
      return;
    }
    if (paramInt < 5000)
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 87L);
      AppMethodBeat.o(287088);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 88L);
    AppMethodBeat.o(287088);
  }
  
  private final String a(String paramString, a parama)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      try
      {
        AppMethodBeat.i(287078);
        ArrayList localArrayList = (ArrayList)AIM.get(paramString);
        if (localArrayList != null)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          p.j(localArrayList, "dataList");
          localObject1 = (emk)j.lp((List)localArrayList);
          if (localObject1 != null)
          {
            l2 = ((emk)localObject1).GhA;
            localObject1 = (emk)j.lr((List)localArrayList);
            if (localObject1 == null) {
              break label559;
            }
            l1 = ((emk)localObject1).GhA;
            l2 = l1 - l2;
            Iterator localIterator = ((Iterable)localArrayList).iterator();
            i = 0;
            if (localIterator.hasNext())
            {
              localObject1 = localIterator.next();
              j = i + 1;
              if (i < 0) {
                j.iBO();
              }
              emk localemk = (emk)localObject1;
              if (i == 0)
              {
                p.j(localStringBuilder1.append("start at " + localemk.GhA + "\n " + localemk.BHO + " \n "), "flowStr.append(\"start at…\\n ${curData.stage} \\n \")");
                i = j;
                continue;
              }
              localObject2 = (emk)localArrayList.get(i - 1);
              localObject1 = (String)parama.AIT.get(localemk.BHO);
              if (localObject1 == null) {
                break label584;
              }
              localObject2 = b((String)localObject1, i, localArrayList);
              break label565;
              label260:
              if ((l2 <= 0L) || (localObject2 == null)) {
                break label587;
              }
              StringBuilder localStringBuilder2 = new StringBuilder();
              af localaf = af.aaBG;
              long l3 = localemk.GhA;
              if (localObject2 == null) {
                p.iCn();
              }
              localObject2 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf((float)(l3 - ((emk)localObject2).GhA) * 100.0F / (float)l2) }, 1));
              p.j(localObject2, "java.lang.String.format(format, *args)");
              localObject2 = (String)localObject2 + "%";
              localStringBuilder1.append(localemk.BHO + '[' + (String)localObject1 + "ms " + (String)localObject2 + "] \n ");
              if (i != localArrayList.size() - 1) {
                break label578;
              }
              localStringBuilder1.append("end at ".concat(String.valueOf(l1)));
              break label578;
              l3 = localemk.GhA;
              if (localObject2 == null) {
                p.iCn();
              }
              localObject1 = String.valueOf(l3 - ((emk)localObject2).GhA);
              continue;
            }
            parama = "Total Cost:" + l2 + "ms... " + localStringBuilder1;
            AIN.put(paramString, parama);
            Log.i(TAG, parama);
            AppMethodBeat.o(287078);
            paramString = parama;
            return paramString;
          }
        }
        else
        {
          paramString = "";
          AppMethodBeat.o(287078);
          continue;
        }
        long l2 = 0L;
      }
      finally {}
      continue;
      label559:
      long l1 = 0L;
      continue;
      label565:
      label578:
      label584:
      for (;;)
      {
        if (localObject2 != null) {
          break label585;
        }
        localObject1 = "null ";
        break label260;
        i = j;
        break;
      }
      label585:
      continue;
      label587:
      Object localObject2 = "";
    }
  }
  
  private void a(String paramString1, String paramString2, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    label438:
    label447:
    label471:
    for (;;)
    {
      ap.a locala;
      int i;
      try
      {
        AppMethodBeat.i(287074);
        p.k(paramString1, "id");
        p.k(paramString2, "stage");
        ArrayList localArrayList = (ArrayList)AIM.get(paramString1);
        if (localArrayList != null) {
          break label471;
        }
        localArrayList = new ArrayList();
        p.j(localArrayList, "flows.get(id) ?: ArrayList()");
        Object localObject = ap.AIh;
        if (p.h(paramString2, ap.efi().name)) {
          ((Map)AIO).put(paramString1, Boolean.valueOf(paramBoolean3));
        }
        paramBoolean3 = paramBoolean1;
        if (aGb(paramString1))
        {
          localObject = ap.AIh;
          paramBoolean3 = paramBoolean1;
          if ((p.h(paramString2, ap.efr().name) ^ true)) {
            paramBoolean3 = false;
          }
        }
        paramString2 = j(paramString2, localArrayList);
        paramBoolean1 = a(paramString1, paramString2, paramBoolean2, localArrayList);
        if (paramBoolean3)
        {
          localArrayList.clear();
          localObject = new emk();
          ((emk)localObject).id = paramString1;
          ((emk)localObject).BHO = paramString2;
          ((emk)localObject).GhA = cm.bfC();
          if (!paramBoolean3) {
            break label447;
          }
          locala = ap.AIh;
          i = ap.efd();
          ((emk)localObject).type = i;
          ((emk)localObject).UoX = paramb;
          paramb = b.AJc;
          b.a((emk)localObject, localArrayList, paramBoolean1);
          localArrayList.add(localObject);
          ((Map)AIM).put(paramString1, localArrayList);
          Log.i(TAG, "tag, stage:" + paramString2 + ", isStart:" + paramBoolean3 + ", isEnd:" + paramBoolean1);
          if (paramBoolean1) {
            com.tencent.e.h.ZvG.o((Runnable)new c(paramString1), 0L);
          }
          AppMethodBeat.o(287074);
          return;
        }
        if (localArrayList.isEmpty()) {
          break label438;
        }
        localObject = (emk)j.lp((List)localArrayList);
        if (localObject != null)
        {
          i = ((emk)localObject).type;
          localObject = ap.AIh;
          if (i != ap.efd()) {
            break label438;
          }
          localObject = (emk)j.lr((List)localArrayList);
          if (localObject == null) {
            continue;
          }
          i = ((emk)localObject).type;
          localObject = ap.AIh;
          if (i != ap.efe()) {
            continue;
          }
          AppMethodBeat.o(287074);
          continue;
        }
        AppMethodBeat.o(287074);
      }
      finally {}
      continue;
      AppMethodBeat.o(287074);
      continue;
      if (paramBoolean1)
      {
        locala = ap.AIh;
        i = ap.efe();
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2, boolean paramBoolean, ArrayList<emk> paramArrayList)
  {
    AppMethodBeat.i(287077);
    if ((p.h((Boolean)AIO.get(paramString1), Boolean.TRUE) ^ true))
    {
      AppMethodBeat.o(287077);
      return paramBoolean;
    }
    paramString1 = ap.AIh;
    if (p.h(paramString2, ap.efo().name))
    {
      paramString1 = ((Iterable)paramArrayList).iterator();
      while (paramString1.hasNext())
      {
        Object localObject1 = (emk)paramString1.next();
        Object localObject2 = ((emk)localObject1).BHO;
        ap.a locala = ap.AIh;
        if (!p.h(localObject2, ap.efl().name))
        {
          localObject1 = ((emk)localObject1).BHO;
          localObject2 = ap.AIh;
          if (!p.h(localObject1, ap.efn().name)) {
            break;
          }
        }
        else
        {
          AppMethodBeat.o(287077);
          return true;
        }
      }
    }
    paramString1 = ap.AIh;
    if (!p.h(paramString2, ap.efl().name))
    {
      paramString1 = ap.AIh;
      if (!p.h(paramString2, ap.efn().name)) {}
    }
    else
    {
      paramString1 = ((Iterable)paramArrayList).iterator();
      while (paramString1.hasNext())
      {
        paramString2 = ((emk)paramString1.next()).BHO;
        paramArrayList = ap.AIh;
        if (p.h(paramString2, ap.efo().name))
        {
          AppMethodBeat.o(287077);
          return true;
        }
      }
    }
    AppMethodBeat.o(287077);
    return false;
  }
  
  private static boolean aGb(String paramString)
  {
    AppMethodBeat.i(287072);
    if (AIP.containsKey(paramString))
    {
      paramString = (aw)AIP.get(paramString);
      if ((paramString == null) || (paramString.qLu != 0L))
      {
        AppMethodBeat.o(287072);
        return true;
      }
    }
    AppMethodBeat.o(287072);
    return false;
  }
  
  private static emk b(String paramString, int paramInt, ArrayList<emk> paramArrayList)
  {
    AppMethodBeat.i(287080);
    Object localObject = null;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    paramArrayList = (ArrayList<emk>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject = (emk)localObject;
      if ((i >= paramInt) || (!p.h(((emk)localObject).BHO, paramString))) {
        break label93;
      }
      paramArrayList = (ArrayList<emk>)localObject;
    }
    label93:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(287080);
      return paramArrayList;
    }
  }
  
  public static int efU()
  {
    return AIK;
  }
  
  public static String efV()
  {
    return AIL;
  }
  
  public static HashMap<String, ArrayList<emk>> efW()
  {
    return AIM;
  }
  
  public static HashMap<String, String> efX()
  {
    return AIN;
  }
  
  public static ConcurrentHashMap<String, aw> efY()
  {
    return AIP;
  }
  
  public static int efZ()
  {
    return AIQ;
  }
  
  public static boolean ega()
  {
    return AIR;
  }
  
  public static void egb()
  {
    AppMethodBeat.i(287081);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 70L);
    AppMethodBeat.o(287081);
  }
  
  public static void egc()
  {
    AppMethodBeat.i(287082);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 71L);
    AppMethodBeat.o(287082);
  }
  
  public static void egd()
  {
    AppMethodBeat.i(287083);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 72L);
    AppMethodBeat.o(287083);
  }
  
  public static void ege()
  {
    AppMethodBeat.i(287084);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 73L);
    AppMethodBeat.o(287084);
  }
  
  public static void egf()
  {
    AppMethodBeat.i(287085);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 79L);
    AppMethodBeat.o(287085);
  }
  
  public static void egg()
  {
    AppMethodBeat.i(287086);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 80L);
    AppMethodBeat.o(287086);
  }
  
  public static void egh()
  {
    AppMethodBeat.i(287087);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 81L);
    AppMethodBeat.o(287087);
  }
  
  private static String j(String paramString, ArrayList<emk> paramArrayList)
  {
    AppMethodBeat.i(287076);
    Object localObject = ap.AIh;
    if (p.h(paramString, ap.efo().name))
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = ((emk)paramArrayList.next()).BHO;
        ap.a locala = ap.AIh;
        if (p.h(localObject, ap.efo().name))
        {
          paramString = ap.AIh;
          paramString = ap.efq().name;
          AppMethodBeat.o(287076);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(287076);
    return paramString;
  }
  
  public static void qU(boolean paramBoolean)
  {
    AIR = paramBoolean;
  }
  
  public final void clear(String paramString)
  {
    try
    {
      AppMethodBeat.i(287079);
      p.k(paramString, "id");
      AIM.remove(paramString);
      AIO.remove(paramString);
      AIP.remove(paramString);
      Log.i(TAG, "clear id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(287079);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "", "cmpMap", "", "", "(Ljava/util/Map;)V", "getCmpMap", "()Ljava/util/Map;", "plugin-finder_release"})
  public static final class a
  {
    final Map<String, String> AIT;
    
    public a(Map<String, String> paramMap)
    {
      AppMethodBeat.i(283254);
      this.AIT = paramMap;
      AppMethodBeat.o(283254);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$TimeCost;", "", "()V", "CDNPlay", "", "cdnConnect", "cdnConnectCount", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "id", "joinLive", "joinLiveCount", "logId", "", "stageConfig", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "total", "totalCount", "trtcConnect", "trtcConnectCount", "processTag", "", "curTagData", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isEnd", "", "reportCdnConnect", "time", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFlow", "", "originDataList", "reportJoinLive", "reportPlay", "reportTotal", "reportTrtcConnect", "plugin-finder_release"})
  public static final class b
  {
    private static final long AHg = 50L;
    private static final long AHh = 51L;
    private static final long AHi = 52L;
    private static final long AHj = 54L;
    private static final long AIU = 1L;
    private static final long AIV = 2L;
    private static final long AIW = 3L;
    private static final long AIX = 5L;
    private static final long AIY = 6L;
    private static final long AIZ = 7L;
    private static final long AJa = 8L;
    private static final ar.a AJb;
    public static final b AJc;
    private static final long id = 1552L;
    private static final int jTq = 21173;
    private static final long total = 0L;
    private static final long xEc = 4L;
    
    static
    {
      AppMethodBeat.i(273060);
      AJc = new b();
      id = 1552L;
      AIU = 1L;
      AIV = 2L;
      AIW = 3L;
      xEc = 4L;
      AIX = 5L;
      AIY = 6L;
      AIZ = 7L;
      AJa = 8L;
      AHg = 50L;
      AHh = 51L;
      AHi = 52L;
      AHj = 54L;
      HashMap localHashMap = new HashMap();
      Object localObject = ap.AIh;
      localObject = ap.efl().name;
      ap.a locala = ap.AIh;
      localHashMap.put(localObject, ap.efi().name);
      localObject = ap.AIh;
      localObject = ap.efn().name;
      locala = ap.AIh;
      localHashMap.put(localObject, ap.efi().name);
      localObject = ap.AIh;
      localObject = ap.efo().name;
      locala = ap.AIh;
      localHashMap.put(localObject, ap.efm().name);
      localObject = ap.AIh;
      localObject = ap.efq().name;
      locala = ap.AIh;
      localHashMap.put(localObject, ap.efh().name);
      localObject = ap.AIh;
      localObject = ap.efp().name;
      locala = ap.AIh;
      localHashMap.put(localObject, ap.efm().name);
      AJb = new ar.a((Map)localHashMap);
      jTq = 21173;
      AppMethodBeat.o(273060);
    }
    
    public static void a(emk paramemk, ArrayList<emk> paramArrayList, boolean paramBoolean)
    {
      AppMethodBeat.i(273057);
      p.k(paramemk, "curTagData");
      p.k(paramArrayList, "dataList");
      Object localObject1 = (String)AJb.AIT.get(paramemk.BHO);
      Object localObject3;
      long l;
      if (localObject1 != null)
      {
        localObject3 = ar.AIS;
        localObject1 = ar.c((String)localObject1, paramArrayList.size(), paramArrayList);
        if (localObject1 != null)
        {
          l = paramemk.GhA - ((emk)localObject1).GhA;
          localObject1 = paramemk.BHO;
          localObject3 = ap.AIh;
          if (!p.h(localObject1, ap.efl().name))
          {
            localObject3 = ap.AIh;
            if (!p.h(localObject1, ap.efn().name)) {
              break label447;
            }
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIU, l, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIX, 1L, false);
          localObject1 = paramemk.BHO;
          localObject3 = ap.AIh;
          if (p.h(localObject1, ap.efn().name))
          {
            localObject3 = paramemk.UoX;
            if (localObject3 != null)
            {
              localObject1 = (a)new cro();
              localObject3 = ((b)localObject3).toByteArray();
            }
          }
        }
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          ((a)localObject1).parseFrom((byte[])localObject3);
          localObject1 = (cro)localObject1;
          if (localObject1 != null) {}
          switch (((cro)localObject1).errCode)
          {
          default: 
            com.tencent.mm.plugin.report.service.h.IzE.F(id, AHj);
            localObject1 = ar.AIS;
            Log.i(ar.egi(), "reportJoinLive ".concat(String.valueOf(l)));
            if (!paramBoolean) {
              break label681;
            }
            paramArrayList = (emk)j.lp((List)paramArrayList);
            if (paramArrayList == null) {
              break label681;
            }
            l = paramemk.GhA - paramArrayList.GhA;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, total, l, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, xEc, 1L, false);
            paramemk = ar.AIS;
            Log.i(ar.egi(), "reportTotal ".concat(String.valueOf(l)));
            AppMethodBeat.o(273057);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.F(id, AHg);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.F(id, AHh);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.F(id, AHi);
          continue;
        }
        label447:
        localObject3 = ap.AIh;
        if (p.h(localObject2, ap.efo().name))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIV, l, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIY, 1L, false);
          localObject2 = ar.AIS;
          Log.i(ar.egi(), "reportCdnConnect ".concat(String.valueOf(l)));
        }
        else
        {
          localObject3 = ap.AIh;
          if (p.h(localObject2, ap.efp().name))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIW, l, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AIZ, 1L, false);
            localObject2 = ar.AIS;
            Log.i(ar.egi(), "reportTrtcConnect ".concat(String.valueOf(l)));
          }
          else
          {
            localObject3 = ap.AIh;
            if (p.h(localObject2, ap.efq().name))
            {
              localObject2 = paramemk.id;
              if (localObject2 != null)
              {
                localObject3 = ar.AIS;
                p.j(localObject2, "it");
                ar.f((String)localObject2, paramemk.GhA, (int)l);
              }
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(id, AJa, l, false);
              localObject2 = ar.AIS;
              Log.i(ar.egi(), "reportBeginPlay ".concat(String.valueOf(l)));
            }
          }
        }
      }
      label681:
      AppMethodBeat.o(273057);
    }
    
    public static void k(String paramString, ArrayList<emk> paramArrayList)
    {
      AppMethodBeat.i(273059);
      p.k(paramString, "id");
      p.k(paramArrayList, "originDataList");
      Object localObject1 = ar.AIS;
      ar.Rp(0);
      localObject1 = ar.AIS;
      ar.qU(false);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll((Collection)paramArrayList);
      Object localObject2 = (emk)j.lp((List)localObject1);
      paramArrayList = (emk)j.lr((List)localObject1);
      long l1;
      long l2;
      int i;
      int j;
      label373:
      int n;
      if ((localObject2 != null) && (paramArrayList != null) && ((p.h(localObject2, paramArrayList) ^ true)))
      {
        l1 = paramArrayList.GhA;
        l2 = ((emk)localObject2).GhA;
        localObject2 = paramArrayList.BHO;
        Object localObject3 = ap.AIh;
        if (p.h(localObject2, ap.efo().name)) {
          i = 1;
        }
        for (;;)
        {
          localObject2 = new StringBuilder();
          localObject3 = ((Iterable)localObject1).iterator();
          j = 0;
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            if (j < 0) {
              j.iBO();
            }
            localObject4 = (emk)localObject4;
            if (j > 0)
            {
              Object localObject5 = ((ArrayList)localObject1).get(j - 1);
              p.j(localObject5, "dataList.get(index - 1)");
              localObject5 = (emk)localObject5;
              ((StringBuilder)localObject2).append(((emk)localObject4).BHO + ':' + (((emk)localObject4).GhA - ((emk)localObject5).GhA) + ';');
              localObject5 = ar.AIS;
              if (ar.efZ() == 0)
              {
                localObject5 = ((emk)localObject4).BHO;
                ap.a locala = ap.AIh;
                if (!p.h(localObject5, ap.eft().name))
                {
                  localObject5 = ((emk)localObject4).BHO;
                  locala = ap.AIh;
                  if (!p.h(localObject5, ap.efs().name))
                  {
                    localObject5 = ((emk)localObject4).BHO;
                    locala = ap.AIh;
                    if (!p.h(localObject5, ap.efu().name)) {
                      break label373;
                    }
                  }
                }
                localObject5 = ar.AIS;
                ar.Rp(1);
              }
              localObject4 = ((emk)localObject4).BHO;
              localObject5 = ap.AIh;
              if (p.h(localObject4, ap.efq().name))
              {
                localObject4 = ar.AIS;
                ar.qU(true);
              }
            }
            j += 1;
          }
          localObject3 = ap.AIh;
          if (p.h(localObject2, ap.efp().name))
          {
            i = 2;
          }
          else
          {
            localObject3 = ap.AIh;
            if (p.h(localObject2, ap.efn().name)) {
              i = 3;
            } else {
              i = 0;
            }
          }
        }
        localObject1 = ar.AIS;
        if (!ar.ega())
        {
          localObject1 = ar.AIS;
          ar.Rp(1);
        }
        n = 0;
        localObject1 = paramArrayList.UoX;
        if (localObject1 == null) {
          break label887;
        }
        paramArrayList = (a)new cro();
        localObject1 = ((b)localObject1).toByteArray();
      }
      for (;;)
      {
        try
        {
          paramArrayList.parseFrom((byte[])localObject1);
          paramArrayList = (cro)paramArrayList;
          if (paramArrayList != null)
          {
            n = paramArrayList.errCode;
            paramArrayList = paramArrayList.errMsg;
            if (paramArrayList != null)
            {
              localObject1 = n.l(paramArrayList, ",", ";", false);
              paramArrayList = (ArrayList<emk>)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramArrayList = "";
            }
            j = 0;
            m = 0;
            k = 0;
            localObject1 = ar.AIS;
            if (ar.efY().containsKey(paramString))
            {
              localObject1 = ar.AIS;
              localObject1 = (aw)ar.efY().get(paramString);
              if ((localObject1 != null) && (((aw)localObject1).qLu == 0L)) {
                break label894;
              }
              j = 1;
              localObject1 = ar.AIS;
              localObject1 = (aw)ar.efY().get(paramString);
              if (localObject1 == null) {
                break label899;
              }
              m = ((aw)localObject1).AJA;
              localObject1 = ar.AIS;
              localObject1 = (aw)ar.efY().get(paramString);
              if (localObject1 == null) {
                break label905;
              }
              k = ((aw)localObject1).AJB;
            }
            paramString = new StringBuilder().append(paramString).append(',').append(l1 - l2).append(',').append(i).append(',').append(localObject2).append(',').append(n).append(',').append(paramArrayList).append(',');
            paramArrayList = ar.AIS;
            paramString = paramString.append(ar.efU()).append(',').append(j).append(',').append(m).append(',').append(k).append(',');
            paramArrayList = ar.AIS;
            paramString = ar.efZ();
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(jTq, paramString);
            paramArrayList = ar.AIS;
            Log.i(ar.egi(), "reportFlow 21173, ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(273059);
            return;
          }
        }
        catch (Exception paramArrayList)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayList });
          paramArrayList = null;
          continue;
          paramArrayList = "";
          continue;
        }
        label887:
        paramArrayList = "";
        continue;
        label894:
        j = 0;
        continue;
        label899:
        int m = 0;
        continue;
        label905:
        int k = 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(288568);
      Object localObject1 = ar.AIS;
      localObject1 = (ArrayList)ar.efW().get(this.sKs);
      if (localObject1 != null)
      {
        Object localObject2 = ar.b.AJc;
        localObject2 = this.sKs;
        p.j(localObject1, "dataList");
        ar.b.k((String)localObject2, (ArrayList)localObject1);
      }
      ar.a(ar.AIS, this.sKs, new ar.a(ae.iBR()));
      ar.AIS.clear(this.sKs);
      AppMethodBeat.o(288568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ar
 * JD-Core Version:    0.7.0.1
 */
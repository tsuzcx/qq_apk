package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.fhi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.protocal.protobuf.fhi;>;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats;", "", "()V", "INNER_VERSION", "", "getINNER_VERSION", "()I", "KEY_ID", "", "RV_VISITOR", "", "getRV_VISITOR", "()Ljava/lang/String;", "TAG", "containBeingPlay", "", "getContainBeingPlay", "()Z", "setContainBeingPlay", "(Z)V", "flows", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getFlows", "()Ljava/util/HashMap;", "historyLog", "getHistoryLog", "playPath", "getPlayPath", "setPlayPath", "(I)V", "preloadMap", "getPreloadMap", "timeRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/utils/PlayTimeCostRecord;", "getTimeRecord", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkEndState", "id", "stage", "isEnd", "stateList", "checkStage", "checkStartState", "isStart", "clear", "", "clearAll", "end", "delay", "getData", "maxIndex", "dataList", "logStage", "config", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "reportLinkAppluSuc", "reportLinkApplyFail", "reportLinkHangupFail", "reportLinkHangupSuc", "reportRewardConsumeFail", "reportRewardFail", "reportRewardLevel", "wecoin", "reportRewardSuc", "saveTime", "beginPlayTime", "selectToPlayTimeCost", "setPreloadLiveState", "preloadLive", "tag", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "tagEnterLive", "userClickPlay", "StageLogConfig", "TimeCost", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  private static final HashMap<String, Boolean> EUu;
  private static final long Gjw;
  public static final bd Gli;
  private static final int Glj;
  private static final String Glk;
  private static final HashMap<String, ArrayList<fhi>> Gll;
  private static final HashMap<String, String> Glm;
  public static final ConcurrentHashMap<String, bn> Gln;
  private static int Glo;
  private static boolean Glp;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333322);
    Gli = new bd();
    TAG = "Finder.LiveFlowStats";
    Glj = 1;
    Glk = "RV_VISITOR_";
    Gll = new HashMap();
    Glm = new HashMap();
    EUu = new HashMap();
    Gln = new ConcurrentHashMap();
    Gjw = 1552L;
    AppMethodBeat.o(333322);
  }
  
  public static void Uw(int paramInt)
  {
    Glo = paramInt;
  }
  
  public static void Ux(int paramInt)
  {
    AppMethodBeat.i(333289);
    if (paramInt < 10)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 82L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    if (paramInt < 50)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 83L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    if (paramInt < 200)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 84L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    if (paramInt < 500)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 85L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    if (paramInt < 1000)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 86L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    if (paramInt < 5000)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 87L, 1L);
      AppMethodBeat.o(333289);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 88L, 1L);
    AppMethodBeat.o(333289);
  }
  
  private final String a(String paramString, bd.a parama)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(333214);
        ArrayList localArrayList = (ArrayList)Gll.get(paramString);
        if (localArrayList != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = (fhi)p.oL((List)localArrayList);
          long l1;
          fhi localfhi;
          if (localObject1 == null)
          {
            l1 = 0L;
            localObject1 = (fhi)p.oN((List)localArrayList);
            if (localObject1 == null)
            {
              l2 = 0L;
              l1 = l2 - l1;
              Iterator localIterator = ((Iterable)localArrayList).iterator();
              i = 0;
              if (!localIterator.hasNext()) {
                continue;
              }
              localObject1 = localIterator.next();
              j = i + 1;
              if (i < 0) {
                p.kkW();
              }
              localfhi = (fhi)localObject1;
              if (i != 0) {
                continue;
              }
              localStringBuilder.append("start at " + localfhi.GvM + "\n " + localfhi.Hsw + " \n ");
              i = j;
              continue;
            }
          }
          else
          {
            l1 = ((fhi)localObject1).GvM;
            continue;
          }
          long l2 = ((fhi)localObject1).GvM;
          continue;
          localObject2 = localArrayList.get(i - 1);
          localObject1 = (String)parama.Glq.get(localfhi.Hsw);
          if (localObject1 != null)
          {
            localObject2 = b((String)localObject1, i, localArrayList);
            break label514;
            if ((l1 <= 0L) || (localObject2 == null)) {
              break label533;
            }
            am localam = am.aixg;
            localObject2 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf((float)(localfhi.GvM - ((fhi)localObject2).GvM) * 100.0F / (float)l1) }, 1));
            s.s(localObject2, "java.lang.String.format(format, *args)");
            localObject2 = s.X((String)localObject2, "%");
            localStringBuilder.append(localfhi.Hsw + '[' + (String)localObject1 + "ms " + (String)localObject2 + "] \n ");
            if (i != localArrayList.size() - 1) {
              break label527;
            }
            localStringBuilder.append(s.X("end at ", Long.valueOf(l2)));
            break label527;
            localObject1 = String.valueOf(localfhi.GvM - ((fhi)localObject2).GvM);
            continue;
            parama = "Total Cost:" + l1 + "ms... " + localStringBuilder;
            Glm.put(paramString, parama);
            Log.i(TAG, parama);
            AppMethodBeat.o(333214);
            paramString = parama;
            return paramString;
          }
        }
        else
        {
          paramString = "";
          AppMethodBeat.o(333214);
          continue;
        }
        if (localObject2 != null) {
          continue;
        }
      }
      finally {}
      label514:
      Object localObject1 = "null ";
      continue;
      label527:
      int i = j;
      continue;
      label533:
      Object localObject2 = "";
    }
  }
  
  private void a(String paramString1, String paramString2, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      bb.a locala;
      try
      {
        AppMethodBeat.i(333166);
        s.u(paramString1, "id");
        s.u(paramString2, "stage");
        ArrayList localArrayList = (ArrayList)Gll.get(paramString1);
        Object localObject;
        if (localArrayList == null)
        {
          localArrayList = new ArrayList();
          localObject = bb.GjM;
          if (s.p(paramString2, bb.fhf().name)) {
            ((Map)EUu).put(paramString1, Boolean.valueOf(paramBoolean3));
          }
          paramBoolean3 = paramBoolean1;
          if (aCc(paramString1))
          {
            localObject = bb.GjM;
            paramBoolean3 = paramBoolean1;
            if (!s.p(paramString2, bb.fho().name)) {
              paramBoolean3 = false;
            }
          }
          paramString2 = k(paramString2, localArrayList);
          paramBoolean1 = a(paramString1, paramString2, paramBoolean2, localArrayList);
          if (paramBoolean3)
          {
            localArrayList.clear();
            localObject = new fhi();
            ((fhi)localObject).id = paramString1;
            ((fhi)localObject).Hsw = paramString2;
            ((fhi)localObject).GvM = cn.bDu();
            if (!paramBoolean3) {
              break label445;
            }
            locala = bb.GjM;
            i = bb.fha();
            ((fhi)localObject).type = i;
            ((fhi)localObject).abHV = paramb;
            paramb = b.Glr;
            b.a((fhi)localObject, localArrayList, paramBoolean1);
            localArrayList.add(localObject);
            ((Map)Gll).put(paramString1, localArrayList);
            Log.i(TAG, "tag, stage:" + paramString2 + ", isStart:" + paramBoolean3 + ", isEnd:" + paramBoolean1);
            if (paramBoolean1) {
              com.tencent.threadpool.h.ahAA.p(new bd..ExternalSyntheticLambda0(paramString1), 0L);
            }
            AppMethodBeat.o(333166);
          }
        }
        else
        {
          continue;
        }
        if (!localArrayList.isEmpty())
        {
          localObject = (fhi)p.oL((List)localArrayList);
          if (localObject == null) {
            break label433;
          }
          i = ((fhi)localObject).type;
          localObject = bb.GjM;
          if (i != bb.fha()) {
            break label433;
          }
          i = 1;
          if (i != 0)
          {
            localObject = (fhi)p.oN((List)localArrayList);
            if (localObject == null) {
              break label439;
            }
            i = ((fhi)localObject).type;
            localObject = bb.GjM;
            if (i != bb.fhb()) {
              break label439;
            }
            i = 1;
            break label469;
          }
        }
        AppMethodBeat.o(333166);
        continue;
        i = 0;
      }
      finally {}
      label433:
      continue;
      label439:
      int i = 0;
      label445:
      if (paramBoolean1)
      {
        locala = bb.GjM;
        i = bb.fhb();
      }
      else
      {
        i = 0;
        continue;
        label469:
        if (i == 0) {}
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2, boolean paramBoolean, ArrayList<fhi> paramArrayList)
  {
    AppMethodBeat.i(333192);
    if (!s.p((Boolean)EUu.get(paramString1), Boolean.TRUE))
    {
      AppMethodBeat.o(333192);
      return paramBoolean;
    }
    paramString1 = bb.GjM;
    if (s.p(paramString2, bb.fhl().name))
    {
      paramString1 = ((Iterable)paramArrayList).iterator();
      while (paramString1.hasNext())
      {
        Object localObject1 = (fhi)paramString1.next();
        Object localObject2 = ((fhi)localObject1).Hsw;
        bb.a locala = bb.GjM;
        if (!s.p(localObject2, bb.fhi().name))
        {
          localObject1 = ((fhi)localObject1).Hsw;
          localObject2 = bb.GjM;
          if (!s.p(localObject1, bb.fhk().name)) {
            break;
          }
        }
        else
        {
          AppMethodBeat.o(333192);
          return true;
        }
      }
    }
    paramString1 = bb.GjM;
    if (!s.p(paramString2, bb.fhi().name))
    {
      paramString1 = bb.GjM;
      if (!s.p(paramString2, bb.fhk().name)) {}
    }
    else
    {
      paramString1 = ((Iterable)paramArrayList).iterator();
      while (paramString1.hasNext())
      {
        paramString2 = ((fhi)paramString1.next()).Hsw;
        paramArrayList = bb.GjM;
        if (s.p(paramString2, bb.fhl().name))
        {
          AppMethodBeat.o(333192);
          return true;
        }
      }
    }
    AppMethodBeat.o(333192);
    return false;
  }
  
  private static boolean aCc(String paramString)
  {
    AppMethodBeat.i(333148);
    if (Gln.containsKey(paramString))
    {
      paramString = (bn)Gln.get(paramString);
      if ((paramString != null) && (paramString.tQb == 0L)) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(333148);
        return true;
      }
    }
    AppMethodBeat.o(333148);
    return false;
  }
  
  private static final void aCd(String paramString)
  {
    AppMethodBeat.i(333297);
    s.u(paramString, "$id");
    ArrayList localArrayList = (ArrayList)Gll.get(paramString);
    if (localArrayList != null)
    {
      b localb = b.Glr;
      b.l(paramString, localArrayList);
    }
    Gli.a(paramString, new bd.a(ak.kkZ()));
    Gli.clear(paramString);
    AppMethodBeat.o(333297);
  }
  
  private static fhi b(String paramString, int paramInt, ArrayList<fhi> paramArrayList)
  {
    AppMethodBeat.i(333221);
    Object localObject = null;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    paramArrayList = (ArrayList<fhi>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (fhi)localObject;
      if ((i >= paramInt) || (!s.p(((fhi)localObject).Hsw, paramString))) {
        break label93;
      }
      paramArrayList = (ArrayList<fhi>)localObject;
    }
    label93:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(333221);
      return paramArrayList;
    }
  }
  
  public static int fhR()
  {
    return Glj;
  }
  
  public static String fhS()
  {
    return Glk;
  }
  
  public static HashMap<String, String> fhT()
  {
    return Glm;
  }
  
  public static ConcurrentHashMap<String, bn> fhU()
  {
    return Gln;
  }
  
  public static int fhV()
  {
    return Glo;
  }
  
  public static boolean fhW()
  {
    return Glp;
  }
  
  public static void fhX()
  {
    AppMethodBeat.i(333230);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 70L, 1L);
    AppMethodBeat.o(333230);
  }
  
  public static void fhY()
  {
    AppMethodBeat.i(333238);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 71L, 1L);
    AppMethodBeat.o(333238);
  }
  
  public static void fhZ()
  {
    AppMethodBeat.i(333245);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 72L, 1L);
    AppMethodBeat.o(333245);
  }
  
  public static void fia()
  {
    AppMethodBeat.i(333252);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 73L, 1L);
    AppMethodBeat.o(333252);
  }
  
  public static void fib()
  {
    AppMethodBeat.i(333262);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 79L, 1L);
    AppMethodBeat.o(333262);
  }
  
  public static void fic()
  {
    AppMethodBeat.i(333270);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 80L, 1L);
    AppMethodBeat.o(333270);
  }
  
  public static void fid()
  {
    AppMethodBeat.i(333281);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 81L, 1L);
    AppMethodBeat.o(333281);
  }
  
  private static String k(String paramString, ArrayList<fhi> paramArrayList)
  {
    AppMethodBeat.i(333181);
    Object localObject = bb.GjM;
    if (s.p(paramString, bb.fhl().name))
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = ((fhi)paramArrayList.next()).Hsw;
        bb.a locala = bb.GjM;
        if (s.p(localObject, bb.fhl().name))
        {
          paramString = bb.GjM;
          paramString = bb.fhn().name;
          AppMethodBeat.o(333181);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(333181);
    return paramString;
  }
  
  public static void uv(boolean paramBoolean)
  {
    Glp = paramBoolean;
  }
  
  public final void clear(String paramString)
  {
    try
    {
      AppMethodBeat.i(333336);
      s.u(paramString, "id");
      Gll.remove(paramString);
      EUu.remove(paramString);
      Gln.remove(paramString);
      Log.i(TAG, s.X("clear id:", paramString));
      AppMethodBeat.o(333336);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$TimeCost;", "", "()V", "CDNPlay", "", "cdnConnect", "cdnConnectCount", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "id", "joinLive", "joinLiveCount", "logId", "", "stageConfig", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "total", "totalCount", "trtcConnect", "trtcConnectCount", "processTag", "", "curTagData", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isEnd", "", "reportCdnConnect", "time", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFlow", "", "originDataList", "reportJoinLive", "reportPlay", "reportTotal", "reportTrtcConnect", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final long Bbb;
    private static final long GjG;
    private static final long GjH;
    private static final long GjI;
    private static final long GjJ;
    public static final b Glr;
    private static final long Gls;
    private static final long Glt;
    private static final long Glu;
    private static final long Glv;
    private static final long Glw;
    private static final long Glx;
    private static final long Gly;
    private static final bd.a Glz;
    private static final long id;
    private static final int mtI;
    private static final long total = 0L;
    
    static
    {
      AppMethodBeat.i(333644);
      Glr = new b();
      id = 1552L;
      Gls = 1L;
      Glt = 2L;
      Glu = 3L;
      Bbb = 4L;
      Glv = 5L;
      Glw = 6L;
      Glx = 7L;
      Gly = 8L;
      GjG = 50L;
      GjH = 51L;
      GjI = 52L;
      GjJ = 54L;
      HashMap localHashMap = new HashMap();
      Object localObject = bb.GjM;
      localObject = bb.fhi().name;
      bb.a locala = bb.GjM;
      localHashMap.put(localObject, bb.fhf().name);
      localObject = bb.GjM;
      localObject = bb.fhk().name;
      locala = bb.GjM;
      localHashMap.put(localObject, bb.fhf().name);
      localObject = bb.GjM;
      localObject = bb.fhl().name;
      locala = bb.GjM;
      localHashMap.put(localObject, bb.fhj().name);
      localObject = bb.GjM;
      localObject = bb.fhn().name;
      locala = bb.GjM;
      localHashMap.put(localObject, bb.fhe().name);
      localObject = bb.GjM;
      localObject = bb.fhm().name;
      locala = bb.GjM;
      localHashMap.put(localObject, bb.fhj().name);
      localObject = ah.aiuX;
      Glz = new bd.a((Map)localHashMap);
      mtI = 21173;
      AppMethodBeat.o(333644);
    }
    
    public static void a(fhi paramfhi, ArrayList<fhi> paramArrayList, boolean paramBoolean)
    {
      AppMethodBeat.i(333595);
      s.u(paramfhi, "curTagData");
      s.u(paramArrayList, "dataList");
      Object localObject1 = (String)Glz.Glq.get(paramfhi.Hsw);
      Object localObject3;
      long l;
      boolean bool;
      if (localObject1 != null)
      {
        localObject3 = bd.Gli;
        localObject1 = bd.c((String)localObject1, paramArrayList.size(), paramArrayList);
        if (localObject1 != null)
        {
          l = paramfhi.GvM - ((fhi)localObject1).GvM;
          localObject1 = paramfhi.Hsw;
          localObject3 = bb.GjM;
          if (!s.p(localObject1, bb.fhi().name)) {
            break label364;
          }
          bool = true;
          if (!bool) {
            break label458;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Gls, l, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Glv, 1L, false);
          localObject1 = paramfhi.Hsw;
          localObject3 = bb.GjM;
          if (s.p(localObject1, bb.fhk().name))
          {
            localObject3 = paramfhi.abHV;
            if (localObject3 != null)
            {
              localObject1 = (a)new dim();
              localObject3 = ((b)localObject3).toByteArray();
            }
          }
        }
      }
      for (;;)
      {
        label364:
        Object localObject2;
        try
        {
          ((a)localObject1).parseFrom((byte[])localObject3);
          localObject1 = (dim)localObject1;
          if (localObject1 != null) {}
          switch (((dim)localObject1).errCode)
          {
          default: 
            com.tencent.mm.plugin.report.service.h.OAn.p(id, GjJ, 1L);
            Log.i(bd.aUw(), s.X("reportJoinLive ", Long.valueOf(l)));
            if (paramBoolean)
            {
              paramArrayList = (fhi)p.oL((List)paramArrayList);
              if (paramArrayList != null)
              {
                l = paramfhi.GvM - paramArrayList.GvM;
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, total, l, false);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Bbb, 1L, false);
                Log.i(bd.aUw(), s.X("reportTotal ", Long.valueOf(l)));
              }
            }
            AppMethodBeat.o(333595);
            return;
            localObject3 = bb.GjM;
            bool = s.p(localObject1, bb.fhk().name);
          }
        }
        catch (Exception localException)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.p(id, GjG, 1L);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.p(id, GjH, 1L);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.p(id, GjI, 1L);
          continue;
        }
        label458:
        localObject3 = bb.GjM;
        if (s.p(localObject2, bb.fhl().name))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Glt, l, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Glw, 1L, false);
          Log.i(bd.aUw(), s.X("reportCdnConnect ", Long.valueOf(l)));
        }
        else
        {
          localObject3 = bb.GjM;
          if (s.p(localObject2, bb.fhm().name))
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Glu, l, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Glx, 1L, false);
            Log.i(bd.aUw(), s.X("reportTrtcConnect ", Long.valueOf(l)));
          }
          else
          {
            localObject3 = bb.GjM;
            if (s.p(localObject2, bb.fhn().name))
            {
              localObject2 = paramfhi.id;
              if (localObject2 != null)
              {
                localObject3 = bd.Gli;
                bd.h((String)localObject2, paramfhi.GvM, (int)l);
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(id, Gly, l, false);
              Log.i(bd.aUw(), s.X("reportBeginPlay ", Long.valueOf(l)));
            }
          }
        }
      }
    }
    
    public static void l(String paramString, ArrayList<fhi> paramArrayList)
    {
      AppMethodBeat.i(333626);
      s.u(paramString, "id");
      s.u(paramArrayList, "originDataList");
      Object localObject1 = bd.Gli;
      bd.Uw(0);
      localObject1 = bd.Gli;
      bd.uv(false);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll((Collection)paramArrayList);
      Object localObject2 = (fhi)p.oL((List)localObject1);
      paramArrayList = (fhi)p.oN((List)localObject1);
      long l1;
      long l2;
      int i;
      int j;
      label371:
      int n;
      if ((localObject2 != null) && (paramArrayList != null) && (!s.p(localObject2, paramArrayList)))
      {
        l1 = paramArrayList.GvM;
        l2 = ((fhi)localObject2).GvM;
        localObject2 = paramArrayList.Hsw;
        Object localObject3 = bb.GjM;
        if (s.p(localObject2, bb.fhl().name)) {
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
              p.kkW();
            }
            localObject4 = (fhi)localObject4;
            if (j > 0)
            {
              Object localObject5 = ((ArrayList)localObject1).get(j - 1);
              s.s(localObject5, "dataList.get(index - 1)");
              localObject5 = (fhi)localObject5;
              ((StringBuilder)localObject2).append(((fhi)localObject4).Hsw + ':' + (((fhi)localObject4).GvM - ((fhi)localObject5).GvM) + ';');
              localObject5 = bd.Gli;
              if (bd.fhV() == 0)
              {
                localObject5 = ((fhi)localObject4).Hsw;
                bb.a locala = bb.GjM;
                if (!s.p(localObject5, bb.fhq().name))
                {
                  localObject5 = ((fhi)localObject4).Hsw;
                  locala = bb.GjM;
                  if (!s.p(localObject5, bb.fhp().name))
                  {
                    localObject5 = ((fhi)localObject4).Hsw;
                    locala = bb.GjM;
                    if (!s.p(localObject5, bb.fhr().name)) {
                      break label371;
                    }
                  }
                }
                localObject5 = bd.Gli;
                bd.Uw(1);
              }
              localObject4 = ((fhi)localObject4).Hsw;
              localObject5 = bb.GjM;
              if (s.p(localObject4, bb.fhn().name))
              {
                localObject4 = bd.Gli;
                bd.uv(true);
              }
            }
            j += 1;
          }
          localObject3 = bb.GjM;
          if (s.p(localObject2, bb.fhm().name))
          {
            i = 2;
          }
          else
          {
            localObject3 = bb.GjM;
            if (s.p(localObject2, bb.fhk().name)) {
              i = 3;
            } else {
              i = 0;
            }
          }
        }
        localObject1 = bd.Gli;
        if (!bd.fhW())
        {
          localObject1 = bd.Gli;
          bd.Uw(1);
        }
        n = 0;
        localObject1 = paramArrayList.abHV;
        if (localObject1 == null) {
          break label905;
        }
        paramArrayList = (a)new dim();
        localObject1 = ((b)localObject1).toByteArray();
      }
      for (;;)
      {
        try
        {
          paramArrayList.parseFrom((byte[])localObject1);
          paramArrayList = (dim)paramArrayList;
          if (paramArrayList != null)
          {
            n = paramArrayList.errCode;
            paramArrayList = paramArrayList.errMsg;
            if (paramArrayList == null)
            {
              paramArrayList = "";
              j = 0;
              m = 0;
              k = 0;
              localObject1 = bd.Gli;
              if (bd.fhU().containsKey(paramString))
              {
                localObject1 = bd.Gli;
                localObject1 = (bn)bd.fhU().get(paramString);
                if ((localObject1 == null) || (((bn)localObject1).tQb != 0L)) {
                  continue;
                }
                j = 1;
                if (j != 0) {
                  continue;
                }
                j = 1;
                localObject1 = bd.Gli;
                localObject1 = (bn)bd.fhU().get(paramString);
                if (localObject1 != null) {
                  continue;
                }
                m = 0;
                localObject1 = bd.Gli;
                localObject1 = (bn)bd.fhU().get(paramString);
                if (localObject1 != null) {
                  continue;
                }
                k = 0;
              }
              paramString = new StringBuilder().append(paramString).append(',').append(l1 - l2).append(',').append(i).append(',').append(localObject2).append(',').append(n).append(',').append(paramArrayList).append(',');
              paramArrayList = bd.Gli;
              paramString = paramString.append(bd.fhR()).append(',').append(j).append(',').append(m).append(',').append(k).append(',');
              paramArrayList = bd.Gli;
              paramString = bd.fhV();
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(mtI, paramString);
              Log.i(bd.aUw(), s.X("reportFlow 21173, ", paramString));
              AppMethodBeat.o(333626);
            }
          }
        }
        catch (Exception paramArrayList)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayList });
          paramArrayList = null;
          continue;
          localObject1 = n.bV(paramArrayList, ",", ";");
          paramArrayList = (ArrayList<fhi>)localObject1;
          if (localObject1 != null) {
            continue;
          }
          paramArrayList = "";
          continue;
          j = 0;
          continue;
          j = 0;
          continue;
          int m = ((bn)localObject1).Gmo;
          continue;
          int k = ((bn)localObject1).Gmp;
          continue;
        }
        label905:
        paramArrayList = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bd
 * JD-Core Version:    0.7.0.1
 */
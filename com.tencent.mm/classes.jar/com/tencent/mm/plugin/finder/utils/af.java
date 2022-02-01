package com.tencent.mm.plugin.finder.utils;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.protocal.protobuf.ecj;>;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats;", "", "()V", "KEY_ID", "", "RV_VISITOR", "", "getRV_VISITOR", "()Ljava/lang/String;", "TAG", "flows", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getFlows", "()Ljava/util/HashMap;", "historyLog", "getHistoryLog", "clear", "", "id", "clearAll", "end", "delay", "", "getData", "stage", "maxIndex", "dataList", "logStage", "config", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "reportLinkAppluSuc", "reportLinkApplyFail", "reportLinkHangupFail", "reportLinkHangupSuc", "reportRewardConsumeFail", "reportRewardFail", "reportRewardLevel", "wecoin", "reportRewardSuc", "tag", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "isStart", "", "isEnd", "StageLogConfig", "TimeCost", "plugin-finder_release"})
public final class af
{
  private static final String TAG = "Finder.LiveFlowStats";
  private static final long vYo = 1552L;
  private static final String vZX = "RV_VISITOR_";
  private static final HashMap<String, ArrayList<ecj>> vZY;
  private static final HashMap<String, String> vZZ;
  public static final af waa;
  
  static
  {
    AppMethodBeat.i(253786);
    waa = new af();
    TAG = "Finder.LiveFlowStats";
    vZX = "RV_VISITOR_";
    vZY = new HashMap();
    vZZ = new HashMap();
    vYo = 1552L;
    AppMethodBeat.o(253786);
  }
  
  public static void LZ(int paramInt)
  {
    AppMethodBeat.i(253785);
    if (paramInt < 10)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 82L);
      AppMethodBeat.o(253785);
      return;
    }
    if (paramInt < 50)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 83L);
      AppMethodBeat.o(253785);
      return;
    }
    if (paramInt < 200)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 84L);
      AppMethodBeat.o(253785);
      return;
    }
    if (paramInt < 500)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 85L);
      AppMethodBeat.o(253785);
      return;
    }
    if (paramInt < 1000)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 86L);
      AppMethodBeat.o(253785);
      return;
    }
    if (paramInt < 5000)
    {
      com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 87L);
      AppMethodBeat.o(253785);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 88L);
    AppMethodBeat.o(253785);
  }
  
  private void a(String paramString1, String paramString2, b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    label342:
    label350:
    label374:
    for (;;)
    {
      ad.a locala;
      int i;
      try
      {
        AppMethodBeat.i(253773);
        p.h(paramString1, "id");
        p.h(paramString2, "stage");
        ArrayList localArrayList = (ArrayList)vZY.get(paramString1);
        if (localArrayList != null) {
          break label374;
        }
        localArrayList = new ArrayList();
        p.g(localArrayList, "flows.get(id) ?: ArrayList()");
        if (paramBoolean1)
        {
          localArrayList.clear();
          localObject = new ecj();
          ((ecj)localObject).id = paramString1;
          ((ecj)localObject).wVT = paramString2;
          ((ecj)localObject).Asv = cl.aWy();
          if (!paramBoolean1) {
            break label350;
          }
          locala = ad.vZu;
          i = ad.dDz();
          ((ecj)localObject).type = i;
          ((ecj)localObject).NcA = paramb;
          paramb = b.waj;
          b.a((ecj)localObject, localArrayList, paramBoolean2);
          localArrayList.add(localObject);
          ((Map)vZY).put(paramString1, localArrayList);
          Log.i(TAG, "tag, stage:" + paramString2 + ", isStart:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
          if (paramBoolean2)
          {
            p.h(paramString1, "id");
            com.tencent.f.h.RTc.o((Runnable)new c(paramString1), 0L);
          }
          AppMethodBeat.o(253773);
          return;
        }
        if (localArrayList.isEmpty()) {
          break label342;
        }
        Object localObject = (ecj)j.kt((List)localArrayList);
        if (localObject != null)
        {
          i = ((ecj)localObject).type;
          localObject = ad.vZu;
          if (i != ad.dDz()) {
            break label342;
          }
          localObject = (ecj)j.kv((List)localArrayList);
          if (localObject == null) {
            continue;
          }
          i = ((ecj)localObject).type;
          localObject = ad.vZu;
          if (i != ad.dDA()) {
            continue;
          }
          AppMethodBeat.o(253773);
          continue;
        }
        AppMethodBeat.o(253773);
      }
      finally {}
      continue;
      AppMethodBeat.o(253773);
      continue;
      if (paramBoolean2)
      {
        locala = ad.vZu;
        i = ad.dDA();
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static ecj b(String paramString, int paramInt, ArrayList<ecj> paramArrayList)
  {
    AppMethodBeat.i(253777);
    Object localObject = null;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    paramArrayList = (ArrayList<ecj>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject = (ecj)localObject;
      if ((i >= paramInt) || (!p.j(((ecj)localObject).wVT, paramString))) {
        break label93;
      }
      paramArrayList = (ArrayList<ecj>)localObject;
    }
    label93:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(253777);
      return paramArrayList;
    }
  }
  
  public static String dEm()
  {
    return vZX;
  }
  
  public static HashMap<String, ArrayList<ecj>> dEn()
  {
    return vZY;
  }
  
  public static HashMap<String, String> dEo()
  {
    return vZZ;
  }
  
  public static void dEp()
  {
    AppMethodBeat.i(253778);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 70L);
    AppMethodBeat.o(253778);
  }
  
  public static void dEq()
  {
    AppMethodBeat.i(253779);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 71L);
    AppMethodBeat.o(253779);
  }
  
  public static void dEr()
  {
    AppMethodBeat.i(253780);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 72L);
    AppMethodBeat.o(253780);
  }
  
  public static void dEs()
  {
    AppMethodBeat.i(253781);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 73L);
    AppMethodBeat.o(253781);
  }
  
  public static void dEt()
  {
    AppMethodBeat.i(253782);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 79L);
    AppMethodBeat.o(253782);
  }
  
  public static void dEu()
  {
    AppMethodBeat.i(253783);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 80L);
    AppMethodBeat.o(253783);
  }
  
  public static void dEv()
  {
    AppMethodBeat.i(253784);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 81L);
    AppMethodBeat.o(253784);
  }
  
  public final String a(String paramString, a parama)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      try
      {
        AppMethodBeat.i(253775);
        p.h(paramString, "id");
        p.h(parama, "config");
        ArrayList localArrayList = (ArrayList)vZY.get(paramString);
        if (localArrayList != null)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          p.g(localArrayList, "dataList");
          localObject1 = (ecj)j.kt((List)localArrayList);
          if (localObject1 != null)
          {
            l2 = ((ecj)localObject1).Asv;
            localObject1 = (ecj)j.kv((List)localArrayList);
            if (localObject1 == null) {
              break label577;
            }
            l1 = ((ecj)localObject1).Asv;
            l2 = l1 - l2;
            Iterator localIterator = ((Iterable)localArrayList).iterator();
            i = 0;
            if (localIterator.hasNext())
            {
              localObject1 = localIterator.next();
              j = i + 1;
              if (i < 0) {
                j.hxH();
              }
              ecj localecj = (ecj)localObject1;
              if (i == 0)
              {
                p.g(localStringBuilder1.append("start at " + localecj.Asv + "\n " + localecj.wVT + " \n "), "flowStr.append(\"start at…\\n ${curData.stage} \\n \")");
                i = j;
                continue;
              }
              localObject2 = (ecj)localArrayList.get(i - 1);
              localObject1 = (String)parama.wab.get(localecj.wVT);
              if (localObject1 == null) {
                break label602;
              }
              localObject2 = b((String)localObject1, i, localArrayList);
              break label583;
              label276:
              if ((l2 <= 0L) || (localObject2 == null)) {
                break label605;
              }
              StringBuilder localStringBuilder2 = new StringBuilder();
              kotlin.g.b.ae localae = kotlin.g.b.ae.SYK;
              long l3 = localecj.Asv;
              if (localObject2 == null) {
                p.hyc();
              }
              localObject2 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf((float)(l3 - ((ecj)localObject2).Asv) * 100.0F / (float)l2) }, 1));
              p.g(localObject2, "java.lang.String.format(format, *args)");
              localObject2 = (String)localObject2 + "%";
              localStringBuilder1.append(localecj.wVT + '[' + (String)localObject1 + "ms " + (String)localObject2 + "] \n ");
              if (i != localArrayList.size() - 1) {
                break label596;
              }
              localStringBuilder1.append("end at ".concat(String.valueOf(l1)));
              break label596;
              l3 = localecj.Asv;
              if (localObject2 == null) {
                p.hyc();
              }
              localObject1 = String.valueOf(l3 - ((ecj)localObject2).Asv);
              continue;
            }
            parama = "Total Cost:" + l2 + "ms... " + localStringBuilder1;
            vZZ.put(paramString, parama);
            Log.i(TAG, parama);
            AppMethodBeat.o(253775);
            paramString = parama;
            return paramString;
          }
        }
        else
        {
          paramString = "";
          AppMethodBeat.o(253775);
          continue;
        }
        long l2 = 0L;
      }
      finally {}
      continue;
      label577:
      long l1 = 0L;
      continue;
      label583:
      label596:
      label602:
      for (;;)
      {
        if (localObject2 != null) {
          break label603;
        }
        localObject1 = "null ";
        break label276;
        i = j;
        break;
      }
      label603:
      continue;
      label605:
      Object localObject2 = "";
    }
  }
  
  public final void clear(String paramString)
  {
    try
    {
      AppMethodBeat.i(253776);
      p.h(paramString, "id");
      vZY.remove(paramString);
      Log.i(TAG, "clear id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(253776);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "", "cmpMap", "", "", "(Ljava/util/Map;)V", "getCmpMap", "()Ljava/util/Map;", "plugin-finder_release"})
  public static final class a
  {
    final Map<String, String> wab;
    
    public a(Map<String, String> paramMap)
    {
      AppMethodBeat.i(253768);
      this.wab = paramMap;
      AppMethodBeat.o(253768);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$TimeCost;", "", "()V", "cdnConnect", "", "cdnConnectCount", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "id", "joinLive", "joinLiveCount", "logId", "", "stageConfig", "Lcom/tencent/mm/plugin/finder/utils/LiveVisitorFlowStats$StageLogConfig;", "total", "totalCount", "trtcConnect", "trtcConnectCount", "processTag", "", "curTagData", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isEnd", "", "reportCdnConnect", "time", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFlow", "", "originDataList", "reportJoinLive", "reportTotal", "reportTrtcConnect", "plugin-finder_release"})
  public static final class b
  {
    private static final int hhs = 21173;
    private static final long id = 1552L;
    private static final long tTn = 4L;
    private static final long total = 0L;
    private static final long vYA = 52L;
    private static final long vYB = 54L;
    private static final long vYy = 50L;
    private static final long vYz = 51L;
    private static final long wac = 1L;
    private static final long wad = 2L;
    private static final long wae = 3L;
    private static final long waf = 5L;
    private static final long wag = 6L;
    private static final long wah = 7L;
    private static final af.a wai;
    public static final b waj;
    
    static
    {
      AppMethodBeat.i(253771);
      waj = new b();
      id = 1552L;
      wac = 1L;
      wad = 2L;
      wae = 3L;
      tTn = 4L;
      waf = 5L;
      wag = 6L;
      wah = 7L;
      vYy = 50L;
      vYz = 51L;
      vYA = 52L;
      vYB = 54L;
      HashMap localHashMap = new HashMap();
      Object localObject = ad.vZu;
      localObject = ad.dDH().name;
      ad.a locala = ad.vZu;
      localHashMap.put(localObject, ad.dDE().name);
      localObject = ad.vZu;
      localObject = ad.dDJ().name;
      locala = ad.vZu;
      localHashMap.put(localObject, ad.dDE().name);
      localObject = ad.vZu;
      localObject = ad.dDK().name;
      locala = ad.vZu;
      localHashMap.put(localObject, ad.dDI().name);
      localObject = ad.vZu;
      localObject = ad.dDL().name;
      locala = ad.vZu;
      localHashMap.put(localObject, ad.dDI().name);
      wai = new af.a((Map)localHashMap);
      hhs = 21173;
      AppMethodBeat.o(253771);
    }
    
    public static void a(ecj paramecj, ArrayList<ecj> paramArrayList, boolean paramBoolean)
    {
      AppMethodBeat.i(253769);
      p.h(paramecj, "curTagData");
      p.h(paramArrayList, "dataList");
      Object localObject1 = (String)wai.wab.get(paramecj.wVT);
      Object localObject3;
      long l;
      if (localObject1 != null)
      {
        localObject3 = af.waa;
        localObject1 = af.c((String)localObject1, paramArrayList.size(), paramArrayList);
        if (localObject1 != null)
        {
          l = paramecj.Asv - ((ecj)localObject1).Asv;
          localObject1 = paramecj.wVT;
          localObject3 = ad.vZu;
          if (!p.j(localObject1, ad.dDH().name))
          {
            localObject3 = ad.vZu;
            if (!p.j(localObject1, ad.dDJ().name)) {
              break label447;
            }
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, wac, l, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, waf, 1L, false);
          localObject1 = paramecj.wVT;
          localObject3 = ad.vZu;
          if (p.j(localObject1, ad.dDJ().name))
          {
            localObject3 = paramecj.NcA;
            if (localObject3 != null)
            {
              localObject1 = (a)new cit();
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
          localObject1 = (cit)localObject1;
          if (localObject1 != null) {}
          switch (((cit)localObject1).errCode)
          {
          default: 
            com.tencent.mm.plugin.report.service.h.CyF.F(id, vYB);
            localObject1 = af.waa;
            Log.i(af.dEw(), "reportJoinLive ".concat(String.valueOf(l)));
            if (!paramBoolean) {
              break label589;
            }
            paramArrayList = (ecj)j.kt((List)paramArrayList);
            if (paramArrayList == null) {
              break label589;
            }
            l = paramecj.Asv - paramArrayList.Asv;
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, total, l, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, tTn, 1L, false);
            paramecj = af.waa;
            Log.i(af.dEw(), "reportTotal ".concat(String.valueOf(l)));
            AppMethodBeat.o(253769);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.F(id, vYy);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.F(id, vYz);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.F(id, vYA);
          continue;
        }
        label447:
        localObject3 = ad.vZu;
        if (p.j(localObject2, ad.dDK().name))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, wad, l, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, wag, 1L, false);
          localObject2 = af.waa;
          Log.i(af.dEw(), "reportCdnConnect ".concat(String.valueOf(l)));
        }
        else
        {
          localObject3 = ad.vZu;
          if (p.j(localObject2, ad.dDL().name))
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, wae, l, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(id, wah, 1L, false);
            localObject2 = af.waa;
            Log.i(af.dEw(), "reportTrtcConnect ".concat(String.valueOf(l)));
          }
        }
      }
      label589:
      AppMethodBeat.o(253769);
    }
    
    public static void i(String paramString, ArrayList<ecj> paramArrayList)
    {
      AppMethodBeat.i(253770);
      p.h(paramString, "id");
      p.h(paramArrayList, "originDataList");
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll((Collection)paramArrayList);
      Object localObject2 = (ecj)j.kt((List)localObject1);
      paramArrayList = (ecj)j.kv((List)localObject1);
      long l1;
      long l2;
      int i;
      int j;
      if ((localObject2 != null) && (paramArrayList != null) && ((p.j(localObject2, paramArrayList) ^ true)))
      {
        l1 = paramArrayList.Asv;
        l2 = ((ecj)localObject2).Asv;
        localObject2 = paramArrayList.wVT;
        Object localObject3 = ad.vZu;
        if (p.j(localObject2, ad.dDK().name)) {
          i = 1;
        }
        for (;;)
        {
          localObject2 = new StringBuilder();
          localObject3 = (Iterable)localObject1;
          j = 0;
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            if (j < 0) {
              j.hxH();
            }
            localObject4 = (ecj)localObject4;
            if (j > 0)
            {
              Object localObject5 = ((ArrayList)localObject1).get(j - 1);
              p.g(localObject5, "dataList.get(index - 1)");
              localObject5 = (ecj)localObject5;
              ((StringBuilder)localObject2).append(((ecj)localObject4).wVT + ':' + (((ecj)localObject4).Asv - ((ecj)localObject5).Asv) + ';');
            }
            j += 1;
          }
          localObject3 = ad.vZu;
          if (p.j(localObject2, ad.dDL().name))
          {
            i = 2;
          }
          else
          {
            localObject3 = ad.vZu;
            if (p.j(localObject2, ad.dDJ().name)) {
              i = 3;
            } else {
              i = 0;
            }
          }
        }
        j = 0;
        localObject1 = paramArrayList.NcA;
        if (localObject1 == null) {
          break label546;
        }
        paramArrayList = (a)new cit();
        localObject1 = ((b)localObject1).toByteArray();
      }
      for (;;)
      {
        try
        {
          paramArrayList.parseFrom((byte[])localObject1);
          paramArrayList = (cit)paramArrayList;
          if (paramArrayList != null)
          {
            int k = paramArrayList.errCode;
            paramArrayList = paramArrayList.errMsg;
            if (paramArrayList != null)
            {
              localObject1 = n.j(paramArrayList, ",", ";", false);
              paramArrayList = (ArrayList<ecj>)localObject1;
              j = k;
              if (localObject1 != null) {}
            }
            else
            {
              paramArrayList = "";
              j = k;
            }
            paramString = paramString + ',' + (l1 - l2) + ',' + i + ',' + localObject2 + ',' + j + ',' + paramArrayList;
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(hhs, paramString);
            paramArrayList = af.waa;
            Log.i(af.dEw(), "reportFlow 21173, ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(253770);
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
        label546:
        paramArrayList = "";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(253772);
      Object localObject1 = af.waa;
      localObject1 = (ArrayList)af.dEn().get(this.pAl);
      if (localObject1 != null)
      {
        Object localObject2 = af.b.waj;
        localObject2 = this.pAl;
        p.g(localObject1, "dataList");
        af.b.i((String)localObject2, (ArrayList)localObject1);
      }
      af.waa.a(this.pAl, new af.a(kotlin.a.ae.emptyMap()));
      af.waa.clear(this.pAl);
      AppMethodBeat.o(253772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.af
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.edge.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.c.i;

public final class a
  implements c
{
  private long mAM;
  public b zAl;
  private long zAm;
  
  public a()
  {
    AppMethodBeat.i(299637);
    this.zAl = new b();
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dHW();
    if (localMultiProcessMMKV != null)
    {
      this.zAm = localMultiProcessMMKV.getLong("mmkv_key_realtime_report_period", 0L);
      this.mAM = localMultiProcessMMKV.getLong("mmkv_key_realtime_report_lasttime", 0L);
    }
    AppMethodBeat.o(299637);
  }
  
  private static void a(int paramInt, String paramString, z.a parama)
  {
    AppMethodBeat.i(299705);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new emj();
    ((c.a)localObject).otF = new emk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((c.a)localObject).funcId = 716;
    localObject = ((c.a)localObject).bEF();
    emj localemj = (emj)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localemj.mut = d.Yxb;
    localemj.muu = d.Yxa;
    localemj.muv = d.Yxd;
    localemj.muw = d.Yxe;
    localemj.mux = LocaleUtil.getApplicationLanguage();
    localemj.aaLf = paramInt;
    localemj.OzQ = paramString;
    z.a((com.tencent.mm.am.c)localObject, new a..ExternalSyntheticLambda2(Util.nowMilliSecond(), localemj, parama));
    AppMethodBeat.o(299705);
  }
  
  public static void b(String paramString, int paramInt, List<com.tencent.mm.plugin.expt.edge.e.b> paramList)
  {
    AppMethodBeat.i(299650);
    if ((i.hm(paramString)) || (paramInt <= 0) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299650);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (com.tencent.mm.plugin.expt.edge.e.b)localIterator.next();
        j = i;
        if (paramList == null)
        {
          AppMethodBeat.o(299650);
          return;
        }
        while (paramList.index > j)
        {
          localArrayList.add("");
          j += 1;
        }
        i = j;
        if (paramList.index >= j) {
          if (paramList.type == 2) {
            paramList = String.valueOf(paramList.zzU);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject = paramList;
      if (paramList.contains(",")) {
        localObject = paramList.replace(",", "\\$");
      }
      localArrayList.add(localObject);
      i = j + 1;
      break;
      if (paramList.type == 1) {
        paramList = String.valueOf(paramList.qDL);
      } else if (paramList.type == 0)
      {
        if (paramList.stringValue == null)
        {
          paramList = "";
        }
        else
        {
          paramList = paramList.stringValue;
          continue;
          b.L(paramString, paramInt, eZ(localArrayList));
          AppMethodBeat.o(299650);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  public static String eZ(List<String> paramList)
  {
    AppMethodBeat.i(299694);
    if (paramList == null)
    {
      AppMethodBeat.o(299694);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)paramList.get(i)).append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)paramList.get(i));
      }
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(299694);
    return paramList;
  }
  
  private boolean fn(List<ama> paramList)
  {
    AppMethodBeat.i(299682);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299682);
      return false;
    }
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(299682);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.plugin.expt.edge.b.a(paramList, this), 0);
    AppMethodBeat.o(299682);
    return bool;
  }
  
  private static void fo(List<ama> paramList)
  {
    AppMethodBeat.i(299688);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299688);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ama localama = (ama)paramList.next();
      if ((localama.Krs != null) && (localama.Krs.size() > 0))
      {
        Iterator localIterator = localama.Krs.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(localama.ZsX, str);
        }
      }
    }
    AppMethodBeat.o(299688);
  }
  
  public static void v(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(299658);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(299658);
      return;
    }
    Log.i("EdgeComputingReporter", "[EdgeComputingReporter] kvReportStrData logID : ".concat(String.valueOf(paramInt)));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = str;
      if (str.contains(",")) {
        paramList = str.replace(",", "\\$");
      }
      localArrayList.add(paramList);
    }
    paramList = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.d(paramInt, eZ(localArrayList), false, true);
    AppMethodBeat.o(299658);
  }
  
  public static void w(int paramInt, List<com.tencent.mm.plugin.expt.edge.e.b> paramList)
  {
    AppMethodBeat.i(299666);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(299666);
      return;
    }
    Log.i("EdgeComputingReporter", "[EdgeComputingReporter] kvReportFieldData logID : ".concat(String.valueOf(paramInt)));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (com.tencent.mm.plugin.expt.edge.e.b)localIterator.next();
        j = i;
        if (paramList == null)
        {
          AppMethodBeat.o(299666);
          return;
        }
        while (paramList.index > j)
        {
          localArrayList.add("");
          j += 1;
        }
        i = j;
        if (paramList.index >= j) {
          if (paramList.type == 2) {
            paramList = String.valueOf(paramList.zzU);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject = paramList;
      if (paramList.contains(",")) {
        localObject = paramList.replace(",", "\\$");
      }
      localArrayList.add(localObject);
      i = j + 1;
      break;
      if (paramList.type == 1) {
        paramList = String.valueOf(paramList.qDL);
      } else if (paramList.type == 0)
      {
        if (paramList.stringValue == null)
        {
          paramList = "";
        }
        else
        {
          paramList = paramList.stringValue;
          continue;
          paramList = com.tencent.mm.plugin.report.service.h.OAn;
          com.tencent.mm.plugin.report.service.h.d(paramInt, eZ(localArrayList), false, true);
          AppMethodBeat.o(299666);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  public static void x(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(299671);
    if ((paramInt <= 0) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299671);
      return;
    }
    Log.i("EdgeComputingReporter", "[EdgeComputingReporter] rtKVReportStrData logID : ".concat(String.valueOf(paramInt)));
    a(paramInt, eZ(paramList), new a..ExternalSyntheticLambda1(paramInt, paramList));
    AppMethodBeat.o(299671);
  }
  
  public static void y(int paramInt, List<com.tencent.mm.plugin.expt.edge.e.b> paramList)
  {
    AppMethodBeat.i(299677);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(299677);
      return;
    }
    Log.i("EdgeComputingReporter", "[EdgeComputingReporter] rtKVReportFieldData logID : ".concat(String.valueOf(paramInt)));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (com.tencent.mm.plugin.expt.edge.e.b)localIterator.next();
        j = i;
        if (paramList == null)
        {
          AppMethodBeat.o(299677);
          return;
        }
        while (paramList.index > j)
        {
          localArrayList.add("");
          j += 1;
        }
        i = j;
        if (paramList.index >= j) {
          if (paramList.type == 2) {
            paramList = String.valueOf(paramList.zzU);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject = paramList;
      if (paramList.contains(",")) {
        localObject = paramList.replace(",", "\\$");
      }
      localArrayList.add(localObject);
      i = j + 1;
      break;
      if (paramList.type == 1) {
        paramList = String.valueOf(paramList.qDL);
      } else if (paramList.type == 0)
      {
        if (paramList.stringValue == null)
        {
          paramList = "";
        }
        else
        {
          paramList = paramList.stringValue;
          continue;
          a(paramInt, eZ(localArrayList), new a..ExternalSyntheticLambda0(paramInt, localArrayList));
          AppMethodBeat.o(299677);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  public final void a(long paramLong, List<alz> paramList, List<ama> paramList1)
  {
    AppMethodBeat.i(299760);
    Object localObject = com.tencent.mm.plugin.expt.edge.b.dHW();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putLong("mmkv_key_realtime_report_period", paramLong);
    }
    this.zAm = paramLong;
    if ((paramList != null) && (paramList1 != null))
    {
      paramList = paramList.iterator();
      int i = 0;
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label270;
        }
        localObject = (alz)paramList.next();
        Iterator localIterator = paramList1.iterator();
        if (localIterator.hasNext())
        {
          ama localama = (ama)localIterator.next();
          if ((!i.qA(localama.zzS, ((alz)localObject).zzS)) || (localama.ZsX != ((alz)localObject).ZsX)) {
            break;
          }
          if ((((alz)localObject).ZsY != 0) && (localama.Krs != null))
          {
            localIterator = localama.Krs.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(localama.ZsX, str);
            }
            i = 1;
            Log.e("EdgeComputingReporter", "report realtimeReport svr reject configID : " + localama.zzS + ", logID : " + localama.ZsX + ", dropFlag : " + ((alz)localObject).ZsY + ", contents size : " + localama.Krs.size());
          }
        }
      }
      label270:
      if (i != 0) {
        break label290;
      }
      com.tencent.mm.plugin.expt.edge.f.a.Lv(5);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.edge.f.a.Lv(2);
      AppMethodBeat.o(299760);
      return;
      label290:
      com.tencent.mm.plugin.expt.edge.f.a.Lv(4);
    }
  }
  
  public final void dIu()
  {
    AppMethodBeat.i(299750);
    Object localObject = b.dIv();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      AppMethodBeat.o(299750);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.mAM < this.zAm * 1000L)
    {
      Log.i("EdgeComputingReporter", "report realtimeReport reportPeriod : " + this.zAm + ", distance : " + (l - this.mAM));
      AppMethodBeat.o(299750);
      return;
    }
    if (!fn((List)localObject))
    {
      fo((List)localObject);
      Log.e("EdgeComputingReporter", "report realtimeReport fail!");
    }
    localObject = com.tencent.mm.plugin.expt.edge.b.dHW();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putLong("mmkv_key_realtime_report_lasttime", l);
    }
    this.mAM = l;
    b.clear();
    com.tencent.mm.plugin.expt.edge.f.a.Lv(1);
    AppMethodBeat.o(299750);
  }
  
  public final void fp(List<ama> paramList)
  {
    AppMethodBeat.i(299768);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299768);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ama localama = (ama)paramList.next();
      Iterator localIterator = localama.Krs.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(localama.ZsX, str);
      }
    }
    com.tencent.mm.plugin.expt.edge.f.a.Lv(3);
    AppMethodBeat.o(299768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.g.a
 * JD-Core Version:    0.7.0.1
 */
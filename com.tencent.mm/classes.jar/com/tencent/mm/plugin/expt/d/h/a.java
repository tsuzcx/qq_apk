package com.tencent.mm.plugin.expt.d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.b.g;

public final class a
  implements c
{
  private long kaI;
  public b weq;
  private long wer;
  
  public a()
  {
    AppMethodBeat.i(256956);
    this.weq = new b();
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.d.b.dbz();
    if (localMultiProcessMMKV != null)
    {
      this.wer = localMultiProcessMMKV.getLong("mmkv_key_realtime_report_period", 0L);
      this.kaI = localMultiProcessMMKV.getLong("mmkv_key_realtime_report_lasttime", 0L);
    }
    AppMethodBeat.o(256956);
  }
  
  public static void b(String paramString, int paramInt, List<com.tencent.mm.plugin.expt.d.f.b> paramList)
  {
    AppMethodBeat.i(256960);
    if ((g.fK(paramString)) || (paramInt <= 0) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(256960);
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
        paramList = (com.tencent.mm.plugin.expt.d.f.b)localIterator.next();
        j = i;
        if (paramList == null)
        {
          AppMethodBeat.o(256960);
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
            paramList = String.valueOf(paramList.wea);
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
        paramList = String.valueOf(paramList.intValue);
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
          b.J(paramString, paramInt, dt(localArrayList));
          AppMethodBeat.o(256960);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  private boolean dr(List<aiv> paramList)
  {
    AppMethodBeat.i(256972);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(256972);
      return false;
    }
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(256972);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.plugin.expt.d.b.a(paramList, this), 0);
    AppMethodBeat.o(256972);
    return bool;
  }
  
  private static void ds(List<aiv> paramList)
  {
    AppMethodBeat.i(256974);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(256974);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aiv localaiv = (aiv)paramList.next();
      if ((localaiv.EyF != null) && (localaiv.EyF.size() > 0))
      {
        Iterator localIterator = localaiv.EyF.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(localaiv.Stn, str);
        }
      }
    }
    AppMethodBeat.o(256974);
  }
  
  public static String dt(List<String> paramList)
  {
    AppMethodBeat.i(256977);
    if ((paramList == null) || (paramList.isEmpty())) {}
    StringBuilder localStringBuilder;
    for (paramList = "";; paramList = localStringBuilder.toString())
    {
      AppMethodBeat.o(256977);
      return paramList;
      localStringBuilder = new StringBuilder();
      int j = paramList.size() - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i)).append(',');
        i += 1;
      }
      localStringBuilder.append((String)paramList.get(j));
    }
  }
  
  public static void g(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(256963);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(256963);
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
    paramList = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.report.service.h.u(paramInt, localArrayList);
    AppMethodBeat.o(256963);
  }
  
  public static void h(int paramInt, List<com.tencent.mm.plugin.expt.d.f.b> paramList)
  {
    AppMethodBeat.i(256966);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(256966);
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
        paramList = (com.tencent.mm.plugin.expt.d.f.b)localIterator.next();
        j = i;
        if (paramList == null)
        {
          AppMethodBeat.o(256966);
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
            paramList = String.valueOf(paramList.wea);
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
        paramList = String.valueOf(paramList.intValue);
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
          if (localArrayList.size() > 0)
          {
            paramList = com.tencent.mm.plugin.report.service.h.IzE;
            com.tencent.mm.plugin.report.service.h.u(paramInt, localArrayList);
          }
          AppMethodBeat.o(256966);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  public final void a(long paramLong, List<aiu> paramList, List<aiv> paramList1)
  {
    AppMethodBeat.i(256981);
    Object localObject = com.tencent.mm.plugin.expt.d.b.dbz();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putLong("mmkv_key_realtime_report_period", paramLong);
    }
    this.wer = paramLong;
    if ((paramList != null) && (paramList1 != null))
    {
      paramList = paramList.iterator();
      int i = 0;
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label269;
        }
        localObject = (aiu)paramList.next();
        Iterator localIterator = paramList1.iterator();
        if (localIterator.hasNext())
        {
          aiv localaiv = (aiv)localIterator.next();
          if ((!g.oC(localaiv.wdY, ((aiu)localObject).wdY)) || (localaiv.Stn != ((aiu)localObject).Stn)) {
            break;
          }
          if ((((aiu)localObject).Sto != 0) && (localaiv.EyF != null))
          {
            localIterator = localaiv.EyF.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(localaiv.Stn, str);
            }
            i = 1;
            Log.e("EdgeComputingReporter", "report realtimeReport svr reject configID : " + localaiv.wdY + ", logID : " + localaiv.Stn + ", dropFlag : " + ((aiu)localObject).Sto + ", contents size : " + localaiv.EyF.size());
          }
        }
      }
      label269:
      if (i != 0) {
        break label288;
      }
      com.tencent.mm.plugin.expt.d.g.a.Kv(5);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.d.g.a.Kv(2);
      AppMethodBeat.o(256981);
      return;
      label288:
      com.tencent.mm.plugin.expt.d.g.a.Kv(4);
    }
  }
  
  public final void dbQ()
  {
    AppMethodBeat.i(256969);
    Object localObject = b.dbR();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      AppMethodBeat.o(256969);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.kaI < this.wer * 1000L)
    {
      Log.i("EdgeComputingReporter", "report realtimeReport reportPeriod : " + this.wer + ", distance : " + (l - this.kaI));
      AppMethodBeat.o(256969);
      return;
    }
    if (!dr((List)localObject))
    {
      ds((List)localObject);
      Log.e("EdgeComputingReporter", "report realtimeReport fail!");
    }
    localObject = com.tencent.mm.plugin.expt.d.b.dbz();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putLong("mmkv_key_realtime_report_lasttime", l);
    }
    this.kaI = l;
    b.clear();
    com.tencent.mm.plugin.expt.d.g.a.Kv(1);
    AppMethodBeat.o(256969);
  }
  
  public final void du(List<aiv> paramList)
  {
    AppMethodBeat.i(256985);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(256985);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aiv localaiv = (aiv)paramList.next();
      Iterator localIterator = localaiv.EyF.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(localaiv.Stn, str);
      }
    }
    com.tencent.mm.plugin.expt.d.g.a.Kv(3);
    AppMethodBeat.o(256985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.a
 * JD-Core Version:    0.7.0.1
 */
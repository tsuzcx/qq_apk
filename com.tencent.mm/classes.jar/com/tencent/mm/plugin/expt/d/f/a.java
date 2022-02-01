package com.tencent.mm.plugin.expt.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  private static Boolean qQn;
  public static Boolean qQo;
  
  public static void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210273);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 8L, 1L, false);
    }
    for (;;)
    {
      ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(210273);
      return;
      if (paramLong <= 100L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 9L, 1L, false);
      }
      else if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 10L, 1L, false);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 11L, 1L, false);
        if (qQo == null)
        {
          qQo = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qHP, false));
          ad.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime sIsMonitorPerformance : " + qQo);
        }
        if (qQo.booleanValue()) {
          com.tencent.mm.plugin.report.service.g.yhR.f(20176, new Object[] { paramString, Integer.valueOf(2), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
        }
      }
    }
  }
  
  public static void kR(boolean paramBoolean)
  {
    AppMethodBeat.i(210274);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 20L, 1L, false);
    }
    for (;;)
    {
      ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(210274);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 21L, 1L, false);
    }
  }
  
  public static void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(210275);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 22L, 1L, false);
    }
    for (;;)
    {
      ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(210275);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 23L, 1L, false);
    }
  }
  
  public static void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(210276);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 24L, 1L, false);
    }
    for (;;)
    {
      ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(210276);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 25L, 1L, false);
    }
  }
  
  public static void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210272);
    if (qQn == null)
    {
      qQn = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qHO, false));
      ad.i("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess sIsMonitorProcess : " + qQn);
    }
    if (qQn.booleanValue()) {
      com.tencent.mm.plugin.report.service.g.yhR.f(20177, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(210272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.f.a
 * JD-Core Version:    0.7.0.1
 */
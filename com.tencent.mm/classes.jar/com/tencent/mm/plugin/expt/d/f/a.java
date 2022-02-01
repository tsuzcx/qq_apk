package com.tencent.mm.plugin.expt.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  private static Boolean qYi;
  public static Boolean qYj;
  
  public static void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(195926);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 8L, 1L, false);
    }
    for (;;)
    {
      ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(195926);
      return;
      if (paramLong <= 100L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 9L, 1L, false);
      }
      else if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 10L, 1L, false);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 11L, 1L, false);
        if (qYj == null)
        {
          qYj = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qPv, false));
          ae.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime sIsMonitorPerformance : " + qYj);
        }
        if (qYj.booleanValue()) {
          com.tencent.mm.plugin.report.service.g.yxI.f(20176, new Object[] { paramString, Integer.valueOf(2), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
        }
      }
    }
  }
  
  public static void kR(boolean paramBoolean)
  {
    AppMethodBeat.i(195927);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 20L, 1L, false);
    }
    for (;;)
    {
      ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(195927);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 21L, 1L, false);
    }
  }
  
  public static void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(195928);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 22L, 1L, false);
    }
    for (;;)
    {
      ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(195928);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 23L, 1L, false);
    }
  }
  
  public static void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(195929);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 24L, 1L, false);
    }
    for (;;)
    {
      ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(195929);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 25L, 1L, false);
    }
  }
  
  public static void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(195925);
    if (qYi == null)
    {
      qYi = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qPu, false));
      ae.i("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess sIsMonitorProcess : " + qYi);
    }
    if (qYi.booleanValue()) {
      com.tencent.mm.plugin.report.service.g.yxI.f(20177, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(195925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.f.a
 * JD-Core Version:    0.7.0.1
 */
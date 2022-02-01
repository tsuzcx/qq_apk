package com.tencent.mm.plugin.expt.d.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static Boolean wep;
  
  public static void Kv(int paramInt)
  {
    AppMethodBeat.i(251563);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 38L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statRealReportProcess reportProcess : ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(251563);
      return;
      if (paramInt == 2)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 30L, 1L, false);
      }
      else if (paramInt == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 31L, 1L, false);
      }
      else if (paramInt == 4)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 32L, 1L, false);
      }
      else
      {
        if (paramInt != 5) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 33L, 1L, false);
      }
    }
    AppMethodBeat.o(251563);
  }
  
  public static boolean dbP()
  {
    AppMethodBeat.i(251566);
    if (wep == null) {
      if (!com.tencent.mm.plugin.expt.d.b.No()) {
        break label60;
      }
    }
    label60:
    for (wep = Boolean.TRUE;; wep = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXA, false)))
    {
      Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] getMonitorPerformanceSwitch sMonitorSwitch : " + wep);
      boolean bool = wep.booleanValue();
      AppMethodBeat.o(251566);
      return bool;
    }
  }
  
  public static void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(251558);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 8L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 45L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 46L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 91L, 1L, false);
      if (dbP()) {
        com.tencent.mm.plugin.report.service.h.IzE.a(20176, new Object[] { paramString, Integer.valueOf(2), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      }
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(251558);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 9L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 10L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 11L, 1L, false);
      }
    }
  }
  
  public static void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(251557);
    if (dbP()) {
      com.tencent.mm.plugin.report.service.h.IzE.a(20177, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess configID : %s, process : %d, reportTimeEC : %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(251557);
  }
  
  public static void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(251559);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 20L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 55L, 1L, false);
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(251559);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 21L, 1L, false);
    }
  }
  
  public static void nf(boolean paramBoolean)
  {
    AppMethodBeat.i(251561);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 22L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 36L, 1L, false);
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(251561);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 23L, 1L, false);
    }
  }
  
  public static void ng(boolean paramBoolean)
  {
    AppMethodBeat.i(251562);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 24L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 37L, 1L, false);
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(251562);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 25L, 1L, false);
    }
  }
  
  public static void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(251564);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 177L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 179L, 1L, false);
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptDownloadSuccess success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(251564);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1409L, 178L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.g.a
 * JD-Core Version:    0.7.0.1
 */
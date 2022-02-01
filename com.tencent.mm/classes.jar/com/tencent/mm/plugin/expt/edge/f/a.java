package com.tencent.mm.plugin.expt.edge.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.edge.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import org.apache.commons.c.i;

public final class a
{
  private static Boolean zAj;
  private static String zAk = "";
  
  public static void D(long paramLong, int paramInt)
  {
    AppMethodBeat.i(299817);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 26L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 53L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 54L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 98L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { zAk, Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime configID : %s, costTime : %d, type : %d", new Object[] { zAk, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(299817);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 27L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 28L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 29L, 1L, false);
      }
    }
  }
  
  public static void Lv(int paramInt)
  {
    AppMethodBeat.i(299854);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 38L, 1L, false);
    }
    for (;;)
    {
      b.hf("EdgeComputingMonitor", "[EdgeComputingMonitor] statRealReportProcess reportProcess : ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(299854);
      return;
      if (paramInt == 2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 30L, 1L, false);
      }
      else if (paramInt == 3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 31L, 1L, false);
      }
      else if (paramInt == 4)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 32L, 1L, false);
      }
      else
      {
        if (paramInt != 5) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 33L, 1L, false);
      }
    }
    AppMethodBeat.o(299854);
  }
  
  public static void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(299761);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 4L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 43L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 44L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 90L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(1), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299761);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 5L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 6L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 7L, 1L, false);
      }
    }
  }
  
  public static void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(299805);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 68L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 72L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 73L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 96L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(9), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statSingleScriptWorkTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299805);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 69L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 70L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 71L, 1L, false);
      }
    }
  }
  
  public static void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(299843);
    if (dIt()) {
      com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(10), Integer.valueOf(0), Long.valueOf(paramLong), "" });
    }
    AppMethodBeat.o(299843);
  }
  
  public static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(299847);
    if (dIt()) {
      com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(paramLong), "" });
    }
    AppMethodBeat.o(299847);
  }
  
  public static void aqr(String paramString)
  {
    AppMethodBeat.i(299866);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299866);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = b.dHW();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299866);
      return;
    }
    long l = System.currentTimeMillis();
    String str = "mmkv_key_log_last_report_time" + zAk;
    if ((l - localMultiProcessMMKV.getLong(str, 0L) <= 604800000L) && (!b.isDebugMode()))
    {
      AppMethodBeat.o(299866);
      return;
    }
    if (dIt())
    {
      paramString = paramString.replace(",", ";");
      com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { zAk, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), paramString });
      localMultiProcessMMKV.putLong(str, l);
    }
    AppMethodBeat.o(299866);
  }
  
  public static void aqs(String paramString)
  {
    AppMethodBeat.i(299877);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299877);
      return;
    }
    zAk = paramString;
    AppMethodBeat.o(299877);
  }
  
  private static boolean dIt()
  {
    AppMethodBeat.i(299871);
    if (zAj == null) {
      if (!b.isDebugMode()) {
        break label60;
      }
    }
    label60:
    for (zAj = Boolean.TRUE;; zAj = Boolean.valueOf(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqg, false)))
    {
      Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] getMonitorPerformanceSwitch sMonitorSwitch : " + zAj);
      boolean bool = zAj.booleanValue();
      AppMethodBeat.o(299871);
      return bool;
    }
  }
  
  public static void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(299752);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 0L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 34L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 35L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 89L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(paramInt), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(299752);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 1L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 2L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 3L, 1L, false);
      }
    }
  }
  
  public static void f(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(299771);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 8L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 45L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 46L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 91L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(2), Long.valueOf(paramLong), Integer.valueOf(paramInt), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(299771);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 9L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 10L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 11L, 1L, false);
      }
    }
  }
  
  public static void g(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(299780);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 12L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 47L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 48L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 92L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { paramString, Integer.valueOf(3), Long.valueOf(paramLong), Integer.valueOf(paramInt), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statSQLQueryCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(299780);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 13L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 14L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 15L, 1L, false);
      }
    }
  }
  
  public static void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(299743);
    if (dIt()) {
      com.tencent.mm.plugin.report.service.h.OAn.b(20177, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess configID : %s, process : %d, reportTimeEC : %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(299743);
  }
  
  public static void lT(long paramLong)
  {
    AppMethodBeat.i(299788);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 16L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 49L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 50L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 93L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { Integer.valueOf(0), Integer.valueOf(4), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statRegularTaskTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299788);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 17L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 18L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 19L, 1L, false);
      }
    }
  }
  
  public static void lU(long paramLong)
  {
    AppMethodBeat.i(299793);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 56L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 60L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 61L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 94L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { Integer.valueOf(0), Integer.valueOf(7), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statUnInstantTaskTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299793);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 57L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 58L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 59L, 1L, false);
      }
    }
  }
  
  public static void lV(long paramLong)
  {
    AppMethodBeat.i(299800);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 62L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 66L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 67L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 95L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { Integer.valueOf(0), Integer.valueOf(8), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlTaskTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299800);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 63L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 64L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 65L, 1L, false);
      }
    }
  }
  
  public static void lW(long paramLong)
  {
    AppMethodBeat.i(299811);
    if (paramLong <= 10L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 39L, 1L, false);
    }
    for (;;)
    {
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 51L, paramLong, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 52L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 97L, 1L, false);
      if (dIt()) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20176, new Object[] { Integer.valueOf(0), Integer.valueOf(6), Long.valueOf(paramLong), Integer.valueOf(1), "" });
      }
      b.o("EdgeComputingMonitor", "[EdgeComputingMonitor] statInstantTaskTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(1) });
      AppMethodBeat.o(299811);
      return;
      if (paramLong <= 100L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 40L, 1L, false);
      } else if (paramLong <= 1000L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 41L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 42L, 1L, false);
      }
    }
  }
  
  public static void oE(boolean paramBoolean)
  {
    AppMethodBeat.i(299824);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 20L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 55L, 1L, false);
      b.hf("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(299824);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 21L, 1L, false);
    }
  }
  
  public static void oF(boolean paramBoolean)
  {
    AppMethodBeat.i(299832);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 22L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 36L, 1L, false);
      b.hf("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(299832);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 23L, 1L, false);
    }
  }
  
  public static void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(299836);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 24L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 37L, 1L, false);
      b.hf("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(299836);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 25L, 1L, false);
    }
  }
  
  public static void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(299859);
    if (paramBoolean) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 177L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 179L, 1L, false);
      b.hf("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptDownloadSuccess success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(299859);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1409L, 178L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.f.a
 * JD-Core Version:    0.7.0.1
 */
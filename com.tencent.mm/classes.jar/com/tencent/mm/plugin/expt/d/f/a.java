package com.tencent.mm.plugin.expt.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static Boolean syu;
  public static Boolean syv;
  
  public static void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220348);
    if (paramLong <= 10L) {
      h.CyF.idkeyStat(1409L, 8L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(220348);
      return;
      if (paramLong <= 100L)
      {
        h.CyF.idkeyStat(1409L, 9L, 1L, false);
      }
      else if (paramLong <= 1000L)
      {
        h.CyF.idkeyStat(1409L, 10L, 1L, false);
      }
      else
      {
        h.CyF.idkeyStat(1409L, 11L, 1L, false);
        if (syv == null)
        {
          syv = Boolean.valueOf(((b)g.af(b.class)).a(b.a.smE, false));
          Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime sIsMonitorPerformance : " + syv);
        }
        if (syv.booleanValue()) {
          h.CyF.a(20176, new Object[] { paramString, Integer.valueOf(2), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
        }
      }
    }
  }
  
  public static void k(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220347);
    if (syu == null)
    {
      syu = Boolean.valueOf(((b)g.af(b.class)).a(b.a.smD, false));
      Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess sIsMonitorProcess : " + syu);
    }
    if (syu.booleanValue()) {
      h.CyF.a(20177, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(220347);
  }
  
  public static void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(220349);
    if (paramBoolean) {
      h.CyF.idkeyStat(1409L, 20L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(220349);
      return;
      h.CyF.idkeyStat(1409L, 21L, 1L, false);
    }
  }
  
  public static void lU(boolean paramBoolean)
  {
    AppMethodBeat.i(220350);
    if (paramBoolean) {
      h.CyF.idkeyStat(1409L, 22L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(220350);
      return;
      h.CyF.idkeyStat(1409L, 23L, 1L, false);
    }
  }
  
  public static void lV(boolean paramBoolean)
  {
    AppMethodBeat.i(220351);
    if (paramBoolean) {
      h.CyF.idkeyStat(1409L, 24L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(220351);
      return;
      h.CyF.idkeyStat(1409L, 25L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.f.a
 * JD-Core Version:    0.7.0.1
 */
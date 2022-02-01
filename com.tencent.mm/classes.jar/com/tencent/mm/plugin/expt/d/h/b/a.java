package com.tencent.mm.plugin.expt.d.h.b;

import android.os.SystemClock;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements b
{
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if (paramV8Array == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        l = SystemClock.uptimeMillis();
        paramV8Object = b(paramV8Array);
        try
        {
          l = SystemClock.uptimeMillis() - l;
          i = getType();
          if (l <= 10L)
          {
            h.CyF.idkeyStat(1409L, 26L, 1L, false);
            Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime configID : %s, costTime : %d, type : %d", new Object[] { Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(i) });
            return paramV8Object;
          }
          if (l > 100L) {
            continue;
          }
          h.CyF.idkeyStat(1409L, 27L, 1L, false);
          continue;
          Log.e("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke throw Exception e : " + paramV8Array.getMessage());
        }
        catch (Exception paramV8Array) {}
      }
      catch (Exception paramV8Array)
      {
        long l;
        int i;
        paramV8Object = null;
        continue;
      }
      return paramV8Object;
      if (l <= 1000L)
      {
        h.CyF.idkeyStat(1409L, 28L, 1L, false);
      }
      else
      {
        h.CyF.idkeyStat(1409L, 29L, 1L, false);
        if (com.tencent.mm.plugin.expt.d.f.a.syv == null)
        {
          com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smE, false));
          Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
        }
        if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
          h.CyF.a(20176, new Object[] { "", Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b.a
 * JD-Core Version:    0.7.0.1
 */
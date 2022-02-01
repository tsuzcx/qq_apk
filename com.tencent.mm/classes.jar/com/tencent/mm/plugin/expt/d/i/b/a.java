package com.tencent.mm.plugin.expt.d.i.b;

import android.os.SystemClock;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
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
    Object localObject = null;
    paramV8Object = localObject;
    for (;;)
    {
      long l;
      try
      {
        l = SystemClock.uptimeMillis();
        paramV8Object = localObject;
        paramV8Array = b(paramV8Array);
        paramV8Object = paramV8Array;
        l = SystemClock.uptimeMillis() - l;
        paramV8Object = paramV8Array;
        int i = getType();
        if (l <= 10L)
        {
          paramV8Object = paramV8Array;
          h.IzE.idkeyStat(1409L, 26L, 1L, false);
          if (l <= 1000L)
          {
            paramV8Object = paramV8Array;
            h.IzE.idkeyStat(1409L, 53L, l, false);
            paramV8Object = paramV8Array;
            h.IzE.idkeyStat(1409L, 54L, 1L, false);
          }
          paramV8Object = paramV8Array;
          h.IzE.idkeyStat(1409L, 98L, 1L, false);
          paramV8Object = paramV8Array;
          if (com.tencent.mm.plugin.expt.d.g.a.dbP())
          {
            paramV8Object = paramV8Array;
            h.IzE.a(20176, new Object[] { "", Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i) });
          }
          paramV8Object = paramV8Array;
          Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statJsApiCostTime configID : %s, costTime : %d, type : %d", new Object[] { "", Long.valueOf(l), Integer.valueOf(i) });
          paramV8Object = paramV8Array;
          Log.i("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke type : " + getType());
          return paramV8Array;
        }
      }
      catch (Exception paramV8Array)
      {
        Log.e("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke throw Exception e : " + paramV8Array.getMessage());
        return paramV8Object;
      }
      if (l <= 100L)
      {
        paramV8Object = paramV8Array;
        h.IzE.idkeyStat(1409L, 27L, 1L, false);
      }
      else if (l <= 1000L)
      {
        paramV8Object = paramV8Array;
        h.IzE.idkeyStat(1409L, 28L, 1L, false);
      }
      else
      {
        paramV8Object = paramV8Array;
        h.IzE.idkeyStat(1409L, 29L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.b.a
 * JD-Core Version:    0.7.0.1
 */
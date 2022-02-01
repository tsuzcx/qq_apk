package com.tencent.matrix.strategy;

import com.tencent.matrix.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Deprecated
public final class d
  implements a
{
  private static int azB()
  {
    if (MMApplicationContext.isMainProcess()) {
      return 10;
    }
    if (MMApplicationContext.isAppBrandProcess()) {
      return 20;
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsIsolatedProcess())) {
      return 30;
    }
    return -1;
  }
  
  public final void o(Map<String, Boolean> paramMap)
  {
    for (;;)
    {
      String str1;
      boolean bool;
      b localb;
      try
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str1 = (String)localIterator1.next();
          bool = ((Boolean)paramMap.get(str1)).booleanValue();
          Iterator localIterator2 = com.tencent.matrix.c.avW().efL.iterator();
          if (localIterator2.hasNext())
          {
            localb = (b)localIterator2.next();
            if (localb != null) {
              break label109;
            }
            Log.e("Matrix.PluginStatusChangeNotify", "plugin is null");
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramMap)
      {
        Log.printErrStackTrace("Matrix.PluginStatusChangeNotify", paramMap, "", new Object[0]);
      }
      label109:
      if ((!(localb instanceof com.tencent.matrix.a.c)) && (!(localb instanceof com.tencent.matrix.iocanary.a)))
      {
        String str2 = localb.getTag();
        if (str2.equals(str1)) {
          if ((localb.isPluginStarted()) && (!bool))
          {
            Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStop", new Object[] { str2 });
            localb.stop();
            if (((localb instanceof com.tencent.matrix.resource.c)) && (azB() >= 0)) {
              h.OAn.p(1699L, azB(), 1L);
            }
          }
          else if (((localb.isPluginStopped()) || (localb.getStatus() == 1)) && (bool))
          {
            Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStart", new Object[] { str2 });
            localb.start();
            if (((localb instanceof com.tencent.matrix.resource.c)) && (azB() >= 0)) {
              h.OAn.p(1699L, azB() + 1, 1L);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.strategy.d
 * JD-Core Version:    0.7.0.1
 */
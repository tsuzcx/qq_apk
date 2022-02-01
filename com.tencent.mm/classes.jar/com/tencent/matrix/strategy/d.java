package com.tencent.matrix.strategy;

import com.tencent.matrix.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements a
{
  public final void h(Map<String, Boolean> paramMap)
  {
    for (;;)
    {
      String str1;
      boolean bool;
      com.tencent.matrix.d.b localb;
      try
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str1 = (String)localIterator1.next();
          bool = ((Boolean)paramMap.get(str1)).booleanValue();
          Iterator localIterator2 = com.tencent.matrix.b.Vu().coE.iterator();
          if (localIterator2.hasNext())
          {
            localb = (com.tencent.matrix.d.b)localIterator2.next();
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
      if ((!(localb instanceof c)) && (!(localb instanceof com.tencent.matrix.iocanary.a)))
      {
        String str2 = localb.getTag();
        if (str2.equals(str1)) {
          if ((localb.isPluginStarted()) && (!bool))
          {
            Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStop", new Object[] { str2 });
            localb.stop();
          }
          else if (((localb.isPluginStopped()) || (localb.getStatus() == 1)) && (bool))
          {
            Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStart", new Object[] { str2 });
            localb.start();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.strategy.d
 * JD-Core Version:    0.7.0.1
 */
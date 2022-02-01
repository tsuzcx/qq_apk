package com.tencent.matrix.strategy;

import com.tencent.c.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.e;
import com.tencent.matrix.trace.f.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements a
{
  private static MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");
  
  public final void p(Map<String, Boolean> paramMap)
  {
    String str;
    boolean bool;
    Object localObject1;
    label112:
    Object localObject2;
    for (;;)
    {
      try
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          bool = ((Boolean)paramMap.get(str)).booleanValue();
          Iterator localIterator2 = com.tencent.matrix.b.RG().cqP.iterator();
          if (localIterator2.hasNext())
          {
            localObject1 = (com.tencent.matrix.e.b)localIterator2.next();
            if (localObject1 != null) {
              break label112;
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
      if (!(localObject1 instanceof com.tencent.matrix.a.b))
      {
        if ((!((com.tencent.matrix.e.b)localObject1).getTag().equals("Trace")) || (!str.startsWith("Trace"))) {
          break label539;
        }
        localObject1 = (com.tencent.matrix.trace.a)localObject1;
        localObject2 = com.tencent.matrix.trace.a.Tt();
        if ((localObject2 != null) && (((com.tencent.matrix.trace.core.b)localObject2).isInit)) {
          break;
        }
        Log.w("Matrix.PluginStatusChangeNotify", "uiThreadMonitor is never inited!");
      }
    }
    switch (str.hashCode())
    {
    }
    while (localObject1 != null)
    {
      if ((localObject1 instanceof c))
      {
        i = cPL.getInt(a.a.RzK.name(), 0);
        if ((i == 1) || (i == -1))
        {
          Log.i("Matrix.PluginStatusChangeNotify", "FrameTracer has set in MatrixSettingUI value=".concat(String.valueOf(i)));
          break;
          if (!str.equals("Trace_StartUp")) {
            break label637;
          }
          i = 0;
          break label639;
          if (!str.equals("Trace_EvilMethod")) {
            break label637;
          }
          i = 1;
          break label639;
          if (!str.equals("Trace_FPS")) {
            break label637;
          }
          i = 2;
          break label639;
          localObject1 = ((com.tencent.matrix.trace.a)localObject1).daE;
          continue;
          localObject1 = ((com.tencent.matrix.trace.a)localObject1).daD;
          continue;
          localObject1 = ((com.tencent.matrix.trace.a)localObject1).daF;
          continue;
        }
        if (!BuildInfo.DEBUG) {
          break label459;
        }
        Log.i("Matrix.PluginStatusChangeNotify", "FrameTracer ignore change");
        break;
      }
      if ((localObject1 instanceof com.tencent.matrix.trace.f.b))
      {
        i = cPL.getInt(a.a.RzS.name(), 0);
        if ((i != 1) && (i != -1)) {
          break label459;
        }
        Log.i("Matrix.PluginStatusChangeNotify", "EvilMethodTracer has set in MatrixSettingUI value=".concat(String.valueOf(i)));
        break;
      }
      if ((localObject1 instanceof e))
      {
        i = cPL.getInt(a.a.RzU.name(), 0);
        if ((i == 1) || (i == -1))
        {
          Log.i("Matrix.PluginStatusChangeNotify", "StartupTracer has set in MatrixSettingUI value=".concat(String.valueOf(i)));
          break;
        }
      }
      label459:
      if (!bool)
      {
        Log.i("Matrix.PluginStatusChangeNotify", "%s#onCloseTrace", new Object[] { str });
        ((f)localObject1).TH();
        if (!(localObject1 instanceof com.tencent.matrix.trace.f.b)) {
          break;
        }
        com.tencent.matrix.trace.a.Ts().onStop();
        break;
      }
      Log.i("Matrix.PluginStatusChangeNotify", "%s#onStartTrace", new Object[] { str });
      if ((localObject1 instanceof com.tencent.matrix.trace.f.b)) {
        com.tencent.matrix.trace.a.Ts().onStart();
      }
      ((f)localObject1).TG();
      break;
      label539:
      localObject2 = ((com.tencent.matrix.e.b)localObject1).getTag();
      if (!((String)localObject2).equals(str)) {
        break;
      }
      if ((((com.tencent.matrix.e.b)localObject1).isPluginStarted()) && (!bool))
      {
        Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStop", new Object[] { localObject2 });
        ((com.tencent.matrix.e.b)localObject1).stop();
        break;
      }
      if (((!((com.tencent.matrix.e.b)localObject1).isPluginStopped()) && (((com.tencent.matrix.e.b)localObject1).getStatus() != 1)) || (!bool)) {
        break;
      }
      Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStart", new Object[] { localObject2 });
      ((com.tencent.matrix.e.b)localObject1).start();
      break;
      label637:
      int i = -1;
      label639:
      switch (i)
      {
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.strategy.d
 * JD-Core Version:    0.7.0.1
 */
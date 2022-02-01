package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ToolsProfile$a
{
  private static final AtomicInteger cJZ;
  private static Object cKa;
  
  static
  {
    AppMethodBeat.i(19497);
    cJZ = new AtomicInteger(0);
    AppMethodBeat.o(19497);
  }
  
  private static boolean Lb()
  {
    AppMethodBeat.i(19493);
    try
    {
      if (cKa == null)
      {
        Object localObject2 = ai.getContext();
        Object localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if (localObject1 != null) {}
        for (;;)
        {
          cKa = localObject1;
          localObject1 = (ArrayMap)org.a.a.gc(localObject1).aXB("mServices").object;
          int i = ((ArrayMap)localObject1).size();
          if (i > 0) {
            break;
          }
          AppMethodBeat.o(19493);
          return true;
          localObject1 = localObject2.getClass().getField("mLoadedApk");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(localObject2);
          localObject2 = localObject1.getClass().getDeclaredField("mActivityThread");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
        }
        if (((ArrayMap)localObject1).size() == 1)
        {
          boolean bool = localObject1.values().toArray()[0] instanceof BaseIPCService;
          if (bool)
          {
            AppMethodBeat.o(19493);
            return true;
          }
        }
        AppMethodBeat.o(19493);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", new Object[] { localThrowable });
      AppMethodBeat.o(19493);
    }
    return false;
  }
  
  public static boolean isLocked()
  {
    AppMethodBeat.i(19492);
    boolean bool;
    if (cJZ.get() <= 0)
    {
      Object localObject = (ActivityManager)ai.getContext().getSystemService("activity");
      if (localObject == null) {
        break label226;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        break label226;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName.equals(localRunningAppProcessInfo.processName))
          {
            i = localRunningAppProcessInfo.importance;
            if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 100 }, i))
            {
              i = localRunningAppProcessInfo.importance;
              if ((!com.tencent.mm.compatible.loader.a.contains(new int[] { 300, 125 }, i)) || (Lb()))
              {
                i = localRunningAppProcessInfo.importanceReasonCode;
                if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 1, 2 }, i)) {
                  break;
                }
              }
            }
            bool = true;
            ac.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localRunningAppProcessInfo.importance), Integer.valueOf(localRunningAppProcessInfo.importanceReasonCode) });
            if (!bool) {}
          }
        }
      }
    }
    label226:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label231;
      }
      AppMethodBeat.o(19492);
      return true;
      bool = false;
      break;
    }
    label231:
    AppMethodBeat.o(19492);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.a
 * JD-Core Version:    0.7.0.1
 */
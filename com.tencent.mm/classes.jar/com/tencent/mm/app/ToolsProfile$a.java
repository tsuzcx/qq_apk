package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ToolsProfile$a
{
  private static final AtomicInteger hjb;
  private static Object hjc;
  
  static
  {
    AppMethodBeat.i(19497);
    hjb = new AtomicInteger(0);
    AppMethodBeat.o(19497);
  }
  
  public static boolean aDn()
  {
    AppMethodBeat.i(239138);
    if ((hjb.get() > 0) || ((ix("com.tencent.mm:tools")) && (ix("com.tencent.mm:toolsmp"))))
    {
      AppMethodBeat.o(239138);
      return true;
    }
    AppMethodBeat.o(239138);
    return false;
  }
  
  private static boolean aDo()
  {
    AppMethodBeat.i(19493);
    try
    {
      if (hjc == null)
      {
        Object localObject3 = MMApplicationContext.getContext();
        Object localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if (localObject1 != null) {}
        for (;;)
        {
          hjc = localObject1;
          localObject1 = (ArrayMap)org.a.a.jP(localObject1).bLt("mServices").object;
          int i = ((ArrayMap)localObject1).size();
          if (i > 0) {
            break;
          }
          AppMethodBeat.o(19493);
          return true;
          localObject1 = localObject3.getClass().getField("mLoadedApk");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(localObject3);
          localObject3 = localObject1.getClass().getDeclaredField("mActivityThread");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
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
    finally
    {
      Log.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", new Object[] { localObject2 });
      AppMethodBeat.o(19493);
    }
    return false;
  }
  
  public static boolean isLocked()
  {
    AppMethodBeat.i(19492);
    if ((hjb.get() > 0) || (ix(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName)))
    {
      AppMethodBeat.o(19492);
      return true;
    }
    AppMethodBeat.o(19492);
    return false;
  }
  
  private static boolean ix(String paramString)
  {
    AppMethodBeat.i(239142);
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(239142);
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(239142);
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (paramString.equals(localRunningAppProcessInfo.processName))
      {
        int i = localRunningAppProcessInfo.importance;
        if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 100 }, i))
        {
          i = localRunningAppProcessInfo.importance;
          if ((!com.tencent.mm.compatible.loader.a.contains(new int[] { 300, 125 }, i)) || (aDo()))
          {
            i = localRunningAppProcessInfo.importanceReasonCode;
            if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 1, 2 }, i)) {
              break label214;
            }
          }
        }
        label214:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localRunningAppProcessInfo.importance), Integer.valueOf(localRunningAppProcessInfo.importanceReasonCode) });
          if (!bool) {
            break;
          }
          AppMethodBeat.o(239142);
          return true;
        }
      }
    }
    AppMethodBeat.o(239142);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.a
 * JD-Core Version:    0.7.0.1
 */
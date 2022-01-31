package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.ArrayMap;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.b.a;

public final class ToolsProfile$a
{
  private static final AtomicInteger bxl = new AtomicInteger(0);
  private static Object bxm;
  
  public static boolean isLocked()
  {
    boolean bool2 = false;
    boolean bool1;
    if (bxl.get() <= 0)
    {
      Object localObject = (ActivityManager)ae.getContext().getSystemService("activity");
      if (localObject == null) {
        break label183;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        break label183;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (((h)com.tencent.mm.kernel.g.DM().Dr()).dIA.equals(localRunningAppProcessInfo.processName)) {
            if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 300) && (!td())) || (localRunningAppProcessInfo.importanceReasonCode == 1) || (localRunningAppProcessInfo.importanceReasonCode == 2))
            {
              bool1 = true;
              y.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localRunningAppProcessInfo.importance) });
              if (!bool1) {
                break label183;
              }
            }
          }
        }
      }
    }
    label183:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private static boolean td()
  {
    try
    {
      if (bxm == null)
      {
        Object localObject2 = ae.getContext();
        Object localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        if (localObject1 != null) {}
        for (;;)
        {
          bxm = localObject1;
          localObject1 = (ArrayMap)a.cz(localObject1).ahx("mServices").object;
          if (((ArrayMap)localObject1).size() > 0) {
            break;
          }
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
          if (bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      y.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", new Object[] { localThrowable });
    }
    return false;
  }
  
  static void te()
  {
    y.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", new Object[] { Integer.valueOf(bxl.getAndSet(0)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.sdk.processes;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess$Companion;", "", "()V", "TAG", "", "isProcessRunning", "", "context", "Landroid/content/Context;", "process", "processNameOfComponent", "clazz", "Ljava/lang/Class;", "luggage-wechat-full-sdk_release"})
public final class c$a
{
  public static String U(Class<?> paramClass)
  {
    AppMethodBeat.i(244493);
    p.k(paramClass, "clazz");
    for (;;)
    {
      try
      {
        Object localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getPackageManager();
        Object localObject2 = new ComponentName(MMApplicationContext.getContext(), paramClass);
        if (localObject1 != null)
        {
          localObject1 = ((PackageManager)localObject1).getActivityInfo((ComponentName)localObject2, 128);
          if (localObject1 != null)
          {
            localObject2 = ((ActivityInfo)localObject1).processName;
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              AppMethodBeat.o(244493);
              return localObject1;
            }
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        String str = "";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("Luggage.LuggageMiniProgramProcess", "processNameOfComponent: catch cmpClass[" + paramClass + "] " + localNameNotFoundException.getMessage());
        AppMethodBeat.o(244493);
        return null;
      }
    }
  }
  
  static boolean isProcessRunning(Context paramContext, String paramString)
  {
    AppMethodBeat.i(244492);
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        try
        {
          paramContext = paramContext.getSystemService("activity");
          if (paramContext == null)
          {
            paramContext = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(244492);
            throw paramContext;
          }
        }
        catch (Exception paramContext)
        {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "isProcessRunning: ", new Object[] { android.util.Log.getStackTraceString((Throwable)paramContext) });
          AppMethodBeat.o(244492);
          return false;
        }
        paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while ((localRunningAppProcessInfo.processName == null) || (!p.h(localRunningAppProcessInfo.processName, paramString)));
    AppMethodBeat.o(244492);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.c.a
 * JD-Core Version:    0.7.0.1
 */
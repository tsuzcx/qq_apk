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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess$Companion;", "", "()V", "TAG", "", "isProcessRunning", "", "context", "Landroid/content/Context;", "process", "processNameOfComponent", "clazz", "Ljava/lang/Class;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  public static String ad(Class<?> paramClass)
  {
    AppMethodBeat.i(220405);
    s.u(paramClass, "clazz");
    try
    {
      Object localObject = MMApplicationContext.getContext().getPackageManager();
      ComponentName localComponentName = new ComponentName(MMApplicationContext.getContext(), paramClass);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((PackageManager)localObject).getActivityInfo(localComponentName, 128))
      {
        AppMethodBeat.o(220405);
        return "";
      }
      localObject = ((ActivityInfo)localObject).processName;
      if (localObject == null)
      {
        AppMethodBeat.o(220405);
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("Luggage.LuggageMiniProgramProcess", "processNameOfComponent: catch cmpClass[" + paramClass + "] " + localNameNotFoundException.getMessage());
      AppMethodBeat.o(220405);
      return null;
    }
    AppMethodBeat.o(220405);
    return localNameNotFoundException;
  }
  
  static boolean isProcessRunning(Context paramContext, String paramString)
  {
    AppMethodBeat.i(220399);
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
            paramContext = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(220399);
            throw paramContext;
          }
        }
        catch (Exception paramContext)
        {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "isProcessRunning: ", new Object[] { android.util.Log.getStackTraceString((Throwable)paramContext) });
          AppMethodBeat.o(220399);
          return false;
        }
        paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while ((localRunningAppProcessInfo.processName == null) || (!s.p(localRunningAppProcessInfo.processName, paramString)));
    AppMethodBeat.o(220399);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.c.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.cc;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static boolean g(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(152431);
    if (paramContext == null)
    {
      AppMethodBeat.o(152431);
      return false;
    }
    paramContext = jJ(paramContext);
    int i = 0;
    for (;;)
    {
      if (i < 10)
      {
        String str = paramVarArgs[i];
        Integer localInteger = (Integer)paramContext.get(str);
        if (localInteger != null) {
          Log.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[] { localInteger, str });
        }
        try
        {
          com.tencent.mm.hellhoundlib.b.a locala = c.a(localInteger.intValue(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { str, localInteger, localThrowable });
          }
        }
      }
    }
    AppMethodBeat.o(152431);
    return true;
  }
  
  private static Map<String, Integer> jJ(Context paramContext)
  {
    AppMethodBeat.i(152429);
    HashMap localHashMap = new HashMap();
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          localHashMap.put(localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid));
        }
        AppMethodBeat.o(152429);
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static void jK(Context paramContext)
  {
    AppMethodBeat.i(152432);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject1).uid == j) && (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i))
      {
        localObject1 = c.a(((ActivityManager.RunningAppProcessInfo)localObject1).pid, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    paramContext = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramContext.aFh(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(152432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */
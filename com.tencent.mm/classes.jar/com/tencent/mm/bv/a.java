package com.tencent.mm.bv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static boolean bY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(152430);
    int i;
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      i = 0;
    }
    while (i != 0)
    {
      try
      {
        paramContext = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramContext.ahE(), "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(152430);
        return true;
      }
      catch (Throwable paramContext)
      {
        ae.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { paramString, Integer.valueOf(i), paramContext });
        AppMethodBeat.o(152430);
        return false;
      }
      paramContext = (Integer)hM(paramContext).get(paramString);
      if (paramContext != null) {
        i = paramContext.intValue();
      } else {
        i = 0;
      }
    }
    AppMethodBeat.o(152430);
    return false;
  }
  
  public static boolean f(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(152431);
    if (paramContext == null)
    {
      AppMethodBeat.o(152431);
      return false;
    }
    paramContext = hM(paramContext);
    int i = 0;
    for (;;)
    {
      if (i < 10)
      {
        String str = paramVarArgs[i];
        Integer localInteger = (Integer)paramContext.get(str);
        if (localInteger != null) {
          ae.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[] { localInteger, str });
        }
        try
        {
          com.tencent.mm.hellhoundlib.b.a locala = c.a(localInteger.intValue(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { str, localInteger, localThrowable });
          }
        }
      }
    }
    AppMethodBeat.o(152431);
    return true;
  }
  
  private static Map<String, Integer> hM(Context paramContext)
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
        ae.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static void hN(Context paramContext)
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
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    paramContext = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramContext.ahE(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(152432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.a
 * JD-Core Version:    0.7.0.1
 */
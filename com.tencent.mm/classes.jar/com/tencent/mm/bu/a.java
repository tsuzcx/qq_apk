package com.tencent.mm.bu;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static boolean f(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(79961);
    if (paramContext == null)
    {
      AppMethodBeat.o(79961);
      return false;
    }
    paramContext = gd(paramContext);
    int i = 0;
    for (;;)
    {
      if (i < 9)
      {
        String str = paramVarArgs[i];
        Integer localInteger = (Integer)paramContext.get(str);
        if (localInteger != null) {
          ab.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[] { localInteger, str });
        }
        try
        {
          Process.killProcess(localInteger.intValue());
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ab.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { str, localInteger, localThrowable });
          }
        }
      }
    }
    AppMethodBeat.o(79961);
    return true;
  }
  
  private static Map<String, Integer> gd(Context paramContext)
  {
    AppMethodBeat.i(79960);
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
        AppMethodBeat.o(79960);
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static void ge(Context paramContext)
  {
    AppMethodBeat.i(151633);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.uid == j) && (localRunningAppProcessInfo.pid != i)) {
        Process.killProcess(localRunningAppProcessInfo.pid);
      }
    }
    Process.killProcess(i);
    AppMethodBeat.o(151633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bu.a
 * JD-Core Version:    0.7.0.1
 */
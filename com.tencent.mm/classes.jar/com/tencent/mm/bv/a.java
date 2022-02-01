package com.tencent.mm.bv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static boolean bT(Context paramContext, String paramString)
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
        Process.killProcess(i);
        AppMethodBeat.o(152430);
        return true;
      }
      catch (Throwable paramContext)
      {
        ac.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { paramString, Integer.valueOf(i), paramContext });
        AppMethodBeat.o(152430);
        return false;
      }
      paramContext = (Integer)hB(paramContext).get(paramString);
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
    paramContext = hB(paramContext);
    int i = 0;
    for (;;)
    {
      if (i < 10)
      {
        String str = paramVarArgs[i];
        Integer localInteger = (Integer)paramContext.get(str);
        if (localInteger != null) {
          ac.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[] { localInteger, str });
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
            ac.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", new Object[] { str, localInteger, localThrowable });
          }
        }
      }
    }
    AppMethodBeat.o(152431);
    return true;
  }
  
  private static Map<String, Integer> hB(Context paramContext)
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
        ac.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static void hC(Context paramContext)
  {
    AppMethodBeat.i(152432);
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
    AppMethodBeat.o(152432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.a
 * JD-Core Version:    0.7.0.1
 */
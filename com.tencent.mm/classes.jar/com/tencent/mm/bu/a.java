package com.tencent.mm.bu;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static Map<String, Integer> fd(Context paramContext)
  {
    localHashMap = new HashMap();
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          localHashMap.put(localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid));
        }
        return localHashMap;
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bu.a
 * JD-Core Version:    0.7.0.1
 */
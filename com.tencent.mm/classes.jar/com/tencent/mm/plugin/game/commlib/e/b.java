package com.tencent.mm.plugin.game.commlib.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static volatile MMHandler Czq;
  private static final Object rim;
  
  static
  {
    AppMethodBeat.i(89962);
    rim = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static boolean aQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207207);
    try
    {
      paramString = new Intent(paramContext, Class.forName(paramString)).resolveActivity(paramContext.getPackageManager());
      if (paramString != null)
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(10).iterator();
        while (paramContext.hasNext())
        {
          boolean bool = ((ActivityManager.RunningTaskInfo)paramContext.next()).baseActivity.equals(paramString);
          if (bool)
          {
            AppMethodBeat.o(207207);
            return true;
          }
        }
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.e("MicroMsg.GameCommLibUtil", "err: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(207207);
    }
    return false;
  }
  
  public static void clU()
  {
    AppMethodBeat.i(89960);
    if (Czq == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (rim)
    {
      if (Czq != null)
      {
        g.bBw("GameCommLib#WorkThread");
        Czq.quit();
        Czq = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static MMHandler getWorkerHandler()
  {
    AppMethodBeat.i(184541);
    if (Czq == null) {}
    synchronized (rim)
    {
      if (Czq == null)
      {
        Czq = new MMHandler("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new a("GameCommLib#WorkThread"));
      }
      ??? = Czq;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.b
 * JD-Core Version:    0.7.0.1
 */
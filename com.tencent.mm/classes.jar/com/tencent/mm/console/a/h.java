package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cd;
import java.util.Calendar;

public final class h
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20184);
    com.tencent.mm.pluginsdk.cmd.b.a(new h(), new String[] { "//sport" });
    AppMethodBeat.o(20184);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20183);
    if (ae.getLogLevel() > 1)
    {
      AppMethodBeat.o(20183);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20183);
      return true;
    }
    paramContext = paramArrayOfString[1];
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20183);
      return true;
      if (!paramContext.equals("setdevicestep")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("clear")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("setextapistep")) {
        break;
      }
      i = 2;
      break;
      i = Integer.valueOf(paramArrayOfString[2]).intValue();
      bu.fpJ();
      paramContext = Calendar.getInstance();
      paramContext.set(11, 0);
      paramContext.set(12, 0);
      paramContext.set(13, 0);
      long l1 = paramContext.getTimeInMillis();
      long l2 = System.currentTimeMillis();
      ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, cd.fwK());
      continue;
      ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).ejH();
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahE(), "com/tencent/mm/console/command/SportCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/SportCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      paramContext = new gb();
      paramContext.dsE.action = 2;
      paramContext.dsE.dsH = Integer.valueOf(paramArrayOfString[2]).intValue();
      paramContext.dsE.bqh = 1L;
      com.tencent.mm.sdk.b.a.IvT.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.h
 * JD-Core Version:    0.7.0.1
 */
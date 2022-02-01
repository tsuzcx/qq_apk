package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
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
    if (ad.getLogLevel() > 1)
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
      com.tencent.mm.sdk.platformtools.bt.eGJ();
      paramContext = Calendar.getInstance();
      paramContext.set(11, 0);
      paramContext.set(12, 0);
      paramContext.set(13, 0);
      long l1 = paramContext.getTimeInMillis();
      long l2 = System.currentTimeMillis();
      ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, com.tencent.mm.storage.bt.eMY());
      continue;
      ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).dFk();
      Process.killProcess(Process.myPid());
      continue;
      paramContext = new fw();
      paramContext.diH.action = 2;
      paramContext.diH.diK = Integer.valueOf(paramArrayOfString[2]).intValue();
      paramContext.diH.bfb = 1L;
      com.tencent.mm.sdk.b.a.ESL.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.h
 * JD-Core Version:    0.7.0.1
 */
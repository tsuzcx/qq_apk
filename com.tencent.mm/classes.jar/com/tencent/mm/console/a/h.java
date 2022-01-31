package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.util.Calendar;

public final class h
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16139);
    com.tencent.mm.pluginsdk.cmd.b.a(new h(), new String[] { "//sport" });
    AppMethodBeat.o(16139);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16138);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16138);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16138);
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
      AppMethodBeat.o(16138);
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
      if (!paramContext.equals("updatehistorystep")) {
        break;
      }
      i = 3;
      break;
      i = Integer.valueOf(paramArrayOfString[2]).intValue();
      bo.dtU();
      paramContext = Calendar.getInstance();
      paramContext.set(11, 0);
      paramContext.set(12, 0);
      paramContext.set(13, 0);
      long l1 = paramContext.getTimeInMillis();
      long l2 = System.currentTimeMillis();
      ((com.tencent.mm.plugin.sport.a.b)g.E(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, bs.dyO());
      continue;
      ((com.tencent.mm.plugin.sport.a.b)g.E(com.tencent.mm.plugin.sport.a.b.class)).cyv();
      Process.killProcess(Process.myPid());
      continue;
      paramContext = new fq();
      paramContext.ctM.action = 2;
      paramContext.ctM.ctP = Integer.valueOf(paramArrayOfString[2]).intValue();
      paramContext.ctM.aJH = 1L;
      com.tencent.mm.sdk.b.a.ymk.a(paramContext, Looper.getMainLooper());
      continue;
      paramContext = Calendar.getInstance();
      paramContext.add(5, -1);
      paramContext.set(10, 23);
      paramContext.set(12, 59);
      paramContext.set(13, 59);
      l1 = paramContext.getTimeInMillis();
      paramContext.add(5, -120);
      paramContext.set(10, 0);
      paramContext.set(12, 0);
      paramContext.set(13, 0);
      l2 = paramContext.getTimeInMillis();
      ((com.tencent.mm.plugin.sport.a.b)g.E(com.tencent.mm.plugin.sport.a.b.class)).a(l2, l1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.h
 * JD-Core Version:    0.7.0.1
 */
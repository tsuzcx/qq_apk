package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.h.a.fn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import java.util.Calendar;

public final class h
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    com.tencent.mm.pluginsdk.cmd.b.a(new h(), new String[] { "//sport" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
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
      long l1 = bk.crX() / 10000L;
      ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).O(202, l1);
      ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).O(201, i);
      paramContext = Calendar.getInstance();
      paramContext.set(11, 0);
      paramContext.set(12, 0);
      paramContext.set(13, 0);
      l1 = paramContext.getTimeInMillis();
      long l2 = System.currentTimeMillis();
      ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, bs.cwc());
      continue;
      ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).bKZ();
      Process.killProcess(Process.myPid());
      continue;
      paramContext = new fn();
      paramContext.bMr.action = 2;
      paramContext.bMr.bMu = Integer.valueOf(paramArrayOfString[2]).intValue();
      paramContext.bMr.bMv = 1L;
      com.tencent.mm.sdk.b.a.udP.a(paramContext, Looper.getMainLooper());
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
      ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).a(l2, l1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.h
 * JD-Core Version:    0.7.0.1
 */
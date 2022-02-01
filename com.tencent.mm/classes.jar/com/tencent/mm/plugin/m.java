package com.tencent.mm.plugin;

import android.os.Build.VERSION;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.a.e;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.ArrayList;

public final class m
  implements e
{
  public final boolean bUX()
  {
    AppMethodBeat.i(260310);
    if (!BuildInfo.IS_ARM64)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new IDKey(1660, 10, 1));
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 29) && (JeVersion.gzc()))
      {
        localArrayList.add(new IDKey(1660, 12, 1));
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          localArrayList.add(new IDKey(1660, 11, 1));
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, false);
        AppMethodBeat.o(260310);
        return bool;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvr, false))
        {
          long l = AbstractProcessChecker.aAm();
          if (l > 3788800000L)
          {
            localArrayList.add(new IDKey(1660, 13, 1));
            bool = true;
            continue;
          }
          if ((com.tencent.mm.plugin.performance.c.gxW()) && (l > 2764800000L))
          {
            localArrayList.add(new IDKey(1660, 14, 1));
            bool = true;
            continue;
          }
        }
        bool = false;
      }
    }
    AppMethodBeat.o(260310);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m
 * JD-Core Version:    0.7.0.1
 */
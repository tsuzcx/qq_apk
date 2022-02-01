package com.tencent.mm.plugin;

import android.os.Build.VERSION;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.a.e;
import com.tencent.mm.plugin.performance.c;
import com.tencent.mm.plugin.performance.elf.AbstractProcessChecker;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.ArrayList;

public final class f
  implements e
{
  public final boolean bwe()
  {
    AppMethodBeat.i(201958);
    if (!BuildInfo.IS_ARM64)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new IDKey(1660, 10, 1));
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 29) && (JeVersion.foh()))
      {
        localArrayList.add(new IDKey(1660, 12, 1));
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          localArrayList.add(new IDKey(1660, 11, 1));
        }
        com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, false);
        AppMethodBeat.o(201958);
        return bool;
        if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.wbS, false))
        {
          long l = AbstractProcessChecker.Yr();
          if (l > 3788800000L)
          {
            localArrayList.add(new IDKey(1660, 13, 1));
            bool = true;
            continue;
          }
          if ((c.fnj()) && (l > 2764800000L))
          {
            localArrayList.add(new IDKey(1660, 14, 1));
            bool = true;
            continue;
          }
        }
        bool = false;
      }
    }
    AppMethodBeat.o(201958);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f
 * JD-Core Version:    0.7.0.1
 */
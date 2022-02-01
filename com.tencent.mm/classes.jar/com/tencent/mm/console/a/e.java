package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class e
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20178);
    b.a(new e(), new String[] { "//hotpatch" });
    AppMethodBeat.o(20178);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20177);
    if (ac.getLogLevel() > 1)
    {
      AppMethodBeat.o(20177);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20177);
      return true;
    }
    paramString = paramArrayOfString[1];
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(20177);
        return true;
        if (paramString.equals("apply"))
        {
          i = 0;
          continue;
          if (paramString.equals("info"))
          {
            i = 1;
            continue;
            if (paramString.equals("clear"))
            {
              i = 2;
              continue;
              if (paramString.equals("check")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (paramArrayOfString.length < 3) {}
    for (paramArrayOfString = "/data/local/tmp/test.apk";; paramArrayOfString = paramArrayOfString[2])
    {
      ac.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramArrayOfString });
      if (!com.tencent.tinker.lib.e.a.kX(paramContext).Kra) {
        com.tencent.tinker.lib.e.a.kX(paramContext).cTr();
      }
      az.ayM();
      c.agA().set(ah.a.GOb, Long.valueOf(System.currentTimeMillis() - 300000L));
      paramContext = new jw();
      paramContext.dlq.dlv = paramArrayOfString;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      AppMethodBeat.o(20177);
      return true;
    }
    ac.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(20177);
    return true;
    ac.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new jw();
    paramContext.dlq.cZu = 1;
    com.tencent.mm.sdk.b.a.GpY.l(paramContext);
    AppMethodBeat.o(20177);
    return true;
    if (paramArrayOfString.length < 3)
    {
      AppMethodBeat.o(20177);
      return true;
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = paramArrayOfString;
    if (!paramArrayOfString.startsWith("/")) {
      paramContext = "/data/data/com.tencent.mm/app_dex/".concat(String.valueOf(paramArrayOfString));
    }
    ac.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramContext });
    ac.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ac.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ac.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.checkIfMd5Valid(paramContext)) });
    ac.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    AppMethodBeat.o(20177);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.e
 * JD-Core Version:    0.7.0.1
 */
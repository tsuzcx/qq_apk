package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class d
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16131);
    b.a(new d(), new String[] { "//hotpatch" });
    AppMethodBeat.o(16131);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16130);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16130);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16130);
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
        AppMethodBeat.o(16130);
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
      ab.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramArrayOfString });
      if (!com.tencent.tinker.lib.e.a.jo(paramContext).BsU) {
        com.tencent.tinker.lib.e.a.jo(paramContext).bIo();
      }
      aw.aaz();
      c.Ru().set(ac.a.yHs, Long.valueOf(System.currentTimeMillis() - 300000L));
      paramContext = new iq();
      paramContext.cxZ.cye = paramArrayOfString;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      AppMethodBeat.o(16130);
      return true;
    }
    ab.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(16130);
    return true;
    ab.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new iq();
    paramContext.cxZ.coO = 1;
    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    AppMethodBeat.o(16130);
    return true;
    if (paramArrayOfString.length < 3)
    {
      AppMethodBeat.o(16130);
      return true;
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = paramArrayOfString;
    if (!paramArrayOfString.startsWith("/")) {
      paramContext = "/data/data/com.tencent.mm/app_dex/".concat(String.valueOf(paramArrayOfString));
    }
    ab.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramContext });
    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ab.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.axd(paramContext)) });
    ab.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    AppMethodBeat.o(16130);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.a.d
 * JD-Core Version:    0.7.0.1
 */
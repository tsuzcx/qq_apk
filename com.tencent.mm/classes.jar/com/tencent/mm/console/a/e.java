package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
    if (ad.getLogLevel() > 1)
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
      ad.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramArrayOfString });
      if (!com.tencent.tinker.lib.e.a.kI(paramContext).IER) {
        com.tencent.tinker.lib.e.a.kI(paramContext).cGh();
      }
      az.arV();
      c.afk().set(ae.a.Fql, Long.valueOf(System.currentTimeMillis() - 300000L));
      paramContext = new jo();
      paramContext.dnH.dnM = paramArrayOfString;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(20177);
      return true;
    }
    ad.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(20177);
    return true;
    ad.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new jo();
    paramContext.dnH.dbV = 1;
    com.tencent.mm.sdk.b.a.ESL.l(paramContext);
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
    ad.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramContext });
    ad.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ad.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    ad.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.checkIfMd5Valid(paramContext)) });
    ad.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    AppMethodBeat.o(20177);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.e
 * JD-Core Version:    0.7.0.1
 */
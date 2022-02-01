package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mr;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

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
    if (Log.getLogLevel() > 1)
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
      Log.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramArrayOfString });
      if (!com.tencent.tinker.lib.e.a.oy(paramContext).ahRN) {
        com.tencent.tinker.lib.e.a.oy(paramContext).fQd();
      }
      bh.bCz();
      c.ban().set(at.a.acTb, Long.valueOf(System.currentTimeMillis() - 300000L));
      paramContext = new mr();
      paramContext.hON.hOS = paramArrayOfString;
      paramContext.publish();
      AppMethodBeat.o(20177);
      return true;
    }
    Log.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(20177);
    return true;
    Log.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new mr();
    paramContext.hON.hAf = 1;
    paramContext.publish();
    AppMethodBeat.o(20177);
    return true;
    if (paramArrayOfString.length < 3)
    {
      AppMethodBeat.o(20177);
      return true;
    }
    paramString = paramArrayOfString[2];
    paramArrayOfString = paramString;
    if (!paramString.startsWith("/")) {
      paramArrayOfString = paramContext.getCacheDir().getParent() + "/app_dex/" + paramString;
    }
    Log.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramArrayOfString });
    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    Log.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.checkIfMd5Valid(paramArrayOfString)) });
    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    AppMethodBeat.o(20177);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.e
 * JD-Core Version:    0.7.0.1
 */
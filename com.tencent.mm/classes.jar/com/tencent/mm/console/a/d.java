package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.h.a.ij;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class d
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    b.a(new d(), new String[] { "//hotpatch" });
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
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
        if (paramContext.equals("apply"))
        {
          i = 0;
          continue;
          if (paramContext.equals("info"))
          {
            i = 1;
            continue;
            if (paramContext.equals("clear"))
            {
              i = 2;
              continue;
              if (paramContext.equals("check")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (paramArrayOfString.length < 3) {}
    for (paramContext = "/data/local/tmp/test.apk";; paramContext = paramArrayOfString[2])
    {
      y.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramContext });
      paramArrayOfString = new ij();
      paramArrayOfString.bQz.bQE = paramContext;
      com.tencent.mm.sdk.b.a.udP.m(paramArrayOfString);
      return true;
    }
    y.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    return true;
    y.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new ij();
    paramContext.bQz.bHz = 1;
    com.tencent.mm.sdk.b.a.udP.m(paramContext);
    return true;
    if (paramArrayOfString.length < 3) {
      return true;
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = paramArrayOfString;
    if (!paramArrayOfString.startsWith("/")) {
      paramContext = "/data/data/com.tencent.mm/app_dex/" + paramArrayOfString;
    }
    y.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramContext });
    y.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    y.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    y.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.agm(paramContext)) });
    y.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.a.d
 * JD-Core Version:    0.7.0.1
 */
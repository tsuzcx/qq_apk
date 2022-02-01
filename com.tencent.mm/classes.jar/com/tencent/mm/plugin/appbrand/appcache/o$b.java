package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class o$b
{
  static void Vb(String paramString)
  {
    AppMethodBeat.i(44240);
    y.deleteFile(paramString);
    try
    {
      Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
      AppMethodBeat.o(44240);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
      AppMethodBeat.o(44240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.o.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class n$a
{
  static void yo(String paramString)
  {
    AppMethodBeat.i(129335);
    e.deleteFile(paramString);
    try
    {
      Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
      AppMethodBeat.o(129335);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
      AppMethodBeat.o(129335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n.a
 * JD-Core Version:    0.7.0.1
 */
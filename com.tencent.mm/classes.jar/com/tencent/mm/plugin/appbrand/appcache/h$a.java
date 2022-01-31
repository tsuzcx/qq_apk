package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.y;

public final class h$a
{
  static void qS(String paramString)
  {
    e.deleteFile(paramString);
    try
    {
      Runtime.getRuntime().exec("rm -r " + paramString + "_xdir");
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", new Object[] { paramString + "_xdir", localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, at.a parama)
  {
    return at.a(new af(paramString1, paramInt1, paramInt2, paramString2, parama), parama);
  }
  
  static int x(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = WABSPatch.bspatch(paramString1, paramString2, paramString3);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { localException, paramString1, paramString2, paramString3 });
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */
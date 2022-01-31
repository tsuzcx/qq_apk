package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;

public final class aj
{
  final aj.b fDH = new aj.b(this);
  
  public static String abZ()
  {
    String str2 = g.DP().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    h.Vu(str1);
    return str1;
  }
  
  public final int b(a parama)
  {
    if (this.fDH.Wj(parama.rVT))
    {
      y.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.rVT });
      return 0;
    }
    int i = this.fDH.b(parama);
    y.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.rVT, Integer.valueOf(i) });
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */
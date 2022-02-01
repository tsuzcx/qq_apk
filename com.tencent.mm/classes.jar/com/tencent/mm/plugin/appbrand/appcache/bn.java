package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.k;

public final class bn
{
  private static a jJu = null;
  
  static q a(AppBrandRuntime paramAppBrandRuntime, bf parambf)
  {
    AppMethodBeat.i(178571);
    if (jJu != null)
    {
      parambf = jJu.a(paramAppBrandRuntime, parambf);
      if (parambf != null)
      {
        AppMethodBeat.o(178571);
        return parambf;
      }
    }
    paramAppBrandRuntime = new y(paramAppBrandRuntime.mAppId, paramAppBrandRuntime.Fh().jYh);
    AppMethodBeat.o(178571);
    return paramAppBrandRuntime;
  }
  
  public static void a(a parama)
  {
    jJu = parama;
  }
  
  public static abstract interface a
  {
    public abstract q a(AppBrandRuntime paramAppBrandRuntime, bf parambf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.k;

public final class bm
{
  private static a jpA = null;
  
  static q a(AppBrandRuntime paramAppBrandRuntime, be parambe)
  {
    AppMethodBeat.i(178571);
    if (jpA != null)
    {
      parambe = jpA.a(paramAppBrandRuntime, parambe);
      if (parambe != null)
      {
        AppMethodBeat.o(178571);
        return parambe;
      }
    }
    paramAppBrandRuntime = new x(paramAppBrandRuntime.mAppId, paramAppBrandRuntime.DI().jEg);
    AppMethodBeat.o(178571);
    return paramAppBrandRuntime;
  }
  
  public static void a(a parama)
  {
    jpA = parama;
  }
  
  public static abstract interface a
  {
    public abstract q a(AppBrandRuntime paramAppBrandRuntime, be parambe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm
 * JD-Core Version:    0.7.0.1
 */
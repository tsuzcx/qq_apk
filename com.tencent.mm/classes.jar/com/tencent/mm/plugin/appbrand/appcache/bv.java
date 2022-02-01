package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.l;

public final class bv
{
  private static a nIA = null;
  
  static q a(AppBrandRuntime paramAppBrandRuntime, bl parambl)
  {
    AppMethodBeat.i(178571);
    if (nIA != null)
    {
      parambl = nIA.a(paramAppBrandRuntime, parambl);
      if (parambl != null)
      {
        AppMethodBeat.o(178571);
        return parambl;
      }
    }
    paramAppBrandRuntime = new aa(paramAppBrandRuntime.mAppId, paramAppBrandRuntime.Sp().nYR);
    AppMethodBeat.o(178571);
    return paramAppBrandRuntime;
  }
  
  public static void a(a parama)
  {
    nIA = parama;
  }
  
  public static abstract interface a
  {
    public abstract q a(AppBrandRuntime paramAppBrandRuntime, bl parambl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bv
 * JD-Core Version:    0.7.0.1
 */
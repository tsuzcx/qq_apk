package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.l;

public final class bo
{
  private static a kOz = null;
  
  static q a(AppBrandRuntime paramAppBrandRuntime, bg parambg)
  {
    AppMethodBeat.i(178571);
    if (kOz != null)
    {
      parambg = kOz.a(paramAppBrandRuntime, parambg);
      if (parambg != null)
      {
        AppMethodBeat.o(178571);
        return parambg;
      }
    }
    paramAppBrandRuntime = new z(paramAppBrandRuntime.mAppId, paramAppBrandRuntime.OT().leE);
    AppMethodBeat.o(178571);
    return paramAppBrandRuntime;
  }
  
  public static void a(a parama)
  {
    kOz = parama;
  }
  
  public static abstract interface a
  {
    public abstract q a(AppBrandRuntime paramAppBrandRuntime, bg parambg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bo
 * JD-Core Version:    0.7.0.1
 */
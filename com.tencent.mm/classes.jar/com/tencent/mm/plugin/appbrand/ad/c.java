package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;

public final class c
  implements g
{
  public static final c jiE;
  
  static
  {
    AppMethodBeat.i(44024);
    jiE = new c();
    AppMethodBeat.o(44024);
  }
  
  public final boolean HB(String paramString)
  {
    AppMethodBeat.i(44021);
    boolean bool = d.HB(paramString);
    AppMethodBeat.o(44021);
    return bool;
  }
  
  public final int M(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(163910);
    if (((paramAppBrandRuntime instanceof o)) && (paramAppBrandRuntime.DJ() != null))
    {
      int i = a.rn(((o)paramAppBrandRuntime).aTS().jDK);
      AppMethodBeat.o(163910);
      return i;
    }
    AppMethodBeat.o(163910);
    return 140;
  }
  
  public final boolean N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(162160);
    boolean bool = d.N(paramAppBrandRuntime);
    AppMethodBeat.o(162160);
    return bool;
  }
  
  public final boolean O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44022);
    boolean bool = d.O(paramAppBrandRuntime);
    AppMethodBeat.o(44022);
    return bool;
  }
  
  public final boolean P(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44023);
    boolean bool = d.P(paramAppBrandRuntime);
    AppMethodBeat.o(44023);
    return bool;
  }
  
  public final p aUO()
  {
    AppMethodBeat.i(174692);
    p localp = d.aUO();
    AppMethodBeat.o(174692);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.c
 * JD-Core Version:    0.7.0.1
 */
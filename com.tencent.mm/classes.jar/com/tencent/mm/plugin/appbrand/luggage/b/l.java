package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  implements b
{
  private final List<b> lSF;
  
  public l(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207767);
    this.lSF = new LinkedList();
    this.lSF.add(new p(paramAppBrandRuntime));
    this.lSF.add(new i());
    this.lSF.add(new j(paramAppBrandRuntime));
    this.lSF.add(new h(paramAppBrandRuntime));
    AppMethodBeat.o(207767);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(207768);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(207768);
      return false;
    }
    Iterator localIterator = this.lSF.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString))
      {
        AppMethodBeat.o(207768);
        return true;
      }
    }
    AppMethodBeat.o(207768);
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(207769);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(207769);
      return paramString;
    }
    Iterator localIterator = this.lSF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramc, paramString))
      {
        paramc = localb.b(paramc, paramString);
        AppMethodBeat.o(207769);
        return paramc;
      }
    }
    AppMethodBeat.o(207769);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */
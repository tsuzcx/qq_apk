package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements b
{
  private final List<b> kPh;
  
  public k(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(194472);
    this.kPh = new LinkedList();
    this.kPh.add(new o(paramAppBrandRuntime));
    this.kPh.add(new h());
    this.kPh.add(new i(paramAppBrandRuntime));
    AppMethodBeat.o(194472);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(194473);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(194473);
      return false;
    }
    Iterator localIterator = this.kPh.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString))
      {
        AppMethodBeat.o(194473);
        return true;
      }
    }
    AppMethodBeat.o(194473);
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(194474);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(194474);
      return paramString;
    }
    Iterator localIterator = this.kPh.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramc, paramString))
      {
        paramc = localb.b(paramc, paramString);
        AppMethodBeat.o(194474);
        return paramc;
      }
    }
    AppMethodBeat.o(194474);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */
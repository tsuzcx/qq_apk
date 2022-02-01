package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  implements b
{
  private final List<b> naf;
  
  public l(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219341);
    this.naf = new LinkedList();
    this.naf.add(new p(paramAppBrandRuntime));
    this.naf.add(new i());
    this.naf.add(new j(paramAppBrandRuntime));
    this.naf.add(new h(paramAppBrandRuntime));
    AppMethodBeat.o(219341);
  }
  
  public final boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(219342);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(219342);
      return false;
    }
    Iterator localIterator = this.naf.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramf, paramString))
      {
        AppMethodBeat.o(219342);
        return true;
      }
    }
    AppMethodBeat.o(219342);
    return false;
  }
  
  public final String b(f paramf, String paramString)
  {
    AppMethodBeat.i(219343);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(219343);
      return paramString;
    }
    Iterator localIterator = this.naf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramf, paramString))
      {
        paramf = localb.b(paramf, paramString);
        AppMethodBeat.o(219343);
        return paramf;
      }
    }
    AppMethodBeat.o(219343);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */
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
  private final List<b> lqG;
  
  public k(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193388);
    this.lqG = new LinkedList();
    this.lqG.add(new o(paramAppBrandRuntime));
    this.lqG.add(new h());
    this.lqG.add(new i(paramAppBrandRuntime));
    AppMethodBeat.o(193388);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(193389);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(193389);
      return false;
    }
    Iterator localIterator = this.lqG.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString))
      {
        AppMethodBeat.o(193389);
        return true;
      }
    }
    AppMethodBeat.o(193389);
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(193390);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(193390);
      return paramString;
    }
    Iterator localIterator = this.lqG.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramc, paramString))
      {
        paramc = localb.b(paramc, paramString);
        AppMethodBeat.o(193390);
        return paramc;
      }
    }
    AppMethodBeat.o(193390);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */
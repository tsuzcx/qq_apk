package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements b
{
  private final List<b> lOe;
  
  public k(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197281);
    this.lOe = new LinkedList();
    this.lOe.add(new o(paramAppBrandRuntime));
    this.lOe.add(new h());
    this.lOe.add(new i(paramAppBrandRuntime));
    AppMethodBeat.o(197281);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(197282);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(197282);
      return false;
    }
    Iterator localIterator = this.lOe.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString))
      {
        AppMethodBeat.o(197282);
        return true;
      }
    }
    AppMethodBeat.o(197282);
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(197283);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(197283);
      return paramString;
    }
    Iterator localIterator = this.lOe.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramc, paramString))
      {
        paramc = localb.b(paramc, paramString);
        AppMethodBeat.o(197283);
        return paramc;
      }
    }
    AppMethodBeat.o(197283);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */
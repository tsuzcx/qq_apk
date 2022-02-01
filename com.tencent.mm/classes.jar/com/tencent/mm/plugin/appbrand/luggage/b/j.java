package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements b
{
  private final List<b> tfz;
  
  public j(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(319875);
    this.tfz = new LinkedList();
    this.tfz.add(new n(paramAppBrandRuntime));
    this.tfz.add(new g());
    this.tfz.add(new h(paramAppBrandRuntime));
    this.tfz.add(new f(paramAppBrandRuntime));
    AppMethodBeat.o(319875);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(319882);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(319882);
      return false;
    }
    Iterator localIterator = this.tfz.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramf, paramString))
      {
        AppMethodBeat.o(319882);
        return true;
      }
    }
    AppMethodBeat.o(319882);
    return false;
  }
  
  public final String b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(319888);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(319888);
      return paramString;
    }
    Iterator localIterator = this.tfz.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramf, paramString))
      {
        paramf = localb.b(paramf, paramString);
        AppMethodBeat.o(319888);
        return paramf;
      }
    }
    AppMethodBeat.o(319888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */
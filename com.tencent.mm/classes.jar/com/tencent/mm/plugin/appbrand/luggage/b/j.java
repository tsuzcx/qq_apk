package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements b
{
  private final List<b> qau;
  
  public j(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244151);
    this.qau = new LinkedList();
    this.qau.add(new n(paramAppBrandRuntime));
    this.qau.add(new g());
    this.qau.add(new h(paramAppBrandRuntime));
    this.qau.add(new f(paramAppBrandRuntime));
    AppMethodBeat.o(244151);
  }
  
  public final boolean a(e parame, String paramString)
  {
    AppMethodBeat.i(244152);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(244152);
      return false;
    }
    Iterator localIterator = this.qau.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(parame, paramString))
      {
        AppMethodBeat.o(244152);
        return true;
      }
    }
    AppMethodBeat.o(244152);
    return false;
  }
  
  public final String b(e parame, String paramString)
  {
    AppMethodBeat.i(244153);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(244153);
      return paramString;
    }
    Iterator localIterator = this.qau.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(parame, paramString))
      {
        parame = localb.b(parame, paramString);
        AppMethodBeat.o(244153);
        return parame;
      }
    }
    AppMethodBeat.o(244153);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */
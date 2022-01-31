package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.a.b;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements a.a
{
  d$1(d paramd) {}
  
  public final <T extends b> void a(Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(91010);
    if (paramT == null)
    {
      com.tencent.luggage.g.d.w("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", new Object[] { paramClass, paramT });
      AppMethodBeat.o(91010);
      return;
    }
    this.hwL.hwK.b(paramClass, paramT);
    AppMethodBeat.o(91010);
  }
  
  public final <T extends com.tencent.luggage.a.d> void a(Class<T> paramClass, T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */
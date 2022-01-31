package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;

final class z
  implements f
{
  public final e d(c paramc)
  {
    AppMethodBeat.i(86790);
    if ((paramc instanceof e))
    {
      paramc = (e)paramc;
      AppMethodBeat.o(86790);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      paramc = ((r)paramc).getCurrentPageView();
      AppMethodBeat.o(86790);
      return paramc;
    }
    AppMethodBeat.o(86790);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements e
{
  public final int[] p(c paramc)
  {
    AppMethodBeat.i(220587);
    if (paramc == null)
    {
      paramc = new int[2];
      AppMethodBeat.o(220587);
      return paramc;
    }
    if ((paramc instanceof h))
    {
      paramc = ai.f((h)paramc);
      AppMethodBeat.o(220587);
      return paramc;
    }
    paramc = d.ck(paramc.getContext());
    int i = paramc.x;
    int j = paramc.y;
    AppMethodBeat.o(220587);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.b
 * JD-Core Version:    0.7.0.1
 */
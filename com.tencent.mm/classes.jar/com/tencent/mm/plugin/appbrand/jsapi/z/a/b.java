package com.tencent.mm.plugin.appbrand.jsapi.z.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements e
{
  public final int[] p(c paramc)
  {
    AppMethodBeat.i(206712);
    if (paramc == null)
    {
      paramc = new int[2];
      AppMethodBeat.o(206712);
      return paramc;
    }
    if ((paramc instanceof h))
    {
      paramc = ad.g((h)paramc);
      AppMethodBeat.o(206712);
      return paramc;
    }
    paramc = d.cl(paramc.getContext());
    int i = paramc.x;
    int j = paramc.y;
    AppMethodBeat.o(206712);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.b
 * JD-Core Version:    0.7.0.1
 */
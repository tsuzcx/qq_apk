package com.tencent.mm.plugin.appbrand.jsapi.aa.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements e
{
  public final int[] p(c paramc)
  {
    AppMethodBeat.i(195072);
    if (paramc == null)
    {
      paramc = new int[2];
      AppMethodBeat.o(195072);
      return paramc;
    }
    if ((paramc instanceof h))
    {
      paramc = ac.g((h)paramc);
      AppMethodBeat.o(195072);
      return paramc;
    }
    paramc = d.cf(paramc.getContext());
    int i = paramc.x;
    int j = paramc.y;
    AppMethodBeat.o(195072);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.b
 * JD-Core Version:    0.7.0.1
 */
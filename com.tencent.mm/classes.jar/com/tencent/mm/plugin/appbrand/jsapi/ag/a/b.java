package com.tencent.mm.plugin.appbrand.jsapi.ag.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements e
{
  public final int[] p(f paramf)
  {
    AppMethodBeat.i(215801);
    if (paramf == null)
    {
      paramf = new int[2];
      AppMethodBeat.o(215801);
      return paramf;
    }
    if ((paramf instanceof k))
    {
      paramf = ai.f((k)paramf);
      AppMethodBeat.o(215801);
      return paramf;
    }
    paramf = d.az(paramf.getContext());
    int i = paramf.x;
    int j = paramf.y;
    AppMethodBeat.o(215801);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a.b
 * JD-Core Version:    0.7.0.1
 */
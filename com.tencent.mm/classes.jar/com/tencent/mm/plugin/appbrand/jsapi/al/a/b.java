package com.tencent.mm.plugin.appbrand.jsapi.al.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements e
{
  public final int[] t(f paramf)
  {
    AppMethodBeat.i(326992);
    if (paramf == null)
    {
      paramf = new int[2];
      AppMethodBeat.o(326992);
      return paramf;
    }
    if ((paramf instanceof k))
    {
      paramf = aq.d((k)paramf);
      AppMethodBeat.o(326992);
      return paramf;
    }
    paramf = d.bf(paramf.getContext());
    if (paramf == null)
    {
      paramf = new int[2];
      AppMethodBeat.o(326992);
      return paramf;
    }
    int i = paramf.x;
    int j = paramf.y;
    AppMethodBeat.o(326992);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a.b
 * JD-Core Version:    0.7.0.1
 */
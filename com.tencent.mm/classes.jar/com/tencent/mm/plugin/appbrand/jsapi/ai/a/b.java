package com.tencent.mm.plugin.appbrand.jsapi.ai.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.ui.statusbar.d;

public final class b
  implements com.tencent.mm.plugin.appbrand.jsapi.camera.e
{
  public final int[] r(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(226132);
    if (parame == null)
    {
      parame = new int[2];
      AppMethodBeat.o(226132);
      return parame;
    }
    if ((parame instanceof j))
    {
      parame = ak.f((j)parame);
      AppMethodBeat.o(226132);
      return parame;
    }
    parame = d.au(parame.getContext());
    int i = parame.x;
    int j = parame.y;
    AppMethodBeat.o(226132);
    return new int[] { i, j };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.b
 * JD-Core Version:    0.7.0.1
 */
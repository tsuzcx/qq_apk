package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a.i;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;

final class c$1
  implements IXWebLibraryLoader
{
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(154463);
    d.i("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramString });
    try
    {
      k.a(paramString, i.class.getClassLoader());
      AppMethodBeat.o(154463);
      return true;
    }
    catch (Exception localException)
    {
      d.e("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramString, localException });
      AppMethodBeat.o(154463);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.c.1
 * JD-Core Version:    0.7.0.1
 */
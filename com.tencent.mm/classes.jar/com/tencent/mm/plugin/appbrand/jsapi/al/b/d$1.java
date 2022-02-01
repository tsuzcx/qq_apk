package com.tencent.mm.plugin.appbrand.jsapi.al.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;

final class d$1
  implements IXWebLibraryLoader
{
  public final boolean afterLoad()
  {
    AppMethodBeat.i(139446);
    h.class.getClassLoader();
    k.DA("skia-canvas-log-bridge");
    AppMethodBeat.o(139446);
    return true;
  }
  
  public final boolean beforeLoad()
  {
    return false;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(139445);
    Log.i("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramString });
    try
    {
      h.class.getClassLoader();
      k.DA(paramString);
      AppMethodBeat.o(139445);
      return true;
    }
    finally
    {
      Log.e("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(139445);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.d.1
 * JD-Core Version:    0.7.0.1
 */
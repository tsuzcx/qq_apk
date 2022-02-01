package com.tencent.mm.plugin.appbrand.jsapi.aa.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import java.util.HashMap;

public final class c
  extends ar
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c kzt;
  
  static
  {
    AppMethodBeat.i(139463);
    kzt = new c();
    AppMethodBeat.o(139463);
  }
  
  public static void e(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    try
    {
      AppMethodBeat.i(139462);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      kzt.C(localHashMap);
      paramc.b(kzt);
      AppMethodBeat.o(139462);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.c
 * JD-Core Version:    0.7.0.1
 */
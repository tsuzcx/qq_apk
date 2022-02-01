package com.tencent.mm.plugin.appbrand.jsapi.ad.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import java.util.HashMap;

public final class c
  extends at
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c lCi;
  
  static
  {
    AppMethodBeat.i(139463);
    lCi = new c();
    AppMethodBeat.o(139463);
  }
  
  public static void e(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    try
    {
      AppMethodBeat.i(139462);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      lCi.I(localHashMap);
      paramc.b(lCi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.c
 * JD-Core Version:    0.7.0.1
 */
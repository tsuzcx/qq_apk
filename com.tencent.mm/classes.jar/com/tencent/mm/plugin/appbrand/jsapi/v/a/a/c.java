package com.tencent.mm.plugin.appbrand.jsapi.v.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import java.util.HashMap;

public final class c
  extends ai
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c iiu;
  
  static
  {
    AppMethodBeat.i(154467);
    iiu = new c();
    AppMethodBeat.o(154467);
  }
  
  public static void d(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    try
    {
      AppMethodBeat.i(154466);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      iiu.x(localHashMap);
      paramc.b(iiu);
      AppMethodBeat.o(154466);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a.c
 * JD-Core Version:    0.7.0.1
 */
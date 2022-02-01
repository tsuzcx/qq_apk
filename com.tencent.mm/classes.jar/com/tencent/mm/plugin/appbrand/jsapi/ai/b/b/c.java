package com.tencent.mm.plugin.appbrand.jsapi.ai.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;

public final class c
  extends az
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c pKy;
  
  static
  {
    AppMethodBeat.i(139463);
    pKy = new c();
    AppMethodBeat.o(139463);
  }
  
  public static void e(e parame, int paramInt)
  {
    try
    {
      AppMethodBeat.i(139462);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      pKy.E(localHashMap);
      parame.a(pKy, null);
      AppMethodBeat.o(139462);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.c
 * JD-Core Version:    0.7.0.1
 */
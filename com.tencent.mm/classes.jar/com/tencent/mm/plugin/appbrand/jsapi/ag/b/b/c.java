package com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;

public final class c
  extends bc
{
  private static final int CTRL_INDEX = 675;
  private static final String NAME = "onXWebCanvasSurfaceChange";
  private static final c mJG;
  
  static
  {
    AppMethodBeat.i(139463);
    mJG = new c();
    AppMethodBeat.o(139463);
  }
  
  public static void e(f paramf, int paramInt)
  {
    try
    {
      AppMethodBeat.i(139462);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("viewId", Integer.valueOf(paramInt));
      mJG.L(localHashMap);
      paramf.a(mJG, null);
      AppMethodBeat.o(139462);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Map;

public final class d
  extends ai
{
  private static final int CTRL_INDEX = 296;
  public static final String NAME = "onRecorderStateChange";
  private static final d ifx;
  
  static
  {
    AppMethodBeat.i(145940);
    ifx = new d();
    AppMethodBeat.o(145940);
  }
  
  public static void a(c paramc, Map<String, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(145939);
      ifx.j(paramc).x(paramMap).aBz();
      AppMethodBeat.o(145939);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.d
 * JD-Core Version:    0.7.0.1
 */
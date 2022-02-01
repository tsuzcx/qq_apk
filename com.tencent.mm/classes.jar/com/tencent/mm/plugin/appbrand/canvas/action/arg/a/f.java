package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import java.util.Map;

public final class f
  extends a<BasePathActionArg>
{
  private static f laf;
  
  static
  {
    AppMethodBeat.i(145325);
    laf = new f();
    AppMethodBeat.o(145325);
  }
  
  public static f bzq()
  {
    return laf;
  }
  
  public final <T> T WE(String paramString)
  {
    AppMethodBeat.i(145324);
    paramString = ((com.tencent.mm.plugin.appbrand.canvas.b.a)e.a.law.lav.get(paramString)).bzv();
    AppMethodBeat.o(145324);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f
 * JD-Core Version:    0.7.0.1
 */
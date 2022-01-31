package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import java.util.Map;

public final class f
  extends a<BasePathActionArg>
{
  private static f hfy;
  
  static
  {
    AppMethodBeat.i(103642);
    hfy = new f();
    AppMethodBeat.o(103642);
  }
  
  public static f ayd()
  {
    return hfy;
  }
  
  public final <T> T zC(String paramString)
  {
    AppMethodBeat.i(103641);
    paramString = ((com.tencent.mm.plugin.appbrand.canvas.b.a)e.a.hfO.hfN.get(paramString)).ayi();
    AppMethodBeat.o(103641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f
 * JD-Core Version:    0.7.0.1
 */
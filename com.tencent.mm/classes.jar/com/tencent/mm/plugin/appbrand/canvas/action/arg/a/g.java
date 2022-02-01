package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg;

public final class g
  extends a<BaseDrawActionArg>
{
  private static g qUa;
  
  static
  {
    AppMethodBeat.i(145327);
    qUa = new g();
    AppMethodBeat.o(145327);
  }
  
  public static g ckg()
  {
    return qUa;
  }
  
  public final <T> T WS(String paramString)
  {
    AppMethodBeat.i(145326);
    Object localObject = null;
    if ("linear".equalsIgnoreCase(paramString)) {
      localObject = new RealSetFillStyleActionLinearArg();
    }
    for (;;)
    {
      ((BaseDrawActionArg)localObject).method = paramString;
      AppMethodBeat.o(145326);
      return localObject;
      if ("radial".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionRadialArg();
      } else if ("normal".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionNormalArg();
      } else if ("pattern".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionPatternArg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g
 * JD-Core Version:    0.7.0.1
 */
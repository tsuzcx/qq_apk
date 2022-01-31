package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg;

public final class h
  extends a<BaseDrawActionArg>
{
  private static h hfA;
  
  static
  {
    AppMethodBeat.i(103646);
    hfA = new h();
    AppMethodBeat.o(103646);
  }
  
  public static h ayf()
  {
    return hfA;
  }
  
  public final <T> T zC(String paramString)
  {
    AppMethodBeat.i(103645);
    Object localObject = null;
    if ("linear".equalsIgnoreCase(paramString)) {
      localObject = new RealSetStrokeStyleActionLinearArg();
    }
    for (;;)
    {
      ((BaseDrawActionArg)localObject).method = paramString;
      AppMethodBeat.o(103645);
      return localObject;
      if ("radial".equalsIgnoreCase(paramString)) {
        localObject = new RealSetStrokeStyleActionRadialArg();
      } else if ("normal".equalsIgnoreCase(paramString)) {
        localObject = new RealSetStrokeStyleActionNormalArg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h
 * JD-Core Version:    0.7.0.1
 */
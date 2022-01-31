package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.d;
import java.util.Map;

public final class c
  extends a<BaseDrawActionArg>
{
  private static com.tencent.mm.plugin.appbrand.canvas.c hfs;
  private static c hft;
  
  static
  {
    AppMethodBeat.i(103635);
    hfs = new com.tencent.mm.plugin.appbrand.canvas.c();
    hft = new c();
    AppMethodBeat.o(103635);
  }
  
  public static c aya()
  {
    return hft;
  }
  
  public final <T> T zC(String paramString)
  {
    AppMethodBeat.i(103634);
    paramString = (d)hfs.heA.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(103634);
      return null;
    }
    paramString = paramString.axW();
    AppMethodBeat.o(103634);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c
 * JD-Core Version:    0.7.0.1
 */
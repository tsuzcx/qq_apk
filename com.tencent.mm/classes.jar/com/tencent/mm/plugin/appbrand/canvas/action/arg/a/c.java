package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.d;
import java.util.Map;

public final class c
  extends a<BaseDrawActionArg>
{
  private static com.tencent.mm.plugin.appbrand.canvas.c nUj;
  private static c nUk;
  
  static
  {
    AppMethodBeat.i(145318);
    nUj = new com.tencent.mm.plugin.appbrand.canvas.c();
    nUk = new c();
    AppMethodBeat.o(145318);
  }
  
  public static c bKC()
  {
    return nUk;
  }
  
  public final <T> T aep(String paramString)
  {
    AppMethodBeat.i(145317);
    paramString = (d)nUj.nTv.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(145317);
      return null;
    }
    paramString = paramString.bKy();
    AppMethodBeat.o(145317);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c
 * JD-Core Version:    0.7.0.1
 */
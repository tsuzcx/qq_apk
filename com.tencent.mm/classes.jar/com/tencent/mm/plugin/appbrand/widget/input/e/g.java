package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(136699);
    rAK = new g("LEFT", 0);
    rAL = new g("RIGHT", 1);
    rAM = new g("CENTER", 2);
    rAN = new g[] { rAK, rAL, rAM };
    AppMethodBeat.o(136699);
  }
  
  private g() {}
  
  public static g anF(String paramString)
  {
    AppMethodBeat.i(136698);
    paramString = d.h(paramString, g.class);
    g localg = rAK;
    if (paramString == null) {
      paramString = localg;
    }
    for (;;)
    {
      paramString = (g)paramString;
      AppMethodBeat.o(136698);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(136699);
    mgZ = new g("LEFT", 0);
    mha = new g("RIGHT", 1);
    mhb = new g("CENTER", 2);
    mhc = new g[] { mgZ, mha, mhb };
    AppMethodBeat.o(136699);
  }
  
  private g() {}
  
  public static g NO(String paramString)
  {
    AppMethodBeat.i(136698);
    paramString = d.h(paramString, g.class);
    g localg = mgZ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(136699);
    njw = new g("LEFT", 0);
    njx = new g("RIGHT", 1);
    njy = new g("CENTER", 2);
    njz = new g[] { njw, njx, njy };
    AppMethodBeat.o(136699);
  }
  
  private g() {}
  
  public static g Vu(String paramString)
  {
    AppMethodBeat.i(136698);
    paramString = d.h(paramString, g.class);
    g localg = njw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.g
 * JD-Core Version:    0.7.0.1
 */
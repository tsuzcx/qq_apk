package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(136699);
    uMa = new g("LEFT", 0);
    uMb = new g("RIGHT", 1);
    uMc = new g("CENTER", 2);
    uMd = new g[] { uMa, uMb, uMc };
    AppMethodBeat.o(136699);
  }
  
  private g() {}
  
  public static g ahd(String paramString)
  {
    AppMethodBeat.i(136698);
    g localg1 = (g)d.l(paramString, g.class);
    g localg2 = uMa;
    paramString = localg1;
    if (localg1 == null) {
      paramString = localg2;
    }
    paramString = (g)paramString;
    AppMethodBeat.o(136698);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.g
 * JD-Core Version:    0.7.0.1
 */
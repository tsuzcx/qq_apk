package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(123957);
    jri = new g("LEFT", 0);
    jrj = new g("RIGHT", 1);
    jrk = new g("CENTER", 2);
    jrl = new g[] { jri, jrj, jrk };
    AppMethodBeat.o(123957);
  }
  
  private g() {}
  
  public static g FR(String paramString)
  {
    AppMethodBeat.i(123956);
    paramString = d.g(paramString, g.class);
    g localg = jri;
    if (paramString == null) {
      paramString = localg;
    }
    for (;;)
    {
      paramString = (g)paramString;
      AppMethodBeat.o(123956);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.g
 * JD-Core Version:    0.7.0.1
 */
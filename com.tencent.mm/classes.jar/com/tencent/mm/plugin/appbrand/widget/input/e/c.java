package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final int style;
  
  static
  {
    AppMethodBeat.i(131528);
    rAa = new c("NORMAL", 0, 0);
    rAb = new c("BOLD", 1, 1);
    rAc = new c[] { rAa, rAb };
    AppMethodBeat.o(131528);
  }
  
  private c(int paramInt)
  {
    this.style = paramInt;
  }
  
  public static c anE(String paramString)
  {
    AppMethodBeat.i(131527);
    paramString = d.h(paramString, c.class);
    c localc = rAa;
    if (paramString == null) {
      paramString = localc;
    }
    for (;;)
    {
      paramString = (c)paramString;
      AppMethodBeat.o(131527);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.c
 * JD-Core Version:    0.7.0.1
 */
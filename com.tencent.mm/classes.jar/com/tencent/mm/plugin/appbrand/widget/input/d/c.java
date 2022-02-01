package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final int style;
  
  static
  {
    AppMethodBeat.i(131528);
    nnW = new c("NORMAL", 0, 0);
    nnX = new c("BOLD", 1, 1);
    nnY = new c[] { nnW, nnX };
    AppMethodBeat.o(131528);
  }
  
  private c(int paramInt)
  {
    this.style = paramInt;
  }
  
  public static c Wf(String paramString)
  {
    AppMethodBeat.i(131527);
    paramString = d.h(paramString, c.class);
    c localc = nnW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.c
 * JD-Core Version:    0.7.0.1
 */
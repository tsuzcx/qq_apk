package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final int style;
  
  static
  {
    AppMethodBeat.i(131528);
    uLr = new c("NORMAL", 0, 0);
    uLs = new c("BOLD", 1, 1);
    uLt = new c[] { uLr, uLs };
    AppMethodBeat.o(131528);
  }
  
  private c(int paramInt)
  {
    this.style = paramInt;
  }
  
  public static c ahc(String paramString)
  {
    AppMethodBeat.i(131527);
    c localc1 = (c)d.l(paramString, c.class);
    c localc2 = uLr;
    paramString = localc1;
    if (localc1 == null) {
      paramString = localc2;
    }
    paramString = (c)paramString;
    AppMethodBeat.o(131527);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.c
 * JD-Core Version:    0.7.0.1
 */
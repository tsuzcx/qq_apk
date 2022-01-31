package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final int style;
  
  static
  {
    AppMethodBeat.i(77452);
    jqy = new c("NORMAL", 0, 0);
    jqz = new c("BOLD", 1, 1);
    jqA = new c[] { jqy, jqz };
    AppMethodBeat.o(77452);
  }
  
  private c(int paramInt)
  {
    this.style = paramInt;
  }
  
  public static c FQ(String paramString)
  {
    AppMethodBeat.i(77451);
    paramString = d.g(paramString, c.class);
    c localc = jqy;
    if (paramString == null) {
      paramString = localc;
    }
    for (;;)
    {
      paramString = (c)paramString;
      AppMethodBeat.o(77451);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.c
 * JD-Core Version:    0.7.0.1
 */
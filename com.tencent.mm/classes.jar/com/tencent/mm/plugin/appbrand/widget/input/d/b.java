package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int niM;
  
  static
  {
    AppMethodBeat.i(131524);
    niG = new b("DONE", 0, 6);
    niH = new b("SEARCH", 1, 3);
    niI = new b("NEXT", 2, 5);
    niJ = new b("GO", 3, 2);
    niK = new b("SEND", 4, 4);
    niL = new b("RETURN", 5, 0);
    niN = new b[] { niG, niH, niI, niJ, niK, niL };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.niM = paramInt;
  }
  
  public static b Vs(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b il(boolean paramBoolean)
  {
    if (paramBoolean) {
      return niL;
    }
    return niG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
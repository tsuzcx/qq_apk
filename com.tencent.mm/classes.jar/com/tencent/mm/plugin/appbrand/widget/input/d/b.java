package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int nnU;
  
  static
  {
    AppMethodBeat.i(131524);
    nnO = new b("DONE", 0, 6);
    nnP = new b("SEARCH", 1, 3);
    nnQ = new b("NEXT", 2, 5);
    nnR = new b("GO", 3, 2);
    nnS = new b("SEND", 4, 4);
    nnT = new b("RETURN", 5, 0);
    nnV = new b[] { nnO, nnP, nnQ, nnR, nnS, nnT };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.nnU = paramInt;
  }
  
  public static b We(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b ij(boolean paramBoolean)
  {
    if (paramBoolean) {
      return nnT;
    }
    return nnO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
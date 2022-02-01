package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int uLp;
  
  static
  {
    AppMethodBeat.i(131524);
    uLj = new b("DONE", 0, 6);
    uLk = new b("SEARCH", 1, 3);
    uLl = new b("NEXT", 2, 5);
    uLm = new b("GO", 3, 2);
    uLn = new b("SEND", 4, 4);
    uLo = new b("RETURN", 5, 0);
    uLq = new b[] { uLj, uLk, uLl, uLm, uLn, uLo };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.uLp = paramInt;
  }
  
  public static b ahb(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.l(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b lH(boolean paramBoolean)
  {
    if (paramBoolean) {
      return uLo;
    }
    return uLj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.b
 * JD-Core Version:    0.7.0.1
 */
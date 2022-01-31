package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int jqw;
  
  static
  {
    AppMethodBeat.i(77448);
    jqr = new b("DONE", 0, 6);
    jqs = new b("SEARCH", 1, 3);
    jqt = new b("NEXT", 2, 5);
    jqu = new b("GO", 3, 2);
    jqv = new b("SEND", 4, 4);
    jqx = new b[] { jqr, jqs, jqt, jqu, jqv };
    AppMethodBeat.o(77448);
  }
  
  private b(int paramInt)
  {
    this.jqw = paramInt;
  }
  
  public static b FP(String paramString)
  {
    AppMethodBeat.i(77447);
    paramString = (b)d.g(paramString, b.class);
    AppMethodBeat.o(77447);
    return paramString;
  }
  
  public static b aRP()
  {
    return jqr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
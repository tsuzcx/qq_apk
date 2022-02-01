package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int mgo;
  
  static
  {
    AppMethodBeat.i(131524);
    mgj = new b("DONE", 0, 6);
    mgk = new b("SEARCH", 1, 3);
    mgl = new b("NEXT", 2, 5);
    mgm = new b("GO", 3, 2);
    mgn = new b("SEND", 4, 4);
    mgp = new b[] { mgj, mgk, mgl, mgm, mgn };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.mgo = paramInt;
  }
  
  public static b NM(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b buh()
  {
    return mgj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int oxA;
  
  static
  {
    AppMethodBeat.i(131524);
    oxu = new b("DONE", 0, 6);
    oxv = new b("SEARCH", 1, 3);
    oxw = new b("NEXT", 2, 5);
    oxx = new b("GO", 3, 2);
    oxy = new b("SEND", 4, 4);
    oxz = new b("RETURN", 5, 0);
    oxB = new b[] { oxu, oxv, oxw, oxx, oxy, oxz };
    AppMethodBeat.o(131524);
  }
  
  private b(int paramInt)
  {
    this.oxA = paramInt;
  }
  
  public static b aga(String paramString)
  {
    AppMethodBeat.i(131523);
    paramString = (b)d.h(paramString, b.class);
    AppMethodBeat.o(131523);
    return paramString;
  }
  
  public static b jk(boolean paramBoolean)
  {
    if (paramBoolean) {
      return oxz;
    }
    return oxu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
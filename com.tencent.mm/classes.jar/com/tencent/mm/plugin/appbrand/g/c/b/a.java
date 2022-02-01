package com.tencent.mm.plugin.appbrand.g.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public b lll;
  public String value;
  
  public a()
  {
    AppMethodBeat.i(159022);
    this.lll = new b();
    AppMethodBeat.o(159022);
  }
  
  public final String Yh(String paramString)
  {
    AppMethodBeat.i(159023);
    paramString = this.lll.get(paramString);
    AppMethodBeat.o(159023);
    return paramString;
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(159024);
    String str = this.value + ", attrs:" + this.lll.toString() + "\n";
    AppMethodBeat.o(159024);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.b.a
 * JD-Core Version:    0.7.0.1
 */
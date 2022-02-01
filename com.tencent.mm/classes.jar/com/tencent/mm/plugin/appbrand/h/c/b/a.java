package com.tencent.mm.plugin.appbrand.h.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public b jKa;
  public String value;
  
  public a()
  {
    AppMethodBeat.i(159022);
    this.jKa = new b();
    AppMethodBeat.o(159022);
  }
  
  public final String KU(String paramString)
  {
    AppMethodBeat.i(159023);
    paramString = this.jKa.get(paramString);
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
    String str = this.value + ", attrs:" + this.jKa.toString() + "\n";
    AppMethodBeat.o(159024);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.b.a
 * JD-Core Version:    0.7.0.1
 */
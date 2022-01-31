package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(90974);
    gYe = new b("FOREGROUND", 0);
    gYf = new b("BACKGROUND", 1);
    gYg = new b("SUSPEND", 2);
    gYh = new b("DESTROYED", 3);
    gYi = new b[] { gYe, gYf, gYg, gYh };
    AppMethodBeat.o(90974);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$b
{
  static
  {
    AppMethodBeat.i(90952);
    gOX = new b("INIT", 0);
    gOY = new b("ON_CREATE", 1);
    gOZ = new b("ON_RESUME", 2);
    gPa = new b("ON_PAUSE", 3);
    gPb = new b("ON_STOP", 4);
    gPc = new b("ON_DESTROY", 5);
    gPd = new b[] { gOX, gOY, gOZ, gPa, gPb, gPc };
    AppMethodBeat.o(90952);
  }
  
  private e$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.b
 * JD-Core Version:    0.7.0.1
 */
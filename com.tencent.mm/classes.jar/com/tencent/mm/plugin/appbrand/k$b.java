package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$b
{
  static
  {
    AppMethodBeat.i(140563);
    nsU = new b("INIT", 0);
    nsV = new b("ON_CREATE", 1);
    nsW = new b("ON_RESUME", 2);
    nsX = new b("ON_PAUSE", 3);
    nsY = new b("ON_STOP", 4);
    nsZ = new b("ON_DESTROY", 5);
    nta = new b[] { nsU, nsV, nsW, nsX, nsY, nsZ };
    AppMethodBeat.o(140563);
  }
  
  private k$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.b
 * JD-Core Version:    0.7.0.1
 */
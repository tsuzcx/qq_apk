package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bb
{
  static
  {
    AppMethodBeat.i(135279);
    leY = new bb("MODAL", 0);
    leZ = new bb("ACTION_SHEET", 1);
    lfa = new bb("TOAST", 2);
    lfb = new bb[] { leY, leZ, lfa };
    AppMethodBeat.o(135279);
  }
  
  private bb() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb
 * JD-Core Version:    0.7.0.1
 */
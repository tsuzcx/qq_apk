package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum aw
{
  static
  {
    AppMethodBeat.i(135279);
    lEO = new aw("MODAL", 0);
    lEP = new aw("ACTION_SHEET", 1);
    lEQ = new aw("TOAST", 2);
    lER = new aw[] { lEO, lEP, lEQ };
    AppMethodBeat.o(135279);
  }
  
  private aw() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw
 * JD-Core Version:    0.7.0.1
 */
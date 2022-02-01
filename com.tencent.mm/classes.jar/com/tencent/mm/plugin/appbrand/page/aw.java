package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum aw
{
  static
  {
    AppMethodBeat.i(135279);
    mes = new aw("MODAL", 0);
    met = new aw("ACTION_SHEET", 1);
    meu = new aw("TOAST", 2);
    mev = new aw[] { mes, met, meu };
    AppMethodBeat.o(135279);
  }
  
  private aw() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw
 * JD-Core Version:    0.7.0.1
 */
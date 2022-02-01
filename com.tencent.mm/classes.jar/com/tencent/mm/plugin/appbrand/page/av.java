package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum av
{
  static
  {
    AppMethodBeat.i(135279);
    miM = new av("MODAL", 0);
    miN = new av("ACTION_SHEET", 1);
    miO = new av("TOAST", 2);
    miP = new av[] { miM, miN, miO };
    AppMethodBeat.o(135279);
  }
  
  private av() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */
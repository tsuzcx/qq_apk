package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bb
{
  static
  {
    AppMethodBeat.i(135279);
    tzO = new bb("MODAL", 0);
    tzP = new bb("ACTION_SHEET", 1);
    tzQ = new bb("TOAST", 2);
    tzR = new bb[] { tzO, tzP, tzQ };
    AppMethodBeat.o(135279);
  }
  
  private bb() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb
 * JD-Core Version:    0.7.0.1
 */
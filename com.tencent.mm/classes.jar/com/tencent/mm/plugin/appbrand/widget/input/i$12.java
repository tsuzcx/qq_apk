package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.a;

final class i$12
  extends p.a
{
  i$12(i parami) {}
  
  public final void vn()
  {
    AppMethodBeat.i(141612);
    if (this.jlw.jll != null) {
      try
      {
        this.jlw.jlp.a(this.jlw.jll.getEditableText(), false);
        AppMethodBeat.o(141612);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(141612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.12
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c wfJ;
  public a wfK;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.wfK = new d();
    if (b.isMMProcess()) {
      this.wfK.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c dcQ()
  {
    AppMethodBeat.i(121963);
    if (wfJ == null) {}
    try
    {
      if (wfJ == null) {
        wfJ = new c();
      }
      c localc = wfJ;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void axj(String paramString)
  {
    AppMethodBeat.i(121965);
    this.wfK.axj(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
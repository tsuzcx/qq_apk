package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c pEN;
  public a pEO;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.pEO = new d();
    if (b.cbv()) {
      this.pEO.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c cbS()
  {
    AppMethodBeat.i(121963);
    if (pEN == null) {}
    try
    {
      if (pEN == null) {
        pEN = new c();
      }
      c localc = pEN;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void VX(String paramString)
  {
    AppMethodBeat.i(121965);
    this.pEO.VX(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
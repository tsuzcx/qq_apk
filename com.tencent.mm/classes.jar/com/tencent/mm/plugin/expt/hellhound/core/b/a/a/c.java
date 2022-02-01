package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c szP;
  public a szQ;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.szQ = new d();
    if (b.isMMProcess()) {
      this.szQ.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c cNY()
  {
    AppMethodBeat.i(121963);
    if (szP == null) {}
    try
    {
      if (szP == null) {
        szP = new c();
      }
      c localc = szP;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void apj(String paramString)
  {
    AppMethodBeat.i(121965);
    this.szQ.apj(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
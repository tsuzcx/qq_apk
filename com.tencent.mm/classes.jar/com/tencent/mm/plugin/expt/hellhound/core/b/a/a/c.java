package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c qjA;
  public a qjB;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.qjB = new d();
    if (b.ciE()) {
      this.qjB.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c cjd()
  {
    AppMethodBeat.i(121963);
    if (qjA == null) {}
    try
    {
      if (qjA == null) {
        qjA = new c();
      }
      c localc = qjA;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void aam(String paramString)
  {
    AppMethodBeat.i(121965);
    this.qjB.aam(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
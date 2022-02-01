package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c qZy;
  public a qZz;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.qZz = new d();
    if (b.cpe()) {
      this.qZz.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c cpF()
  {
    AppMethodBeat.i(121963);
    if (qZy == null) {}
    try
    {
      if (qZy == null) {
        qZy = new c();
      }
      c localc = qZy;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void aeT(String paramString)
  {
    AppMethodBeat.i(121965);
    this.qZz.aeT(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
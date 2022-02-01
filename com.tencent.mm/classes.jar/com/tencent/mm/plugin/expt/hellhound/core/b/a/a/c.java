package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c qRA;
  public a qRB;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.qRB = new d();
    if (b.cnC()) {
      this.qRB.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c cod()
  {
    AppMethodBeat.i(121963);
    if (qRA == null) {}
    try
    {
      if (qRA == null) {
        qRA = new c();
      }
      c localc = qRA;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void adZ(String paramString)
  {
    AppMethodBeat.i(121965);
    this.qRB.adZ(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
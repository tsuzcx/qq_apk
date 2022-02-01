package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c zBK;
  public a zBL;
  
  private c()
  {
    AppMethodBeat.i(121964);
    this.zBL = new d();
    if (b.isMMProcess()) {
      this.zBL.reset();
    }
    AppMethodBeat.o(121964);
  }
  
  public static c dJs()
  {
    AppMethodBeat.i(121963);
    if (zBK == null) {}
    try
    {
      if (zBK == null) {
        zBK = new c();
      }
      c localc = zBK;
      AppMethodBeat.o(121963);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121963);
    }
  }
  
  public final void arn(String paramString)
  {
    AppMethodBeat.i(121965);
    this.zBL.arn(paramString);
    AppMethodBeat.o(121965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
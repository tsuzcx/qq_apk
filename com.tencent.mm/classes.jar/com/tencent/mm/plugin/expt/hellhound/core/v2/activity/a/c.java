package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c
{
  private static volatile c mag;
  public a mah;
  
  private c()
  {
    AppMethodBeat.i(73428);
    this.mah = new d();
    if (b.brt()) {
      this.mah.reset();
    }
    AppMethodBeat.o(73428);
  }
  
  public static c brO()
  {
    AppMethodBeat.i(73427);
    if (mag == null) {}
    try
    {
      if (mag == null) {
        mag = new c();
      }
      c localc = mag;
      AppMethodBeat.o(73427);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(73427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c
 * JD-Core Version:    0.7.0.1
 */
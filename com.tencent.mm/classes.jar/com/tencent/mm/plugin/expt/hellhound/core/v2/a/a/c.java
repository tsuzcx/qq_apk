package com.tencent.mm.plugin.expt.hellhound.core.v2.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c maA;
  public int ikr;
  public b maB;
  public a maC;
  
  private c()
  {
    AppMethodBeat.i(152313);
    this.ikr = -1;
    this.maB = new b();
    AppMethodBeat.o(152313);
  }
  
  public static c brT()
  {
    AppMethodBeat.i(152312);
    if (maA == null) {}
    try
    {
      if (maA == null) {
        maA = new c();
      }
      c localc = maA;
      AppMethodBeat.o(152312);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(152312);
    }
  }
  
  final void vp(int paramInt)
  {
    AppMethodBeat.i(152311);
    this.ikr = paramInt;
    if (this.maC != null) {
      this.maC.vo(paramInt);
    }
    AppMethodBeat.o(152311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c
 * JD-Core Version:    0.7.0.1
 */
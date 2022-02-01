package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static volatile c cbt;
  public g cbu;
  
  protected c()
  {
    AppMethodBeat.i(130470);
    this.cbu = new com.tencent.luggage.game.c.c();
    AppMethodBeat.o(130470);
  }
  
  public static c Bt()
  {
    AppMethodBeat.i(130471);
    if (cbt == null) {}
    try
    {
      if (cbt == null) {
        cbt = new c();
      }
      c localc = cbt;
      AppMethodBeat.o(130471);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(130471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.c
 * JD-Core Version:    0.7.0.1
 */
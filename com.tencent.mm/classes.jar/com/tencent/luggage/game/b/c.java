package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static volatile c bYq;
  public g bYr;
  
  protected c()
  {
    AppMethodBeat.i(130470);
    this.bYr = new com.tencent.luggage.game.c.c();
    AppMethodBeat.o(130470);
  }
  
  public static c AX()
  {
    AppMethodBeat.i(130471);
    if (bYq == null) {}
    try
    {
      if (bYq == null) {
        bYq = new c();
      }
      c localc = bYq;
      AppMethodBeat.o(130471);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(130471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.b.c
 * JD-Core Version:    0.7.0.1
 */
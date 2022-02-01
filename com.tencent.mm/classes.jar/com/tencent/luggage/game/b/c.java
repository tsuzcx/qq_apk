package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static volatile c ciI;
  public g ciJ;
  
  protected c()
  {
    AppMethodBeat.i(130470);
    this.ciJ = new com.tencent.luggage.game.c.c();
    AppMethodBeat.o(130470);
  }
  
  public static c Cw()
  {
    AppMethodBeat.i(130471);
    if (ciI == null) {}
    try
    {
      if (ciI == null) {
        ciI = new c();
      }
      c localc = ciI;
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
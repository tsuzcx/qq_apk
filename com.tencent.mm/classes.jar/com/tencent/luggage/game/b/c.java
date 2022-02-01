package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static volatile c ciK;
  public g ciL;
  
  protected c()
  {
    AppMethodBeat.i(130470);
    this.ciL = new com.tencent.luggage.game.c.c();
    AppMethodBeat.o(130470);
  }
  
  public static c Cz()
  {
    AppMethodBeat.i(130471);
    if (ciK == null) {}
    try
    {
      if (ciK == null) {
        ciK = new c();
      }
      c localc = ciK;
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
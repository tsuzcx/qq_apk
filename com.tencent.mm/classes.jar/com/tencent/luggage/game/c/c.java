package com.tencent.luggage.game.c;

import com.tencent.luggage.game.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static volatile c bAd;
  public f bAe;
  
  protected c()
  {
    AppMethodBeat.i(140349);
    this.bAe = new com.tencent.luggage.game.d.c();
    AppMethodBeat.o(140349);
  }
  
  public static c uC()
  {
    AppMethodBeat.i(140350);
    if (bAd == null) {}
    try
    {
      if (bAd == null) {
        bAd = new c();
      }
      c localc = bAd;
      AppMethodBeat.o(140350);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(140350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.c
 * JD-Core Version:    0.7.0.1
 */
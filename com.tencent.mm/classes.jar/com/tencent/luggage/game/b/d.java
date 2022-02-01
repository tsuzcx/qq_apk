package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.c;
import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  private static volatile d ekJ;
  public g ekK;
  
  protected d()
  {
    AppMethodBeat.i(130470);
    this.ekK = new c();
    AppMethodBeat.o(130470);
  }
  
  public static d aoV()
  {
    AppMethodBeat.i(130471);
    if (ekJ == null) {}
    try
    {
      if (ekJ == null) {
        ekJ = new d();
      }
      d locald = ekJ;
      AppMethodBeat.o(130471);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(130471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.b.d
 * JD-Core Version:    0.7.0.1
 */
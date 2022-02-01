package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static d.a cye;
  
  static
  {
    AppMethodBeat.i(140005);
    cye = new d.a()
    {
      public final void gS(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(140005);
  }
  
  public static d.a HA()
  {
    return cye;
  }
  
  public static void a(d.a parama)
  {
    cye = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.a
 * JD-Core Version:    0.7.0.1
 */
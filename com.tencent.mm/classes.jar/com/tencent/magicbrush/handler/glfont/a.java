package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static d.a cnz;
  
  static
  {
    AppMethodBeat.i(140005);
    cnz = new d.a()
    {
      public final void gN(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(140005);
  }
  
  public static d.a Gf()
  {
    return cnz;
  }
  
  public static void a(d.a parama)
  {
    cnz = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.a
 * JD-Core Version:    0.7.0.1
 */
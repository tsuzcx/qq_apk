package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static d.a cqs;
  
  static
  {
    AppMethodBeat.i(140005);
    cqs = new d.a()
    {
      public final void he(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(140005);
  }
  
  public static d.a Gt()
  {
    return cqs;
  }
  
  public static void a(d.a parama)
  {
    cqs = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.a
 * JD-Core Version:    0.7.0.1
 */
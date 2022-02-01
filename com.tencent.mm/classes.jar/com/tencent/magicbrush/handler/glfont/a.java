package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static d.a eJa;
  
  static
  {
    AppMethodBeat.i(140005);
    eJa = new d.a()
    {
      public final void mQ(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(140005);
  }
  
  public static void a(d.a parama)
  {
    eJa = parama;
  }
  
  public static d.a avK()
  {
    return eJa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.a
 * JD-Core Version:    0.7.0.1
 */
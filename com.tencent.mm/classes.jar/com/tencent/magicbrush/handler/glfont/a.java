package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static d.a bJH;
  
  static
  {
    AppMethodBeat.i(115904);
    bJH = new a.1();
    AppMethodBeat.o(115904);
  }
  
  public static void a(d.a parama)
  {
    bJH = parama;
  }
  
  public static d.a ys()
  {
    return bJH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.a
 * JD-Core Version:    0.7.0.1
 */
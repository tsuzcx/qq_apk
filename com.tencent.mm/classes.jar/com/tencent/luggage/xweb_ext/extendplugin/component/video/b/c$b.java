package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c$b
  implements c
{
  private static b bIn;
  
  public static b ya()
  {
    AppMethodBeat.i(139906);
    if (bIn == null) {}
    try
    {
      if (bIn == null) {
        bIn = new b();
      }
      b localb = bIn;
      AppMethodBeat.o(139906);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(139906);
    }
  }
  
  public final b g(a parama)
  {
    AppMethodBeat.i(139907);
    parama = new d();
    AppMethodBeat.o(139907);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.ae;
import com.tencent.mm.plugin.game.luggage.b.g;
import com.tencent.mm.plugin.game.luggage.b.h;
import com.tencent.mm.plugin.game.luggage.b.k;
import com.tencent.mm.plugin.game.luggage.b.v;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.plugin.webview.luggage.jsapi.ay;
import java.util.LinkedList;

public final class b
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> pow;
  
  private static void aM(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(211711);
    pow.add(paramClass);
    AppMethodBeat.o(211711);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> ccP()
  {
    try
    {
      AppMethodBeat.i(211710);
      pow = new LinkedList();
      aM(ax.class);
      aM(ay.class);
      aM(v.class);
      aM(ae.class);
      aM(k.class);
      aM(g.class);
      aM(h.class);
      LinkedList localLinkedList = pow;
      AppMethodBeat.o(211710);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.b
 * JD-Core Version:    0.7.0.1
 */
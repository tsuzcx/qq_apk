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
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> pvc;
  
  private static void aM(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(193110);
    pvc.add(paramClass);
    AppMethodBeat.o(193110);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> cee()
  {
    try
    {
      AppMethodBeat.i(193109);
      pvc = new LinkedList();
      aM(ax.class);
      aM(ay.class);
      aM(v.class);
      aM(ae.class);
      aM(k.class);
      aM(g.class);
      aM(h.class);
      LinkedList localLinkedList = pvc;
      AppMethodBeat.o(193109);
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
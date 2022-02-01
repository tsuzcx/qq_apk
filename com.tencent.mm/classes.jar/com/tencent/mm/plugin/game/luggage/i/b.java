package com.tencent.mm.plugin.game.luggage.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.ah;
import com.tencent.mm.plugin.game.luggage.b.g;
import com.tencent.mm.plugin.game.luggage.b.h;
import com.tencent.mm.plugin.game.luggage.b.l;
import com.tencent.mm.plugin.game.luggage.b.p;
import com.tencent.mm.plugin.game.luggage.b.q;
import com.tencent.mm.plugin.game.luggage.b.y;
import com.tencent.mm.plugin.webview.luggage.jsapi.ay;
import com.tencent.mm.plugin.webview.luggage.jsapi.az;
import java.util.LinkedList;

public final class b
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> xwA;
  
  private static void aQ(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(187008);
    xwA.add(paramClass);
    AppMethodBeat.o(187008);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> dTr()
  {
    try
    {
      AppMethodBeat.i(187007);
      xwA = new LinkedList();
      aQ(ay.class);
      aQ(az.class);
      aQ(y.class);
      aQ(ah.class);
      aQ(l.class);
      aQ(g.class);
      aQ(h.class);
      aQ(q.class);
      aQ(p.class);
      LinkedList localLinkedList = xwA;
      AppMethodBeat.o(187007);
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.ak;
import com.tencent.mm.plugin.game.luggage.b.g;
import com.tencent.mm.plugin.game.luggage.b.h;
import com.tencent.mm.plugin.game.luggage.b.l;
import com.tencent.mm.plugin.game.luggage.b.p;
import com.tencent.mm.plugin.game.luggage.b.q;
import com.tencent.mm.plugin.game.luggage.b.z;
import com.tencent.mm.plugin.webview.luggage.jsapi.ay;
import com.tencent.mm.plugin.webview.luggage.jsapi.az;
import java.util.LinkedList;

public final class b
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> CAI;
  
  private static void bh(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(231496);
    CAI.add(paramClass);
    AppMethodBeat.o(231496);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> ewB()
  {
    try
    {
      AppMethodBeat.i(231495);
      CAI = new LinkedList();
      bh(ay.class);
      bh(az.class);
      bh(z.class);
      bh(ak.class);
      bh(l.class);
      bh(g.class);
      bh(h.class);
      bh(q.class);
      bh(p.class);
      LinkedList localLinkedList = CAI;
      AppMethodBeat.o(231495);
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
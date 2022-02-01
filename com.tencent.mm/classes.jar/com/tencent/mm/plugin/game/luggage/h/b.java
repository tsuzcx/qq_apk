package com.tencent.mm.plugin.game.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.ad;
import com.tencent.mm.plugin.game.luggage.b.aq;
import com.tencent.mm.plugin.game.luggage.b.h;
import com.tencent.mm.plugin.game.luggage.b.i;
import com.tencent.mm.plugin.game.luggage.b.o;
import com.tencent.mm.plugin.game.luggage.b.s;
import com.tencent.mm.plugin.game.luggage.b.t;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import java.util.LinkedList;

public final class b
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> Iuu;
  
  private static void bS(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(276968);
    Iuu.add(paramClass);
    AppMethodBeat.o(276968);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> fEv()
  {
    try
    {
      AppMethodBeat.i(276963);
      Iuu = new LinkedList();
      bS(bc.class);
      bS(bd.class);
      bS(ad.class);
      bS(aq.class);
      bS(o.class);
      bS(h.class);
      bS(i.class);
      bS(t.class);
      bS(s.class);
      LinkedList localLinkedList = Iuu;
      AppMethodBeat.o(276963);
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
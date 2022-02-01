package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.a>> oKO;
  
  private static void aM(Class<? extends com.tencent.luggage.d.a> paramClass)
  {
    AppMethodBeat.i(83050);
    oKO.add(paramClass);
    AppMethodBeat.o(83050);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.a>> bYl()
  {
    try
    {
      AppMethodBeat.i(83049);
      oKO = new LinkedList();
      aM(g.class);
      aM(i.class);
      aM(j.class);
      aM(l.class);
      aM(m.class);
      aM(r.class);
      aM(s.class);
      aM(u.class);
      aM(z.class);
      aM(x.class);
      aM(y.class);
      aM(o.class);
      aM(c.class);
      aM(b.class);
      aM(q.class);
      aM(h.class);
      aM(p.class);
      aM(f.class);
      aM(v.class);
      aM(e.class);
      aM(w.class);
      aM(n.class);
      aM(aa.class);
      aM(ba.class);
      aM(d.class);
      aM(k.class);
      aM(t.class);
      LinkedList localLinkedList = oKO;
      AppMethodBeat.o(83049);
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */
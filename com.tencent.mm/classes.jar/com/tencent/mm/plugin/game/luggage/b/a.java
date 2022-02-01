package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.a>> oho;
  
  private static void aM(Class<? extends com.tencent.luggage.d.a> paramClass)
  {
    AppMethodBeat.i(83050);
    oho.add(paramClass);
    AppMethodBeat.o(83050);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.a>> bQW()
  {
    try
    {
      AppMethodBeat.i(83049);
      oho = new LinkedList();
      aM(g.class);
      aM(i.class);
      aM(j.class);
      aM(k.class);
      aM(l.class);
      aM(q.class);
      aM(r.class);
      aM(s.class);
      aM(x.class);
      aM(v.class);
      aM(w.class);
      aM(n.class);
      aM(c.class);
      aM(b.class);
      aM(p.class);
      aM(h.class);
      aM(o.class);
      aM(f.class);
      aM(t.class);
      aM(e.class);
      aM(u.class);
      aM(m.class);
      aM(y.class);
      aM(ba.class);
      aM(d.class);
      LinkedList localLinkedList = oho;
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
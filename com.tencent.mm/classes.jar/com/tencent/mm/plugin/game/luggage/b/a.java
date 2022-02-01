package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> pvc;
  
  private static void aM(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(83050);
    pvc.add(paramClass);
    AppMethodBeat.o(83050);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> cee()
  {
    try
    {
      AppMethodBeat.i(83049);
      pvc = new LinkedList();
      aM(g.class);
      aM(j.class);
      aM(k.class);
      aM(m.class);
      aM(n.class);
      aM(t.class);
      aM(v.class);
      aM(x.class);
      aM(ae.class);
      aM(aa.class);
      aM(ab.class);
      aM(q.class);
      aM(c.class);
      aM(b.class);
      aM(s.class);
      aM(i.class);
      aM(r.class);
      aM(f.class);
      aM(y.class);
      aM(e.class);
      aM(z.class);
      aM(p.class);
      aM(ah.class);
      aM(bd.class);
      aM(d.class);
      aM(l.class);
      aM(w.class);
      aM(af.class);
      aM(ag.class);
      aM(o.class);
      aM(ad.class);
      aM(u.class);
      aM(ac.class);
      LinkedList localLinkedList = pvc;
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
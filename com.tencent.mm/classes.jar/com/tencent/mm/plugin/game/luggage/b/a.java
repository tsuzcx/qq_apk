package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.be;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.b>> CAI;
  
  private static void bh(Class<? extends com.tencent.luggage.d.b> paramClass)
  {
    AppMethodBeat.i(83050);
    CAI.add(paramClass);
    AppMethodBeat.o(83050);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.b>> ewB()
  {
    try
    {
      AppMethodBeat.i(83049);
      CAI = new LinkedList();
      bh(g.class);
      bh(k.class);
      bh(l.class);
      bh(n.class);
      bh(o.class);
      bh(x.class);
      bh(z.class);
      bh(ab.class);
      bh(ak.class);
      bh(ag.class);
      bh(ah.class);
      bh(t.class);
      bh(c.class);
      bh(b.class);
      bh(v.class);
      bh(j.class);
      bh(u.class);
      bh(f.class);
      bh(ad.class);
      bh(e.class);
      bh(ae.class);
      bh(s.class);
      bh(an.class);
      bh(be.class);
      bh(d.class);
      bh(m.class);
      bh(aa.class);
      bh(ac.class);
      bh(al.class);
      bh(am.class);
      bh(r.class);
      bh(aj.class);
      bh(y.class);
      bh(ai.class);
      bh(i.class);
      bh(q.class);
      bh(p.class);
      bh(af.class);
      bh(w.class);
      LinkedList localLinkedList = CAI;
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
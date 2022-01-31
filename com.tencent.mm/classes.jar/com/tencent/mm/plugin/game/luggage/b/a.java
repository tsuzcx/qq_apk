package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.a>> laz;
  
  private static void ai(Class<? extends com.tencent.luggage.d.a> paramClass)
  {
    AppMethodBeat.i(135865);
    laz.add(paramClass);
    AppMethodBeat.o(135865);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.a>> bjM()
  {
    try
    {
      AppMethodBeat.i(135864);
      laz = new LinkedList();
      ai(f.class);
      ai(h.class);
      ai(i.class);
      ai(j.class);
      ai(k.class);
      ai(p.class);
      ai(q.class);
      ai(r.class);
      ai(w.class);
      ai(u.class);
      ai(v.class);
      ai(m.class);
      ai(c.class);
      ai(b.class);
      ai(o.class);
      ai(g.class);
      ai(n.class);
      ai(e.class);
      ai(s.class);
      ai(d.class);
      ai(t.class);
      ai(l.class);
      ai(x.class);
      LinkedList localLinkedList = laz;
      AppMethodBeat.o(135864);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */
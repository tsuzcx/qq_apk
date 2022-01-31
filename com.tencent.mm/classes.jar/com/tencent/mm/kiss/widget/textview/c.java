package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  public static c eLm;
  public ConcurrentHashMap<Integer, b> eLn;
  
  static
  {
    AppMethodBeat.i(105699);
    eLm = new c();
    AppMethodBeat.o(105699);
  }
  
  public c()
  {
    AppMethodBeat.i(105694);
    this.eLn = new ConcurrentHashMap();
    AppMethodBeat.o(105694);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(105698);
    int i = parama.hashCode();
    AppMethodBeat.o(105698);
    return i;
  }
  
  public final void SJ()
  {
    AppMethodBeat.i(105697);
    Iterator localIterator = this.eLn.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).eLl.clear();
    }
    this.eLn.clear();
    AppMethodBeat.o(105697);
  }
  
  public final f a(a parama, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105696);
    if (parama != null)
    {
      parama = (b)this.eLn.get(Integer.valueOf(parama.hashCode()));
      if (parama != null)
      {
        parama = parama.s(paramCharSequence);
        AppMethodBeat.o(105696);
        return parama;
      }
    }
    AppMethodBeat.o(105696);
    return null;
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(105695);
    if (parama == null)
    {
      AppMethodBeat.o(105695);
      return;
    }
    b localb = (b)this.eLn.get(Integer.valueOf(parama.hashCode()));
    if (localb != null)
    {
      localb.a(paramf);
      this.eLn.put(Integer.valueOf(parama.hashCode()), localb);
      AppMethodBeat.o(105695);
      return;
    }
    localb = new b();
    localb.a(paramf);
    this.eLn.put(Integer.valueOf(parama.hashCode()), localb);
    AppMethodBeat.o(105695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.c
 * JD-Core Version:    0.7.0.1
 */
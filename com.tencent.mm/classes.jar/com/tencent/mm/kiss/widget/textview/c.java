package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  public static c mGx;
  public ConcurrentHashMap<Integer, b> mGy;
  
  static
  {
    AppMethodBeat.i(141017);
    mGx = new c();
    AppMethodBeat.o(141017);
  }
  
  public c()
  {
    AppMethodBeat.i(141012);
    this.mGy = new ConcurrentHashMap();
    AppMethodBeat.o(141012);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(141016);
    int i = parama.hashCode();
    AppMethodBeat.o(141016);
    return i;
  }
  
  public final f a(a parama, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141014);
    if (parama != null)
    {
      parama = (b)this.mGy.get(Integer.valueOf(parama.hashCode()));
      if (parama != null)
      {
        parama = parama.J(paramCharSequence);
        AppMethodBeat.o(141014);
        return parama;
      }
    }
    AppMethodBeat.o(141014);
    return null;
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(141013);
    if (parama == null)
    {
      AppMethodBeat.o(141013);
      return;
    }
    b localb = (b)this.mGy.get(Integer.valueOf(parama.hashCode()));
    if (localb != null)
    {
      localb.a(paramf);
      this.mGy.put(Integer.valueOf(parama.hashCode()), localb);
      AppMethodBeat.o(141013);
      return;
    }
    localb = new b();
    localb.a(paramf);
    this.mGy.put(Integer.valueOf(parama.hashCode()), localb);
    AppMethodBeat.o(141013);
  }
  
  public final void bbI()
  {
    AppMethodBeat.i(141015);
    Iterator localIterator = this.mGy.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).mGw.clear();
    }
    this.mGy.clear();
    AppMethodBeat.o(141015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.kiss.widget.textview;

import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  public static c dNE = new c();
  public ConcurrentHashMap<Integer, b> dNF = new ConcurrentHashMap();
  
  public static int a(a parama)
  {
    return parama.hashCode();
  }
  
  public final void EE()
  {
    Iterator localIterator = this.dNF.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).dND.clear();
    }
    this.dNF.clear();
  }
  
  public final f a(a parama, CharSequence paramCharSequence)
  {
    if (parama != null)
    {
      parama = (b)this.dNF.get(Integer.valueOf(parama.hashCode()));
      if (parama != null) {
        return parama.n(paramCharSequence);
      }
    }
    return null;
  }
  
  public final void a(a parama, f paramf)
  {
    if (parama == null) {
      return;
    }
    b localb = (b)this.dNF.get(Integer.valueOf(parama.hashCode()));
    if (localb != null)
    {
      localb.a(paramf);
      this.dNF.put(Integer.valueOf(parama.hashCode()), localb);
      return;
    }
    localb = new b();
    localb.a(paramf);
    this.dNF.put(Integer.valueOf(parama.hashCode()), localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.c
 * JD-Core Version:    0.7.0.1
 */
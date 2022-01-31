package com.tencent.mm.plugin.appbrand.n.a;

import com.tencent.mm.plugin.appbrand.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final r bEw;
  private final a iui;
  private Set<Integer> iuj = new HashSet();
  
  public e(a parama, r paramr)
  {
    this.iui = parama;
    this.bEw = paramr;
  }
  
  public final void E(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.iuj.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.iui.d(i, paramMap);
    }
  }
  
  protected abstract void aIC();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.iuj.isEmpty()) {
          break label47;
        }
        i = 1;
        this.iuj.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      aIC();
      return;
      label47:
      int i = 0;
    }
  }
  
  protected abstract void removeListener();
  
  public final void unListen(int paramInt)
  {
    try
    {
      if (this.iuj.contains(Integer.valueOf(paramInt))) {
        this.iuj.remove(Integer.valueOf(paramInt));
      }
      if (!this.iuj.isEmpty()) {
        return;
      }
      removeListener();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a.e
 * JD-Core Version:    0.7.0.1
 */
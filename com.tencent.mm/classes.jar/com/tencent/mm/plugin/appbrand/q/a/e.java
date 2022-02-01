package com.tencent.mm.plugin.appbrand.q.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final q ceh;
  private final a lyn;
  private final Set<Integer> lyo = new b();
  
  public e(a parama, q paramq)
  {
    this.lyn = parama;
    this.ceh = paramq;
  }
  
  public final void Q(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.lyo.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.lyn.d(i, paramMap);
    }
  }
  
  protected abstract void bpC();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.lyo.isEmpty()) {
          break label47;
        }
        i = 1;
        this.lyo.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      bpC();
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
      if (this.lyo.contains(Integer.valueOf(paramInt))) {
        this.lyo.remove(Integer.valueOf(paramInt));
      }
      if (!this.lyo.isEmpty()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.e
 * JD-Core Version:    0.7.0.1
 */
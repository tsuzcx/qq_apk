package com.tencent.mm.plugin.appbrand.u.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final s cAJ;
  private final a nkd;
  private final Set<Integer> nke = new b();
  
  public e(a parama, s params)
  {
    this.nkd = parama;
    this.cAJ = params;
  }
  
  public final void aa(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.nke.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.nkd.f(i, paramMap);
    }
  }
  
  protected abstract void bPV();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.nke.isEmpty()) {
          break label47;
        }
        i = 1;
        this.nke.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      bPV();
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
      if (this.nke.contains(Integer.valueOf(paramInt))) {
        this.nke.remove(Integer.valueOf(paramInt));
      }
      if (!this.nke.isEmpty()) {
        return;
      }
      removeListener();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.e
 * JD-Core Version:    0.7.0.1
 */
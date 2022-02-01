package com.tencent.mm.plugin.appbrand.r.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final q chm;
  private final a kWD;
  private final Set<Integer> kWE = new b();
  
  public e(a parama, q paramq)
  {
    this.kWD = parama;
    this.chm = paramq;
  }
  
  public final void Q(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.kWE.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.kWD.d(i, paramMap);
    }
  }
  
  protected abstract void biJ();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.kWE.isEmpty()) {
          break label47;
        }
        i = 1;
        this.kWE.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      biJ();
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
      if (this.kWE.contains(Integer.valueOf(paramInt))) {
        this.kWE.remove(Integer.valueOf(paramInt));
      }
      if (!this.kWE.isEmpty()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.q.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final q cox;
  private final a lXL;
  private final Set<Integer> lXM = new b();
  
  public e(a parama, q paramq)
  {
    this.lXL = parama;
    this.cox = paramq;
  }
  
  public final void Q(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.lXM.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.lXL.d(i, paramMap);
    }
  }
  
  protected abstract void btD();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.lXM.isEmpty()) {
          break label47;
        }
        i = 1;
        this.lXM.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      btD();
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
      if (this.lXM.contains(Integer.valueOf(paramInt))) {
        this.lXM.remove(Integer.valueOf(paramInt));
      }
      if (!this.lXM.isEmpty()) {
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
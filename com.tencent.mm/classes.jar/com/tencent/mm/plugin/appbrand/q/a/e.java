package com.tencent.mm.plugin.appbrand.q.a;

import android.support.v4.e.b;
import com.tencent.mm.plugin.appbrand.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final r coz;
  private final a mcs;
  private final Set<Integer> mct = new b();
  
  public e(a parama, r paramr)
  {
    this.mcs = parama;
    this.coz = paramr;
  }
  
  public final void X(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.mct.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.mcs.e(i, paramMap);
    }
  }
  
  protected abstract void buo();
  
  public abstract int getType();
  
  public final void listen(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mct.isEmpty()) {
          break label47;
        }
        i = 1;
        this.mct.add(Integer.valueOf(paramInt));
        if (i != 0) {
          return;
        }
      }
      finally {}
      buo();
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
      if (this.mct.contains(Integer.valueOf(paramInt))) {
        this.mct.remove(Integer.valueOf(paramInt));
      }
      if (!this.mct.isEmpty()) {
        return;
      }
      removeListener();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void e(int paramInt, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.e
 * JD-Core Version:    0.7.0.1
 */
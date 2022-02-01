package com.tencent.mm.plugin.appbrand.v.a;

import androidx.b.b;
import com.tencent.mm.plugin.appbrand.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final y esk;
  private final Set<Integer> tqA = new b();
  private final a tqz;
  
  public e(a parama, y paramy)
  {
    this.tqz = parama;
    this.esk = paramy;
  }
  
  public final void CA(int paramInt)
  {
    try
    {
      if (!this.tqA.isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        this.tqA.add(Integer.valueOf(paramInt));
        if (i == 0) {
          break;
        }
        return;
      }
      cCY();
    }
    finally {}
  }
  
  public final void aa(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.tqA.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.tqz.d(i, paramMap);
    }
  }
  
  protected abstract void cCY();
  
  public abstract int getType();
  
  protected abstract void removeListener();
  
  public final void unListen(int paramInt)
  {
    try
    {
      if (this.tqA.contains(Integer.valueOf(paramInt))) {
        this.tqA.remove(Integer.valueOf(paramInt));
      }
      if (!this.tqA.isEmpty()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.u.a;

import androidx.b.b;
import com.tencent.mm.plugin.appbrand.v;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  public final v czP;
  private final a qlB;
  private final Set<Integer> qlC = new b();
  
  public e(a parama, v paramv)
  {
    this.qlB = parama;
    this.czP = paramv;
  }
  
  public final void Cl(int paramInt)
  {
    try
    {
      if (!this.qlC.isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        this.qlC.add(Integer.valueOf(paramInt));
        if (i == 0) {
          break;
        }
        return;
      }
      ccC();
    }
    finally {}
  }
  
  public final void T(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.qlC.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.qlB.e(i, paramMap);
    }
  }
  
  protected abstract void ccC();
  
  public abstract int getType();
  
  protected abstract void removeListener();
  
  public final void unListen(int paramInt)
  {
    try
    {
      if (this.qlC.contains(Integer.valueOf(paramInt))) {
        this.qlC.remove(Integer.valueOf(paramInt));
      }
      if (!this.qlC.isEmpty()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.e
 * JD-Core Version:    0.7.0.1
 */
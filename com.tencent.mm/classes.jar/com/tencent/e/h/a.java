package com.tencent.e.h;

import com.tencent.e.d.a;
import com.tencent.e.d.e;
import com.tencent.e.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean MrS = new AtomicBoolean(false);
  
  public final <V> com.tencent.e.i.d<V> g(k<V> paramk)
  {
    if (!this.MrS.get())
    {
      if (!paramk.isCancelled())
      {
        gal().i(paramk);
        return paramk;
      }
      com.tencent.e.d.Mqv.w("[BasePool#input] task=%s pool=%s", paramk.getKey() + "#" + paramk.Msr, new Object[] { getName() });
    }
    for (;;)
    {
      return null;
      com.tencent.e.d.Mqt.f(paramk.getKey(), paramk.Msr, getName());
    }
  }
  
  protected abstract a gal();
  
  public final boolean isShutdown()
  {
    return this.MrS.get();
  }
  
  protected abstract void onShutdown();
  
  public final void shutdown()
  {
    if (this.MrS.compareAndSet(false, true)) {
      onShutdown();
    }
  }
  
  public static abstract interface a
  {
    public abstract void i(k<?> paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.a
 * JD-Core Version:    0.7.0.1
 */
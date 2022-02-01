package com.tencent.e.h;

import com.tencent.e.d.a;
import com.tencent.e.d.e;
import com.tencent.e.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean ZwQ = new AtomicBoolean(false);
  
  protected abstract void Xq();
  
  public final <V> com.tencent.e.i.d<V> f(k<V> paramk)
  {
    if (!this.ZwQ.get())
    {
      if (!paramk.isCancelled())
      {
        ipX().h(paramk);
        return paramk;
      }
      com.tencent.e.d.Zvw.w("[BasePool#input] task=%s pool=%s", paramk.getKey() + "#" + paramk.Zxo, new Object[] { getName() });
    }
    for (;;)
    {
      return null;
      com.tencent.e.d.Zvu.g(paramk.getKey(), paramk.Zxo, getName());
    }
  }
  
  protected abstract a ipX();
  
  public final boolean isShutdown()
  {
    return this.ZwQ.get();
  }
  
  public final void shutdown()
  {
    if (this.ZwQ.compareAndSet(false, true)) {
      Xq();
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(k<?> paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.h.a
 * JD-Core Version:    0.7.0.1
 */
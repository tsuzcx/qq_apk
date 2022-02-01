package com.tencent.f.h;

import com.tencent.f.d.a;
import com.tencent.f.d.e;
import com.tencent.f.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean RUo = new AtomicBoolean(false);
  
  public final <V> com.tencent.f.i.d<V> f(k<V> paramk)
  {
    if (!this.RUo.get())
    {
      if (!paramk.isCancelled())
      {
        hmw().h(paramk);
        return paramk;
      }
      com.tencent.f.d.RSS.w("[BasePool#input] task=%s pool=%s", paramk.getKey() + "#" + paramk.RUM, new Object[] { getName() });
    }
    for (;;)
    {
      return null;
      com.tencent.f.d.RSQ.g(paramk.getKey(), paramk.RUM, getName());
    }
  }
  
  protected abstract a hmw();
  
  public final boolean isShutdown()
  {
    return this.RUo.get();
  }
  
  protected abstract void onShutdown();
  
  public final void shutdown()
  {
    if (this.RUo.compareAndSet(false, true)) {
      onShutdown();
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(k<?> paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.h.a
 * JD-Core Version:    0.7.0.1
 */
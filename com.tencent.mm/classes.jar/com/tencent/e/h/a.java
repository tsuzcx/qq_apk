package com.tencent.e.h;

import com.tencent.e.d.a;
import com.tencent.e.d.e;
import com.tencent.e.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean LUX = new AtomicBoolean(false);
  
  protected abstract a fVM();
  
  public final <V> com.tencent.e.i.d<V> g(k<V> paramk)
  {
    if (!this.LUX.get())
    {
      if (!paramk.isCancelled())
      {
        fVM().i(paramk);
        return paramk;
      }
      com.tencent.e.d.LTy.w("[BasePool#input] task=%s pool=%s", paramk.getKey() + "#" + paramk.LVw, new Object[] { getName() });
    }
    for (;;)
    {
      return null;
      com.tencent.e.d.LTw.f(paramk.getKey(), paramk.LVw, getName());
    }
  }
  
  public final boolean isShutdown()
  {
    return this.LUX.get();
  }
  
  protected abstract void onShutdown();
  
  public final void shutdown()
  {
    if (this.LUX.compareAndSet(false, true)) {
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
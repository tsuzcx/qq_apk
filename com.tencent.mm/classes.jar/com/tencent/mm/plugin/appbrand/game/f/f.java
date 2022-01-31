package com.tencent.mm.plugin.appbrand.game.f;

import android.support.v4.f.k.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class f<T>
  implements k.a<T>
{
  public ConcurrentLinkedQueue<T> gdq = new ConcurrentLinkedQueue();
  
  public final boolean D(T paramT)
  {
    return this.gdq.offer(paramT);
  }
  
  public abstract T agt();
  
  public T de()
  {
    Object localObject2 = this.gdq.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = agt();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.game.g;

import androidx.core.f.e.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T>
  implements e.a<T>
{
  public ConcurrentLinkedQueue<T> eoq = new ConcurrentLinkedQueue();
  
  public final T acquire()
  {
    Object localObject2 = this.eoq.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = apc();
    }
    return localObject1;
  }
  
  protected abstract T apc();
  
  public final boolean release(T paramT)
  {
    return this.eoq.offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.g.b
 * JD-Core Version:    0.7.0.1
 */
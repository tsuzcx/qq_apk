package com.tencent.luggage.game.g;

import androidx.core.f.f.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T>
  implements f.a<T>
{
  public ConcurrentLinkedQueue<T> cwr = new ConcurrentLinkedQueue();
  
  protected abstract T OU();
  
  public final T acquire()
  {
    Object localObject2 = this.cwr.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = OU();
    }
    return localObject1;
  }
  
  public final boolean release(T paramT)
  {
    return this.cwr.offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.g.b
 * JD-Core Version:    0.7.0.1
 */
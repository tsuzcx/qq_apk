package com.tencent.luggage.game.g;

import android.support.v4.e.k.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T>
  implements k.a<T>
{
  public ConcurrentLinkedQueue<T> bCB = new ConcurrentLinkedQueue();
  
  public final T acquire()
  {
    Object localObject2 = this.bCB.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = uK();
    }
    return localObject1;
  }
  
  public final boolean release(T paramT)
  {
    return this.bCB.offer(paramT);
  }
  
  protected abstract T uK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.g.b
 * JD-Core Version:    0.7.0.1
 */
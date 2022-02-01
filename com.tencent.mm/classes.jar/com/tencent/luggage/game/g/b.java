package com.tencent.luggage.game.g;

import android.support.v4.e.l.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T>
  implements l.a<T>
{
  public ConcurrentLinkedQueue<T> clU = new ConcurrentLinkedQueue();
  
  protected abstract T CG();
  
  public final T acquire()
  {
    Object localObject2 = this.clU.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = CG();
    }
    return localObject1;
  }
  
  public final boolean release(T paramT)
  {
    return this.clU.offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.g.b
 * JD-Core Version:    0.7.0.1
 */
package com.bumptech.glide.c.b.a;

import com.bumptech.glide.h.j;
import java.util.Queue;

abstract class d<T extends m>
{
  private final Queue<T> aGC = j.dx(20);
  
  public final void a(T paramT)
  {
    if (this.aGC.size() < 20) {
      this.aGC.offer(paramT);
    }
  }
  
  abstract T oF();
  
  final T oG()
  {
    m localm2 = (m)this.aGC.poll();
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = oF();
    }
    return localm1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.d
 * JD-Core Version:    0.7.0.1
 */
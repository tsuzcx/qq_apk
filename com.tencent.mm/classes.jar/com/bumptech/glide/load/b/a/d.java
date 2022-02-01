package com.bumptech.glide.load.b.a;

import com.bumptech.glide.g.k;
import java.util.Queue;

abstract class d<T extends m>
{
  private final Queue<T> aIn = k.ds(20);
  
  public final void a(T paramT)
  {
    if (this.aIn.size() < 20) {
      this.aIn.offer(paramT);
    }
  }
  
  abstract T pc();
  
  final T pd()
  {
    m localm2 = (m)this.aIn.poll();
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = pc();
    }
    return localm1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.d
 * JD-Core Version:    0.7.0.1
 */
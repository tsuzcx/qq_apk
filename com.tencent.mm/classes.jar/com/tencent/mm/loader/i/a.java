package com.tencent.mm.loader.i;

import java.util.concurrent.LinkedBlockingDeque;

public final class a<E>
  extends LinkedBlockingDeque<E>
{
  public final boolean offer(E paramE)
  {
    return super.offerFirst(paramE);
  }
  
  public final E remove()
  {
    return super.removeFirst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.i.a
 * JD-Core Version:    0.7.0.1
 */
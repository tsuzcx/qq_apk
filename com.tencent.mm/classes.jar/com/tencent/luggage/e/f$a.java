package com.tencent.luggage.e;

import java.util.LinkedList;

final class f$a<E>
  extends LinkedList<E>
{
  private f$a(f paramf) {}
  
  public final E pop()
  {
    Object localObject = super.pop();
    this.biA.qi();
    return localObject;
  }
  
  public final void push(E paramE)
  {
    super.push(paramE);
    this.biA.qh();
  }
  
  public final E remove(int paramInt)
  {
    Object localObject = super.remove(paramInt);
    this.biA.qi();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.e.f.a
 * JD-Core Version:    0.7.0.1
 */
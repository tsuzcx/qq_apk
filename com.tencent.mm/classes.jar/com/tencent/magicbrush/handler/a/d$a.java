package com.tencent.magicbrush.handler.a;

import java.util.LinkedList;
import java.util.Queue;

public final class d$a
{
  public Queue<d.b> bkK = new LinkedList();
  
  public final void a(d.b paramb)
  {
    this.bkK.offer(paramb);
  }
  
  public final d.b qL()
  {
    d.b localb2 = (d.b)this.bkK.poll();
    d.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new d.b();
    }
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.d.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.game.c;

import java.util.Iterator;
import java.util.Queue;

public final class d$1
  implements Runnable
{
  public d$1(d paramd) {}
  
  public final void run()
  {
    Iterator localIterator = d.a(this.gbn).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      d.b(this.gbn).tn(str);
    }
    d.a(this.gbn).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.d.1
 * JD-Core Version:    0.7.0.1
 */
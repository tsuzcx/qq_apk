package com.tencent.mm.plugin.game.model;

import java.util.Iterator;
import java.util.Set;

final class k$2
  implements Runnable
{
  k$2(k paramk, int paramInt, String paramString) {}
  
  public final void run()
  {
    synchronized ()
    {
      Iterator localIterator = k.aZj().iterator();
      if (localIterator.hasNext()) {
        ((k.a)localIterator.next()).f(this.val$event, this.val$packageName, this.kOI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k.2
 * JD-Core Version:    0.7.0.1
 */
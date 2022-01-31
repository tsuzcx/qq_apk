package com.tencent.mm.plugin.appbrand;

import java.util.concurrent.ConcurrentLinkedQueue;

final class i$9
  implements i.a
{
  i$9(i parami, ConcurrentLinkedQueue paramConcurrentLinkedQueue, i.b paramb, i.a parama) {}
  
  public final void done()
  {
    this.fyQ.remove(this.fyR);
    if (this.fyQ.isEmpty()) {
      this.fyS.done();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.9
 * JD-Core Version:    0.7.0.1
 */
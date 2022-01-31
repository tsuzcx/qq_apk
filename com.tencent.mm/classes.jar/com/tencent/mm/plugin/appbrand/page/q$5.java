package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.e.e;
import java.util.Collection;
import java.util.Iterator;

final class q$5
  implements Runnable
{
  q$5(q paramq) {}
  
  public final void run()
  {
    Iterator localIterator = q.j(this.gTY).iterator();
    while (localIterator.hasNext()) {
      ((e.e)localIterator.next()).onReady();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.5
 * JD-Core Version:    0.7.0.1
 */
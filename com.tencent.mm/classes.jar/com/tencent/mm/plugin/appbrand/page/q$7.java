package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import java.util.Iterator;
import java.util.Set;

final class q$7
  implements Runnable
{
  q$7(q paramq) {}
  
  public final void run()
  {
    Iterator localIterator = q.l(this.gTY).iterator();
    while (localIterator.hasNext()) {
      ((e.b)localIterator.next()).qa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.7
 * JD-Core Version:    0.7.0.1
 */
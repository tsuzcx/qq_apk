package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import java.util.Iterator;
import java.util.Set;

final class q$8
  implements Runnable
{
  q$8(q paramq) {}
  
  public final void run()
  {
    Iterator localIterator = q.m(this.gTY).iterator();
    while (localIterator.hasNext()) {
      ((e.c)localIterator.next()).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.8
 * JD-Core Version:    0.7.0.1
 */
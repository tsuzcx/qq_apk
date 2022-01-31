package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;

final class q$27
  implements Runnable
{
  q$27(q paramq) {}
  
  public final void run()
  {
    h localh = new h();
    q localq = this.gTY;
    o localo = q.d(this.gTY).Zy();
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", localq.getURL());
    localh.o(localHashMap).a(localo, localq.hashCode()).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.27
 * JD-Core Version:    0.7.0.1
 */
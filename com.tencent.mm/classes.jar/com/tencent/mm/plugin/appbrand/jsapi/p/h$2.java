package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.v.g.a;
import java.util.List;

final class h$2
  implements g.a
{
  h$2(h paramh) {}
  
  public final boolean i(Object... arg1)
  {
    synchronized (h.a(this.gBj))
    {
      if (h.a(this.gBj).isEmpty()) {
        return false;
      }
      h.b(this.gBj).run();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.h.2
 * JD-Core Version:    0.7.0.1
 */
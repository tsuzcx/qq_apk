package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.i;
import java.util.Map;

final class aq$2
  extends g.b
{
  aq$2(aq paramaq, i parami) {}
  
  public final void onDestroy()
  {
    g.b(aq.a(this.fEz), this);
    synchronized (aq.aco())
    {
      aq.aco().remove(this.fAy);
      aq.b(this.fEz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq.2
 * JD-Core Version:    0.7.0.1
 */
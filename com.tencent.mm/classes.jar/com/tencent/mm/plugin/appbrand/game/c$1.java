package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.v.l.1;
import java.net.MalformedURLException;
import java.net.URL;

final class c$1
  implements Runnable
{
  c$1(c paramc, long paramLong) {}
  
  public final void run()
  {
    if (this.fZR.getRuntime() != null) {
      this.fZR.getRuntime().fzG.n(14, System.currentTimeMillis() - this.fZQ);
    }
    c.a(this.fZR, System.currentTimeMillis());
    Object localObject2;
    Object localObject1;
    if ((this.fZR.getRuntime() != null) && (this.fZR.getRuntime().aah()))
    {
      c.a(this.fZR);
      localObject2 = c.b(this.fZR);
      localObject1 = this.fZR.agc();
      localObject2 = (i)((f)localObject2).I(i.class);
      if (localObject2 != null) {
        ((i)localObject2).aP(new l.1((b)localObject1));
      }
      localObject1 = (i)c.b(this.fZR).I(i.class);
      if (localObject1 != null) {
        ((i)localObject1).tp("xdebug");
      }
      if (c.c(this.fZR)) {
        localObject1 = c.b(this.fZR);
      }
    }
    try
    {
      localObject2 = new URL("https://usr/" + "break.js");
      ((f)localObject1).a((URL)localObject2, "breakprogram();", null);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label206:
      break label206;
    }
    c.d(this.fZR);
    if (this.fZR.getRuntime() != null) {
      this.fZR.getRuntime().fzG.n(10, System.currentTimeMillis() - c.e(this.fZR));
    }
    c.f(this.fZR);
    if (!c.g(this.fZR)) {
      c.h(this.fZR);
    }
    c.i(this.fZR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.1
 * JD-Core Version:    0.7.0.1
 */
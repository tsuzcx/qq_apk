package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.o.o;
import java.util.Map;

final class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1) {}
  
  public final void run()
  {
    synchronized (this.gxE.gxD.gxA)
    {
      if (!this.gxE.gxD.gxA.containsKey(h.k(this.gxE.gpS, this.gxE.gxB)))
      {
        c.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
        return;
      }
      o.gRH.a(this.gxE.gxC);
      this.gxE.gxD.gxA.remove(h.k(this.gxE.gpS, this.gxE.gxB));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h.1.1
 * JD-Core Version:    0.7.0.1
 */
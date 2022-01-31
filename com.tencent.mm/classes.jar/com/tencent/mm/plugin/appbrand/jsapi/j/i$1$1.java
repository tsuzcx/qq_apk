package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.p;
import java.util.Map;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(108061);
    synchronized (this.hUf.hUe.gRJ)
    {
      if (!this.hUf.hUe.gRJ.containsKey(i.k(this.hUf.hKB, this.hUf.hUc)))
      {
        d.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
        AppMethodBeat.o(108061);
        return;
      }
      p.itw.a(this.hUf.hUd);
      this.hUf.hUe.gRJ.remove(i.k(this.hUf.hKB, this.hUf.hUc));
      AppMethodBeat.o(108061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i.1.1
 * JD-Core Version:    0.7.0.1
 */
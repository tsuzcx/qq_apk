package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.r;
import org.json.JSONObject;

final class g$1
  implements Runnable
{
  g$1(g paramg, d paramd, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(141749);
    r localr = this.hVN.getRuntime().atj();
    if (localr.getPageCount() <= 1)
    {
      this.hVN.h(this.bAX, this.hVO.j("fail cannot navigate back at first page", null));
      AppMethodBeat.o(141749);
      return;
    }
    localr.pa(this.bBa.optInt("delta", 1));
    this.hVN.h(this.bAX, this.hVO.j("ok", null));
    AppMethodBeat.o(141749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.g.1
 * JD-Core Version:    0.7.0.1
 */
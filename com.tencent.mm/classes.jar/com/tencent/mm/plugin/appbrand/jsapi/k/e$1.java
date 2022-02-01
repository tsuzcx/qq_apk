package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, q paramq, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138219);
    r localr = this.bZx.getRuntime().aSA().getCurrentPage();
    if (!(localr instanceof k))
    {
      this.bZx.h(this.bZy, this.kFd.e("fail:not TabBar page", null));
      AppMethodBeat.o(138219);
      return;
    }
    ((k)localr).getTabBar().dT(this.bZB.optBoolean("animation", true));
    this.bZx.h(this.bZy, this.kFd.e("ok", null));
    AppMethodBeat.o(138219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.e.1
 * JD-Core Version:    0.7.0.1
 */
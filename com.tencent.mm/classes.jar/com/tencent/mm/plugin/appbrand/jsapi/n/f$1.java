package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import org.json.JSONObject;

final class f$1
  implements Runnable
{
  f$1(f paramf, q paramq, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138219);
    r localr = this.cjP.getRuntime().aVN().getCurrentPage();
    if (!(localr instanceof k))
    {
      this.cjP.h(this.cjQ, this.lbp.e("fail:not TabBar page", null));
      AppMethodBeat.o(138219);
      return;
    }
    ((k)localr).getTabBar().dV(this.cjT.optBoolean("animation", true));
    this.cjP.h(this.cjQ, this.lbp.e("ok", null));
    AppMethodBeat.o(138219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.f.1
 * JD-Core Version:    0.7.0.1
 */
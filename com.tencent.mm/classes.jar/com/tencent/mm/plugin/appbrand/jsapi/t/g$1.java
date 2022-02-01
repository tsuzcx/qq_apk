package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.y;
import org.json.JSONObject;

final class g$1
  implements Runnable
{
  g$1(g paramg, y paramy, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138219);
    u localu = this.elY.getRuntime().getPageContainer().getCurrentPage();
    if (!(localu instanceof n))
    {
      this.elY.callback(this.elZ, this.snN.ZP("fail:not TabBar page"));
      AppMethodBeat.o(138219);
      return;
    }
    ((n)localu).getTabBar().gc(this.ejE.optBoolean("animation", true));
    this.elY.callback(this.elZ, this.snN.ZP("ok"));
    AppMethodBeat.o(138219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.g.1
 * JD-Core Version:    0.7.0.1
 */
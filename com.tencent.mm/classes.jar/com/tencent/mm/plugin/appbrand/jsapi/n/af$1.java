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

final class af$1
  implements Runnable
{
  af$1(af paramaf, q paramq, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138248);
    r localr = this.cjP.getRuntime().aVN().getCurrentPage();
    if (!(localr instanceof k))
    {
      this.cjP.h(this.cjQ, this.lcq.e("fail:not TabBar page", null));
      AppMethodBeat.o(138248);
      return;
    }
    ((k)localr).getTabBar().aF(this.cjT.optBoolean("animation", true));
    this.cjP.h(this.cjQ, this.lcq.e("ok", null));
    AppMethodBeat.o(138248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.af.1
 * JD-Core Version:    0.7.0.1
 */
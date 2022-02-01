package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import org.json.JSONObject;

final class af$1
  implements Runnable
{
  af$1(af paramaf, r paramr, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138248);
    q localq = this.cjR.getRuntime().aWm().getCurrentPage();
    if (!(localq instanceof j))
    {
      this.cjR.h(this.cjS, this.lgb.e("fail:not TabBar page", null));
      AppMethodBeat.o(138248);
      return;
    }
    ((j)localq).getTabBar().aF(this.cjV.optBoolean("animation", true));
    this.cjR.h(this.cjS, this.lgb.e("ok", null));
    AppMethodBeat.o(138248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.af.1
 * JD-Core Version:    0.7.0.1
 */
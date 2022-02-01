package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, com.tencent.mm.plugin.appbrand.q paramq, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138219);
    com.tencent.mm.plugin.appbrand.page.q localq = this.ccA.getRuntime().aLK().getCurrentPage();
    if (!(localq instanceof j))
    {
      this.ccA.h(this.ccB, this.kel.e("fail:not TabBar page", null));
      AppMethodBeat.o(138219);
      return;
    }
    ((j)localq).getTabBar().hH(this.ccE.optBoolean("animation", true));
    this.ccA.h(this.ccB, this.kel.e("ok", null));
    AppMethodBeat.o(138219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.e.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import org.json.JSONObject;

final class ad$1
  implements Runnable
{
  ad$1(ad paramad, com.tencent.mm.plugin.appbrand.q paramq, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(138248);
    com.tencent.mm.plugin.appbrand.page.q localq = this.ccA.getRuntime().aLK().getCurrentPage();
    if (!(localq instanceof j))
    {
      this.ccA.h(this.ccB, this.kfk.e("fail:not TabBar page", null));
      AppMethodBeat.o(138248);
      return;
    }
    ((j)localq).getTabBar().aF(this.ccE.optBoolean("animation", true));
    this.ccA.h(this.ccB, this.kfk.e("ok", null));
    AppMethodBeat.o(138248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.ad.1
 * JD-Core Version:    0.7.0.1
 */
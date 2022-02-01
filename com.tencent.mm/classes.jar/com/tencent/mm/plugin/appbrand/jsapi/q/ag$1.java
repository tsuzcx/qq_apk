package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;

final class ag$1
  implements Runnable
{
  ag$1(ag paramag, v paramv, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(138244);
    u localu = this.cue.getRuntime().bBX().getCurrentPage();
    if (!(localu instanceof n))
    {
      this.cue.j(this.cuf, this.pjx.h("fail:not TabBar page", null));
      AppMethodBeat.o(138244);
      return;
    }
    ((n)localu).getTabBar().m(this.pjt, this.pju, this.pjv, this.pjw);
    this.cue.j(this.cuf, this.pjx.h("ok", null));
    AppMethodBeat.o(138244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.ag.1
 * JD-Core Version:    0.7.0.1
 */
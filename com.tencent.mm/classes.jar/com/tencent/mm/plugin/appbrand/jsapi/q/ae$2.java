package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;

final class ae$2
  implements Runnable
{
  ae$2(ae paramae, v paramv, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(138238);
    u localu = this.cue.getRuntime().bBX().getCurrentPage();
    if (!(localu instanceof n))
    {
      this.cue.j(this.cuf, this.pjk.h("fail:not TabBar page", null));
      AppMethodBeat.o(138238);
      return;
    }
    ((n)localu).getTabBar().e(this.val$index, this.cFU, this.pjl, this.pjm, this.pjn);
    this.cue.j(this.cuf, this.pjk.h("ok", null));
    AppMethodBeat.o(138238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.ae.2
 * JD-Core Version:    0.7.0.1
 */
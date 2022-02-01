package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;

final class aa$2
  implements Runnable
{
  aa$2(aa paramaa, q paramq, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(138238);
    r localr = this.cjP.getRuntime().aVN().getCurrentPage();
    if (!(localr instanceof k))
    {
      this.cjP.h(this.cjQ, this.lbX.e("fail:not TabBar page", null));
      AppMethodBeat.o(138238);
      return;
    }
    ((k)localr).getTabBar().d(this.val$index, this.lbY, this.lbZ, this.lca, this.lcb);
    this.cjP.h(this.cjQ, this.lbX.e("ok", null));
    AppMethodBeat.o(138238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.aa.2
 * JD-Core Version:    0.7.0.1
 */
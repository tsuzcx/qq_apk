package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;

final class aa$2
  implements Runnable
{
  aa$2(aa paramaa, r paramr, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(138238);
    q localq = this.cjR.getRuntime().aWm().getCurrentPage();
    if (!(localq instanceof j))
    {
      this.cjR.h(this.cjS, this.lfI.e("fail:not TabBar page", null));
      AppMethodBeat.o(138238);
      return;
    }
    ((j)localq).getTabBar().d(this.val$index, this.lfJ, this.lfK, this.lfL, this.lfM);
    this.cjR.h(this.cjS, this.lfI.e("ok", null));
    AppMethodBeat.o(138238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.aa.2
 * JD-Core Version:    0.7.0.1
 */
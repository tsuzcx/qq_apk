package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.f;
import java.util.LinkedList;

final class ab$1
  implements Runnable
{
  ab$1(ab paramab, q paramq, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138242);
    Object localObject = this.cjP.getRuntime().aVN().getCurrentPage();
    if (!(localObject instanceof k))
    {
      this.cjP.h(this.cjQ, this.lce.e("fail:not TabBar page", null));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((k)localObject).getTabBar();
    d locald1 = ((a)localObject).npn.a(this.lcc, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.lcf.a(ab.1.this.val$index, ab.1.this.val$text, (d)((Pair)this.lcf.npt.get(ab.1.this.val$index)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.cjP, this.val$index);
    d locald2 = ((a)localObject).npn.a(this.lcd, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.lcf.a(ab.1.this.val$index, ab.1.this.val$text, null, (d)((Pair)this.lcf.npt.get(ab.1.this.val$index)).second);
        AppMethodBeat.o(138241);
      }
    }, this.cjP, this.val$index);
    ((a)localObject).a(this.val$index, this.val$text, locald1, locald2);
    this.cjP.h(this.cjQ, this.lce.e("ok", null));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.ab.1
 * JD-Core Version:    0.7.0.1
 */
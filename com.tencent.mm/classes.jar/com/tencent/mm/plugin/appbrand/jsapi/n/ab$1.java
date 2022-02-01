package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.f;
import java.util.LinkedList;

final class ab$1
  implements Runnable
{
  ab$1(ab paramab, r paramr, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138242);
    Object localObject = this.cjR.getRuntime().aWm().getCurrentPage();
    if (!(localObject instanceof j))
    {
      this.cjR.h(this.cjS, this.lfP.e("fail:not TabBar page", null));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((j)localObject).getTabBar();
    d locald1 = ((a)localObject).nux.a(this.lfN, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.lfQ.a(ab.1.this.val$index, ab.1.this.val$text, (d)((Pair)this.lfQ.nuD.get(ab.1.this.val$index)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.cjR, this.val$index);
    d locald2 = ((a)localObject).nux.a(this.lfO, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.lfQ.a(ab.1.this.val$index, ab.1.this.val$text, null, (d)((Pair)this.lfQ.nuD.get(ab.1.this.val$index)).second);
        AppMethodBeat.o(138241);
      }
    }, this.cjR, this.val$index);
    ((a)localObject).a(this.val$index, this.val$text, locald1, locald2);
    this.cjR.h(this.cjS, this.lfP.e("ok", null));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.ab.1
 * JD-Core Version:    0.7.0.1
 */
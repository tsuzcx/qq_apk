package com.tencent.mm.plugin.appbrand.jsapi.k;

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

final class z$1
  implements Runnable
{
  z$1(z paramz, q paramq, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138242);
    Object localObject = this.bZx.getRuntime().aSA().getCurrentPage();
    if (!(localObject instanceof k))
    {
      this.bZx.h(this.bZy, this.kFO.e("fail:not TabBar page", null));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((k)localObject).getTabBar();
    d locald1 = ((a)localObject).mOQ.a(this.kFM, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.kFP.a(z.1.this.hNp, z.1.this.fLm, (d)((Pair)this.kFP.mOW.get(z.1.this.hNp)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.bZx, this.hNp);
    d locald2 = ((a)localObject).mOQ.a(this.kFN, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.kFP.a(z.1.this.hNp, z.1.this.fLm, null, (d)((Pair)this.kFP.mOW.get(z.1.this.hNp)).second);
        AppMethodBeat.o(138241);
      }
    }, this.bZx, this.hNp);
    ((a)localObject).a(this.hNp, this.fLm, locald1, locald2);
    this.bZx.h(this.bZy, this.kFO.e("ok", null));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.z.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.t;
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
    Object localObject = this.ccA.getRuntime().aLK().getCurrentPage();
    if (!(localObject instanceof j))
    {
      this.ccA.h(this.ccB, this.keY.e("fail:not TabBar page", null));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((j)localObject).getTabBar();
    d locald1 = ((a)localObject).mmP.a(this.keW, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.keZ.a(z.1.this.hmM, z.1.this.fHG, (d)((Pair)this.keZ.mmV.get(z.1.this.hmM)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.ccA, this.hmM);
    d locald2 = ((a)localObject).mmP.a(this.keX, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.keZ.a(z.1.this.hmM, z.1.this.fHG, null, (d)((Pair)this.keZ.mmV.get(z.1.this.hmM)).second);
        AppMethodBeat.o(138241);
      }
    }, this.ccA, this.hmM);
    ((a)localObject).a(this.hmM, this.fHG, locald1, locald2);
    this.ccA.h(this.ccB, this.keY.e("ok", null));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.z.1
 * JD-Core Version:    0.7.0.1
 */
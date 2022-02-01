package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.f;
import com.tencent.mm.plugin.appbrand.y;
import java.util.LinkedList;

final class af$1
  implements Runnable
{
  af$1(af paramaf, y paramy, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138242);
    Object localObject = this.elY.getRuntime().getPageContainer().getCurrentPage();
    if (!(localObject instanceof n))
    {
      this.elY.callback(this.elZ, this.sow.ZP("fail:not TabBar page"));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((n)localObject).getTabBar();
    d locald1 = ((a)localObject).uRx.a(this.sou, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.sox.a(af.1.this.val$index, af.1.this.val$text, (d)((Pair)this.sox.uRD.get(af.1.this.val$index)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.elY, this.val$index);
    d locald2 = ((a)localObject).uRx.a(this.sov, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.sox.a(af.1.this.val$index, af.1.this.val$text, null, (d)((Pair)this.sox.uRD.get(af.1.this.val$index)).second);
        AppMethodBeat.o(138241);
      }
    }, this.elY, this.val$index);
    ((a)localObject).a(this.val$index, this.val$text, locald1, locald2);
    this.elY.callback(this.elZ, this.sow.ZP("ok"));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.af.1
 * JD-Core Version:    0.7.0.1
 */
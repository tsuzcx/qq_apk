package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.f;
import java.util.LinkedList;

final class af$1
  implements Runnable
{
  af$1(af paramaf, v paramv, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(138242);
    Object localObject = this.cue.getRuntime().bBX().getCurrentPage();
    if (!(localObject instanceof n))
    {
      this.cue.j(this.cuf, this.pjq.h("fail:not TabBar page", null));
      AppMethodBeat.o(138242);
      return;
    }
    localObject = ((n)localObject).getTabBar();
    d locald1 = ((a)localObject).rGl.a(this.pjo, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138240);
        super.a(paramAnonymousString, paramAnonymousd);
        this.pjr.a(af.1.this.val$index, af.1.this.val$text, (d)((Pair)this.pjr.rGr.get(af.1.this.val$index)).first, null);
        AppMethodBeat.o(138240);
      }
    }, this.cue, this.val$index);
    d locald2 = ((a)localObject).rGl.a(this.pjp, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(138241);
        super.a(paramAnonymousString, paramAnonymousd);
        this.pjr.a(af.1.this.val$index, af.1.this.val$text, null, (d)((Pair)this.pjr.rGr.get(af.1.this.val$index)).second);
        AppMethodBeat.o(138241);
      }
    }, this.cue, this.val$index);
    ((a)localObject).a(this.val$index, this.val$text, locald1, locald2);
    this.cue.j(this.cuf, this.pjq.h("ok", null));
    AppMethodBeat.o(138242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.af.1
 * JD-Core Version:    0.7.0.1
 */
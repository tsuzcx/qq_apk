package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$3"})
final class c$f$c
  implements n.d
{
  c$f$c(c.f paramf, b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(143800);
    j.p(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramMenuItem = g.cT(b.a.hQk);
    }
    for (;;)
    {
      paramMenuItem.b((a)new c.f.c.1(this));
      AppMethodBeat.o(143800);
      return;
      paramMenuItem = c.c(this.hQv.hQs);
      continue;
      paramMenuItem = c.d(this.hQv.hQs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.f.c
 * JD-Core Version:    0.7.0.1
 */
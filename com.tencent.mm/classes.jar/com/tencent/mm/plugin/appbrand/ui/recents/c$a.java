package com.tencent.mm.plugin.appbrand.ui.recents;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a
  implements Runnable
{
  c$a(c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(135128);
    AppBrandNearbyShowcaseView localAppBrandNearbyShowcaseView = this.iSo.iSt;
    j.p(localAppBrandNearbyShowcaseView, "mShowcaseView");
    if (this.iSn) {}
    for (int i = 0;; i = 8)
    {
      localAppBrandNearbyShowcaseView.setVisibility(i);
      AppMethodBeat.o(135128);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class AppBrandProfileUI$2
  implements n.c
{
  AppBrandProfileUI$2(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(133026);
    paraml.clear();
    if (((af)g.E(af.class)).aC(AppBrandProfileUI.d(this.iOj), 0)) {}
    for (int i = 2131296874;; i = 2131296871)
    {
      paraml.hx(4, i);
      paraml.hx(2, 2131296584);
      if ((AppBrandProfileUI.e(this.iOj) != null) && (AppBrandProfileUI.e(this.iOj).bDd == 0)) {
        paraml.hx(5, 2131296805);
      }
      AppMethodBeat.o(133026);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecentAppBrandView$a$1
  implements View.OnClickListener
{
  RecentAppBrandView$a$1(RecentAppBrandView.a parama, e parame, AppBrandDesktopView.c paramc, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133931);
    if (RecentAppBrandView.c(this.jgg.jgf) != null) {
      RecentAppBrandView.c(this.jgg.jgf).a(this.jfn, this.jfm);
    }
    AppMethodBeat.o(133931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.a.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$e$1
  implements RecentAppBrandView.b
{
  AppBrandDesktopView$e$1(AppBrandDesktopView.e parame) {}
  
  public final void a(RecyclerView.v paramv, AppBrandDesktopView.c paramc)
  {
    AppMethodBeat.i(154872);
    AppBrandDesktopView.w(this.jfl.jfg);
    AppBrandDesktopView.x(this.jfl.jfg);
    AppBrandDesktopView.y(this.jfl.jfg);
    this.jfl.jfg.setLayoutFrozen(true);
    if (paramc != null) {
      AppBrandDesktopView.a(this.jfl.jfg, 1089, 2, paramc.jfk, paramv.jN());
    }
    AppMethodBeat.o(154872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.1
 * JD-Core Version:    0.7.0.1
 */
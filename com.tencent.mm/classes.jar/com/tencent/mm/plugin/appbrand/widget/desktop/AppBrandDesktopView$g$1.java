package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopView$g$1
  implements View.OnClickListener
{
  AppBrandDesktopView$g$1(AppBrandDesktopView.g paramg, AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133851);
    AppBrandDesktopView.w(this.jfr.jfg);
    AppBrandDesktopView.x(this.jfr.jfg);
    AppBrandDesktopView.y(this.jfr.jfg);
    paramView = this.jfr.jfg;
    if ((paramView.jbP != null) && (paramView.jeL))
    {
      DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = (DynamicBackgroundGLSurfaceView)paramView.jbP.getBackgroundGLSurfaceView();
      if (localDynamicBackgroundGLSurfaceView != null)
      {
        localDynamicBackgroundGLSurfaceView.jhg.onPause();
        paramView.jeP = true;
        paramView.jeV = true;
      }
    }
    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
    long l = System.currentTimeMillis();
    if ((AppBrandDesktopView.c(this.jfr.jfg) != null) && ((AppBrandDesktopView.g.a(this.jfr) == 0L) || (l - AppBrandDesktopView.g.a(this.jfr) > 1000L)))
    {
      AppBrandDesktopView.g.a(this.jfr, l);
      paramView = AppBrandDesktopView.c(this.jfr.jfg);
      paramView.juU += 1;
      ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramView.juU) });
    }
    paramView = (j)g.E(j.class);
    if (paramView != null) {
      paramView.ad(AppBrandDesktopView.j(this.jfr.jfg), 42);
    }
    AppMethodBeat.o(133851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.g.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class AppBrandDesktopView$g
  extends RecyclerView.v
{
  protected EditText lVu;
  private long lVv;
  
  public AppBrandDesktopView$g(final AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49596);
    this.lVv = 0L;
    this.lVu = ((EditText)paramView.findViewById(2131296709));
    if (this.lVu != null)
    {
      this.lVu.setFocusable(false);
      this.lVu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(49595);
          AppBrandDesktopView.v(AppBrandDesktopView.g.this.lVl);
          AppBrandDesktopView.w(AppBrandDesktopView.g.this.lVl);
          AppBrandDesktopView.x(AppBrandDesktopView.g.this.lVl);
          paramAnonymousView = AppBrandDesktopView.g.this.lVl;
          if ((paramAnonymousView.lRJ != null) && (paramAnonymousView.lUP))
          {
            DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = (DynamicBackgroundGLSurfaceView)paramAnonymousView.lRJ.getBackgroundGLSurfaceView();
            if (localDynamicBackgroundGLSurfaceView != null)
            {
              localDynamicBackgroundGLSurfaceView.onPause();
              paramAnonymousView.lUT = true;
              paramAnonymousView.lUZ = true;
            }
          }
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
          long l = System.currentTimeMillis();
          if ((AppBrandDesktopView.b(AppBrandDesktopView.g.this.lVl) != null) && ((AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) == 0L) || (l - AppBrandDesktopView.g.a(AppBrandDesktopView.g.this) > 1000L)))
          {
            AppBrandDesktopView.g.a(AppBrandDesktopView.g.this, l);
            paramAnonymousView = AppBrandDesktopView.b(AppBrandDesktopView.g.this.lVl);
            paramAnonymousView.mle += 1;
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", new Object[] { Integer.valueOf(paramAnonymousView.mle) });
          }
          paramAnonymousView = (com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.a(AppBrandDesktopView.i(AppBrandDesktopView.g.this.lVl), 42, AppBrandDesktopView.E(AppBrandDesktopView.g.this.lVl), "");
          }
          AppMethodBeat.o(49595);
        }
      });
    }
    AppMethodBeat.o(49596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.g
 * JD-Core Version:    0.7.0.1
 */
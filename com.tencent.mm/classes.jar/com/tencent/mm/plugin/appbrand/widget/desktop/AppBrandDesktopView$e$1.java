package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopView$e$1
  implements View.OnClickListener
{
  AppBrandDesktopView$e$1(AppBrandDesktopView.e parame, AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppBrandDesktopView.d(this.hqA.hqv).startActivity(((com.tencent.mm.plugin.appbrand.r.g)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.g.class)).cd(AppBrandDesktopView.d(this.hqA.hqv)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e.1
 * JD-Core Version:    0.7.0.1
 */
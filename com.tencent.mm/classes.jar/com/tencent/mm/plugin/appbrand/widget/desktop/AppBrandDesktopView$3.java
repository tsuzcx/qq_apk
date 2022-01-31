package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;

final class AppBrandDesktopView$3
  implements Runnable
{
  AppBrandDesktopView$3(AppBrandDesktopView paramAppBrandDesktopView, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(143652);
    ((DynamicBackgroundGLSurfaceView)this.jfh).setShowGradientView(false);
    AppMethodBeat.o(143652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.3
 * JD-Core Version:    0.7.0.1
 */
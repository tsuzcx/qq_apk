package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class AppBrandDesktopHalfItemView$3
  implements Runnable
{
  AppBrandDesktopHalfItemView$3(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void run()
  {
    AppMethodBeat.i(134127);
    if (AppBrandDesktopHalfItemView.g(this.jhV) != null)
    {
      AppBrandDesktopHalfItemView.a locala = AppBrandDesktopHalfItemView.g(this.jhV);
      if ((locala.jhX != null) && (locala.jhX.aku != null) && ((locala.jhX instanceof BaseAppBrandRecentView.c)) && (((BaseAppBrandRecentView.c)locala.jhX).jft != null)) {
        ((BaseAppBrandRecentView.c)locala.jhX).jft.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setListener(null).setDuration(150L).withEndAction(new AppBrandDesktopHalfItemView.a.1(locala)).start();
      }
    }
    AppMethodBeat.o(134127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.3
 * JD-Core Version:    0.7.0.1
 */
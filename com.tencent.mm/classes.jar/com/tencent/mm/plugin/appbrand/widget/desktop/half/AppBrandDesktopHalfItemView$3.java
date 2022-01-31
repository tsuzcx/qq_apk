package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class AppBrandDesktopHalfItemView$3
  implements Runnable
{
  AppBrandDesktopHalfItemView$3(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void run()
  {
    if (AppBrandDesktopHalfItemView.g(this.hry) != null)
    {
      AppBrandDesktopHalfItemView.a locala = AppBrandDesktopHalfItemView.g(this.hry);
      if ((locala.hrA != null) && (locala.hrA.aie != null) && ((locala.hrA instanceof BaseAppBrandRecentView.c)) && (((BaseAppBrandRecentView.c)locala.hrA).hCT != null)) {
        ((BaseAppBrandRecentView.c)locala.hrA).hCT.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setListener(null).setDuration(150L).withEndAction(new AppBrandDesktopHalfItemView.a.1(locala)).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.3
 * JD-Core Version:    0.7.0.1
 */
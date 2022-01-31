package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class AppBrandDesktopHalfItemView$a$1
  implements Runnable
{
  AppBrandDesktopHalfItemView$a$1(AppBrandDesktopHalfItemView.a parama) {}
  
  public final void run()
  {
    if ((this.hrB.hrA != null) && (((BaseAppBrandRecentView.c)this.hrB.hrA).hCT != null)) {
      ((BaseAppBrandRecentView.c)this.hrB.hrA).hCT.animate().scaleX(1.0F).scaleY(1.0F).setListener(AppBrandDesktopHalfItemView.k(this.hrB.hry)).setDuration(150L).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.a.1
 * JD-Core Version:    0.7.0.1
 */
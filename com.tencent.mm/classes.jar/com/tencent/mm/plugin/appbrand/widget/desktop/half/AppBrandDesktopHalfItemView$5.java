package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;

final class AppBrandDesktopHalfItemView$5
  implements View.OnClickListener
{
  AppBrandDesktopHalfItemView$5(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void onClick(View paramView)
  {
    if (AppBrandDesktopHalfItemView.a(this.hry) == AppBrandRecentView.f.hBY)
    {
      ((f)g.r(f.class)).cc(this.hry.getContext());
      if (AppBrandDesktopHalfItemView.b(this.hry) != null) {
        AppBrandDesktopHalfItemView.b(this.hry).arD();
      }
    }
    do
    {
      do
      {
        return;
      } while (AppBrandDesktopHalfItemView.a(this.hry) != AppBrandRecentView.f.hBX);
      ((f)g.r(f.class)).cb(this.hry.getContext());
    } while (AppBrandDesktopHalfItemView.b(this.hry) == null);
    AppBrandDesktopHalfItemView.b(this.hry).arE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.5
 * JD-Core Version:    0.7.0.1
 */
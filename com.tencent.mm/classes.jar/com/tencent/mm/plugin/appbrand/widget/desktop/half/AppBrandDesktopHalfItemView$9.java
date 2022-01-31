package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;

final class AppBrandDesktopHalfItemView$9
  implements AppBrandRecentView.b
{
  AppBrandDesktopHalfItemView$9(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134133);
    if (AppBrandDesktopHalfItemView.e(this.jhV) != null)
    {
      boolean bool = AppBrandDesktopHalfItemView.e(this.jhV).a(paramView, parama, paramFloat1, paramFloat2);
      AppMethodBeat.o(134133);
      return bool;
    }
    AppMethodBeat.o(134133);
    return false;
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134134);
    if (AppBrandDesktopHalfItemView.e(this.jhV) != null)
    {
      boolean bool = AppBrandDesktopHalfItemView.e(this.jhV).b(paramView, parama, paramFloat1, paramFloat2);
      AppMethodBeat.o(134134);
      return bool;
    }
    AppMethodBeat.o(134134);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.9
 * JD-Core Version:    0.7.0.1
 */
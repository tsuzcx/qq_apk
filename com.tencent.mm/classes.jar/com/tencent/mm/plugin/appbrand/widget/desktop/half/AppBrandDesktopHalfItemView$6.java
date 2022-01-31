package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;

final class AppBrandDesktopHalfItemView$6
  implements View.OnClickListener
{
  AppBrandDesktopHalfItemView$6(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134130);
    if (AppBrandDesktopHalfItemView.a(this.jhV) == AppBrandRecentView.f.jur)
    {
      ((l)g.E(l.class)).cG(this.jhV.getContext());
      if (AppBrandDesktopHalfItemView.b(this.jhV) != null)
      {
        AppBrandDesktopHalfItemView.b(this.jhV).aQn();
        AppMethodBeat.o(134130);
      }
    }
    else if (AppBrandDesktopHalfItemView.a(this.jhV) == AppBrandRecentView.f.juq)
    {
      ((l)g.E(l.class)).D(this.jhV.getContext(), 3);
      if (AppBrandDesktopHalfItemView.b(this.jhV) != null) {
        AppBrandDesktopHalfItemView.b(this.jhV).aQo();
      }
    }
    AppMethodBeat.o(134130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.6
 * JD-Core Version:    0.7.0.1
 */
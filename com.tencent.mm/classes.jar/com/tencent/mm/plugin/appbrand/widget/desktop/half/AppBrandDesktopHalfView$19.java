package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandDesktopHalfView$19
  implements AppBrandRecentView.b
{
  AppBrandDesktopHalfView$19(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134179);
    this.jin.setLayoutFrozen(true);
    if ((AppBrandDesktopHalfView.g(this.jin) != null) && (parama != null) && (parama.jfk != null) && (!bo.isNullOrNil(parama.jfk.appId)))
    {
      AppBrandDesktopHalfView.d(this.jin).getRecentView();
      int i = RecyclerView.bq(paramView);
      if (i != -1)
      {
        AppBrandDesktopHalfView.h(this.jin);
        AppBrandDesktopHalfView.g(this.jin).bC(parama.jfk.appId, i);
      }
      AppBrandDesktopHalfView.i(this.jin);
    }
    AppMethodBeat.o(134179);
    return false;
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.19
 * JD-Core Version:    0.7.0.1
 */
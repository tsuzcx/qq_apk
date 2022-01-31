package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandDesktopHalfView$4
  implements AppBrandRecentView.b
{
  AppBrandDesktopHalfView$4(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134163);
    this.jin.setLayoutFrozen(true);
    if ((AppBrandDesktopHalfView.g(this.jin) != null) && (parama != null) && (parama.jfk != null) && (!bo.isNullOrNil(parama.jfk.appId)))
    {
      AppBrandDesktopHalfView.c(this.jin).getRecentView();
      int i = RecyclerView.bq(paramView);
      if (i != -1)
      {
        AppBrandDesktopHalfView.h(this.jin);
        AppBrandDesktopHalfView.g(this.jin).bD(parama.jfk.appId, i);
      }
      AppBrandDesktopHalfView.i(this.jin);
    }
    AppMethodBeat.o(134163);
    return false;
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.4
 * JD-Core Version:    0.7.0.1
 */
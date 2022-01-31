package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopView$6
  extends RecyclerView.m
{
  AppBrandDesktopView$6(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (AppBrandDesktopView.p(this.hqv))
    {
      AppBrandDesktopView.q(this.hqv);
      if (AppBrandDesktopView.e(this.hqv) != null)
      {
        paramInt1 = AppBrandDesktopView.r(this.hqv) - AppBrandDesktopView.e(this.hqv).gY();
        if ((paramInt1 >= 0) && (paramInt1 < this.hqv.getChildCount()))
        {
          paramInt1 = this.hqv.getChildAt(paramInt1).getTop();
          this.hqv.scrollBy(0, paramInt1);
        }
      }
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    y.i("MicroMsg.MyAppBrandHeader", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(AppBrandDesktopView.m(this.hqv)) });
    if ((!AppBrandDesktopView.f(this.hqv)) && ((AppBrandDesktopView.m(this.hqv)) || (paramInt == 0)))
    {
      AppBrandDesktopView.n(this.hqv);
      AppBrandDesktopView.o(this.hqv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.6
 * JD-Core Version:    0.7.0.1
 */
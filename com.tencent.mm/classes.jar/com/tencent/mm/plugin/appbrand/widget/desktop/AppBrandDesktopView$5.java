package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopView$5
  extends RecyclerView.m
{
  AppBrandDesktopView$5(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156585);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (AppBrandDesktopView.Q(this.jfg))
    {
      AppBrandDesktopView.R(this.jfg);
      if (AppBrandDesktopView.k(this.jfg) != null)
      {
        paramInt1 = AppBrandDesktopView.S(this.jfg) - AppBrandDesktopView.k(this.jfg).it();
        if ((paramInt1 >= 0) && (paramInt1 < this.jfg.getChildCount()))
        {
          paramInt1 = this.jfg.getChildAt(paramInt1).getTop();
          this.jfg.scrollBy(0, paramInt1);
        }
      }
    }
    AppMethodBeat.o(156585);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(156584);
    super.c(paramRecyclerView, paramInt);
    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(AppBrandDesktopView.G(this.jfg)) });
    if ((!AppBrandDesktopView.H(this.jfg)) && (AppBrandDesktopView.G(this.jfg)) && (paramInt == 0))
    {
      AppBrandDesktopView.I(this.jfg);
      AppBrandDesktopView.J(this.jfg);
    }
    if (paramInt == 0)
    {
      if (!AppBrandDesktopView.K(this.jfg)) {
        break label196;
      }
      AppBrandDesktopView.L(this.jfg);
      if ((!AppBrandDesktopView.O(this.jfg)) || (AppBrandDesktopView.P(this.jfg))) {
        break label228;
      }
      if (AppBrandDesktopView.c(this.jfg) != null)
      {
        paramRecyclerView = AppBrandDesktopView.c(this.jfg);
        paramRecyclerView.juT += 1;
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(paramRecyclerView.juT) });
      }
      AppBrandDesktopView.a(this.jfg, true);
    }
    for (;;)
    {
      AppBrandDesktopView.i(this.jfg, paramInt);
      AppMethodBeat.o(156584);
      return;
      label196:
      if ((AppBrandDesktopView.M(this.jfg) != 1) && (AppBrandDesktopView.M(this.jfg) != 2)) {
        break;
      }
      AppBrandDesktopView.N(this.jfg);
      break;
      label228:
      AppBrandDesktopView.a(this.jfg, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.5
 * JD-Core Version:    0.7.0.1
 */
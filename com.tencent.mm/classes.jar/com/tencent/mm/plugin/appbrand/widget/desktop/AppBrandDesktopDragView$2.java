package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.a;

final class AppBrandDesktopDragView$2
  implements a
{
  AppBrandDesktopDragView$2(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final boolean J(RecyclerView.v paramv)
  {
    return paramv.aii == 2;
  }
  
  public final boolean K(RecyclerView.v paramv)
  {
    return (paramv.aii == 1) || (paramv.aii == 2) || (paramv.aii == 7);
  }
  
  public final boolean L(RecyclerView.v paramv)
  {
    return (paramv == null) || (paramv.aii == 2);
  }
  
  public final void a(RecyclerView.v paramv, View paramView)
  {
    AppBrandDesktopDragView.a(this.hpQ, paramv, paramView);
  }
  
  public final View b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    return this.hpQ.a(paramRecyclerView, (e)paramv);
  }
  
  public final void ba(Object paramObject)
  {
    if (((paramObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(this.hpQ) != null)) {
      AppBrandDesktopDragView.a(this.hpQ).bd(paramObject);
    }
  }
  
  public final void c(Object paramObject, boolean paramBoolean)
  {
    if ((paramBoolean) && (AppBrandDesktopDragView.a(this.hpQ) != null)) {
      AppBrandDesktopDragView.a(this.hpQ).bb(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.2
 * JD-Core Version:    0.7.0.1
 */
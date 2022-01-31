package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.a;

final class AppBrandDesktopDragView$4
  implements a
{
  AppBrandDesktopDragView$4(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final boolean J(RecyclerView.v paramv)
  {
    return paramv.aii == 1;
  }
  
  public final boolean K(RecyclerView.v paramv)
  {
    return (paramv.aii == 1) || (paramv.aii == 7);
  }
  
  public final boolean L(RecyclerView.v paramv)
  {
    return false;
  }
  
  public final void a(RecyclerView.v paramv, View paramView) {}
  
  public final View b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    return this.hpQ.a(paramRecyclerView, (e)paramv);
  }
  
  public final void ba(Object paramObject)
  {
    if (((paramObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(this.hpQ) != null)) {
      AppBrandDesktopDragView.a(this.hpQ).bc(paramObject);
    }
  }
  
  public final void c(Object paramObject, boolean paramBoolean)
  {
    if (AppBrandDesktopDragView.a(this.hpQ) != null) {
      AppBrandDesktopDragView.a(this.hpQ).arn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopView$h
  extends GridLayoutManager
{
  public AppBrandDesktopView$h(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new AppBrandDesktopView.g(this.hqv, AppBrandDesktopView.d(this.hqv));
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    try
    {
      super.c(paramo, params);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      y.e("MicroMsg.MyAppBrandHeader", "[onLayoutChildren] IndexOutOfBoundsException!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.h
 * JD-Core Version:    0.7.0.1
 */
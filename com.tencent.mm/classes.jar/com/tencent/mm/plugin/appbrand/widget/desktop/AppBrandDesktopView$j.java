package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class AppBrandDesktopView$j
  extends GridLayoutManager
{
  public AppBrandDesktopView$j(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    super(paramInt, 1);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(49600);
    paramRecyclerView = new AppBrandDesktopView.i(this.lVl, AppBrandDesktopView.i(this.lVl));
    paramRecyclerView.ard = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(49600);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(49599);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(49599);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ad.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
      AppMethodBeat.o(49599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.j
 * JD-Core Version:    0.7.0.1
 */
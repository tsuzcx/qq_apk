package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopView$j
  extends GridLayoutManager
{
  public AppBrandDesktopView$j(AppBrandDesktopView paramAppBrandDesktopView, int paramInt)
  {
    super(paramInt, (byte)0);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(133856);
    paramRecyclerView = new AppBrandDesktopView.i(this.jfg, AppBrandDesktopView.j(this.jfg));
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(133856);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(133855);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(133855);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ab.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
      AppMethodBeat.o(133855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.j
 * JD-Core Version:    0.7.0.1
 */
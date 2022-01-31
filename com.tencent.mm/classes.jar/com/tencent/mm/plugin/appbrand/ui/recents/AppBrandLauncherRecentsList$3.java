package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandLauncherRecentsList$3
  extends LinearLayoutManager
{
  AppBrandLauncherRecentsList$3(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList)
  {
    super(1);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(133332);
    paramRecyclerView = new p(this.iTl.getActivity(), AppBrandLauncherRecentsList.q(this.iTl));
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(133332);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(138699);
    try
    {
      int i = super.b(paramInt, paramo, params);
      AppMethodBeat.o(138699);
      return i;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", paramo, "scrollVerticallyBy(%d, %s)", new Object[] { Integer.valueOf(paramInt), params });
      AppMethodBeat.o(138699);
    }
    return 0;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(133333);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(133333);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren IndexOutOfBoundsException retry notifyDataSetChanged");
      try
      {
        AppBrandLauncherRecentsList.b(this.iTl).ajb.notifyChanged();
        AppMethodBeat.o(133333);
        return;
      }
      catch (IllegalStateException paramo)
      {
        ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged e=%s", new Object[] { paramo });
        if (bo.nullAsNil(paramo.getMessage()).contains("computing a layout or scrolling"))
        {
          paramo = new AppBrandLauncherRecentsList.3.1(this);
          AppBrandLauncherRecentsList.e(this.iTl).sendMessage(AppBrandLauncherRecentsList.e(this.iTl).obtainMessage(2, paramo));
        }
        AppMethodBeat.o(133333);
      }
    }
  }
  
  public final boolean ih()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.recents;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

final class AppBrandLauncherRecentsList$g
  extends RecyclerView.h
{
  private AppBrandLauncherRecentsList$g(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(133395);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    paramRect.top = 0;
    if ((paramRecyclerView instanceof MRecyclerView))
    {
      paramRect = paramRecyclerView.bb(paramView);
      if ((paramRect instanceof AppBrandLauncherRecentsList.e))
      {
        paramView = ((AppBrandLauncherRecentsList.e)paramRect).gqg;
        if (((MRecyclerView)paramRecyclerView).S(paramRect) != AppBrandLauncherRecentsList.b(this.iTl).getItemCount() - 1) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(133395);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.g
 * JD-Core Version:    0.7.0.1
 */
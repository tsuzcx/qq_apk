package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class AppBrandProfileUI$22
  extends RecyclerView.h
{
  AppBrandProfileUI$22(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(227645);
    int i = a.aG(this.nWa, 2131165855);
    int j = a.aG(this.nWa, 2131165849);
    if (RecyclerView.bw(paramView) == 0) {}
    for (paramRect.left = i;; paramRect.left = 0)
    {
      paramRect.right = j;
      AppMethodBeat.o(227645);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.22
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class AppBrandProfileUI$19
  extends RecyclerView.h
{
  AppBrandProfileUI$19(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(133043);
    int i = a.ao(this.iOj, 2131428056);
    int j = a.ao(this.iOj, 2131428051);
    if (RecyclerView.bq(paramView) == 0) {}
    for (paramRect.left = i;; paramRect.left = 0)
    {
      paramRect.right = j;
      AppMethodBeat.o(133043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.19
 * JD-Core Version:    0.7.0.1
 */
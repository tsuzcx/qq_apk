package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

final class AppBrandProfileUI$21
  extends RecyclerView.h
{
  AppBrandProfileUI$21(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(188883);
    int i = a.ax(this.mDY, 2131165829);
    int j = a.ax(this.mDY, 2131165823);
    if (RecyclerView.bw(paramView) == 0) {}
    for (paramRect.left = i;; paramRect.left = 0)
    {
      paramRect.right = j;
      AppMethodBeat.o(188883);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.21
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.recents;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

final class e$f
  extends RecyclerView.h
{
  private e$f(e parame) {}
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    paramRect.top = 0;
    if ((paramRecyclerView instanceof MRecyclerView))
    {
      paramRect = paramRecyclerView.aT(paramView);
      if ((paramRect instanceof e.d))
      {
        paramView = ((e.d)paramRect).eYp;
        if (((MRecyclerView)paramRecyclerView).N(paramRect) != e.b(this.hhH).getItemCount() - 1) {
          break label82;
        }
      }
    }
    label82:
    for (int i = 8;; i = 0)
    {
      l.A(paramView, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.f
 * JD-Core Version:    0.7.0.1
 */
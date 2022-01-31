package com.tencent.mm.plugin.appbrand.ui.collection;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

final class i
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    if (paramRecyclerView != null)
    {
      paramView = paramRecyclerView.aT(paramView);
      if ((paramView != null) && ((paramView instanceof j)))
      {
        paramRect = ((j)paramView).hgH;
        int j = ((j)paramView).id();
        paramView = paramRecyclerView.getAdapter();
        if (paramView == null) {
          break label73;
        }
        i = paramView.getItemCount();
        if (j != i - 1) {
          break label79;
        }
      }
    }
    label73:
    label79:
    for (int i = 8;; i = 0)
    {
      paramRect.setVisibility(i);
      return;
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.i
 * JD-Core Version:    0.7.0.1
 */
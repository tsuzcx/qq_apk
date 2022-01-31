package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends RecyclerView.h
{
  private int padding;
  
  public c(int paramInt)
  {
    this.padding = paramInt;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = RecyclerView.bh(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (j == 0) {}
    for (int i = 0;; i = this.padding)
    {
      paramRect.left = i;
      paramRect.right = 0;
      y.d("MicroMsg.BizTimeLineHotViewItemDecoration", "alvinluo getItemOffsets pos: %d, rect: %s", new Object[] { Integer.valueOf(j), String.format("%d, %d, %d, %d", new Object[] { Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.top), Integer.valueOf(paramRect.right), Integer.valueOf(paramRect.bottom) }) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c
 * JD-Core Version:    0.7.0.1
 */
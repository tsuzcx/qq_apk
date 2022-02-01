package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends RecyclerView.h
{
  int padding;
  
  public a(int paramInt)
  {
    this.padding = paramInt;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(49820);
    int j = RecyclerView.bx(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (j == 0) {}
    for (int i = 0;; i = this.padding)
    {
      paramRect.left = i;
      paramRect.right = 0;
      ad.d("MicroMsg.AppBrandRecentViewHalfItemDecoration", "alvinluo getItemOffsets pos: %d, rect: %s", new Object[] { Integer.valueOf(j), String.format("%d, %d, %d, %d", new Object[] { Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.top), Integer.valueOf(paramRect.right), Integer.valueOf(paramRect.bottom) }) });
      AppMethodBeat.o(49820);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.a
 * JD-Core Version:    0.7.0.1
 */
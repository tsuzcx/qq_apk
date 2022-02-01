package com.tencent.mm.plugin.game.media;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;

final class h$b
  extends RecyclerView.h
{
  private int mSize;
  
  public h$b()
  {
    AppMethodBeat.i(40987);
    this.mSize = ao.fromDPToPix(aj.getContext(), 1);
    AppMethodBeat.o(40987);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(40988);
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    RecyclerView.bw(paramView);
    paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramRecyclerView.amN;
    ad.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.amV), Integer.valueOf(i), Integer.valueOf(paramView.amU) });
    if (paramView.amV != i)
    {
      if (paramView.amU == 0)
      {
        paramRect.set(0, this.mSize, this.mSize, this.mSize);
        AppMethodBeat.o(40988);
        return;
      }
      paramRect.set(this.mSize, this.mSize, 0, this.mSize);
      AppMethodBeat.o(40988);
      return;
    }
    paramRect.set(0, 0, 0, 0);
    AppMethodBeat.o(40988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h.b
 * JD-Core Version:    0.7.0.1
 */
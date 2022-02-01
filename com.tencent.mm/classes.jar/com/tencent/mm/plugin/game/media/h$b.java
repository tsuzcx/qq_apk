package com.tencent.mm.plugin.game.media;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;

final class h$b
  extends RecyclerView.h
{
  private int mSize;
  
  public h$b()
  {
    AppMethodBeat.i(40987);
    this.mSize = aq.fromDPToPix(ak.getContext(), 1);
    AppMethodBeat.o(40987);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(40988);
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    RecyclerView.bw(paramView);
    paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramRecyclerView.apA;
    ae.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.apI), Integer.valueOf(i), Integer.valueOf(paramView.apH) });
    if (paramView.apI != i)
    {
      if (paramView.apH == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h.b
 * JD-Core Version:    0.7.0.1
 */
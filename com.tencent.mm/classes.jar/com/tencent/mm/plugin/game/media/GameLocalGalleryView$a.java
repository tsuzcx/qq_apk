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

final class GameLocalGalleryView$a
  extends RecyclerView.h
{
  private int mSize;
  
  public GameLocalGalleryView$a(GameLocalGalleryView paramGameLocalGalleryView)
  {
    AppMethodBeat.i(41001);
    this.mSize = ao.fromDPToPix(aj.getContext(), 3);
    AppMethodBeat.o(41001);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(41002);
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    params = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramRecyclerView.amN;
    int j = RecyclerView.bw(paramView);
    int k = params.amU;
    ad.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(params.amV), Integer.valueOf(i), Integer.valueOf(k) });
    if (j < i)
    {
      if (k == 0)
      {
        paramRect.set(0, 0, 0, 0);
        AppMethodBeat.o(41002);
        return;
      }
      paramRect.set(this.mSize, 0, 0, 0);
      AppMethodBeat.o(41002);
      return;
    }
    if (k == 0)
    {
      paramRect.set(0, this.mSize, 0, 0);
      AppMethodBeat.o(41002);
      return;
    }
    paramRect.set(this.mSize, this.mSize, 0, 0);
    AppMethodBeat.o(41002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.a
 * JD-Core Version:    0.7.0.1
 */
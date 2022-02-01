package com.tencent.mm.plugin.game.media;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;

final class GameLocalGalleryView$a
  extends RecyclerView.h
{
  private int mSize;
  
  public GameLocalGalleryView$a(GameLocalGalleryView paramGameLocalGalleryView)
  {
    AppMethodBeat.i(41001);
    this.mSize = bd.fromDPToPix(MMApplicationContext.getContext(), 3);
    AppMethodBeat.o(41001);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(276852);
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    params = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramRecyclerView.bWl;
    int j = RecyclerView.bA(paramView);
    int k = params.bWs;
    Log.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(params.bWt), Integer.valueOf(i), Integer.valueOf(k) });
    if (j < i)
    {
      if (k == 0)
      {
        paramRect.set(0, 0, 0, 0);
        AppMethodBeat.o(276852);
        return;
      }
      paramRect.set(this.mSize, 0, 0, 0);
      AppMethodBeat.o(276852);
      return;
    }
    if (k == 0)
    {
      paramRect.set(0, this.mSize, 0, 0);
      AppMethodBeat.o(276852);
      return;
    }
    paramRect.set(this.mSize, this.mSize, 0, 0);
    AppMethodBeat.o(276852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.a
 * JD-Core Version:    0.7.0.1
 */
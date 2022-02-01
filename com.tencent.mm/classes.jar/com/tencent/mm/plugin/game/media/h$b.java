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

final class h$b
  extends RecyclerView.h
{
  private int mSize;
  
  public h$b()
  {
    AppMethodBeat.i(40987);
    this.mSize = bd.fromDPToPix(MMApplicationContext.getContext(), 1);
    AppMethodBeat.o(40987);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(276853);
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    RecyclerView.bA(paramView);
    paramView = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramRecyclerView.bWl;
    Log.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramView.bWt), Integer.valueOf(i), Integer.valueOf(paramView.bWs) });
    if (paramView.bWt != i)
    {
      if (paramView.bWs == 0)
      {
        paramRect.set(0, this.mSize, this.mSize, this.mSize);
        AppMethodBeat.o(276853);
        return;
      }
      paramRect.set(this.mSize, this.mSize, 0, this.mSize);
      AppMethodBeat.o(276853);
      return;
    }
    paramRect.set(0, 0, 0, 0);
    AppMethodBeat.o(276853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h.b
 * JD-Core Version:    0.7.0.1
 */
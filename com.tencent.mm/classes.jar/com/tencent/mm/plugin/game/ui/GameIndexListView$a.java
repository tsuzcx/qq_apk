package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GameIndexListView$a
  extends RecyclerView.h
{
  private final Drawable ajR;
  private int mSize;
  
  public GameIndexListView$a(GameIndexListView paramGameIndexListView, Resources paramResources)
  {
    AppMethodBeat.i(42155);
    this.ajR = new ColorDrawable(paramResources.getColor(2131100406));
    this.mSize = paramResources.getDimensionPixelSize(2131165421);
    AppMethodBeat.o(42155);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(42156);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < n - 1)
    {
      View localView = paramRecyclerView.getChildAt(i);
      Object localObject = ((ViewGroup)localView).getChildAt(0);
      if (((localObject instanceof GameBestSellingItemView)) || ((localObject instanceof GameBestSellingTitle)) || ((localObject instanceof GameFeedModuleTitle))) {
        super.a(paramCanvas, paramRecyclerView, params);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (RecyclerView.LayoutParams)localView.getLayoutParams();
        int i1 = localView.getBottom();
        i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i1;
        int i2 = this.mSize;
        this.ajR.setBounds(j, i1, k - m, i2 + i1);
        this.ajR.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(42156);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(42157);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(42157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.a
 * JD-Core Version:    0.7.0.1
 */
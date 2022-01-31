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
  private final Drawable acK;
  private int mSize;
  
  public GameIndexListView$a(GameIndexListView paramGameIndexListView, Resources paramResources)
  {
    AppMethodBeat.i(111971);
    this.acK = new ColorDrawable(paramResources.getColor(2131690085));
    this.mSize = paramResources.getDimensionPixelSize(2131427715);
    AppMethodBeat.o(111971);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(111972);
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
        this.acK.setBounds(j, i1, k - m, i2 + i1);
        this.acK.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(111972);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(111973);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(111973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.a
 * JD-Core Version:    0.7.0.1
 */
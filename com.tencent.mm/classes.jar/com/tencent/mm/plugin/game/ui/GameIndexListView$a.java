package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.c;

public final class GameIndexListView$a
  extends RecyclerView.h
{
  private int mSize;
  private final Drawable tP;
  
  public GameIndexListView$a(GameIndexListView paramGameIndexListView, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(276585);
    this.tP = new ColorDrawable(paramResources.getColor(paramInt));
    this.mSize = paramResources.getDimensionPixelSize(h.c.HSX);
    AppMethodBeat.o(276585);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(276586);
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
        this.tP.setBounds(j, i1, k - m, i2 + i1);
        this.tP.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(276586);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(276587);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(276587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.a
 * JD-Core Version:    0.7.0.1
 */
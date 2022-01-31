package com.tencent.mm.plugin.downloader_app.ui;

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
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.c;

public final class a
  extends RecyclerView.h
{
  private final Drawable adT;
  private int mSize;
  
  public a(Resources paramResources)
  {
    this.adT = new ColorDrawable(paramResources.getColor(b.b.divided_color));
    this.mSize = paramResources.getDimensionPixelSize(b.c.item_divided_size);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m - 1)
    {
      View localView = paramRecyclerView.getChildAt(i);
      Object localObject1 = ((ViewGroup)localView).getChildAt(0);
      if ((localView.getVisibility() == 8) || (((View)localObject1).getVisibility() == 8)) {
        super.a(paramCanvas, paramRecyclerView, params);
      }
      for (;;)
      {
        i += 1;
        break;
        int n;
        int i1;
        if (((localObject1 instanceof TaskManagerHeaderView)) || ((localObject1 instanceof TaskHeaderView)))
        {
          localObject1 = (RecyclerView.LayoutParams)localView.getLayoutParams();
          n = localView.getBottom();
          n = ((RecyclerView.LayoutParams)localObject1).bottomMargin + n;
          i1 = this.mSize;
          this.adT.setBounds(j, n, k, i1 + n);
          this.adT.draw(paramCanvas);
        }
        else if ((localObject1 instanceof TaskItemView))
        {
          Object localObject2;
          if (i < m - 2)
          {
            localObject2 = paramRecyclerView.getChildAt(i + 1);
            if ((localObject2 != null) && (!(((ViewGroup)localObject2).getChildAt(0) instanceof TaskItemView))) {}
          }
          else
          {
            localObject2 = (RecyclerView.LayoutParams)localView.getLayoutParams();
            n = localView.getBottom() + ((RecyclerView.LayoutParams)localObject2).bottomMargin;
            i1 = this.mSize;
            this.adT.setBounds(((TaskItemView)localObject1).getNamePaddingLeft() + j, n, k, n + i1);
            this.adT.draw(paramCanvas);
          }
        }
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    paramRect.set(0, 0, 0, this.mSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.a
 * JD-Core Version:    0.7.0.1
 */
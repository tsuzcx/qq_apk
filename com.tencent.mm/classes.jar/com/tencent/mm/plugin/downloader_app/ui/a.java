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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends RecyclerView.h
{
  private final Drawable ajR;
  private int mSize;
  private final Drawable ojB;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(9025);
    this.ajR = new ColorDrawable(paramResources.getColor(2131100251));
    this.mSize = paramResources.getDimensionPixelSize(2131166455);
    this.ojB = new ColorDrawable(paramResources.getColor(2131101179));
    AppMethodBeat.o(9025);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(9026);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m)
    {
      View localView2 = paramRecyclerView.getChildAt(i);
      View localView1 = ((ViewGroup)localView2).getChildAt(0);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView2.getLayoutParams();
      int n = localView2.getBottom() + localLayoutParams.bottomMargin;
      int i1 = n + this.mSize;
      if ((localView2.getVisibility() == 8) || (localView1.getVisibility() == 8)) {
        if ((localView1 instanceof TaskItemView))
        {
          this.ojB.setBounds(j, n, k, i1);
          this.ojB.draw(paramCanvas);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((localView1 instanceof TaskManagerHeaderView)) || ((localView1 instanceof TaskHeaderView)) || ((localView1 instanceof ExpandView)))
        {
          this.ajR.setBounds(j, n, k, i1);
          this.ajR.draw(paramCanvas);
        }
        else
        {
          if ((localView1 instanceof TaskItemView))
          {
            localView2 = paramRecyclerView.getChildAt(i + 1);
            if (localView2 != null)
            {
              localView2 = ((ViewGroup)localView2).getChildAt(0);
              if ((localView2 instanceof TaskHeaderView)) {
                break label353;
              }
              if (((localView2 instanceof ExpandView)) && (localView2.getVisibility() == 8))
              {
                this.ajR.setBounds(j, n, k, i1);
                this.ajR.draw(paramCanvas);
                continue;
              }
            }
            this.ajR.setBounds(((TaskItemView)localView1).getNamePaddingLeft() + j, n, k, i1);
            this.ajR.draw(paramCanvas);
            this.ojB.setBounds(j, n, ((TaskItemView)localView1).getNamePaddingLeft() + j, i1);
            this.ojB.draw(paramCanvas);
            continue;
          }
          label353:
          super.a(paramCanvas, paramRecyclerView, params);
        }
      }
    }
    AppMethodBeat.o(9026);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(9027);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(9027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.a
 * JD-Core Version:    0.7.0.1
 */
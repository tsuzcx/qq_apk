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
  private final Drawable acK;
  private final Drawable lcs;
  private int mSize;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(136257);
    this.acK = new ColorDrawable(paramResources.getColor(2131689965));
    this.mSize = paramResources.getDimensionPixelSize(2131428471);
    this.lcs = new ColorDrawable(-1);
    AppMethodBeat.o(136257);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(136258);
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
          this.lcs.setBounds(j, n, k, i1);
          this.lcs.draw(paramCanvas);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((localView1 instanceof TaskManagerHeaderView)) || ((localView1 instanceof TaskHeaderView)) || ((localView1 instanceof ExpandView)))
        {
          this.acK.setBounds(j, n, k, i1);
          this.acK.draw(paramCanvas);
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
                break label352;
              }
              if (((localView2 instanceof ExpandView)) && (localView2.getVisibility() == 8))
              {
                this.acK.setBounds(j, n, k, i1);
                this.acK.draw(paramCanvas);
                continue;
              }
            }
            this.acK.setBounds(((TaskItemView)localView1).getNamePaddingLeft() + j, n, k, i1);
            this.acK.draw(paramCanvas);
            this.lcs.setBounds(j, n, ((TaskItemView)localView1).getNamePaddingLeft() + j, i1);
            this.lcs.draw(paramCanvas);
            continue;
          }
          label352:
          super.a(paramCanvas, paramRecyclerView, params);
        }
      }
    }
    AppMethodBeat.o(136258);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(136259);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(136259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.a
 * JD-Core Version:    0.7.0.1
 */
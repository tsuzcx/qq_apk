package com.tencent.mm.plugin.downloader_app.ui;

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
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.c;

public final class a
  extends RecyclerView.h
{
  private int mSize;
  private final Drawable tP;
  private final Drawable xuo;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(9025);
    this.tP = new ColorDrawable(paramResources.getColor(e.b.xpG));
    this.mSize = paramResources.getDimensionPixelSize(e.c.xpN);
    this.xuo = new ColorDrawable(paramResources.getColor(e.b.white));
    AppMethodBeat.o(9025);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(269725);
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
          this.xuo.setBounds(j, n, k, i1);
          this.xuo.draw(paramCanvas);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((localView1 instanceof TaskManagerHeaderView)) || ((localView1 instanceof TaskHeaderView)) || ((localView1 instanceof ExpandView)))
        {
          this.tP.setBounds(j, n, k, i1);
          this.tP.draw(paramCanvas);
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
                this.tP.setBounds(j, n, k, i1);
                this.tP.draw(paramCanvas);
                continue;
              }
            }
            this.tP.setBounds(((TaskItemView)localView1).getNamePaddingLeft() + j, n, k, i1);
            this.tP.draw(paramCanvas);
            this.xuo.setBounds(j, n, ((TaskItemView)localView1).getNamePaddingLeft() + j, i1);
            this.xuo.draw(paramCanvas);
            continue;
          }
          label352:
          super.a(paramCanvas, paramRecyclerView, params);
        }
      }
    }
    AppMethodBeat.o(269725);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(269726);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(269726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.a
 * JD-Core Version:    0.7.0.1
 */
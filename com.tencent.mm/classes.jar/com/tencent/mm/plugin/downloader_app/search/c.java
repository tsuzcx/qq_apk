package com.tencent.mm.plugin.downloader_app.search;

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
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.e;

public final class c
  extends RecyclerView.h
{
  private final Drawable adT;
  private final Resources mRes;
  private int mSize;
  
  public c(Resources paramResources)
  {
    this.mRes = paramResources;
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
      View localView1 = paramRecyclerView.getChildAt(i);
      View localView2 = localView1.findViewById(b.e.search_header_layout);
      View localView3 = localView1.findViewById(b.e.search_history_layout);
      View localView4 = localView1.findViewById(b.e.search_result_layout);
      if (localView1.getVisibility() == 8) {
        super.a(paramCanvas, paramRecyclerView, params);
      }
      for (;;)
      {
        i += 1;
        break;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView1.getLayoutParams();
        int n = localView1.getBottom();
        n = localLayoutParams.bottomMargin + n;
        int i1 = this.mSize + n;
        if (localView2.getVisibility() == 0)
        {
          this.adT.setBounds(j, n, k, i1);
          this.adT.draw(paramCanvas);
        }
        else if (localView3.getVisibility() == 0)
        {
          this.adT.setBounds(this.mRes.getDimensionPixelSize(b.c.search_item_name_padding) + j, n, k, i1);
          this.adT.draw(paramCanvas);
        }
        else if (localView4.getVisibility() == 0)
        {
          this.adT.setBounds(this.mRes.getDimensionPixelSize(b.c.search_info_view_padding) + j, n, k, i1);
          this.adT.draw(paramCanvas);
        }
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    paramRect.set(0, 0, 0, this.mSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.c
 * JD-Core Version:    0.7.0.1
 */
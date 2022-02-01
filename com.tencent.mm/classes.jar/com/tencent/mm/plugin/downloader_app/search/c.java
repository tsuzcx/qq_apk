package com.tencent.mm.plugin.downloader_app.search;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.c;
import com.tencent.mm.plugin.downloader_app.e.e;

public final class c
  extends RecyclerView.h
{
  private final Resources mRes;
  private int mSize;
  private final Drawable sQ;
  
  public c(Resources paramResources)
  {
    AppMethodBeat.i(8958);
    this.mRes = paramResources;
    this.sQ = new ColorDrawable(paramResources.getColor(e.b.ujD));
    this.mSize = paramResources.getDimensionPixelSize(e.c.ujJ);
    AppMethodBeat.o(8958);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(243117);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m - 1)
    {
      View localView1 = paramRecyclerView.getChildAt(i);
      View localView2 = localView1.findViewById(e.e.ukn);
      View localView3 = localView1.findViewById(e.e.uko);
      View localView4 = localView1.findViewById(e.e.search_result_layout);
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
          this.sQ.setBounds(j, n, k, i1);
          this.sQ.draw(paramCanvas);
        }
        else if (localView3.getVisibility() == 0)
        {
          this.sQ.setBounds(this.mRes.getDimensionPixelSize(e.c.ujL) + j, n, k, i1);
          this.sQ.draw(paramCanvas);
        }
        else if (localView4.getVisibility() == 0)
        {
          this.sQ.setBounds(this.mRes.getDimensionPixelSize(e.c.ujK) + j, n, k, i1);
          this.sQ.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(243117);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(243118);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(243118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.c
 * JD-Core Version:    0.7.0.1
 */
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
  private final Drawable tP;
  
  public c(Resources paramResources)
  {
    AppMethodBeat.i(8958);
    this.mRes = paramResources;
    this.tP = new ColorDrawable(paramResources.getColor(e.b.xpG));
    this.mSize = paramResources.getDimensionPixelSize(e.c.xpN);
    AppMethodBeat.o(8958);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(269693);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m - 1)
    {
      View localView1 = paramRecyclerView.getChildAt(i);
      View localView2 = localView1.findViewById(e.e.xqz);
      View localView3 = localView1.findViewById(e.e.xqA);
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
          this.tP.setBounds(j, n, k, i1);
          this.tP.draw(paramCanvas);
        }
        else if (localView3.getVisibility() == 0)
        {
          this.tP.setBounds(this.mRes.getDimensionPixelSize(e.c.xpP) + j, n, k, i1);
          this.tP.draw(paramCanvas);
        }
        else if (localView4.getVisibility() == 0)
        {
          this.tP.setBounds(this.mRes.getDimensionPixelSize(e.c.xpO) + j, n, k, i1);
          this.tP.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(269693);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(269694);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(269694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.c
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends RecyclerView.h
{
  private final Drawable acK;
  private final Resources mRes;
  private int mSize;
  
  public c(Resources paramResources)
  {
    AppMethodBeat.i(136197);
    this.mRes = paramResources;
    this.acK = new ColorDrawable(paramResources.getColor(2131689965));
    this.mSize = paramResources.getDimensionPixelSize(2131428471);
    AppMethodBeat.o(136197);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(136198);
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m - 1)
    {
      View localView1 = paramRecyclerView.getChildAt(i);
      View localView2 = localView1.findViewById(2131827493);
      View localView3 = localView1.findViewById(2131827496);
      View localView4 = localView1.findViewById(2131827500);
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
          this.acK.setBounds(j, n, k, i1);
          this.acK.draw(paramCanvas);
        }
        else if (localView3.getVisibility() == 0)
        {
          this.acK.setBounds(this.mRes.getDimensionPixelSize(2131428652) + j, n, k, i1);
          this.acK.draw(paramCanvas);
        }
        else if (localView4.getVisibility() == 0)
        {
          this.acK.setBounds(this.mRes.getDimensionPixelSize(2131428651) + j, n, k, i1);
          this.acK.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(136198);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(136199);
    paramRect.set(0, 0, 0, this.mSize);
    AppMethodBeat.o(136199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.c
 * JD-Core Version:    0.7.0.1
 */
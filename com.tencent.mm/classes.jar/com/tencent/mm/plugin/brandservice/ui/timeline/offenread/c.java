package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends RecyclerView.h
{
  int padding;
  Paint paint;
  
  public c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(198739);
    this.paint = new Paint();
    this.padding = paramInt;
    this.paint.setColor(paramContext.getResources().getColor(2131099736));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    AppMethodBeat.o(198739);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(198740);
    super.a(paramCanvas, paramRecyclerView, paramt);
    paramt = (BizTimeLineHotListView)paramRecyclerView;
    if ((!paramt.nDT) || (paramt.getDataCount() <= 2))
    {
      AppMethodBeat.o(198740);
      return;
    }
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j - 1)
    {
      View localView1 = paramt.getChildAt(i);
      int k = RecyclerView.bx(localView1);
      if ((k == 1) || ((k == 0) && (i == 1)))
      {
        View localView2 = localView1.findViewById(2131297336);
        if (localView2 == null)
        {
          AppMethodBeat.o(198740);
          return;
        }
        localView2.getLayoutParams();
        i = localView1.getRight();
        float f1 = paramt.getItemPadding() / 2 + i;
        float f2 = BizTimeLineHotListView.nzi * a.eb(paramRecyclerView.getContext());
        paramCanvas.drawRect(f1 - 0.35F, localView2.getTop() + f2 + f2 / 2.0F, 1.0F + f1, localView2.getBottom() - f2 / 2.0F, this.paint);
        AppMethodBeat.o(198740);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(198740);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(6133);
    int i = RecyclerView.bx(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (i == 0) {}
    for (i = 0;; i = this.padding)
    {
      paramRect.left = i;
      paramRect.right = 0;
      AppMethodBeat.o(6133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c
 * JD-Core Version:    0.7.0.1
 */
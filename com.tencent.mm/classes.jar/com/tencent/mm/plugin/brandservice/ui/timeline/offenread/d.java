package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends RecyclerView.h
{
  private static int pzN = 0;
  int padding;
  Paint paint;
  private float pzM;
  
  public d(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(195019);
    this.paint = new Paint();
    this.padding = paramInt;
    this.paint.setColor(paramContext.getResources().getColor(2131099750));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    this.pzM = a.eP(paramContext);
    pzN = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    AppMethodBeat.o(195019);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(195020);
    super.a(paramCanvas, paramRecyclerView, params);
    params = (BizTimeLineHotListView)paramRecyclerView;
    if ((!params.pyY) || (params.getDataCount() <= 2))
    {
      AppMethodBeat.o(195020);
      return;
    }
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j - 1)
    {
      paramRecyclerView = params.getChildAt(i);
      int k = RecyclerView.bx(paramRecyclerView);
      if ((k == 1) || ((k == 0) && (i == 1)))
      {
        float f1 = Math.max(0.0F, (paramRecyclerView.getBottom() - paramRecyclerView.getTop() - this.pzM) / 2.0F);
        float f2 = paramRecyclerView.getRight();
        paramCanvas.drawRect(f2 - 0.35F, paramRecyclerView.getTop() + f1 - pzN * 2, 1.0F + f2, paramRecyclerView.getBottom() - f1 - pzN * 2, this.paint);
        AppMethodBeat.o(195020);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(195020);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(6133);
    int m = RecyclerView.bx(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (((BizTimeLineHotListView)paramRecyclerView).pyY)
    {
      if ((m != 0) && (m != 1)) {}
      for (i = this.padding / 2;; i = 0)
      {
        paramRect.left = i;
        i = j;
        if (m != 0)
        {
          i = j;
          if (m != 1) {
            i = this.padding / 2;
          }
        }
        paramRect.right = i;
        AppMethodBeat.o(6133);
        return;
      }
    }
    if (m != 0) {}
    for (int i = this.padding / 2;; i = 0)
    {
      paramRect.left = i;
      i = k;
      if (m != 0) {
        i = this.padding / 2;
      }
      paramRect.right = i;
      AppMethodBeat.o(6133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d
 * JD-Core Version:    0.7.0.1
 */
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
  private static int omX = 0;
  private float omW;
  int padding;
  Paint paint;
  
  public c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(208509);
    this.paint = new Paint();
    omX = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.padding = paramInt;
    this.paint.setColor(paramContext.getResources().getColor(2131099736));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    this.omW = (com.tencent.mm.cb.a.fromDPToPix(paramContext, 32) * a.ef(paramContext));
    AppMethodBeat.o(208509);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(208510);
    super.a(paramCanvas, paramRecyclerView, paramt);
    paramt = (BizTimeLineHotListView)paramRecyclerView;
    if ((!paramt.omo) || (paramt.getDataCount() <= 2))
    {
      AppMethodBeat.o(208510);
      return;
    }
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j - 1)
    {
      paramRecyclerView = paramt.getChildAt(i);
      int k = RecyclerView.bx(paramRecyclerView);
      if ((k == 1) || ((k == 0) && (i == 1)))
      {
        View localView = paramRecyclerView.findViewById(2131297336);
        if (localView == null)
        {
          AppMethodBeat.o(208510);
          return;
        }
        float f1 = Math.max(0.0F, (localView.getBottom() - localView.getTop() - this.omW) / 2.0F);
        float f2 = paramRecyclerView.getRight();
        f2 = paramt.getItemPadding() / 2.0F + f2;
        paramCanvas.drawRect(f2 - 0.35F, localView.getTop() + omX + f1, 1.0F + f2, localView.getBottom() + omX - f1, this.paint);
        AppMethodBeat.o(208510);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(208510);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int j = 0;
    AppMethodBeat.i(6133);
    int k = RecyclerView.bx(paramView);
    paramRect.top = 0;
    paramRect.bottom = 0;
    if (k != 0) {}
    for (int i = this.padding / 2;; i = 0)
    {
      paramRect.left = i;
      i = j;
      if (k != 0) {
        i = this.padding / 2;
      }
      paramRect.right = i;
      AppMethodBeat.o(6133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c
 * JD-Core Version:    0.7.0.1
 */
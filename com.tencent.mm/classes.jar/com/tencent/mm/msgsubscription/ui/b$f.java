package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
public final class b$f
  extends RecyclerView.h
{
  private final int paddingLeft;
  private final Paint paint;
  private final int strokeWidth;
  
  b$f()
  {
    AppMethodBeat.i(149756);
    this.strokeWidth = a.g(aj.getContext(), 0.5F);
    this.paddingLeft = a.fromDPToPix(aj.getContext(), 40);
    this.paint = new Paint();
    this.paint.setColor(b.b(localb).getResources().getColor(2131100241));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    this.paint.setStrokeWidth(this.strokeWidth);
    AppMethodBeat.o(149756);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(149754);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    super.a(paramCanvas, paramRecyclerView, paramt);
    float f1 = paramRecyclerView.getPaddingLeft();
    float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      paramt = paramRecyclerView.getChildAt(i);
      p.g(paramt, "child");
      Object localObject = paramt.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(149754);
        throw paramCanvas;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      float f3 = paramt.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.strokeWidth;
      if (i == 0)
      {
        float f4 = paramt.getTop();
        f4 = ((RecyclerView.LayoutParams)localObject).topMargin + f4 - this.strokeWidth;
        if (paramCanvas != null) {
          paramCanvas.drawLine(f1, f4, f2, f4, this.paint);
        }
      }
      if (i == paramRecyclerView.getChildCount() - 1) {
        if (paramCanvas != null) {
          paramCanvas.drawLine(f1, f3, f2, f3, this.paint);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawLine(f1 + this.paddingLeft, f3, f2, f3, this.paint);
        }
      }
    }
    AppMethodBeat.o(149754);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(149755);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    if (RecyclerView.bw(paramView) == 0)
    {
      paramRect.set(0, this.strokeWidth, 0, this.strokeWidth);
      AppMethodBeat.o(149755);
      return;
    }
    paramRect.set(0, 0, 0, this.strokeWidth);
    AppMethodBeat.o(149755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.f
 * JD-Core Version:    0.7.0.1
 */
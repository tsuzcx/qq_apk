package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.msgsubscription.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
public final class c$h
  extends RecyclerView.h
{
  private final int msN;
  private final Paint paint;
  private final int strokeWidth;
  
  c$h()
  {
    AppMethodBeat.i(149756);
    this.strokeWidth = 2;
    this.msN = a.fromDPToPix(MMApplicationContext.getContext(), 40);
    this.paint = new Paint();
    this.paint.setColor(c.b(localc).getResources().getColor(a.a.dialog_divider_line_color));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    this.paint.setStrokeWidth(this.strokeWidth);
    AppMethodBeat.o(149756);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(263709);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    float f1 = paramRecyclerView.getPaddingLeft();
    float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      p.j(params, "child");
      Object localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(263709);
        throw paramCanvas;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      float f3 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.strokeWidth;
      if (i == 0)
      {
        float f4 = params.getTop();
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
          paramCanvas.drawLine(f1 + this.msN, f3, f2, f3, this.paint);
        }
      }
    }
    AppMethodBeat.o(263709);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(263710);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    if (RecyclerView.bh(paramView) == 0)
    {
      paramRect.set(0, this.strokeWidth, 0, this.strokeWidth);
      AppMethodBeat.o(263710);
      return;
    }
    paramRect.set(0, 0, 0, this.strokeWidth);
    AppMethodBeat.o(263710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.h
 * JD-Core Version:    0.7.0.1
 */
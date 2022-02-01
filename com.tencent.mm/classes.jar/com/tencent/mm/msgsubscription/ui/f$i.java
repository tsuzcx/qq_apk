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
import com.tencent.mm.cd.a;
import com.tencent.mm.msgsubscription.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$i
  extends RecyclerView.h
{
  private final Paint paint;
  private final int pmp;
  private final int strokeWidth;
  
  f$i(f paramf)
  {
    AppMethodBeat.i(149756);
    this.strokeWidth = 2;
    this.pmp = a.fromDPToPix(MMApplicationContext.getContext(), 40);
    this.paint = new Paint();
    this.paint.setColor(f.c(this.pmq).getResources().getColor(a.a.dialog_divider_line_color));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    this.paint.setStrokeWidth(this.strokeWidth);
    AppMethodBeat.o(149756);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(236582);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    float f1 = paramRecyclerView.getPaddingLeft();
    float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int k = paramRecyclerView.getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      params = paramRecyclerView.getChildAt(i);
      Object localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(236582);
        throw paramCanvas;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      float f3 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.strokeWidth;
      if (i == 0)
      {
        float f4 = params.getTop();
        f4 = ((RecyclerView.LayoutParams)localObject).topMargin + f4 - this.strokeWidth;
        paramCanvas.drawLine(f1, f4, f2, f4, this.paint);
      }
      if (i == paramRecyclerView.getChildCount() - 1) {
        paramCanvas.drawLine(f1, f3, f2, f3, this.paint);
      }
      while (j >= k)
      {
        AppMethodBeat.o(236582);
        return;
        paramCanvas.drawLine(f1 + this.pmp, f3, f2, f3, this.paint);
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(236586);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    if (RecyclerView.bA(paramView) == 0)
    {
      paramRect.set(0, this.strokeWidth, 0, this.strokeWidth);
      AppMethodBeat.o(236586);
      return;
    }
    paramRect.set(0, 0, 0, this.strokeWidth);
    AppMethodBeat.o(236586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.f.i
 * JD-Core Version:    0.7.0.1
 */
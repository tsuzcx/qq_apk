package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
public final class CardHomePageNewUI$j
  extends RecyclerView.h
{
  private final Paint paint;
  
  CardHomePageNewUI$j()
  {
    AppMethodBeat.i(89220);
    this.paint = new Paint();
    this.paint.setColor(Color.parseColor("#19000000"));
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setFlags(1);
    AppMethodBeat.o(89220);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(89219);
    super.a(paramCanvas, paramRecyclerView, params);
    paramRecyclerView = CardHomePageNewUI.i(this.kzs);
    if (paramRecyclerView != null)
    {
      int k = paramRecyclerView.getPaddingLeft();
      params = CardHomePageNewUI.kzl;
      int m = CardHomePageNewUI.bfh();
      int n = paramRecyclerView.getWidth();
      int i1 = paramRecyclerView.getPaddingRight();
      int i2 = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < i2 - 1)
      {
        params = paramRecyclerView.getChildAt(i);
        j.p(params, "child");
        Object localObject = params.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(89219);
          throw paramCanvas;
        }
        localObject = (RecyclerView.LayoutParams)localObject;
        int i3 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin;
        if (i == i2 - 1) {
          params = CardHomePageNewUI.kzl;
        }
        for (int j = CardHomePageNewUI.bfg();; j = 1)
        {
          if (paramCanvas != null) {
            paramCanvas.drawRect(k + m, i3, n - i1, j + i3, this.paint);
          }
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(89219);
      return;
    }
    AppMethodBeat.o(89219);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(89218);
    super.a(paramRect, paramView, paramRecyclerView, params);
    int i;
    if (paramRecyclerView != null)
    {
      paramView = Integer.valueOf(RecyclerView.bq(paramView));
      i = CardHomePageNewUI.p(this.kzs).getItemCount();
      if (paramView != null) {
        break label62;
      }
    }
    for (;;)
    {
      if (paramRect != null)
      {
        paramRect.bottom = 1;
        AppMethodBeat.o(89218);
        return;
        paramView = null;
        break;
        label62:
        if (paramView.intValue() == i - 1)
        {
          ab.d("MicroMsg.CardHomePageNewUI", "is last");
          if (paramRect != null)
          {
            paramView = CardHomePageNewUI.kzl;
            paramRect.bottom = CardHomePageNewUI.bfg();
            AppMethodBeat.o(89218);
            return;
          }
          AppMethodBeat.o(89218);
          return;
        }
      }
    }
    AppMethodBeat.o(89218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.j
 * JD-Core Version:    0.7.0.1
 */
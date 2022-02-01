package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "dividerHeight", "", "(Landroid/content/Context;I)V", "bounds", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "getDividerHeight", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "plugin-force-notify_release"})
public final class a
  extends RecyclerView.h
{
  private final Rect byi;
  private final Context context;
  private final int jau;
  private final Paint paint;
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(253918);
    this.context = paramContext;
    this.jau = paramInt;
    this.byi = new Rect();
    paramContext = new Paint();
    if (ar.isDarkMode()) {}
    for (paramInt = this.context.getResources().getColor(a.b.force_notify_divider_white_10);; paramInt = this.context.getResources().getColor(a.b.force_notify_divider_dark_10))
    {
      paramContext.setColor(paramInt);
      paramContext.setAntiAlias(true);
      this.paint = paramContext;
      AppMethodBeat.o(253918);
      return;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(253915);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    if (RecyclerView.bh(paramView) != 0) {
      paramRect.top = this.jau;
    }
    AppMethodBeat.o(253915);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(253913);
    p.k(paramCanvas, "canvas");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    paramCanvas.save();
    int j = paramRecyclerView.getChildCount();
    if (j > 1)
    {
      int i = 0;
      while (i < j)
      {
        params = paramRecyclerView.getChildAt(i);
        if (RecyclerView.bh(params) != 0)
        {
          RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
          if (localLayoutManager != null) {
            localLayoutManager.getDecoratedBoundsWithMargins(params, this.byi);
          }
          int k = this.byi.top;
          int m = this.byi.top;
          int n = this.jau;
          int i1 = paramRecyclerView.getRight();
          paramCanvas.drawRect(paramRecyclerView.getLeft(), k, i1, m + n, this.paint);
        }
        i += 1;
      }
    }
    paramCanvas.restore();
    AppMethodBeat.o(253913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.a
 * JD-Core Version:    0.7.0.1
 */
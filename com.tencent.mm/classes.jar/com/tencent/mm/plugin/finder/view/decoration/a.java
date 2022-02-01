package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/decoration/CommentItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "extraLast", "(Landroid/graphics/drawable/Drawable;I[II)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class a
  extends RecyclerView.h
{
  private int[] Bew;
  private int Bex;
  private Drawable nbH;
  
  public a(Drawable paramDrawable, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(168498);
    this.nbH = paramDrawable;
    this.Bew = paramArrayOfInt;
    this.Bex = paramInt2;
    paramDrawable.setBounds(0, 0, 0, paramInt1);
    AppMethodBeat.o(168498);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(282420);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(282420);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(282421);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    AppMethodBeat.o(282421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.a
 * JD-Core Version:    0.7.0.1
 */
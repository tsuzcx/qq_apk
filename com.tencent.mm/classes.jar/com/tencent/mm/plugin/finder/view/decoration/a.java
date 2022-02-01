package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/decoration/CommentItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "extraLast", "(Landroid/graphics/drawable/Drawable;I[II)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.h
{
  private int[] GGT;
  private int GGU;
  private Drawable pYO;
  
  public a(Drawable paramDrawable, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(168498);
    this.pYO = paramDrawable;
    this.GGT = paramArrayOfInt;
    this.GGU = paramInt2;
    paramDrawable.setBounds(0, 0, 0, paramInt1);
    AppMethodBeat.o(168498);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(344939);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(344939);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(344948);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    AppMethodBeat.o(344948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.decoration.a
 * JD-Core Version:    0.7.0.1
 */
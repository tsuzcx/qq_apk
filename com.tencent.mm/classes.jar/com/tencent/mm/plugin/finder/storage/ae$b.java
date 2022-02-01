package com.tencent.mm.plugin.finder.storage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
public final class ae$b
  extends RecyclerView.h
{
  private final int space;
  
  ae$b()
  {
    AppMethodBeat.i(266091);
    this.space = a.fromDPToPix(MMApplicationContext.getContext(), 1.0F);
    AppMethodBeat.o(266091);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(266090);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
    params = paramView.getLayoutParams();
    if (params == null)
    {
      paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
      AppMethodBeat.o(266090);
      throw paramRect;
    }
    params = (GridLayoutManager.LayoutParams)params;
    int i = RecyclerView.bh(paramView);
    if (paramRecyclerView == null) {
      p.iCn();
    }
    int j = paramRecyclerView.ku();
    if (paramRecyclerView.getSpanSizeLookup().ao(i, j) == 0) {
      paramRect.top = this.space;
    }
    paramRect.bottom = this.space;
    if (params.kw() == j)
    {
      paramRect.left = this.space;
      paramRect.right = this.space;
      AppMethodBeat.o(266090);
      return;
    }
    paramRect.left = ((int)((j - params.kv()) / j * this.space));
    paramRect.right = ((int)(1.0F * this.space * (j + 1) / j - paramRect.left));
    AppMethodBeat.o(266090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ae.b
 * JD-Core Version:    0.7.0.1
 */
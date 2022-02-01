package com.tencent.mm.plugin.emoji.ui.v3;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.v3.a.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spaceV", "", "edgeH", "headerCount", "sizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "(IIILcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;)V", "TAG", "", "itemIntervalH", "spanCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.h
{
  private final String TAG;
  private int spanCount;
  private final int xZr;
  private final int xZs;
  private int xZt;
  private final k xZu;
  private int xZv;
  
  public a(int paramInt1, int paramInt2, k paramk)
  {
    AppMethodBeat.i(270461);
    this.xZr = paramInt1;
    this.xZs = 0;
    this.xZt = paramInt2;
    this.xZu = paramk;
    this.TAG = "MicroMsg.EmojiStoreV3GridItemDecoration";
    AppMethodBeat.o(270461);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(270469);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    this.spanCount = this.xZu.spanCount;
    this.xZv = this.xZu.itemSpace;
    params = paramRecyclerView.getAdapter();
    if (params == null) {}
    for (int i = 0;; i = params.getItemCount())
    {
      paramView = paramView.getLayoutParams();
      if (paramView != null) {
        break;
      }
      paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(270469);
      throw paramRect;
    }
    int j = ((RecyclerView.LayoutParams)paramView).bXh.KI();
    if ((j < 0) || (i <= 0))
    {
      AppMethodBeat.o(270469);
      return;
    }
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null)
    {
      i = -1;
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(270469);
      return;
      i = paramView.getItemViewType(j);
      break;
      i = this.xZs + this.xZu.mls;
      paramRect.set(i, 0, i, 0);
      AppMethodBeat.o(270469);
      return;
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(270469);
      return;
      i = this.xZt;
      int k = this.spanCount;
      paramRect.bottom = this.xZr;
      float f1 = (this.xZs * 2 + (this.spanCount - 1) * this.xZv) * 1.0F / this.spanCount;
      float f2 = this.xZs;
      f2 = (j - i) % k * (this.xZv - f1) + f2;
      paramRect.left = kotlin.h.a.eH(f2);
      paramRect.right = kotlin.h.a.eH(f1 - f2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a
 * JD-Core Version:    0.7.0.1
 */
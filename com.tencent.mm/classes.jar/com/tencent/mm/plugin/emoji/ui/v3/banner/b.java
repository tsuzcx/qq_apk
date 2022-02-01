package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerNoLoopItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(I)V", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  private final int space;
  
  public b(int paramInt)
  {
    this.space = paramInt;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(270571);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    int j = RecyclerView.bA(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getItemCount())
    {
      if (j == i - 1) {
        paramRect.right = this.space;
      }
      paramRect.left = this.space;
      AppMethodBeat.o(270571);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.b
 * JD-Core Version:    0.7.0.1
 */
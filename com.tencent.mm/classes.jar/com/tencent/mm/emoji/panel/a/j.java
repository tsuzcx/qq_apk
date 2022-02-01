package com.tencent.mm.emoji.panel.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-emojisdk_release"})
public final class j
  extends RecyclerView.h
{
  private final String TAG;
  private final q jLi;
  
  public j(q paramq)
  {
    AppMethodBeat.i(105667);
    this.jLi = paramq;
    this.TAG = "MicroMsg.EmojiPanelItemDecoration";
    AppMethodBeat.o(105667);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(237430);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(237430);
      return;
    }
    p.j(paramRecyclerView, "parent.adapter ?: return");
    int i = RecyclerView.bh(paramView);
    if (i == -1)
    {
      AppMethodBeat.o(237430);
      return;
    }
    i = paramRecyclerView.getItemViewType(i);
    int j = this.jLi.jMp;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237430);
      return;
      paramRect.set(j, 0, j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.j
 * JD-Core Version:    0.7.0.1
 */
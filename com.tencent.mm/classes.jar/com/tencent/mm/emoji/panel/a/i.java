package com.tencent.mm.emoji.panel.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-emojisdk_release"})
public final class i
  extends RecyclerView.h
{
  private final String TAG;
  private final o fPt;
  
  public i(o paramo)
  {
    AppMethodBeat.i(105667);
    this.fPt = paramo;
    this.TAG = "MicroMsg.EmojiPanelItemDecoration";
    AppMethodBeat.o(105667);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(105666);
    k.h(paramRect, "outRect");
    k.h(paramView, "view");
    k.h(paramRecyclerView, "parent");
    k.h(params, "state");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(105666);
      return;
    }
    k.g(paramRecyclerView, "parent.adapter ?: return");
    int i = RecyclerView.bw(paramView);
    if (i == -1)
    {
      AppMethodBeat.o(105666);
      return;
    }
    i = paramRecyclerView.getItemViewType(i);
    int j = this.fPt.fQt;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105666);
      return;
      paramRect.set(j, 0, j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.i
 * JD-Core Version:    0.7.0.1
 */
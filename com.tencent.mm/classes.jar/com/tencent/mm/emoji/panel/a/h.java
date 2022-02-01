package com.tencent.mm.emoji.panel.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.h
{
  private final String TAG;
  private final o mku;
  
  public h(o paramo)
  {
    AppMethodBeat.i(105667);
    this.mku = paramo;
    this.TAG = "MicroMsg.EmojiPanelItemDecoration";
    AppMethodBeat.o(105667);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(242420);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(242420);
      return;
    }
    int i = RecyclerView.bA(paramView);
    if (i == -1)
    {
      AppMethodBeat.o(242420);
      return;
    }
    i = paramRecyclerView.getItemViewType(i);
    int j = this.mku.mls;
    if (i == 2) {
      paramRect.set(j, 0, j, 0);
    }
    AppMethodBeat.o(242420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.h
 * JD-Core Version:    0.7.0.1
 */
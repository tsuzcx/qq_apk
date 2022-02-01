package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelItemLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "scrollToPosition", "", "position", "smoothScrollToPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "Scroller", "plugin-emojisdk_release"})
public final class EmojiPanelItemLayoutManager
  extends GridLayoutManager
{
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(105714);
    super.ah(paramInt, 0);
    AppMethodBeat.o(105714);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(105713);
    p.h(paramRecyclerView, "recyclerView");
    p.h(params, "state");
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(105713);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelItemLayoutManager$Scroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getVerticalSnapPreference", "", "plugin-emojisdk_release"})
  static final class a
    extends ae
  {
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(105712);
      AppMethodBeat.o(105712);
    }
    
    public final int kA()
    {
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.EmojiPanelItemLayoutManager
 * JD-Core Version:    0.7.0.1
 */
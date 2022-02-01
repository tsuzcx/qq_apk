package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelItemLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "scrollToPosition", "", "position", "smoothScrollToPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Scroller", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiPanelItemLayoutManager
  extends GridLayoutManager
{
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(105714);
    super.bo(paramInt, 0);
    AppMethodBeat.o(105714);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(242358);
    s.u(paramRecyclerView, "recyclerView");
    s.u(params, "state");
    paramRecyclerView = paramRecyclerView.getContext();
    s.s(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(242358);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelItemLayoutManager$Scroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getVerticalSnapPreference", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends o
  {
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(105712);
      AppMethodBeat.o(105712);
    }
    
    public final int JC()
    {
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.EmojiPanelItemLayoutManager
 * JD-Core Version:    0.7.0.1
 */
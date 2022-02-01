package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "fragmentTabType", "", "(I)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindConfig", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "bindFriendConfig", "bindLbsConfig", "getLayoutId", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class aa
  extends e<y>
{
  private final String TAG;
  private final int xlO;
  private final int xlY;
  
  public aa(int paramInt)
  {
    this.xlO = paramInt;
    this.TAG = "FinderFeedLiveListItemConvert";
    this.xlY = 5;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(237827);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(237827);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(237826);
    if (aj.a(aj.AGc, this.xlO, 0, 2))
    {
      i = b.g.finder_feed_live_list_square_full_item;
      AppMethodBeat.o(237826);
      return i;
    }
    int i = b.g.finder_feed_live_list_square_item;
    AppMethodBeat.o(237826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "fragmentTabType", "", "(I)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindConfig", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "bindFriendConfig", "bindLbsConfig", "getLayoutId", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends f<z>
{
  private final int AJV;
  private final int AKn;
  private final String TAG;
  
  public x(int paramInt)
  {
    this.AJV = paramInt;
    this.TAG = "FinderFeedLiveListItemConvert";
    this.AKn = 5;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350545);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350545);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_live_list_square_full_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */
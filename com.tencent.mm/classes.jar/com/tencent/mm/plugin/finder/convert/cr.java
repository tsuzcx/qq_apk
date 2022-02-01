package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1;", "linkLayout", "loadMoreLayout", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportExpose", "", "getReportExpose", "()Z", "setReportExpose", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1;", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "titleLayoutSet", "Ljava/util/LinkedList;", "viewRect", "createTitleLayout", "context", "Landroid/content/Context;", "parent", "getLayoutId", "", "isViewExposed", "view", "jumpToHotTab", "", "Lcom/tencent/mm/ui/MMActivity;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onClickTopic", "txt", "", "index", "onCreateViewHolder", "setFinderStreamTxtCard", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cr
  extends f<av>
{
  public static final a AMS;
  
  static
  {
    AppMethodBeat.i(349904);
    AMS = new a((byte)0);
    AppMethodBeat.o(349904);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349917);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(349917);
    throw null;
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_card_txt_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cr
 * JD-Core Version:    0.7.0.1
 */
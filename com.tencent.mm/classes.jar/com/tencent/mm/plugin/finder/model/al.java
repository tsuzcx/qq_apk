package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "privateMsgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "commentFailedNotifyDataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "friendTabLikeTipsState", "Lcom/tencent/mm/plugin/finder/model/FriendTabLikeTipsState;", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/model/FriendTabLikeTipsState;)V", "getCommentFailedNotifyDataList", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "getFriendTabLikeTipsState", "()Lcom/tencent/mm/plugin/finder/model/FriendTabLikeTipsState;", "setFriendTabLikeTipsState", "(Lcom/tencent/mm/plugin/finder/model/FriendTabLikeTipsState;)V", "getMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "getPrivateMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "compare", "", "obj", "getItemId", "", "getItemType", "isEmpty", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends i.b
  implements k
{
  public final bs Ban;
  public final ConcurrentLinkedQueue<f> Bar;
  public bz ECT;
  public final h msgNotifyData;
  
  private al(h paramh, bs parambs, ConcurrentLinkedQueue<f> paramConcurrentLinkedQueue, bz parambz)
  {
    AppMethodBeat.i(332129);
    this.msgNotifyData = paramh;
    this.Ban = parambs;
    this.Bar = paramConcurrentLinkedQueue;
    this.ECT = parambz;
    AppMethodBeat.o(332129);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332142);
    s.u(paramk, "obj");
    AppMethodBeat.o(332142);
    return 2147483647;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332148);
    long l = hashCode();
    AppMethodBeat.o(332148);
    return l;
  }
  
  public final int bZB()
  {
    return 2019;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.al
 * JD-Core Version:    0.7.0.1
 */
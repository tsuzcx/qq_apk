package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.h.b;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "privateMsgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "commentFailedNotifyDataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "getCommentFailedNotifyDataList", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "getMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "getPrivateMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "compare", "", "obj", "getItemId", "", "getItemType", "isEmpty", "", "plugin-finder_release"})
public final class aj
  extends h.b
  implements k
{
  public final h msgNotifyData;
  public final bm xCY;
  public final ConcurrentLinkedQueue<f> xDc;
  
  public aj(h paramh, bm parambm, ConcurrentLinkedQueue<f> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(281045);
    this.msgNotifyData = paramh;
    this.xCY = parambm;
    this.xDc = paramConcurrentLinkedQueue;
    AppMethodBeat.o(281045);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(281040);
    p.k(paramk, "obj");
    AppMethodBeat.o(281040);
    return 2147483647;
  }
  
  public final int bAQ()
  {
    return 2019;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(281042);
    long l = hashCode();
    AppMethodBeat.o(281042);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aj
 * JD-Core Version:    0.7.0.1
 */
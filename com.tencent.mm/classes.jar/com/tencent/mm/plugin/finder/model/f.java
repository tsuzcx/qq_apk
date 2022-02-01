package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class f
  extends h.b
  implements k
{
  public final long feedId;
  public final String objectNonceId;
  public int zAc;
  
  private f(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.zAc = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166364);
    p.k(paramk, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final int bAQ()
  {
    return -4;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(293368);
    long l = hashCode();
    AppMethodBeat.o(293368);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */
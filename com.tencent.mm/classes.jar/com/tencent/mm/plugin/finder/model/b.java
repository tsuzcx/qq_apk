package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class b
  extends d.b
  implements i
{
  public final long feedId;
  public final String objectNonceId;
  public int qDq;
  
  private b(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.qDq = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166364);
    k.h(parami, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final long bMs()
  {
    AppMethodBeat.i(198621);
    long l = hashCode();
    AppMethodBeat.o(198621);
    return l;
  }
  
  public final int bMt()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */
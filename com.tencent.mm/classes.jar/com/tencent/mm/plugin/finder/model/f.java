package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends i.b
  implements k
{
  public int ECj;
  public final long feedId;
  public final String objectNonceId;
  
  private f(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.ECj = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166364);
    s.u(paramk, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(166365);
    long l = hashCode();
    AppMethodBeat.o(166365);
    return l;
  }
  
  public final int bZB()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */
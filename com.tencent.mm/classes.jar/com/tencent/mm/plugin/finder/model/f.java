package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class f
  extends g.b
  implements i
{
  public final long feedId;
  public final String objectNonceId;
  public int uNO;
  
  private f(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.uNO = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166364);
    p.h(parami, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final int cxn()
  {
    return -4;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(258538);
    long l = hashCode();
    AppMethodBeat.o(258538);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class e
  extends d.b
  implements i
{
  public final long dtq;
  public final String objectNonceId;
  public int sjS;
  
  private e(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.dtq = paramLong;
    this.objectNonceId = paramString;
    this.sjS = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166364);
    p.h(parami, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final int bYk()
  {
    return -4;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(221470);
    long l = hashCode();
    AppMethodBeat.o(221470);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.e
 * JD-Core Version:    0.7.0.1
 */
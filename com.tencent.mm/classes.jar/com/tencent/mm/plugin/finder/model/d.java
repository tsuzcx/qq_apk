package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedId", "", "objectNonceId", "", "canRemove", "", "(JLjava/lang/String;I)V", "getCanRemove", "()I", "setCanRemove", "(I)V", "getFeedId", "()J", "getObjectNonceId", "()Ljava/lang/String;", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class d
  extends d.b
  implements h
{
  public final long dig;
  public final String objectNonceId;
  public int ruz;
  
  private d(long paramLong, String paramString)
  {
    AppMethodBeat.i(166366);
    this.dig = paramLong;
    this.objectNonceId = paramString;
    this.ruz = 0;
    AppMethodBeat.o(166366);
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(166364);
    k.h(paramh, "obj");
    AppMethodBeat.o(166364);
    return 0;
  }
  
  public final int bTF()
  {
    return -4;
  }
  
  public final long lx()
  {
    AppMethodBeat.i(210186);
    long l = hashCode();
    AppMethodBeat.o(210186);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.d
 * JD-Core Version:    0.7.0.1
 */
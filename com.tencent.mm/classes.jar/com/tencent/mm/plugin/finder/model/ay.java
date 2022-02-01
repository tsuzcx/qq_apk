package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectLikeLike;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"})
public final class ay
  extends a
{
  public ay(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(248821);
    AppMethodBeat.o(248821);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248820);
    p.h(parami, "obj");
    AppMethodBeat.o(248820);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248819);
    int i = ay.class.getName().hashCode();
    AppMethodBeat.o(248819);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ay
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMsgSysHead;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"})
public final class be
  extends a
{
  public be(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(248832);
    AppMethodBeat.o(248832);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248831);
    p.h(parami, "obj");
    AppMethodBeat.o(248831);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248830);
    int i = be.class.getName().hashCode();
    AppMethodBeat.o(248830);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.be
 * JD-Core Version:    0.7.0.1
 */
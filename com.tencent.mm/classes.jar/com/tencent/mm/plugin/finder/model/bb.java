package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMsgMentioned;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"})
public final class bb
  extends a
{
  public bb(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(248827);
    AppMethodBeat.o(248827);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248826);
    p.h(parami, "obj");
    AppMethodBeat.o(248826);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248825);
    int i = bb.class.getName().hashCode();
    AppMethodBeat.o(248825);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bb
 * JD-Core Version:    0.7.0.1
 */
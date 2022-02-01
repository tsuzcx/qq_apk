package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMsgFollow;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"})
public final class av
  extends a
{
  public av(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(248812);
    AppMethodBeat.o(248812);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248811);
    p.h(parami, "obj");
    AppMethodBeat.o(248811);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248810);
    int i = av.class.getName().hashCode();
    AppMethodBeat.o(248810);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.av
 * JD-Core Version:    0.7.0.1
 */
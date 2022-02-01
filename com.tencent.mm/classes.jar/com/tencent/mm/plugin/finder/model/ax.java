package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApplyAccept;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"})
public final class ax
  extends a
{
  public ax(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(248818);
    AppMethodBeat.o(248818);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248817);
    p.h(parami, "obj");
    AppMethodBeat.o(248817);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248816);
    int i = ax.class.getName().hashCode();
    AppMethodBeat.o(248816);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ax
 * JD-Core Version:    0.7.0.1
 */
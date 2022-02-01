package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.av;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderMsgMentioned;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
  extends a
{
  public bi(av paramav)
  {
    super(paramav);
    AppMethodBeat.i(331920);
    AppMethodBeat.o(331920);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331932);
    s.u(paramk, "obj");
    AppMethodBeat.o(331932);
    return 0;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331926);
    int i = bi.class.getName().hashCode();
    AppMethodBeat.o(331926);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bi
 * JD-Core Version:    0.7.0.1
 */
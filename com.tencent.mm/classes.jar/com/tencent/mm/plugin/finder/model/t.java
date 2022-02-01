package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isContentCollapsed", "", "()Z", "setContentCollapsed", "(Z)V", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class t
  extends s
  implements i
{
  public boolean isContentCollapsed;
  public final FinderItem tHo;
  
  public t(FinderItem paramFinderItem)
  {
    super(localan);
    this.tHo = paramFinderItem;
    this.isContentCollapsed = true;
    AppMethodBeat.o(248734);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248733);
    p.h(parami, "obj");
    AppMethodBeat.o(248733);
    return 0;
  }
  
  public final int cxn()
  {
    return s.uOi;
  }
  
  public final long lT()
  {
    return this.tHo.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.t
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isContentCollapsed", "", "()Z", "setContentCollapsed", "(Z)V", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class t
  extends s
{
  public boolean isContentCollapsed;
  public final FinderItem xpY;
  
  public t(FinderItem paramFinderItem)
  {
    super(localam);
    this.xpY = paramFinderItem;
    this.isContentCollapsed = true;
    AppMethodBeat.o(264923);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(264922);
    p.k(paramk, "obj");
    AppMethodBeat.o(264922);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(264921);
    int i = s.dKx();
    AppMethodBeat.o(264921);
    return i;
  }
  
  public final long mf()
  {
    return this.xpY.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.t
 * JD-Core Version:    0.7.0.1
 */
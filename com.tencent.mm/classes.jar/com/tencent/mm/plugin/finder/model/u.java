package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isContentCollapsed", "", "()Z", "setContentCollapsed", "(Z)V", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends t
{
  public final FinderItem ANj;
  public boolean isContentCollapsed;
  
  public u(FinderItem paramFinderItem)
  {
    super(localau);
    this.ANj = paramFinderItem;
    this.isContentCollapsed = true;
    AppMethodBeat.o(332219);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332236);
    s.u(paramk, "obj");
    AppMethodBeat.o(332236);
    return 0;
  }
  
  public final long bZA()
  {
    return this.ANj.field_id;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332227);
    int i = t.eDl();
    AppMethodBeat.o(332227);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.u
 * JD-Core Version:    0.7.0.1
 */
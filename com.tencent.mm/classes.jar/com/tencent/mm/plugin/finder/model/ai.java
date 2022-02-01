package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;J)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements cc
{
  public final FinderItem feedObject;
  private final long id;
  
  public ai(FinderItem paramFinderItem, long paramLong)
  {
    AppMethodBeat.i(332115);
    this.feedObject = paramFinderItem;
    this.id = paramLong;
    AppMethodBeat.o(332115);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332132);
    s.u(paramk, "obj");
    if (((paramk instanceof ai)) && (this.id == ((ai)paramk).id))
    {
      AppMethodBeat.o(332132);
      return 0;
    }
    AppMethodBeat.o(332132);
    return -1;
  }
  
  public final long bZA()
  {
    return this.id;
  }
  
  public final int bZB()
  {
    return 2017;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ai
 * JD-Core Version:    0.7.0.1
 */
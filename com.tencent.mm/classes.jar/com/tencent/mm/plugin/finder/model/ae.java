package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;J)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ae
  implements bo
{
  public final FinderItem feedObject;
  private final long id;
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248752);
    p.h(parami, "obj");
    if (((parami instanceof ae)) && (this.id == ((ae)parami).id))
    {
      AppMethodBeat.o(248752);
      return 0;
    }
    AppMethodBeat.o(248752);
    return -1;
  }
  
  public final int cxn()
  {
    return 2017;
  }
  
  public final long lT()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ae
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderObjectTransform;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataTransform;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "transform", "src", "plugin-finder_release"})
public final class j
{
  public static final j sKW;
  
  static
  {
    AppMethodBeat.i(204417);
    sKW = new j();
    AppMethodBeat.o(204417);
  }
  
  public static am g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204416);
    p.h(paramFinderItem, "src");
    b.a locala = b.sLq;
    paramFinderItem = (am)b.a.j(paramFinderItem);
    AppMethodBeat.o(204416);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */
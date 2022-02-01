package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderObjectTransform;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataTransform;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "transform", "src", "plugin-finder_release"})
public final class j
{
  public static final j szZ;
  
  static
  {
    AppMethodBeat.i(203826);
    szZ = new j();
    AppMethodBeat.o(203826);
  }
  
  public static al g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203825);
    p.h(paramFinderItem, "src");
    b.a locala = b.sAs;
    paramFinderItem = (al)b.a.j(paramFinderItem);
    AppMethodBeat.o(203825);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */
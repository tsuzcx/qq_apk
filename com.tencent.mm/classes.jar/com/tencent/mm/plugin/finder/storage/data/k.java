package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderObjectTransform;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataTransform;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "transform", "src", "plugin-finder_release"})
public final class k
{
  public static final k vGq;
  
  static
  {
    AppMethodBeat.i(252009);
    vGq = new k();
    AppMethodBeat.o(252009);
  }
  
  public static bo o(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(252008);
    p.h(paramFinderItem, "src");
    c.a locala = c.vGN;
    paramFinderItem = (bo)c.a.s(paramFinderItem);
    AppMethodBeat.o(252008);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */
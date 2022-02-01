package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderObjectTransform;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataTransform;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "transform", "src", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j FNf;
  
  static
  {
    AppMethodBeat.i(339342);
    FNf = new j();
    AppMethodBeat.o(339342);
  }
  
  public static cc t(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(339337);
    s.u(paramFinderItem, "src");
    d.a locala = d.FND;
    paramFinderItem = (cc)d.a.a(paramFinderItem);
    AppMethodBeat.o(339337);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */
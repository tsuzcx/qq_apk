package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderBlockSubTitleData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class m
  extends h.b
  implements k
{
  public aj zAg;
  
  public m(aj paramaj)
  {
    AppMethodBeat.i(279807);
    this.zAg = paramaj;
    AppMethodBeat.o(279807);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(279805);
    p.k(paramk, "obj");
    AppMethodBeat.o(279805);
    return 2147483647;
  }
  
  public final int bAQ()
  {
    return -8;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(279806);
    long l = hashCode();
    AppMethodBeat.o(279806);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.m
 * JD-Core Version:    0.7.0.1
 */
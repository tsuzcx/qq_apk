package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderBlockSubTitleData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends i.b
  implements k
{
  public ar ECo;
  
  public n(ar paramar)
  {
    AppMethodBeat.i(332191);
    this.ECo = paramar;
    AppMethodBeat.o(332191);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332199);
    s.u(paramk, "obj");
    AppMethodBeat.o(332199);
    return 2147483647;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332208);
    long l = hashCode();
    AppMethodBeat.o(332208);
    return l;
  }
  
  public final int bZB()
  {
    return -8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.n
 * JD-Core Version:    0.7.0.1
 */
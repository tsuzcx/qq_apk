package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.ben;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class b
  implements bu
{
  private final x zzV;
  
  public b(x paramx)
  {
    AppMethodBeat.i(284598);
    this.zzV = paramx;
    AppMethodBeat.o(284598);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(284596);
    p.k(paramk, "obj");
    if (((paramk instanceof b)) && (((b)paramk).zzV.a(this.zzV)))
    {
      AppMethodBeat.o(284596);
      return 0;
    }
    AppMethodBeat.o(284596);
    return -1;
  }
  
  public final int bAQ()
  {
    return this.zzV.Amb.SPE;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(284593);
    long l = this.zzV.getId();
    AppMethodBeat.o(284593);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(284597);
    String str = "ItemId=" + this.zzV.getId() + ",ItemType=" + bAQ() + ' ';
    AppMethodBeat.o(284597);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */
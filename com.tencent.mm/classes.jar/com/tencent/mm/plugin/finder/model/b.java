package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.apx;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class b
  implements am
{
  private final u ssM;
  
  public b(u paramu)
  {
    AppMethodBeat.i(203416);
    this.ssM = paramu;
    AppMethodBeat.o(203416);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(203414);
    p.h(parami, "obj");
    if (((parami instanceof b)) && (((b)parami).ssM.a(this.ssM)))
    {
      AppMethodBeat.o(203414);
      return 0;
    }
    AppMethodBeat.o(203414);
    return -1;
  }
  
  public final int bZz()
  {
    return this.ssM.sJS.GGY;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(203413);
    long l = this.ssM.getId();
    AppMethodBeat.o(203413);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203415);
    String str = "ItemId=" + this.ssM.getId() + ",ItemType=" + bZz() + ' ';
    AppMethodBeat.o(203415);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */
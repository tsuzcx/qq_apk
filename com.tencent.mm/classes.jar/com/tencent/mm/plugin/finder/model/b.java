package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.apk;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class b
  implements al
{
  private final u sjP;
  
  public b(u paramu)
  {
    AppMethodBeat.i(202936);
    this.sjP = paramu;
    AppMethodBeat.o(202936);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202934);
    p.h(parami, "obj");
    if (((parami instanceof b)) && (((b)parami).sjP.a(this.sjP)))
    {
      AppMethodBeat.o(202934);
      return 0;
    }
    AppMethodBeat.o(202934);
    return -1;
  }
  
  public final int bYk()
  {
    return this.sjP.szb.GnS;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202933);
    long l = this.sjP.getId();
    AppMethodBeat.o(202933);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202935);
    String str = "ItemId=" + this.sjP.getId() + ",ItemType=" + bYk() + ' ';
    AppMethodBeat.o(202935);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */
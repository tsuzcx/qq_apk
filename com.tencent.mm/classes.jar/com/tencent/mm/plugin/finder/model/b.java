package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.protocal.protobuf.bpn;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements cc
{
  private final z ECc;
  
  public b(z paramz)
  {
    AppMethodBeat.i(332167);
    this.ECc = paramz;
    AppMethodBeat.o(332167);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332185);
    s.u(paramk, "obj");
    if (((paramk instanceof b)) && (((b)paramk).ECc.a(this.ECc)))
    {
      AppMethodBeat.o(332185);
      return 0;
    }
    AppMethodBeat.o(332185);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332175);
    long l = this.ECc.getId();
    AppMethodBeat.o(332175);
    return l;
  }
  
  public final int bZB()
  {
    return this.ECc.FLT.ZXW;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332190);
    String str = "ItemId=" + this.ECc.getId() + ",ItemType=" + bZB() + ' ';
    AppMethodBeat.o(332190);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */
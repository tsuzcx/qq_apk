package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  implements cc
{
  public final bno EDe;
  
  public ar(bno parambno)
  {
    AppMethodBeat.i(332062);
    this.EDe = parambno;
    AppMethodBeat.o(332062);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332104);
    s.u(paramk, "obj");
    if ((paramk instanceof ar)) {
      paramk = (ar)paramk;
    }
    while (paramk != null) {
      if (Util.isEqual(paramk.EDe.ZWi, this.EDe.ZWi))
      {
        AppMethodBeat.o(332104);
        return 0;
        paramk = null;
      }
      else
      {
        AppMethodBeat.o(332104);
        return -1;
      }
    }
    AppMethodBeat.o(332104);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332072);
    long l = hashCode();
    AppMethodBeat.o(332072);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332088);
    int i = ar.class.hashCode();
    AppMethodBeat.o(332088);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ar
 * JD-Core Version:    0.7.0.1
 */
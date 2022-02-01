package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class al
  implements bo
{
  public final axk uOy;
  
  public al(axk paramaxk)
  {
    AppMethodBeat.i(248775);
    this.uOy = paramaxk;
    AppMethodBeat.o(248775);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248774);
    p.h(parami, "obj");
    if (!(parami instanceof al)) {
      parami = null;
    }
    for (;;)
    {
      parami = (al)parami;
      if (parami != null)
      {
        if (Util.isEqual(parami.uOy.LHS, this.uOy.LHS))
        {
          AppMethodBeat.o(248774);
          return 0;
        }
        AppMethodBeat.o(248774);
        return -1;
      }
      AppMethodBeat.o(248774);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248773);
    int i = al.class.hashCode();
    AppMethodBeat.o(248773);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248772);
    long l = hashCode();
    AppMethodBeat.o(248772);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.al
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class an
  implements bu
{
  public final bda zAP;
  
  public an(bda parambda)
  {
    AppMethodBeat.i(282886);
    this.zAP = parambda;
    AppMethodBeat.o(282886);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(282885);
    p.k(paramk, "obj");
    if (!(paramk instanceof an)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (an)paramk;
      if (paramk != null)
      {
        if (Util.isEqual(paramk.zAP.SOi, this.zAP.SOi))
        {
          AppMethodBeat.o(282885);
          return 0;
        }
        AppMethodBeat.o(282885);
        return -1;
      }
      AppMethodBeat.o(282885);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(282884);
    int i = an.class.hashCode();
    AppMethodBeat.o(282884);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(282883);
    long l = hashCode();
    AppMethodBeat.o(282883);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.an
 * JD-Core Version:    0.7.0.1
 */
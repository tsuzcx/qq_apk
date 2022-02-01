package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.model.x;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderLiveInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "saveFeedLiveList", "", "plugin-finder_release"})
public final class b
  implements f
{
  private SparseArray<x> pGf;
  
  public b()
  {
    AppMethodBeat.i(287425);
    this.pGf = new SparseArray();
    AppMethodBeat.o(287425);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(287422);
    p.k(paramf, "resp");
    AppMethodBeat.o(287422);
    return false;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(287423);
    p.k(paramd, "loadedInfo");
    AppMethodBeat.o(287423);
    return false;
  }
  
  public final boolean b(d paramd, int paramInt)
  {
    AppMethodBeat.i(287424);
    p.k(paramd, "loadedInfo");
    x localx = (x)this.pGf.get(paramInt);
    if (localx != null) {
      paramd.xFF.add(0, localx);
    }
    AppMethodBeat.o(287424);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.model.y;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderLiveInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "saveFeedLiveList", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements g
{
  private SparseArray<y> sLp;
  
  public d()
  {
    AppMethodBeat.i(336711);
    this.sLp = new SparseArray();
    AppMethodBeat.o(336711);
  }
  
  public final boolean a(aq.d paramd, int paramInt)
  {
    AppMethodBeat.i(336725);
    s.u(paramd, "resp");
    AppMethodBeat.o(336725);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.d paramd)
  {
    AppMethodBeat.i(336740);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336740);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(336749);
    s.u(paramd, "loadedInfo");
    y localy = (y)this.sLp.get(paramInt);
    if (localy != null) {
      paramd.Bex.add(0, localy);
    }
    AppMethodBeat.o(336749);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.d
 * JD-Core Version:    0.7.0.1
 */
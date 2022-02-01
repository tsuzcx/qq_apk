package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.model.x;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderLiveInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "saveFeedLiveList", "", "plugin-finder_release"})
public final class b
  implements f
{
  private SparseArray<x> mHa;
  
  public b()
  {
    AppMethodBeat.i(242617);
    this.mHa = new SparseArray();
    AppMethodBeat.o(242617);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(242614);
    p.h(paramf, "resp");
    AppMethodBeat.o(242614);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(242615);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(242615);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
  {
    AppMethodBeat.i(242616);
    p.h(paramb, "loadedInfo");
    x localx = (x)this.mHa.get(paramInt);
    if (localx != null) {
      paramb.tUz.add(0, localx);
    }
    AppMethodBeat.o(242616);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.b
 * JD-Core Version:    0.7.0.1
 */
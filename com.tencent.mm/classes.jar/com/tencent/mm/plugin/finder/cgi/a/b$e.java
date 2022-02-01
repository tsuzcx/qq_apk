package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.d.a;
import com.tencent.mm.plugin.finder.feed.model.internal.d.c;
import com.tencent.mm.plugin.finder.view.i;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "request", "", "plugin-finder_release"})
public final class b$e
  implements d.a
{
  b$e(int paramInt, g.c paramc, com.tencent.mm.bx.b paramb) {}
  
  public final void eDp()
  {
    AppMethodBeat.i(197358);
    this.KKp.a((g.a)new a(this), this.KKg, this.KKe, this.KKq);
    AppMethodBeat.o(197358);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1$request$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final void a(c paramc, int paramInt)
    {
      AppMethodBeat.i(197357);
      k.h(paramc, "info");
      d.c localc = new d.c(new LinkedList((Collection)paramc.incrementList));
      localc.KQU = paramc;
      this.KKr.KKp.KKn.a(localc);
      paramc = new ys();
      paramc.bhU.IoU = this.KKr.KKp.IoU;
      paramc.bhU.bpQ = this.KKr.KKp.KKn.length;
      i.a(paramc);
      AppMethodBeat.o(197357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.b.e
 * JD-Core Version:    0.7.0.1
 */
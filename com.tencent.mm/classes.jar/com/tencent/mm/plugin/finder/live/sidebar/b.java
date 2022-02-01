package com.tencent.mm.plugin.finder.live.sidebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements cc
{
  boolean Bvd;
  final f data;
  
  public b(f paramf)
  {
    AppMethodBeat.i(351978);
    this.data = paramf;
    AppMethodBeat.o(351978);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(352000);
    s.u(paramk, "obj");
    if ((paramk instanceof b))
    {
      int i = this.data.a((k)((b)paramk).data);
      AppMethodBeat.o(352000);
      return i;
    }
    AppMethodBeat.o(352000);
    return -1;
  }
  
  public final long bZA()
  {
    return this.data.Ebr.liveId;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(351991);
    int i = b.class.hashCode();
    AppMethodBeat.o(351991);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.sidebar.b
 * JD-Core Version:    0.7.0.1
 */
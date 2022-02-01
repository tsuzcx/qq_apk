package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.h.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class l$a
  extends c.a
{
  public l$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201633);
    AppMethodBeat.o(201633);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201630);
    this.rgh.requestLoadMore();
    AppMethodBeat.o(201630);
  }
  
  public final void cuB() {}
  
  public final void cur()
  {
    AppMethodBeat.i(201628);
    c.b localb = this.rgf;
    if (localb != null)
    {
      localb.U((ArrayList)this.rgh.getDataListJustForAdapter());
      AppMethodBeat.o(201628);
      return;
    }
    AppMethodBeat.o(201628);
  }
  
  public final c cut()
  {
    AppMethodBeat.i(201631);
    Object localObject = this.rgf;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).cuF();; localObject = null)
    {
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((r)localObject).cuS();
      AppMethodBeat.o(201631);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201632);
    super.onDetach();
    h.a locala = h.rmQ;
    ac.i(h.access$getTAG$cp(), "clearCache");
    h.cvC().clear();
    AppMethodBeat.o(201632);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201629);
    this.rgh.requestRefresh();
    AppMethodBeat.o(201629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.feed.model.j.a.a;
import com.tencent.mm.plugin.finder.feed.model.j.c;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
public final class o$a
  extends c.a
{
  public static final o.a.a rhZ;
  
  static
  {
    AppMethodBeat.i(201684);
    rhZ = new o.a.a((byte)0);
    AppMethodBeat.o(201684);
  }
  
  public o$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201683);
    AppMethodBeat.o(201683);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(201679);
    k.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201679);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201677);
    this.rgh.requestLoadMore();
    AppMethodBeat.o(201677);
  }
  
  public final void cuB()
  {
    AppMethodBeat.i(201678);
    long l = this.iMV.getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    Object localObject = this.rgh;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
      AppMethodBeat.o(201678);
      throw ((Throwable)localObject);
    }
    localObject = (j)localObject;
    j.a locala = j.rmZ;
    ((j)localObject).lastBuffer = j.a.un(l).lastBuffer;
    a.initData$default(this.rgh, (g)new j.c(l, (f)new o.a.b()), false, 2, null);
    AppMethodBeat.o(201678);
  }
  
  public final void cur()
  {
    AppMethodBeat.i(201676);
    c.b localb = this.rgf;
    if (localb != null)
    {
      localb.U((ArrayList)this.rgh.getDataListJustForAdapter());
      AppMethodBeat.o(201676);
      return;
    }
    AppMethodBeat.o(201676);
  }
  
  public final c cut()
  {
    AppMethodBeat.i(201681);
    Object localObject = this.rgf;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).cuF();; localObject = null)
    {
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((r)localObject).cuS();
      AppMethodBeat.o(201681);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201682);
    super.onDetach();
    j.a locala = j.rmZ;
    ac.i(j.access$getTAG$cp(), "clearCache");
    j.cvD().clear();
    AppMethodBeat.o(201682);
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o.a
 * JD-Core Version:    0.7.0.1
 */
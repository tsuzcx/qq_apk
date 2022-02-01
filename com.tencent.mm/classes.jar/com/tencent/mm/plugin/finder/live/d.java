package com.tencent.mm.plugin.finder.live;

import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveDataLoader;", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveDataLoader;", "()V", "dataLoader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "livePreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "loadType", "", "loading", "", "getLoading", "()Z", "setLoading", "(Z)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "checkLoadingType", "type", "getLoader", "loadData", "loadParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "loadMoreLiveFeed", "onAttach", "", "onDetach", "preloadLiveFeed", "preloading", "setLoader", "loader", "Companion", "plugin-finder_release"})
public final class d
  implements m
{
  private static final int xUR;
  public static final b xUS;
  volatile boolean aGh;
  private c.a xUN;
  private final com.tencent.mm.plugin.finder.feed.model.internal.p<f> xUO;
  private int xUP;
  private FinderLiveRelatedLoader xUQ;
  
  static
  {
    AppMethodBeat.i(282747);
    xUS = new b((byte)0);
    a locala = a.Zlt;
    xUR = ((Number)a.imx().aSr()).intValue();
    AppMethodBeat.o(282747);
  }
  
  public d()
  {
    AppMethodBeat.i(282746);
    this.xUO = new com.tencent.mm.plugin.finder.feed.model.internal.p((byte)0);
    this.xUP = 3;
    FinderLiveRelatedLoader localFinderLiveRelatedLoader = new FinderLiveRelatedLoader();
    localFinderLiveRelatedLoader.fetchEndCallback = ((kotlin.g.a.b)new a(localFinderLiveRelatedLoader, this));
    this.xUQ = localFinderLiveRelatedLoader;
    AppMethodBeat.o(282746);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(282740);
    kotlin.g.b.p.k(parama, "presenter");
    this.xUN = parama;
    this.xUQ.setPreload((com.tencent.mm.plugin.finder.feed.model.internal.l)this.xUO);
    AppMethodBeat.o(282740);
  }
  
  public final boolean a(int paramInt, j paramj)
  {
    AppMethodBeat.i(282744);
    kotlin.g.b.p.k(paramj, "loadParams");
    StringBuilder localStringBuilder = new StringBuilder("loadData presenter:");
    c.a locala = this.xUN;
    if (locala != null)
    {
      i = locala.hashCode();
      Log.i("FinderLiveDataLoader", i + ", curLoadType:" + this.xUP + ", type:" + paramInt + ", loading:" + this.aGh);
      if (!this.aGh) {
        break label129;
      }
      if ((this.xUP == 3) && (paramInt == 2)) {
        this.xUP = 2;
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label134;
      }
      AppMethodBeat.o(282744);
      return false;
      i = 0;
      break;
    }
    label134:
    this.aGh = true;
    switch (paramInt)
    {
    default: 
      this.xUP = 2;
      this.xUQ.a(paramj);
      this.xUQ.requestLoadMore();
      AppMethodBeat.o(282744);
      return true;
    }
    this.xUP = 3;
    this.xUQ.a(paramj);
    this.xUQ.requestPreload();
    AppMethodBeat.o(282744);
    return true;
  }
  
  public final FinderLiveRelatedLoader dwi()
  {
    return this.xUQ;
  }
  
  public final boolean dwj()
  {
    return this.xUO.isLoading;
  }
  
  public final boolean dwk()
  {
    return this.aGh;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282742);
    com.tencent.mm.plugin.finder.feed.model.internal.p localp = this.xUO;
    if (localp != null) {
      localp.clearCache();
    }
    this.aGh = false;
    this.xUN = null;
    AppMethodBeat.o(282742);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "invoke", "com/tencent/mm/plugin/finder/live/FinderLiveDataLoader$dataLoader$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.b<IResponse<f>, x>
  {
    a(FinderLiveRelatedLoader paramFinderLiveRelatedLoader, d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveDataLoader$Companion;", "", "()V", "LOADMORE_THRESHOLD", "", "TAG", "", "needPreload", "", "curPos", "listSize", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live;

import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveDataLoader;", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveDataLoader;", "()V", "curState", "", "getCurState", "()I", "setCurState", "(I)V", "dataLoader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "livePreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "loading", "", "getLoading", "()Z", "setLoading", "(Z)V", "logicPullType", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "checkLoadingType", "type", "genNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "getLoader", "loadData", "onAttach", "", "onDetach", "onSideBarStateChanged", "show", "preloading", "setLoader", "loader", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  static long Bhv;
  public static final a BvP;
  private static final int BvU;
  private static long BvV;
  c.a BvQ;
  final q<f> BvR;
  int BvS;
  FinderLiveRelatedLoader BvT;
  volatile boolean loading;
  int owq;
  
  static
  {
    AppMethodBeat.i(350757);
    BvP = new a((byte)0);
    a locala = a.ahiX;
    BvU = ((Number)a.jSZ().bmg()).intValue();
    Bhv = -1L;
    BvV = -1L;
    AppMethodBeat.o(350757);
  }
  
  public d()
  {
    AppMethodBeat.i(350720);
    this.BvR = new q((byte)0);
    this.BvS = 2;
    final FinderLiveRelatedLoader localFinderLiveRelatedLoader = new FinderLiveRelatedLoader();
    localFinderLiveRelatedLoader.fetchEndCallback = ((kotlin.g.a.b)new b(this, localFinderLiveRelatedLoader));
    ah localah = ah.aiuX;
    this.BvT = localFinderLiveRelatedLoader;
    AppMethodBeat.o(350720);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveDataLoader$Companion;", "", "()V", "LOADMORE_THRESHOLD", "", "NormalState", "SideBarState", "TAG", "", "isIgnorePreloadForFeedId", "", "()J", "setIgnorePreloadForFeedId", "(J)V", "isIgnorePreloadShopForFeedId", "setIgnorePreloadShopForFeedId", "needPreload", "", "curPos", "listSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean hy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350815);
      Log.i("FinderLiveDataLoader", "needPreload curPos:" + paramInt1 + ", listSize:" + paramInt2 + ", threshold:" + d.egI() + '!');
      if (paramInt2 - paramInt1 <= d.egI())
      {
        AppMethodBeat.o(350815);
        return true;
      }
      AppMethodBeat.o(350815);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<f>, ah>
  {
    b(d paramd, FinderLiveRelatedLoader paramFinderLiveRelatedLoader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.d
 * JD-Core Version:    0.7.0.1
 */
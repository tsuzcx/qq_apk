package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.b;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  extends a.a
{
  public c$a(MMActivity paramMMActivity, FinderLikeMegaVideoLoader paramFinderLikeMegaVideoLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderLikeMegaVideoLoader);
    AppMethodBeat.i(341997);
    AppMethodBeat.o(341997);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(342008);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(342008);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(342028);
    g localg = (g)new a();
    AppMethodBeat.o(342028);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(342017);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(342017);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(342037);
    a.b localb = this.EAa;
    if (localb != null) {
      localb.ae((ArrayList)this.EzZ.getDataListJustForAdapter());
    }
    AppMethodBeat.o(342037);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(342003);
    this.EzZ.requestRefresh();
    AppMethodBeat.o(342003);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(341958);
      f localf = (f)new b();
      AppMethodBeat.o(341958);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.b;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
  extends a.a
{
  public b$a(MMActivity paramMMActivity, FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderFavMegaVideoLoader);
    AppMethodBeat.i(341883);
    AppMethodBeat.o(341883);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(341896);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(341896);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(341909);
    g localg = (g)new a();
    AppMethodBeat.o(341909);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(341902);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(341902);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(341920);
    a.b localb = this.EAa;
    if (localb != null) {
      localb.ae((ArrayList)this.EzZ.getDataListJustForAdapter());
    }
    AppMethodBeat.o(341920);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(341889);
    this.EzZ.requestRefresh();
    AppMethodBeat.o(341889);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(341817);
      f localf = (f)new b();
      AppMethodBeat.o(341817);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.b;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class b$a
  extends a.a
{
  public b$a(MMActivity paramMMActivity, FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderFavMegaVideoLoader);
    AppMethodBeat.i(291184);
    AppMethodBeat.o(291184);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(291179);
    this.zxg.requestLoadMore();
    AppMethodBeat.o(291179);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(291181);
    BaseFeedLoader.requestInit$default(this.zxg, false, 1, null);
    AppMethodBeat.o(291181);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(291183);
    a.b localb = this.zxf;
    if (localb != null)
    {
      localb.ab((ArrayList)this.zxg.getDataListJustForAdapter());
      AppMethodBeat.o(291183);
      return;
    }
    AppMethodBeat.o(291183);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(291182);
    f localf = (f)new a();
    AppMethodBeat.o(291182);
    return localf;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(291178);
    this.zxg.requestRefresh();
    AppMethodBeat.o(291178);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(282856);
      e locale = (e)new b();
      AppMethodBeat.o(282856);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.b.a
 * JD-Core Version:    0.7.0.1
 */
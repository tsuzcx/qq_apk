package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.b;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class c$a
  extends a.a
{
  public c$a(MMActivity paramMMActivity, FinderLikeMegaVideoLoader paramFinderLikeMegaVideoLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderLikeMegaVideoLoader);
    AppMethodBeat.i(278019);
    AppMethodBeat.o(278019);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(278015);
    this.zxg.requestLoadMore();
    AppMethodBeat.o(278015);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(278016);
    BaseFeedLoader.requestInit$default(this.zxg, false, 1, null);
    AppMethodBeat.o(278016);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(278018);
    a.b localb = this.zxf;
    if (localb != null)
    {
      localb.ab((ArrayList)this.zxg.getDataListJustForAdapter());
      AppMethodBeat.o(278018);
      return;
    }
    AppMethodBeat.o(278018);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(278017);
    f localf = (f)new a();
    AppMethodBeat.o(278017);
    return localf;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(278014);
    this.zxg.requestRefresh();
    AppMethodBeat.o(278014);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(286072);
      e locale = (e)new b();
      AppMethodBeat.o(286072);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
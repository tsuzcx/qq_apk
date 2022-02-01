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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class c$a
  extends a.a
{
  public c$a(MMActivity paramMMActivity, FinderLikeMegaVideoLoader paramFinderLikeMegaVideoLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderLikeMegaVideoLoader);
    AppMethodBeat.i(248502);
    AppMethodBeat.o(248502);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(248498);
    this.uLF.requestLoadMore();
    AppMethodBeat.o(248498);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(248501);
    a.b localb = this.uLE;
    if (localb != null)
    {
      localb.ab((ArrayList)this.uLF.getDataListJustForAdapter());
      AppMethodBeat.o(248501);
      return;
    }
    AppMethodBeat.o(248501);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(248500);
    f localf = (f)new a();
    AppMethodBeat.o(248500);
    return localf;
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(248499);
    BaseFeedLoader.requestInit$default(this.uLF, false, 1, null);
    AppMethodBeat.o(248499);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248497);
    this.uLF.requestRefresh();
    AppMethodBeat.o(248497);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(248496);
      e locale = (e)new b();
      AppMethodBeat.o(248496);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
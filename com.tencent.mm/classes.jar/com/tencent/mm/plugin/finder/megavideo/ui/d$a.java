package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.d;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "isSelf", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
  extends a.a
{
  public static final a EAE;
  private final FinderMegaVideoProfileUIContract.Presenter.feedProgressListener.1 EAF;
  
  static
  {
    AppMethodBeat.i(341905);
    EAE = new a((byte)0);
    AppMethodBeat.o(341905);
  }
  
  public d$a(MMActivity paramMMActivity, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderMegaVideoProfileLoader);
    AppMethodBeat.i(341898);
    this.EAF = new FinderMegaVideoProfileUIContract.Presenter.feedProgressListener.1(paramFinderMegaVideoProfileLoader, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(341898);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(341944);
    s.u(paramb, "callback");
    super.a(paramb);
    this.EAF.alive();
    AppMethodBeat.o(341944);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(341924);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(341924);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(341932);
    g localg = (g)new b(this);
    AppMethodBeat.o(341932);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(341926);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.EzZ, false, 1, null);
    AppMethodBeat.o(341926);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(341938);
    a.b localb = this.EAa;
    if (localb != null) {
      localb.ae((ArrayList)this.EzZ.getDataListJustForAdapter());
    }
    AppMethodBeat.o(341938);
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(341912);
    boolean bool = s.p(((FinderMegaVideoProfileLoader)this.EzZ).ACm, z.bAW());
    AppMethodBeat.o(341912);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(341948);
    super.onDetach();
    this.EAF.dead();
    AppMethodBeat.o(341948);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(341921);
    this.EzZ.requestRefresh();
    AppMethodBeat.o(341921);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    b(d.a parama) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(342022);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new d(this.EAG);
      AppMethodBeat.o(342022);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.d.a
 * JD-Core Version:    0.7.0.1
 */